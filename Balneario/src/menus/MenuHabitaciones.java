package menus;
import balneario.Balneario;
import habitaciones.Habitacion;
import factorias.FactoryHabitacion;
import java.util.Scanner;


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
        if(getBalneario().getHabitaciones().isEmpty()){
            System.out.println("\nNo hay habitaciones registradas\n");
        }else{
            for (Habitacion h: getBalneario().getHabitaciones()){
                h.infoHabitacion();
                System.out.println();
            }
        }
    }
    
    private void listaHabitaciones(int numHabitacion){
        for (Habitacion h: getBalneario().getHabitaciones()){
            if (h.getNumero() == numHabitacion){
                h.infoHabitacion();
                System.out.println("");
                return;
            }
        }
        System.out.println("\nLa habitación no está registrada\n");
    }
    
    private void agregarHabitacion(){
        int numero = 0;
        boolean flag = true;
        
        do{
            numero = Habitacion.pedirNumero();
            
            if (getBalneario().buscarHabitacion(numero) != null){
                System.out.println("Ya hay registrada una habitación con ese número");
            }else{
                flag = false;
            }
        }while(flag);
        
        Habitacion fh = new FactoryHabitacion().getInstancia(String.valueOf(numero), Balneario.getInstancia());
        getBalneario().getHabitaciones().add(fh);
        
        System.out.println("Habitación añadida.");
    }
    
    private void eliminarHabitacion(){
        boolean flag = true;
        Habitacion habit = null;
        
        do{
            habit = getBalneario().buscarHabitacion(Habitacion.pedirNumero());
            
            if (habit == null){
                System.out.println("No hay registrada una habitación con ese número");
            }else{
                flag = false;
            }
        }while(flag);
        
        habit.infoHabitacion();
        System.out.println("\n¿Seguro que quieres borrar esta habitación? (s/n)");
        
        Scanner sc = new Scanner(System.in);
        
        if (sc.next().equals("s")){
            getBalneario().getHabitaciones().remove(habit);
            System.out.println("Se ha eliminado la habitación");
        }else{
            System.out.println("Operación cancelada");
        }
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaHabitaciones();
                break;
            case 2:
                listaHabitaciones(Habitacion.pedirNumero());
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
