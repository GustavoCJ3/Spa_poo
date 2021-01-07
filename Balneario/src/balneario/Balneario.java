/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balneario;
import java.util.ArrayList;
/**
 *
 * @author maxpi
 */
public class Balneario {
    private Balneario instancia;
    private final ArrayList<Habitacion> habitaciones= new ArrayList();
    
    private Balneario(){}
    
    public Balneario getInstancia(){
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
        return true;
    }
    
    public static boolean guardarDatos(){
        return true;
    }
    
    public void agregarHabitacion(){
        
    }
    
    public void eliminarHabitacion(){
        
    }
    
    public static void main(String[] args) {
        
    }
    
}
