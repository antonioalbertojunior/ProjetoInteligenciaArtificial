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
public class Execute {
    
      public static void main(String args[]){
          Cidade estadoinicial  =  new Cidade("SP");
          Cidade estadofinal    = new Cidade("RIB");
          Heuristica heuristica = new Heuristica(estadoinicial,estadofinal);
          heuristica.readCsvHeuristica();
         // Ambiente matrizes = new Ambiente();
         // matrizes.readCsv();
         // matrizes.searchNode();
          
          //BestFirst bt = new BestFirst();
          //bt.returnTreeSearch();
        
    }
}
