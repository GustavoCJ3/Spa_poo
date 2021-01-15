package amenus;

/**
 *
 * @author maxpi
 */
public class MenuFacturas extends Menu{
    //tratarlo como int a la hora de ir generando ids únicos, y luego convertir a String para inserción en la clase
    private static int idServicios = 0;
    
    
    public MenuFacturas(){
        super("1. Listado de todas las facturas\n"
                    + "2. Información de una factura\n"
                    + "3. Generar una factura\n"
                    + "4. Guardar cambios\n"
                    + "0. Volver\n"
                    + "\nElige una opción: ", 4);
        
    }
    
    private void listaFacturas(){
        
    }
    
    private void listaFacturas(int codigo){
        
    }
    
    private void generarFactura(){
        
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
                generarFactura();
                break;
            case 4:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
