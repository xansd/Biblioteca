import Utils.Utilidades;
import biblioteca.GestorDatos;
import biblioteca.GestorDatosInterface;

/**
 * Aplicación BIBLIOTECA
 * @author Javier Taboada
 * @author xavitag.es
 * @version 1.0
 * @since 1.0
*/
public class Biblioteca {
    private static final String BIBLIOPASS="bibliotecario"; // Password do bibliotecario

    /**
     *  Xestor para o acceso á "Base de Datos"
     */
    public static GestorDatosInterface gd=new GestorDatos();      

    /**
     * Método Principal.
     * @param args 
     */
    public static void main(String[] args) {
        String pass;
        
        pass=Utilidades.getString("Introduce Contrasinal do Bibliotecario ou Enter para menú de Socio: ");
        if (pass.equals(BIBLIOPASS)) bibliotecarioApp(); // Bibliotecario
        else                         socioApp();         // Socio
    }

    /**
     * Aplicación do Bibliotecario
     */
    private static void bibliotecarioApp() {
        new MenuBibliotecario().run();  // Lanzamos o menú de Bibliotecario
    }
    
    /**
     * Aplicación do Socio
     */
    private static void socioApp() {
        new MenuLibro(MenuLibro.Tipo.SOCIO).run(); // Lanzamos o menú de Socio
    }
}
