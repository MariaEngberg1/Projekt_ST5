package dk.aau.controllers;

import dk.aau.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PtCPRController {

    private App mainApp;

    @FXML
    private TextField CPRnummerTextField;

    @FXML
    void handleEnterBtn(ActionEvent event) {
        if (CPRnummerTextField.getText().equals("01012000-1143")) {
            mainApp.showPtRootlayer();
            mainApp.showPtSpg1();
        }
        else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("ERROR");
            alert.setHeaderText("Forkert CPR-nummer");
            alert.setContentText("Prøv venligst igen, hvis det ikke virker, ring 64987897");
            alert.showAndWait();
        } 
    }

    public void setMainApp(App mainApp){
        this.mainApp = mainApp;
    }
}