
package UI;

import CL.Inventario;
import CL.RegistroAlquileres;
import CL.RegistroCliente;

import javax.swing.JOptionPane;

public class MenuPrincipal {
    
    private Inventario inventario;
    private RegistroCliente registroClientes;
    private RegistroAlquileres registroAlquileres;
    
            
    public MenuPrincipal(){
        inventario = new Inventario();
        registroClientes = new RegistroCliente (20);
        registroAlquileres = new RegistroAlquileres();
        
        inventario.peliculasIniciales();
    }
    public void mostrarMenu(){
        boolean continuar = true;
        while (continuar) {
            String opcion = JOptionPane.showInputDialog(null,"Menu principal \n" + 
                                                    "Seleccione la opcion: \n"+
                                                    "1. Ver el catalogo de peliculas \n"+
                                                    "2. Alquilar una pelicula \n"+
                                                    "3. Registrar un cliente \n"+
                                                    "4. Ingresar como administrador \n"+
                                                    "5. Salir ");
            if (opcion == null) return;
            
            switch(opcion)
            {
                case "1":
                    inventario.mostrarPeli();
                    break;
                case "2":
                    registroAlquileres.realizarAlquiler(inventario, registroClientes);
                    break;
                case "3":
                    registrarCliente();
                    break;
                case "4":
                    MenuAdmin admin = new MenuAdmin(inventario, registroClientes, registroAlquileres);
                    admin.adminMenu();
                    break;
                case "5":
                    continuar = false;
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
              }
        }
    }
    private void registrarCliente() {
        
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String documento = JOptionPane.showInputDialog("Documento (ID):");
        String correo = JOptionPane.showInputDialog("Correo:");
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Telefono:"));
        int añoNacimiento = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
        
        boolean agregado = registroClientes.agregarCliente(nombre, documento, correo, telefono, añoNacimiento);
        if (agregado){
            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
        }
        else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente");
        }
  
    }
}
