package menus;

import facturas.Factura;

/**
 * @author Gustavo Cortés Jiménez
 * @author Rodrigo Lázaro Escudero
 */
public class MenuFacturas extends Menu{
    
    
    public MenuFacturas(){
        super("1. Listado de todas las facturas\n"
                    + "2. Información de una factura\n"
                    + "3. Generar una factura\n"
                    + "4. Guardar cambios\n"
                    + "0. Volver\n"
                    + "\nElige una opción: ", 4);
        
    }
    
    /**
     * Muestra los datos de todas las facturas guardadas
     */
    private void listaFacturas(){
        for(Factura f: getBalneario().getFacturas()){
            System.out.println(f.infoFactura());
        }
    }
    
    /**
     * Muestra los datos de una factura
     * @param codigo El código de la factura que mostrar
     */
    private void listaFacturas(String codigo){
        //TODO: String listaTotalReservas = (bucle para listar) //Esperar esto a ver si podemos usar la misma estrategia que para el composite de reservas
        for(Factura f: getBalneario().getFacturas()){
            if (f.getCodigo().compareTo(codigo) == 0) {
                System.out.println("Código de factura: " + codigo
                    + "\nInformación del cliente: " + f.getCliente().infoCliente()
                    //TODO: Añadir listado de las reservas. Esperar a ver qué pasa con los composites
                    + "\nCoste total: " + f.getCosteTotal()
                    + "\nFecha de facturación: " + f.getFechaFactura() + "\n");
                
                return;
            }
        }
        return;
    }
    
    /**
     * Crea y añade una nueva factura al sistema
     */
    private void generarFactura(){
        //TODO: hay que controlar que el idFactura sea único (autoincremental vale) y convertirlo a string
        /*
        Generar la factura correspondiente dada una habitación con reserva.
        Sólo se puede facturar si la fecha de facturación coincide o es posterior
        a la fecha de salida de la reserva de la habitación. A los clientes que ya
        han ocupado habitaciones del Balneario en el mismo año natural se les
        aplicará un 5% de descuento.        
        */
        //Necesito poder obtener el listado de reservas para hacer el cálculo del coste total. Ya mañana.
        
/*
        String idCliente;
        FactoryCliente fc;
        
        //System.out.println("Introduce el DNI del cliente:\n"); //Ya lo pide Cliente.pedirId
        idCliente = Cliente.pedirId();
        
        //Comprobamos que el DNI no esté ya en el sistema        
        for(Cliente c: getBalneario().getClientes()){
            if (c.getDni().equalsIgnoreCase(idCliente)) {
                System.out.println("El DNI indicado ya está registrado en el sistema.\n");
                return;
            } 
        }
        
        fc = new FactoryCliente();
        getBalneario().getClientes().add(fc.getInstancia(idCliente));
        System.out.println("Cliente añadido.\n");
*/
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaFacturas();
                break;
            case 2:
                listaFacturas(Factura.pedirId());
                break;
            case 3:
                generarFactura();
                break;
            case 4:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
