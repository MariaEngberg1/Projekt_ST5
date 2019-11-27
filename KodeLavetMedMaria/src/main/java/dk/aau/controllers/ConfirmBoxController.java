package dk.aau.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ConfirmBoxController {
    private Stage dialogStage;
    private Boolean answer; 

    public void initialize() {
    }

    @FXML
    void handlerJaBnt(ActionEvent event) {
        this.answer = true; 
        dialogStage.close();
    }

    @FXML
    void handlerNejBnt(ActionEvent event) {
        this.answer = false; 
        dialogStage.close();
    }

     /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

     /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean chosenAnswer() {
        return this.answer;
    }
}