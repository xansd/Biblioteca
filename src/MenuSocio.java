/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Utils.Menu;
import biblioteca.GestorDatos;
import biblioteca.GestorDatosInterface;
import biblioteca.Libro;
import java.util.ArrayList;

/**
 *
 * @author xavi
 */
public class MenuSocio {

    public static void menu() {
        Menu m=new Menu(new String[]{"Consulta por DNI","Engadir Socio","Voltar"});
        int opc;
        String search;
        ArrayList <Libro> result;
        Libro libro;
        GestorDatosInterface gd=new GestorDatos();
        
        do {
            opc=m.getOpcion();
            switch(opc) {
                case 1: 
                    System.out.println("BUSCA POR TITULO: Introduce palabras a buscar separadas por comas: ");
                    search=Biblioteca.scn.nextLine();
                    result=gd.consultaLibroPorTitulo(search);
                    if (result.isEmpty())   System.out.println("Sin resultados");
                    else                    Biblioteca.showArray(result);
                    break;
                case 2: 
                    System.out.println("BUSCA POR AUTOR: Introduce palabras a buscar separadas por comas: ");
                    search=Biblioteca.scn.nextLine();
                    result=gd.consultaLibroPorTitulo(search);
                    if (result.isEmpty())   System.out.println("Sin resultados");
                    else                    Biblioteca.showArray(result);
                    break;
                case 3:
                    System.out.println("ISBN: ");
                    search=Biblioteca.scn.nextLine();
                    libro=gd.consultaLibro(search);
                    if (libro==null) System.out.println("Libro non atopado");
                    else {
                        System.out.println(libro);
                        System.out.println("RESUMO: ");
                        System.out.println(libro.getResumen());
                        if (libro.getExistencias()<=libro.getEn_prestamo())
                            System.out.println("\n Non Dispoñible");
                        else
                            System.out.println("\n Dispoñible");
                    }
                    break;
            }
        } while(opc!=4);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
