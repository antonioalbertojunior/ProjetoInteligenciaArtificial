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

    private int matrizvalorada[][] = new int[6][6];
    private int matrizadjacencia[][] = new int[10][10];

    private static final String FILENAME = "C:\\Users\\Antonio Junior\\"
            + "Documents\\NetBeansProjects\\"
            + "ProjetoInteligenciaArtificial\\ProjetoIA\\dados\\matridist.csv";

    public void readMatriz() {
        for (int i = 0; i < 6; i++) {
            System.out.println(" ");
            for (int j = 0; j < 6; j++) {
                System.out.print(" " + matrizvalorada[i][j]);
            }
        }
    }

    public void searchNode() {
        List<Integer> indl = new ArrayList<>();
        for (int j = 0; j < 6; j++) {
            if (matrizvalorada[0][j] != 0) {
                //System.out.print(" " + matrizvalorada[0][j]);
                
                indl.add( matrizvalorada[0][j]);
            }
        }
        for(int i =0;i<indl.size();i++){
            System.out.println(indl.get(i));
        }
    }

    public void readCsv() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;
            int cont = 0;
            int index = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                if (cont == 0) {
                    cont++;
                } else {
                    int indice = sCurrentLine.indexOf(';') + 1;
                    int tam = sCurrentLine.length();
                    String var = sCurrentLine.substring(indice, tam);
                    String[] g = var.split(";");
                    for (int i = 0; i < 6; i++) {
                        matrizvalorada[index][i] = Integer.valueOf(g[i]);
                    }
                    index++;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int[][] getMatrizvalorada() {
        return matrizvalorada;
    }

    public void setMatrizvalorada(int[][] matrizvalorada) {
        this.matrizvalorada = matrizvalorada;
    }

    public int[][] getMatrizadjacencia() {
        return matrizadjacencia;
    }

    public void setMatrizadjacencia(int[][] matrizadjacencia) {
        this.matrizadjacencia = matrizadjacencia;
    }

}
