import Utils.Menu;

/**
 * Menu de Bibliotecario
 * Xestiona as opcións de xestión que pode usar o bibliotecario
 * O menú do Bibliotecario é distinto do menú do Socio
 * @author Javier Taboada
 * @author xavitag.es
 * @version 1.0
 * @since 1.0
*/
public class MenuBibliotecario extends Menu {
    /**
     * Constructor
     */
    MenuBibliotecario() {
        super(new String[]{"Xestión de Socios","Xestión de Préstamos","Xestión de Libros","Saír"});
    }
    
    /**
     * Accións do menú
     * @param opc - Acción desexada
     */
    @Override
    public boolean menu(int opc) {
        switch(opc) {
            // Xestión de Socios
            case 1: new MenuSocio().choose();
                    break;
            // Xestión de Prestamos
            case 2: new MenuPrestamo().choose();
                    break;
            // Xestión de Libros
            case 3: new MenuLibro(MenuLibro.Tipo.BIBLIOTECARIO).choose();
                    break;
            case 4: return true;
        }
        return false;
    }
    
}
