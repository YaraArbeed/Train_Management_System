/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.project;
import java.io.*;
/**
 *
 * @author yarax
 */
public class Train implements Serializable {

  private String train_id;
  private String departion_station;
  private String arrival_station;
  private String num_of_pass;

    public Train(String train_id, String departion_station, String arrival_station, String num_of_pass) {
        this.train_id = train_id;
        this.departion_station = departion_station;
        this.arrival_station = arrival_station;
        
        this.num_of_pass = num_of_pass;
    }

    public String getTrain_id() {
        return train_id;
    }

    public String getDepartion_station() {
        return departion_station;
    }

    public String getArrival_station() {
        return arrival_station;
    }

    public String getNum_of_pass() {
        return num_of_pass;
    }

    @Override
    public String toString() {
        return "Train{" + "train_id=" + train_id + ", departion_station=" + departion_station + ", arrival_station=" + arrival_station + ", num_of_pass=" + num_of_pass + '}';
    }
    
  
    public static void main(String[] args) {
      
    }
    
}
