/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.project;
import java.sql.*;

public class DB {

    private final Connection con;

    public DB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/logindata", "root", "root");
    }

    public int loginSearch(String log, String pass) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from MyUsers where name = '" + log + "' and password ='" + pass + "' ;");
        if( rs.next()){
            String name = rs.getString(1);
            String passw = rs.getString(2);
            int  admin= rs.getInt(3);
            return (admin==1) ? 1 : 2;
        }else{
            return 0; 
        }
        
    }

    public void close() throws SQLException {
        con.close();
    }
}
