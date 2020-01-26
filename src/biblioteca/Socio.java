package biblioteca;

/**
 * Define un Socio
 * @author Javier Taboada
 * @author xavitag.es
 * @version 1.0
 * @since 1.0
*/
public class Socio {
    /**
     * DNI do socio
     */
    private String dni;
    /**
     * Nome e apelidos do socio
     */
    private String nombre;
    /**
     * Dirección do socio
     */
    private String direccion;
    /**
     * Teléfono do socio
     */
    private String telefono;
    /**
     * Email do socio
     */
    private String email;
    /**
     * Indica si o socio está activo (pode facer préstamos) ou non
     */
    private boolean active;
    
    /**
     * Constructor
     * @param dni - DNI
     * @param nombre - Nome e Apelidos
     * @param direccion - Dirección
     * @param telefono - Teléfono
     * @param email - Email
     */
    public Socio(String dni,String nombre, String direccion,String telefono,String email) {
        this.dni=dni;
        this.nombre=nombre;
        this.direccion=direccion;
        this.telefono=telefono;
        this.email=email;
        this.active=true;
    }

    /**
     * Construtor de copia. So utilizable dende este paquete
     * @param s 
     */
    Socio(Socio s) {
        this.dni=s.dni;
        this.nombre=s.nombre;
        this.direccion=s.direccion;
        this.telefono=s.telefono;
        this.email=s.email;
        this.active=s.active;
    }

    /**
     * Devolve o DNI do Socio
     * @return o DNI
     */
    public String getDni() {
        return dni;
    }


    /**
     * Devolve o nome e apelidos do socio
     * @return nome e apelidos do socio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devolve a dirección do socio
     * @return a dirección
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Devolve o teléfono do socio
     * @return o teléfono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Devolve o email do socio
     * @return o email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Indica si o socio pode facer préstamos ou non
     * @return true (activo) ou false (inactivo)
     */
    public boolean isActive() {
        return active;
    }
    
    /**
     *
     * @return String representando o Obxecto Socio
     */
    @Override
    public String toString() {
        return dni+": "+nombre;
    }

    /**
     * Activa ou desactiva un socio de modo que se lle impidan o permitan préstamos
     * @param b true activa, e false desactiva
     */
    public void setActive(boolean b) {
        this.active=b;
    }
}
