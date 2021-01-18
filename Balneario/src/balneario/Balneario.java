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
 * Contiene la información principal de la aplicación.
 * @author Gustavo Cortés Jiménez.
 * @author Rodrigo Lázaro Escudero.
 */
public class Balneario implements Serializable{
    private static Balneario instancia;
    private final String NOMBRE_ARCHIVO = "Configuracion.dat";
    private ArrayList<Habitacion> habitaciones= new ArrayList();
    private ArrayList<Servicio> servicios = new ArrayList();
    private ArrayList<Reserva> reservas = new ArrayList();
    private ArrayList<Cliente> clientes = new ArrayList();
    private ArrayList<Factura> facturas = new ArrayList();
    
    
    private Balneario(){}
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
    
    /**
     * Carga los datos almacenados en el archivo de configuración en la aplicación.
     * @return false si han ocurrido fallos; si todo ha ido bien, true.
     */
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
    
    /**
     * Guarda los datos de la aplicación en el archivo de configuración.
     * @return false si han ocurrido fallos; si todo ha ido bien, true.
     */
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
    
    /**
     * Devuelve la habitación cuyo número se corresponda con el recibido.
     * @param numero el número de la habitación.
     * @return la habitación correspondiente; si no, null
     */
    public Habitacion buscarHabitacion(int numero){
        for (Habitacion h: habitaciones){
            if (h.getNumero() == numero){
                return h;
            }
        }
        return null;
    }
    
    //TODO todas estas probablemente podríamos buscar un patrón para reutilizar el código. De momento lo copio y luego ya limpiaremos
    //TODO mirar en el código de Rodri dónde se puede reemplazar por estas funciones.
    public Servicio buscarServicio(int idServicio){
        for (Servicio s: servicios){
            if (s.getCodigo() == idServicio){
                return s;
            }
        }
        return null;
    }
    
    public Reserva buscarReserva(int idReserva){
        for (Reserva r: reservas){
            if (r.getNumReserva() == idReserva){
                return r;
            }
        }
        return null;
    }
    
    public Cliente buscarCliente(String idCliente){
        for (Cliente c: clientes){
            if (c.getDni().compareToIgnoreCase(idCliente) == 0){
                return c;
            }
        }
        return null;
    }
    
    public Factura buscarFacura(int numero){
        for (Factura f: facturas){
            if (Integer.parseInt(f.getCodigo()) == numero){
                return f;
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
