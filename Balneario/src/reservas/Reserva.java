package reservas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Contiene la información y las funciones de una reserva.
 * @author Gustavo Cortés Jiménez.
 * @author Rodrigo Lázaro Escudero.
 */
public abstract class Reserva implements Serializable{
    //Atributos
    private int numReserva;
    private int numHabitacion;
    private LocalDate diaInicio;
    private float coste;
    
    
    //Constructores
    public Reserva(int numReserva, int numHabitacion, LocalDate diaInicio, float coste) {
        this.numReserva = numReserva;
        this.numHabitacion = numHabitacion;
        this.diaInicio = diaInicio;
        this.coste = coste;
    }
    
    
    //Métodos
    
    /**
     * Muestra la información de la reserva.
     * @return los datos de la reserva.
     */
    public abstract String infoReserva();
    
    /**
     * Calcula el coste del servicio.
     * @return el coste total del servicio.
     */
    public abstract float getCosteTotal();
    
    /**
     * Añade una nueva reserva al ArrayList de reservas.
     * @param r una reserva que añadir.
     */
    public abstract void agregar(Reserva r);
    
    /**
     * Elimina una reserva del ArrayList de reservas.
     * @param r una reserva que eliminar.
     */
    public abstract void eliminar(Reserva r);
    
    /**
     * Pide un número de reserva.
     * @return un número de reserva.
     */
    public static int pedirId(){
        int id = 0;
        boolean flag = true;
        Scanner sc;
        
        do{
            System.out.println("Introduce el número de la reserva: ");
            try{
                sc = new Scanner(System.in);
                id = sc.nextInt();
                
                flag = false;               
            }catch(Exception e){
                System.out.println("\nEl valor introducido debe ser un número.\n");
            }

        }while(flag);
        
        return id;
    }
    
    
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
