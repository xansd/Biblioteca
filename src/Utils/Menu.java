package Utils;


import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ASIR\xavi
 */
public abstract class Menu {
    public ArrayList<String> opciones=new ArrayList <>();
    
    public Menu(String[] ops) {
        opciones.addAll(Arrays.asList(ops));
    }
    
    public int getOpcion() {
        int nops;
        int opc;
        
        do {
            try {
                nops=showMenu();
                return Utilidades.getInt("Elixe Opcion: ",1,nops);
            } catch (Exception ex) {}
            System.out.println("\nOpción errónea \n");
        } while(true);
    }
    
    public abstract void menu();   
    
    private int showMenu() {
        int n=1;
        System.out.println("\nM E N U");
        System.out.println("-------");
        for(String s: opciones) {
            System.out.println(n+".- "+s);
            n++;
        }
        System.out.println();
        return n-1;
    }
}
