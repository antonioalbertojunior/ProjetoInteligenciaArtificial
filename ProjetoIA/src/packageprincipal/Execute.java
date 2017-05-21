/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageprincipal;

/**
 *
 * @author Antonio Junior
 */
public class Execute {

    public static void main(String args[]) {
        Ambiente matrizes   = new Ambiente();
        City estadoinicial  = new City(0, "sp");
        City estadofinal    = new City(6, "rib");

        AdjacencyData adjnodes = matrizes.returnDataAdjacency(estadoinicial);
        Node noinit = new Node(estadoinicial, adjnodes);
        BestFirst bf = new BestFirst(matrizes, noinit, estadoinicial, estadofinal);
        bf.returnTree();
    }
}
