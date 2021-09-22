package co.edu.unicauca.commandrestaurant.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comando concreto para crear una comida
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class CreateCommand extends FoodCommand {

    /**
     * Comida a crear
     */
    private Food food;

    /**
     * Constructor parametrizado
     *
     * @param food comida crear en la base de datos
     */
    public CreateCommand(Food food) {
        super();
        this.food = food;
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(CreateCommand.class); 
        logger.info("Comando de creación ejecutado. Se creo la comida " + food.toString());
        service.create(food);
    }

    @Override
    public void undo() {
        Logger logger= LoggerFactory.getLogger(CreateCommand.class); 
        logger.info("Comando de creación deshecho. Se eliminó la comida " + food.toString());        
        service.delete(food.getId());
    }

}
