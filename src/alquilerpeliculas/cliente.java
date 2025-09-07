
package alquilerpeliculas;


public class cliente {
    
     private String nombreCompleto;
    private String documento;
    private String correo;
    private int telefono;
    private int edad;
  
    
    
    public cliente(String nombreCompleto, String documento, String correo, int telefono, int edad){
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;

    }
    //getter y setter
    public String getNombreCompleto(){
        return nombreCompleto;
       
    }
    public void setNombreCompleto(String nombreCompleto){
        this.nombreCompleto = nombreCompleto;
    }
    
    public String getDocumento(){
        return documento;
       
    }
    public void setDocumento(String documento){
        this.documento = documento;
      }
    
    public String getCorreo(){
        return correo;
       
    }
    public void setCorreo(String correo){
        this.correo = correo;
      }
    
    
    public int getTelefono(){
        return telefono;
       
    }
    public void setTelefono(int telefono){
        this.telefono = telefono;
      }
    
    public int getEdad(){
        return edad;
       
    }
    public void setEdad(int edad){
        this.edad = edad;
      }
    
     
}
