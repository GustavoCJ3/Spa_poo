package menus;

import balneario.Balneario;
import java.util.Scanner;

/**
 *
 * @author maxpi
 */
public abstract class Menu {
    private final Balneario balneario;
    private final String mensaje;
    private final int max;
    
    public Menu(String mensaje, int max){
        balneario = Balneario.getInstancia();
        this.mensaje = mensaje;
        this.max = max;
    }

    public Balneario getBalneario() {
        return balneario;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public int getMax() {
        return max;
    }
    
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
    
    public abstract void opciones(byte respuesta);
}
