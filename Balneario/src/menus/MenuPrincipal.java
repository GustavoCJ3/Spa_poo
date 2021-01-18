package menus;
import java.util.ArrayList;

/**
 *
 * @author maxpi
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
    
    public void iniciar(){
        getBalneario().cargarDatos();
        menu();
    }
    
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
