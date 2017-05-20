/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageprincipal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Antonio Junior
 */
public class Heuristica {

    private List<Integer> confiabilidade = new ArrayList();
    private List<Integer> distancia = new ArrayList();

    public final void readCsvHeuristica() {
        int index = 0;
        final String FILENAME = "C:\\Users\\Antonio Junior\\Documents\\NetBeansProjects\\"
                + "ProjetoInteligenciaArtificial\\ProjetoIA\\dados\\heu_sp_rib.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;
            int cont = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                if (cont == 0) {
                    cont++;
                } else {
                    int indice = sCurrentLine.indexOf(';') + 1;

                    int tam = sCurrentLine.length();
                    String var = sCurrentLine.substring(indice, tam);
                    var = var.substring(var.indexOf(';') + 1);

                    String[] g = var.split(";");
                    confiabilidade.add(Integer.valueOf(g[0]));
                    distancia.add(Integer.valueOf(g[1]));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Heuristica(City objective) {
        //quando passar os paramentros de cidade
        //procurar o arquivo csv que tem as informações
        this.readCsvHeuristica();
    }

    public int searchCityOne(City cd) {
        int indexcidade = 0;
        for (int i = 0; i < confiabilidade.size(); i++) {
            if (i == cd.getCode()) {
                indexcidade = confiabilidade.get(i);
            }
        }
        return indexcidade;
    }

    public int searchCityTwo(City cd) {
        int indexcidade = 0;
        for (int i = 0; i < distancia.size(); i++) {
            if (i == cd.getCode()) {
                indexcidade = distancia.get(i);
            }
        }
        return indexcidade;
    }

    public void printDistancia() {
        for (int i = 0; i < distancia.size(); i++) {
            System.out.println("Codigo Cidade:" + i + " " + distancia.get(i));
        }
    }

    public void printConfi() {
        for (int i = 0; i < confiabilidade.size(); i++) {
            System.out.println("Codigo Cidade:" + i + " " + confiabilidade.get(i));
        }
    }

    public String searchOnMatrix(int index) {
        String nov = confiabilidade.get(index).toString() + " " + distancia.get(index).toString();
        // int value =   distancia.get(index)+ confiabilidade.get(index);
        return nov;
    }

    public int sumHeuristic(int index) {
        int nov = confiabilidade.get(index) + distancia.get(index);
        // int value =   distancia.get(index)+ confiabilidade.get(index);
        return nov;
    }

    //para cada cidade do nó fazer
    public City heuristicFunction(Node nodes, City cd1, City cd2) {
        AdjacencyData adj = nodes.getNodeAdjacencyData();
        HashMap<Integer, Integer> hash = new HashMap<>();
        City nextCity = null;

        if (cd1.isVisited() == false) {
            cd1.setVisited(true);
            //iteracao para verificar todos os nos adjacentes
            for (City key : adj.getAdjacencyData().keySet()) {
                int dist = Integer.valueOf(adj.getAdjacencyData().get(key).toString());
                int sum = sumHeuristic(key.getCode());

                if (sum != 0) {
                    hash.put(key.getCode(), sumHeuristic(key.getCode()));
                    System.out.println(key.getCode() + " " + dist + " " + searchOnMatrix(key.getCode()) + "  " + sum);
                }
            }
        } else {
            return new City(-1, "");
        }
        //verifica o menor valor do hashmap
        int min = Collections.min(hash.values());
        System.out.println(min);

        // iteracao para pegar a cidade do hashmap e fazer a proxima iteracao a partir dela
        for (City key : adj.getAdjacencyData().keySet()) {
            int sum = sumHeuristic(key.getCode());
            if (sum == min) {
                nextCity = new City(key.getCode(), key.getName());
            }
        }
        return nextCity;
    }
    //Função heurística: recebe como parâmetro a Matriz de adjacência e o Nopresidente estado final. 
    //Retorna as heurísticas nos nós dos presidentes com relação ao estado objetivo. 

}
