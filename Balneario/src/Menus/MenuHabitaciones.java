/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 *
 * @author maxpi
 */
public class MenuHabitaciones extends Menu{
    
    public MenuHabitaciones(){
        super("1. Listado de todas las habitaciones\n"
                    + "2. Información de una habitación\n"
                    + "3. Añadir una habitación\n"
                    + "4. Eliminar una habitación\n"
                    + "5. Guardar cambios\n"
                    + "0. Volver\n"
                    + "\nElige una opción: ", 5);
        
    }
    
    private void listaHabitaciones(){
        
    }
    
    private void listaHabitaciones(int numHabitacion){
    
    }
    
    private void agregarHabitacion(){
        
    }
    
    private void eliminarHabitacion(){
        
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaHabitaciones();
                break;
            case 2:
                listaHabitaciones();
                break;
            case 3:
                agregarHabitacion();
                break;
            case 4:
                eliminarHabitacion();
                break;
            case 5:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
