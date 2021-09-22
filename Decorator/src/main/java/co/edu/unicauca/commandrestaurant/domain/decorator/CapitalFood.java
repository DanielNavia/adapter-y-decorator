package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.unicauca.commandRestaurant.infra.Utilities;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class CapitalFood extends Food {
    /**
     * Comida decorada
     */
    private Food myDecoratedFood;

    /**
     * Costructor
     * @param id es el identificador
     * @param name es el nombre del plato
     * @param type es el tipo de plato
     */
    public CapitalFood(int id, String name, FoodTypeEnum type) {
        //Lo convierte a mayúsculas
        String capitalizeFoodName = Utilities.capitalize(name);
        myDecoratedFood = new Food(id, capitalizeFoodName, type);
    }

    @Override
    public void setName(String name) {
        myDecoratedFood.setName(name.toUpperCase());
    }

    @Override
    public String getName() {
        return myDecoratedFood.getName();
    }

    /**
     *
     * @return Id del plato
     */
    @Override
    public int getId() {
        return myDecoratedFood.getId();
    }

    @Override
    public void setId(int id) {
        myDecoratedFood.setId(id);
    }

    @Override
    public FoodTypeEnum getType() {
        return myDecoratedFood.getType();
    }

    @Override
    public void setType(FoodTypeEnum type) {
        myDecoratedFood.setType(type);
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + myDecoratedFood.getId() + ", name=" + myDecoratedFood.getName() + ", type=" + myDecoratedFood.getType() + '}';
    }

}
