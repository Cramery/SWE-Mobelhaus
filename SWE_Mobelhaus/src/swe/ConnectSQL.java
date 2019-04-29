/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cramery
 */
public class ConnectSQL {
    
    public void main(String[] args){
        String dbDriver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(dbDriver).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println(e);
        } 
        // Credentials in produktiven Programmen in ein Konfigurationsfile auslagern
        String connectString = "jdbc:mysql://86.119.29.127:22/MariaDB";
        String user = "root";          
        String password = "";
        try {
            Connection con = DriverManager.getConnection(connectString, user, password);
            System.out.println("Wir haben eine Verbindung");
            con.close();
        } catch (SQLException e) {
            System.out.println("hallo");
            System.out.println(e);
        }       
    }
}
