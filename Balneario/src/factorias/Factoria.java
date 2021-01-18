package factorias;

import balneario.Balneario;

/**
 *
 * @author Ro
 */
public interface Factoria <T>{
    public T getInstancia(String id, Balneario balneario);
}
