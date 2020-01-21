/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;

/**
 *
 * @author ASIR\xavi
 */
interface GestorDatosInterface {
    public ArrayList <Libro> consultaLibroPorTitulo(String titulo);
    public ArrayList <Libro> consultaLibroPorAutor(String autor);
    public Libro consultaLibro(String iban);
    public Libro guardaLibro(Libro l);
    public Socio guardaSocio(Socio s);
    public Socio consultaSocio(String dni);
    public Prestamo guardaPrestamo(Prestamo p) throws Exception;
    public Prestamo consultaPrestamo(String dni,String iban);
    public void  devolucion(Prestamo p);
    public ArrayList <Prestamo> listaPendientes();
    
}
