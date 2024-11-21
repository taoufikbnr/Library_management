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
    private String nom, prenom,cin,adresse;
    private int tel;
       public Subscriber(){
        }
    public Subscriber(String nom,String prenom,String cin,String adresse,int tel){
        this.nom=nom;
        this.prenom=prenom;
        this.cin=cin;
        this.adresse=adresse;
        this.tel=tel;
    }
    public Object[][] getUsers(String query,String selectedCriteria){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
         String st;

            switch (selectedCriteria) {
              case "id":
                  st = "SELECT * FROM subscribers WHERE id LIKE ?";
                  break;
              case "nom":
                  st = "SELECT * FROM subscribers WHERE nom LIKE ?";
                  break;
              case "prenom":
                  st = "SELECT * FROM subscribers WHERE prenom LIKE ?";
                  break;
              case "cin":
                  st = "SELECT * FROM subscribers WHERE cin LIKE ?";
                  break;
              case "adresse":
                  st = "SELECT * FROM subscribers WHERE adresse LIKE ?";
                  break;
              case "tel":
                  st = "SELECT * FROM subscribers WHERE tel LIKE ?";
                  break;
              default:
                  st = "SELECT * FROM subscribers WHERE id LIKE ?";
                  break;
          }
        try {
            conn = DBConnection.getConnection();
            statement = conn.prepareStatement(st);
        statement.setString(1, "%" + query + "%");
            resultSet = statement.executeQuery();
                ArrayList<Object[]> data = new ArrayList<>();

            // Collect data from ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String cin = resultSet.getString("cin");
                String adresse = resultSet.getString("adresse");
                int tel = resultSet.getInt("tel");
                String dateAb = resultSet.getString("created_at");
                String dateOnly = dateAb.split(" ")[0];
                data.add(new Object[]{id, prenom,nom,cin,adresse,tel,dateOnly});
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
    public void deleteUser(String id){
         Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
            
 try {
            conn = DBConnection.getConnection();
            statement = conn.prepareStatement("DELETE FROM subscribers WHERE id = ?");
            statement.setString(1,id);
            statement.executeUpdate();      
  
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving users: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
}
      public void addUser(){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

           try {
            conn = DBConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO subscribers (nom,prenom,cin,adresse,tel) VALUES (?,?,?,?,?)");
            statement.setString(1,this.nom);
            statement.setString(2,this.prenom);
            statement.setString(3,this.cin);
            statement.setString(4,this.adresse);
            statement.setInt(5,this.tel);
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
      public void updateUser(String id){
          Connection conn;
          PreparedStatement statement;
   
          try {
              conn = DBConnection.getConnection();
            statement = conn.prepareStatement("UPDATE subscribers set prenom=?,nom=?,cin=?,adresse=?,tel=? WHERE id=?");
            statement.setString(1,this.nom);
            statement.setString(2,this.prenom);
            statement.setString(3,this.cin);
            statement.setString(4,this.adresse);
            statement.setInt(5,this.tel);
            statement.setString(6,id);
            statement.executeUpdate();  
          } catch (SQLException e) {
          }
          
      }
      
}
