package dk.aau.controllers.patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import dk.aau.models.patient.Generelinfo;

public class FillOutScheme1Ctrl {
    private Generelinfo generelinfoTemporyDB;
   
    @FXML
    private Label ArbejdeErrorLabel;

    @FXML
    private Label MobilErrorLabel;

    @FXML
    private Label TelefonErrorLabel;

    @FXML
    private Label indhentErrorLabel;

    @FXML
    private TextField MobilTextField;

    @FXML
    private TextField ArbejdeTextField1;

    @FXML
    private TextField TelefonTextField2;

    @FXML
    private CheckBox jaChechBox_id;

    @FXML
    private CheckBox nejCheckBox_id;

    @FXML
    void handleJaCheckBoc(ActionEvent event) {
        if( jaChechBox_id.isSelected() ){
            nejCheckBox_id.setSelected(false);
            generelinfoTemporyDB.setOkHentOplysninger("true");
        }else{
            nejCheckBox_id.setSelected(true); 
            generelinfoTemporyDB.setOkHentOplysninger("false");  
        }
    }

    @FXML
    void handleNejChechBox(ActionEvent event) {
        if( nejCheckBox_id.isSelected() ){
            jaChechBox_id.setSelected(false);
            generelinfoTemporyDB.setOkHentOplysninger("false");  
        }else{
            jaChechBox_id.setSelected(true); 
            generelinfoTemporyDB.setOkHentOplysninger("true");
        }
    }



    public Boolean checkIfReadyToPresNext(){
        boolean bool = true; 

        if(MobilTextField.getPromptText().isEmpty() && MobilTextField.getText().isEmpty() ) {
            MobilErrorLabel.setText("Ovenstaande felt er ikke udfyld");
            MobilErrorLabel.setVisible(true); 
            bool = false; 
        }else if (!MobilTextField.getText().isEmpty()){
            try{
                int i = Integer.parseInt(MobilTextField.getText().trim());
                i = MobilTextField.getText().length();
                if (i == 8){
                    generelinfoTemporyDB.setMobilNummer(MobilTextField.getText());
                }else {
                    bool = false;
                    MobilErrorLabel.setText("Ovenstaaende felt er ikke et korrekt mobil");
                    MobilErrorLabel.setVisible(true);
                }
            }catch (NumberFormatException nfe){
                bool = false;
                MobilErrorLabel.setText("Ovenstaaende felt er ikke et tal");
                MobilErrorLabel.setVisible(true);            
            }
        }
            
        if(ArbejdeTextField1.getPromptText().isEmpty() && ArbejdeTextField1.getText().isEmpty() ) {
            ArbejdeErrorLabel.setText("Nedstaaende felt er ikke udfyld");
            ArbejdeErrorLabel.setVisible(true); 
            bool = false; 
        }else if(!ArbejdeTextField1.getText().isEmpty()) generelinfoTemporyDB.setArbejde(ArbejdeTextField1.getText());



        if(TelefonTextField2.getPromptText().isEmpty() && TelefonTextField2.getText().isEmpty() ) {
            TelefonErrorLabel.setText("Ovenstaande felt er ikke udfyld");
            TelefonErrorLabel.setVisible(true); 
            bool = false; 
        }else if (!TelefonTextField2.getText().isEmpty()){
            try{
                int i = Integer.parseInt(TelefonTextField2.getText().trim());
                i = TelefonTextField2.getText().length();
                if (i == 8){
                    generelinfoTemporyDB.setTelefonNummer(TelefonTextField2.getText());
                }else {
                    bool = false;
                    TelefonErrorLabel.setText("Ovenstaaende felt er ikke et korrekt telefon nummer");
                    TelefonErrorLabel.setVisible(true);
                }
            }catch (NumberFormatException nfe){
                bool = false;
                TelefonErrorLabel.setText("Ovenstaaende felt er ikke et tal");
                TelefonErrorLabel.setVisible(true);            
            }
        }
        
        
        if(!jaChechBox_id.isSelected() && !nejCheckBox_id.isSelected()){
            indhentErrorLabel.setText("Ovenstaaende checkbokse er ikke udfyldte");
            indhentErrorLabel.setVisible(true); 
            bool = false; 
        }
        else if (jaChechBox_id.isSelected()) generelinfoTemporyDB.setOkHentOplysninger("true"); 
        else if (nejCheckBox_id.isSelected()) generelinfoTemporyDB.setOkHentOplysninger("false"); 

        return bool; 
    }

    public void setInstansOfGeneralPersonInfo(Generelinfo generelinfoTemporyDB, Generelinfo generelinfoClinicalSuiteDB){
        this.generelinfoTemporyDB = generelinfoTemporyDB;

        if (generelinfoTemporyDB.getMobilNummer().isEmpty()) MobilTextField.setPromptText(generelinfoClinicalSuiteDB.getMobilNummer());
        else  MobilTextField.setPromptText(generelinfoTemporyDB.getMobilNummer());

        ArbejdeTextField1.setPromptText(generelinfoTemporyDB.getArbejde());

        if (generelinfoTemporyDB.getTelefonNummer().isEmpty()) TelefonTextField2.setPromptText(generelinfoClinicalSuiteDB.getTelefonNummer());
        else TelefonTextField2.setPromptText(generelinfoTemporyDB.getTelefonNummer());
        
        if (!generelinfoTemporyDB.getOkHentOplysninger().isEmpty()){
            if (generelinfoTemporyDB.getOkHentOplysninger().equals("true")) jaChechBox_id.setSelected(true);
            else nejCheckBox_id.setSelected(true);
        }
    }
}