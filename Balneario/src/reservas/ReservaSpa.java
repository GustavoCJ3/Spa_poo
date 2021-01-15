package reservas;

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
    public ReservaSpa(int numReserva, int numHabitacion, LocalDate diaInicio, float coste, int total, LocalDate diaServicio, Servicio servicio, byte numPersonas){
        super(numReserva, numHabitacion, diaInicio, coste, total);
        this.diaServicio = diaServicio;
        this.servicio = servicio;
        this.numPersonas = numPersonas;
    }
    
    
    //Métodos
    public String infoReserva(){ //TODO: faltan cosas, esto es placeholder
        return "\nNúmero de habitación: " + getNumHabitacion()
                + "\nDía de inicio: " + getDiaInicio()
                + "\nCoste: " + getCoste()
                + "\nTotal: " + getTotal()
                + "\nDía servicio: " + diaServicio
                + "\nServicio: " + servicio
                + "\nNúmero de personas: " + numPersonas;
    }
    
    //Getters y Setters
    public LocalDate getDiaServicio() {
        return diaServicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public byte getNumPersonas() {
        return numPersonas;
    }

    public void setDiaServicio(LocalDate diaServicio) {
        this.diaServicio = diaServicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setNumPersonas(byte numPersonas) {
        this.numPersonas = numPersonas;
    }
    
}
