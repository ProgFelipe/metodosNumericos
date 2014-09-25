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
 * @author Felipe
 */
public class RegulaFalsi {
    private JFrame frame;
    private double x0,x1;
    private final double tolerancia;
    private final int niter;
    public RegulaFalsi(JFrame f, double x0, double x1, double tolerancia, int niter){
        this.frame = f;
        this.x0 = x0;
        this.x1 = x1;
        this.tolerancia = tolerancia;
        this.niter = niter;
                
    }
    public void Cal(){
        Math.log(x1-x0);
        funcion f = new funcion();
        double fx0 = f.calc(x0);
        if(fx0 == 0){
            JOptionPane.showMessageDialog(frame, "X inicial es raiz :" + fx0);
            //return Double.toString(x0);
        }else{
            if(f.calc(x1) == 0){
                JOptionPane.showMessageDialog(frame, "X inicial es raiz :" + fx0);
                //return Double.toString(x1);
            }else{
                if(fx0*f.calc(x1) < 0){
                    double x = x0-((f.calc(x0)*(x1-x0))/(f.calc(x1)-f.calc(x0)));
                    double fx = f.calc(x);
                    int i = 1;
                    double error = tolerancia+1;

                    while(i<= niter && fx != 0 && error > tolerancia){
                        if(f.calc(x0)*f.calc(x1) < 0 ){
                                x1 = x;
                        }else{
                                x0 = x;
                        }
                        double aux = x;
                        x = (x0+x1)/2;
                        error = Math.abs(x-aux);
                        fx = f.calc(x);
                        i++;
                    }
                    if(f.calc(x) == 0){
                     JOptionPane.showMessageDialog(frame, "La raíz es raiz :" + x);
                        //return Double.toString(x);
                    }else{
                        if(error < tolerancia){
                        JOptionPane.showMessageDialog(frame, x+" es una aproximación a la raiz con un error máximo de "+tolerancia);
                        //return Double.toString(x);
                        }else{
                        JOptionPane.showMessageDialog(frame, "fracaso en Niteraciones igual a : " + niter);
                        }
                    }
                }
            }
        }
    }
    
    
}
