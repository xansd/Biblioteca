
import Utils.Menu;

/**
 *
 * @author xavi
 */
public class MenuBibliotecario extends Menu {
    MenuBibliotecario() {
        super(new String[]{"Xestión de Socios","Xestión de Préstamos","Xestión de Libros","Saír"});
    }
    
    @Override
    public void menu() {
        int opc;
        String[] ops={"Consulta por Título","Consulta por Autor","Información do Libro","Engadir Libro","Voltar"};
        do {
            opc=getOpcion();
            switch(opc) {
                case 1: new MenuSocio().menu();
                        break;
                case 2: new MenuPrestamo().menu();
                        break;
                case 3: new MenuLibro(ops).menu();
                        break;
                
            }
        } while(opc!=4);
    }
    
}
