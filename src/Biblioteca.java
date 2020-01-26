
import java.util.Scanner;
import java.util.ArrayList;
import Utils.Menu;

/**
 * Aplicación BIBLIOTECA
 * @author Javier Taboada
 * @author xavitag.es
 * @version 1.0
 * @since 1.0
*/
public class Biblioteca {
    private static final String BIBLIOPASS="bibliotecario";
    public static Scanner scn=new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pass;
        
        System.out.println("Introduce Contrasinal do Bibliotecario ou Enter para menú de Socio: ");
        pass=scn.nextLine();
        if (pass.equals(BIBLIOPASS)) bibliotecarioApp(); // Bibliotecario
        else                         socioApp();         // Socio
    }

    private static void bibliotecarioApp() {
        int opc;
        Menu m=new Menu(new String[]{"Xestión de Socios","Xestión de Préstamos","Xestión de Libros","Saír"});
        Menu m_libro=new Menu(new String[]{"Consulta por Título","Consulta por Autor",
                                     "Información do Libro","Engadir Libro","Voltar"});
        do {
            opc=m.getOpcion();
            switch(opc) {
                case 1: MenuSocio.menu();
                        break;
                case 2: MenuPrestamo.menu();
                        break;
                case 3: MenuLibro.menu(m_libro);
                        break;
                
            }
        } while(opc!=4);
    }
    
    private static void socioApp() {
        Menu m=new Menu(new String[]{"Busca por Título","Busca por Autor","Busca por ISBN"});
        MenuLibro.menu(m);
    }
    
    static void showArray(ArrayList al) {
        for(Object obj: al) System.out.println(al);
    }
}
