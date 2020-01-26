

import Utils.Menu;
import biblioteca.GestorDatos;
import biblioteca.GestorDatosInterface;
import biblioteca.Libro;
import java.util.ArrayList;

/**
 *
 * @author xavi
 */
public class MenuLibro {
    public static void menu(Menu m) {
        int opc,nl;
        String search;
        ArrayList <Libro> result;
        Libro libro;
        GestorDatosInterface gd=new GestorDatos();
        
        do {
            opc=m.getOpcion();
            switch(opc) {
                case 1: 
                    System.out.println("BUSCA POR TITULO: Introduce palabras a buscar separadas por comas: ");
                    search=Biblioteca.scn.nextLine();
                    result=gd.consultaLibroPorTitulo(search);
                    if (result.isEmpty())   System.out.println("Sin resultados");
                    else                    Biblioteca.showArray(result);
                    break;
                case 2: 
                    System.out.println("BUSCA POR AUTOR: Introduce palabras a buscar separadas por comas: ");
                    search=Biblioteca.scn.nextLine();
                    result=gd.consultaLibroPorTitulo(search);
                    if (result.isEmpty())   System.out.println("Sin resultados");
                    else                    Biblioteca.showArray(result);
                    break;
                case 3:
                    System.out.println("ISBN: ");
                    search=Biblioteca.scn.nextLine();
                    libro=gd.consultaLibro(search);
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
                case 4:
                    System.out.println("ISBN: ");
                    search=Biblioteca.scn.nextLine();
                    libro=gd.consultaLibro(search);
                    if (libro!=null) {
                        System.out.println("O libro xa existe: "+libro);
                        System.out.println("Cantas unidades desexas engadir? (0- ):");
                        try {
                            nl=Integer.parseInt(Biblioteca.scn.nextLine());
                            libro.addExistencias(nl);
                            gd.guardaLibro(libro);
                        } catch(Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                       System.out.println("Non se atopa o libro");
                    }
            }
        } while(opc!=5);
    }
}
