/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class Exemplaires {
    int documentId;
    int etagereId;
    String statut="disponible";
    public Exemplaires(int  documentId,int etagereId){
        this.documentId=documentId;
        this.etagereId=etagereId;
    }
    
    public void addExemplaire(){
        Connection conn=null;
        PreparedStatement statement=null;
        try {
            conn=DBConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO exemplaires (document_id,etagere_id,statut) VALUES (?,?,?)");
            statement.setInt(1, this.documentId);
            statement.setInt(2, this.etagereId);
            statement.setString(3, this.statut);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }
}
