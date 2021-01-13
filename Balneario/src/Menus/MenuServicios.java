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
public class MenuServicios extends Menu{
    
    public MenuServicios(){
        super("1. Listado de todos los servicios\n"
                    + "2. Información de un servicio\n"
                    + "3. Añadir un servicio\n"
                    + "4. Eliminar un servicio\n"
                    + "5. Guardar cambios\n"
                    + "0. Volver\n"
                    + "\nElige una opción: ", 5);
        
    }
    
    private void listaServicios(){
        
    }
    
    private void listaServicios(int codigo){
    
    }
    
    private void agregarServicio(){
        
    }
    
    private void eliminarServicio(){
        
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaServicios();
                break;
            case 2:
                listaServicios();
                break;
            case 3:
                agregarServicio();
                break;
            case 4:
                eliminarServicio();
                break;
            case 5:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
