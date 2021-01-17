package clientes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import clientes.Cliente;

/**
 *
 * @author Ro
 */
public class FactoryCliente {
    
    public static Cliente getCliente(String idCliente){
        String nombreApellidos = " ";
        String telefonoMovil = " ";
        boolean flag = true;
        BufferedReader br;

        
        System.out.println("Introduce el nombre y apellidos del cliente:\n");             
        do {
            try {
                br = new BufferedReader(new InputStreamReader(System.in),1);
                nombreApellidos = br.readLine();
                
                flag = false;
            }
            catch (Exception e) {
                System.out.println("Ha ocurrido un error de lectura. Vuelve a intentarlo.");
            }
        } while (flag);     
        
        System.out.println("Introduce el número de teléfono móvil del cliente:\n");             
        do {
            try {
                br = new BufferedReader(new InputStreamReader(System.in),1);
                telefonoMovil = br.readLine();
                
                //TODO validación del móvil
                
                flag = false;
            }
            catch (Exception e) {
                System.out.println("Ha ocurrido un error de lectura. Vuelve a intentarlo.");
            }
        } while (flag);
        
        Cliente cliente = new Cliente(idCliente, nombreApellidos, telefonoMovil);
        
        return cliente;
    }
}
