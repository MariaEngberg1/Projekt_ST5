package dk.aau.controllers;

import dk.aau.App;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import dk.aau.controllers.PtRootlayerController;

public class PtSpg1Controller {

    private App mainApp;
    
    @FXML
    private TextField NavnTextField;

    @FXML
    private TextField CPRTextField;

    @FXML
    private TextField ArbejdeTextField;

    @FXML
    private TextField MobilTextField;

    @FXML
    private TextField LægeTextField;

    @FXML
    private CheckBox JaCheckBox;

    @FXML
    private CheckBox NejCheckbox;

    @FXML
    void initialize() {
        PtRootlayerController.tilbageknapsynlig(false); 
    }

    public void setMainApp(App mainApp){
        this.mainApp = mainApp;
    }

}