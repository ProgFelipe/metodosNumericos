/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import numericos.funcion;

/**
 *
 * @authors Felipe & Andres
 */
public class NewtonRaphson {
     public numericos.funcion funcion;
    private double x0, tolerancia;
    int niter;
    public NewtonRaphson(double tol, double x0, int niter){
        this.x0 = x0; this.tolerancia = tol; this.niter = niter;
    }   
    
    public String calc(){
        funcion f = new funcion();
        double fx = f.calc(x0);
        double dfx = f.derivada(x0);
        int contador = 0;
        double x1 = 0;
        double error = tolerancia +1;
        while(error > tolerancia && fx != 0 && dfx != 0 && contador < niter){
            x1 = x0 - (fx/dfx);
            fx = f.calc(x1);
            dfx = f.derivada(x1);
            error = Math.abs(x1-x0);
            x0 = x1;
            contador += 1;
        }
        if(fx == 0){
            return Double.toString(x0);
        }else
            if(error < tolerancia){
                return x1+" se aproxima a una raiz con tolerancia de = "+tolerancia;
            }else
                if(dfx == 0){
                    return x1+" es una posible raiz multiple";
                }else
                    return "fracaso en "+niter+" iteraciones";   
    }
}
