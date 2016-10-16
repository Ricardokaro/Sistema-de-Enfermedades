/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Ricardo
 */
public class ConvertiraDecimal {
       
    public double binarioDecimal(String binario) {              
        double  suma=0;
        int elevar=1;
        for (int i = 3; i < binario.length(); i++) {
           if(binario.charAt(i)=='1'){
               suma += Math.pow(2,-elevar);
           }
           elevar++;
        }
        
        if(binario.charAt(0)=='1'){
            suma=suma*(-1);
        }
        return suma;
    }
}
