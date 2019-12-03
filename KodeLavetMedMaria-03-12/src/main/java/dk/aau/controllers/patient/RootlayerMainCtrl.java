package dk.aau.controllers.patient;

import java.io.IOException;

import dk.aau.App;
import dk.aau.models.Generelinfo;
import dk.aau.models.database.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RootlayerMainCtrl {
    private App mainApp;
    private BorderPane borderpane; 
    private int nrCenterViewShowing =1; 
    private Generelinfo generelInfo; 
    private FillOutScheme1Ctrl fillOutScheme1Ctrl;
    private FillOutScheme2Ctrl fillOutScheme2Ctrl;


    @FXML
    private Button NextBtn;

    @FXML
    private Button TilbageBtn;
 
    @FXML
    private ProgressBar ProgressBar;

    @FXML
    private Text Overskrift;

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

    public void setReferenceParameteres(App mainApp, BorderPane borderpane, Generelinfo generelInfo){
        this.mainApp = mainApp;
        this.borderpane = borderpane;
        this.generelInfo = generelInfo; 
    }

    public void setInstanceGenerelinfos(Generelinfo generelInfo){
        this.generelInfo = generelInfo; 
    }

    public void manageCurrentcenterView(){
        if(nrCenterViewShowing == 0) ++nrCenterViewShowing; 
        if(nrCenterViewShowing == 1) {
            showFillOutScheme1(); 
            NextBtn.setText("Næste");
            Overskrift.setText("Spørgsmål 1 - Generel information");
        }

        if(nrCenterViewShowing == 2 && fillOutScheme1Ctrl.checkIfReadyToPresNext()){
            showFillOutScheme2(); 
            TilbageBtn.setVisible(true);
            Overskrift.setText("Spørgsmål 2 - Generel information");

            
        }else if (nrCenterViewShowing == 2 && !fillOutScheme1Ctrl.checkIfReadyToPresNext()) --nrCenterViewShowing; 

        if(nrCenterViewShowing ==3 && fillOutScheme2Ctrl.checkIfReadyToPresNext()){
            showPtSlut(); 
            NextBtn.setText("Overfoer");
            Overskrift.setText("Tak for besvarelse");

        } else if (nrCenterViewShowing ==3 && !fillOutScheme2Ctrl.checkIfReadyToPresNext()) --nrCenterViewShowing; 

        if(nrCenterViewShowing == 4) {
            Boolean bool = mainApp.showTransferView(); 
            if(bool){
                
                DatabaseManipulator.updateDataBase("UPDATE `GenerelInformation` SET `Arbejde` = '"+generelInfo.getArbejde()+"', `Mobilnummer` = '"+generelInfo.getMobilNummer()+"', `telefonNummer` = '"+generelInfo.getTelefonNummer()+"', `adresse` = '"+generelInfo.getAdresse()+"', `naermesteNavn` = '"+generelInfo.getNaermesteNavn()+"', `naermesteTlf` = '"+generelInfo.getNaermesteTlf()+"', `naermesteMobil` = '"+generelInfo.getNaermesteMobil()+"', `naermesteArbejde` = '"+generelInfo.getNaermesteArbejde()+"', `mrsa` = '"+generelInfo.getMrsa()+"', `EgenLaegeNavn` = '"+generelInfo.getEgenLaegeNavn()+"', `okHentOplysninger` = '"+generelInfo.getOkHentOplysninger()+"', `SkemaUdfyld` = 'true' WHERE `GenerelInformation`.`CPR-nummer` = '"+generelInfo.getCprNummer()+"'");  

                Stage primaryStage = mainApp.getPrimaryStage(); 
                primaryStage.close();
                
            } else  nrCenterViewShowing = 2; 
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
            fillOutScheme1Ctrl.setInstansOfGeneralPersonInfo(generelInfo);
            TilbageBtn.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
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
            fillOutScheme2Ctrl.setInstansOfGeneralPersonInfo(generelInfo);
            TilbageBtn.setVisible(false);

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