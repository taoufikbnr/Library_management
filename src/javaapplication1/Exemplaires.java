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

/**
 *
 * @author lenovo
 */
public class Exemplaires {
    int documentId;
    int etagereId;
    String statut="disponible";
    
    public Exemplaires(){

    }

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
    
    
    public Object[][] getExemplaires(String docId) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Connection conn = null;
  String sql = "SELECT d.id, d.cote, d.titre, d.etat, " +
             "a.nom_auteur, a.prenom_auteur, " +
             "et.numEt, pl.numPl, e.statut,e.numEx " +
             "FROM documents d " +
             "INNER JOIN documents_authors da ON d.id = da.document_id " + 
             "INNER JOIN authors a ON da.author_id = a.code_auteur " + 
             "INNER JOIN exemplaires e ON d.id = e.document_id " + 
             "LEFT JOIN etageres et ON et.id = e.etagere_id " + 
             "LEFT JOIN placards pl ON pl.numPl = et.placard_id " +  
             "WHERE d.id = ?"; 


    Object[][] tableData = null;

    try {
        conn = DBConnection.getConnection();
        statement = conn.prepareStatement(sql);
  
            statement.setString(1, docId); 
        resultSet = statement.executeQuery();

        ArrayList<Object[]> data = new ArrayList<>();
  
        while (resultSet.next()) {
            String exId = resultSet.getString("numEx");
            String id = resultSet.getString("id");
            String cote = resultSet.getString("cote");
            String titre = resultSet.getString("titre");
            String nomAuteur = resultSet.getString("nom_auteur");
            String prenomAuteur = resultSet.getString("prenom_auteur");
            String placard = resultSet.getString("numPl");
            String etagere = resultSet.getString("numEt");
            this.statut = resultSet.getString("statut");
            data.add(new Object[]{exId,id, cote,titre,nomAuteur+" "+prenomAuteur,placard,etagere,statut});;
        }

        // Conversion de la liste en tableau 2D
        tableData = data.toArray(new Object[0][]);

    } catch (SQLException e) {
        // Gestion des erreurs SQL
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // Fermeture des ressources dans un bloc finally
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

    return tableData;
}
}
