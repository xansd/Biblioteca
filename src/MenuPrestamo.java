/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Utils.Menu;
import Utils.Utilidades;
import biblioteca.GestorDatosInterface;
import biblioteca.Prestamo;
import java.util.ArrayList;

/**
 *
 * @author xavi
 */
public class MenuPrestamo extends Menu {
    MenuPrestamo() {
        super(new String[]{"Novo Préstamo","Prestamos por Socio","Prestamos por Libro","Listado Pendentes","Voltar"});
    }
    
    public void menu() {
        int opc;
        String dni;
        String isbn;
        Prestamo p;
        GestorDatosInterface gd=Biblioteca.gd;
        ArrayList <Prestamo> lista;
        
        do {
            opc=getOpcion();
            switch(opc) {
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
                case 2:
                    dni=Utilidades.getString("DNI do Socio: ");
                    lista=gd.prestamosSocio(dni, false);
                    System.out.println("Prestamos en poder de "+gd.consultaSocio(dni)+": ");
                    Utilidades.showArray(lista);
                    break;
                case 3:
                    isbn=Utilidades.getString("ISBN do Libro: ");
                    lista=gd.prestamosLibro(isbn, false);
                    System.out.println("Prestamos de "+gd.consultaLibro(isbn)+": ");
                    Utilidades.showArray(lista);
                    break;
                case 4:
                    lista=gd.listaPendientes();
                    Utilidades.showArray(lista);
                    break;
            }
        } while(opc!=5);
    }
    
}
