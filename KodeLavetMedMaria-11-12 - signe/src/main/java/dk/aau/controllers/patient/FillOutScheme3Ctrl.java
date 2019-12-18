package dk.aau.controllers.patient;

import dk.aau.models.patient.Patientinformation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class FillOutScheme3Ctrl {
    private Patientinformation patientinformation;

    @FXML
    private Label hjerteErrorLabel;

    @FXML
    private Label AstmaErrorLabel;

    @FXML
    private Label NyreErrorLabel;

    @FXML
    private Label NaermesteArbejdeErrorLabel_id;

    @FXML
    private CheckBox HjertejaChechBox_id;

    @FXML
    private CheckBox nejHjerteCheckBox_id;

    @FXML
    private CheckBox AstmaJaChechBox_id;

    @FXML
    private CheckBox AstamaNejCheckBox_id;

    @FXML
    private CheckBox nyreJaChechBox_id;

    @FXML
    private CheckBox NyreNejCheckBox_id;

    @FXML
    private CheckBox sukkerJaChechBox_id;

    @FXML
    private CheckBox SukkerNejCheckBox_id;
  
    @FXML
    void handleAstmaJaCheckBoc(ActionEvent event) {
        if( AstmaJaChechBox_id.isSelected() ){
            AstamaNejCheckBox_id.setSelected(false);
            patientinformation.tidligereSygdommePSDB.setAstma("true");
        }else{
            AstamaNejCheckBox_id.setSelected(true); 
            patientinformation.tidligereSygdommePSDB.setAstma("false");
        }
    }

    @FXML
    void handleAstmaNejChechBox(ActionEvent event) {
        if( AstamaNejCheckBox_id.isSelected() ){
            AstmaJaChechBox_id.setSelected(false);
            patientinformation.tidligereSygdommePSDB.setAstma("false");
        }else{
            AstmaJaChechBox_id.setSelected(true); 
            patientinformation.tidligereSygdommePSDB.setAstma("true");
        }
    }

    @FXML
    void handleHjerteJaCheckBoc(ActionEvent event) {
        if( HjertejaChechBox_id.isSelected() ){
            nejHjerteCheckBox_id.setSelected(false);
            patientinformation.tidligereSygdommePSDB.setHjerte("true");
        }else{
            nejHjerteCheckBox_id.setSelected(true); 
            patientinformation.tidligereSygdommePSDB.setHjerte("false");
        }
    }

    @FXML
    void handleNejHjerteChechBox(ActionEvent event) {
        if( nejHjerteCheckBox_id.isSelected() ){
            HjertejaChechBox_id.setSelected(false);
            patientinformation.tidligereSygdommePSDB.setHjerte("false");
        }else{
            HjertejaChechBox_id.setSelected(true); 
            patientinformation.tidligereSygdommePSDB.setHjerte("true");
        }
    }

    @FXML
    void handleNyreJaCheckBoc(ActionEvent event) {
        if( nyreJaChechBox_id.isSelected() ){
            NyreNejCheckBox_id.setSelected(false);
            patientinformation.tidligereSygdommePSDB.setNyre("true");
        }else{
            NyreNejCheckBox_id.setSelected(true); 
            patientinformation.tidligereSygdommePSDB.setNyre("false");
        }
    }


    @FXML
    void handleNyreNejChechBox(ActionEvent event) {
        if( NyreNejCheckBox_id.isSelected() ){
            nyreJaChechBox_id.setSelected(false);
            patientinformation.tidligereSygdommePSDB.setNyre("false");

        }else{
            nyreJaChechBox_id.setSelected(true); 
            patientinformation.tidligereSygdommePSDB.setNyre("true");
        }
    }

    @FXML
    void handleSukkerJaCheckBox(ActionEvent event) {
        if( sukkerJaChechBox_id.isSelected() ){
            SukkerNejCheckBox_id.setSelected(false);
            patientinformation.tidligereSygdommePSDB.setSukkerSyge("true");

        }else{
            SukkerNejCheckBox_id.setSelected(true); 
            patientinformation.tidligereSygdommePSDB.setSukkerSyge("false");

        }
    }

    @FXML
    void handleSukkerNejChechBox(ActionEvent event) {
        if( SukkerNejCheckBox_id.isSelected() ){
            sukkerJaChechBox_id.setSelected(false);
            patientinformation.tidligereSygdommePSDB.setSukkerSyge("false");

        }else{
            sukkerJaChechBox_id.setSelected(true); 
            patientinformation.tidligereSygdommePSDB.setSukkerSyge("true");

        }
    }

    public Boolean checkIfReadyToPresNext(){
        boolean bool = true; 
        if(!HjertejaChechBox_id.isSelected() && !nejHjerteCheckBox_id.isSelected()){
            hjerteErrorLabel.setText("Ovenstaaende checkbokse er ikke udfyldte");
            hjerteErrorLabel.setVisible(true); 
            bool = false; 
        }

        if(!AstmaJaChechBox_id.isSelected() && !AstamaNejCheckBox_id.isSelected()){
            AstmaErrorLabel.setText("Ovenstaaende checkbokse er ikke udfyldte");
            AstmaErrorLabel.setVisible(true); 
            bool = false; 
        }

        if(!nyreJaChechBox_id.isSelected() && !NyreNejCheckBox_id.isSelected()){
            NyreErrorLabel.setText("Ovenstaaende checkbokse er ikke udfyldte");
            NyreErrorLabel.setVisible(true); 
            bool = false; 
        }

        if(!sukkerJaChechBox_id.isSelected() && !SukkerNejCheckBox_id.isSelected()){
            NaermesteArbejdeErrorLabel_id.setText("Ovenstaaende checkbokse er ikke udfyldte");
            NaermesteArbejdeErrorLabel_id.setVisible(true); 
            bool = false; 
        }
        
        return bool; 
    }


    public void setPatientReference(Patientinformation patientinformation){
        this.patientinformation = patientinformation; 
        setKnownParameters(patientinformation);        
    }

    

    public void setKnownParameters (Patientinformation patientinformation) {
        if (!patientinformation.tidligereSygdommePSDB.getHjerte().isEmpty()){
            if (patientinformation.tidligereSygdommePSDB.getHjerte().equals("true")) HjertejaChechBox_id.setSelected(true);
            else nejHjerteCheckBox_id.setSelected(true);
        }

        if (!patientinformation.tidligereSygdommePSDB.getAstma().isEmpty()){
            if (patientinformation.tidligereSygdommePSDB.getAstma().equals("true")) AstmaJaChechBox_id.setSelected(true);
            else AstamaNejCheckBox_id.setSelected(true);
        }

        if (!patientinformation.tidligereSygdommePSDB.getNyre().isEmpty()){
            if (patientinformation.tidligereSygdommePSDB.getNyre().equals("true")) nyreJaChechBox_id.setSelected(true);
            else NyreNejCheckBox_id.setSelected(true);
        }

        if (!patientinformation.tidligereSygdommePSDB.getSukkerSyge().isEmpty()){
            if (patientinformation.tidligereSygdommePSDB.getSukkerSyge().equals("true")) sukkerJaChechBox_id.setSelected(true);
            else SukkerNejCheckBox_id.setSelected(true);
        }
    }
}
