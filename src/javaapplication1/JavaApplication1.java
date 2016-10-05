/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author Ricardo
 */
public class JavaApplication1 {

    
    public static void main(String[] args) {
        
       ArrayList<Individuo> mustra = new  ArrayList<>();         
        
       for (int i = 1; i < 11; i++) {
          Individuo ind = new Individuo();
          ind.generarMatrizAleatoria();  
          ind.generarMatrizBinaria();          
          mustra.add(ind);     
       }
        
        
       Sintoma sintoma = new Sintoma();
       Enfermedad enfermedad = new Enfermedad();
       Sigmoide sigmoide = new Sigmoide();
       double yc[] = new double[4];
       double error[] = new double[4];
       
        
       for (int p = 0; p < 10; p++) {
           //for (int t= 0; t < 4; t++) {
               
           
            int x[] = sintoma.getFila(p);
            int y[] = enfermedad.getFila(0);
            
            for (Individuo indi : mustra) {
                
                double R[][] = indi.getMatriz();
                double suma = 0;
                double sumaError = 0;
                
                
                
                for (int i = 0; i < 4 ; i++) {     
                    
                    for (int j = 0; j < 7; j++) {
                        double aux = x[j]*R[j][i];
                        suma += aux;                        
                    }                    
                    yc[i] = sigmoide.function(suma);
                    
                    suma = 0;                    
                    error[i] = y[i] - yc[i];
                } 
                
                for (int i = 0; i < error.length; i++) {
                    sumaError += error[i];
                }
                
                indi.setErrorPatron(sumaError);                
            }
            
           //} 
           //Ordenar de menor a mayor para obtener los mejores individuos para la reproduccion 
            Collections.sort(mustra, new Comparator<Individuo>() {
		@Override
		public int compare(Individuo p1, Individuo p2) {
                    // Aqui esta el truco, ahora comparamos p2 con p1 y no al reves como antes
                    return new Double(p2.getErrorPatron()).compareTo(new Double(p1.getErrorPatron()));
		}
            });
            
            
           
        }
    }    
       
}
