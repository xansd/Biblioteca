package biblioteca;

import java.util.Calendar;
import java.util.Date;

/**
 * Define un Préstamo
 * @author Javier Taboada
 * @author xavitag.es
 * @version 1.0
 * @since 1.0
*/
public class Prestamo {
    /**
     * Socio que realiza o préstamo
     */
    private Socio socio;    
    /**
     * Libro prestado
     */
    private Libro libro;
    /**
     * Data do préstamo
     */
    private java.sql.Date fprestamo;
    /**
     * Data límite de devolución
     */
    private java.sql.Date fdevolucion;
    /**
     * true indica que non foi devolto, false que foi devolto
     */
    private boolean status;
    
    /**
     * Crea un préstamo a partir dun Socio e un Libro
     * @param socio - Socio que realiza o préstamo
     * @param libro - Libro que realiza o préstamo
     */
    public Prestamo(Socio socio,Libro libro) throws Exception {
        if (libro==null) throw new Exception("Error Préstamo: Libro non existente");
        if (socio==null) throw new Exception("Error Préstamo: Socio non existente");
        this.socio=socio;
        this.libro=libro;
        this.fprestamo=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        this.fdevolucion=addDays(this.fprestamo,7); // 7 días
        this.status=true;
    }

    /**
     * Constructor de copia. So se permite dentro do mesmo paquete
     * @param p - Préstamo a copiar
     */
    Prestamo(Prestamo p) {
        socio=new Socio(p.socio);
        libro=new Libro(p.libro);
        fprestamo=new java.sql.Date(p.fprestamo.getTime());
        fdevolucion=new java.sql.Date(p.fdevolucion.getTime());
        status=p.status;
    }
    
    /**
     * Devolve o socio que realizou o préstamo. NON devolve unha copia, a 
     * modificación deste socio modificará o préstamo
     * So utilizable dende o mesmo paquete
     * @return devolve o socio
     */
    Socio getSocio() {
        return socio;
    }

    /**
     * Devolve o libro que realizou o préstamo. NON devolve unha copia, 
     * a modificación deste socio modificará o préstamo. So utilizable dende o
     * mesmo paquete
     * @return o libro
     */
    Libro getLibro() {
        return libro;
    }

    /**
     * Devolve a data de préstamo. A alteración desta data altera o obxecto Préstamo
     * So utilizable dende o mesmo paquete
     * @return a data do préstamo
     */
    java.sql.Date getFprestamo() {
        return fprestamo;
    }

    /**
     * Devolve a data de devolución do préstamo. A alteración desta data altera o obxecto Préstamo
     * So utilizable dende o mesmo paquete
     * @return a data de devolución
     */
    java.sql.Date getFdevolucion() {
        return fdevolucion;
    }

    /**
     * Devolve true si o préstamo está "activo" e false si está devolto
     * @return Estado do préstamo (false indica xa devolto)
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Cambia o estado do préstamo. So utilizable dende o mesmo paquete
     * @param status the status to set
     */
    void setStatus(boolean status) {
        this.status = status;
    }
    
    
    /**
     * Engade a data indicada un número de dias
     * @param date - Data
     * @param days - Número de días a engadir
     * @return Data resultante
     */    
    private static java.sql.Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new java.sql.Date(c.getTimeInMillis());
    }
    
    @Override
    public String toString() {
        return socio+" - "+libro+"\n"+"Prestado o "+fprestamo+"\n"+"A devolver "+fdevolucion;
    }
}
