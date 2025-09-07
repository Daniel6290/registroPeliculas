
package alquilerpeliculas;

import javax.swing.JOptionPane;


public class menuAdmin {
    
    private Inventario inventario;
    private RegistroCliente registroCliente;
    private RegistroAlquileres registroAlquiler;
    
    
    public menuAdmin(Inventario inventario, RegistroCliente registroCliente, RegistroAlquileres registroAlquiler){
        this.inventario = inventario;
        this.registroCliente = registroCliente;
        this.registroAlquiler = registroAlquiler;
       
        
    }
    
    public void adminMenu(){
        //autenticacion del administrador
        
        JOptionPane.showMessageDialog(null, "Acceso restringido porfavor ingrese el usuario y la contraseña:");
        
        if (!autenticacion()){
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
            return;
        }
        
        //menu del administrador
        boolean continuar = true;
        while (continuar){
            String opc = JOptionPane.showInputDialog("=====Menu Administrador====\n" +
                    "1. Agregar pelicula\n" +
                    "2. Modificar pelicula\n" +
                    "3. Volver al Menu Principal");
            
            if (opc == null) return;
            switch (opc){
                case "1":
                    inventario.agregarPelicula();
                    break;
                    
                case "2":
                    inventario.modificarPelicula();
                    break;
                    
                    
                case "3":
                    continuar = false;
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalidad");
                    break;
            }
        }
    }
    private boolean autenticacion(){
        String usuario = JOptionPane.showInputDialog("Usuario: ");
        if (usuario == null)
            return false;
        String contraseña = JOptionPane.showInputDialog("Contraseña: ");
        if (contraseña == null)
            return false;
        return usuario.equals("admin") && contraseña.equals("1234");
        
    }
}
