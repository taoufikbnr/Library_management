/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import utils.PasswordEncryption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class Librarian {
    public static Librarian instance;
    private String username;
    private String password;
    
    public Librarian(){

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private Librarian(String username) {
        this.username = username;
    }

    public static void setCurrentUser(String username) {
        instance = new Librarian(username);
    }
      public static void logout() {
        instance = null;
    }
     public boolean login(String usernameData,String passwordData){
     Connection conn = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
      boolean isAuthenticated = false;
    try {
        conn = DBConnection.getConnection();

        statement = conn.prepareStatement("SELECT * FROM librarian WHERE username = ?");
        statement.setString(1, usernameData);
        resultSet = statement.executeQuery();
        if(resultSet.next()){
         String  hashedPassword =resultSet.getString("password");
            if (PasswordEncryption.verifyPassword(passwordData, hashedPassword)) {
                        isAuthenticated = true;
                } 
            }


    } catch (SQLException e) {
        e.printStackTrace(); // Print the exception for debugging
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
    } catch (Exception e) {
        e.printStackTrace(); // Print the exception for debugging
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    } finally {
        // Clean up resources
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
         return isAuthenticated;

    } 
      
}