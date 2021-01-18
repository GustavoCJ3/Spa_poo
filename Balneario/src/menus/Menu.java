package menus;

import balneario.Balneario;
import java.util.Scanner;

/**
 * Muestra y gestiona las funciones con las que puede interactuar el usuario.
 * @author Gustavo Cortés Jiménez
 * @author Rodrigo Lázaro Escudero
 */
public abstract class Menu {
    private final Balneario balneario;
    private final String mensaje;
    private final int max;
    
    /**
     *
     * @param mensaje Opciones que muestra el menú
     * @param max número máximo de opción
     */
    public Menu(String mensaje, int max){
        balneario = Balneario.getInstancia();
        this.mensaje = mensaje;
        this.max = max;
    }

    //getters
    public Balneario getBalneario() {
        return balneario;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public int getMax() {
        return max;
    }
    
    /**
     * Muestra las opciones disponibles, y ejecuta una de ellas según la respuesta recibida
     */
    public void menu(){
        byte respuesta = 0;
        boolean flag = true;
        
        do{
            System.out.print(getMensaje());
            do{
                try{
                    flag = true;
                    Scanner sc = new Scanner(System.in);
                    respuesta = sc.nextByte();

                    if( (respuesta > getMax()) || (respuesta < 0)){
                        throw new Exception();
                    }else{
                        flag = false;
                    }
                }catch(Exception e){
                    System.out.println("\nPor favor, introduce una opción válida.\n");
                }

            }while(flag);
            
            opciones(respuesta);
            
        }while(respuesta != 0);
    }
    
    /**
     * Llama a la función correspondiente a la respuesta recibida
     * @param respuesta la opción elegida por el usuario
     * @pre respuesta debe estar entre 0 y max
     */
    public abstract void opciones(byte respuesta);
}
