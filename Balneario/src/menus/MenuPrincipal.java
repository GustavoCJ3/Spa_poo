package menus;
import java.util.ArrayList;
import reservas.Reserva;
import servicios.Servicio;

/**
 * Permite al usuario acceder al resto de menús.
 * @author Gustavo Cortés Jiménez
 * @author Rodrigo Lázaro Escudero
 */
public class MenuPrincipal extends Menu{
    
    private final ArrayList<Menu> menus = new ArrayList();
    
    public MenuPrincipal(){
        super("1. Habitaciones\n"
                    + "2. Clientes\n"
                    + "3. Servicios\n"
                    + "4. Reservas\n"
                    + "5. Facturas\n"
                    + "0. Salir\n"
                    + "\nElige una opción: ", 5);
        
        menus.add(new MenuHabitaciones());
        menus.add(new MenuClientes());
        menus.add(new MenuServicios());
        menus.add(new MenuReservas());
        menus.add(new MenuFacturas());
    }
    
    /**
     * Carga los datos del archivo de configuración, y llama al menú principal
     */
    public void iniciar(){
        if (getBalneario().cargarDatos()){
            int tam = getBalneario().getReservas().size();
            if (tam != 0){
                Reserva.numMaxReserva = getBalneario().getReservas().get( tam - 1 ).getNumReserva() + 1;
            }
            
            tam = getBalneario().getServicios().size();
            if (tam != 0){
                Servicio.codigoMax = getBalneario().getServicios().get( tam - 1 ).getCodigo() + 1;
            }
        }
        menu();
    }
    
    /**
     * Guarda los datos del programa en el archivo de configuración
     */
    public void cerrar(){
        getBalneario().guardarDatos();
        System.out.println("Gracias por usar esta aplicación.");
    }
    
    @Override
    public void opciones(byte respuesta){
        if(respuesta != 0){
            menus.get(respuesta - 1).menu();
        }else{
            cerrar();
        }
    }
    
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        
        menu.iniciar();
    }
}
