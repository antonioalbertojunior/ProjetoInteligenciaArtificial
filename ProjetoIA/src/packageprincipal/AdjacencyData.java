/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageprincipal;

import java.util.HashMap;

/**
 *
 * @author miguel
 */
public class AdjacencyData {

    //cidades adjacentes com seus custos
    private HashMap<City, Integer> adjacencyData;//= new HashMap<>();

    public AdjacencyData() {
        this.adjacencyData = new HashMap<>();
    }

    public AdjacencyData(HashMap<City, Integer> ad) {
        this.adjacencyData = new HashMap<>();
    }

    public HashMap<City, Integer> getAdjacencyData() {
        return this.adjacencyData;
    }

    public void addAdjacentCity(City city, int cost) {
        this.adjacencyData.put(city, cost);
    }

    public void addAdjacentCity(int code, String city, int cost) {
        this.adjacencyData.put(new City(code, city), cost);
    }

    public void printAllAdjacencyData() {
        HashMap<City, Integer> mp = this.adjacencyData;
    }
    

    public String getAllAdjacencyData() {
        String result = "";
        for (City key : this.adjacencyData.keySet()) {
            result += key.getCode() + " - " + key.getName() + ": " + this.adjacencyData.get(key).toString() + "\n";
        }

        return result;
    }

    public void set(HashMap<City, Integer> param) {
        this.adjacencyData = param;
    }

    public Integer getCityAdjacencyData(City city) {
        boolean existe = adjacencyData.containsKey(city);
        if (existe) {
            return adjacencyData.get(city);
        } else {
            return null;
        }
    }
    
}
