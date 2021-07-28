package org.afpa.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class FournisseurDAO {

    public FournisseurDAO() {
    }

    public static HashMap<String, Integer> getFounisNomList()     {

        HashMap<String, Integer> fournisseurList = new HashMap<>();

        try {

            String url = "jdbc:mariadb://localhost:3306/papyrus";
            Connection connection = DriverManager.getConnection(url, "root" , "root");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM fournis");

            while (resultSet.next()) {
                Fournisseur fournis = new Fournisseur();

                fournis.setNomfou(resultSet.getString("nomfou"));
                fournis.setNumfou(resultSet.getInt("numfou"));

                fournisseurList.put(fournis.getNomfou(),fournis.getNumfou());
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

//    public static <String, Integer> getAll() {
//
//        HashMap<String, Integer> hashMap = new HashMap<>();
//
//        try {
//
//            String url = "jdbc:mariadb://localhost:3306/papyrus";
//            Connection connection = DriverManager.getConnection(url, "root" , "root");
//
//            Statement statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM fournis");
//
//            while (resultSet.next()) {
//                hashMap.put(resultSet.getString("nomfou"), resultSet.getInt("numfou"));
//            }
//
//            statement.close();
//            resultSet.close();
//            connection.close();
//
//        } catch (Exception e) {
//            System.out.println("Erreur de lecture 'fournisseur'");
//            System.out.println(e.getMessage());
//        }
//
//        return hashMap;
//    }
}
