package org.afpa.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO {

    public static List<Commande> getFournisCommandes(int numfou){

        List<Commande> commandeList = new ArrayList<Commande>();

        try {

            String url = "jdbc:mariadb://localhost:3306/papyrus";
            Connection connection = DriverManager.getConnection(url, "root" , "root");

            PreparedStatement  preparedStatement = connection.prepareStatement("SELECT numcom, datcom, obscom FROM entcom WHERE numfou=? ");
            preparedStatement.setInt(1, numfou);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Commande commande = new Commande();
                commande.setNumcom(resultSet.getInt("numcom"));
                commande.setDatecom(resultSet.getTimestamp("datcom"));
                commande.setObscom(resultSet.getString("obscom"));
                commandeList.add(commande);
            }

            preparedStatement.close();
            resultSet.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Erreur de lecture 'fournisseur'");
            System.out.println(e.getMessage());
        }

        return commandeList;
    }
}
