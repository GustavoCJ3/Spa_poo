package clientes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        return "DNI: " + dni
                + "\nNombre y Apellidos: " + nombreApellidos
                + "\nTeléfono Móvil: " + telefonoMovil + "\n";
    }

    public static String pedirId(){
        boolean flag = true;
        BufferedReader br;
        String dni = " ";
        
        do {
            System.out.println("Introduce el DNI del cliente: ");
            try {
                br = new BufferedReader(new InputStreamReader(System.in),1);
                dni = br.readLine();
                
                //Validar
                if (!validaDni(dni)) {
                    throw new Exception();
                }                            
                
                flag = false;
            }
            catch (Exception e) {
                System.out.println("Error de formato, vuelve a intentarlo (un DNI consiste de 8 dígitos y una letra).");
            }
        } while (flag);         
        
        return dni;
    }
    
    public static boolean validaDni(String dni) {
        if (dni.length() != 9) {
            return false;
        }
        
        //Va a ser más rápido comprobar con regex que ir caso a caso
        if (dni.matches("\\d{8}[A-Za-z]")) {
            return true;
        }
        
        return false;
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
