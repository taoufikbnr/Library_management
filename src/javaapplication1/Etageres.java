/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class Etageres {
    int numEt;
    String libelleEt;
    int placard_id;
    
    public Etageres(String libelle,int placardId,int numEt){
        this.libelleEt=libelle;
        this.placard_id=placardId;
        this.numEt=numEt;
    }
    public Etageres(){
 
    }
    
    
    
    public ResultSet getEtageres(String numEtagere,String placardId){
    
         PreparedStatement statement = null;
            ResultSet resultSet = null;
            Connection conn = null;
                        try {
            conn = DBConnection.getConnection();
            statement=conn.prepareStatement("SELECT * FROM etageres WHERE numEt = ? AND placard_id = ?");
            statement.setString(1, numEtagere);
            statement.setString(2, placardId);
            resultSet = statement.executeQuery();
            
        } catch (SQLException e) {
        }
      return resultSet;
    }
    
    public void addEtagere(){
        Connection conn=null;
        PreparedStatement statement=null;
        try {
            conn=DBConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO etageres (libelleEt,placard_id,numEt) VALUES (?,?,?)");
            statement.setString(1, this.libelleEt);
            statement.setInt(2, this.placard_id);
            statement.setInt(3, this.numEt);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }
}
