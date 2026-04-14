package DataLayer;

/**
 * Representa a un cliente dentro del sistema de videoclub.
 * Esta clase almacena la información personal necesaria para 
 * procesar los alquileres y validar restricciones de edad.
 * @author Daniel Serrano
 * @version 2.0
 */
public class Cliente {

    private String nombreCompleto;
    private String documento;
    private String correo;
    private int telefono;
    private int edad;

    /**
     * Constructor principal para crear un nuevo Cliente en el sistema.
     * @param nombreCompleto El nombre y apellidos del cliente.
     * @param documento La cédula o identificación única.
     * @param correo El correo electrónico de contacto.
     * @param telefono El número de teléfono.
     * @param edad La edad del cliente (usada para validar películas).
     */
    public Cliente(String nombreCompleto, String documento, String correo, int telefono, int edad) {
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
}