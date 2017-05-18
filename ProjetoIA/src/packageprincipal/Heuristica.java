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
public class Heuristica {
    private int confiabilidade;
    private int distancia;

    public int getConfiabilidade() {
        return confiabilidade;
    }

    public void setConfiabilidade(int confiabilidade) {
        this.confiabilidade = confiabilidade;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    
    public List<No> heuristicFunction(int matriz[][],List<No> list,No nofinal){
        List<No> iojfd = null;
        return iojfd;
    }
    //Função heurística: recebe como parâmetro a Matriz de adjacência e o Nopresidente estado final. 
    //Retorna as heurísticas nos nós dos presidentes com relação ao estado objetivo. 

}
