package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.afpa.dal.FournisseurDAO;
import org.afpa.model.Fournisseur;

import java.sql.SQLException;

public class Exo3Controller {

    public TextField nomField;
    public TextField adresseField;
    public TextField cpField;
    public TextField villeFiled;
    public TextField contactField;

    public Label contactError;
    public Label villeError;
    public Label adresseError;
    public Label nomError;
    public Label cpError;

    public Button addBtn;
    public Button cancelBtn;

    public static String adresseRegex = "[\\d]+[A-Za-z0-9\\s,\\.]+";
    public static String nomRegex = "^[A-Za-z]+$";
    public static String cpRegex = "[0-9]{5}";


    public void add(ActionEvent actionEvent) throws SQLException {
        if(!nomField.getText().matches(nomRegex) || nomField.getText().equals("")){
            nomError.setVisible(true);
            nomError.setText("Veuillez entrer un nom valide !");
        }else{
            nomError.setVisible(false);
        }
        if(!adresseField.getText().matches(adresseRegex) || adresseField.getText().equals("")){
            adresseError.setVisible(true);
            adresseError.setText("Veuillez entrer une adresse valide !");
        }else{
            adresseError.setVisible(false);
        }
        if(!cpField.getText().matches(cpRegex) || cpField.getText().equals("")){
            cpError.setVisible(true);
            cpError.setText("Veuillez entrer un code postal valide !");
        }else{
            cpError.setVisible(false);
        }
        if(!villeFiled.getText().matches(nomRegex) || villeFiled.getText().equals("")){
            villeError.setVisible(true);
            villeError.setText("Veuillez entrer une ville valide !");
        }else{
            villeError.setVisible(false);
        }
        if(!contactField.getText().matches(nomRegex) || contactField.getText().equals("")){
            contactError.setVisible(true);
            contactError.setText("Veuillez entrer un contact valide !");
        }else{
            contactError.setVisible(false);
        }

        if(!adresseError.isVisible() && !nomError.isVisible() && !villeError.isVisible() && !contactError.isVisible() && !cpError.isVisible() ){

            Fournisseur fournisseur = new Fournisseur(nomField.getText(),adresseField.getText(),cpField.getText(),villeFiled.getText(),contactField.getText());
            FournisseurDAO fournisseurDAO = new FournisseurDAO();

            if(fournisseurDAO.add(fournisseur)){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("le fournisseur a bien été ajouter !!");
                alert.showAndWait();

            }else{

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("le fournisseur n'a pas été ajouter !!");
                alert.showAndWait();
            }
        }
    }
    public void cancel(ActionEvent actionEvent) {
        nomField.clear();
        adresseField.clear();
        cpField.clear();
        villeFiled.clear();
        contactField.clear();

        nomError.setVisible(false);
        adresseError.setVisible(false);
        cpError.setVisible(false);
        villeError.setVisible(false);
        contactError.setVisible(false);
    }
}
