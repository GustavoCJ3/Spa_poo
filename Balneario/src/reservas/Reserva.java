package reservas;

import clientes.Cliente;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Ro
 */
//TODO intentar encajarlo en patrón composite, una vez ya esté funcionando todo
public abstract class Reserva implements Serializable{
    //Atributos
    private int numReserva;
    private int numHabitacion;
    private LocalDate diaInicio;
    private float coste;
    private Cliente cliente;
    
    
    //Constructores
    public Reserva(int numReserva, int numHabitacion, LocalDate diaInicio, float coste, Cliente cliente) {
        this.numReserva = numReserva;
        this.numHabitacion = numHabitacion;
        this.diaInicio = diaInicio;
        this.coste = coste;
        this.cliente = cliente;
    }
    
    
    //Métodos
    public abstract String infoReserva();
    public abstract float getCosteTotal();
    public abstract void agregar(Reserva r);
    public abstract void eliminar(Reserva r);
    
    
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

}
