package CL;

import DataLayer.*; // Importamos las películas desde la capa de datos
import javax.swing.JOptionPane;

/**
 * Gestor central de la lógica de control del catálogo de películas.
 * Se encarga de almacenar, clasificar, agregar, modificar y buscar las películas
 * utilizando un arreglo de tamaño fijo como estructura de datos temporal.
 * @author Daniel Serrano
 * @version 2.0
 */
public class Inventario {

    private Pelicula[] peliculas = new Pelicula[15];

    public void peliculasIniciales() {
        peliculas[0] = new PeliculaClasica("Cars", "Animacion", 1998, 750, 0, 5, "P01");
        peliculas[1] = new PeliculaEstreno("Rapidos y Furiosos", "Accion", 2007, 900, 13, 2, "P02");
        peliculas[2] = new PeliculaClasica("Chuky", "Terror", 2005, 550, 18, 10, "P03");
    }

    public void mostrarPeli() {
        String lista = "==== Catalogo de peliculas ====\n";
        boolean hayPeli = false;
        for (int i = 0; i < peliculas.length; i++) {
            Pelicula p = peliculas[i];

            if (p != null) {
                hayPeli = true;

                // --- INICIO DEL CÓDIGO NUEVO ---
                // Le preguntamos a Java de qué clase hija proviene esta película
                String tipoEtiqueta = "";
                if (p instanceof PeliculaEstreno) {
                    tipoEtiqueta = "[ESTRENO] ";
                } else if (p instanceof PeliculaClasica) {
                    tipoEtiqueta = "[CLÁSICA] ";
                }
                // --- FIN DEL CÓDIGO NUEVO ---

                // Le agregamos la variable tipoEtiqueta justo antes del título
                lista += (i + 1) + ". " + tipoEtiqueta + p.getTitulo() + " (" + p.getAño() + ") - " + p.getGenero() + "\n" +
                        "Clasificacion +" + p.getClasificacionEdad() + "\n" +
                        "Codigo: " + p.getCodigo() + "\nDisponibles: " + p.getUnidadesDisponibles() + "\n\n";
            }
        }
        if (!hayPeli) {
            lista = "No hay peliculas en el inventario.";
        }
        JOptionPane.showMessageDialog(null, lista);
    }


    /**
     * Muestra en pantalla un catálogo filtrado de películas.
     * @param filtroGenero El texto del género específico que se desea buscar, ignorando mayúsculas.
     */
    public void mostrarPeli(String filtroGenero) {
        String lista = "==== Peliculas de " + filtroGenero + " ====\n";
        boolean hayPeli = false;

        for (int i = 0; i < peliculas.length; i++) {
            Pelicula p = peliculas[i];
            if (p != null && p.getGenero().equalsIgnoreCase(filtroGenero)) {
                hayPeli = true;
                lista += (i + 1) + ". " + p.getTitulo() + " (" + p.getAño() + ") - " + p.getGenero() + "\n" +
                        "Clasificacion +" + p.getClasificacionEdad() + "\n" +
                        "Codigo: " + p.getCodigo() + "\nDisponibles: " + p.getUnidadesDisponibles() + "\n\n";
            }
        }

        if (!hayPeli) {
            lista = "No se encontraron peliculas para el genero: " + filtroGenero;
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    /**
     * Solicita datos al usuario mediante cuadros de diálogo para registrar una nueva película.
     * Aplica polimorfismo al permitir elegir entre crear una Película de Estreno
     * o una Película Clásica, almacenándola en el primer espacio disponible del arreglo.
     */
    public void agregarPelicula() {
        for (int i = 0; i < peliculas.length; i++) {
            if(peliculas[i] == null) {
                String titulo = JOptionPane.showInputDialog("Ingrese el titulo de la pelicula:");
                String genero = JOptionPane.showInputDialog("Ingrese el genero de la pelicula:");
                int año = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de lanzamiento:"));
                double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio por dia:"));
                int clasificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la clasificacion de la pelicula:"));
                int disponibles = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de peliculas disponibles:"));
                String codigo = JOptionPane.showInputDialog("Ingrese el codigo unico de la pelicula:");

                String[] opciones = {"Estreno", "Clásica"};
                int tipoPelicula = JOptionPane.showOptionDialog(null,
                        "¿Qué tipo de película es?",
                        "Tipo de Película",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]);

                if (tipoPelicula == 0) {
                    peliculas[i] = new PeliculaEstreno(titulo, genero, año, precio, clasificacion, disponibles, codigo);
                } else if (tipoPelicula == 1) {
                    peliculas[i] = new PeliculaClasica(titulo, genero, año, precio, clasificacion, disponibles, codigo);
                } else {
                    JOptionPane.showMessageDialog(null, "Operacion cancelada.");
                    return;
                }

                JOptionPane.showMessageDialog(null, "Pelicula agregada correctamente");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Inventario lleno. No se pueden agregar mas peliculas.");
    }

    public void modificarPelicula() {
        String codigo = JOptionPane.showInputDialog("Ingrese el codigo de la pelicula a modificar:");
        if (codigo == null || codigo.isBlank()) {
            JOptionPane.showMessageDialog(null, "Codigo invalido.");
            return;
        }
        Pelicula p = buscarPorCodigo(codigo);
        if (p == null) {
            JOptionPane.showMessageDialog(null, "Pelicula no encontrada.");
            return;
        }
        String nuevoTitulo = JOptionPane.showInputDialog("Nuevo titulo:", p.getTitulo());
        double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio por dia:", p.getPrecioDia()));
        int nuevaDisponibles = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de peliculas disponibles:", p.getUnidadesDisponibles()));

        p.setTitulo(nuevoTitulo);
        p.setPrecioDia(nuevoPrecio);
        p.setUnidadesDisponibles(nuevaDisponibles);

        JOptionPane.showMessageDialog(null, "Pelicula modificada con exito");
    }

    /**
     * Busca secuencialmente una película dentro del inventario utilizando su identificador.
     * @param codigo El código único de la película a buscar.
     * @return El objeto Pelicula si es encontrado, o null si no existe en el sistema.
     */
    public Pelicula buscarPorCodigo(String codigo) {
        for(int i = 0; i < peliculas.length; i++) {
            Pelicula p = peliculas[i];
            if (p != null && p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }
}