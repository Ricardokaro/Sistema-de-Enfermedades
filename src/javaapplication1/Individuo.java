/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author Ricardo
 */
public class Individuo {
   private double matriz[][] = new double[7][4];
   private String matrizBinaria[][] = new String[7][4];
   private String vectorBinario[] = new String[28];
   public double errorPatron;
   DecimalFormat dec = new DecimalFormat();
  
  
        
   
    public void generarMatrizAleatoria(){       
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {                   
                matriz[i][j] = numeroAleatorioDecimales(-1, 1);
            }
        }
    }
    
    public void generarVectorBinario(){        
            int k=0;
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 4; j++) {                   
                    vectorBinario[k] = matrizBinaria[i][j];
                    k++;
                }
            }  
    }
    
    public void generarMatrizBinaria(){       
        ConvertidorBinario conv = new ConvertidorBinario();
        String numero;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {              
                numero = quitarSigno(matriz[i][j]);
                if(esNegativo(matriz[i][j])){
                     matrizBinaria[i][j] = "1"+conv.decimalBinario(numero);
                }else{
                    matrizBinaria[i][j] = "0"+conv.decimalBinario(numero);
                }    
               
            }
        }
    }
    
    public void convertirVectoraMatriz(){
        int k=0;
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 4; j++) {                   
                      matrizBinaria[i][j] = vectorBinario[k];
                    k++;
                }
            }  
    }
    
    public String quitarSigno(double numero){
        String cadena = String.valueOf(numero);
        String sinSigno="";
        if(esNegativo(numero)){
            for (int i = 1; i <= cadena.length()-1; i++) {
                sinSigno += cadena.charAt(i);
            }
        }else{
            for (int i = 0; i <= cadena.length()-1; i++) {
                sinSigno += cadena.charAt(i);
            }
        }
        //System.out.println(sinSigno);
        return sinSigno;
    }
    
    public boolean esNegativo(double numero){
        boolean valor; 
        String negativo = String.valueOf(numero);
        
            if(negativo.charAt(0) == '-'){
                valor = true;
            }else{
                valor = false;
            }
        
        return valor;
    }
    
    public double numeroAleatorioDecimales(int min, int max) {
        
        DecimalFormat dec = new DecimalFormat("0.000");
        DecimalFormatSymbols dfs = dec.getDecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        dec.setDecimalFormatSymbols(dfs);        
        double numAleatorio;
        double  num = Math.random() * (max - min);
        numAleatorio = num + min;
        //System.out.println(dec.format(numAleatorio));
        return Double.valueOf(dec.format(numAleatorio));
    }

    /**
     * @return the matriz
    */
    public double[][] getMatriz() {
        return matriz;
    }
    
      public String[][] getMatrizBinaria() {
        return matrizBinaria;
    }

    public double getErrorPatron() {        
        return errorPatron;
    }

    public void setErrorPatron(double errorPatron) {
        this.errorPatron = errorPatron;
    } 

    public String[] getVectorBinario() {
        return vectorBinario;
    }

    public void setVectorBinario(String[] vectorBinario) {
        this.vectorBinario = vectorBinario;        
    }
    
    
    
}
