package reservas;

import java.time.LocalDate;

/**
 *
 * @author Ro
 */
public abstract class Reserva {
    //Atributos
    private int numReserva;
    private int numHabitacion;
    private LocalDate diaInicio;
    private float coste;
    private int total; //static?
    
    
    //Constructores
    public Reserva(int numReserva, int numHabitacion, LocalDate diaInicio, float coste, int total) {
        this.numReserva = numReserva;
        this.numHabitacion = numHabitacion;
        this.diaInicio = diaInicio;
        this.coste = coste;
        this.total = total;
    }
    
    
    //Métodos
    public abstract String infoReserva();
    
    
    //Getters y Setters
    public int getNumReserva() {
        return numReserva;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public LocalDate getDiaInicio() {
        return diaInicio;
    }

    public float getCoste() {
        return coste;
    }

    public int getTotal() { //static?
        return total;
    }
    
    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public void setDiaInicio(LocalDate diaInicio) {
        this.diaInicio = diaInicio;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }
    
    public void setTotal() { //static?
        this.total = total;
    }

}
