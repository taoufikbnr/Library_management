/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.sql.Date;
/**
 *
 * @author lenovo
 */
public class Pret {
    int documentId;
    int subscriberId;
    Date dateRetour;
    
    public Pret(int docId,int subId){
        this.documentId=docId;
        this.subscriberId=subId;
    }
    public Pret(){
    }
    
    
    public void addPret() throws ParseException{
            Connection conn=null;
            PreparedStatement statement=null;
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
        public Object[][] getPret(String query) throws ParseException{
            Connection conn=null;
            PreparedStatement statement=null;
            ResultSet resultSet=null;
            Object[][] tableData=null;


           
        try {
            conn=DBConnection.getConnection();
            statement = conn.prepareStatement("SELECT p.numPr,p.created_at,p.dateRetour,s.cin FROM pret p INNER JOIN subscribers s"
                    + " ON p.subscriber_id = s.id"
                    + " WHERE cin LIKE ? AND dateRetour IS NULL");
            statement.setString(1, "%"+query+"%");
            resultSet = statement.executeQuery();
            
             ArrayList<Object[]> data = new ArrayList<>();
  
        while (resultSet.next()) {
            String numPr = resultSet.getString("numPr");
            String cin = resultSet.getString("cin");
            String dateR = resultSet.getString("dateRetour");
            String date = resultSet.getString("created_at");
            data.add(new Object[]{numPr,cin, date,dateR});
        }

        tableData = data.toArray(new Object[0][]);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return tableData;
    }
    
        public void updatePret(int numPr) throws ParseException{
            Connection conn=null;
            PreparedStatement statement=null;
        try {
            this.dateRetour = new java.sql.Date(System.currentTimeMillis());
           
            conn=DBConnection.getConnection();
            statement = conn.prepareStatement("UPDATE pret SET dateRetour=? WHERE numPr = ? ");
            statement.setDate(1, this.dateRetour);
            statement.setInt(2, numPr);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
    }
}
