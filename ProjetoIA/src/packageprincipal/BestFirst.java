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

    public List<City> cid;

    public BestFirst(Ambiente matrizes, Node nodes, City initcity, City finalcity) {
        Heuristica heu = new Heuristica(finalcity);
        cid = new ArrayList<>();
        boolean end = false;

        cid.add(initcity);
        City cy = heu.returnNextCity(nodes, finalcity, cid);
        while (end != true) {
            AdjacencyData adjnodes = matrizes.returnDataAdjacency(cy);
            Node noinit = new Node(cy, adjnodes);
            cy = heu.returnNextCity(noinit, finalcity, cid);
            if (cy.getCode() == -1) {
                end = true;
            }
        }
    }

    public void returnTree() {
        System.out.print("\nCaminho Best First: ");
        for (int i = 0; i < cid.size(); i++) {
            System.out.print(cid.get(i).getName() + " ");
        }
        System.out.println("\n");
    }

}
