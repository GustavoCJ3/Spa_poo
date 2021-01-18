package factorias;

/**
 * Permite definir clases destinadas a la creación de objetos.
 * @author Gustavo Cortés Jiménez.
 * @author Rodrigo Lázaro Escudero.
 */
public interface Factoria <T>{
    
    /**
     * Crea una nuevo objeto
     * @param id identificador del objeto a crear
     * @return el objeto creado
     * @pre el identificador debe tener la estructura correcta
     */
    public T getInstancia(String id);
}
