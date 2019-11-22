package dk.aau.controllers;

import dk.aau.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;

public class PtRootlayerController {

    private App mainApp;

    @FXML
    private Button NæsteBtn;

    @FXML
    private static Button TilbageBtn;

    static void tilbageknapsynlig(Boolean bool) {
        //TilbageBtn.setVisible(bool);
    } 

    @FXML
    private ProgressBar ProgressBar;

    @FXML
    private Text Overskrift;

    @FXML
    void handleNæsteBtn(ActionEvent event) {
        mainApp.showPtSlut();
    }

    @FXML
    void handleTilbageBtn(ActionEvent event) {
        mainApp.showPtSpg1();
    }

    public void setMainApp(App mainApp){
        this.mainApp = mainApp;
    }
}