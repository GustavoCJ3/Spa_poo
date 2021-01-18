package menus;

import factorias.FactoryServicio;
import servicios.Servicio;

/**
 *
 * @author maxpi
 */
public class MenuServicios extends Menu{
  
    public MenuServicios(){
        super("1. Listado de todos los servicios\n"
                    + "2. Información de un servicio\n"
                    + "3. Añadir un servicio\n"
                    + "4. Eliminar un servicio\n"
                    + "5. Guardar cambios\n"
                    + "0. Volver\n"
                    + "\nElige una opción: ", 5);
        
    }
    
    private void listaServicios() {
        for(Servicio s: getBalneario().getServicios()){
            System.out.println(s.infoServicio());
        }
    }
    
    private void listaServicios(int codigo) {        
        for(Servicio s: getBalneario().getServicios()){
            if (s.getCodigo() == codigo) {
                System.out.println(s.infoServicio());
            return;
            }
        }
        System.out.println("No existe ningún servicio con el código indicado.\n");
    }
    
    private void agregarServicio(){
        int idServicio = 0;
        String descripcion;
        float coste;
        FactoryServicio fs;
        
        //Generamos automáticamente un Id nuevo y no repetido
        boolean duplicado = false;
        do {        
            for(Servicio s: getBalneario().getServicios()){
                if(s.getCodigo() == idServicio) {
                    duplicado = true;
                    idServicio++;
                } else {
                    duplicado = false;
                }
            }
        } while(duplicado);        
        
        fs = new FactoryServicio(); //TODO ver si se pudiera hacer esto de modo estático para ahorrar tneer que instanciar la factoría
        getBalneario().getServicios().add(fs.getInstancia(Integer.toString(idServicio)));
        System.out.println("Servicio añadido.\n");

    }
    
    private void eliminarServicio(int id){
        //TODO asegurar integridad estrucutura. No dejará borrar Servicios o Habitaciones si hay Reservas de los mismos.
        for(Servicio s: getBalneario().getServicios()){
            if(s.getCodigo() == id) {
                getBalneario().getServicios().remove(s);
                return;
            }
        }
        System.out.println("No existe ningún servicio con el código indicado.\n");
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaServicios();
                break;
            case 2:
                listaServicios(Servicio.pedirId());
                break;
            case 3:
                agregarServicio();
                break;
            case 4:
                eliminarServicio(Servicio.pedirId());
                break;
            case 5:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
