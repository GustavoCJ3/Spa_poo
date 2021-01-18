package facturas;

import clientes.Cliente;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import reservas.Reserva;

/**
 *
 * @author Ro
 */
public class Factura implements Serializable{
    //Atributos
    private String codigo;
    private Cliente cliente;
    private ArrayList<Reserva> reservas;
    private float costeTotal;
    private LocalDate fechaFactura;
    
    //Constructores

    public Factura(String codigo, Cliente cliente, ArrayList<Reserva> reservas, float costeTotal, LocalDate fechaFactura) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.reservas = reservas;
        this.costeTotal = costeTotal;
        this.fechaFactura = fechaFactura;
    }

    
    
    //Métodos    
    public String infoFactura(){
        return "Código de factura: " + codigo
                + "\nDNI de cliente: " + cliente.getDni()
                + "\nFecha de facturación: " + fechaFactura + "\n";
    }
    
    public static String pedirId(){
        boolean flag = true;
        BufferedReader br;
        String dni = " ";
        
        do {
            System.out.println("Introduce el DNI del cliente: ");
            try {
                br = new BufferedReader(new InputStreamReader(System.in),1);
                dni = br.readLine();
                
                flag = false;
            }
            catch (Exception e) {
                System.out.println("Error de formato, vuelve a intentarlo (un DNI consiste de 8 dígitos y una letra).");
            }
        } while (flag);         
        
        return dni;
    }
    
    //Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public float getCosteTotal() {
        return costeTotal;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }
    
}
