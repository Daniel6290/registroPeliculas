package DataLayer;
import java.util.Date;

public class Recibo {
    private String idRecibo;
    private Date fechaEmision;
    private double totalCobrado;

    public Recibo(String idRecibo, double totalCobrado) {
        this.idRecibo = idRecibo;
        this.fechaEmision = new Date(); // Toma la fecha y hora actual
        this.totalCobrado = totalCobrado;
    }

    public String getIdRecibo() {
        return idRecibo;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public double getTotalCobrado() {
        return totalCobrado;
    }
}