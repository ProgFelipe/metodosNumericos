/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numericos;

/**
 *
 * @author Felipe & Andres
 */
public class funcion {
    
    public funcion(){

    }    

    public double calc(double x){
        //funcion evaluada en x
        //System.err.println(Math.sin(x));
        return Math.sin(x);
    }
    
    public double derivada(double x){
        return Math.cos(x);
    }
}
