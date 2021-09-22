package co.edu.unicauca.commandrestaurant.domain;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.access.RepositoryFactory;
import co.edu.unicauca.commandrestaurant.domain.service.FoodService;

/**
 * Clase abstracta que representa un Comando cualquieraF
 *
 * @author Libardo, Julio
 */
public abstract class FoodCommand {
      protected IFoodRepository repo;
      protected FoodService service;
      protected boolean hasUndo;
    /**
     * ¿Tiene deshacer?
     *
     */
    
    public FoodCommand(){
         repo = RepositoryFactory.getInstance().getRepository();
         service = new FoodService(repo);
    }
    
    /**
     * Ejecuta el comando
     */
    public abstract void execute();

    /**
     * Dehace el comando
     */
    public abstract void undo();

    public boolean hasUndo() {
        return hasUndo;
    }

    public void setHasUndo(boolean hasUndo) {
        this.hasUndo = hasUndo;
    }

}
