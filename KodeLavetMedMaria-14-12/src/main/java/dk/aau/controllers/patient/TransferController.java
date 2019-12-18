package dk.aau.controllers.patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class TransferController {
    private Stage transferStage;
    private Boolean answer; 

    @FXML
    void handlerJaBnt(ActionEvent event) {
        this.answer = true; 
        transferStage.close();
    }

    @FXML
    void handlerNejBnt(ActionEvent event) {
        this.answer = false; 
        transferStage.close();
    }

     /**
     * Sets the reference to the transfer stage
     * @param transferStage
     */
    public void setTransferStage(Stage transferStage) {
        this.transferStage = transferStage;
    }

     /**
     * Returns true if the user clicked OK, false otherwise.
     * @return
     */
    public boolean chosenAnswer() {
        return this.answer;
    }
}