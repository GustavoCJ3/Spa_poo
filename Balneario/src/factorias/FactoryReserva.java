package factorias;

import java.util.Scanner;
import java.io.*;
import reservas.Reserva;

/**
 *
 * @author Ro
 */
public class FactoryReserva implements Factoria<Reserva>{
    
    public Reserva getInstancia(String idReserva){
        /* //TODO
        String descripcion = " ";
        float coste = 0f;
        boolean flag = true;
        
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),1);
        
        System.out.println("Introduce una descripción del servicio:\n");             
        do {
            try {
                descripcion = br.readLine();
                flag = false;
            }
            catch (IOException ex) {
                System.out.println("Ha ocurrido un error de lectura. Vuelve a intentarlo.");
            }
        } while (flag);     
        
        System.out.println("Introduce el coste del servicio: \n");     
        flag = true;
        do{
            try{
                coste = sc.nextFloat();
                flag = false;
            }catch(NumberFormatException e){
                System.out.println("\nEl coste del servicio debe ser un dato de tipo float. Inténtalo otra vez:\n");
            }
        }while(flag);        
        
        Servicio servicio = new Servicio(idServicio, descripcion, coste);
        */
        return null;
    }
}
