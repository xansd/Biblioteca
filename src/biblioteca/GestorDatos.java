package biblioteca;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ASIR\xavi
 */
public class GestorDatos implements GestorDatosInterface {
    private final HashMap<String,Socio> listaSocios=new HashMap<>();
    private final HashMap<String,Libro> listaLibros=new HashMap <>();
    private final ArrayList <Prestamo> listaPrestamos=new ArrayList <>();
    
    @Override
    public ArrayList<Libro> consultaLibroPorTitulo(String titulo) {
        ArrayList <Libro> result=new ArrayList <>();
        String pattern;
        titulo=titulo.replace(',', '|');
        pattern=".*"+titulo+".*";
        Pattern rx=Pattern.compile(pattern);
        
        for(Libro l: listaLibros.values()) {
           Matcher m = rx.matcher(l.getTitulo());
            if (m.matches()) result.add(l);
        }
        return result;
    }

    @Override
    public ArrayList<Libro> consultaLibroPorAutor(String autor) {
        ArrayList <Libro> result=new ArrayList <>();
        String pattern;
        
        autor=autor.replace(',','|');
        pattern=".*"+autor+".*";
        Pattern rx=Pattern.compile(pattern);
        
        for(Libro l: listaLibros.values()) {
           Matcher m = rx.matcher(l.getAutor());
            if (m.matches()) result.add(l);
        }
        return result;
    }

    @Override
    public Libro consultaLibro(String iban) {
        return listaLibros.get(iban);
    }

    @Override
    public Libro guardaLibro(Libro l) {
        Libro libro;
        
        libro=consultaLibro(l.getIsbn());
        if (libro==null)    listaLibros.put(l.getIsbn(),l);
        else                libro.addExistencias(l.getExistencias());
        return l;
    }

    @Override
    public Socio guardaSocio(Socio s) {
        listaSocios.put(s.getDni(), s);
        return s;
    }

    @Override
    public Socio consultaSocio(String dni) {
        return listaSocios.get(dni);
    }

    @Override
    public Prestamo guardaPrestamo(Prestamo p) throws LibroException {
        Libro l=p.getLibro();
        l.incPrestamo();
        listaPrestamos.add(p);
        return p;
    }

    @Override
    public Prestamo consultaPrestamo(String dni, String iban) {
        Libro l;
        Socio s;
        
        for(Prestamo p: listaPrestamos) {
            if (p.isStatus()) {
                l=p.getLibro();
                s=p.getSocio();
                if ((l.getIsbn().equals(iban)) && (s.getDni().equals(dni))) return p;
            }
        }
        return null;
    }

    @Override
    public void devolucion(Prestamo p) {
        p.setStatus(false);
    }

    @Override
    public ArrayList<Prestamo> listaPendientes() {
        ArrayList <Prestamo> lista=new ArrayList <>();
        java.util.Date today=Calendar.getInstance().getTime();
       
        
        for(Prestamo p: listaPrestamos) {
            if (p.isStatus()) {
                if (p.getFdevolucion().before(today)) lista.add(p);
            }
        }
        return lista;
    }
}
