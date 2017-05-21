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
    private int flag = 0;

    public final void readCsvHeuristica() {
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

    public int heuristicFunction(int index) {
        int nov = confiabilidade.get(index) + distancia.get(index);
        // int value =   distancia.get(index)+ confiabilidade.get(index);
        return nov;
    }

    public City returnNextCity(Node nodes, City cd2, List<City> city) {
        AdjacencyData adj = nodes.getNodeAdjacencyData();
        HashMap<Integer, Integer> hash = new HashMap<>();
        City nextCity = null;

        for (int c = 0; c < city.size(); c++) {
            if (city.get(c).getCode() == cd2.getCode()) {
                //System.out.println("jatem");
                return new City(-1, "");
            }
        }
        
        //iteracao para verificar todos os nos adjacentes
        for (City key : adj.getAdjacencyData().keySet()) {
            int dist = Integer.valueOf(adj.getAdjacencyData().get(key).toString());
            int sum = heuristicFunction(key.getCode()) + dist;
            
            //distancia real entre origem e destino
            hash.put(key.getCode(), sum);
            System.out.println(key.getCode() + " " + dist + " " + searchOnMatrix(key.getCode()) + "  " + sum);

        }

        //verifica o menor valor de fn dos nós adjacentes
        int min = Collections.min(hash.values());
        System.out.println("Menor valor da iteracao: " + min);

        // iteracao para pegar a cidade do hashmap e fazer a proxima iteracao a partir dela
        for (City key : adj.getAdjacencyData().keySet()) {
            int dist = Integer.valueOf(adj.getAdjacencyData().get(key).toString());
            int sum = heuristicFunction(key.getCode()) + dist;
            // System.out.println(sum+"' ' "+min);
            if (sum == min) {
                nextCity = new City(key.getCode(), key.getName());
            }
        }
        city.add(nextCity);
        return nextCity;

    }
}
