/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author lenovo
 */
public class Documents {
        
        int cote;
        String titre;
        String date;
        String etat;
        String type;
        String isbn;
        String editeur;
        String diplome;
        String theme;
        public Documents(int cote,String titre,String date,String etat,String type,String editeur,String isbn,String diplome,String theme ){
            this.cote=cote;
            this.titre=titre;
            this.date=date;
            this.etat=etat;
            this.type=type;
            this.isbn=isbn;
            this.editeur=editeur;
            this.diplome=diplome;
            this.theme=theme;
        }
        public Documents(){
        }
        
        
  public int addDocument(){
       Connection conn=null;
       PreparedStatement statement=null;
       ResultSet generatedKeys = null;
        int docId = -1;
        
        try {
      conn = DBConnection.getConnection();
      String sql = "INSERT INTO documents (cote, titre, date_parution,etat,type, isbn, editeur, diplome,theme) VALUES (?,?,?,?,?,?,?,?,?)";
        statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    

    
    SimpleDateFormat inputFormat = new SimpleDateFormat("d MMMM yyyy", Locale.FRENCH);  
    java.util.Date utilDate = inputFormat.parse(this.date);             
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());  
  

    statement.setInt(1, cote);
    statement.setString(2, this.titre);
    statement.setDate(3, sqlDate); 
    statement.setString(4, (String) this.etat);
    statement.setString(5, this.type);
    
    if ("ouvrage".equals( this.type)) {
        statement.setString(6, this.isbn); 
        statement.setString(7, this.editeur); 
        statement.setString(8, null); 
    } else {
        statement.setString(6, null); 
        statement.setString(7, null); 
        statement.setString(8, this.diplome); 
    }
    statement.setString(9, this.theme);
    
        int affectedRows = statement.executeUpdate();
    
            if (affectedRows > 0) {
           
            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                docId = generatedKeys.getInt(1);  
            }
        }
    
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding users: " + e.getMessage());
        } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Error adding users: " + ex.getMessage());

         Logger.getLogger(AddDocumentUI.class.getName()).log(Level.SEVERE, null, ex);
     }
         return docId;
    }      
        
  
      public void deleteDocument(String id){
         Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
            
 try {
            conn = DBConnection.getConnection();
            statement = conn.prepareStatement("DELETE FROM documents WHERE id = ?");
            statement.setString(1,id);
            statement.executeUpdate();      
  
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ereur, y'a des exemplaire pour ce document!");
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
      
        
 public Object[][] getDocuments(String query, String selectedCriteria) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Connection conn = null;
    String sql;
    switch (selectedCriteria) {
        case "id":
            sql = "SELECT d.id, d.cote, d.titre, d.etat, d.type,d.diplome,d.date_parution,d.ISBN,d.editeur,d.theme, " +
                  "a.nom_auteur, a.prenom_auteur " +
                  "FROM documents d " +
                  "LEFT JOIN documents_authors da ON d.id = da.document_id " +
                  "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
                  "WHERE d.id = ?";
            break;
        case "cote":
            sql = "SELECT d.id, d.cote, d.titre, d.etat, d.type,d.diplome,d.date_parution,d.ISBN,d.editeur,d.theme,  " +
                  "a.nom_auteur, a.prenom_auteur " +
                  "FROM documents d " +
                  "LEFT JOIN documents_authors da ON d.id = da.document_id " +
                  "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
                  "WHERE d.cote = ?";
            break;
        case "etat":
            sql = "SELECT d.id, d.cote, d.titre, d.etat, d.type,d.diplome,d.date_parution,d.ISBN,d.editeur,d.theme,   " +
                  "a.nom_auteur, a.prenom_auteur " +
                  "FROM documents d " +
                  "LEFT JOIN documents_authors da ON d.id = da.document_id " +
                  "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
                  "WHERE d.etat LIKE ?";
            break;
        case "auteur":
        sql = "SELECT d.id, d.cote,d.titre, d.etat,d.type,d.diplome,d.date_parution,d.ISBN,d.editeur,d.theme, "
                + "a.nom_auteur,a.prenom_auteur  " +
              "FROM documents d " +
              "LEFT JOIN documents_authors da ON d.id = da.document_id " +
              "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
              "WHERE (a.nom_auteur LIKE ? OR a.prenom_auteur LIKE ?)";
            break;
        case "type":
        sql = "SELECT d.id, d.cote,d.titre, d.etat,d.type,d.diplome,d.date_parution,d.ISBN,d.editeur,d.theme,  "
                + "a.nom_auteur,a.prenom_auteur  " +
              "FROM documents d " +
              "LEFT JOIN documents_authors da ON d.id = da.document_id " +
              "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
              "WHERE d.type LIKE ?";
            break;
        case "titre":
                 sql = "SELECT d.id, d.cote,d.titre, d.etat,d.type,d.diplome,d.date_parution,d.ISBN,d.editeur,d.theme,  "
                         + "a.nom_auteur,a.prenom_auteur  " +
              "FROM documents d " +
              "LEFT JOIN documents_authors da ON d.id = da.document_id " +
              "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
              "WHERE d.titre LIKE ?";
            break;
        case "theme":
                 sql = "SELECT d.id, d.cote,d.titre, d.etat,d.type,d.diplome,d.date_parution,d.ISBN,d.editeur,d.theme,  "
                         + "a.nom_auteur,a.prenom_auteur  " +
              "FROM documents d " +
              "LEFT JOIN documents_authors da ON d.id = da.document_id " +
              "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
              "WHERE d.theme LIKE ?";
            break;
        case "editeur":
                 sql = "SELECT d.id, d.cote,d.titre, d.etat,d.type,d.diplome,d.date_parution,d.ISBN,d.editeur,d.theme,  "
                         + "a.nom_auteur,a.prenom_auteur  " +
              "FROM documents d " +
              "LEFT JOIN documents_authors da ON d.id = da.document_id " +
              "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
              "WHERE d.editeur LIKE ?";
            break;
        default:
            sql = "SELECT d.id, d.cote, d.titre, d.etat, d.type,d.diplome,d.date_parution,d.ISBN,d.editeur,d.theme,  " +
                  "a.nom_auteur, a.prenom_auteur " +
                  "FROM documents d " +
                  "LEFT JOIN documents_authors da ON d.id = da.document_id " +
                  "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
                  "WHERE d.id LIKE ?";
            break;
    }

    Object[][] tableData = null;
        String searchQuery = selectedCriteria.equals("id") || selectedCriteria.equals("cote")?query:"%" + query + "%";

    try {
        conn = DBConnection.getConnection();
        statement = conn.prepareStatement(sql);
         if (selectedCriteria.equals("auteur")) {
            statement.setString(1, searchQuery);  
            statement.setString(2, searchQuery);  
        } else {
            statement.setString(1, searchQuery); 
        }
        resultSet = statement.executeQuery();

        ArrayList<Object[]> data = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String cote = resultSet.getString("cote");
            this.titre = resultSet.getString("titre");
            String nomAuteur = resultSet.getString("nom_auteur");
            String prenomAuteur = resultSet.getString("prenom_auteur");
            String date_parution = resultSet.getString("date_parution");
            this.type = resultSet.getString("type");
            this.isbn = resultSet.getString("ISBN");
            this.editeur = resultSet.getString("editeur");
            this.etat = resultSet.getString("etat");
            this.diplome = resultSet.getString("diplome");
            this.theme = resultSet.getString("theme");
            data.add(new Object[]{id, cote,titre,nomAuteur+" "+prenomAuteur,theme,date_parution,type,diplome,editeur,isbn, etat});
        }

        // Conversion de la liste en tableau 2D
        tableData = data.toArray(new Object[0][]);

    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    } finally {
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
 public void updateDocument(String id){
       Connection conn=null;
       PreparedStatement statement=null;
        
        try {
      conn = DBConnection.getConnection();
      String sql = "UPDATE documents SET  titre=?, date_parution=?,etat=?,type=?, isbn=?, editeur=?, diplome=?,theme=? WHERE id=?";
        statement = conn.prepareStatement(sql);
    
    
    SimpleDateFormat inputFormat = new SimpleDateFormat("d MMMM yyyy", Locale.FRENCH);  
    java.util.Date utilDate = inputFormat.parse(this.date);             
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());  
  
    statement.setString(1, this.titre);
    statement.setDate(2, sqlDate); 
    statement.setString(3, this.etat);
    statement.setString(4, this.type);
    
    if ("ouvrage".equals(this.type)) {
        statement.setString(5, this.isbn); 
        statement.setString(6, this.editeur); 
        statement.setString(7, null); 
    } else {
        statement.setString(5, null); 
        statement.setString(6, null); 
        statement.setString(7, this.diplome); 
    }
        statement.setString(8, this.theme);
        statement.setString(9, id);

        statement.executeUpdate();

    
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding users: " + e.getMessage());
        } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Error adding users: " + ex.getMessage());

         Logger.getLogger(UpdateDocumentUI.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
 
 
 
}
