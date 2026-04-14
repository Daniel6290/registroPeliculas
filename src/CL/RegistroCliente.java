
package CL;

import DataLayer.Cliente;

//ingresar nuevo cliente
public class RegistroCliente {
    private Cliente[] clientes;
    private int cantidad;
    
    public RegistroCliente(int tamaño){
        clientes = new Cliente[tamaño];
        cantidad = 0;
    }
    
    public boolean agregarCliente(String nombre, String documento, String correo, int telefono, int añoNacimiento){
        if (cantidad < clientes.length){
            Cliente nuevo = new Cliente(nombre, documento, correo, telefono, añoNacimiento);
            clientes [cantidad] = nuevo;
            cantidad++;
            return true;
           
    }
        else {
            return false;
        }
        
      }
        
  // metodo para buscar cliente por ID
  
  public Cliente buscarID(String documento){
      for (int i = 0; i < cantidad; i++ ){
          if (clientes[i].getDocumento().equals(documento) ){
              return clientes[i];
          }
      }
      return null;
     
  }
  public Cliente[] getClientes(){
      return clientes;
      
  }
  public int getCantidad(){
      return cantidad;
      
  }
    
}
