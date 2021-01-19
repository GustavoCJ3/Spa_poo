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
        if (h == null){
            System.out.println("La habitación indicada no está registrada en el sistema. Regístrela primero antes de usarla.\n");
            return null;
        }

        //Haremos las comprobaciones de solapamiento de fechas en las reservas más adelante,
        //al recibir las fechas de fin de reserva y de servicio, respectivamente
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
            
            //Comprobar lo primero de todo que la habitación indicada está reservada, y que la fecha de inicio de la reserva de 
            //spa coincide con la fecha de inicio de la reserva de la habitación
            flag = false;
            for (Reserva r : Balneario.getInstancia().getReservas()) {
                //r instanceof ReservaHabitacion
                //r.getNumHabitacion() == numHabitacion
                //diaInicio.isEqual(r.getDiaInicio())
                if ((r instanceof ReservaHabitacion) && (r.getNumHabitacion() == numHabitacion) && (diaInicio.isEqual(r.getDiaInicio()))){
                    reservaPadre = (ReservaHabitacion)r;
                                        
                    flag = true;
                }
            }        
            if (!flag) {
                System.out.println("No se puede reservar servicio de spa para esa habitación en ese periodo. (Debes asegurarte de que la habitación está reservada y que"
                        + "\nla fecha de inicio indicada para el servicio de spa coincide con la fecha de inicio de la habitación).\n");

                return null;
            }  
            
            //Pedir código servicio y comprobar si existe
            codigoServicio = Servicio.pedirId();
            servicio = Balneario.getInstancia().buscarServicio(codigoServicio);
            if (servicio == null){
                System.out.println("El servicio indicado no está registrado en el sistema. Regístrelo primero antes de usarlo.\n");
                return null;
            }
            
            //Pedir fecha del servicio
            System.out.println("Introduce la fecha para reservar servicio de spa (formato aaaa-mm-dd): \n");   
            flag = true;
            do{
                try {
                    br = new BufferedReader(new InputStreamReader(System.in),1);
                    diaServicio = LocalDate.parse(br.readLine());
                    
                    flag = false;
                } catch(Exception e) {
                    System.out.println("\nError, fecha inválida. El formato de la fecha debe ser aaaa-mm-dd (Ejemplo: 2000-10-25).\n");
                }            
            }while(flag);
            
            //Comprobamos si el servicio ya está pedido ese día, y pedimos fecha distinta de ser así
            for (Reserva r : Balneario.getInstancia().getReservas()) {
                //r instanceof ReservaSpa
                //((ReservaSpa)r).getServicio().getCodigo() == codigoServicio
                //((ReservaSpa)r).getDiaServicio() == diaServicio                        
                if ((r instanceof ReservaSpa) && (((ReservaSpa)r).getServicio().getCodigo() == codigoServicio) && (((ReservaSpa)r).getDiaServicio() == diaServicio)){
                    System.out.println("\nEl servicio no puede ser reservado ese día porque ya existe una reserva previa. Elije una fecha distinta.\n");
                    return null;
                }
            }
            
            //Comprobamos que la fecha del servicio esté dentro del intervalo en que la habitación ha sido reservada
            for (Reserva r: Balneario.getInstancia().getReservas()) {
                //Comprobamos sólo sobre reservas de habitaciones con el mismo número
                if ((r instanceof ReservaHabitacion) && (r.getNumHabitacion() == numHabitacion)){                    
                    //Comprobamos que la fecha del servicio esté comprendida en el periodo de reserva de la habitación
                    if (!fechaEntre(diaServicio, (ReservaHabitacion)r)){
                        System.out.println("Error. La reserva de spa debe estar comprendida entre el día de inicio y el día final de la reserva de habitación asociada.\n");
                        return null;
                    }
                }
            }

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
            flag = true;
            do{
                try {
                    br = new BufferedReader(new InputStreamReader(System.in),1);
                    diaFin = LocalDate.parse(br.readLine());
                    if (!(diaInicio.isBefore(diaFin))) {
                        throw new Exception();
                    }
                    flag = false;
                } catch(Exception e) {
                    System.out.println("\nLa fecha de fin de reserva debe ser superior a la fecha de inicio. "
                            + "El formato de la fecha debe ser aaaa-mm-dd (Ejemplo: 2000-10-25).\n");
                }
            }while(flag);
            
            //Comprobaciones adicionales de solapamientos de fechas
            for (Reserva r: Balneario.getInstancia().getReservas()) {
                //Comprobamos sólo sobre reservas de habitaciones con el mismo número que pudiesen generar conflictos
                if ((r instanceof ReservaHabitacion) && (r.getNumHabitacion() == numHabitacion)){                    
                    //Comprobamos que ni la fecha de inicio ni la fecha de final estén comprendidas en periodos ocupados por otras reservas
                    if (fechaEntre(diaInicio, (ReservaHabitacion)r) || fechaEntre(diaFin, (ReservaHabitacion)r)){
                        System.out.println("Error. La habitación ya estaba reservada para ese periodo. Elija fechas no ocupadas.\n");
                        return null;
                    }
                }
            }
            
            //Buscamos el coste de la habitación
            Habitacion hab = Balneario.getInstancia().buscarHabitacion(numHabitacion);
            coste = hab.getPrecio();

            ReservaHabitacion reserva = new ReservaHabitacion(numReserva, numHabitacion, diaInicio, coste, c, diaFin);                                        
            return (Reserva)reserva;          
        }  
    }    

    /**
     * Comprueba si una fecha está comprendida entre el día de inicio y el día de finalización de la ReservaHabitacion.
     * @param fecha a evaluar, ReservaHabitación rh proporciona el intervalo de fechas
     * @return true si la fecha está entre inicio y el final de la reserva rh indicada; si no, false.
     */
    public static boolean fechaEntre(LocalDate fecha, ReservaHabitacion rh) {
        //Devolvemos negación de OR en vez de comprobación sobre AND para evitar solapamientos en los días de inicio y final 
        return !(fecha.isBefore(rh.getDiaInicio()) || fecha.isAfter(rh.getDiaFin()));
    }
}


