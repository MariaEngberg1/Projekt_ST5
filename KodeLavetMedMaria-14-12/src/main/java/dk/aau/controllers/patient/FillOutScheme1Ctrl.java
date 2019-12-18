package dk.aau.controllers.patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import dk.aau.models.patient.Patientinformation;

public class FillOutScheme1Ctrl {
    private Patientinformation patientinformation;
   
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
            patientinformation.generelInfoPSDB.setOkHentOplysninger("true");
        }else{
            nejCheckBox_id.setSelected(true); 
            patientinformation.generelInfoPSDB.setOkHentOplysninger("false");  
        }
    }

    @FXML
    void handleNejChechBox(ActionEvent event) {
        if( nejCheckBox_id.isSelected() ){
            jaChechBox_id.setSelected(false);
            patientinformation.generelInfoPSDB.setOkHentOplysninger("false");  
        }else{
            jaChechBox_id.setSelected(true); 
            patientinformation.generelInfoPSDB.setOkHentOplysninger("true");
        }
    }


    /**
     * Function indicate whether all information has been filled
     * @return indicator whether all info has been filled 
     */
    public Boolean checkIfReadyToPresNext(){
        boolean bool = true; 

        // Check if information regarding mobil-nr has been identified 
        if(MobilTextField.getPromptText().isEmpty() && MobilTextField.getText().isEmpty() ) {
            MobilErrorLabel.setText("Ovenstaande felt er ikke udfyld");
            MobilErrorLabel.setVisible(true); 
            bool = false; 
        }else if (!MobilTextField.getText().isEmpty()){
            try{
                int i = Integer.parseInt(MobilTextField.getText().trim());
                i = MobilTextField.getText().length();
                if (i == 8){
                    patientinformation.generelInfoPSDB.setMobilNummer(MobilTextField.getText());
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
            
        // Check if information regarding work has been identified 
        if(ArbejdeTextField1.getPromptText().isEmpty() && ArbejdeTextField1.getText().isEmpty() ) {
            ArbejdeErrorLabel.setText("Ovenstaaende felt er ikke udfyld");
            ArbejdeErrorLabel.setVisible(true); 
            bool = false; 
        }else if(!ArbejdeTextField1.getText().isEmpty()) patientinformation.generelInfoPSDB.setArbejde(ArbejdeTextField1.getText());


        // Check if information regarding tlf-nr has been identified 
        if(TelefonTextField2.getPromptText().isEmpty() && TelefonTextField2.getText().isEmpty() ) {
            TelefonErrorLabel.setText("Ovenstaande felt er ikke udfyld");
            TelefonErrorLabel.setVisible(true); 
            bool = false; 
        }else if (!TelefonTextField2.getText().isEmpty()){
            try{
                int i = Integer.parseInt(TelefonTextField2.getText().trim());
                i = TelefonTextField2.getText().length();
                if (i == 8){
                    patientinformation.generelInfoPSDB.setTelefonNummer(TelefonTextField2.getText());
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
        
        // Check if information regarding consent has been identified 
        if(!jaChechBox_id.isSelected() && !nejCheckBox_id.isSelected()){
            indhentErrorLabel.setText("Ovenstaaende checkbokse er ikke udfyldte");
            indhentErrorLabel.setVisible(true); 
            bool = false; 
        }
        else if (jaChechBox_id.isSelected()) patientinformation.generelInfoPSDB.setOkHentOplysninger("true"); 
        else if (nejCheckBox_id.isSelected()) patientinformation.generelInfoPSDB.setOkHentOplysninger("false"); 

        // Return true if all information is registered 
        return bool; 
    }

    /**
     * Giv this object a reference to the instance of Patientinformation which rootlayer holds
     * @param patientinformation is the object of Patientinformation which holds the validated CPR-nr
     */
    public void setPatientReference(Patientinformation patientinformation){
        this.patientinformation = patientinformation;
        setKnownParameters (patientinformation);
    }

    /**
     * If values of the views already known, display them
     * @param patientinformaiton is the object of Patientinformation which holds the validated CPR-nr 
     */
    public void setKnownParameters (Patientinformation patientinformaiton) {
        if (!patientinformation.generelInfoPSDB.getMobilNummer().isEmpty()) MobilTextField.setPromptText(patientinformation.generelInfoPSDB.getMobilNummer());

        if (!patientinformation.generelInfoPSDB.getArbejde().isEmpty()) ArbejdeTextField1.setPromptText(patientinformation.generelInfoPSDB.getArbejde());

        if (!patientinformation.generelInfoPSDB.getTelefonNummer().isEmpty()) TelefonTextField2.setPromptText(patientinformation.generelInfoPSDB.getTelefonNummer());

        if (!patientinformation.generelInfoPSDB.getOkHentOplysninger().isEmpty()){
            if (patientinformation.generelInfoPSDB.getOkHentOplysninger().equals("true")) jaChechBox_id.setSelected(true);
            else nejCheckBox_id.setSelected(true);
        } 
    }
}