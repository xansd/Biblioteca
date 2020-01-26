package Utils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utilidades de entrada de datos e visualización
 * @author Javier Taboada
 * @author xavitag.es
 * @version 1.0
 * @since 1.0
*/
public class Utilidades {
    private static final Scanner scn=new Scanner(System.in);    // Para entrada de datos
    
    /**
     * Lee de teclado un int entre min e max incluídos.
     * @param min - Valor mínimo aceptable
     * @param max - Valor máximo aceptable
     * @return  - O número enteiro lido de teclado
     * @throws Exception - A entrada non é numérica ou excede os límites
     */
    public static int getInt(int min,int max) throws Exception {
        int num;
        
        num=Integer.parseInt(scn.nextLine());
        if ((num<min)||(num>max)) throw new Exception("Rango excedido");
        return num;
    }
    
    /**
     * lee de teclado un int
     * @return O int lido de teclado
     * @throws Exception A entrada non e un int
     */
    public static int getInt() throws Exception {
        return Integer.parseInt(scn.nextLine());
    }
    
    /**
     * Lee un double de teclado entre un valor mínimo e un máximo incluidos
     * @param min - límite inferior
     * @param max - límite superior
     * @return Double lido de teclado
     * @throws Exception - A entrada non é un double ou excede os límites
     */
    public static double getDouble(double min, double max) throws Exception {
        double num;
        
        num=Double.parseDouble(scn.nextLine());
        if ((num<min)||(num>max)) throw new Exception("Rango excedido");
        return num;       
    }
    
    /**
     * Lee un Double de teclado
     * @return Double lido
     * @throws Exception  A entrada non é un Double
     */
    public static double getDouble() throws Exception {
        return Double.parseDouble(scn.nextLine());
    }
    
    /**
     * Lee un String de teclado
     * @return String lido de teclado
     */
    public static String getString() {
        return scn.nextLine();
    }
    
    /**
     * Lee un String de teclado visualizando unha mensaxe
     * @param txt - Mensaxe a visualizar
     * @return  String lido
     */
    public static String getString(String txt) {
        System.out.print(txt);
        return getString();
    }

    /**
     * Lee de teclado un int entre min e max incluídos visualizando unha mensaxe.
     * @param txt - Mensaxe a visualizar
     * @param min - Valor mínimo aceptable
     * @param max - Valor máximo aceptable
     * @return  - O número enteiro lido de teclado
     * @throws Exception - A entrada non é numérica ou excede os límites
     */
    public static int getInt(String txt, int min, int max) throws Exception {
        System.out.print(txt);
        return getInt(min,max);
    }
    
        
    /**
     * lee de teclado un int visualizando unha mensaxe.
     * @param txt - mensaxe a visualizar
     * @return O int lido de teclado
     * @throws Exception A entrada non e un int
     */
    public static int getInt(String txt) throws Exception {
        System.out.print(txt);
        return getInt();
    }
    
    /**
     * Lee un double de teclado entre un valor mínimo e un máximo incluidos visualizando unha mensaxe
     * @param txt - mensaxe a visualizar
     * @param min - límite inferior
     * @param max - límite superior
     * @return Double lido de teclado
     * @throws Exception - A entrada non é un double ou excede os límites
     */
    public static double getDouble(String txt, double min, double max) throws Exception {
        System.out.print(txt);
        return getDouble(min,max);
    }
    
    /**
     * Lee un Double de teclado amosando unha mensaxe.
     * @param txt - mensaxe a visualizar
     * @return Double lido
     * @throws Exception  A entrada non é un Double
     */
    public static double getDouble(String txt) throws Exception {
        System.out.print(txt);
        return getDouble();
    }
    
    /**
     * Amosa en Pantalla os elementos dun ArrayList
     * @param al - ArrayList
     */
    public static void showArray(ArrayList al) {
        for(Object obj: al) {
            System.out.println("-------------------------------------------");
            System.out.println(obj);
            System.out.println("-------------------------------------------");
        }
    }
}
