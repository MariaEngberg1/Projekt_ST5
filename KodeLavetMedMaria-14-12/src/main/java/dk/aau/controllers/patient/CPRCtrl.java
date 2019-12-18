package dk.aau.controllers.patient;

import dk.aau.App;
import dk.aau.models.patient.GenerelinfoHandler;
import dk.aau.models.patient.Patientinformation;
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

    /**
     * Validate the entered CPR-nr.
     * @param CPRnummerTextField is holding the entered CPR-nr
     */
    public void validateCPR(TextField CPRnummerTextField){
        // Check if entered CPR-nr is empty
        if (!CPRnummerTextField.getText().isEmpty()){
            try{
                // If entered CPR only contains numbers an exception will not be thrown
                Long.parseLong(CPRnummerTextField.getText().trim());
                // Check if correct lengh
                if (CPRnummerTextField.getText().length() == 10){
                    // Load info from PSDB regarding entered CPR-nr
                    GenerelinfoHandler generelinfoHandler =  new GenerelinfoHandler("PSDB");
                    DatabaseManipulator.executeQueryWithResultSet(generelinfoHandler, "SELECT * FROM `TemporyDBGenerelInformation` WHERE `CPR-nummer` ='"+CPRnummerTextField.getText()+"'" );

                    // If CPR exist in PSDB, array will be 1 in size
                    if(generelinfoHandler.getSizeOfGenerelinfoListe() !=0) {
                        // Check if entered CPR-nr already has answered questionnaire
                        if (generelinfoHandler.getGenerelinfoListe(0).getSkemaUdfyld().equals("false")){
                            // Load instance in patient
                            Patientinformation patientinformation = new Patientinformation(); 
                            patientinformation.setGenerelInfoPSDB(generelinfoHandler.getGenerelinfoListe(0));

                            // Shift view to rootlayer
                            mainApp.showRootlayer(patientinformation);
                        }else alertBox("Praebooking-skema allerede udfyldt");
                    } else alertBox("Intet Praebooking skema er tilsendt");      
                }else alertBox("Indtastede CPR input har forkert laengde");
            }catch (NumberFormatException nfe){ alertBox("Indtastet CPR input maa ikke indeholde bogstaver");}   
        } else alertBox("TextField er tom");
    }


    /**
     * Show alert box 
     * @param text will be display on alert box
     */
    public void alertBox(String text){
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("ERROR");
        alert.setHeaderText(text);
        alert.setContentText("Proev venligst igen, hvis det ikke virker, ring 64987897");
        alert.showAndWait();
    }

    /**
     * Reference to App, needed for shifting views
     * @param mainApp is instance of app
     */
    public void setMainApp(App mainApp){
        this.mainApp = mainApp;
    }
}
