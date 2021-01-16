package balneario;
import java.util.ArrayList;
import clientes.Cliente;
import facturas.Factura;
import habitaciones.Habitacion;
import reservas.Reserva;
import servicios.Servicio;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 *
 * @author maxpi
 */
public class Balneario implements Serializable{
    private static Balneario instancia;
    private final String NOMBRE_ARCHIVO = "Configuracion.dat";
    private ArrayList<Habitacion> habitaciones= new ArrayList();
    private ArrayList<Servicio> servicios = new ArrayList<Servicio>();
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    
    
    private Balneario(){}
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
    
    public boolean cargarDatos(){
        try{
            FileInputStream in = new FileInputStream(NOMBRE_ARCHIVO);
            ObjectInputStream ois = new ObjectInputStream(in);
            habitaciones = (ArrayList<Habitacion>)ois.readObject();
            servicios = (ArrayList<Servicio>)ois.readObject();
            reservas = (ArrayList<Reserva>)ois.readObject();
            clientes = (ArrayList<Cliente>)ois.readObject();
            facturas = (ArrayList<Factura>)ois.readObject();
            ois.close();
            ois.close();
        }catch(FileNotFoundException e){
            System.out.println("No se ha encontrado el archivo de configuración.");
            return false;
        }catch(Exception e){
            System.out.println("Se ha producido un error en la lectura del archivo.");
            return false;
        }
        System.out.println("Datos cargados");
        return true;
    }
    
    public boolean guardarDatos(){
        try{
            FileOutputStream out = new FileOutputStream(NOMBRE_ARCHIVO);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(habitaciones);
            oos.writeObject(servicios);
            oos.writeObject(reservas);
            oos.writeObject(clientes);
            oos.writeObject(facturas);
            oos.flush();
            oos.close();
            out.close();
        }catch(FileNotFoundException e){
            System.out.println("No se ha podido crear el archivo de configuración.");
            return false;
        }catch(IOException e){
            System.out.println("Se ha producido un error en la escritura.");
            return false;
        }
        
        System.out.println("\nDatos guardados\n");
        return true;
    }
    
    public Habitacion buscarHabitacion(int numero){
        for (Habitacion h: habitaciones){
            if (h.getNumero() == numero){
                return h;
            }
        }
        return null;
    }
    
    
        //Getters y Setters
    
    public static Balneario getInstancia(){
        if(instancia == null){
            instancia = new Balneario();
        }
        
        return instancia;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }    

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public ArrayList<Factura> getFacturas() {
        return facturas;
    }   
}
