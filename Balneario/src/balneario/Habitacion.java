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
        System.out.println("Numero de habitación: " + getNumero());
        System.out.println("Precio de la habitación: " + getPrecio());
    }
}
