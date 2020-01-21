/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author ASIR\xavi
 */
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String resumen;
    private int existencias;
    private int en_prestamo;
    
    public Libro(String iban, String titulo, String autor, String resumen) {
        this.isbn=iban;
        this.titulo=titulo;
        this.autor=autor;
        this.resumen=resumen;
        this.existencias=1;
        this.en_prestamo=0;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the resumen
     */
    public String getResumen() {
        return resumen;
    }

    /**
     * @param resumen the resumen to set
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    /**
     * @return the existencias
     */
    public int getExistencias() {
        return existencias;
    }

    /**
     * @param existencias the existencias to set
     */
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    /**
     * @return the en_prestamo
     */
    public int getEn_prestamo() {
        return en_prestamo;
    }

    /**
     * @param en_prestamo the en_prestamo to set
     */
    public void setEn_prestamo(int en_prestamo) {
        this.en_prestamo = en_prestamo;
    }
    
    int incPrestamo() throws LibroException {
        if (en_prestamo>=existencias) throw new LibroException("Todos os exemplares de "+this+" estan prestados");
        en_prestamo++;
        return en_prestamo;
    }

    int addExistencias(int existencias) {
        this.existencias+=existencias;
        return this.existencias;
    }
}
