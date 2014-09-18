/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @authors Felipe & Andres
 */
import numericos.funcion;

public class puntoFijo{
    double xa, tolerancia;
    int niter;
    
    public puntoFijo(double xa, double tolerancia, int niter){
        this.xa = xa; this.tolerancia = tolerancia; this.niter = niter;
    }
    public puntoFijo(){}
    public double calcRaiz(funcion f){
        return 0;
    }
}
