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
public class Node {
    private City name;
    private AdjacencyData adData; //cidade - Adjacencia
 
    
    public Node(City city, AdjacencyData ad){
        this.name = city;
        this.adData = ad;
    }
    
    public Node(){
        this.name = null;
        this.adData = new AdjacencyData();
    }
    
    public void setNode(City city, HashMap<City, Integer> adData){
        this.name = city;
        this.adData = new AdjacencyData(adData);
    }
    
    public void addAdjacentNode(City city, int cost){
        this.adData.addAdjacentCity(city, cost);
    }
    
    public AdjacencyData getNodeAdjacencyData(){
        return this.adData;
    } 
    
    public String getAllAdjacentNodes(){
        return this.adData.getAllAdjacencyData();
    }
}


