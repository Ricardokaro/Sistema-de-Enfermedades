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
        int puntoCruce[] = new int[4];        
        for (int i = 0; i <=numeroConvinacion(numeroIndividuos); i++) {
           
            for (int n = 0; n <= numeroConvinacion(numeroIndividuos); n++) {                 
                if (i != n) {
                    System.out.println(i+"-"+n);
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
                        
                        for (int k = punto; k <= 20; k++) {
                            parte += genPadre.charAt(k);
                        }
                        
                        hijo[j] = parte;                        
                    }

                    
                    ind.setVectorBinario(hijo);
                    ind.convertirVectoraMatriz();
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
        double num = Math.random() * (20 - 1);
        numAleatorio = num + 1;
        return (int) numAleatorio;
    }
}
