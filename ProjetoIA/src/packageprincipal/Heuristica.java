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
                + "ProjetoInteligenciaArtificial\\ProjetoIA\\dados\\riberao.csv"; //heu_sp_rib
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

    public String searchOnMatrix(int index) {
        String nov = "[" + confiabilidade.get(index).toString() + "," + distancia.get(index).toString() + "]";
        // int value =   distancia.get(index)+ confiabilidade.get(index);
        return nov;
    }

    public int heuristicFunction(int index) {
        int nov = confiabilidade.get(index) + distancia.get(index);
        // int value =   distancia.get(index)+ confiabilidade.get(index);
        return nov;
    }

    public City getCityWithMinFunction(AdjacencyData adj, List<City> list) {
        HashMap<City, Integer> hash = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        City nextCity = null;
        System.out.println("\nCod  Distancia   Heuristica   f(n)");

        //Para cada nó adjacente calcular f(n)
        for (City key : adj.getAdjacencyData().keySet()) {
            int dist = Integer.valueOf(adj.getAdjacencyData().get(key).toString());
            int sum = heuristicFunction(key.getCode()) + dist;
            //distancia real entre origem e destino
            hash.put(new City(key.getCode(), key.getName()), sum);
            arr.add(sum);
            System.out.println(key.getCode() + "    " + dist + "    " + searchOnMatrix(key.getCode()) + "   " + sum);
        }

        //verifica o menor valor de f(n) dos nós adjacentes
        Collections.sort(arr);
        int minfn = Collections.min(hash.values());
        System.out.println("Menor de f(n) neste nó: " + arr.get(0));
        System.out.println("");

        int cont =0;
        // iteracao para pegar a cidade do hashmap e fazer a proxima iteracao a partir dela
        for (City key : adj.getAdjacencyData().keySet()) {
            int dist = Integer.valueOf(adj.getAdjacencyData().get(key).toString());
            int sum = heuristicFunction(key.getCode()) + dist;
            if (minfn == sum) {
                if (!list.contains(key)) {
                    System.out.println("Aqui" + key);
                    return key;
                }
            } else {
               // return new City()
            }
           //cont = arr;
        }

        return new City(-1, "");
    }

    public City getNextCity(Node nodes, City cd2, List<City> city) {
        AdjacencyData adj = nodes.getNodeAdjacencyData();
        City nextCity = null;

        boolean ja = false;

        System.out.println("Cidade Atual: " + nodes.getCurrentCity().getCode());
        for (int c = 0; c < city.size(); c++) {
            System.out.print(city.get(c)+" ");
        }

        //checar nó final
        for (int c = 0; c < city.size(); c++) {
            if (city.get(c).getCode() == cd2.getCode()) {
                ja = true;
            }
        }
        if (ja == true) {
            return new City(-1, "");
        } else {
            adj.printAllAdjacencyData();

            nextCity = getCityWithMinFunction(adj, city);
            System.out.println("-------------------------------");
            nextCity.setVisited(true);
            city.add(nextCity);

            return nextCity;
        }

    }
}
