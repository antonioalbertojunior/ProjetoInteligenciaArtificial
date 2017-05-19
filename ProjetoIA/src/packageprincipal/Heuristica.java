/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageprincipal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Antonio Junior
 */
public class Heuristica {
    private int confiabilidade;
    private int distancia;
    
    
    public void readCsvHeuristica(){
       final String FILENAME = "C:\\Users\\Antonio Junior\\Documents\\NetBeansProjects\\"
            + "ProjetoInteligenciaArtificial\\ProjetoIA\\dados\\heu_sp_rib.csv";
         try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;
            int cont = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                if (cont == 0) {
                    cont++;
                } else {
                    System.out.println(sCurrentLine);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public Heuristica(Cidade cd1,Cidade cd2){
        //readCsvHeuristica();
    }

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
