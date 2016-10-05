/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Enfermedad {
    
    int enfermedad[][] = new int[10][4];
    public Enfermedad() {
        enfermedad[0][0] = 1;enfermedad[0][1]=0;enfermedad[0][2]=0;enfermedad[0][3]=0;
        enfermedad[1][0] = 0;enfermedad[1][1]=1;enfermedad[1][2]=0;enfermedad[1][3]=0;
        enfermedad[2][0] = 0;enfermedad[2][1]=0;enfermedad[2][2]=1;enfermedad[2][3]=0;
        enfermedad[3][0] = 0;enfermedad[3][1]=0;enfermedad[3][2]=0;enfermedad[3][3]=1;
        enfermedad[4][0] = 1;enfermedad[4][1]=1;enfermedad[4][2]=0;enfermedad[4][3]=0;
        enfermedad[5][0] = 0;enfermedad[5][1]=0;enfermedad[5][2]=1;enfermedad[5][3]=1;
        enfermedad[6][0] = 1;enfermedad[6][1]=0;enfermedad[6][2]=0;enfermedad[6][3]=1;
        enfermedad[7][0] = 0;enfermedad[7][1]=1;enfermedad[7][2]=1;enfermedad[7][3]=0;
        enfermedad[8][0] = 1;enfermedad[8][1]=0;enfermedad[8][2]=1;enfermedad[8][3]=0;
        enfermedad[9][0] = 0;enfermedad[9][1]=1;enfermedad[9][2]=0;enfermedad[9][3]=1;
    }

    public int[][] getEnfermedad() {
        return enfermedad;
    }
    
     public int[] getFila(int num) {
         int fila[] = new int[4]; 
         
             for (int j = 0; j <= enfermedad[num].length-1; j++) {
                 fila[j] = enfermedad[num][j];
             }
         
         return fila;
    }
}
