/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numericos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import metodos.*;

/**
 *
 * @authors Felipe & Andres
 */
public class Numericos {
    private static JTextField jtxtfuncion;
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
      jtxtfuncion = new JTextField("ingrese funcion",20);
      btncalcular = new JButton("Evaluar");
      list = new JList(data); //data has type Object[]
      list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      list.setLayoutOrientation(JList.VERTICAL);
      list.setVisibleRowCount(-1);
      
      JScrollPane listScroller = new JScrollPane(list);
      
      listScroller.setPreferredSize(new Dimension(250, 80));
      
      btncalcular.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e) {
              funcion f = new funcion(jtxtfuncion.getText());
              if(f.validador()){
                    switch(list.getSelectedIndex()){
                        default:
                            new bsqIncremental();
                            break;
                        case 1:
                            new puntoFijo();
                            break;
                        case 2:
                            new biseccion();
                            break;                      
                        case 3:
                            new NewtonRaphson();
                            break;                      
                        case 4:
                            new secante();
                            break;
                    }
              }
          }
      });
      // Al cerrar el frame, termina la ejecuciÃ³n de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();  
      // Agregar un JPanel que se llama Mesh (esta clase)
      frame.setLayout( new FlowLayout( ) );
      frame.add(jtxtfuncion);
      frame.add(listScroller);
      frame.add(btncalcular);
      // Asignarle tamaÃ±o
      frame.setSize(screenSize.width/2, 140);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
    }   
}
