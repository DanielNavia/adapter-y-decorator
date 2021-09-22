package co.edu.unicauca.commandrestaurant.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comando concreto para buscar una comida por su id
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class FindByIdCommand extends FoodCommand {

    /**
     * Comida resultado de la búsqueda
     */
    private Food food;
    /**
     * id de la comida a buscar
     */
    private int foodId;
    /**
     * Instancia al receptor
     */

    /**
     * Constructor
     */
    public FindByIdCommand() {
        super();
        //No tiene deshacer
        this.hasUndo = false;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(FindByIdCommand.class); 
        logger.info("Comando de buscar buscar comida por id se ha ejecutado. Id " + foodId);          
        food = service.findByIdl(foodId);
    }

    @Override
    public void undo() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public Food getFood() {
        return food;
    }

}
