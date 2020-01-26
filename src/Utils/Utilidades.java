/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import java.util.Scanner;


public class Utilidades {
    private static final Scanner scn=new Scanner(System.in);
    
    public static int getInt(int min,int max) throws Exception {
        int num;
        
        num=Integer.parseInt(scn.nextLine());
        if ((num<min)||(num>max)) throw new Exception("Rango excedido");
        return num;
    }
    
    public static int getInt() throws Exception {
        return Integer.parseInt(scn.nextLine());
    }
    
    
    public static double getDouble(double min, double max) throws Exception {
        double num;
        
        num=Double.parseDouble(scn.nextLine());
        if ((num<min)||(num>max)) throw new Exception("Rango excedido");
        return num;       
    }
    
    public static double getDouble() throws Exception {
        return Double.parseDouble(scn.nextLine());
    }
    
    public static String getString() {
        return scn.nextLine();
    }
    
    public static String getString(String txt) {
        System.out.print(txt);
        return getString();
    }

    public static int getInt(String txt, int i, int nops) throws Exception {
        System.out.print(txt);
        return getInt(i,nops);
    }
    
    public static int getInt(String txt) throws Exception {
        System.out.print(txt);
        return getInt();
    }
    
    public static double getDouble(String txt, double i, double nops) throws Exception {
        System.out.print(txt);
        return getDouble(i,nops);
    }
    
    public static double getDouble(String txt) throws Exception {
        System.out.print(txt);
        return getDouble();
    }
    
        
    public static void showArray(ArrayList al) {
        for(Object obj: al) {
            System.out.println("-------------------------------------------");
            System.out.println(obj);
            System.out.println("-------------------------------------------");
        }
    }
}
