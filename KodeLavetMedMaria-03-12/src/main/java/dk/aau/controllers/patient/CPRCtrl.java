package dk.aau.controllers.patient;

import dk.aau.App;
import dk.aau.models.patient.GenerelinfoHandler;
import dk.aau.models.patient.Patient;
import dk.aau.models.database.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CPRCtrl {
    private App mainApp;

    @FXML
    private TextField CPRnummerTextField;

    @FXML
    void handleEnterBtn(ActionEvent event) {
        validateCPR(CPRnummerTextField); 
    }

    public void validateCPR(TextField CPRnummerTextField){
        if (!CPRnummerTextField.getText().isEmpty()){
            try{
                Long.parseLong(CPRnummerTextField.getText().trim());
                if (CPRnummerTextField.getText().length() == 10){
                    GenerelinfoHandler generelinfoHandlerTemporyDB =  new GenerelinfoHandler("TemporyDB");
                    DatabaseManipulator.executeQueryWithResultSet(generelinfoHandlerTemporyDB, "SELECT * FROM `TemporyDBGenerelInformation` WHERE `CPR-nummer` ='"+CPRnummerTextField.getText()+"'");

                    if(generelinfoHandlerTemporyDB.getSizeOfGenerelinfoListe() !=0) {
                        if (!generelinfoHandlerTemporyDB.getGenerelinfoListe(0).getSkemaUdfyld().equals("true")){
                            GenerelinfoHandler generelinfoHandlerClinicalSuiteDB = new GenerelinfoHandler("ClinicalSuiteDB");
                            DatabaseManipulator.executeQueryWithResultSet(generelinfoHandlerClinicalSuiteDB, "SELECT * FROM `ClinicalSuiteDBGenerelInformation`  WHERE `CPR-nummer` ='"+CPRnummerTextField.getText()+"'");
                            
                            Patient patient = new Patient(); 
                            patient.setGenerelInfoTemporyDB(generelinfoHandlerTemporyDB.getGenerelinfoListe(0));
                            patient.setGenerelinfoClinicalSuiteDB(generelinfoHandlerClinicalSuiteDB.getGenerelinfoListe(0));
                            mainApp.showRootlayer(patient);

                        }else alertBox("Praebooking-skema allerede udfyldt");
                    } else alertBox("Intet Praebooking skema er tilsendt");      
                }else alertBox("Indtastede CPR input har forkert laengde");
            }catch (NumberFormatException nfe){ alertBox("Indtastet CPR input maa ikke indeholde bogstaver");}   
        } else alertBox("TextField er tom");
    }

    public void alertBox(String text){
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("ERROR");
        alert.setHeaderText(text);
        alert.setContentText("Proev venligst igen, hvis det ikke virker, ring 64987897");
        alert.showAndWait();
    }

    public void setMainApp(App mainApp){
        this.mainApp = mainApp;
    }
}
