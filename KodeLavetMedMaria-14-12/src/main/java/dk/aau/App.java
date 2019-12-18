package dk.aau;

// Importing build classes 
import dk.aau.controllers.patient.TransferController;
import dk.aau.controllers.patient.CPRCtrl;
import dk.aau.controllers.patient.RootlayerMainCtrl;
import dk.aau.models.patient.Patientinformation;

// Importing of class to handle exceptions
import java.io.IOException;

// Importing classes from JavaFX
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

    /**
     * The launch() method is a static method located in the Application class.
     * This method launches the JavaFX runtime and the JavaFX application. 
     */
    public static void main(String[] args) { 
        launch(args);
    }

    /**
     * The start() method is called when the JavaFX application is started.
     * The Stage object is created by the JavaFX runtime
     */
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
            this.anchorpane = (AnchorPane) loader.load();

            // Show the scene containing CPR view
            Scene scene = new Scene(this.anchorpane);
            primaryStage.setScene(scene);
            primaryStage.show();

            // Set the ctrl class and give a reference to MainApp
            CPRCtrl controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show Rootlayer view and set corresponding ctrl.
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

            // Set ctrl and reference to MainApp borderpane of RootlayerView and instance of Patientinformation
            RootlayerMainCtrl controller = loader.getController();
            controller.setReferenceParameteres(this, borderpane, patientinformation);
            controller.showFillOutScheme1();
        } catch (IOException e) {
            e.printStackTrace();
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

            // Create the tranfer Stage.
            Stage transferStage = new Stage();
            transferStage.setTitle("Closing");
            
            // Gives the stage the proberty so user cannot interact with primary stage while transfer stage is open
            transferStage.initModality(Modality.WINDOW_MODAL); 
            transferStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            transferStage.setScene(scene);

            // Set the ctrl and give ctrl a reference to the stage
            TransferController controller = loader.getController();
            controller.setTransferStage(transferStage);

            // Show the transfer stage and wait until the user closes it
            transferStage.showAndWait();

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