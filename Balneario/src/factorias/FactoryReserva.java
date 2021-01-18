package factorias;

import balneario.Balneario;
import clientes.Cliente;
import habitaciones.Habitacion;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import reservas.Reserva;
import reservas.ReservaHabitacion;
import reservas.ReservaSpa;
import servicios.Servicio;

/**
 *
 * @author Ro
 */
//TODO comprobaciones adicionales de solapamientos de fechas
public class FactoryReserva implements Factoria<Reserva>{
    
    public Reserva getInstancia(String idReserva, Balneario balneario){
        
        int numReserva = Integer.parseInt(idReserva);
        int numHabitacion;
        LocalDate diaInicio = LocalDate.now();
        float coste = 0f;
                
        boolean flag = true;
        BufferedReader br;
        Scanner sc;
        byte opcion = 0;
        
        numHabitacion = Habitacion.pedirNumero();
        
        //Comprobamos que la habitación especificada esté registrada en el sistema
        flag = false;
        for(Habitacion h: balneario.getHabitaciones()){
            if (h.getNumero() == numHabitacion) {
                flag = true;
            }
        }        
        if (!flag) {
            System.out.println("La habitación indicada no está registrada en el sistema. Regístrela primero antes de usarla.\n");
            
            return null;
        }
        
        System.out.println("Introduce la fecha de inicio de la reserva (formato aaaa-mm-dd): \n");     
        flag = true;
        do{
            try {
                br = new BufferedReader(new InputStreamReader(System.in),1);
                diaInicio = LocalDate.parse(br.readLine());
                flag = false;
            } catch(Exception e) {
                System.out.println("\nError. El formato de la fecha debe ser aaaa-mm-dd (Ejemplo: 2000-10-25).\n");
            }
        }while(flag);
        
        System.out.println("Introduce el tipo de reserva:\n"
                + "1. Reserva de habitación.\n"
                + "2. Reserva de servicio de Spa.\n");
        do{
            try{
                sc = new Scanner(System.in);
                opcion = sc.nextByte();
                
                if ( (opcion < 1) || (opcion > 2)){
                    throw new Exception();
                }else{
                    flag = false;
                }
            }catch(Exception e){
                System.out.println("\nPor favor, introduce una opción válida.\n");
            }
        }while(flag);
        
        //Generamos el tipo de Reserva solicitado
        if (opcion == 2) {

            LocalDate diaServicio;
            Servicio servicio;
            byte numPersonas;

        
        
            ReservaSpa reserva = new ReservaSpa(numReserva, numHabitacion, diaInicio, coste, diaServicio, servicio, numPersonas);                    

            return (Reserva)reserva;
            
        } else { //opcion == 1
            
            System.out.println("¿A nombre de quién se hace la reserva?\n");
            String idCliente = Cliente.pedirId();
            LocalDate diaFin = LocalDate.now();

            //Comprobamos que el DNI esté registrado en el sistema        
            for(Cliente c: balneario.getClientes()){
                if (c.getDni().equalsIgnoreCase(idCliente)) {
                    
                    System.out.println("Introduce la fecha de finalización de la reserva (formato aaaa-mm-dd): \n");     
                    do{
                        try {
                            br = new BufferedReader(new InputStreamReader(System.in),1);
                            diaFin = LocalDate.parse(br.readLine());
                            flag = false;
                        } catch(Exception e) {
                            System.out.println("\nError. El formato de la fecha debe ser aaaa-mm-dd (Ejemplo: 2000-10-25)."
                                    + "Además, la fecha de fin de reserva debe ser superior a la fecha de inicio.\n");
                        }
                    }while(flag);
                    
                    //Buscamos el coste de la habitación
                    for(Habitacion h: balneario.getHabitaciones()){
                        if (h.getNumero() == numHabitacion) {
                            coste = h.getPrecio();
                        }
                    }                    
                    
                    ReservaHabitacion reserva = new ReservaHabitacion(numReserva, numHabitacion, diaInicio, coste, c, diaFin);                    
                    
                    return (Reserva)reserva;
                } 
            }
            //Si el cliente no existe, indicamos al usuario que lo cree primero
            System.out.println("El DNI del cliente indicado no está registrado en el sistema. Regístrelo antes de hacer la reserva a su nombre.\n");

            return null;

        }  

    }    

}
