package facturas;

import clientes.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;
import reservas.Reserva;

/**
 *
 * @author Ro
 */
public class Factura {
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
        return "\nCódigo de factura: " + codigo
                + "\nDNI de cliente: " + cliente.getDni()
                + "\nFecha de facturación: " + fechaFactura;
    }
    
    //Getters y Setters
    //TODO: generar código automáticamente para los que hagan falta.
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
