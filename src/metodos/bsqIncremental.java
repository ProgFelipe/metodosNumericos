/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import numericos.funcion;

/**
 *
 * @author Felipe & Andres
 */
public class bsqIncremental {
    public numericos.funcion funcion;
    private double x0, delta;
    int niter;
    public bsqIncremental(double x0, double delta, int niter){
        this.x0 = x0; this.delta = delta; this.niter = niter;
    }
    
    public String calc(){
        funcion f = new funcion();
        double fx0 = f.calc(x0);
        if(fx0 == 0){
            return Double.toString(x0);
        }else{
            double x1 = x0 + delta;
            int contador = 1;
            double fx1 = f.calc(x1);
            while(fx1*fx0 > 0 && contador <= niter){
               x0 = x1;
               fx0 = fx1;
               x1 = x0 + delta;
               fx1 = f.calc(x1);
               contador += 1;
            }
            if(fx1 == 0){
                return Double.toString(x0);
            }else{
                if(fx0*fx1 < 0){
                    return "Raiz entre "+x0+" y "+x1;
                }else{
                    return "Fracaso en "+niter+" iteraciones";
                }
            }
        }
    }
}
