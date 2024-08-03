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

//we use ArrayList to write and read multible objects 
//https://www.youtube.com/watch?v=l__bi60QeBU&t=969s this link helps us
//this is the way to retrive data from ArrayList
//https://www.tutorialspoint.com/retrieve-an-element-from-arraylist-in-java#:~:text=An%20element%20can%20be%20retrieved,get()%20method.

public class addTrain extends JFrame {
 private JButton b1,b2;
    private JTextField t1,t2;
    private JComboBox c1,c2;
    private JLabel l1,l2,l3,l4;
    
    public addTrain(String title){
        super(title);
   
        b1=new JButton("Add");
        b2=new JButton("cancel");
        l1=new JLabel("train id");
        l2=new JLabel("departion station");
        l3=new JLabel("arrival station");
        l4=new JLabel("max passengers");
        t1=new JTextField(10);
        t2=new JTextField(10);
        String s1[]={"Buraydah","Uyon_Al-Jewa","Unizah","AL-Rass"};
        c1=new JComboBox(s1);
        c2=new JComboBox(s1);
    
       JPanel p=(JPanel)this.getContentPane();
       p.setLayout(new GridLayout(2,1));
       
       JPanel p1=new JPanel();
       p1.setLayout(new GridLayout(4,2));
       p1.add(l1);
       p1.add(t1);
       p1.add(l2);
       p1.add(c1);
       p1.add(l3);
       p1.add(c2);
       p1.add(l4);
       p1.add(t2);
       p1.add(b1);
       p1.add(b2);
       
     JPanel p2=new JPanel();
       p2.setLayout(new FlowLayout(FlowLayout.CENTER));
       p2.add(b1);
       p2.add(b2);
       
    p.add(p1);
    p.add(p2);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    b1.addActionListener(new add());
    b2.addActionListener(new cancel_add());
    } 
    
         class add implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a){
 try {
                if (t1.getText().equals("") || t2.getText().equals("") || (c1.getSelectedIndex() == c2.getSelectedIndex())) {
               throw new null_f("null");//I shoud use separate class to stop insted of completing 
                }
                ArrayList<Train> train = new ArrayList<Train>();
                File f = new File("Train.txt");
                if (f.length()==0) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Train.txt"));
                train.add(new Train(t1.getText() , (String)c1.getSelectedItem() , (String)c2.getSelectedItem() , t2.getText()));
                oos.writeObject(train);
                oos.close();
                JOptionPane.showMessageDialog(null, "the addion is done successfully" , "Operation is done" , JOptionPane.INFORMATION_MESSAGE);
                return;
                }
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Train.txt"));
                train = (ArrayList<Train>) ois.readObject();
                for (int i = 0; i < train.size(); i++) {
                    System.out.println(train.get(i));
                    if(train.get(i).getTrain_id().equals(t1.getText())){
                        throw new ID_er("same ID");
                    }
                }
                ois.close();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Train.txt"));
                train.add(new Train(t1.getText() , (String)c1.getSelectedItem() , (String)c2.getSelectedItem() , t2.getText()));
                oos.writeObject(train);
                oos.close();
                JOptionPane.showMessageDialog(null, "the addion is done successfully" , "Operation is done" , JOptionPane.INFORMATION_MESSAGE);
            }catch (IOException e3){
                
            }
             catch (ClassNotFoundException ex) {
            }
            catch (ID_er ex) {
                JOptionPane.showMessageDialog(null, "the train ID alrady exist" , "ID error" , JOptionPane.ERROR_MESSAGE);
            } catch (null_f e2) {
                JOptionPane.showMessageDialog(null, "Check your input", "error input", JOptionPane.ERROR_MESSAGE);
            }
           
        }

    }


        
   
    
         class cancel_add implements ActionListener{
        public void actionPerformed(ActionEvent e){
            t1.setText("");
            t2.setText("");    
        }
    }
    public static void main(String[] args) {
       addTrain a=  new addTrain ("Add Train");
    }
    
}
