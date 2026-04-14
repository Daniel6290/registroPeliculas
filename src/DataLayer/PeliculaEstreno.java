package DataLayer;

/**
 * Representa una película de estreno en el sistema de alquiler.
 * Esta clase hereda de la clase abstracta Pelicula y define
 * su propio cálculo de costos aplicando un recargo por novedad.
 * @author Daniel Serrano
 * @version 2.0
 */
public class PeliculaEstreno extends Pelicula {

    public PeliculaEstreno(String titulo, String genero, int año, double precioDia, int clasificacionEdad, int unidadesDisponibles, String codigo) {
        super(titulo, genero, año, precioDia, clasificacionEdad, unidadesDisponibles, codigo);
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        double costoBase = getPrecioDia() * dias;
        double recargo = costoBase * 0.20; // 20% extra por ser estreno
        return costoBase + recargo;
    }
}