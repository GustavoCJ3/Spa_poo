package ahabitaciones;


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
        System.out.println("Habitacion doble");
        super.infoHabitacion();
        
        if (banoCompartido){
            System.out.println("El baño está compartido");
        }else{
            System.out.println("El baño es privado");
        }
    }
}
