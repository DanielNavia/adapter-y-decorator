/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.commandrestaurant.access.adapter;

import co.edu.unicauca.commandrestaurant.domain.Food;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.decorator.CapitalFood;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio con Json
 * @author Luis Arroyo y Daniel Navia
 */
public class FoodJsonArrayRepository {

    private static List<String> components;

    public FoodJsonArrayRepository() {
        if (components == null) {
            components = new ArrayList();
            initData();
        }
        
    }

    /**
     * inicializacion de datos base
     */
    private void initData() {
        components.add(objectToJSON(new CapitalFood(1, "Fríjoles", FoodTypeEnum.PRINCIPIO)));
        components.add(objectToJSON(new CapitalFood(2, "Sopa de verduras", FoodTypeEnum.ENTRADA)));
        components.add(objectToJSON(new CapitalFood(3, "Jugo de mango", FoodTypeEnum.JUGO)));

    }
     /**
     * Consulta una comida por su id
     * @param id identificador de la comida
     * @return comida
     */
    public Food getById(int id) {
        int i;
        Food res=null;
        for(i=0;i<components.size();i++){
            String aux=components.get(i);
            if(aux.contains("\"id\":"+id+",")){
                res=jsonToFood(components.get(i));
            }  
        }
        return res;
    }
     /**
     * Agrega una comida
     * @param food comida a agregar
     * @return true si la agrega, false en caso contrario
     */
    public boolean add(Food food) {
        if (getById(food.getId()) == null) {
            components.add(this.objectToJSON(new CapitalFood(food.getId(),food.getName(),food.getType())));
            return true;
        }
        return false;
    }
    /**
     * Elimina una comida
     * @param id identificador de la comida
     */
    public void remove(int id) {
        int i;
         for(i=0;i<components.size();i++){
            String aux=components.get(i);
            if(aux.contains("\"id\":"+id+",")){
                components.remove(i);
            }  
        }  
    }
    
    /**
     * Modifica una comida
     * @param food comida a modificar
     * @return true si la logra modificar, false en caso contrario
     */
    public boolean modify(Food food) {
        Food aux = this.getById(food.getId());
        if (aux != null) {
            this.remove(aux.getId());
            this.add(food);
            return true;
        }
        return false;
    }
    
    /**
     * Devuelve todos las comidas
     * @return platos en en un Mapa
     */
    public List<String> getAll() {
        return components;
    }
    
    

    /**
     * Convierte jsonFood, guardado en la lista de json a un objeto Food
     *
     * @param jsonFood objeto food en formato json
     * @return retorna el objeto como objeto nuevamente
     */
    private Food jsonToFood(String jsonFood) {

        Gson gson = new Gson();
        Food food = gson.fromJson(jsonFood, CapitalFood.class);

        return food;

    }

    /**
     * Convierte el objeto Food a Json
     *
     * @param food
     * @return food en formato Json
     */
    private String objectToJSON(CapitalFood food) {
       
        Gson gson = new Gson();
        String strObject = gson.toJson(food);
        return strObject;
    }

}
