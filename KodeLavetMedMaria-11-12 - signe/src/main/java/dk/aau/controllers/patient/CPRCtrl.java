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

    public void validateCPR(TextField CPRnummerTextField){
        if (!CPRnummerTextField.getText().isEmpty()){
            try{
                Long.parseLong(CPRnummerTextField.getText().trim());
                if (CPRnummerTextField.getText().length() == 10){
                    GenerelinfoHandler generelinfoHandler =  new GenerelinfoHandler("PSDB");
                    DatabaseManipulator.executeQueryWithResultSet(generelinfoHandler, "SELECT * FROM `TemporyDBGenerelInformation` WHERE `CPR-nummer` ='"+CPRnummerTextField.getText()+"'" );

                    if(generelinfoHandler.getSizeOfGenerelinfoListe() !=0) {
                        if (generelinfoHandler.getGenerelinfoListe(0).getSkemaUdfyld().equals("false")){

                            Patientinformation patientinformation = new Patientinformation(); 
                            patientinformation.setGenerelInfoPSDB(generelinfoHandler.getGenerelinfoListe(0));
                            mainApp.showRootlayer(patientinformation);
                            


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
