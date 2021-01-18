package menus;

import factorias.FactoryReserva;
import reservas.Reserva;
import reservas.ReservaHabitacion;
import reservas.ReservaSpa;

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
        if(getBalneario().getReservas().isEmpty()){
            System.out.println("\nNo hay reservas registradas.\n");
        }else{   
            for(Reserva r: getBalneario().getReservas()){
                System.out.println(r.infoReserva());
            }  
        }
    }
    
    private void listaReservas(int numReserva){
        for(Reserva r: getBalneario().getReservas()){
            if (r.getNumReserva() == numReserva) {
                System.out.println(r.infoReserva());
            return;
            }
        }
        System.out.println("No existe ninguna reserva con el número indicado.\n");
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
        Reserva reserva = fr.getInstancia(Integer.toString(idReserva));
        if (reserva != null) {
            getBalneario().getReservas().add(reserva);
            System.out.println("Reserva añadida.\n");
        } else {
            System.out.println("La reserva NO se ha creado. Por favor verifique que las habitaciones, clientes y servicios necesarios"
                    + "estén registrados previamente en el sistema.\n");
        }
        
    }
    
    private void eliminarReserva(int numReserva){        
        for(Reserva r: getBalneario().getReservas()){
            if(r.getNumReserva() == numReserva) {
                
                //Si es una ReservaSpa, eliminar de la lista del padre
                if (r instanceof ReservaSpa) {
                    ReservaHabitacion padre = ((ReservaSpa) r).getPadre();
                    padre.eliminar(r);
                } else { //Si es una ReservaHabitacion, eliminar todas las reservasSpa que contiene
                    for (Reserva rs: ((ReservaHabitacion)r).getReservasSpa()) {
                        getBalneario().getReservas().remove(rs);
                    }
                }
                
                //Finalmente, eliminar el propio nodo
                getBalneario().getReservas().remove(r);
                
                return;
            }
        }
        System.out.println("No existe ninguna reserva con el código indicado.\n");
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaReservas();
                break;
            case 2:
                listaReservas(Reserva.pedirId());
                break;
            case 3:
                agregarReserva();
                break;
            case 4:
                System.out.println("ATENCIÓN: eliminar una reserva de habitación eliminará todos los servicios de Spa asociados a esa reserva.");
                eliminarReserva(Reserva.pedirId());
                break;
            case 5:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
