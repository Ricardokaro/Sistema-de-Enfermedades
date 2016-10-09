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
        
       
    }    
       
}
