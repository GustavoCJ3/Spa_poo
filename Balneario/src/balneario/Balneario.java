package balneario;
import java.util.ArrayList;
import clientes.Cliente;
import facturas.Factura;
import habitaciones.Habitacion;
import reservas.Reserva;
import servicios.Servicio;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 *
 * @author maxpi
 */
public class Balneario implements Serializable{
    private static Balneario instancia;
    private final ArrayList<Habitacion> habitaciones= new ArrayList();
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
            FileInputStream in = new FileInputStream("Configuracion.dat");
            ObjectInputStream ois = new ObjectInputStream(in);
            instancia = (Balneario)ois.readObject();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Datos cargados");
        return true;
    }
    
    public boolean guardarDatos(){
        try{
            FileOutputStream out = new FileOutputStream("Configuracion.dat");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(getInstancia());
            oos.flush();
        }catch (Exception e){
            System.out.println(e.getMessage());
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
