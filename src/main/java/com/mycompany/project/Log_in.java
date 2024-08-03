/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Log_in extends JFrame {
    private JButton b1,b2;
    private JTextField t1,t2;
    private JLabel l1,l2;
    
    public Log_in(String title){
        super(title);
   
        b1=new JButton("Enter");
        b2=new JButton("cancel");
        
        l1=new JLabel("Login");
        l2=new JLabel("password");
        t1=new JTextField(11);
       t2=new JTextField(11);
       JPanel p=(JPanel)this.getContentPane();
    
       JPanel p1=new JPanel();
       p1.setLayout(new GridLayout(1,2));
       p1.add(l1);
       p1.add(t1);
       
        JPanel p2=new JPanel();
        p2.setLayout(new GridLayout(1,2));
       p2.add(l2);
       p2.add(t2);
       
       JPanel p3=new JPanel();
       p3.add(b1);
       p3.add(b2);
       
       p.add(p1,BorderLayout.NORTH); 
       p.add(p2,BorderLayout.CENTER); 
       p.add(p3,BorderLayout.SOUTH); 

        
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
     
    b1.addActionListener(new enter());
    b2.addActionListener(new cancel());
    }

     class enter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                if (t1.getText().equals("") || t2.getText().equals("")) {
                    throw new null_f("null_f");
                }
                DB c = new DB();
                int v = c.loginSearch(t1.getText(), t2.getText());
                c.close();
                switch (v) {
                    case 1 -> new addTrain ("Add Train");
                    case 2 -> new searchTrain("search a train");
                    default -> JOptionPane.showMessageDialog(null, "check password or username " , "no account found" , JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (null_f e1) {
                JOptionPane.showMessageDialog(null, "Check your input", "error input", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                 
            } catch (ClassNotFoundException ex) {
               
            }
            
        }
    }
         class cancel implements ActionListener{
        public void actionPerformed(ActionEvent e){
            t1.setText("");
            t2.setText("");    
        }
    }
     
    public static void main(String[] args) {
    Log_in l=  new Log_in ("Login page");
    }
}
