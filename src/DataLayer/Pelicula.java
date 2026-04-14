
package DataLayer;

/**
 * Clase abstracta que representa la entidad base de cualquier película en el videoclub.
 * Define los atributos fundamentales y el contrato para que las clases hijas
 * calculen su propio costo de alquiler dependiendo de su tipo.
 * @author Daniel Serrano
 * @version 2.0
 */
public abstract class Pelicula implements IAlquilable {

    private String titulo;
    private String genero;
    private int año;
    private double precioDia;
    private int clasificacionEdad;
    private int unidadesDisponibles;
    private String codigo;

    /**
     * Constructor base para inicializar los datos comunes de una película.
     * @param titulo El nombre de la película.
     * @param genero La categoría principal (ej. Acción, Terror).
     * @param año El año oficial de lanzamiento.
     * @param precioDia El costo base por día de alquiler en colones.
     * @param clasificacionEdad La edad mínima requerida para alquilarla.
     * @param unidadesDisponibles La cantidad de copias físicas en la tienda.
     * @param codigo El identificador alfanumérico único (ej. "P01").
     */
    public Pelicula(String titulo, String genero, int año, double precioDia, int clasificacionEdad, int unidadesDisponibles, String codigo) {
        this.titulo = titulo;
        this.genero = genero;
        this.año = año;
        this.precioDia = precioDia;
        this.clasificacionEdad = clasificacionEdad;
        this.unidadesDisponibles = unidadesDisponibles;
        this.codigo = codigo;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public int getAño() { return año; }
    public void setAño(int año) { this.año = año; }
    public double getPrecioDia() { return precioDia; }
    public void setPrecioDia(double precioDia) { this.precioDia = precioDia; }
    public int getClasificacionEdad() { return clasificacionEdad; }
    public void setClasificacionEdad(int clasificacionEdad) { this.clasificacionEdad = clasificacionEdad; }
    public int getUnidadesDisponibles() { return unidadesDisponibles; }
    public void setUnidadesDisponibles(int unidadesDisponibles) { this.unidadesDisponibles = unidadesDisponibles; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    /**
     * Calcula el costo total del alquiler basado en la cantidad de días.
     * Este método es abstracto y se delega su implementación matemática a las clases hijas.
     * @param dias Cantidad de días que durará el alquiler.
     * @return El costo total calculado en la moneda local.
     */
    public abstract double calcularCostoAlquiler(int dias);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pelicula otraPelicula = (Pelicula) obj;
        return this.codigo.equals(otraPelicula.getCodigo());
    }

    @Override
    public boolean estaDisponible() {
        return this.unidadesDisponibles > 0;
    }
}