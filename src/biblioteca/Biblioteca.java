/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.Scanner;
import Utils.Menu;
import java.util.ArrayList;

/**
 *
 * @author ASIR\xavi
 */
public class Biblioteca {
    private static final String BIBLIOPASS="bibliotecario";
    private static Scanner scn=new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pass;
        
        System.out.println("Introduce Contrasinal do Bibliotecario ou Enter para menú de Socio: ");
        pass=scn.nextLine();
        if (pass.equals(BIBLIOPASS)) biblioApp();
        else                         socioApp();
    }

    private static void biblioApp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void socioApp() {
        Menu m=new Menu(new String[]{"Consulta por Título","Consulta por Autor"});
        int opc;
        String search;
        ArrayList <Libro> result;
        GestorDatosInterface gd=new GestorDatos();
        
        do {
            opc=m.getOpcion();
            if ((opc==1)||(opc==2)) {
                System.out.println("Introduce palabras a buscar separadas por comas: ");
                search=scn.nextLine();
            }
            switch(opc) {
                case 1: 
            }
        } while(true);
    }
    
}
