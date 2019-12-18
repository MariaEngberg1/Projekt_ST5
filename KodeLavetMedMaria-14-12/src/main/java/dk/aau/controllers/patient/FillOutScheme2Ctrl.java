package dk.aau.controllers.patient;

import dk.aau.models.patient.Patientinformation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FillOutScheme2Ctrl {
    private Patientinformation patientinformation;

    @FXML
    private Label NarmesteNavnErrorLabel;

    @FXML
    private Label NaermesteTlfErrorLabel;

    @FXML
    private Label NaermesteMobilErrorLabel;

    @FXML
    private Label NaermesteArbejdeErrorLabel_id;

    @FXML
    private TextField NaermesteTelefonTF;

    @FXML
    private TextField naermesteNavnTF;

    @FXML
    private TextField NaermesteMobilTF;

    @FXML
    private TextField NaermesteArbejdeTF;

    /**
     * Function indicate whether all information has been filled
     * @return indicator whether alle info has been filled 
     */
    public Boolean checkIfReadyToPresNext(){
        boolean bool = true; 

        // Check if information regarding closest person has been identified 
        if(naermesteNavnTF.getPromptText().isEmpty() && naermesteNavnTF.getText().isEmpty() ) {
            NarmesteNavnErrorLabel.setText("Ovenstaande information ikke udfyldt");
            NarmesteNavnErrorLabel.setVisible(true); 
            bool = false; 
        }else if(!naermesteNavnTF.getText().isEmpty()) patientinformation.generelInfoPSDB.setNaermesteNavn(naermesteNavnTF.getText());

        // Check if information regarding closest person mobil or TLF has been identified 
        if(NaermesteTelefonTF.getPromptText().isEmpty() && NaermesteTelefonTF.getText().isEmpty() && NaermesteMobilTF.getPromptText().isEmpty() && NaermesteMobilTF.getText().isEmpty()) {
            NaermesteTlfErrorLabel.setText("Ovenstaaende eller nedstaaende infromation ikke udfyld");
            NaermesteTlfErrorLabel.setVisible(true); 
            bool = false; 
        }if (!NaermesteTelefonTF.getText().isEmpty()){
            try{
                int i = Integer.parseInt(NaermesteTelefonTF.getText().trim());
                i = NaermesteTelefonTF.getText().length();
                if (i == 8){
                    patientinformation.generelInfoPSDB.setNaermesteTlf(NaermesteTelefonTF.getText());
                }else {
                    bool = false;
                    NaermesteTlfErrorLabel.setText("Ovenstaaende felt er ikke et korrekt telefon nummer");
                    NaermesteTlfErrorLabel.setVisible(true);
                }
            }catch (NumberFormatException nfe){
                bool = false;
                NaermesteTlfErrorLabel.setText("Ovenstaaende felt er ikke et tal");
                NaermesteTlfErrorLabel.setVisible(true);            
            }
        }if (!NaermesteMobilTF.getText().isEmpty()){
            try{
                int i = Integer.parseInt(NaermesteMobilTF.getText().trim());
                i = NaermesteMobilTF.getText().length();
                if (i == 8){
                    patientinformation.generelInfoPSDB.setNaermesteMobil(NaermesteMobilTF.getText());
                }else {
                    bool = false;
                    NaermesteMobilErrorLabel.setText("Ovenstaaende felt er ikke et korrekt telefon nummer");
                    NaermesteMobilErrorLabel.setVisible(true);
                }
            }catch (NumberFormatException nfe){
                bool = false;
                NaermesteMobilErrorLabel.setText("Ovenstaaende felt er ikke et tal");
                NaermesteMobilErrorLabel.setVisible(true);            
            }
        }

        // Check if information regarding closest person work has been identified 
        if(NaermesteArbejdeTF.getPromptText().isEmpty() && NaermesteArbejdeTF.getText().isEmpty() ) {
            NaermesteArbejdeErrorLabel_id.setText("Ovenstaaende information er ikke udfyldt"); 
            NaermesteArbejdeErrorLabel_id.setVisible(true); 
            bool = false; 
        }else if(!NaermesteArbejdeTF.getText().isEmpty()) patientinformation.generelInfoPSDB.setNaermesteArbejde(NaermesteArbejdeTF.getText());
        
        // Return true if all information is registered 
        return bool; 
    }

    /**
     * Giv this object a reference to the instance of Patientinformation which rootlayer holds
     * @param patientinformation is the object of Patientinformation which holds the validated CPR-nr
     */
    public void setPatientReference(Patientinformation patientinformation){
        this.patientinformation = patientinformation;
        setKnownParameters(patientinformation);        
    }

    /**
     * If values of the views already known, display them
     * @param patientinformaiton is the object of Patientinformation which holds the validated CPR-nr 
     */
    public void setKnownParameters (Patientinformation patientinformaiton) {
        if (!patientinformation.generelInfoPSDB.getNaermesteNavn().isEmpty()) naermesteNavnTF.setPromptText(patientinformation.generelInfoPSDB.getNaermesteNavn());

        if (!patientinformation.generelInfoPSDB.getNaermesteMobil().isEmpty()) NaermesteMobilTF.setPromptText(patientinformation.generelInfoPSDB.getNaermesteMobil());

        if (!patientinformation.generelInfoPSDB.getNaermesteTlf().isEmpty()) NaermesteTelefonTF.setPromptText(patientinformation.generelInfoPSDB.getNaermesteTlf());

        if (!patientinformation.generelInfoPSDB.getNaermesteArbejde().isEmpty()) NaermesteArbejdeTF.setPromptText(patientinformation.generelInfoPSDB.getNaermesteArbejde());
    }   
}