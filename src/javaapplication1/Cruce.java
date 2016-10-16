/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Arrays;
import javaapplication1.Individuo;

/**
 *
 * @author Ricardo
 */
public class Cruce {

    int numeroIndividuos;
    ArrayList<Individuo> poblacion;
    ArrayList<Individuo> nuevaPoblacion = new ArrayList<>();

    public Cruce(int numeroIndividuos, ArrayList<Individuo> pobalcion) {
        this.numeroIndividuos = numeroIndividuos;
        this.poblacion = pobalcion;        
    }

    public ArrayList<Individuo> nuevaGenaracion() {
        nuevaPoblacion.add(poblacion.get(0));
        int puntoCruce[] = new int[30];        
        for (int i = 0; i <=numeroConvinacion(numeroIndividuos); i++) {           
            for (int n = 0; n <= numeroConvinacion(numeroIndividuos); n++) {                 
                if (i != n) {                    
                    Individuo ind = new Individuo();
                    String hijo[] = new String[28];
                    
                    String padre[] = poblacion.get(i).getVectorBinario();
                    String madre[] = poblacion.get(n).getVectorBinario();         

                    for (int j = 0; j < puntoCruce.length; j++) {                        
                        int aux = numeroAleatorioPunto(); 
                        if(j==0){
                            puntoCruce[j]=aux;
                        }else{
                            do {
                               aux = numeroAleatorioPunto(); 
                            } while (aux == puntoCruce[j-1]);
                           puntoCruce[j] = aux; 
                        }
                    }

                    Arrays.sort(puntoCruce);

                    for (int j = 0; j < padre.length; j++) {
                        String genPadre = padre[j];
                        String genMadre = madre[j];
                        String parte = "";
                        int punto = 0;
                        for (int k = 0; k < puntoCruce.length; k++) {                           
                            for (int l = punto; l <= puntoCruce[k]; l++) {
                                if (k == 0 || k % 2 == 0) {
                                    parte += genPadre.charAt(l);
                                } else {
                                    parte += genMadre.charAt(l);
                                }
                            }
                            punto = puntoCruce[k]+1;
                        }
                        
                        for (int k = punto; k < genPadre.length(); k++) {
                            parte += genPadre.charAt(k);
                        }
                        
                        hijo[j] = mutar(parte);                        
                    }                    
                    
                    ind.setVectorBinario(hijo);
                    ind.convertirVectoraMatriz();
                    ind.generarMatrizBinariaaDecimal();
                    nuevaPoblacion.add(ind);
                }
            }
           
        }
       
        for (int i = 0; i <= nuevaPoblacion.size(); i++) {
            if(i > numeroIndividuos){
                nuevaPoblacion.remove(nuevaPoblacion.size()-1);
                i=0;
            }
        }
        
        return nuevaPoblacion;
    }
    
    private String mutar(String cadena) {
        
        int genMutar[] = new int[15];
        for (int j = 0; j < genMutar.length; j++) {
            int aux = numeroAleatorioPunto();
            if (j == 0) {
                genMutar[j] = aux;
            } else {
                do {
                    aux = numeroAleatorioPunto();
                } while (aux == genMutar[j - 1]);
                genMutar[j] = aux;
            }
        }        
        
        
        char[] vec = convertirVector(cadena);
        for (int i = 0; i < genMutar.length; i++) {
            for (int j = 0; j < vec.length; j++) {
                if(genMutar[i] == j){                    
                    if(vec[j] == '1'){
                       vec[j] = '0'; 
                    }else{
                       vec[j] = '1'; 
                    }
                }
            }
        }
        
        cadena = String.valueOf(vec);
        return cadena;
    }

    private char[] convertirVector(String cadena){
        char vector[] = new char[60];
        for (int i = 0; i < cadena.length()-1; i++) {
            vector[i] = cadena.charAt(i);
        }
        return vector;
    }
    
    private int numeroConvinacion(int numeroIndividuo) {
        int numeroonvinacion = 1;
        boolean bandera = true;
        while (bandera) {
            int aux = numeroonvinacion * (numeroonvinacion + 1);
            if (aux >= numeroIndividuo) {
                bandera = false;
            }
            numeroonvinacion++;
        }
        return numeroonvinacion - 1;
    }

    public int numeroAleatorioPunto() {
        double numAleatorio;
        double num = Math.random() * (59 - 1);
        numAleatorio = num + 1;
        return (int) numAleatorio;
    }
}
