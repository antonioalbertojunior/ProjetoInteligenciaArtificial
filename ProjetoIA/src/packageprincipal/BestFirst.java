/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageprincipal;

import java.util.List;

/**
 *
 * @author Antonio Junior
 */
public class BestFirst {

    public BestFirst(Ambiente matrizes, Node nodes, City currentcity, City finalcity) {
        Heuristica heu = new Heuristica(finalcity);

        //retornar o nos adjacentes do estadoinicial
        // AdjacencyData adjnodes = matrizes.returnDataAdjacency(currentcity);
        //System.out.println(adjnodes.getAllAdjacencyData());
        //Node noinit = new Node(currentcity,adjnodes);
        boolean end = false;
        //enquanto cidade objetivo nao chegar faça...
        City cy = heu.heuristicFunction(nodes, currentcity, finalcity);
        while (end != true) {
            if (cy.getCode() == -1 && cy.getName() == "") {
                end = true;
            } else {
                AdjacencyData adjnodes = matrizes.returnDataAdjacency(cy);
                Node noinit = new Node(cy, adjnodes);
                cy = heu.heuristicFunction(noinit, cy, finalcity); 
            }
            //pegar todos os nós diferentes de 0
            //aplicar o método da funçao heuristica para cada nó
            //heuristica.heuristicFunction(,no);
            //verifica o menor funcao heurística..
            // continua iteraçao até achar o estado final
        }
    }

}
