
package alquilerpeliculas;

import javax.swing.JOptionPane;

public class Inventario {
    
    public static pelicula [] peliculas = new pelicula [15];
    //algunas peliculas para empezar
    public void peliculasIniciales() {
        peliculas[0]= new pelicula("Cars", "Animacion", 1998, 750,0,5,"P01" );
        peliculas[1]= new pelicula("Rapidos y Furiosos", "Accion", 2007, 900,13,2,"P02");
        peliculas[2]= new pelicula("Chuky", "Terror", 2005, 550, 18, 10, "P03");
        
    }
    //Catalogo de peliculas
    public void mostrarPeli(){
        String lista = "====Catalogo de peliculas====\n";
        boolean hayPeli = false;
        for (int i = 0; i < peliculas.length; i++){
            pelicula p = peliculas [i];
            if (p != null) {
                hayPeli = true;
                lista += (i + 1) + "." + p.getTitulo()+ "(" + p.getAño() + ") - " + p.getGenero() + "\n" + 
                "Clasificacion + " + p.getClasificacionEdad() + "\n" + 
                "Codigo: " + p.getCodigo() + "\n" + "Disponibles: " + p.getUnidadesDisponibles() + "\n\n";
            }
        }
        if (!hayPeli){
            lista = "No hay peliculas en el inventario.";
        }
        JOptionPane.showMessageDialog(null, lista);
    }
    public void agregarPelicula(){
        for (int i = 0; i < peliculas.length; i++){
            if(peliculas [i] == null){
                String titulo = JOptionPane.showInputDialog("Ingrese el titulo de la pelicula: ");
                String genero = JOptionPane.showInputDialog("Ingrese el genero de la pelicula: ");
                int año = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de lanzamiento:"));
                double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio por dia:"));
                int clasificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la clasificacion de la pelicula:"));
                int disponibles = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de peliculas disponibles:"));
                String codigo = JOptionPane.showInputDialog("Ingrese el codigo unico de la pelicula: ");
                
                peliculas [i] = new pelicula(titulo, genero, año, precio, clasificacion, disponibles, codigo);
                JOptionPane.showMessageDialog(null, "Pelicula agregada correctamente");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Inventario lleno. No se pueden agregar mas peliculas.");
        
    }
    public void modificarPelicula(){
        String codigo = JOptionPane.showInputDialog("Ingrese el codigo de la pelicula a modificar:");
       if (codigo == null || codigo.isBlank()){
           JOptionPane.showMessageDialog(null, "Codigo invalido.");
           return;
       } 
       pelicula p = buscarPorCodigo(codigo);
       if (p == null){
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
    public pelicula buscarPorCodigo(String codigo){
        for(int i = 0; i < peliculas.length; i++ ){
            pelicula p = peliculas [i];
            if (p != null && p.getCodigo().equalsIgnoreCase(codigo)){
                return p;
            }
        }
        return null;
    }
}
