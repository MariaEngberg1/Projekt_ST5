/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dk.aau;

import java.io.IOException;

import dk.aau.controllers.patient.ConfirmBoxController;
import dk.aau.controllers.sygehus.SearchPatientCtrl;
import dk.aau.controllers.sygehus.ShowSchemeCtrl;
import dk.aau.controllers.sygehus.ShowEditCreateCtrl;
import dk.aau.controllers.IntroController;
import dk.aau.controllers.patient.CPRCtrl;
import dk.aau.controllers.patient.RootlayerMainCtrl;
import dk.aau.models.CS_Generelinfo;
import dk.aau.models.Generelinfo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {
    private Stage primaryStage;
    private AnchorPane anchorpane;
    private BorderPane borderpane; 

    public static void main(String[] args) { 
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage; 
        this.primaryStage.setTitle("Projekt_ST5");
        // Set the application icon.
        this.primaryStage.getIcons().add(new Image("/images/Logo.png"));
        showIntro();

    }

    public void showIntro() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/Intro.fxml"));
            anchorpane = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(anchorpane);
            primaryStage.setScene(scene);

            primaryStage.show();
            IntroController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPtCPR() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/patient/CPRView.fxml"));
            anchorpane = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(anchorpane);
            primaryStage.setScene(scene);

            primaryStage.show();
            CPRCtrl controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRootlayer(Generelinfo gi){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/patient/RootlayerMainView.fxml"));
            borderpane = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(borderpane);
            primaryStage.setScene(scene);

            primaryStage.show();
            RootlayerMainCtrl controller = loader.getController();
            controller.setReferenceParameteres(this, borderpane, gi);
            controller.showFillOutScheme1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ShowScheme(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/laegeViews/ShowSchemeView.fxml"));
            anchorpane = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(anchorpane);
            primaryStage.setScene(scene);
            primaryStage.show();
            ShowSchemeCtrl controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSearchPatient(String selectedDirection){        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/laegeViews/CPRView.fxml"));
            anchorpane = (AnchorPane) loader.load();
            Scene scene = new Scene(anchorpane);
            primaryStage.setScene(scene);
            primaryStage.show();
            SearchPatientCtrl controller = loader.getController();
            controller.setReference(this, selectedDirection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void showShowCreateEdit(CS_Generelinfo cs_generelinfo, Generelinfo generelinfo, String selectedDirection){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/laegeViews/ShowEditCreateCtrl.fxml"));
            anchorpane = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(anchorpane);
            primaryStage.setScene(scene);
            primaryStage.show();
            ShowEditCreateCtrl controller = loader.getController();
            if("opret".equals(selectedDirection)) controller.setReference(this, cs_generelinfo, selectedDirection); 
            if("tilgaa".equals(selectedDirection)) controller.setReference(this, cs_generelinfo, generelinfo, selectedDirection); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public Boolean showTransferView(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/patient/TransferView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Closing");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ConfirmBoxController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.chosenAnswer();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
        
    public Stage getPrimaryStage() {
        return primaryStage;        
    }
    
}
