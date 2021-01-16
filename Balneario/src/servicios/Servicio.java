package servicios;

import java.io.Serializable;

/**
 *
 * @author Ro
 */
public class Servicio implements Serializable{
    //Atributos
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
    public String infoServicio(){
        return "\nDescripción: " + descripcion
                + "\nCoste: " + coste;
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
