package clientes;

/**
 *
 * @author Ro
 */
public class Cliente {
    //Atributos
    private String dni;
    private String nombreApellidos;
    private String telefonoMovil;
    
    
    //Constructores
    public Cliente(String dni, String nombreApellidos, String telefonoMovil) {
        this.dni = dni;
        this.nombreApellidos = nombreApellidos;
        this.telefonoMovil = telefonoMovil;
    }

    
    
    //Métodos    
    public String infoCliente(){
        return "\nDNI: " + dni
                + "\nNombre y Apellidos: " + nombreApellidos
                + "\nTeléfono Móvil: " + telefonoMovil;
    }

    
    //Getters y Setters
    
    //TODO: generar código automáticamente para los que hagan falta.

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public String getDni() {
        return dni;
    }
    
}
