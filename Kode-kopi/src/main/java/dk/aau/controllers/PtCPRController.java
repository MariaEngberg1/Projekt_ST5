package dk.aau.controllers;

import dk.aau.App;
import dk.aau.models.GenerelinfoHandler;
import dk.aau.models.database.*;
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
        GenerelinfoHandler gih = new GenerelinfoHandler();
        DatabaseManipulator.executeQueryWithResultSet(gih);

        int pladsnr = 0;
        int size = gih.getSizeOfGenerelinfoListe();
        boolean isCPRcorrect = false; 

        for (int i = 0; i<size; i++){ 
            if (CPRnummerTextField.getText().equals(gih.getGenerelinfoListe(i).getCPR())) {
                isCPRcorrect = true; 
                pladsnr = i;
            }
        }

        if (isCPRcorrect){
            mainApp.showPtRootlayer();
            mainApp.showPtSpg1(gih.getGenerelinfoListe(pladsnr)); 
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