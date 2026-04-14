package DataLayer;

/**
 * Contrato que define los comportamientos obligatorios para cualquier
 * elemento que pueda ser alquilado dentro del sistema.
 * @author Daniel Serrano
 * @version 2.0
 */
public interface IAlquilable {
    double calcularCostoAlquiler(int dias);
    boolean estaDisponible();
}