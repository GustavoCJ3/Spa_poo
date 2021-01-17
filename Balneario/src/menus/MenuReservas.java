package menus;

import reservas.Reserva;

/**
 *
 * @author maxpi
 */
public class MenuReservas extends Menu{
    private final int ERROR = -1;
    
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
        for(Reserva r: getBalneario().getReservas()){
            System.out.println("\n\nNúmero de reserva: " + r.getNumReserva()
                    + "." + r.infoReserva());
        }  
    }
    
    private int listaReservas(int numReserva){
        for(Reserva r: getBalneario().getReservas()){
            if (r.getNumReserva() == numReserva) {
            System.out.println("Número de reserva: " + numReserva
                    + "." + r.infoReserva());
            return numReserva;
            }
        }
        return ERROR;
    }
    
    private void agregarReserva(){
    /*      //TODO
    public int agregar() {
        boolean duplicado = false;
        do {        
            for(Reserva r: reservas){
                if(r.getNumReserva() == idReservas) {
                    duplicado = true;
                    idReservas++;
                } else {
                    duplicado = false;
                }
            }
        } while(duplicado);
        
        Reserva r = new Reserva();
        
        reservas.add(r);
        return reservas.indexOf(r); //devolvemos el índice del objeto insertado 
    }
    */
    }
    
    private int eliminarReserva(int numReserva){
        for(Reserva r: getBalneario().getReservas()){
            if(r.getNumReserva() == numReserva) {
                int i = getBalneario().getReservas().indexOf(r);
                getBalneario().getReservas().remove(r);
                return i;
            }
        }
        return ERROR;
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaReservas();
                break;
            case 2:
                //listaReservas(); //TODO
                break;
            case 3:
                agregarReserva();
                break;
            case 4:
                //eliminarReserva(); //TODO
                break;
            case 5:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
