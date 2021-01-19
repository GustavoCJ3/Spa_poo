package menus;

import factorias.FactoryReserva;
import reservas.Reserva;
import reservas.ReservaHabitacion;
import reservas.ReservaSpa;

/**
 * Permite al usuario acceder a las funciones que actúan sobre las reservas.
 * @author Gustavo Cortés Jiménez
 * @author Rodrigo Lázaro Escudero
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
    
    /**
     * Muestra los datos de todas las reservas guardadas
     */
    private void listaReservas(){
        if(getBalneario().getReservas().isEmpty()){
            System.out.println("\nNo hay reservas registradas.\n");
        }else{   
            for(Reserva r: getBalneario().getReservas()){
                System.out.println(r.infoReserva());
            }  
        }
    }
    
    /**
     * Muestra los datos de una reserva
     * @param numReserva El número de la reserva que mostrar
     */
    private void listaReservas(int numReserva){
        Reserva r = getBalneario().buscarReserva(numReserva);
        if (r != null){
            System.out.println(r.infoReserva());
            return;
        }
        
        System.out.println("No existe ninguna reserva con el número indicado.\n");
    }
    
    /**
     * Crea y añade una nueva reserva al sistema.
     */
    private void agregarReserva(){
        int idReserva = Reserva.numMaxReserva++;
        FactoryReserva fr = new FactoryReserva();
        
        Reserva reserva = fr.getInstancia(Integer.toString(idReserva));
        
        if (reserva != null) {
            getBalneario().getReservas().add(reserva);
            System.out.println("Reserva añadida.\n");
        } else {
            System.out.println("La reserva NO se ha creado. Por favor verifique que las habitaciones, clientes y servicios necesarios "
                    + "estén registrados previamente en el sistema.\n");
            Reserva.numMaxReserva--;
        }
        
    }
    
    /**
     * Elimina una reserva almacenada en el sistema
     */
    private void eliminarReserva(int numReserva){    
        Reserva r = getBalneario().buscarReserva(numReserva);
        if (r != null){
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
