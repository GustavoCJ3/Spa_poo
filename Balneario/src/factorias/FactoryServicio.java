package factorias;

import java.util.Scanner;
import java.io.*;
import servicios.Servicio;

/**
 * Se encarga del proceso de creación de Servicios
 * @author Gustavo Cortés Jiménez.
 * @author Rodrigo Lázaro Escudero.
 */

public class FactoryServicio implements Factoria<Servicio>{
    
    @Override
    public Servicio getInstancia(String idServicio){
        String descripcion = " ";
        float coste = 0f;
        boolean flag = true;
        BufferedReader br;
        Scanner sc;
        
        System.out.println("Introduce una descripción del servicio:\n");             
        do {
            try {
                //TODO problemas de codificación al meterle caracters no ASCII. Arreglar.
                br = new BufferedReader(new InputStreamReader(System.in),1);
                descripcion = br.readLine();
                flag = false;
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error de lectura. Vuelve a intentarlo.");
            }
        } while (flag);     
        
        System.out.println("Introduce el coste del servicio (usar coma): \n");     
        flag = true;
        do{
            try {
                sc = new Scanner(System.in);
                coste = sc.nextFloat();
                if (coste < 0){
                    System.out.println("\nEl precio debe ser superior a 0.");
                }else{
                    flag = false;
                }
            } catch(Exception e) {
                System.out.println("\nEl coste del servicio debe ser un dato de tipo float. Inténtalo otra vez:\n");
            }
        }while(flag);        
        
        Servicio servicio = new Servicio(Integer.parseInt(idServicio), descripcion, coste);
        
        return servicio;
    }

}