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
public class Sintoma {

    int[][] sintomas = new int[10][7];

    public Sintoma() {
        sintomas[0][0] = 1;sintomas[0][1] = 0;sintomas[0][2] = 1;sintomas[0][3] = 0;sintomas[0][4] = 0;sintomas[0][5] = 1;sintomas[0][6] = 1;
        sintomas[1][0] = 1;sintomas[1][1] = 0;sintomas[1][2] = 1;sintomas[1][3] = 0;sintomas[1][4] = 1;sintomas[1][5] = 1;sintomas[1][6] = 0;
        sintomas[2][0] = 1;sintomas[2][1] = 1;sintomas[2][2] = 1;sintomas[2][3] = 1;sintomas[2][4] = 1;sintomas[2][5] = 1;sintomas[2][6] = 0;
        sintomas[3][0] = 0;sintomas[3][1] = 1;sintomas[3][2] = 0;sintomas[3][3] = 1;sintomas[3][4] = 1;sintomas[3][5] = 0;sintomas[3][6] = 0;
        sintomas[4][0] = 1;sintomas[4][1] = 0;sintomas[4][2] = 1;sintomas[4][3] = 0;sintomas[4][4] = 1;sintomas[4][5] = 1;sintomas[4][6] = 1;
        sintomas[5][0] = 1;sintomas[5][1] = 1;sintomas[5][2] = 0;sintomas[5][3] = 1;sintomas[5][4] = 1;sintomas[5][5] = 0;sintomas[5][6] = 0;
        sintomas[6][0] = 0;sintomas[6][1] = 0;sintomas[6][2] = 0;sintomas[6][3] = 0;sintomas[6][4] = 1;sintomas[6][5] = 1;sintomas[6][6] = 1;
        sintomas[7][0] = 1;sintomas[7][1] = 1;sintomas[7][2] = 1;sintomas[7][3] = 0;sintomas[7][4] = 1;sintomas[7][5] = 1;sintomas[7][6] = 0;
        sintomas[8][0] = 0;sintomas[8][1] = 0;sintomas[8][2] = 1;sintomas[8][3] = 1;sintomas[8][4] = 1;sintomas[8][5] = 1;sintomas[8][6] = 1;
        sintomas[9][0] = 1;sintomas[9][1] = 0;sintomas[9][2] = 1;sintomas[9][3] = 0;sintomas[9][4] = 0;sintomas[9][5] = 1;sintomas[9][6] = 1;       
    }   
    
    public int[][] getSintomas() {
        return sintomas;
    }
    
     public int[] getFila(int num) {
         int fila[] = new int[7]; 
         
             for (int j = 0; j <= sintomas[num].length-1; j++) {
                 fila[j] = sintomas[num][j];
             }
         
         return fila;
    }
    

}
