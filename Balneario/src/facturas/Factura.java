package facturas;

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
        //String listaTotalServicios = (bucle para listar)
        
        return "\nCódigo de factura: " + codigo
                + "\nCliente: " + cliente.getNombreApellidos()
                //TODO: preparar de antemano un String con la lista de servicios con comas y formato adecuado y ponerlo aquí
                + "\nCoste total: " + costeTotal
                + "\nFecha de facturación: " + fechaFactura;
    }
    
    //Getters y Setters
    //TODO: generar código automáticamente para los que hagan falta.
}
