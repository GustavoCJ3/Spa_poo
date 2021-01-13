/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balneario;
import Habitaciones.*;
import java.util.ArrayList;
/**
 *
 * @author maxpi
 */
public class Balneario {
    private static Balneario instancia;
    private final ArrayList<Habitacion> habitaciones= new ArrayList();
    
    private Balneario(){}
    
    public static Balneario getInstancia(){
        if(instancia == null){
            instancia = new Balneario();
        }
        
        return instancia;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
    
    public boolean cargarDatos(){
        System.out.println("Datos cargados");
        return true;
    }
    
    public boolean guardarDatos(){
        System.out.println("\nDatos guardados\n");
        return true;
    }
    
}
