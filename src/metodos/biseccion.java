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
public class biseccion {
	
	public numericos.funcion funcion;
	private double Xi;
	private double Xs;
	private double tolerancia;
	private int niter;
	private int contador;
	private double error;
	private double Xaux;
        private JFrame frame;
	
	public biseccion(JFrame f, double Xi,double Xs,double tolerancia,int niter){
		this.Xi = Xi;
		this.Xs = Xs;
		this.tolerancia = tolerancia;
		this.niter = niter; 
                this.frame = f;
		
	}
	
	public String Cal(){
		
		funcion f = new funcion();
		double fxi = f.calc(Xs);
		double fxs = f.calc(Xi);
		if(fxi == 0){
			System.out.println("X inicial es raiz :" + fxi);
                        JOptionPane.showMessageDialog(frame, " inicial es raiz :" + Xi);
			return Double.toString(fxi);
			}else if(fxs == 0){
                                JOptionPane.showMessageDialog(frame," siguiente es raiz : " + Xs);
				System.out.println("X siguiente es raiz : " + fxs);
				return Double.toString(fxs);
				}else if((fxi*fxs) < 0){
					double Xm = ((Xi+Xs)/2);
					double fxm = f.calc(Xm);
					contador = 1;
					error = tolerancia+1;
						while((error > tolerancia) && (fxm != 0) && (contador <= niter)){
							if((fxi*fxm) < 0){
								Xs = Xm;
								fxs = fxm;
								
							}else{
								Xi = Xm;
								fxi = fxm;
							}								
						Xaux = Xm;
						Xm = ((Xi + Xs)/2);
						fxm = f.calc(Xm);
						error = Math.abs(Xm- Xaux);
						contador = contador+1;
						
						}if(fxm == 0){
                                                    JOptionPane.showMessageDialog(frame, "la raiz es : "+ Xm);
							System.out.println("Xm es raiz y es : "+ Xm);
							return Double.toString(Xm);							
						}else if(error < tolerancia){
                                                    JOptionPane.showMessageDialog(frame, Xm+" : es aproximacion a una raiz con una toleracia igual"+
                                                            " a : " + tolerancia);
							System.out.println(Xm +": " + "es aproximacion a una raiz con una toleracia igual"
									+ " a : " + tolerancia);
							return Double.toString(tolerancia);
						}else{
                                                    JOptionPane.showMessageDialog(frame, "fracaso en Niteraciones igual a : " + niter);
							System.out.println("fracaso en Niteraciones igual a : " + niter);
							return Integer.toString(niter);
						}
						
				}else{
                                    JOptionPane.showMessageDialog(frame, "el intervalo es inadecuado");
					System.out.println("el intervalo es inadecuado");
					Exception e = new Exception("no paso nada");
					e.printStackTrace();
					return null;
				}
		//return "null";
		
	}
	
    
}
