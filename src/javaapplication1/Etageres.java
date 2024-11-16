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
public class Etageres {
    String numEt;
    String libelleEt;
    int placard_id;
    public Etageres(String libelle,int placardId){
        this.libelleEt=libelle;
        this.placard_id=placardId;
    }
    public void addEtagere(){
        Connection conn=null;
        PreparedStatement statement=null;
        try {
            conn=DBConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO etageres (libelleEt,placard_id) VALUES (?,?)");
            statement.setString(1, this.libelleEt);
            statement.setInt(2, this.placard_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }
}
