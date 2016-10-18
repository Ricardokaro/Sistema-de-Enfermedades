/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
/**
 *
 * @author borisgr04
 */
public class CparaCombo {
  private double errorPatron;
  private double matriz[][];
  public CparaCombo(double errorPatron, double[][] matriz)
      {
        this.errorPatron = errorPatron;
        this.matriz = matriz;
      }

    public double getErrorPatron() {
        return errorPatron;
    }

    public void setErrorPatron(double errorPatron) {
        this.errorPatron = errorPatron;
    }

    public double[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public String toString() {
        return "CparaCombo{" + "errorPatron=" + errorPatron + ", matriz=" + matriz + '}';
    }
    
    
   
   
}