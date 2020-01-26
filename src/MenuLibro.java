import Utils.Menu;
import Utils.Utilidades;
import biblioteca.Libro;
import java.util.ArrayList;

/**
 * Menu de Libro
 * Xestiona as opcións de xestión de Libros
 * O menú do Bibliotecario é distinto do menú do Socio
 * @author Javier Taboada
 * @author xavitag.es
 * @version 1.0
 * @since 1.0
*/
public class MenuLibro extends Menu {

    /**
     * Tipos de menú de Xestión de Libros
     */
    public enum Tipo {BIBLIOTECARIO,SOCIO};  
         
    /**
     * Constructor
     * @param t - Tipo de menú de Libro desexado
     */
    MenuLibro(MenuLibro.Tipo t) {
        switch(t) {
            case BIBLIOTECARIO: 
                setMenu(new String[]{"Consulta por Título","Consulta por Autor","Información do Libro","Engadir Libro","Voltar"});
                break;
            case SOCIO:
                setMenu(new String[] {"Busca por Título","Busca por Autor","Busca por ISBN"});
                break;
        }
    }
    
    /**
     * Accións do menú
     * @param opc - Acción desexada
     */
    public void menu(int opc) {
        int nl;
        String search;
        ArrayList <Libro> result;
        Libro libro;
     
        switch(opc) {
            // Consulta de Libro por título
            case 1: 
                search=Utilidades.getString("BUSCA POR TITULO: Introduce palabras a buscar separadas por comas: ");
                result=Biblioteca.gd.consultaLibroPorTitulo(search);
                if (result.isEmpty())   System.out.println("Sin resultados");
                else                    Utilidades.showArray(result);
                break;
            // Consulta de Libro por Autor
            case 2: 
                search=Utilidades.getString("BUSCA POR AUTOR: Introduce palabras a buscar separadas por comas: ");
                result=Biblioteca.gd.consultaLibroPorAutor(search);
                if (result.isEmpty())   System.out.println("Sin resultados");
                else                    Utilidades.showArray(result);
                break;
            // Consulta de Libro por ISBN
            case 3:
                search=Utilidades.getString("ISBN: ");
                libro=Biblioteca.gd.consultaLibro(search);
                if (libro==null) System.out.println("Libro non atopado");
                else {
                    System.out.println(libro);
                    System.out.println("RESUMO: ");
                    System.out.println(libro.getResumen());
                    if (libro.getExistencias()<=libro.getEn_prestamo())
                      System.out.println("\n Non Dispoñible");
                    else
                      System.out.println("\n Dispoñible");
                    }
                    break;
            // Alta de novos libros (So Bibliotecario)
            case 4:
                search=Utilidades.getString("ISBN: ");
                libro=Biblioteca.gd.consultaLibro(search);
                if (libro!=null) {
                    System.out.println("O libro xa existe: "+libro);
                    try {
                        nl=Utilidades.getInt("Cantas unidades desexas engadir? (0-99):",0,99);
                        libro.addExistencias(nl);
                        Biblioteca.gd.guardaLibro(libro);
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    // Pedimos datos do libro
                    String titulo=Utilidades.getString("Titulo: ");
                    String autor=Utilidades.getString("Autor: ");
                    String resumen=Utilidades.getString("Introduce un Resumo breve:");
                    libro=new Libro(search,titulo,autor,resumen);
                    try {
                        Biblioteca.gd.guardaLibro(libro);
                    } catch(Exception e) {
                        System.out.println("ERROR: "+e.getMessage());
                    }
                }
                break;
        }
    }
}
