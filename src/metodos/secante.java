/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import numericos.funcion;

/**
 *
 * @author Felipe & Andres
 */
public class secante {
    public numericos.funcion funcion;
    private final double tolerancia;
    private double x0, x1;
    int niter;
    private final JFrame frame;
    
    public secante(JFrame f, double tol, double x0, double x1, int niter){
        this.tolerancia = tol; this.x0 = x0; this.x1 = x1; this.niter = niter;
        this.frame = f;
    }
    public String calc(){
        funcion f = new funcion();
        double fx0 = f.calc(x0);
        if(fx0 == 0){
            return Double.toString(x0);
        }else{
            double fx1 = f.calc(x1);
            int contador = 0;
            double error = tolerancia + 1;
            double den = fx1 - fx0;
            while(error > tolerancia && fx1 != 0 && den != 0 && contador < niter){
                double x2 = x1 - fx1* (x1*x0)/den;
                error = Math.abs(x2-x1);
                x0 = x1;
                fx0 = fx1;
                x1 = x2;
                fx1 = f.calc(x1);
                den = fx1 - fx0;
                contador += 1;
            }
            if(fx1 == 0){
                return Double.toString(x1);
            }else
                if(error < tolerancia){
                    JOptionPane.showMessageDialog(frame, "es una aproximacion a una raiz con tolerancia = "+tolerancia);
                    return x1+"es una aproximacion a una raiz con tolerancia = "+tolerancia;
                }else
                    if(den == 0){
                        JOptionPane.showMessageDialog(frame, "hay una posible raiz multiple");
                        return "hay una posible raiz multiple";
                    }else
                        JOptionPane.showMessageDialog(frame, "fracaso en "+niter+" iteraciones");
                        return "fracaso en "+niter+" iteraciones";
        }
    }
}
