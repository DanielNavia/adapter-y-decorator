package co.edu.unicauca.commandrestaurant.access;

import java.util.List;
import co.edu.unicauca.commandrestaurant.domain.Food;

/**
 * Interface que define los servicios de persistencia de comidas
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public interface IFoodRepository {

    /**
     * Buscar una comida
     *
     * @param id identificador
     * @return objeto comida
     */
    public Food findById(int id);

    /**
     * Busca todas las comidas
     *
     * @return lista de comidas
     */
    public List<Food> findAll();

    /**
     *
     * @param food comida a agregar
     * @return true si la agrega, false en caso contrario
     */
    public boolean create(Food food);

    /**
     * Modifica una comida
     *
     * @param food comida a ser modificada
     * @return true si lo modifica con exito, false en caso contrario
     */
    public boolean update(Food food);

    /**
     * Eliminar una comida
     *
     * @param id identificador de la comida
     */
    public void delete(int id);

}
