
package DataLayer;

public class Alquiler {

    private Cliente cliente;
    private Pelicula pelicula;
    private int dias;
    private double costoTotal;
    private Recibo recibo;

    public Alquiler(Cliente cliente, Pelicula pelicula, int dias, double costoTotal) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.dias = dias;
        this.costoTotal = costoTotal;
        this.recibo = new Recibo("REC-" + System.currentTimeMillis(), costoTotal);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Recibo getRecibo() { return recibo; }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public int getDias() {
        return dias;
    }

    public double getCostoTotal() {
        return costoTotal;
    }
}

