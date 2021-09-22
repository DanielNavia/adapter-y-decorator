/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.access.IFoodRepository;
import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.decorator.CapitalFood;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Adaptador de FoodJsonArrayRepository. Implementa la misma interfaz IFoodRepository
 * @author Luis Arroyo y Daniel Navia
 */
public class FoodRepositoryJsonArrayAdapter implements IFoodRepository {

    /**
     * Repositorio adaptado
     */
    FoodJsonArrayRepository adaptedRepository;

    /**
     * Constructor
     */
    public FoodRepositoryJsonArrayAdapter() {
        adaptedRepository = new FoodJsonArrayRepository();
    }

    @Override
    public Food findById(int id) {
        return adaptedRepository.getById(id);
    }

    @Override
    public List<Food> findAll() {
        List<String> srt = adaptedRepository.getAll();
        List<Food> list = new ArrayList();
        for(String food: srt){
           list.add(jsonToFood(food));
        }
        return list;}
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

    private Food jsonToFood(String jsonFood) {

        Gson gson = new Gson();
        Food food = gson.fromJson(jsonFood, CapitalFood.class);

        return food;

    }
    
}
