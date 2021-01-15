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
        
        
        /* //TODO quitarlo luego. Pruebas. Sólo MenuServicios es funcional de momento
        MenuReservas mr = new MenuReservas();
        MenuServicios ms = new MenuServicios();
        
        ms.agregarServicio("Baño relajante", 10);
        ms.agregarServicio("Baño relajante2", 20);
        ms.agregarServicio("Baño relajante3", 30);
        ms.agregarServicio("Baño relajante4", 40);
        ms.agregarServicio("Baño relajante5", 50);
        
        ms.listaServicios();
        ms.listaServicios(3);
        
        ms.eliminarServicio(2);
        ms.eliminarServicio(4);
        ms.listaServicios();
        /////////////////////// */
        
        
        
        menu.iniciar();
    }
}
