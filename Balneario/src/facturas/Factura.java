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
    public String infoFactura(){
        return "Código de factura: " + codigo
                + "\nDNI de cliente: " + cliente.getDni()
                + "\nFecha de facturación: " + fechaFactura + "\n";
    }
    
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
