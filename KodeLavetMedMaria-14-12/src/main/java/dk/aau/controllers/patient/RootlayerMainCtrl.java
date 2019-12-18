package dk.aau.controllers.patient;

import java.io.IOException;

import dk.aau.App;
import dk.aau.models.database.DatabaseManipulator;
import dk.aau.models.patient.Patientinformation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RootlayerMainCtrl {
    private App mainApp; 
    private BorderPane borderpane; 
    private int nrCenterViewShowing =1; 
    private Patientinformation patientinformation; 
    private FillOutScheme1Ctrl fillOutScheme1Ctrl;
    private FillOutScheme2Ctrl fillOutScheme2Ctrl;
    private FillOutScheme3Ctrl fillOutScheme3Ctrl;

    @FXML
    private Label overskriftLabel;

    @FXML
    private Button NextBtn;

    @FXML
    private Button TilbageBtn;

    @FXML
    private ProgressBar ProgressBar;

    @FXML
    void handleNextBtn(ActionEvent event) {
        ++nrCenterViewShowing; 
        manageCurrentcenterView(); 
    }

    @FXML
    void handleTilbageBtn(ActionEvent event) {
        --nrCenterViewShowing; 
        manageCurrentcenterView();     
    }

    /**
     * @param mainApp reference to instance of app
     * @param borderpane reference to rootlayerViews borderpana 
     * @param patientinformation reference to object of Patientinformation which were validated in CPRCtrl
     */
    public void setReferenceParameteres(App mainApp, BorderPane borderpane, Patientinformation patientinformation){
        this.mainApp = mainApp;
        this.borderpane = borderpane;
        this.patientinformation = patientinformation; 
    }

    /**
     * Manage which view is displayed in center of rootlayerViews borderpane
     */
    public void manageCurrentcenterView(){
        if(nrCenterViewShowing == 0) ++nrCenterViewShowing; 
        if(nrCenterViewShowing == 1) {
            showFillOutScheme1(); 
            TilbageBtn.setVisible(false);
            overskriftLabel.setText("Spoergsmaal 1 - Generel information");
            ProgressBar.setProgress(0.0);
        }

        if(nrCenterViewShowing == 2 && fillOutScheme1Ctrl.checkIfReadyToPresNext()){
            showFillOutScheme2(); 
            TilbageBtn.setVisible(true);
            overskriftLabel.setText("Spoergsmaal 2 - Information vedroerende naermeste"); 
            ProgressBar.setProgress(0.33);
        }else if (nrCenterViewShowing == 2 && !fillOutScheme1Ctrl.checkIfReadyToPresNext()) --nrCenterViewShowing; 

        if(nrCenterViewShowing ==3 && fillOutScheme2Ctrl.checkIfReadyToPresNext()){
            showFillOutScheme3(); 
            NextBtn.setText("Naeste");
            overskriftLabel.setText("Spoergsmaal 3 - Tidligere sygdomme");
            ProgressBar.setProgress(0.66);
        } else if (nrCenterViewShowing ==3 && !fillOutScheme2Ctrl.checkIfReadyToPresNext()) --nrCenterViewShowing; 

        if(nrCenterViewShowing ==4 && fillOutScheme3Ctrl.checkIfReadyToPresNext()){
            showPtSlut(); 
            NextBtn.setText("Overfoer");
            overskriftLabel.setText("Tak for besvarelse");
            ProgressBar.setProgress(1);
        } else if (nrCenterViewShowing ==4 && !fillOutScheme3Ctrl.checkIfReadyToPresNext()) --nrCenterViewShowing; 


        if(nrCenterViewShowing == 5) {
            if(mainApp.showTransferView()){
                // Send a update SQL-statement
                DatabaseManipulator.updateDataBase("UPDATE `TemporyDBGenerelInformation` SET `Arbejde` = '"+patientinformation.generelInfoPSDB.getArbejde() +"', `Mobilnummer` = '"+patientinformation.generelInfoPSDB.getMobilNummer() +"', `telefonNummer` = '"+patientinformation.generelInfoPSDB.getTelefonNummer() +"', `naermesteNavn` = '"+patientinformation.generelInfoPSDB.getNaermesteNavn() +"', `naermesteTlf` = '"+patientinformation.generelInfoPSDB.getNaermesteTlf() +"', `naermesteMobil` = '"+patientinformation.generelInfoPSDB.getNaermesteMobil() +"', `naermesteArbejde` = '"+patientinformation.generelInfoPSDB.getNaermesteArbejde() +"', `mrsa` = '', `okHentOplysninger` = '"+patientinformation.generelInfoPSDB.getOkHentOplysninger() +"', `SkemaUdfyld` = 'true' WHERE `TemporyDBGenerelInformation`.`CPR-nummer` = '"+patientinformation.generelInfoPSDB.getCprNummer()+"'");                                       
                // Close the app
                Stage primaryStage = mainApp.getPrimaryStage(); 
                primaryStage.close();                
            } else  nrCenterViewShowing = 4; 
        }
    }

    /**
     * Show first view of questionnaire and set corresponding ctrl.
     */
    public void showFillOutScheme1() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/patient/FillOutScheme1View.fxml"));
            AnchorPane anchorpane = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            borderpane.setCenter(anchorpane);

            // Give the controller access to the main app.
            fillOutScheme1Ctrl = loader.getController();
            fillOutScheme1Ctrl.setPatientReference(patientinformation);
            TilbageBtn.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fail loading FillOutScheme1View");
        }  
    }

     /**
     * Show second view of questionnaire and set corresponding ctrl.
     */
    public void showFillOutScheme2(){
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/patient/FillOutScheme2View.fxml"));
            AnchorPane anchorpane = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            borderpane.setCenter(anchorpane);

            // Give the controller access to the main app.
            fillOutScheme2Ctrl = loader.getController();
            fillOutScheme2Ctrl.setPatientReference(patientinformation);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     /**
     * Show third view of questionnaire and set corresponding ctrl.
     */
    public void showFillOutScheme3(){
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/patient/FillOutScheme3View.fxml"));
            AnchorPane anchorpane = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            borderpane.setCenter(anchorpane);

            // Give the controller access to the main app.
            fillOutScheme3Ctrl = loader.getController();
            fillOutScheme3Ctrl.setPatientReference(patientinformation);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     /**
     * Show view containing message that all questionnaire has been filled and set corresponding ctrl.
     */
    public void showPtSlut() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/patient/Pt_Slut.fxml"));
            AnchorPane anchorpane = (AnchorPane) loader.load();
            borderpane.setCenter(anchorpane);            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}