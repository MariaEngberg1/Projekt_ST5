package dk.aau.controllers.sygehus;

import dk.aau.App;
import dk.aau.models.CS_GenerelinfoHandler;
import dk.aau.models.Generelinfo;
import dk.aau.models.GenerelinfoHandler;
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
        CS_GenerelinfoHandler cs_gih = new CS_GenerelinfoHandler();
        DatabaseManipulator.executeQueryWithResultSet(cs_gih, "SELECT * FROM csGenerelInformation");

        int pladsnr = 0; //peger på instansen af CS_GenerelinfoHandler som holder rigtige cpr nummer
        boolean cprNumberExistsInDB = false; 

        //Check if entered CPR nummer exist in CS DB
        for (int i = 0; i<cs_gih.getSizeOfCSGenerelinfoListe(); i++){ 
            if (CPRnummerTextField.getText().equals(cs_gih.getCSGenerelinfoListe(i).getCprNummer())) {
                cprNumberExistsInDB = true; 
                pladsnr = i;
            }
        }

        if(cprNumberExistsInDB){
            // Load temporary DB
            GenerelinfoHandler gih = new GenerelinfoHandler();
            DatabaseManipulator.executeQueryWithResultSet(gih, "SELECT * FROM GenerelInformation");
            
            //Check if entered CPR nummer already exist in temporary DB: 
            if(selectedDirection.equals("opret")){
                Boolean doesEnteredCprNumberAlreadyExistsInTemporaryDB = false; 
                for (int i = 0; i<gih.getSizeOfGenerelinfoListe(); i++){ 
                    if (CPRnummerTextField.getText().equals( gih.getGenerelinfoListe(i).getCprNummer() )) {
                        doesEnteredCprNumberAlreadyExistsInTemporaryDB = true; 
                    }
                }
                //Open "opret" if CPR nummer doesnt exist in tempory DB: 
                if (!doesEnteredCprNumberAlreadyExistsInTemporaryDB) mainApp.showShowCreateEdit(cs_gih.getCSGenerelinfoListe(pladsnr), new Generelinfo(), selectedDirection); 
                else if (doesEnteredCprNumberAlreadyExistsInTemporaryDB) showAlertBox("Prebooking-Skema allerede sendt til CPR-nummeret "+ CPRnummerTextField.getText());

            }else if(selectedDirection.equals("tilgaa")){
                boolean preBookingSkemaSend = true;
                //check in tempory DB if entered CPR nummer has answered PBS
                for (int i = 0; i<gih.getSizeOfGenerelinfoListe(); i++){ 
                    if (CPRnummerTextField.getText().equals(gih.getGenerelinfoListe(i).getCprNummer()) && "true".equals(gih.getGenerelinfoListe(i).getSkemaUdfyld()) ) {
                        //if entered CPR nummer has answered
                        mainApp.showShowCreateEdit(cs_gih.getCSGenerelinfoListe(pladsnr), gih.getGenerelinfoListe(i), selectedDirection); 
                        preBookingSkemaSend = false;

                    } else if (CPRnummerTextField.getText().equals(gih.getGenerelinfoListe(i).getCprNummer()) && "false".equals(gih.getGenerelinfoListe(i).getSkemaUdfyld()) ){
                        //if entered CPR nummer has not answered yet
                        showAlertBox("Prebooking-skema er ikke blevet udfyldt af patient endnu");
                        preBookingSkemaSend = false;
                    }
                }
                
                if(preBookingSkemaSend) showAlertBox("Intet Prebookingskema er sendt til patient");
            }
        }else{
            showAlertBox("CPR-nummer eksiterer ikke i DataBase register");
        }
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
