/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageprincipal;

/**
 *
 * @author miguel
 */
public class City {
    private int code;
    private String name;
    private boolean visited=false;
    
    public City(){
        
    }
    public City(int code,String name,boolean v){
        this.code = code;
        this.name = name;
        this.visited = v;
    }
    
    public City(int code, String name){
        this.code = code;
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    
    public void setCode(int code){
        this.code = code;
    }
    
    public int getCode(){
        return this.code;
    }

    public boolean wasVisited() {
        return visited;
    }
    public void setVisited(boolean bool){
        visited=bool;
    }
    
    @Override
    public String toString(){
        return this.getName();
    }
}
    