package biblioteca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Almacenamento da base de datos de biblioteca en Collections. NON PERSISTENTE
 * @author Javier Taboada
 * @author xavitag.es
 * @version 1.0
 * @since 1.0
*/
public class GestorDatos implements GestorDatosInterface {
    private final HashMap<String,Socio> listaSocios=new HashMap<>();
    private final HashMap<String,Libro> listaLibros=new HashMap <>();
    private final ArrayList <Prestamo> listaPrestamos=new ArrayList <>();
    
    /**
     * Devolve un ArrayList cos libros corresopondentes co string titulo.A modificación
     * dos libros no arraylist devolto non debe modificar a información dos libros almacenados
     * @param titulo - String cun conxunto de palabras separadas por comas
     * @return Lista de libros cun titulo que conten algunha das palabras indicadas. 
     */
    @Override
    public ArrayList<Libro> consultaLibroPorTitulo(String titulo) {
        ArrayList <Libro> result=new ArrayList <>();
        String pattern;
        titulo=titulo.replace(',', '|');
        //pattern=".*"+titulo+".*";
        pattern="\\b(?:"+titulo+")\\b";
        Pattern rx=Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        
        for(Libro l: listaLibros.values()) {
           Matcher m = rx.matcher(l.getTitulo());
           // Gardo unha copia do libro para que non podan alterar o contido de listaLibros
            if (m.find()) result.add(new Libro(l)); 
        }
        return result;
    }

    /**
     * Devolve un ArrayList cos libros correspondentes co autor indicado no título.A modificación
     * dos libros no arraylist devolto non debe modificar a información dos libros almacenados
     * @param autor - String cun conxunto de palabras separadas por comas
     * @return  Lista de libros cun autor que conten no nome algunha das palabras indicadas.
     */
    @Override
    public ArrayList<Libro> consultaLibroPorAutor(String autor) {
        ArrayList <Libro> result=new ArrayList <>();
        String pattern;
        
        autor=autor.replace(',','|');
        //pattern=".*"+autor+".*";
        pattern="\\b(?:"+autor+")\\b";
        Pattern rx=Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        
        for(Libro l: listaLibros.values()) {
            System.out.println("Comprobando: "+l.getAutor());
           Matcher m = rx.matcher(l.getAutor());
           // Gardo unha copia do libro para que non podan alterar o contido de listaLibros
            if (m.find()) result.add(new Libro(l)); 
        }
        return result;
    }

    /**
     * Devolve o libro que ten o iban indicado.A modificación da información do libro devolto
     * non debe alterar a información do libro almacenado.
     * @param isbn ISBN a localizar
     * @return Libro co iban indicado ou null si non existe (a información deste libro non debe alterar a información do libro gardado)
     */
    @Override
    public Libro consultaLibro(String isbn) {
        Libro l=listaLibros.get(isbn);
        // Devolvo unha copia de l para que non podan modificar o contido en listaLibros
        if (l!=null) return new Libro(l); // OJO
        return null;
    }
    
    /**
     * Garda un libro na base de datos.
     * @param l - Libro a gardar
     * @return  - NULL, ou Libro gardado (a modificación deste libro non debe alterar a información do libro almacenado)
     * @throws biblioteca.LibroException - Notifica un erro gardando o libro
     */
    @Override
    public Libro guardaLibro(Libro l) throws LibroException {
        // Almaceno unha copia do libro l para que non podan alterar dende fora o contido de listaLibros
        listaLibros.put(l.getIsbn(), new Libro(l)); 
        return l;
    }

    /**
     * Garda un socio na base de datos
     * @param s - Socio a gardar
     * @return - Socio gardado (a modificación do socio devolto non debe alterar a inforamción do libro almacenado)
     * @throws biblioteca.LibroException - Notifica un erro gardando o socio
     */
    @Override
    public Socio guardaSocio(Socio s) throws LibroException {
        // Gardo unha copia para que non podan modificar dende fora a información en listaSocios
        listaSocios.put(s.getDni(), new Socio(s)); 
        return s;
    }
        
    /**
     * Devolve o socio co dni indicado.A modificación deste socio non debe modificar a información
     * almacenada.
     * @param dni - DNI do socio a localizar
     * @return NULL ou o Socio correspondente ao DNI indicado
     */
    @Override
    public Socio consultaSocio(String dni) {
        Socio s=listaSocios.get(dni);
        // Devolvo unha copia para que non podan modificar a información do Socio en listaSocios
        if (s!=null) return new Socio(s); 
        return null;
    }

    /**
     * Garda na base de datos o préstao indicado
     * @param p - Préstamo a almacenar
     * @return - Préstamo almacenado (a modificación deste Préstamo non debe modificar a información almacenada)
     * @throws LibroException - Indica un erro ao intentar almacenar o préstamo.
     */
    @Override
    public Prestamo guardaPrestamo(Prestamo p) throws LibroException {
        Libro l=listaLibros.get(p.getLibro().getIsbn());
        Socio s=listaSocios.get(p.getSocio().getDni());
        
        // Comprobo que o libro existe
        if (l==null) throw new LibroException("O libro "+l+" non existe");
        // Comprobo que o socio existe
        if (s==null) throw new LibroException("O socio "+s+" non existe");
        // Comprobo que non teña ese libro xa en préstamo
        if (consultaPrestamo(s.getDni(),l.getIsbn())!=null) 
            throw new LibroException(s+" Xa ten un exemplar en préstamo");
        if (!s.isActive()) throw new LibroException("O socio non está activo.");
        
        l.incPrestamo();  
        guardaLibro(l); // Actualiza o libro en listaLibros
        listaPrestamos.add(p); // Engade o préstamo
        return p;
    }
   
    /**
     * Devolve o préstamo correspondente o dni e iban ou NULL si non existe.A modificación
     * deste préstamo non debe alterar a información almacenada.So considera os préstamos activos
     * @param dni - DNI do socio
     * @param isbn - isbn do libro
     * @return Prestamo atopado ou NULL
     */
    @Override
    public Prestamo consultaPrestamo(String dni, String isbn) {
        Prestamo p=buscaPrestamo(dni,isbn);
        // Devolvo unha COPIA para que non podan alterar o obxecto contido do ArrayList
        if (p!=null) return new Prestamo(p); 
        return null;
    }
    
    /**
     * Realiza a devolución do préstamo indicado, actualizando a información almacenada de modo
     * apropiado
     * @param p - Préstamo a devolver
     * @throws LibroException - Erro devolvendo o préstamo
     */
    @Override
    public void devolucion(Prestamo p) throws LibroException {
        Prestamo pr=buscaPrestamo(p.getSocio().getDni(),p.getLibro().getIsbn());
        Libro l=pr.getLibro();
        l.decPrestamo();
        guardaLibro(l);
        if (pr!=null) pr.setStatus(false);  // Se modifica o obxecto contido no ArrayList
        else throw new LibroException("O prestamo non se atopa");
    }
    
    /**
     * Localiza o préstamo no ArrayList
     * @param dni - Dni a buscar
     * @param isbn - ISBN a buscar
     * @return Préstamo correspondente ou NULL.E O obxecto almacenado en listaPrestamos, calquera 
     * modificación afectará a listaPrestamos
     */
    private Prestamo buscaPrestamo(String dni, String isbn) {
        Libro l;
        Socio s;
        
        for(Prestamo p: listaPrestamos) {
            if (p.isStatus()) {
                l=p.getLibro();
                s=p.getSocio();
                // Devolvo o obxecto dentro do ArrayList, si se modifica a súa información
                // modificarase o contido do obxecto dentro do ArrayList (xa que son o mesmo)
                if ((l.getIsbn().equals(isbn)) && (s.getDni().equals(dni))) return p;
            }
        }
        return null;
    }
    

    /**
     * Devolve unha lista cos préstamos que deberían ter sido devoltos.
     * @return Lista dos préstamos pendentes de devolución. A modificación destes préstamos non
     * altera a información almacenada
     */
    @Override
    public ArrayList<Prestamo> listaPendientes() {
        ArrayList <Prestamo> lista=new ArrayList <>();
        java.util.Date today=Calendar.getInstance().getTime();
       
        
        for(Prestamo p: listaPrestamos) {
            if (p.isStatus()) {
                // Almaceno no ArrayList unha copia para que non se podan alterar os Prestamos de listaPrestamos
                if (p.getFdevolucion().before(today)) lista.add(new Prestamo(p));
            }
        }
        return lista;
    }

    /**
     * Devolve a lista de prestamos do socio co dni indicado. Si histórico é true inclúe
     * tamén os préstamos xa devoltos
     * @param dni - DNI do socio
     * @param historico - true indica que se queren tamén os xa devoltos
     * @return lista de préstamos
     */
    @Override
    public ArrayList<Prestamo> prestamosSocio(String dni, boolean historico) {
        ArrayList <Prestamo> lista=new ArrayList <>();
            
        for(Prestamo p: listaPrestamos) {
            if (p.getSocio().getDni().equals(dni)) {
                if (p.isStatus() || historico) {
                    // Almaceno no ArrayList unha copia para que non se podan alterar os Prestamos de listaPrestamos
                    lista.add(new Prestamo(p));
                }
            }
        }
        return lista;
    }

    /**
     * Devolve a lista de préstamos correspondentes ao libro indicado. Si histórico é true
     * inclúe tamén os préstamos xa devoltos
     * @param isbn - ISBN do libro
     * @param historico - true indica que se queren tamén os xa devoltos
     * @return lista de préstamos
     */
    @Override
    public ArrayList<Prestamo> prestamosLibro(String isbn, boolean historico) {
         ArrayList <Prestamo> lista=new ArrayList <>();
            
        for(Prestamo p: listaPrestamos) {
            if (p.getLibro().getIsbn().equals(isbn)) {
                if (p.isStatus() || historico) {
                    // Almaceno no ArrayList unha copia para que non se podan alterar os Prestamos de listaPrestamos
                    lista.add(new Prestamo(p));
                }
            }
        }
        return lista;
    }    
}
