/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dk.aau;

import java.io.IOException;

import dk.aau.controllers.patient.ConfirmBoxController;
import dk.aau.controllers.patient.CPRCtrl;
import dk.aau.controllers.patient.RootlayerMainCtrl;
import dk.aau.models.patient.Patientinformation;
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

        // Set the application icon and show CPR view
        this.primaryStage.getIcons().add(new Image("/images/Logo.png"));
        showCPR();
    }

    /**
     * Show CPR view and set corresponding ctrl.
     */
    public void showCPR() {
        try {
            // load FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/patient/CPRView.fxml"));
            anchorpane = (AnchorPane) loader.load();

            // Show the scene containing CPR view
            Scene scene = new Scene(anchorpane);
            primaryStage.setScene(scene);
            primaryStage.show();

            // Set the ctrl class
            CPRCtrl controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show CPR view and set corresponding ctrl.
     * @param patientinformation inset the objekt with CPR-nr validated
     */
    public void showRootlayer(Patientinformation patientinformation){
        try {
            // Load FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/views/patient/RootlayerMainView.fxml"));
            borderpane = (BorderPane) loader.load();

            // Show the scene containing the rootlayout.
            Scene scene = new Scene(borderpane);
            primaryStage.setScene(scene);
            primaryStage.show();

            // Set ctrl
            RootlayerMainCtrl controller = loader.getController();
            controller.setReferenceParameteres(this, borderpane, patientinformation);
            controller.showFillOutScheme1();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("showRootlayer fungere ikke");
        }
    }

    /**
     * Show transfer view and set corresponding ctrl.
     * This will 'pop-up' an extra stage window
     * @return indicate when stage is closed whether patient want to transfer or not
     */
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

            // Set the ctrl and give ctrl a reference to the stage
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
