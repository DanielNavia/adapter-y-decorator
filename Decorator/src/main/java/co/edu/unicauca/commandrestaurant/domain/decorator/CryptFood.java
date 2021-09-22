package co.edu.unicauca.commandrestaurant.domain.decorator;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.unicauca.commandRestaurant.infra.Utilities;
import java.nio.charset.Charset;

/**
 * 
 * @author Daniel Navia-Luis Arroyo
 */



//patron Decorador para encriptar la comida
public class CryptFood extends Food {

    private Food myDecoratedFood;

    public CryptFood(int id, String name, FoodTypeEnum type) throws Exception {
        //Lo convierte a mayúsculas
        byte[] CryptFoodName = Utilities.encriptar(name);
        System.out.println("Palabra encriptada: "+ String.valueOf(CryptFoodName));
        String DesCriptFoodName = Utilities.desEncriptar(CryptFoodName);
        System.out.println("Palabra decifrada: "+DesCriptFoodName);
        myDecoratedFood = new Food(id, DesCriptFoodName, type);
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
