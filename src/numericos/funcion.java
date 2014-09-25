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

    //Function f(X)
    public double calc(double x){
        //funcion evaluada en x
        //System.err.println(x+" "+Math.sin(x));
        //return Math.sin(x);
        //e^(3x-12)+xcos(3x)-x^2+4 = 0
        //return Math.exp(3*x-12)+x*Math.cos(3*x)-Math.pow(x, 2)+4;
        return Math.pow(x, 3) + (4*Math.pow(x, 2)) - 10;
    }
    //Derivada f'(X)
    public double derivada(double x){
        return Math.cos(x);
    }
    
    //Function g(X)
    public double calcG(double x){
        return Math.exp(3*x-12)+x*Math.cos(3*x)-Math.pow(x, 2)+4;
    }
    
}
