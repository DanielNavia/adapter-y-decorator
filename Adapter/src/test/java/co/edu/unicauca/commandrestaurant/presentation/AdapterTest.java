package co.edu.unicauca.commandrestaurant.presentation;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.access.adapter.FoodJsonArrayRepository;
import co.edu.unicauca.commandrestaurant.access.adapter.FoodRepositoryJsonArrayAdapter;
import co.edu.unicauca.commandrestaurant.domain.FoodCommand;
import co.edu.unicauca.commandrestaurant.domain.CreateCommand;
import co.edu.unicauca.commandrestaurant.domain.FindByIdCommand;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.Invoker;
import co.edu.unicauca.commandrestaurant.domain.UpdateCommand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Luis Arroyo y Daniel Navia
 */
public class AdapterTest {

    @Test
    public void testAdapter() {
        System.out.println("ADAPTER JSON");
        
        //Crear un FoodJsonArrayRepository
        FoodRepositoryJsonArrayAdapter repository  = new FoodRepositoryJsonArrayAdapter();
        
        //Agregar una Comida
        Food mazamorra = new Food(12,"Mazamorra", FoodTypeEnum.POSTRE);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
        repository.create(mazamorra);
        
        //Buscar una comida
        assertEquals(mazamorra.getId(), repository.findById(12).getId());
        
        //Modificar una comida 
        mazamorra.setType(FoodTypeEnum.ENTRADA);
        repository.update(mazamorra);
        assertEquals(mazamorra.getType(),repository.findById(12).getType());
         
        //Eliminar una comida 
        repository.delete(12);
        assertEquals(null, repository.findById(12));
        
      
        
             
        
        

    }

}
