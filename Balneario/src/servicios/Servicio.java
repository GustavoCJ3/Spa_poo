package servicios;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Ro
 */
public class Servicio implements Serializable{
    //Atributos
    private int codigo;
    private String descripcion;
    private float coste;
    
    
    //Constructores
    public Servicio(int codigo, String descripcion, float coste) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.coste = coste;
    }
    
    
    //Métodos    
    public String infoServicio(){
        return "\nDescripción: " + descripcion
                + "\nCoste: " + coste;
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
    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getCoste() {
        return coste;
    }
    
}
