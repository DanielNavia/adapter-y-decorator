package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Adaptador de FoodMapRepository. Implementa la misma interfaz IFoodRepository
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class FoodRepositoryMapAdapter implements IFoodRepository {

    /**
     * Repositorio adaptado
     */
    FoodMapRepository adaptedRepository;

    /**
     * Constructor
     */
    public FoodRepositoryMapAdapter() {
        adaptedRepository = new FoodMapRepository();
    }

    @Override
    public Food findById(int id) {
        return adaptedRepository.getById(id);
    }

    @Override
    public List<Food> findAll() {
        Map<Integer, Food> map = adaptedRepository.getAll();
        List<Food> list = new ArrayList(map.values());
        return list;
    }

    @Override
    public boolean create(Food food) {
        return adaptedRepository.add(food);
    }

    @Override
    public boolean update(Food food) {
        return adaptedRepository.modify(food);
    }

    @Override
    public void delete(int id) {
        adaptedRepository.remove(id);
    }

}
