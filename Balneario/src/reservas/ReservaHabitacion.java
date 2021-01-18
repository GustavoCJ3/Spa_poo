package reservas;

import clientes.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ro
 */
public class ReservaHabitacion extends Reserva{
    //Atributos
    private LocalDate diaFin;
    private ArrayList<Reserva> reservasSpa = new ArrayList<Reserva>(); //Tipo Reserva en vez de ReservaSpa porque usamos patrón Composite
    
    
    //Constructores
    public ReservaHabitacion(int numReserva, int numHabitacion, LocalDate diaInicio, float coste, Cliente cliente, LocalDate diaFin){
        super(numReserva, numHabitacion, diaInicio, coste, cliente);
        this.diaFin = diaFin;        
    }
    
    //Métodos
    public String infoReserva(){
        String concatReservasSpa = "";
        for(Reserva rs: reservasSpa){
            concatReservasSpa = concatReservasSpa + rs.infoReserva();
        }
        
        return "Identificador de reserva: " + getNumReserva()
                + "Número de habitación: " + getNumHabitacion()
                + "\nDía de inicio: " + getDiaInicio()
                + "\nCoste de la habitación: " + getCoste()
                + "\nCoste total de servicios: " + getCosteTotal()
                + "\nDía de fin de reserva: " + diaFin
                + concatReservasSpa;
    }
    
    public float getCosteTotal() {
        float total = 0;
        for(Reserva rs: reservasSpa){
            total = total + rs.getCoste();
        }
        return total;
    }
    
    public void agregar(Reserva r){
        reservasSpa.add(r);
        System.out.println("Se ha agregado Reserva de Spa: " + r.getNumReserva()
                + " a la Reserva de Habitación: " + getNumReserva()
                + ", con número de habitación: " + getNumHabitacion() + "\n");
    }
    
    public void eliminar(Reserva r){
        //TODO
        //System.out.println(".\n");
    }
    
    
    //Getters y Setters
   
}
