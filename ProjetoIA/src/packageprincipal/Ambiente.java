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
import java.util.List;

/**
 *
 * @author Antonio Junior
 */
public class Ambiente {

    private static final int ARRAYSIZE = 13;
    //private static final int ARRAYSIZE = 7;
    
    private int matrizvalorada[][] = new int[ARRAYSIZE][ARRAYSIZE];
    private int matrizadjacencia[][] = new int[10][10];
    private String vectornamecity[] = new String[ARRAYSIZE];
    private List<City> listcity = new ArrayList<City>();

    private static final String FILENAME = "C:\\Users\\Antonio Junior\\"
            + "Documents\\NetBeansProjects\\"
            + "ProjetoInteligenciaArtificial\\ProjetoIA\\dados\\nc.csv";

    public final void setTitleList() {
        for (int i = 0; i < vectornamecity.length; i++) {
            //System.out.println(i+"  w "+ vectornamecity[i]);
            City city = new City(i, vectornamecity[i]);
            this.listcity.add(city);
        }
    }
    public List<City> getList(){
        return this.listcity;
    }

    public Ambiente() {
        readCsv();
        setTitleList();
    }

    public AdjacencyData returnDataAdjacency(City cidadeinit) {
        AdjacencyData adjacency = new AdjacencyData();
        for (int j = 0; j < ARRAYSIZE; j++) {
            //se o valor da matriz naquele indice de cidade for maior de zero
            if (matrizvalorada[cidadeinit.getCode()][j] > 0) {
                adjacency.addAdjacentCity(listcity.get(j), matrizvalorada[cidadeinit.getCode()][j]);
            }
        }
        return adjacency;
    }

    public final void readCsv() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;
            int cont = 0;
            int index = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                if (cont == 0) {
                    sCurrentLine = sCurrentLine.substring(2);
                    vectornamecity = sCurrentLine.split(";");
                    cont++;
                } else {
                    int indice = sCurrentLine.indexOf(';') + 1;
                    int tam = sCurrentLine.length();
                    String var = sCurrentLine.substring(indice, tam);
                    String[] g = var.split(";");
                    for (int i = 0; i < ARRAYSIZE; i++) {
                        matrizvalorada[index][i] = Integer.valueOf(g[i]);
                    }
                    index++;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printMatriz() {
        for (int i = 0; i < ARRAYSIZE; i++) {
            System.out.println(" ");
            for (int j = 0; j < ARRAYSIZE; j++) {
                System.out.print(" " + matrizvalorada[i][j]);
            }
        }
    }

    public int[] getMatrizIndex(City cd) {
        int index = cd.getCode();
        int vetor[] = new int[ARRAYSIZE];
        int cont = 0;
        while (cont < ARRAYSIZE) {
            vetor[cont] = matrizadjacencia[index][cont];
            cont++;
        }
        return vetor;
    }

}