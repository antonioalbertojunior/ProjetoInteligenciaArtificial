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
public class Ambiente {
    private int matrizvalorada[][] = new int[10][10];
    private int matrizadjacencia[][] = new int[10][10];

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
