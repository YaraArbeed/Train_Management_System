/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Reservation extends JFrame {
    private JButton b1;
    private JTextField t1,t2,t3,t4;
    private JLabel l1,l2,l3,l4;
    public Reservation(Train t,String n){
   
        b1=new JButton("confirm");  
        l1=new JLabel("train id");
        l2=new JLabel("departion station");
        l3=new JLabel("arrival station");
        l4=new JLabel("max passengers");
        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);
        t4=new JTextField(10);
        
        t1.setEnabled(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t1.setText(t.getTrain_id());
        t2.setText(t.getDepartion_station());
        t3.setText(t.getArrival_station());
        t4.setText(t.getNum_of_pass());
    
       JPanel p=(JPanel)this.getContentPane();
       p.setLayout(new GridLayout(2,1));
       
       JPanel p1=new JPanel();
       p1.setLayout(new GridLayout(4,2));
       p1.add(l1);
       p1.add(t1);
       p1.add(l2);
       p1.add(t2);
       p1.add(l3);
       p1.add(t3);
       p1.add(l4);
       p1.add(t4);

       
     JPanel p2=new JPanel();
       p2.setLayout(new FlowLayout(FlowLayout.CENTER));
       p2.add(b1);

       
    p.add(p1);
    p.add(p2);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    b1.addActionListener(new confirm(t, n));
    }
   
        class confirm implements ActionListener{
        private Train t;
        private String n;

        public confirm(Train t, String n) {
            this.t = t;
            this.n = n;
        }
        public void actionPerformed(ActionEvent a){
    try {
            
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Train.txt"));
                ArrayList<Train> train = (ArrayList<Train>) ois.readObject();
                ois.close();
                int s1=Integer.parseInt(t.getNum_of_pass());
                int s2=Integer.parseInt(n);
               String s3=Integer.toString(s1-s2); 
               t4.setText(s3);
               JOptionPane.showMessageDialog(null,"Reservation is confirmed","Congratulation",JOptionPane.PLAIN_MESSAGE);
               
             
            }
    catch (ClassNotFoundException ex) {
                
            }
      catch (IOException I) {
                
            }
     


    }
        }
 
    
}
    

