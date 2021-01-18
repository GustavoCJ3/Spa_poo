package menus;

import clientes.Cliente;
import factorias.FactoryCliente;

/**
 * Permite al usuario acceder a las funciones que actúan sobre los clientes.
 * @author Gustavo Cortés Jiménez
 * @author Rodrigo Lázaro Escudero
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
    
    /**
     * Muestra los datos de todos los clientes guardados
     */
    private void listaClientes(){
        if(getBalneario().getClientes().isEmpty()){
            System.out.println("\nNo hay clientes registrados.\n");
        }else{  
            for(Cliente c: getBalneario().getClientes()){
                System.out.println(c.infoCliente());
            }
        }
    }
    
    /**
     * Muestra los datos de un cliente
     * @param dni El DNI del usuario que mostrar
     */
    private void listaClientes(String dni){
        for(Cliente c: getBalneario().getClientes()){
            if (c.getDni().equalsIgnoreCase(dni)) {
                System.out.println(c.infoCliente());
                
                return; //Si el cliente existe
            }
        }
        System.out.println("No existe ningún cliente con el DNI indicado.\n");
    }
    
    /**
     * Crea y añade un nuevo cliente al sistema.
     */
    private void agregarCliente(){        
        String idCliente;
        FactoryCliente fc;
        
        //System.out.println("Introduce el DNI del cliente:\n"); //Ya lo pide Cliente.pedirId
        idCliente = Cliente.pedirId();
        
        //Comprobamos que el DNI no esté ya en el sistema        
        for(Cliente c: getBalneario().getClientes()){
            if (c.getDni().equalsIgnoreCase(idCliente)) {
                System.out.println("El DNI indicado ya está registrado en el sistema.\n");
                return;
            } 
        }
        
        fc = new FactoryCliente();
        getBalneario().getClientes().add(fc.getInstancia(idCliente));
        System.out.println("Cliente añadido.\n");
    }
    
    //No se pide funcionalidad para eliminación de clientes
    /*
    private void eliminarCliente(String dni){     
        for(Cliente c: getBalneario().getClientes()){
            if(c.getDni().equalsIgnoreCase(dni)) {
                getBalneario().getClientes().remove(c);
                return;
            }
        }
        System.out.println("No existe ningún Cliente con el DNI indicado.\n");
    }    
    */
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaClientes();
                break;
            case 2:
                listaClientes(Cliente.pedirId());
                break;
            case 3:
                agregarCliente();
                //eliminarCliente(Cliente.pedirId());
                break;
            case 4:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
