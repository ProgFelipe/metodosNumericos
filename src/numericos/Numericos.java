/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numericos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import metodos.*;

/**
 *
 * @authors Felipe & Andres
 */
public class Numericos {
    private static JTextField jtxtfuncion, jtxtdelta, jtxtx0, jtxtx1, jtxtniter, jtxttol;
    private static JButton btncalcular;
    private static JList list;
    public funcion funcion;
    public metodos.puntoFijo puntoFijo;
    public metodos.bsqIncremental bsqIncremental;
    public metodos.biseccion biseccion;
    public metodos.NewtonRaphson NewtonRaphson;
    public metodos.secante secante;
    
    
    public static void main(String[] args) {
      // Crear un nuevo Frame
      final JFrame frame = new JFrame("Métodos Numéricos - Andres & Felipe 0.1");
      String [] data = {"Busqueda incremental","Punto fijo","Biseccion","Newton Raphson","Secante"};
      JLabel jlbdelta = new JLabel("ingrese delta");
      jtxtdelta = new JTextField("",8);
      JLabel jlbtx0 = new JLabel("ingrese xo");
      jtxtx0 = new JTextField("",8);
      JLabel jlbtx1 = new JLabel("ingrese x1");
      jtxtx1 = new JTextField("",8);
      JLabel jlbiter = new JLabel("ingrese numero iteraciones");
      jtxtniter = new JTextField("",8);
      JLabel jlbtol = new JLabel("ingrese tolerancia");
      jtxttol = new JTextField("",8);
      btncalcular = new JButton("Evaluar");
      list = new JList(data); //data has type Object[]
      list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      list.setLayoutOrientation(JList.VERTICAL);
      list.setVisibleRowCount(-1);
      
      JScrollPane listScroller = new JScrollPane(list);
      
      JPanel ingresar = new JPanel();
      ingresar.setLayout(new GridLayout(5, 2));
      ingresar.setBorder(BorderFactory.createLineBorder(Color.black));
      ingresar.add(jlbdelta);
      ingresar.add(jtxtdelta);
      ingresar.add(jlbtx0);
      ingresar.add(jtxtx0);
      ingresar.add(jlbtx1);
      ingresar.add(jtxtx1);
      ingresar.add(jlbiter);
      ingresar.add(jtxtniter);
      ingresar.add(jlbtol);
      ingresar.add(jtxttol);
      listScroller.setPreferredSize(new Dimension(250, 80));
      
      btncalcular.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {              

              try{
                          switch(list.getSelectedIndex()){
                              case 0:
                                  try{
                                  double x0 = Double.parseDouble(jtxtx0.getText());
                                  double delta = Double.parseDouble(jtxtdelta.getText());
                                  int niter = Integer.parseInt(jtxtniter.getText());
                                  bsqIncremental bsqI = new bsqIncremental(frame, x0, delta, niter);
                                  bsqI.calc();
                                  }catch(Exception exeption){
                                  JOptionPane.showMessageDialog(frame, "No ingreso o erro al ingresar x0 o delta o iteraciones");
                                  }
                                  break;
                              case 1:
                                  puntoFijo pf = new puntoFijo();
                                  break;
                              case 2:
                                  try{
                                  double tolerancia = Double.parseDouble(jtxttol.getText());
                                  double x0 = Double.parseDouble(jtxtx0.getText());
                                  double x1 = Double.parseDouble(jtxtx1.getText());
                                  int niter = Integer.parseInt(jtxtniter.getText());
                                  biseccion bsc =  new biseccion(frame,x0,x1,tolerancia, niter);
                                  bsc.Cal();}catch(Exception exception){
                                  JOptionPane.showMessageDialog(frame, "No ingreso o erro al ingresar x0 o x1 o iteraciones o tolerancia");
                                  }
                                  break;                      
                              case 3:
                                  try{
                                  double tolerancia = Double.parseDouble(jtxttol.getText());
                                  double x0 = Double.parseDouble(jtxtx0.getText());
                                  int niter = Integer.parseInt(jtxtniter.getText());
                                  NewtonRaphson NR = new NewtonRaphson(frame,tolerancia, x0, niter);
                                  NR.calc();}catch(Exception exception){
                                  JOptionPane.showMessageDialog(frame, "No ingreso o erro al ingresar x0 o x1 o iteraciones o tolerancia");}
                                  break;                      
                              case 4:
                                  try{
                                  double tolerancia = Double.parseDouble(jtxttol.getText());
                                  double x0 = Double.parseDouble(jtxtx0.getText());
                                  double x1 = Double.parseDouble(jtxtx1.getText());
                                  int niter = Integer.parseInt(jtxtniter.getText());
                                  secante sc = new secante(frame,tolerancia, x0,x1,niter);
                                  sc.calc();}catch(Exception exceptions){
                                  JOptionPane.showMessageDialog(frame, "No ingreso o erro al ingresar x0 o x1 o iteraciones o tolerancia");
                                  }
                                  
                                  break;
                          }
              }catch(Exception excepcion){
                  System.out.println("Error "+excepcion);
              }
          }
      });
      // Al cerrar el frame, termina la ejecuciÃ³n de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();  
      // Agregar un JPanel que se llama Mesh (esta clase)
      frame.setLayout( new BorderLayout( ) );
      //frame.add(jtxtfuncion);
      frame.add(ingresar,BorderLayout.WEST);
      frame.add(listScroller,BorderLayout.EAST);
      frame.add(btncalcular, BorderLayout.SOUTH);
      // Asignarle tamaÃ±o
      frame.setSize(585, 160);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
    }   
}
