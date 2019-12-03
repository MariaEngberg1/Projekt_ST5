package dk.aau.controllers;

import dk.aau.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class IntroController {

    private App mainApp;

    @FXML
    void handleDr_ProgramBnt(ActionEvent event) {
        mainApp.ShowScheme(); 
    }

    @FXML
    void handlePatient_LinkBnt(ActionEvent event) {
        mainApp.showPtCPR();
    }

    public void setMainApp(App mainApp){
        this.mainApp = mainApp;
    }
}