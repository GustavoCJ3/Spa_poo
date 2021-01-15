package menus;

import facturas.Factura;

/**
 *
 * @author maxpi
 */
public class MenuFacturas extends Menu{
    //tratarlo como int a la hora de ir generando ids únicos, y luego convertir a String para inserción en la clase
    private static int idFactura = 0;
    
    
    public MenuFacturas(){
        super("1. Listado de todas las facturas\n"
                    + "2. Información de una factura\n"
                    + "3. Generar una factura\n"
                    + "4. Guardar cambios\n"
                    + "0. Volver\n"
                    + "\nElige una opción: ", 4);
        
    }
    
    private void listaFacturas(){
        for(Factura f: getBalneario().getFacturas()){
            f.infoFactura();
        }
    }
    
    private int listaFacturas(String codigo){
        //TODO: String listaTotalReservas = (bucle para listar) //Esperar esto a ver si podemos usar la misma estrategia que para el composite de reservas
        for(Factura f: getBalneario().getFacturas()){
            if (f.getCodigo() == codigo) {
                System.out.println("\nCódigo de factura: " + codigo
                    + "\nInformación del cliente: " + f.getCliente().infoCliente()
                    //TODO: Añadir listado de las reservas. Esperar a ver qué pasa con los composites
                    + "\nCoste total: " + f.getCosteTotal()
                    + "\nFecha de facturación: " + f.getFechaFactura());
                
                return Integer.parseInt(codigo); //si la factura indicada existe
            }
        }
        return -1; //TODO
    }
    
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
        
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaFacturas();
                break;
            case 2:
                listaFacturas();
                break;
            case 3:
                //generarFactura();
                break;
            case 4:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
