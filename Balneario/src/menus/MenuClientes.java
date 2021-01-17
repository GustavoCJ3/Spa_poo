package menus;

import clientes.Cliente;

/**
 *
 * @author maxpi
 */
public class MenuClientes extends Menu{
    
    public MenuClientes(){
        super("1. Listado de todos los clientes\n"
                    + "2. Información de un cliente\n"
                    + "3. Añadir un cliente\n"
                    + "4. Guardar cambios\n"
                    + "0. Volver\n"
                    + "\nElige una opción: ", 4);
        
    }
    
    private void listaClientes(){
        for(Cliente c: getBalneario().getClientes()){
            System.out.println("" + c.infoCliente() +"\n");
        }
    }
    
    private void listaClientes(String dni){
        for(Cliente c: getBalneario().getClientes()){
            if (c.getDni() == dni) {
                System.out.println("" + c.infoCliente() +"\n");
                
                return; //Si el cliente existe
            }
        }
    }
    
    private void agregarCliente(String dni, String nombreApellidos, String telefonoMovil){
        //Comprobamos que el DNI no esté ya en el sistema
        
        for(Cliente c: getBalneario().getClientes()){
            if (c.getDni() == dni) {
                return;
            } 
        }
        
        Cliente c = new Cliente(dni, nombreApellidos, telefonoMovil);
        
        getBalneario().getClientes().add(c);
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaClientes();
                break;
            case 2:
                listaClientes();
                break;
            case 3:
                //agregarCliente();
                break;
            case 4:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
