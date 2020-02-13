import Utils.Menu;
import Utils.Utilidades;
import biblioteca.Prestamo;
import java.util.ArrayList;
import biblioteca.GestorDatos;

/**
 * Menu de Prestamo
 * Xestiona as opcións de xestión de Prestamos
 * @author Javier Taboada
 * @author xavitag.es
 * @version 1.0
 * @since 1.0
*/
public class MenuPrestamo extends Menu {
    MenuPrestamo() {
        super(new String[]{"Novo Préstamo","Prestamos por Socio","Prestamos por Libro","Listado Pendentes","Voltar"});
    }
    
    /**
     * Accións do menú
     * @param opc - Acción desexada
     */
    public boolean menu(int opc) {
        String dni;
        String isbn;
        Prestamo p;
        GestorDatos gd=Biblioteca.gd;
        ArrayList <Prestamo> lista;

        switch(opc) {
            // Novo Préstamo
            case 1:
                try {
                    dni=Utilidades.getString("DNI do Socio: ");
                    isbn=Utilidades.getString("ISBN do Libro: ");
                    p=new Prestamo(gd.consultaSocio(dni),gd.consultaLibro(isbn));
                    gd.guardaPrestamo(p);
                    System.out.println("Prestamo Guardado: "+p);
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            // Listado de préstamos dun socio
            case 2:
                dni=Utilidades.getString("DNI do Socio: ");
                lista=gd.prestamosSocio(dni, false);
                System.out.println("Prestamos en poder de "+gd.consultaSocio(dni)+": ");
                Utilidades.showArray(lista);
                break;
            // Listado de Préstamos dun libro
            case 3:
                isbn=Utilidades.getString("ISBN do Libro: ");
                lista=gd.prestamosLibro(isbn, false);
                System.out.println("Prestamos de "+gd.consultaLibro(isbn)+": ");
                Utilidades.showArray(lista);
                break;
            // Listado de Préstamos pendentes de devolución
            case 4:
                lista=gd.listaPendientes();
                Utilidades.showArray(lista);
                break;
            case 5:
                return true;
        }
        return false;
    }    
}
