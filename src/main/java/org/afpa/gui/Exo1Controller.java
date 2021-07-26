package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.afpa.Main;

import java.sql.*;

public class Exo1Controller {

    public TextField nomField;
    public TextField adresseField;
    public TextField cpField;
    public TextField villeFiled;
    public TextField contactField;
    public Button rechercheBtn;
    public TextField numFouField;

    public void searchFour(ActionEvent actionEvent) {
        if(!numFouField.getText().equals("") && numFouField.getText().length()<12){

            try {

                String url = "jdbc:mariadb://localhost:3306/papyrus";
                Connection connection = DriverManager.getConnection(url, "root" , "root");
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM fournis WHERE numfou=?");
                preparedStatement.setInt(1,Integer.parseInt(numFouField.getText()));
                ResultSet resultSet =    preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    Main.changeFxml("error1");
                }
                while (resultSet.next()){
                    nomField.setText(resultSet.getString("nomfou"));
                    adresseField.setText(resultSet.getString("ruefou"));
                    cpField.setText(resultSet.getString("posfou"));
                    villeFiled.setText(resultSet.getString("vilfou"));
                    contactField.setText(resultSet.getString("confou"));
                }

                preparedStatement.close();
                resultSet.close();
                connection.close();


            }catch (Exception e){
                System.out.println("Error");
                System.out.println(e.getMessage());
            }
        }

    }
}
