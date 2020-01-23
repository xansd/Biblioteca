package Utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ASIR\xavi
 */
public class Menu {
    public ArrayList<String> opciones=new ArrayList <>();
    Scanner scn=new Scanner(System.in);
    
    public Menu(String[] ops) {
        opciones.addAll(Arrays.asList(ops));
    }
    
    public int getOpcion() {
        int nops;
        int opc;
        
        do {
            try {
                nops=showMenu();
                System.out.println("Elixe Opcion: ");
                opc=Integer.parseInt(scn.nextLine());
                if ((opc>0)&&(opc<=nops)) return opc;
            } catch (NumberFormatException ex) {}
            System.out.println("\nOpción errónea \n");
        } while(true);
    }
    
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
