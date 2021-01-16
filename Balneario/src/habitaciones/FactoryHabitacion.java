/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package habitaciones;

import java.util.Scanner;

/**
 *
 * @author maxpi
 */
public class FactoryHabitacion {
    
    public static Habitacion getHabitacion(int numero, float precio){
        boolean flag = true;
        byte respuesta = 0;
        
        Habitacion habit = new Habitacion(numero, precio);
        
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
        
        return habit;
    }
}
