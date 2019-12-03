package dk.aau.controllers.sygehus;

import dk.aau.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ShowSchemeCtrl {
    private App mainApp; 

    @FXML
    void handlerOpretBnt(ActionEvent event) {
        mainApp.showSearchPatient("opret"); 
    }

    @FXML
    void handlerTilgaaBnt(ActionEvent event) {
        mainApp.showSearchPatient("tilgaa"); 
    }

    public void setMainApp(App mainApp){
        this.mainApp = mainApp;
    }
}
