package reservas;

import servicios.Servicio;
import java.time.LocalDate;

/**
 * Concreta una reserva del Spa.
 * @author Gustavo Cortés Jiménez.
 * @author Rodrigo Lázaro Escudero.
 */
public class ReservaSpa extends Reserva{
    //Atributos
    private LocalDate diaServicio;
    private Servicio servicio;
    private byte numPersonas;
    private ReservaHabitacion padre;
    
    
    //Constructores
    public ReservaSpa(int numReserva, int numHabitacion, LocalDate diaInicio, float coste, LocalDate diaServicio, Servicio servicio, byte numPersonas, ReservaHabitacion padre){
        super(numReserva, numHabitacion, diaInicio, coste);
        this.diaServicio = diaServicio;
        this.servicio = servicio;
        this.numPersonas = numPersonas;
        this.padre = padre;
    }
    
    
    //Métodos
    @Override
    public String infoReserva(){
        return "Identificador de reserva: " + getNumReserva()
                + "\nCódigo del servicio: " + servicio.getCodigo()
                + "\nDescripción del servicio: " + servicio.getDescripcion()
                + "\nCoste base del servicio: " + getCoste()
                + "\nCoste total del servicio (coste base * número de personas): " + getCosteTotal()
                + "\nDía servicio: " + diaServicio
                + "\nNúmero de personas: " + numPersonas + "\n";
    }
    
    @Override
    public float getCosteTotal() {
        return getCoste() * numPersonas;
    }    
    
    @Override
    /**
     * Muestra un mensaje de error.
     */
    public void agregar(Reserva r){
        System.out.println("Error. Las Reservas de Spa no tienen sub-reservas.\n");
    }
    
    /**
     * Muestra un mensaje de error.
     */
    @Override
    public void eliminar(Reserva r){
        System.out.println("Error. Las Reservas de Spa no tienen sub-reservas.\n");
    }
    
    //Getters y Setters
    public LocalDate getDiaServicio() {
        return diaServicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public ReservaHabitacion getPadre() {
        return padre;
    }

}
