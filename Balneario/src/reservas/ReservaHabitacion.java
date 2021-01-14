package reservas;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ro
 */
public class ReservaHabitacion extends Reserva{
    //Atributos
    private LocalDate diaFin;
    private ArrayList<ReservaSpa> reservasSpa = new ArrayList<ReservaSpa>();
    
    
    //Constructores
    public ReservaHabitacion(int numReserva, int numHabitacion, LocalDate diaInicio, float coste, int total, LocalDate diaFin){
        super(numReserva, numHabitacion, diaInicio, coste, total);
        this.diaFin = diaFin;        
    }
    
    //Métodos
    public String infoReserva(){//TODO: faltan cosas, esto es placeholder
        return "\nNúmero de habitación: " + getNumHabitacion()
                + "\nDía de inicio: " + getDiaInicio()
                + "\nCoste: " + getCoste()
                + "\nTotal: " + getTotal()
                + "\nDía de fin de reserva: "
                + ""; //reservasSpa
    }
    
    //Getters y Setters
    public LocalDate getDiaFin() {
        return diaFin;
    }

    public ArrayList<ReservaSpa> getReservasSpa() {
        return reservasSpa;
    }

    public void setDiaFin(LocalDate diaFin) {
        this.diaFin = diaFin;
    }

    public void setReservasSpa(ArrayList<ReservaSpa> reservasSpa) {
        this.reservasSpa = reservasSpa;
    }
    
}
