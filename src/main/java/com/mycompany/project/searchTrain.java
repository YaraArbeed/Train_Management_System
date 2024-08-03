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
/**
 *
 * @author yarax
 */
public class searchTrain extends JFrame {
    private JButton b1,b2;
    private JTextField t1;
    private JComboBox c1,c2;
    private JLabel l1,l2,l3;
    public searchTrain(String title){
        super(title);
   
        b1=new JButton("search");
        b2=new JButton("cancel");
        l1=new JLabel("departion station");
        l2=new JLabel("arrival station");
        l3=new JLabel("number of passengers");
        t1=new JTextField(10);
        String s1[]={"Buraydah","Uyon_Al-Jewa","Unizah","AL-Rass"};
        c1=new JComboBox(s1);
        c2=new JComboBox(s1);
        
         JPanel p=(JPanel)this.getContentPane();
       p.setLayout(new GridLayout(2,1));
       
       JPanel p1=new JPanel();
       p1.setLayout(new GridLayout(3,2));
       p1.add(l1);
       p1.add(c1);
       p1.add(l2);
       p1.add(c2);
       p1.add(l3);
       p1.add(t1);
   
       
     JPanel p2=new JPanel();
       p2.setLayout(new FlowLayout(FlowLayout.CENTER));
       p2.add(b1);
       p2.add(b2);
       
    p.add(p1);
    p.add(p2);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    b1.addActionListener(new search());
    b2.addActionListener(new cancel_search());
    }
   class search implements ActionListener{
        public void actionPerformed(ActionEvent a){
      try {
                boolean f = false;
                if (t1.getText().equals("") || (c1.getSelectedIndex() == c2.getSelectedIndex())) {
                    throw new null_f("null");
                }
                
                
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Train.txt"));
                ArrayList<Train> train = (ArrayList<Train>) ois.readObject();
                ois.close();
                for (int i = 0; i < train.size(); i++) {
                    if(train.get(i).getArrival_station().equals((String)c2.getSelectedItem()) && train.get(i).getDepartion_station().equals((String)c1.getSelectedItem()) && (Integer.parseInt(train.get(i).getNum_of_pass()))>Integer.parseInt(t1.getText())){
                        new Reservation(train.get(i) , t1.getText());
                        f = true; 
                    }
                }
                if (f==false) {
                    JOptionPane.showMessageDialog(null, "Train not found", "not found", JOptionPane.ERROR_MESSAGE);
                }
                

            } catch (null_f ex) {
                JOptionPane.showMessageDialog(null, "Check your input", "error input", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                
            } catch (IOException ex) {
               
            } catch (ClassNotFoundException ex) {
                
            }
       
        }
    }
         class cancel_search implements ActionListener{
        public void actionPerformed(ActionEvent e){
            t1.setText("");
             
        }
         }
    public static void main(String[] args) {
   searchTrain s=new searchTrain("search a train");
    }
    
}
