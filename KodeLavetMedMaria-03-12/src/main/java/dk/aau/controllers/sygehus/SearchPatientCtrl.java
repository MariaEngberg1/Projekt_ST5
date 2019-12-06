package dk.aau.controllers.sygehus;

import dk.aau.App;
import dk.aau.models.patient.GenerelinfoHandler;
import dk.aau.models.patient.Patient;
import dk.aau.models.database.DatabaseManipulator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SearchPatientCtrl {
    private App mainApp;
    private String selectedDirection; 

    @FXML
    private TextField CPRnummerTextField;

    @FXML
    void handleEnterBtn(ActionEvent event) {
        if (!CPRnummerTextField.getText().isEmpty()){
            try{
                long i = Long.parseLong(CPRnummerTextField.getText().trim());
                if (CPRnummerTextField.getText().length() == 10){
                    GenerelinfoHandler generelinfoClinicalSuiteDB = new GenerelinfoHandler("ClinicalSuiteDB");
                    DatabaseManipulator.executeQueryWithResultSet(generelinfoClinicalSuiteDB, "SELECT * FROM `ClinicalSuiteDBGenerelInformation`  WHERE `CPR-nummer` ='"+ CPRnummerTextField.getText() +"'");

                    GenerelinfoHandler generelinfoTemporyDB = new GenerelinfoHandler("TemporyDB");
                    DatabaseManipulator.executeQueryWithResultSet(generelinfoTemporyDB,  "SELECT * FROM `TemporyDBGenerelInformation` WHERE `CPR-nummer` ='"+ CPRnummerTextField.getText() +"'");


                    if(generelinfoClinicalSuiteDB.getSizeOfGenerelinfoListe() !=0) {
                        System.out.println("size of CS DB " + generelinfoClinicalSuiteDB.getSizeOfGenerelinfoListe()); // <<-------
                        if(selectedDirection.equals("opret")){
                            if(generelinfoTemporyDB.getSizeOfGenerelinfoListe() == 0) {
                                System.out.println("size of T DB " + generelinfoTemporyDB.getSizeOfGenerelinfoListe()); // <<-------

                                Patient patient = new Patient();
                                patient.setGenerelinfoClinicalSuiteDB(generelinfoClinicalSuiteDB.getGenerelinfoListe(0));
                                mainApp.showShowCreateEdit(patient, selectedDirection); 
                            }else showAlertBox("Indtastet patient CPR nummer har allerede faaet tilsendt praebooking skema");

                        }else if(selectedDirection.equals("tilgaa")){
                            if(generelinfoTemporyDB.getSizeOfGenerelinfoListe() != 0) {
                                if(generelinfoTemporyDB.getGenerelinfoListe(0).getSkemaUdfyld().equals("true")){
                                    Patient patient = new Patient();
                                    patient.setGenerelinfoClinicalSuiteDB(generelinfoClinicalSuiteDB.getGenerelinfoListe(0));
                                    patient.setGenerelInfoTemporyDB(generelinfoTemporyDB.getGenerelinfoListe(0));
                                    mainApp.showShowCreateEdit(patient, selectedDirection); 
                                } else showAlertBox("Patient har ikke svaret på praebooking-skema endnu");
                            }else showAlertBox("Intet praebooking-skema er sendt til patient CPR nummer");
                        }
                    }else showAlertBox("Indtastet CPR nummer eksistere ikke i Databasen");
       
                }else {
                    showAlertBox("Indtastede CPR input har forkert laengde");
                }
            }catch (NumberFormatException nfe){
                showAlertBox("Indtastet CPR input maa ikke indeholde bogstaver");     
            }
        }else showAlertBox("Intet CPR nummer indtastet");
    }



    public void showAlertBox(String str){
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("ERROR");
        alert.setHeaderText(str);         
        alert.setContentText("Prøv venligst igen, hvis det ikke virker, ring 64987897");
        alert.showAndWait();
    }

    @FXML
    void handlerTilbageBnt(ActionEvent event) {
        mainApp.ShowScheme(); 
    }

    
    public void setReference(App mainApp, String selectedDirection){
        this.mainApp = mainApp;
        this.selectedDirection = selectedDirection;
    }
}
