package reservas;

import clientes.Cliente;
import servicios.Servicio;
import java.time.LocalDate;

/**
 *
 * @author Ro
 */
public class ReservaSpa extends Reserva{
    //Atributos
    private LocalDate diaServicio;
    private Servicio servicio;
    private byte numPersonas;
    
    
    //Constructores
    public ReservaSpa(int numReserva, int numHabitacion, LocalDate diaInicio, float coste, LocalDate diaServicio, Servicio servicio, byte numPersonas){
        super(numReserva, numHabitacion, diaInicio, coste);
        this.diaServicio = diaServicio;
        this.servicio = servicio;
        this.numPersonas = numPersonas;
    }
    
    
    //Métodos
    public String infoReserva(){
        return "Identificador de reserva: " + getNumReserva()
                + "\nCódigo del servicio: " + servicio.getCodigo()
                + "\nDescripción del servicio: " + servicio.getDescripcion()
                + "\nCoste base del servicio: " + getCoste()
                + "\nCoste total del servicio (coste base * número de personas): " + getCosteTotal()
                + "\nDía servicio: " + diaServicio
                + "\nNúmero de personas: " + numPersonas + "\n";
    }
    
    public float getCosteTotal() {
        return getCoste() * numPersonas;
    }    
    
    public void agregar(Reserva r){
        System.out.println("Error. Las Reservas de Spa no tienen sub-reservas.\n");
    }
    
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

}
