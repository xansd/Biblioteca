/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Utils.Menu;
import Utils.Utilidades;
import biblioteca.GestorDatos;
import biblioteca.GestorDatosInterface;
import biblioteca.Socio;


public class MenuSocio extends Menu {
    MenuSocio() {
        super(new String[]{"Consulta por DNI","Engadir Socio","Voltar"});
    }
    
    public void menu() {
        int opc;
        Socio socio;
        String search;
        GestorDatosInterface gd=Biblioteca.gd;
        
        do {
            opc=getOpcion();
            switch(opc) {
                case 1:
                    search=Utilidades.getString("DNI: ");
                    socio=gd.consultaSocio(search);
                    if (socio==null) System.out.println("Socio non atopado");
                    else {
                        System.out.println(socio);
                        System.out.println(socio.getDireccion());
                        System.out.println("TELEFONO: "+socio.getTelefono());
                        System.out.println("E-MAIL: "+socio.getEmail());
                    }
                    break;
                case 2: 
                    search=Utilidades.getString("DNI: ");
                    socio=gd.consultaSocio(search);
                    if (socio!=null) System.out.println("O socio "+socio+" xa existe");
                    else {
                        String nombre=Utilidades.getString("Nome: ");
                        String direccion=Utilidades.getString("Direccion: ");
                        String telefono=Utilidades.getString("Teléfono: ");
                        String email=Utilidades.getString("E-mail: ");
                        socio=new Socio(search,nombre,direccion,telefono,email);
                        try {
                            gd.guardaSocio(socio);
                        } catch(Exception e) {
                            System.out.println("ERROR: "+e.getMessage());
                        }
                    }
                    break;
            }
        } while(opc!=3);
    }
}
