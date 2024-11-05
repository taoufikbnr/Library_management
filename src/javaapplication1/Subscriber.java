/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class Subscriber {
    public Subscriber(){
    }
    public Object[][] getUsers(String query,String selectedCriteria){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
         String st;

            switch (selectedCriteria) { // Ensure case-insensitive matching
              case "username":
                  st = "SELECT * FROM users WHERE username LIKE ?";
                  break;
              case "password":
                  st = "SELECT * FROM users WHERE password LIKE ?"; // Be cautious with this in real applications
                  break;
              default:
                  st = "SELECT * FROM users WHERE username LIKE ?";
                  break;
          }
        try {
            conn = DBConnection.getConnection();
            statement = conn.prepareStatement(st);
        statement.setString(1, "%" + query + "%");
            resultSet = statement.executeQuery();
            // Displaying the list of users
                ArrayList<Object[]> data = new ArrayList<>();

            // Collect data from ResultSet
            while (resultSet.next()) {
                System.out.println(resultSet);
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                data.add(new Object[]{username, password});
            }
            
            return data.toArray(new Object[0][]);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving users: " + e.getMessage());
            return new Object[0][0];
       
        } finally {
            // Close resources in finally block
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteUser(){
//    int selectedRow = JTablel.getSelectedRow(); // Get the selected row index
    int selectedRow=0;
         Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
    if (selectedRow != -1) { // Check if a row is actually selected
        // Assuming you have a default table model, change this if you're using a custom model
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel model = null;
        
        // Retrieve data from the selected row
        Object username = model.getValueAt(selectedRow, 0); // Change column index based on your table structure
            
 try {
            conn = DBConnection.getConnection();
            statement = conn.prepareStatement("DELETE FROM users WHERE username = ?");
            statement.setString(1,(String)username);
            statement.executeUpdate();      
  
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving users: " + e.getMessage());
        } finally {
            // Close resources in finally block
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        

    } else {
        System.out.println("No row selected.");
    }
    
}
      public void addUser(String username,String password){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

           try {
            conn = DBConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO users (username,password) VALUES (?,?)");
            statement.setString(1,(String)username);
            statement.setString(2,(String)password);
            statement.executeUpdate();      
  
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving users: " + e.getMessage());
        } finally {
            // Close resources in finally block
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }      
    
}  
}
