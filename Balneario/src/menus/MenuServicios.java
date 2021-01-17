package menus;

import servicios.FactoryServicio;
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
            System.out.println("\n\nCódigo de servicio: " + s.getCodigo()
                    + "." + s.infoServicio());
        }
    }
    
    private void listaServicios(int codigo) {
        for(Servicio s: getBalneario().getServicios()){
            if (s.getCodigo() == codigo) {
            System.out.println("Código de servicio: " + codigo
                    + s.infoServicio());
            return;
            }
        }
    }
    
    private void agregarServicio(){
        int idServicio = 0;
        String descripcion;
        float coste;
        
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
        
        getBalneario().getServicios().add(FactoryServicio.getServicio(idServicio));
        System.out.println("Servicio añadido.");

    }
    
    private void eliminarServicio(int id){     
        for(Servicio s: getBalneario().getServicios()){
            if(s.getCodigo() == id) {
                int i = getBalneario().getServicios().indexOf(s);
                getBalneario().getServicios().remove(s);
            }
        }
        return;
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
