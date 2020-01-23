package biblioteca;

import java.util.Scanner;
import Utils.Menu;
import java.util.ArrayList;

/**
 *
 * @author ASIR\xavi
 */
public class Biblioteca {
    private static final String BIBLIOPASS="bibliotecario";
    private static Scanner scn=new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pass;
        
        System.out.println("Introduce Contrasinal do Bibliotecario ou Enter para menú de Socio: ");
        pass=scn.nextLine();
        if (pass.equals(BIBLIOPASS)) biblioApp();
        else                         socioApp();
    }

    private static void biblioApp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void socioApp() {
        Menu m=new Menu(new String[]{"Consulta por Título","Consulta por Autor","Información do Libro"});
        int opc;
        String search=null;
        ArrayList <Libro> result;
        Libro libro=null;
        GestorDatosInterface gd=new GestorDatos();
        
        do {
            opc=m.getOpcion();
            switch(opc) {
                case 1: 
                    System.out.println("BUSCA POR TITULO: Introduce palabras a buscar separadas por comas: ");
                    search=scn.nextLine();
                    result=gd.consultaLibroPorTitulo(search);
                    if (result.isEmpty())   System.out.println("Sin resultados");
                    else                    showArray(result);
                    break;
                case 2: 
                    System.out.println("BUSCA POR AUTOR: Introduce palabras a buscar separadas por comas: ");
                    search=scn.nextLine();
                    result=gd.consultaLibroPorTitulo(search);
                    if (result.isEmpty())   System.out.println("Sin resultados");
                    else                    showArray(result);
                    break;
                case 3:
                    System.out.println("ISBN: ");
                    search=scn.nextLine();
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
            }
        } while(true);
    }
    
    private static void showArray(ArrayList al) {
        for(Object obj: al) System.out.println(al);
    }
}
