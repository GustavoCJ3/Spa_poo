package menus;

import reservas.Servicio;

/**
 *
 * @author maxpi
 */
public class MenuServicios extends Menu{
    private static int idServicios = 0;
    
    public MenuServicios(){
        super("1. Listado de todos los servicios\n"
                    + "2. Información de un servicio\n"
                    + "3. Añadir un servicio\n"
                    + "4. Eliminar un servicio\n"
                    + "5. Guardar cambios\n"
                    + "0. Volver\n"
                    + "\nElige una opción: ", 5);
        
    }
    
    private void listaServicios(){
        for(Servicio s: getBalneario().getServicios()){
            System.out.println("\n\nCódigo de servicio: " + s.getCodigo()
                    + "." + s.infoServicio());
        }
    }
    
    private int listaServicios(int codigo){
        for(Servicio s: getBalneario().getServicios()){
            if (s.getCodigo() == codigo) {
            System.out.println("Código de servicio: " + codigo
                    + "." + s.infoServicio());
            return codigo;
            }
        }
        return -1; //TODO
    }
    
    private int agregarServicio(String descripcion, float coste){
        boolean duplicado = false;
        do {        
            for(Servicio s: getBalneario().getServicios()){
                if(s.getCodigo() == idServicios) {
                    duplicado = true;
                    idServicios++;
                } else {
                    duplicado = false;
                }
            }
        } while(duplicado);
        
        Servicio s = new Servicio(idServicios, descripcion, coste);
        
        getBalneario().getServicios().add(s);
        return getBalneario().getServicios().indexOf(s); //devolvemos el índice del objeto insertado
    }
    
    private int eliminarServicio(int codigo){
        for(Servicio s: getBalneario().getServicios()){
            if(s.getCodigo() == codigo) {
                int i = getBalneario().getServicios().indexOf(s);
                getBalneario().getServicios().remove(s);
                return i; //devolvemos el índice en el que estaba el objeto eliminado
            }
        }
        return -1; //si no se ha podido eliminar
    }
    
    @Override
    public void opciones(byte respuesta){
        switch (respuesta){
            case 1:
                listaServicios();
                break;
            case 2:
                listaServicios();
                break;
            case 3:
                //agregarServicio(); //TODO
                break;
            case 4:
                //eliminarServicio(); //TODO
                break;
            case 5:
                getBalneario().guardarDatos();
                break;
            
        }
    }
}
