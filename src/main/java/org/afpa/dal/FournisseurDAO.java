package org.afpa.dal;

import org.afpa.model.Fournisseur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class FournisseurDAO {

    private static PapyrusDB papyrusDB;
    public FournisseurDAO() throws SQLException{
        papyrusDB = new PapyrusDB();
    }

    public Fournisseur getOne(int numfou){

        Fournisseur fournisseur = new Fournisseur();

        try {

            PreparedStatement preparedStatement = papyrusDB.getCon().prepareStatement("SELECT * FROM fournis WHERE numfou=?");
            preparedStatement.setInt(1,numfou);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                  fournisseur.setNomfou(resultSet.getString("nomfou"));
                  fournisseur.setRuefou(resultSet.getString("ruefou"));
                  fournisseur.setPosfou(resultSet.getString("posfou"));
                  fournisseur.setVilfou(resultSet.getString("vilfou"));
                  fournisseur.setConfou(resultSet.getString("confou"));
            }

        }catch (SQLException throwable){
            throwable.printStackTrace();
        }

        return fournisseur;
    }

    public HashMap<String, Integer> getAll()     {

        HashMap<String, Integer> fournisseurList = new HashMap<>();

        try {


            Statement statement = papyrusDB.getCon().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM fournis");

            while (resultSet.next()) {
                Fournisseur fournis = new Fournisseur();

                fournis.setNomfou(resultSet.getString("nomfou"));
                fournis.setNumfou(resultSet.getInt("numfou"));

                fournisseurList.put(fournis.getNomfou(),fournis.getNumfou());
            }

            statement.close();
            resultSet.close();
            papyrusDB.getCon().close();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return fournisseurList;

    }

    public boolean add(Fournisseur f) {

        try {
            int index = 0;

            Statement statement = papyrusDB.getCon().createStatement();
            ResultSet lastNumFou  = statement.executeQuery("SELECT MAX(numfou) AS lastNumFou FROM fournis");
            while (lastNumFou.next()){
                index = lastNumFou.getInt("lastNumFou");
            }
            System.out.println(index);
            statement.close();
            PreparedStatement stm = papyrusDB.getCon().prepareStatement("INSERT INTO fournis (numfou, nomfou, ruefou, vilfou, posfou, confou) VALUES (?, ?, ?, ?, ?, ?)");

            stm.setInt(1,++index);
            stm.setString(2,f.getNomfou());
            stm.setString(3, f.getRuefou());
            stm.setString(4, f.getVilfou());
            stm.setString(5, f.getPosfou());
            stm.setString(6, f.getConfou());

            stm.execute();

            stm.close();
            papyrusDB.getCon().close();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
    }
}
