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
public class Documents {
        public Documents(){
        }
 public Object[][] getDocuments(String query, String selectedCriteria) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Connection conn = null;
    String sql;
    switch (selectedCriteria) {
        case "id":
            sql = "SELECT d.id, d.cote, d.titre, d.etat, d.type,d.diplome,d.date_parution,d.ISBN,d.editeur, " +
                  "a.nom_auteur, a.prenom_auteur " +
                  "FROM documents d " +
                  "LEFT JOIN documents_authors da ON d.id = da.document_id " +
                  "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
                  "WHERE d.id LIKE ?";
            break;
        case "cote":
            sql = "SELECT d.id, d.cote, d.titre, d.etat, d.type,d.diplome,d.date_parution,d.ISBN,d.editeur, " +
                  "a.nom_auteur, a.prenom_auteur " +
                  "FROM documents d " +
                  "LEFT JOIN documents_authors da ON d.id = da.document_id " +
                  "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
                  "WHERE d.cote LIKE ?";
            break;
        case "etat":
            sql = "SELECT d.id, d.cote, d.titre, d.etat, d.type,d.diplome,d.date_parution,d.ISBN,d.editeur,  " +
                  "a.nom_auteur, a.prenom_auteur " +
                  "FROM documents d " +
                  "LEFT JOIN documents_authors da ON d.id = da.document_id " +
                  "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
                  "WHERE d.etat LIKE ?";
            break;
        case "auteur":
        sql = "SELECT d.id, d.cote,d.titre, d.etat,d.type,d.diplome,d.date_parution,d.ISBN,d.editeur, "
                + "a.nom_auteur,a.prenom_auteur  " +
              "FROM documents d " +
              "LEFT JOIN documents_authors da ON d.id = da.document_id " +
              "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
              "WHERE (a.nom_auteur LIKE ? OR a.prenom_auteur LIKE ?)";
            break;
        case "type":
        sql = "SELECT d.id, d.cote,d.titre, d.etat,d.type,d.diplome,d.date_parution,d.ISBN,d.editeur, "
                + "a.nom_auteur,a.prenom_auteur  " +
              "FROM documents d " +
              "LEFT JOIN documents_authors da ON d.id = da.document_id " +
              "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
              "WHERE d.type LIKE ?";
            break;
        case "titre":
                 sql = "SELECT d.id, d.cote,d.titre, d.etat,d.type,d.diplome,d.date_parution,d.ISBN,d.editeur, "
                         + "a.nom_auteur,a.prenom_auteur  " +
              "FROM documents d " +
              "LEFT JOIN documents_authors da ON d.id = da.document_id " +
              "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
              "WHERE d.titre LIKE ?";
            break;
        default:
            sql = "SELECT d.id, d.cote, d.titre, d.etat, d.type,d.diplome,d.date_parution,d.ISBN,d.editeur, " +
                  "a.nom_auteur, a.prenom_auteur " +
                  "FROM documents d " +
                  "LEFT JOIN documents_authors da ON d.id = da.document_id " +
                  "LEFT JOIN authors a ON da.author_id = a.code_auteur " +
                  "WHERE d.id LIKE ?";
            break;
    }

    Object[][] tableData = null;
        String searchQuery = "%" + query + "%";

    try {
        // Connexion à la base de données
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

        // Parcours des résultats
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String cote = resultSet.getString("cote");
            String titre = resultSet.getString("titre");
            String nomAuteur = resultSet.getString("nom_auteur");
            String prenomAuteur = resultSet.getString("prenom_auteur");
            String date_parution = resultSet.getString("date_parution");
            String type = resultSet.getString("type");
            String isbn = resultSet.getString("ISBN");
            String editeur = resultSet.getString("editeur");
            String etat = resultSet.getString("etat");
            String diplome = resultSet.getString("diplome");
            data.add(new Object[]{id, cote,titre,nomAuteur+" "+prenomAuteur,date_parution,type,diplome,isbn,editeur, etat});
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

    // Mise à jour de l'interface graphique après avoir obtenu les données
 

    return tableData;
}
}
