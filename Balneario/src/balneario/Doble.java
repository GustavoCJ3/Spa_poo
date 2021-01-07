/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balneario;

/**
 *
 * @author maxpi
 */
public class Doble extends DecoradorHabitacion{
    private final boolean banoCompartido;
    private static double extra = 1.15;
    
    public Doble(Habitacion habitacion, boolean banoCompartido){
        super(habitacion);
        this.banoCompartido = banoCompartido;
    }
    
    public static double getExtra() {
        return extra;
    }

    public static void setExtra(double extra) {
        Doble.extra = extra;
    }
    
    @Override
    public float getPrecio() {
        if (banoCompartido){
            return super.getPrecio();
        }
        return (float)(super.getPrecio() * getExtra());
    }
    
    @Override
    public void infoHabitacion(){
        super.infoHabitacion();
        System.out.println("Habitacion doble");
        
        if (banoCompartido){
            System.out.println("El baño está compartido");
        }else{
            System.out.println("El baño es privado");
        }
    }
}
