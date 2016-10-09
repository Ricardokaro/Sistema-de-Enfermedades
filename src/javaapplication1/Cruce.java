/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.ArrayList;
import javaapplication1.Individuo;

/**
 *
 * @author Ricardo
 */
public class Cruce {
    
    int numeroIndividuos;
    ArrayList<Individuo> poblacion;
    ArrayList<Individuo>nuevaPoblacion;

    public Cruce(int numeroIndividuos, ArrayList<Individuo> pobalcion) {
        this.numeroIndividuos = numeroIndividuos;
        this.poblacion = pobalcion;
    }
    
    private void operar(){       
        nuevaPoblacion.add(poblacion.get(0));
        int puntoCruce[] = new int[4];
        int i=1;        
        do {           
            
            String padre[] = poblacion.get(i).getVectorBinario();
            String madre[] = poblacion.get(i+1).getVectorBinario();
            String hijo[] = new String[28];
            
            for (int j = 0; j < puntoCruce.length; j++) {
                puntoCruce[j] = numeroAleatorioPunto();
            }          
            
            for (int j = 0; j < padre.length; j++) {
                String genPadre = padre[j];
                String genMadre = madre[j];    
                
            }
           
            
            i++;
        } while (i <= numeroIndividuos);
        
    }
    
    private int numeroConvinacion(int numeroIndividuo){
        int numeroonvinacion = 1;
        boolean bandera=true;
        while(bandera){
            int aux = numeroonvinacion * (numeroonvinacion+1);
            if(aux >= numeroIndividuo ){
                bandera=false;                
            }
            numeroonvinacion++;
        }
        return numeroonvinacion-1;
    }
    
       public int numeroAleatorioPunto() {              
        double numAleatorio;
        double  num = Math.random() * (20 - 1);
        numAleatorio = num + 1;        
        return (int)numAleatorio;
    }
}
