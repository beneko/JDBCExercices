package org.afpa.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import org.afpa.model.Commande;
import org.afpa.dal.CommandeDAO;
import org.afpa.dal.FournisseurDAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


public class Exo2Controller {

    public ComboBox<String> comboBox;
    public TextArea textArea;
    public HashMap <String, Integer> fournisseurList;

    @FXML
    public void initialize() throws SQLException {
        ObservableList<String> fournis = FXCollections.observableArrayList();
        FournisseurDAO fournisseurDAO = new FournisseurDAO();
        fournisseurList = fournisseurDAO.getAll();
        fournisseurList.put("Tous",0);
        fournis.addAll(fournisseurList.keySet());
        comboBox.setItems(fournis);
//        System.out.println(fournisseurList);
    }


    public void getCommandes(ActionEvent actionEvent) throws SQLException {

        String nomFou = comboBox.getSelectionModel().getSelectedItem();
        CommandeDAO commandeDAO = new CommandeDAO();
        List<Commande> commandes = commandeDAO.getCommandeByFournisseur(fournisseurList.get(nomFou));

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
