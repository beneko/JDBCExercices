package org.afpa.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import org.afpa.Main;
import java.io.IOException;


public class HomeController {


    public Button exo1;
    public Button exo2;
    public Button exo3;

    public void newWindow(ActionEvent actionEvent) throws IOException {
        Button button = (Button) actionEvent.getSource();
        Main.changeFxml(button.getId());
    }
}
