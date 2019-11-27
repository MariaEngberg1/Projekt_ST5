package dk.aau.controllers;

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

public class PtRootlayerController {
    private App mainApp;
    private BorderPane borderpane; 
    private int nrCenterViewShowing =1; 
    private Generelinfo generelInfo; 
    private PtSpg1Controller ptSpg1Controller;

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
            showPtSpg1(); 
            NextBtn.setText("Næste");
        }
        if(nrCenterViewShowing == 2 && ptSpg1Controller.checkIfReadyToPresNext()){
            showPtSlut(); 
            NextBtn.setText("Overfoer");
        }

        else if (nrCenterViewShowing == 2 && !ptSpg1Controller.checkIfReadyToPresNext() ) --nrCenterViewShowing;
        if(nrCenterViewShowing == 3) {
            Boolean bool = mainApp.showConfirmBox(); 
            if(bool){
                DatabaseManipulator.updateDataBase("UPDATE `GenerelInformation` SET `Navn` = '"+generelInfo.getNavn()+ "', `Arbejde` = '"+generelInfo.getArbejde()+"', `Mobilnummer` = '"+generelInfo.getMobil()+"', `EgenLaegeNavn` = '"+generelInfo.getEgenlaegeNavn()+"', `EgenLaegeAdresse` = '"+generelInfo.getEgenlaegeAdresse()+"' WHERE `GenerelInformation`.`CPR-nummer` = '"+generelInfo.getCPR()+"'");  
                //DatabaseManipulator.updateDataBase("UPDATE `GenerelInformation` SET `Navn` = '"+ generelInfo.getNavn() +"' WHERE `GenerelInformation`.`CPR-nummer` = '"+ generelInfo.getCPR() + "'"); 
                Stage primaryStage = mainApp.getPrimaryStage(); 
                primaryStage.close();
                
            } else  nrCenterViewShowing = 2; 
        }
    }


    public void showPtSpg1() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/Pt_Spg1.fxml"));
            AnchorPane anchorpane = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            borderpane.setCenter(anchorpane);

            // Give the controller access to the main app.
            ptSpg1Controller = loader.getController();
            ptSpg1Controller.setInstansOfGeneralPersonInfo(generelInfo);
            ptSpg1Controller.setRefrenceToRootlayer(this);
            TilbageBtn.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPtSlut() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/Pt_Slut.fxml"));
            AnchorPane anchorpane = (AnchorPane) loader.load();
            borderpane.setCenter(anchorpane);
            TilbageBtn.setVisible(true);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}