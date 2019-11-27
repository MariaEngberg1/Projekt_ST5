package dk.aau.controllers;

import dk.aau.App;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import dk.aau.controllers.PtRootlayerController;
import dk.aau.models.Generelinfo;
import dk.aau.models.GenerelinfoHandler;
import dk.aau.models.database.DatabaseManipulator;

public class PtSpg1Controller {
    private Generelinfo generelinfo; 
    private PtRootlayerController ptRootlayerController;

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
    private Label NavnIkkeUdfyldtLabel;

    @FXML
    private Label cprIkkeUdfyldtLabel;

    @FXML
    private Label arbejdeIkkeUdfyldLabel;

    @FXML
    private Label mobilIkkeudfyldLabel;

    @FXML
    private Label egenLaegeIkkeUdfyldLabel;



    @FXML
    void initialize() {
         
    }

    public Boolean checkIfReadyToPresNext(){
        boolean bool = false; 
        if(NavnTextField.getPromptText().isEmpty() && NavnTextField.getText().isEmpty() ) {
            NavnIkkeUdfyldtLabel.setVisible(true); 
            bool = true; 
        }else if(!NavnTextField.getText().isEmpty()) generelinfo.setNavn(NavnTextField.getText());
        

        if(CPRTextField.getPromptText().isEmpty() && CPRTextField.getText().isEmpty() ) {
            cprIkkeUdfyldtLabel.setVisible(true); 
            bool = true; 
        }
        

        if(ArbejdeTextField.getPromptText().isEmpty() && ArbejdeTextField.getText().isEmpty() ) {
            arbejdeIkkeUdfyldLabel.setVisible(true); 
            bool = true; 
        }else if(!ArbejdeTextField.getText().isEmpty()) generelinfo.setArbejde(ArbejdeTextField.getText());
        

        if(MobilTextField.getPromptText().isEmpty() && MobilTextField.getText().isEmpty() ) {
            mobilIkkeudfyldLabel.setVisible(true); 
            bool = true; 
        }else if(!MobilTextField.getText().isEmpty()) generelinfo.setMobil(MobilTextField.getText());
        

        if(DrTextField.getPromptText().isEmpty() && DrTextField.getText().isEmpty() ) {
            egenLaegeIkkeUdfyldLabel.setVisible(true); 
            bool = true; 
        }else if(!DrTextField.getText().isEmpty()) generelinfo.setEgenlaegeNavn(DrTextField.getText());
        
        if(bool) return false;
        else return true;
    }
     


    public void setRefrenceToRootlayer(PtRootlayerController ptRootlayerController) {
        this.ptRootlayerController = ptRootlayerController; 
    }

    public void setInstansOfGeneralPersonInfo(Generelinfo generelinfo){
        this.generelinfo = generelinfo;

        NavnTextField.setPromptText(generelinfo.getNavn());
        CPRTextField.setPromptText(generelinfo.getCPR());
        ArbejdeTextField.setPromptText(generelinfo.getArbejde());
        MobilTextField.setPromptText(generelinfo.getMobil());
        DrTextField.setPromptText(generelinfo.getEgenlaegeNavn());
    }

}