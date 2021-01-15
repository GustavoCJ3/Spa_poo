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
        for(Cliente s: getBalneario().getClientes()){
            s.infoCliente();
        }
    }
    
    private int listaClientes(String dni){
        for(Cliente c: getBalneario().getClientes()){
            if (c.getDni() == dni) {
            
            return Integer.parseInt(dni);
            }
        }
        return -1; //TODO
    }
    
    private int agregarCliente(String dni, String nombreApellidos, String telefonoMovil){
        //Comprobamos que el DNI no esté ya en el sistema
        for(Cliente c: getBalneario().getClientes()){
            if (c.getDni() == dni) {
                return -1; //TODO habría que meter un enum con las constantes. Ya mañana.
            } 
        }
        
        Cliente c = new Cliente(dni, nombreApellidos, telefonoMovil);
        
        getBalneario().getClientes().add(c);
        return getBalneario().getServicios().indexOf(c); //devolvemos el índice del objeto insertado
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
