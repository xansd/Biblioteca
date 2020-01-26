package biblioteca;

/**
 * Define un Libro
 * @author Javier Taboada
 * @author xavitag.es
 * @version 1.0
 * @since 1.0
*/
public class Libro {
    /**
     * ISBN do libro
     */
    private String isbn;
    /**
     * Título do libro
     */
    private String titulo;
    /**
     * Nome e apelidos do autor
     */
    private String autor;
    /**
     * Resumo do libro
     */
    private String resumen;
    /**
     * Número de exemplares en existencias
     */
    private int existencias;
    /**
     * Número de exemplares prestados 
     */
    private int en_prestamo;
    
    /**
     * Constructor
     * @param isbn - ISBN
     * @param titulo - Titulo
     * @param autor - Nome e apelidos do autor
     * @param resumen  - Resumo (Breve Reseña)
     */
    public Libro(String isbn, String titulo, String autor, String resumen) {
        this.isbn=isbn;
        this.titulo=titulo;
        this.autor=autor;
        this.resumen=resumen;
        this.existencias=1;
        this.en_prestamo=0;
    }

    /**
     * Construtor de copia. So utilizable dende este paquete
     * @param l - Libro a copiar
     */
    Libro(Libro l) {
        // Os String son inmutables, se poden asignar sin perigo
        this.isbn=l.isbn;
        this.titulo=l.titulo;
        this.autor=l.autor;
        this.resumen=l.resumen;
        this.existencias=l.existencias;
        this.en_prestamo=l.en_prestamo;
    }

    /**
     * Devolve o ISBN do libro
     * @return ISBN do libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Devolve o título do libro
     * @return Título do libro
     */
    public String getTitulo() {
        return titulo;
    }


    /**
     * Devolve o autor do libro
     * @return Autor do libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Devolve o resumo do libro
     * @return Resumo do libro
     */
    public String getResumen() {
        return resumen;
    }

    /**
     * Devolve as existencias do libro
     * @return número de exemplares do libro na biblioteca
     */
    public int getExistencias() {
        return existencias;
    }

    /**
     * Devolve o número de exemplares en préstamo
     * @return número de exemplares en préstamo deste libro
     */
    public int getEn_prestamo() {
        return en_prestamo;
    }

    /**
     * Incrementa os exemplares prestados deste libro
     * @return número de exemplares prestados
     * @throws LibroException - Non se poden prestar máis exemplares
     */
    int incPrestamo() throws LibroException {
        if (en_prestamo>=existencias) throw new LibroException("Todos os exemplares de "+this+" estan prestados");
        en_prestamo++;
        return en_prestamo;
    }
    
    /**
     * Decrementa os exemplares prestados deste libro
     * @return número de exemplares prestados
     * @throws LibroException - Non se poden prestar máis exemplares
     */
    int decPrestamo() {
        if (en_prestamo>0) en_prestamo--;
        return en_prestamo;
    }

    /**
     * Engade ao libro o número de exemplares indicados
     * @param existencias - Exemplares a engadir
     * @return Exemplares totales existentes
     */
    public int addExistencias(int existencias) {
        this.existencias+=existencias;
        return this.existencias;
    } 
    
    @Override
    public String toString() {
        return isbn+": "+titulo+" ("+autor+")";
    }
}
