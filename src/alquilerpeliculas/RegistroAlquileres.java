package alquilerpeliculas;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class RegistroAlquileres {

    private ArrayList<Alquiler> listaAlquileres = new ArrayList<>();

    public void realizarAlquiler(Inventario inventario, RegistroCliente registroClientes) {
        String documento = JOptionPane.showInputDialog("Ingrese su documento (ID):");
        cliente cliente = registroClientes.buscarID(documento);

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no registrado. Por favor regístrese primero.");
            return;
        }

        inventario.mostrarPeli();
        String codigoPelicula = JOptionPane.showInputDialog("Ingrese el código de la película a alquilar:");
        pelicula pelicula = inventario.buscarPorCodigo(codigoPelicula);

        if (pelicula == null) {
            JOptionPane.showMessageDialog(null, "Película no encontrada.");
            return;
        }

        // Validación de edad
           if (cliente.getEdad() < pelicula.getClasificacionEdad()) {
        JOptionPane.showMessageDialog(null, "No cumple con la edad mínima para alquilar esta película.");
        return;
         }
        //validacion de las peliculas disponibles
        if (pelicula.getUnidadesDisponibles() <= 0) {
            JOptionPane.showMessageDialog(null, "No hay unidades disponibles.");
            return;
        }

        int dias = Integer.parseInt(JOptionPane.showInputDialog("¿Por cuántos días desea alquilar la película?"));

        double costo = dias * pelicula.getPrecioDia();

        pelicula.setUnidadesDisponibles(pelicula.getUnidadesDisponibles() - 1);

        Alquiler alquiler = new Alquiler(cliente, pelicula, dias, costo);
        listaAlquileres.add(alquiler);

        JOptionPane.showMessageDialog(null,
                "¡Alquiler exitoso!\n" +
                "Película: " + pelicula.getTitulo() + "\n" +
                "Cliente: " + cliente.getNombreCompleto() + "\n" +
                "Días: " + dias + "\n" +
                "Total a pagar: ₡" + costo);
    }

    public ArrayList<Alquiler> getListaAlquileres() {
        return listaAlquileres;
    }
}
