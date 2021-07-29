package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.afpa.dal.FournisseurDAO;
import org.afpa.model.Fournisseur;

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
                FournisseurDAO fournisseurDAO = new FournisseurDAO();
                Fournisseur fournisseur = fournisseurDAO.getOne(Integer.parseInt(numFouField.getText()));
                if(fournisseur.toString() != null){

                    nomField.setText(fournisseur.getNomfou());
                    adresseField.setText(fournisseur.getRuefou());
                    cpField.setText(fournisseur.getPosfou());
                    villeFiled.setText(fournisseur.getVilfou());
                    contactField.setText(fournisseur.getConfou());

                }else {
                    nomField.clear();
                    adresseField.clear();
                    cpField.clear();
                    villeFiled.clear();
                    contactField.clear();
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("le fournisseur n'existe pas !!");
                    alert.showAndWait();
                }

            }catch (Exception e){
                System.out.println("Error");
                System.out.println(e.getMessage());
            }
        }

    }
}
