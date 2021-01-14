package habitaciones;

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
    
    public void infoHabitacion(){
        System.out.println("Habitacion individual");
        System.out.println("Numero de habitación: " + getNumero());
        System.out.println("Precio de la habitación: " + getPrecio());
    }
}
