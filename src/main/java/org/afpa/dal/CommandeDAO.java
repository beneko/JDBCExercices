package org.afpa.dal;

import org.afpa.model.Commande;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO {

    private static PapyrusDB papyrusDB;

    public CommandeDAO() throws SQLException {
        papyrusDB = new PapyrusDB();
    }

    public List<Commande> getCommandeByFournisseur(int numfou){

        List<Commande> commandeList = new ArrayList<>();

        try {



            ResultSet resultSet;
            if(numfou == 0 ){
                Statement statement = papyrusDB.getCon().createStatement();
                resultSet = statement.executeQuery("SELECT numcom, datcom, obscom FROM entcom");
                statement.close();

            }else{
                PreparedStatement  preparedStatement = papyrusDB.getCon().prepareStatement("SELECT numcom, datcom, obscom FROM entcom WHERE numfou=? ");
                preparedStatement.setInt(1, numfou);
                resultSet = preparedStatement.executeQuery();
                preparedStatement.close();
            }


            while (resultSet.next()) {
                Commande commande = new Commande();
                commande.setNumcom(resultSet.getInt("numcom"));
                commande.setDatecom(resultSet.getTimestamp("datcom"));
                commande.setObscom(resultSet.getString("obscom"));
                commandeList.add(commande);

            }


            resultSet.close();
            papyrusDB.getCon().close();

        } catch (Exception throwable) {
            throwable.printStackTrace();
        }

        return commandeList;
    }
}
