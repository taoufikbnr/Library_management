/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author lenovo
 */
public class Pret {
    int documentId;
    int subscriberId;
    String dateRetour;
    public Pret(int docId,int subId){
        this.documentId=docId;
        this.subscriberId=subId;
    }
    
    
    public void addPret() throws ParseException{
            Connection conn=null;
            PreparedStatement statement=null;
//            SimpleDateFormat inputFormat = new SimpleDateFormat("d MMMM yyyy", Locale.FRENCH);  
//           java.util.Date utilDate = inputFormat.parse(this.dateRetour);             
//           java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());  
           
        try {
            conn=DBConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO pret (exemplaire_id,subscriber_id) VALUES (?,?)");
            statement.setInt(1, this.documentId);
            statement.setInt(2,this.subscriberId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
    }
}
