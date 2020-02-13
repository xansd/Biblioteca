import Utils.Menu;
import Utils.Utilidades;
import biblioteca.Socio;
import biblioteca.GestorDatos;

/**
 * Menu de Socio
 * Xestiona as opcións de xestión dos socios
 * @author Javier Taboada
 * @author xavitag.es
 * @version 1.0
 * @since 1.0
*/
public class MenuSocio extends Menu {
    /**
     * Constructor
     */
    MenuSocio() {
        super(new String[]{"Consulta por DNI","Engadir Socio","Voltar"});
    }
    
    /**
     * Accións do menú
     * @param opc - Acción desexada
     */
    public boolean menu(int opc) {
        Socio socio;
        String search;
        GestorDatos gd=Biblioteca.gd;
        
        switch(opc) {
            // Consulta de Socio por DNI
            case 1:
                search=Utilidades.getString("DNI: ");
                socio=gd.consultaSocio(search);
                if (socio==null) System.out.println("Socio non atopado");
                else {
                    System.out.println(socio);
                    System.out.println(socio.getDireccion());
                    System.out.println("TELEFONO: "+socio.getTelefono());
                    System.out.println("E-MAIL: "+socio.getEmail());
                    System.out.print("Estado do Socio: ");
                    if (socio.isActive()) System.out.println("ACTIVO");
                    else                  System.out.println("INACTIVO");
                    search=Utilidades.getString("Desexas cambiar o estado do socio (si/non):?");
                    if (search.equals("si")) {
                        socio.setActive(!socio.isActive());
                        try {
                           gd.guardaSocio(socio);
                        } catch (Exception ex) {
                           System.out.println("Erro desactivando socio");
                        }
                    }
                }
                break;
            // Alta de Socio
            case 2: 
                search=Utilidades.getString("DNI: ");
                socio=gd.consultaSocio(search);
                if (socio!=null) System.out.println("O socio "+socio+" xa existe");
                else {
                    String nombre=Utilidades.getString("Nome: ");
                    String direccion=Utilidades.getString("Direccion: ");
                    String telefono=Utilidades.getString("Teléfono: ");
                    String email=Utilidades.getString("E-mail: ");
                    socio=new Socio(search,nombre,direccion,telefono,email);
                    try {
                        gd.guardaSocio(socio);
                    } catch(Exception e) {
                        System.out.println("ERROR: "+e.getMessage());
                    }
                }
                break;
            case 3:
                return true;
        }
        return false;
    }
}
