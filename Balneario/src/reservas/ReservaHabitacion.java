package reservas;

import clientes.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Concreta la reserva de una habitación.
 * @author Gustavo Cortés Jiménez.
 * @author Rodrigo Lázaro Escudero.
 */
public class ReservaHabitacion extends Reserva{
    //Atributos
    private Cliente cliente;
    private LocalDate diaFin;
    private ArrayList<Reserva> reservasSpa = new ArrayList<Reserva>(); //Tipo Reserva en vez de ReservaSpa porque usamos patrón Composite
    
    
    //Constructores
    public ReservaHabitacion(int numReserva, int numHabitacion, LocalDate diaInicio, float coste, Cliente cliente, LocalDate diaFin){
        super(numReserva, numHabitacion, diaInicio, coste);
        this.cliente = cliente;
        this.diaFin = diaFin;        
    }
    
    //Métodos
    @Override
    public String infoReserva(){
        String concatReservasSpa = "\n";
        for(Reserva rs: reservasSpa){
            concatReservasSpa = concatReservasSpa + rs.infoReserva();
        }
        
        return "Identificador de reserva: " + getNumReserva()
                + "\nNúmero de habitación: " + getNumHabitacion()
                + "\nDía de inicio: " + getDiaInicio()
                + "\nCoste de la habitación: " + getCoste()
                + "\nCoste total de habitación + servicios: " + getCosteTotal()
                + "\nDía de fin de reserva: " + diaFin
                + "\nServicios de Spa asociados: " + concatReservasSpa;
    }
    
    @Override
    public float getCosteTotal() {
        float total = getCoste();
        for(Reserva rs: reservasSpa){
            total = total + rs.getCoste();
        }
        return total;
    }
    
    @Override
    public void agregar(Reserva r){
        reservasSpa.add(r);
        System.out.println("Se ha agregado Reserva de Spa: " + r.getNumReserva()
                + " a la Reserva de Habitación: " + getNumReserva()
                + ", con número de habitación: " + getNumHabitacion() + "\n");
    }
    
    @Override
    public void eliminar(Reserva r){
        reservasSpa.remove(r);
        System.out.println("Se ha eliminado la Reserva de Spa: " + r.getNumReserva()
                + " de Reserva de Habitación: " + getNumReserva()
                + ", con número de habitación: " + getNumHabitacion() + "\n");
    }
    
    
    //Getters y Setters
    public ArrayList<Reserva> getReservasSpa() {
        return reservasSpa;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
