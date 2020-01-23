package biblioteca;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ASIR\xavi
 */
public class Prestamo {
    private Socio socio;
    private Libro libro;
    private java.sql.Date fprestamo;
    private java.sql.Date fdevolucion;
    private boolean status;
    
    public Prestamo(Socio socio,Libro libro,java.sql.Date fprestamo) {
        this.socio=socio;
        this.libro=libro;
        this.fprestamo=fprestamo;
        this.fdevolucion=addDays(fprestamo,7);
        this.status=true;
    }
    
    private static java.sql.Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new java.sql.Date(c.getTimeInMillis());
    }

    /**
     * @return the socio
     */
    public Socio getSocio() {
        return socio;
    }

    /**
     * @param socio the socio to set
     */
    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    /**
     * @return the libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * @return the fprestamo
     */
    public java.sql.Date getFprestamo() {
        return fprestamo;
    }

    /**
     * @param fprestamo the fprestamo to set
     */
    public void setFprestamo(java.sql.Date fprestamo) {
        this.fprestamo = fprestamo;
    }

    /**
     * @return the fdevolucion
     */
    public java.sql.Date getFdevolucion() {
        return fdevolucion;
    }

    /**
     * @param fdevolucion the fdevolucion to set
     */
    public void setFdevolucion(java.sql.Date fdevolucion) {
        this.fdevolucion = fdevolucion;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
