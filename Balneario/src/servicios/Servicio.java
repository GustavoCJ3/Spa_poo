package servicios;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Contiene la información y las funciones de un servicio.
 * @author Gustavo Cortés Jiménez.
 * @author Rodrigo Lázaro Escudero.
 */
public class Servicio implements Serializable{
    //Atributos
    public static int codigoMax = 0;
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
    
    /**
     * Muestra la información de la habitación.
     * @return los datos de la factura.
     */
    public String infoServicio(){
        return "Código de servicio: " + codigo
                + "\nDescripción: " + descripcion
                + "\nCoste: " + coste + " euros.\n";
    }

    /**
     * Pide un código de un servicio.
     * @return un código de servicio.
     */
    public static int pedirId(){
        int id = 0;
        boolean flag = true;
        Scanner sc;
        
        do{
            System.out.println("Introduce el código del servicio: ");
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
