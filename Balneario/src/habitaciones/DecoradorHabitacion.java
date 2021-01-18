package habitaciones;

/**
 * Permite añadir características extra a una habitación
 * @author Gustavo Cortés Jiménez
 * @author Rodrigo Lázaro Escudero
 */
public abstract class DecoradorHabitacion extends Habitacion{
    private final Habitacion habitacion;
    
    public DecoradorHabitacion(Habitacion habitacion){
        super(0,0);
        this.habitacion = habitacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }
    
    @Override
    public int getNumero() {
        return habitacion.getNumero();
    }

    @Override
    public void setNumero(int numero) {
        habitacion.setNumero(numero);
    }

    @Override
    public float getPrecio() {
        return habitacion.getPrecio();
    }

    @Override
    public void setPrecio(float precio) {
        habitacion.setPrecio(precio);
    }
    
    @Override
    public void infoHabitacion(){
        System.out.println("Numero de habitación: " + getNumero());
        System.out.println("Precio de la habitación: " + getPrecio());
    }
}
