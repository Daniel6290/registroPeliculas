
package alquilerpeliculas;

//atributos y constructor
public class pelicula {
    private String titulo;
    private String genero;
    private int año;
    private double precioDia;
    private int clasificacionEdad;
    private int unidadesDisponibles;
    private String codigo;
    
    
    public pelicula(String titulo, String genero, int año, double precioDia, int clasificacionEdad, int unidadesDisponibles, String codigo){
        this.titulo = titulo;
        this.genero = genero;
        this.año = año;
        this.precioDia = precioDia;
        this.clasificacionEdad = clasificacionEdad;
        this.unidadesDisponibles = unidadesDisponibles;
        this.codigo = codigo;
        
    }
    //getter y setter
    public String getTitulo(){
        return titulo;
       
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getGenero(){
        return genero;
       
    }
    public void setGenero(String genero){
        this.genero = genero;
      }
    
    
    public int getAño(){
        return año;
       
    }
    public void setAño(int año){
        this.año = año;
      }
    
    public double getPrecioDia(){
        return precioDia;
       
    }
    public void setPrecioDia(double precioDia){
        this.precioDia = precioDia;
      }
    
    public int getClasificacionEdad(){
        return clasificacionEdad;
       
    }
    public void setClasificacionEdad(int clasificacionEdad){
        this.clasificacionEdad = clasificacionEdad;
      }
    
     public int getUnidadesDisponibles(){
        return unidadesDisponibles;
       
    }
    public void setUnidadesDisponibles(int unidadesDisponibles){
        this.unidadesDisponibles = unidadesDisponibles;
      }
    public String getCodigo(){
        return codigo;
       
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
      }
    
    
}
