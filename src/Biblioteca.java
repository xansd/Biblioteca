
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
    public static GestorDatosInterface gd=new GestorDatos();       // Xestor para a base de datos

    /**
     * Método Principal.
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
        new MenuBibliotecario().menu();
    }
    
    /**
     * Aplicación do Socio
     */
    private static void socioApp() {
        String[] ops={"Busca por Título","Busca por Autor","Busca por ISBN"};
        new MenuLibro(MenuLibro.Tipo.SOCIO).menu();
    }
}
