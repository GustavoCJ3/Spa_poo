package reservas;

import clientes.Cliente;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Ro
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
    public abstract String infoReserva();
    public abstract float getCosteTotal();
    public abstract void agregar(Reserva r);
    public abstract void eliminar(Reserva r);
    
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
