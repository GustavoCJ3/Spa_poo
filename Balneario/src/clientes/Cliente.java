package clientes;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Ro
 */
public class Cliente implements Serializable{
    //Atributos
    private String dni;
    private String nombreApellidos;
    private String telefonoMovil;
    
    
    //Constructores
    public Cliente(String dni, String nombreApellidos, String telefonoMovil) {
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
        this.telefonoMovil = telefonoMovil;
    }

    
    
    //Métodos    
    public String infoCliente(){
        return "\nDNI: " + dni
                + "\nNombre y Apellidos: " + nombreApellidos
                + "\nTeléfono Móvil: " + telefonoMovil;
    }

    public static int pedirId(){
        int id = 0;
        boolean flag = true;
        
        do{
            System.out.println("Introduce el código del servicio deseado: ");
            try{
                Scanner sc = new Scanner(System.in);
                id = sc.nextInt();
               
            }catch(Exception e){
                System.out.println("\nEl valor introducido no es un numero\n");
            }

        }while(flag);
        
        return id;
    }
    
    //Getters y Setters    
    //TODO: generar código automáticamente para los que hagan falta.
    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public String getDni() {
        return dni;
    }
    
}
