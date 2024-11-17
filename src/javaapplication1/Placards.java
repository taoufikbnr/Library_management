/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author lenovo
 */
public class Placards {
    int numPl;
    String libellePl;
    
    public Placards(){
    }
    
    public Placards(String libelle){
        this.libellePl=libelle;
    }
 
    public void addPlacard(){
        Connection conn=null;
        PreparedStatement statement=null;
        try {
            conn=DBConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO placards (libellePl) VALUES (?)");
            statement.setString(1, this.libellePl);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
    }
    public Object[][] getPlacards(){
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet resultSet = null;
        Object[][] tableData=null;
        try {
            conn=DBConnection.getConnection();
            statement = conn.prepareStatement("SELECT p.numPl,e.numEt,e.libelleEt,p.libellePl FROM placards p LEFT JOIN etageres e "
                    + "ON p.numpl=e.placard_id");
            resultSet = statement.executeQuery();
             ArrayList<Object[]> data = new ArrayList<>();

            while (resultSet.next()) {
                this.numPl = resultSet.getInt("numPl");
                int numEt = resultSet.getInt("numEt");
                this.libellePl = resultSet.getString("libellePl");
                String libelleEt = resultSet.getString("libelleEt");
                data.add(new Object[]{numPl,libellePl,numEt,libelleEt});
            }
            tableData = data.toArray(new Object[0][]);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        return tableData;
   }
}
