package org.afpa.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FournisseurDAO {

    public FournisseurDAO() {
    }

    public static ObservableList<Fournisseur> getFounisNomList()     {

        ObservableList<Fournisseur> fournisseurList = FXCollections.observableArrayList();

        try {

            String url = "jdbc:mariadb://localhost:3306/papyrus";
            Connection connection = DriverManager.getConnection(url, "root" , "root");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM fournis");

            while (resultSet.next()) {
                Fournisseur fournis = new Fournisseur();

                fournis.setNomfou(resultSet.getString("nomfou"));
                fournis.setNumfou(resultSet.getInt("numfou"));

                fournisseurList.add(fournis);
            }

            statement.close();
            resultSet.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Erreur de lecture 'fournisseur'");
            System.out.println(e.getMessage());
        }

        return fournisseurList;

    }

}
