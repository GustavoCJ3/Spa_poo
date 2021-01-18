package menus;

import factorias.FactoryReserva;
import reservas.Reserva;

/**
 *
 * @author maxpi
 */
public class MenuReservas extends Menu{
    
    public MenuReservas(){
        super("1. Listado de todas las reservas\n"
                    + "2. Información de una reserva\n"
                    + "3. Añadir una reserva\n"
                    + "4. Eliminar una reserva\n"
                    + "5. Guardar cambios\n"
                    + "0. Volver\n"
                    + "\nElige una opción: ", 5);
        
    }
    
    private void listaReservas(){
        for(Reserva r: getBalneario().getReservas()){
            System.out.println("\n\nNúmero de reserva: " + r.getNumReserva()
                    + "." + r.infoReserva());
        }  
    }
    
    private void listaReservas(int numReserva){
        for(Reserva r: getBalneario().getReservas()){
            if (r.getNumReserva() == numReserva) {
            System.out.println("Número de reserva: " + numReserva
                    + "." + r.infoReserva());
            return;
            }
        }
        return;
    }
    
    private void agregarReserva(){
        int idReserva = 0;
        String descripcion;
        float coste;
        FactoryReserva fr;
        
        //Generamos automáticamente un Id nuevo y no repetido
        boolean duplicado = false;
        do {        
            for(Reserva r: getBalneario().getReservas()){
                if(r.getNumReserva() == idReserva) {
                    duplicado = true;
                    idReserva++;
                } else {
                    duplicado = false;
                }
            }
        } while(duplicado);        
        
        fr = new FactoryReserva();
        getBalneario().getReservas().add(fr.getInstancia(Integer.toString(idReserva), getBalneario()));
        System.out.println("Reserva añadida.\n");

    }
    
    private void eliminarReserva(int numReserva){
        for(Reserva r: getBalneario().getReservas()){
            if(r.getNumReserva() == numReserva) {
                int i = getBalneario().getReservas().indexOf(r);
                getBalneario().getReservas().remove(r);
                return;
            }
        }
        return;
        
        //TODO eliminar tb de los array propios de cada ReservaHabitacion
        
        /*
        for(Servicio s: getBalneario().getServicios()){
            if(s.getCodigo() == id) {
                getBalneario().getServicios().remove(s);
                return;
            }
        }
        System.out.println("No existe ningún servicio con el código indicado.\n");
        */
        
        
        
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaReservas();
                break;
            case 2:
                //listaReservas(Reserva.pedirId());
                break;
            case 3:
                agregarReserva();
                break;
            case 4:
                //eliminarReserva(); //TODO
                break;
            case 5:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
