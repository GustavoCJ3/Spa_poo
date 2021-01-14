package habitaciones;

import java.util.Scanner;

/**
 *
 * @author maxpi
 */
public class Habitacion {
    private int numero;
    private float precio;
    
    public Habitacion(int numero, float precio){
        this.numero = numero;
        this.precio = precio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public static int pedirNumero(){
        int numero = 0;
        boolean flag = true;
        
        do{
            System.out.println("Introduce un número de habitación: ");
            try{
                Scanner sc = new Scanner(System.in);
                numero = sc.nextInt();
                if((numero < 100) || (numero > 999)){
                    System.out.println("\nEl numero debe ser de tres cifras\n");
                }else{
                    flag = false;
                }
            }catch(Exception e){
                System.out.println("\nEl valor introducido no es un numero\n");
            }

        }while(flag);
        
        return numero;
    }
    
    public void infoHabitacion(){
        System.out.println("Habitacion individual");
        System.out.println("Numero de habitación: " + getNumero());
        System.out.println("Precio de la habitación: " + getPrecio());
    }
}
