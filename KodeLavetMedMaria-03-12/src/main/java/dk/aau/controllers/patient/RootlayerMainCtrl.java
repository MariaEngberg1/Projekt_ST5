package dk.aau.controllers.patient;

import java.io.IOException;

import dk.aau.App;
import dk.aau.models.database.DatabaseManipulator;
import dk.aau.models.patient.Generelinfo;
import dk.aau.models.patient.Patient;
import dk.aau.models.patient.TidligereSygdomme;
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
    private Generelinfo generelInfoTemporyDB;
    private Generelinfo generelinfoClinicalSuiteDB; 
    private TidligereSygdomme tidligereSygdomme = new TidligereSygdomme(); 
 
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

    public void setReferenceParameteres(App mainApp, BorderPane borderpane, Patient patient){
        this.mainApp = mainApp;
        this.borderpane = borderpane;
        this.generelInfoTemporyDB = patient.getGenerelInfoTemporyDB(); 
        this.generelinfoClinicalSuiteDB = patient.getGenerelinfoClinicalSuiteDB(); 
    }

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
            overskriftLabel.setText("Spoergsmaal 2 - informaiton vedroerende naermeste"); 
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
            Boolean bool = mainApp.showTransferView(); 
            if(bool){
                DatabaseManipulator.updateDataBase("UPDATE `TemporyDBGenerelInformation` SET `Arbejde` = '"+generelInfoTemporyDB.getArbejde() +"', `Mobilnummer` = '"+generelInfoTemporyDB.getMobilNummer() +"', `telefonNummer` = '"+generelInfoTemporyDB.getTelefonNummer() +"', `naermesteNavn` = '"+generelInfoTemporyDB.getNaermesteNavn() +"', `naermesteTlf` = '"+generelInfoTemporyDB.getNaermesteTlf() +"', `naermesteMobil` = '"+generelInfoTemporyDB.getNaermesteMobil() +"', `naermesteArbejde` = '"+generelInfoTemporyDB.getNaermesteArbejde() +"', `mrsa` = '', `okHentOplysninger` = '"+generelInfoTemporyDB.getOkHentOplysninger() +"', `SkemaUdfyld` = 'true' WHERE `TemporyDBGenerelInformation`.`CPR-nummer` = '"+generelInfoTemporyDB.getCprNummer()+"'");                                       

                Stage primaryStage = mainApp.getPrimaryStage(); 
                primaryStage.close();
                
            } else  nrCenterViewShowing = 4; 
        }
    }

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
            fillOutScheme1Ctrl.setInstansOfGeneralPersonInfo( generelInfoTemporyDB, generelinfoClinicalSuiteDB );
            TilbageBtn.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fail loading FillOutScheme1View");
        }  
    }

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
            fillOutScheme2Ctrl.setInstansOfGeneralPersonInfo(generelInfoTemporyDB,generelinfoClinicalSuiteDB);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
            fillOutScheme3Ctrl.setReference(tidligereSygdomme);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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