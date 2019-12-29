/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeRunner.moneyManager.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author adind
 */
public class DatabaseUtilities {
    public static Connection getConnection(){
        return getConnection("jdbc:mysql://localhost/moneymanager", "root", "");
    }
    
    private static Connection getConnection(String url, String user, String pass){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
        }
        return con;
    }

    public void setDriver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
