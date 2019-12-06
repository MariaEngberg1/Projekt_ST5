package dk.aau.controllers.patient;

import dk.aau.models.patient.Generelinfo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FillOutScheme2Ctrl {
    private Generelinfo generelinfoTemporyDB;

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


    public Boolean checkIfReadyToPresNext(){
        boolean bool = true; 
        if(naermesteNavnTF.getPromptText().isEmpty() && naermesteNavnTF.getText().isEmpty() ) {
            NarmesteNavnErrorLabel.setText("Ovenstaande information ikke udfyldt");
            NarmesteNavnErrorLabel.setVisible(true); 
            bool = false; 
        }else if(!naermesteNavnTF.getText().isEmpty()) generelinfoTemporyDB.setNaermesteNavn(naermesteNavnTF.getText());


        if(NaermesteTelefonTF.getPromptText().isEmpty() && NaermesteTelefonTF.getText().isEmpty() && NaermesteMobilTF.getPromptText().isEmpty() && NaermesteMobilTF.getText().isEmpty()) {
            NaermesteTlfErrorLabel.setText("Ovenstaaende eller nedstaaende infromation ikke udfyld");
            NaermesteTlfErrorLabel.setVisible(true); 
            bool = false; 
        }if (!NaermesteTelefonTF.getText().isEmpty()){
            try{
                int i = Integer.parseInt(NaermesteTelefonTF.getText().trim());
                i = NaermesteTelefonTF.getText().length();
                if (i == 8){
                    generelinfoTemporyDB.setNaermesteTlf(NaermesteTelefonTF.getText());
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
                    generelinfoTemporyDB.setNaermesteMobil(NaermesteMobilTF.getText());
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

    
        if(NaermesteArbejdeTF.getPromptText().isEmpty() && NaermesteArbejdeTF.getText().isEmpty() ) {
            NaermesteArbejdeErrorLabel_id.setText("Ovenstaaende information er ikke udfyldt"); 
            NaermesteArbejdeErrorLabel_id.setVisible(true); 
            bool = false; 
        }else if(!NaermesteArbejdeTF.getText().isEmpty()) generelinfoTemporyDB.setNaermesteArbejde(NaermesteArbejdeTF.getText());
        
        return bool; 
    }

    public void setInstansOfGeneralPersonInfo(Generelinfo generelinfoTemporyDB, Generelinfo generelinfoClinicalSuiteDB){
        this.generelinfoTemporyDB = generelinfoTemporyDB;

        if (generelinfoTemporyDB.getNaermesteNavn().isEmpty()) naermesteNavnTF.setPromptText(generelinfoClinicalSuiteDB.getNaermesteNavn());
        else  naermesteNavnTF.setPromptText(generelinfoTemporyDB.getNaermesteNavn());

        if (generelinfoTemporyDB.getNaermesteMobil().isEmpty()) NaermesteMobilTF.setPromptText(generelinfoClinicalSuiteDB.getNaermesteMobil());
        else  NaermesteMobilTF.setPromptText(generelinfoTemporyDB.getNaermesteMobil());

        if (generelinfoTemporyDB.getNaermesteTlf().isEmpty()) NaermesteTelefonTF.setPromptText(generelinfoClinicalSuiteDB.getNaermesteTlf());
        else  NaermesteTelefonTF.setPromptText(generelinfoTemporyDB.getNaermesteTlf());

        if (generelinfoTemporyDB.getNaermesteArbejde().isEmpty()) NaermesteArbejdeTF.setPromptText(generelinfoClinicalSuiteDB.getNaermesteArbejde());
        else  NaermesteArbejdeTF.setPromptText(generelinfoTemporyDB.getNaermesteArbejde());
    }
}