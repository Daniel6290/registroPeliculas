
package alquilerpeliculas;

public class Alquiler {

    private cliente cliente;
    private pelicula pelicula;
    private int dias;
    private double costoTotal;

    public Alquiler(cliente cliente, pelicula pelicula, int dias, double costoTotal) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.dias = dias;
        this.costoTotal = costoTotal;
    }

    public cliente getCliente() {
        return cliente;
    }

    public pelicula getPelicula() {
        return pelicula;
    }

    public int getDias() {
        return dias;
    }

    public double getCostoTotal() {
        return costoTotal;
    }
}

