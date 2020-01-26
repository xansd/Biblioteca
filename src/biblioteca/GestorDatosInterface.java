package biblioteca;

import java.util.ArrayList;

/**
 * Interface definindo o API de Almacenamento  de biblioteca 
 * @author Javier Taboada
 * @author xavitag.es
 * @version 1.0
 * @since 1.0
*/
public interface GestorDatosInterface {
    /**
     * Devolve un ArrayList cos libros corresopondentes co string titulo.A modificación
     * dos libros no arraylist devolto non debe modificar a información dos libros almacenados
     * @param titulo - String cun conxunto de palabras separadas por comas
     * @return Lista de libros cun titulo que conten algunha das palabras indicadas. 
     */
    public ArrayList <Libro> consultaLibroPorTitulo(String titulo);
    
    /**
     * Devolve un ArrayList cos libros correspondentes co autor indicado no título.A modificación
     * dos libros no arraylist devolto non debe modificar a información dos libros almacenados
     * @param autor - String cun conxunto de palabras separadas por comas
     * @return  Lista de libros cun autor que conten no nome algunha das palabras indicadas.
     */
    public ArrayList <Libro> consultaLibroPorAutor(String autor);
    
    /**
     * Devolve o libro que ten o iban indicado.A modificación da información do libro devolto
     * non debe alterar a información do libro almacenado.
     * @param iban IBAN a localizar
     * @return Libro co iban indicado ou null si non existe (a información deste libro non debe alterar a información do libro gardado)
     */
    public Libro consultaLibro(String iban);
    
    /**
     * Garda un libro na base de datos.
     * @param l - Libro a gardar
     * @return  - NULL, ou Libro gardado (a modificación deste libro non debe alterar a información do libro almacenado)
     * @throws biblioteca.LibroException - Notifica un erro gardando o libro
     */
    public Libro guardaLibro(Libro l) throws LibroException;
    
    /**
     * Garda un socio na base de datos
     * @param s - Socio a gardar
     * @return - Socio gardado (a modificación do socio devolto non debe alterar a inforamción do libro almacenado)
     * @throws biblioteca.LibroException - Notifica un erro gardando o socio
     */
    public Socio guardaSocio(Socio s) throws LibroException;
    
    /**
     * Devolve o socio co dni indicado.A modificación deste socio non debe modificar a información
     * almacenada.
     * @param dni - DNI do socio a localizar
     * @return NULL ou o Socio correspondente ao DNI indicado
     */
    public Socio consultaSocio(String dni);
    
    /**
     * Garda na base de datos o préstao indicado
     * @param p - Préstamo a almacenar
     * @return - Préstamo almacenado (a modificación deste Préstamo non debe modificar a información almacenada)
     * @throws LibroException - Indica un erro ao intentar almacenar o préstamo.
     */
    public Prestamo guardaPrestamo(Prestamo p) throws LibroException;
    
    /**
     * Devolve o préstamo correspondente o dni e iban ou NULL si non existe.A modificación
     * deste préstamo non debe alterar a información almacenada.So considera os préstamos activos
     * @param dni - DNI do socio
     * @param isbn - isbn do libro
     * @return Prestamo atopado ou NULL
     */
    public Prestamo consultaPrestamo(String dni,String isbn);
    
    /**
     * Realiza a devolución do préstamo indicado, actualizando a información almacenada de modo
     * apropiado
     * @param p - Préstamo a devolver
     * @throws LibroException - Erro devolvendo o préstamo
     */
    public void  devolucion(Prestamo p) throws LibroException;
    
    /**
     * Devolve unha lista cos préstamos que deberían ter sido devoltos.
     * @return Lista dos préstamos pendentes de devolución. A modificación destes préstamos non
     * altera a información almacenada
     */
    public ArrayList <Prestamo> listaPendientes();
 
    /**
     * Devolve a lista de prestamos do socio co dni indicado. Si histórico é true inclúe
     * tamén os préstamos xa devoltos
     * @param dni - DNI do socio
     * @param historico - true indica que se queren tamén os xa devoltos
     * @return lista de préstamos
     */
    public ArrayList <Prestamo> prestamosSocio(String dni,boolean historico);
    
    /**
     * Devolve a lista de préstamos correspondentes ao libro indicado. Si histórico é true
     * inclúe tamén os préstamos xa devoltos
     * @param isbn - ISBN do libro
     * @param historico - true indica que se queren tamén os xa devoltos
     * @return lista de préstamos
     */
    public ArrayList <Prestamo> prestamosLibro(String isbn,boolean historico);
}
