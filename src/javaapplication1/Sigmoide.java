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
public class Sigmoide {
    double e;
    double p;

    public Sigmoide() {
        e = Math.E; p=1;        
    }
    
    public double function(double a){
        return (1/(1+Math.pow(e, -a/p)));
    }
    
    
}
