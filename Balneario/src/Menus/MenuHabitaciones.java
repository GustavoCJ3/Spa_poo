package menus;
import habitaciones.*;
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
    
    //TODO separar el codigo en bloques mas pequeños
    private void agregarHabitacion(){
        int numero = 0;
        float precio = 0;
        boolean flag = true;
        
        do{
            numero = Habitacion.pedirNumero();
            
            if (getBalneario().buscarHabitacion(numero) != null){
                System.out.println("Ya hay registrada una habitación con ese número");
            }else{
                flag = false;
            }
        }while(flag);
        
        System.out.println("Introduce el precio de la habitación (usar coma)");
        
        do{
            flag = true;
            try{
                Scanner sc = new Scanner(System.in);
                precio = sc.nextFloat();
                
                if (precio < 0){
                    System.out.println("El precio tiene que ser superior a 0");
                }else{
                    flag = false;
                }
            }catch(Exception e){
                System.out.println("El valor introducido no es un numero");
            }
        }while(flag);
        
        Habitacion habit = new Habitacion(numero, precio);
        
        byte respuesta = 0;
        
        System.out.println("Introduce el tipo de habitación:\n"
                + "1. Habitación individual\n"
                + "2. Habitación doble\n"
                + "3. Habitación familiar\n");
        do{
            try{
                Scanner sc = new Scanner(System.in);
                respuesta = sc.nextByte();
                
                if ( (respuesta < 1) || (respuesta > 3)){
                    throw new Exception();
                }else{
                    flag = false;
                }
            }catch(Exception e){
                System.out.println("\nPor favor, introduce una opción correcta\n");
            }
        }while(flag);
        
        switch (respuesta){
            case 2:
                String compartido = "";
                flag = true;
                
                System.out.println("\n¿El baño está compartido? (s/n): \n");
                do{
                    try{
                        Scanner sc = new Scanner(System.in);
                        compartido = sc.next("[ns]");
                        flag = false;
                    }catch(Exception e){
                        System.out.println("\nPor favor, introduce \"s\" o \"n\"\n");
                    }
                }while(flag);
                
                habit = new Doble(habit, (compartido.equals("s")));
                break;
            case 3:
                String camas = "";
                flag = true;
                
                System.out.println("\n¿Tiene camas supletorias? (s/n): \n");
                do{
                    try{
                        Scanner sc = new Scanner(System.in);
                        camas = sc.next("[ns]");
                        flag = false;
                    }catch(Exception e){
                        System.out.println("\nPor favor, introduce \"s\" o \"n\"\n");
                    }
                }while(flag);
                
                habit = new Familiar(habit, (camas.equals("s")));
                break;
        }
        
        getBalneario().getHabitaciones().add(habit);
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
