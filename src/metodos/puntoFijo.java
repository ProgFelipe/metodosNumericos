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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import numericos.funcion;

public class puntoFijo{
    double xa, tolerancia;
    int niter;
    private JFrame frame;
    
    public puntoFijo(JFrame f, double xa, double tolerancia, int niter){
        this.xa = xa; this.tolerancia = tolerancia; this.niter = niter;
        this.frame = f;
    }
    
    public void Calc(){
        funcion f = new funcion();
        double fx = f.calc(xa);
        int contador = 0;
        double error = tolerancia+1;
        
        while(fx != 0 && error > tolerancia && contador < niter){
            double xn = f.calcG(xa);
            fx = f.calc(xn);
            error = Math.abs(xn-xa);
            xa = xn;
            contador++;
        }
        if(fx == 0){
            JOptionPane.showMessageDialog(frame, "La raíz es "+xa);
        }else{
            if(error < tolerancia){
                JOptionPane.showMessageDialog(frame, xa+" es una aproximación a la raiz con un error máximo de "+tolerancia);
            }else{
                JOptionPane.showMessageDialog(frame, "fracaso en Niteraciones igual a : " + niter);
            }   
        }
                
    }
}
