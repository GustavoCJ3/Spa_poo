package menus;

import factorias.FactoryFactura;
import facturas.Factura;

/**
 * Permite al usuario acceder a las funciones que actúan sobre las facturas.
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
        if(getBalneario().getFacturas().isEmpty()){
            System.out.println("\nNo hay facturas registradas.\n");
        }else{   
            for(Factura f: getBalneario().getFacturas()){
                System.out.println(f.infoFactura());
            }
        }
    }
    
    /**
     * Muestra los datos de una factura
     * @param codigo El código de la factura que mostrar
     */
    private void listaFacturas(String codigo){
        Factura f = getBalneario().buscarFacura(codigo);
        if (f != null){
            System.out.println("Código de factura: " + codigo
                + "\nInformación del cliente: " + f.getCliente().infoCliente()
                + "\nListado de reservas: " + f.getReserva().infoReserva()
                + "\nCoste total: " + f.getReserva().getCosteTotal()
                + "\nFecha de facturación: " + f.getFechaFactura() + "\n");                
            return;
        }

        System.out.println("No existe ninguna factura con el código indicado.\n");
    }
    
    /**
     * Crea y añade una nueva factura al sistema
     */
    private void generarFactura(){
       
        int idFactura = 0;
        FactoryFactura ff;
        
        //Generamos automáticamente un Id nuevo y no repetido
        boolean duplicado = false;
        do {        
            for(Factura f: getBalneario().getFacturas()){
                if(idFactura == Integer.parseInt(f.getCodigo())) {
                    duplicado = true;
                    idFactura++;
                } else {
                    duplicado = false;
                }
            }
        } while(duplicado);     
        
        //System.out.println(String.format("%08d", idFactura)); //debug
        
        ff = new FactoryFactura();
        
        Factura factura = ff.getInstancia(String.format("%08d", idFactura));
        if (factura != null) {
            getBalneario().getFacturas().add(factura);
            System.out.println("Factura generada con éxito.\n");
        } else {
            System.out.println("La factura NO se ha creado. Por favor verifique que las habitaciones, clientes y reservas indicadas"
                    + "estén registradas previamente en el sistema.\n");
        }

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
