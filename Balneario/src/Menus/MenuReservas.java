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
public class MenuReservas extends Menu{
    
    public MenuReservas(){
        super("1. Listado de todas las reservas\n"
                    + "2. Información de una reserva\n"
                    + "3. Añadir una reserva\n"
                    + "4. Eliminar una reserva\n"
                    + "5. Guardar cambios\n"
                    + "0. Volver\n"
                    + "\nElige una opción: ", 5);
        
    }
    
    private void listaReservas(){
        
    }
    
    private void listaReservas(int numReserva){
    
    }
    
    private void agregarReserva(){
        
    }
    
    private void eliminarReserva(){
        
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaReservas();
                break;
            case 2:
                listaReservas();
                break;
            case 3:
                agregarReserva();
                break;
            case 4:
                eliminarReserva();
                break;
            case 5:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
