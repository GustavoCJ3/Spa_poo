package factorias;

import balneario.Balneario;
import facturas.Factura;
import habitaciones.Habitacion;
import clientes.Cliente;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import reservas.Reserva;
import reservas.ReservaHabitacion;

/**
 * Se encarga del proceso de creación de Facturas
 * @author Gustavo Cortés Jiménez.
 * @author Rodrigo Lázaro Escudero.
 */
public class FactoryFactura implements Factoria<Factura>{

    @Override
    public Factura getInstancia(String idFactura) {
 
        Cliente cliente = null;
        ReservaHabitacion reserva = null;
        float costeTotal = 0;
        LocalDate fechaFactura = LocalDate.now();

        int numHabitacion;
        boolean flag = true;
        BufferedReader br;
        
        numHabitacion = Habitacion.pedirNumero();
        //Comprobamos que la habitación especificada esté registrada en el sistema
        if (Balneario.getInstancia().buscarHabitacion(numHabitacion) == null){
            System.out.println("La habitación indicada no está registrada en el sistema. Imposible generar factura.\n");
            
            return null;
        }
        
        //Comprobamos que la habitación esté reservada
        flag = false;
        for (Reserva r: Balneario.getInstancia().getReservas()){
            if ((r.getNumHabitacion() == numHabitacion) && (r instanceof ReservaHabitacion)){
                reserva = (ReservaHabitacion)r;
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("La habitación indicada no tiene una reserva en vigencia. Imposible generar factura.\n");
            
            return null;
        }
        
        //Si la habitación está reservada, tendrá un cliente válido porque se comprueba al hacer la reserva
        cliente = reserva.getCliente();        
        //Calculamos coste total (antes de posibles descuentos)
        costeTotal = reserva.getCosteTotal();
        
        //Pedir fecha del servicio
        System.out.println("Introduce la fecha de facturación (formato aaaa-mm-dd). La fecha de facturación debe ser posterior a la fecha de salida de la habitación: \n"); 
        flag = true;
        do{
            try {
                br = new BufferedReader(new InputStreamReader(System.in),1);
                fechaFactura = LocalDate.parse(br.readLine());
                flag = false;
            } catch(Exception e) {
                System.out.println("\nError, fecha inválida. El formato de la fecha debe ser aaaa-mm-dd (Ejemplo: 2000-10-25).\n");
            }
        }while(flag);
        if (fechaFactura.isBefore(reserva.getDiaFin())){
            System.out.println("\nError, fecha inválida. La fecha de la factura debe ser posterior al momento en que concluye la reserva.\n");
            
            return null;
        }
        
        //Aplicar descuento (5% a clientes que tuvieron reservas el mismo año natural)
        flag = false;
        for (Factura factura : Balneario.getInstancia().getFacturas()) {
            if ((factura.getCliente() == cliente) && (factura.getReserva().getDiaInicio().getYear() == fechaFactura.getYear())){
                flag = true;
            }
        }
        if (flag){
            costeTotal = costeTotal * 0.95f;
        }

        Factura factura = new Factura(idFactura, cliente, reserva, costeTotal, fechaFactura);
        
        return factura;
    }
}
