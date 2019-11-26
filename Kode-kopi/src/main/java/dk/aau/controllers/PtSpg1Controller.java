package dk.aau.controllers;

import dk.aau.App;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import dk.aau.controllers.PtRootlayerController;
import dk.aau.models.Generelinfo;
import dk.aau.models.GenerelinfoHandler;
import dk.aau.models.database.DatabaseManipulator;

public class PtSpg1Controller {

    private App mainApp;
    private Generelinfo generelinfo; 

    @FXML
    private TextField NavnTextField;

    @FXML
    private TextField CPRTextField;

    @FXML
    private TextField ArbejdeTextField;

    @FXML
    private TextField MobilTextField;

    @FXML
    private TextField DrTextField;

    @FXML
    private CheckBox JaCheckBox;

    @FXML
    private CheckBox NejCheckbox;

    @FXML
    void initialize() {
         
    }

    public void setMainApp(App mainApp){
        this.mainApp = mainApp;
    }

    public void setInstansOfGeneralPersonInfo(Generelinfo generelinfo){
        this.generelinfo = generelinfo;

        NavnTextField.setPromptText(generelinfo.getNavn());
        CPRTextField.setPromptText(generelinfo.getCPR());
        ArbejdeTextField.setPromptText(generelinfo.getArbejde());
        MobilTextField.setPromptText(generelinfo.getMobil());
        DrTextField.setPromptText(generelinfo.getEgenlaegeNavn());
        CPRTextField.setPromptText(generelinfo.getCPR());  
    }

}