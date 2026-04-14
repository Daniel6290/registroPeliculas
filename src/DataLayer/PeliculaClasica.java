package DataLayer;

/**
 * Representa una película clásica en el sistema de alquiler.
 * Implementa un descuento especial para alquileres prolongados.
 * @author Daniel Serrano
 * @version 2.0
 */
public class PeliculaClasica extends Pelicula {

    public PeliculaClasica(String titulo, String genero, int año, double precioDia, int clasificacionEdad, int unidadesDisponibles, String codigo) {
        super(titulo, genero, año, precioDia, clasificacionEdad, unidadesDisponibles, codigo);
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        double costoBase = getPrecioDia() * dias;
        if (dias > 3) {
            double descuento = costoBase * 0.10; // 10% de descuento si son más de 3 días
            return costoBase - descuento;
        }
        return costoBase;
    }
}