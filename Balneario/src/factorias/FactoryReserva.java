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

//TODO comprobaciones adicionales de solapamientos de fechas

/**
 * Se encarga del proceso de creación de Reservas
 * @author Gustavo Cortés Jiménez.
 * @author Rodrigo Lázaro Escudero.
 */
public class FactoryReserva implements Factoria<Reserva>{
    
    @Override
    public Reserva getInstancia(String idReserva){
        
        final int MAX_PERSONAS = 10;
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
        Habitacion h = Balneario.getInstancia().buscarHabitacion(numHabitacion);
        if (h != null){
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
                System.out.println("\nError, fecha inválida. El formato de la fecha debe ser aaaa-mm-dd (Ejemplo: 2000-10-25).\n");
            }
        }while(flag);
        
        System.out.println("Introduce el tipo de reserva:\n"
                + "1. Reserva de habitación.\n"
                + "2. Reserva de servicio de Spa.\n");
        flag = true;
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

            Servicio servicio = null;
            ReservaHabitacion reservaPadre = null;
            int codigoServicio;
            LocalDate diaServicio = LocalDate.now();
            byte numPersonas = 0;
            
            //Comprobar lo primero de todo que la habitación indicada está reservada.
            flag = false;
            for (Reserva r : Balneario.getInstancia().getReservas()) {
                //Comprobamos que el número de habitación coincida y que la clase sea ReservaHabitacion
                if ((r.getNumHabitacion() == numHabitacion) && (r instanceof ReservaHabitacion)){
                    reservaPadre = (ReservaHabitacion)r;
                                        
                    flag = true;
                }
            }        
            if (!flag) {
                System.out.println("No se puede reservar servicio de spa para esa habitación porque dicha habitación no está reservada por nadie.\n");

                return null;
            }  
            
            //Pedir código servicio y comprobar si existe
            codigoServicio = Servicio.pedirId();            
            Servicio s = Balneario.getInstancia().buscarServicio(codigoServicio);
            if (s == null){
                System.out.println("El servicio indicado no está registrado en el sistema. Regístrelo primero antes de usarlo.\n");
                return null;
            }
            
            //Pedir fecha del servicio
            System.out.println("Introduce la fecha para reservar servicio de spa (formato aaaa-mm-dd): \n");     
            do{
                try {
                    br = new BufferedReader(new InputStreamReader(System.in),1);
                    diaServicio = LocalDate.parse(br.readLine());
                    flag = false;
                } catch(Exception e) {
                    System.out.println("\nError, fecha inválida. El formato de la fecha debe ser aaaa-mm-dd (Ejemplo: 2000-10-25).\n");
                }
            }while(flag);
            //TODO comprobaciones adicionales de solapamientos de fechas, servicios, etc.

            //Pedir número de personas
            System.out.println("Introduce el número de personas que atenderán al servicio: \n");
            do{
                try{
                    sc = new Scanner(System.in);
                    numPersonas = sc.nextByte();

                    if ( (numPersonas < 1) || (numPersonas > MAX_PERSONAS)){
                        throw new Exception();
                    }else{
                        flag = false;
                    }
                }catch(Exception e){
                    System.out.println("\nPor favor, introduce un número entre 1 y " + MAX_PERSONAS + " (inclusive).\n");
                }
            }while(flag);
            
            ReservaSpa reserva = new ReservaSpa(numReserva, numHabitacion, diaInicio, servicio.getCoste(), diaServicio, servicio, numPersonas, reservaPadre);
            
            //Referenciamos la ReservaSpa creada en su ReservaHabitacion padre
            reservaPadre.agregar(reserva);

            return (Reserva)reserva;
            
        } else { //opcion == 1
            
            System.out.println("¿A nombre de quién se hace la reserva?\n");
            String idCliente = Cliente.pedirId();
            LocalDate diaFin = LocalDate.now();

            
            
            //Comprobamos que el DNI esté registrado en el sistema        
            Cliente c = Balneario.getInstancia().buscarCliente(idCliente);
            if (c == null){
                //Si el cliente no existe, indicamos al usuario que lo cree primero
                System.out.println("El DNI del cliente indicado no está registrado en el sistema. Regístrelo antes de hacer la reserva a su nombre.\n");
                return null;
            }

            System.out.println("Introduce la fecha de finalización de la reserva (formato aaaa-mm-dd): \n");     
            do{
                try {
                    br = new BufferedReader(new InputStreamReader(System.in),1);
                    diaFin = LocalDate.parse(br.readLine());
                    flag = false;
                } catch(Exception e) {
                    System.out.println("\nError, fecha inválida. El formato de la fecha debe ser aaaa-mm-dd (Ejemplo: 2000-10-25)."
                            + "Además, la fecha de fin de reserva debe ser superior a la fecha de inicio.\n");
                }
            }while(flag);

            //Buscamos el coste de la habitación
            Habitacion hab = Balneario.getInstancia().buscarHabitacion(numHabitacion);
            coste = hab.getPrecio();

            ReservaHabitacion reserva = new ReservaHabitacion(numReserva, numHabitacion, diaInicio, coste, c, diaFin);                                        
            return (Reserva)reserva;
        }  
    }    
}
