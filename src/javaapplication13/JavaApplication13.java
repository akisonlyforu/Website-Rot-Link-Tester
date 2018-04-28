/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import javax.swing.JFrame;

/**
 *
 * @author AK
 */
public class JavaApplication13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        NewJPanel maini = new NewJPanel();
        JFrame frame = new JFrame(); //main.getFrame();
         frame.add(maini);
         frame.setSize(300,300);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
}
}