package facturas;

import clientes.Cliente;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.LocalDate;
import reservas.Reserva;

/**
 * Contiene la información y las funciones sobre una factura.
 * @author Gustavo Cortés Jiménez.
 * @author Rodrigo Lázaro Escudero.
 */
public class Factura implements Serializable{
    //Atributos
    private String codigo;
    private Cliente cliente;
    private Reserva reserva;
    private float costeTotal;
    private LocalDate fechaFactura;
    
    //Constructores

    public Factura(String codigo, Cliente cliente, Reserva reserva, float costeTotal, LocalDate fechaFactura) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.reserva = reserva;
        this.costeTotal = costeTotal;
        this.fechaFactura = fechaFactura;
    }
    
    
    //Métodos  
    
    /**
     * Muestra la información de la factura.
     * @return los datos de la factura.
     */
    public String infoFactura(){
        return "Código de factura: " + codigo
                + "\nDNI de cliente: " + cliente.getDni()
                + "\nFecha de facturación: " + fechaFactura + "\n";
    }
    
    /**
     * Pide un número de fectura.
     * @return un número de factura.
     */
    public static String pedirId(){
        boolean flag = true;
        BufferedReader br;
        String codigo = " ";
        
        do {
            System.out.println("Introduce el ID de la factura: ");
            try {
                br = new BufferedReader(new InputStreamReader(System.in),1);
                codigo = br.readLine();
                
                //Validar
                if (!validaCodigo(codigo)) {
                    throw new Exception();
                }  
                
                flag = false;
            }
            catch (Exception e) {
                System.out.println("Error de formato, vuelve a intentarlo (un código de factura tiene 8 dígitos).");
            }
        } while (flag);         
        
        return codigo;
    }
    
    /**
     * Comprueba si el código recibido tiene la estructura correcta.
     * @param codigo el código de factura a comprobar.
     * @return true si es correcto; si no, false.
     */
    public static boolean validaCodigo(String codigo) {
        if (codigo.length() != 8) {
            return false;
        }
        
        //Comprobamos formato con regex
        if (codigo.matches("\\d{8}")) {
            return true;
        }
        
        return false;
    }
    
    //Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public float getCosteTotal() {
        return costeTotal;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }
    
}
