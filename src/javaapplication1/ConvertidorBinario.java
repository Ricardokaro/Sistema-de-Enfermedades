/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template  * and open the template in the editor.
file, choose Tools | Templates
 */
package javaapplication1;

/**
 *
 * @author Ricardo
 */
public class ConvertidorBinario {

    public int separarParteEntera(String numero) {
        String acumula = "";
        int punto = numero.indexOf(".");

        for (int i = 0; i < punto; i++) {
            char parteEntera = numero.charAt(i);
            acumula += parteEntera;
        }

        int covierteAint = Integer.parseInt(acumula);
        return covierteAint;
    }

    public double separarParteDecimal(String numero) {
        double parteDecimal=0;
        String decimal = "";
        int contDivisorDecimal=0;
        int punto = numero.indexOf(".");
        
        for (int i = punto+1; i < numero.length(); i++) {
            char separar =  numero.charAt(i);
            contDivisorDecimal++;
            decimal+=separar;
        }
        parteDecimal = Double.parseDouble(decimal)/(int)Math.pow(10, contDivisorDecimal);
        return parteDecimal;
    }
    
    public String operaDecimal(double parteDecimal){
        String acumula="";
        double multiplicacion;
        int numeroDeDecimales = 0;
        
        do{
            
            multiplicacion = parteDecimal*2;
            parteDecimal = separarParteDecimal(Double.toString(multiplicacion));
            acumula += separarParteEntera(Double.toString(multiplicacion));
            numeroDeDecimales++;
            
        }while(multiplicacion !=1 &&  numeroDeDecimales < 57);        
        
        return acumula;
    }
    
    public String decimalBinario(String numero){
       
       int parteEntera = separarParteEntera(numero);      
       double parteDecimal = separarParteDecimal(numero);
       String concatenaConEntero = operaDecimal(parteDecimal);
       
       String acumulaResultado="";
       
       int residuo=0;
       do{
           residuo = parteEntera%2;
           parteEntera = parteEntera/2;
           acumulaResultado += residuo;
           
       }while(parteEntera>0);
       
       String resultadoBinario = inverteCadana(acumulaResultado);
       String binario = resultadoBinario+"."+concatenaConEntero;
        
        if(binario.length() < 57){
            for (int i = binario.length()-1; i < 57; i++) {
                binario += "0";     
            }
        } 
       return binario;
    }  
    
    public String inverteCadana(String numInvertir){
       String retorna="";       
        for (int i = numInvertir.length()-1; i >= 0; i--) {
            char acumula = numInvertir.charAt(i);
            retorna += acumula;            
        }
        return retorna;  
    }

}
