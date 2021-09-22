package co.edu.unicauca.commandrestaurant.domain;

import co.edu.unicauca.commandrestaurant.domain.service.FoodService;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import java.util.ArrayList;
import java.util.List;
import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Comando concreto para buscar todas las comidas
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class FindAllCommand extends FoodCommand {

    /**
     * Lista de comidas, resultado de ejecutar el comando
     */
    private List<Food> foods;
    /**
     * Instancia del receptor
     */
    public FindAllCommand() {
        super();
        foods = new ArrayList<>();
        this.hasUndo = false;
    }

    @Override
    public void execute() {
        Logger logger= LoggerFactory.getLogger(FindAllCommand.class); 
        logger.info("Comando de buscar todas las comidas ejecutado." );            
        foods = service.findAll();
        System.out.println("No hay foods");
    }

    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public void undo() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
