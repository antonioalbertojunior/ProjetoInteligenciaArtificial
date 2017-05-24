/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageprincipal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antonio Junior
 */
public class BestFirst {

    public List<City> listnodesvisited;

    public BestFirst(Ambiente matrizes, Node nodes, City initcity, City finalcity) {
        Heuristica heu = new Heuristica(finalcity);
        listnodesvisited = new ArrayList<>();
        boolean end = false;
        initcity.setVisited(true);
        listnodesvisited.add(initcity);
        City cy = heu.getNextCity(nodes, finalcity, listnodesvisited);
       // while (!listnodesvisited.contains(finalcity)){
        while (end != true) {
            AdjacencyData adjnodes = matrizes.returnDataAdjacency(cy);
            Node noinit = new Node(cy, adjnodes);
            cy = heu.getNextCity(noinit, finalcity, listnodesvisited);
            if (cy.getCode() == -1) {
                end = true;
            }
        }
        
    }

    public void returnTree() {
        System.out.print("\nCaminho Best First: ");
        for (int i = 0; i < listnodesvisited.size(); i++) {
            System.out.print(listnodesvisited.get(i).getName() + " ");
        }
        System.out.println("\n");
    }
    
    public boolean getVisitedNode(City ci){
        return ci.wasVisited()==true;
    }

}
