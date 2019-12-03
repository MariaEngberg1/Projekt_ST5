package dk.aau.controllers.patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import dk.aau.models.Generelinfo;

public class FillOutScheme1Ctrl {
    private Generelinfo generelinfo; 

    @FXML
    private TextField ArbejdeTextField;

    @FXML
    private TextField MobilTextField;

    @FXML
    private TextField TelefonTextField;

    @FXML
    private TextField AdresseTextField;

    @FXML
    private TextField DrTextField;

    @FXML
    private CheckBox JaCheckBox;

    @FXML
    private CheckBox NejCheckbox;

    @FXML
    private Label ArbejdeIkkeUdfyldtLabel;

    @FXML
    private Label MobilkkeUdfyldtLabel;

    @FXML
    private Label TelefonIkkeUdfyldLabel;

    @FXML
    private Label AdresseIkkeudfyldLabel;

    @FXML
    private Label egenLaegeIkkeUdfyldLabel;

    @FXML
    private Label HentOplysningerIkkeUdfyldLabel;

    @FXML
    void handleJaCheckBox(ActionEvent event) {
        if( JaCheckBox.isSelected() ){
            NejCheckbox.setSelected(false);
            generelinfo.setOkHentOplysninger("true");
        }else{
            NejCheckbox.setSelected(true); 
            generelinfo.setOkHentOplysninger("false");  
        }
    }

    @FXML
    void handleNejCheckbox(ActionEvent event) {
        if( NejCheckbox.isSelected() ){
            JaCheckBox.setSelected(false);
            generelinfo.setOkHentOplysninger("false");  
        }else{
            JaCheckBox.setSelected(true); 
            generelinfo.setOkHentOplysninger("true");
        }
    }


    public Boolean checkIfReadyToPresNext(){
        boolean bool = true; 
        if(ArbejdeTextField.getPromptText().isEmpty() && ArbejdeTextField.getText().isEmpty() ) {
            ArbejdeIkkeUdfyldtLabel.setVisible(true); 
            bool = false; 
        }else if(!ArbejdeTextField.getText().isEmpty()) generelinfo.setArbejde(ArbejdeTextField.getText());
        

        if(MobilTextField.getPromptText().isEmpty() && MobilTextField.getText().isEmpty() ) {
            MobilkkeUdfyldtLabel.setVisible(true); 
            bool = false; 
        }else if(!MobilTextField.getText().isEmpty()) generelinfo.setMobilNummer(MobilTextField.getText());


        if(TelefonTextField.getPromptText().isEmpty() && TelefonTextField.getText().isEmpty() ) {
            TelefonIkkeUdfyldLabel.setVisible(true); 
            bool = false; 
        }else if(!TelefonTextField.getText().isEmpty()) generelinfo.setTelefonNummer(TelefonTextField.getText());
        

        if(AdresseTextField.getPromptText().isEmpty() && AdresseTextField.getText().isEmpty() ) {
            AdresseIkkeudfyldLabel.setVisible(true); 
            bool = false; 
        }else if(!AdresseTextField.getText().isEmpty()) generelinfo.setAdresse(AdresseTextField.getText());
        

        if(DrTextField.getPromptText().isEmpty() && DrTextField.getText().isEmpty() ) {
            egenLaegeIkkeUdfyldLabel.setVisible(true); 
            bool = false; 
        }else if(!DrTextField.getText().isEmpty()) generelinfo.setEgenLaegeNavn(DrTextField.getText());
        
        if(!JaCheckBox.isSelected() && !NejCheckbox.isSelected()){
            HentOplysningerIkkeUdfyldLabel.setVisible(true); 
            bool = false; 
        }
        else if (JaCheckBox.isSelected()) generelinfo.setOkHentOplysninger("true"); 
        else if (NejCheckbox.isSelected()) generelinfo.setOkHentOplysninger("false"); 


        return bool; 
    }

    public void setInstansOfGeneralPersonInfo(Generelinfo generelinfo){
        this.generelinfo = generelinfo;

        ArbejdeTextField.setPromptText(generelinfo.getArbejde());
        MobilTextField.setPromptText(generelinfo.getMobilNummer());
        TelefonTextField.setPromptText(generelinfo.getTelefonNummer());
        AdresseTextField.setPromptText(generelinfo.getAdresse());
        DrTextField.setPromptText(generelinfo.getEgenLaegeNavn());
    }

}