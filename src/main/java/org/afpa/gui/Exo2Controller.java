package org.afpa.gui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import org.afpa.model.Commande;
import org.afpa.model.CommandeDAO;
import org.afpa.model.Fournisseur;
import org.afpa.model.FournisseurDAO;

import java.util.List;


public class Exo2Controller {
    public ComboBox<Fournisseur> comboBox;
    public TextArea textArea;
    public ObservableList<Fournisseur> fournis;

    @FXML
    public void initialize() {

        fournis = FournisseurDAO.getFounisNomList();
        comboBox.setItems(fournis);

    }


    public void getFournisCommandes(ActionEvent actionEvent) {

        Fournisseur fournisseur = comboBox.getSelectionModel().getSelectedItem();
        List<Commande> commandes = CommandeDAO.getFournisCommandes(fournisseur.getNumfou());
        if (commandes.size()>0){
            textArea.clear();
            for(Commande c : commandes){
                textArea.appendText(c.toString()+ "\r\n");
            }
        }else {
            textArea.clear();
        }

    }
}
