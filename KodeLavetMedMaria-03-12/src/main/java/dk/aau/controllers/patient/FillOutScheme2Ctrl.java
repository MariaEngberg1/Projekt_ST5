package dk.aau.controllers.patient;

import dk.aau.models.Generelinfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FillOutScheme2Ctrl {
    private Generelinfo generelinfo; 

    @FXML
    private TextField NaermesteNavnTF;

    @FXML
    private TextField NaermesteMobilTF;

    @FXML
    private TextField NaermesteTelefonTF;

    @FXML
    private TextField NaermesteArbTF;

    @FXML
    private CheckBox JaCheckBox;

    @FXML
    private CheckBox NejCheckbox;

    @FXML
    private Label NNavnlkkeUdfyldtLabel;

    @FXML
    private Label TlfMobilkkeudfyldLabel;

    @FXML
    private Label NArbejdeIkkeUdfyldLabel;

    @FXML
    private Label MRSAIkkeUdfyldLabel;

    @FXML
    void HandleNejCheckBox(ActionEvent event) {
        if( NejCheckbox.isSelected() ){
            JaCheckBox.setSelected(false);
            generelinfo.setMrsa("false");  
        }else{
            JaCheckBox.setSelected(true); 
            generelinfo.setMrsa("true");
        }
    }

    @FXML
    void handleJaCheckBox(ActionEvent event) {
        if( JaCheckBox.isSelected() ){
            NejCheckbox.setSelected(false);
            generelinfo.setMrsa("true");
        }else{
            NejCheckbox.setSelected(true); 
            generelinfo.setMrsa("false");  
        } 
    }

    public Boolean checkIfReadyToPresNext(){
        boolean bool = true; 
        if(NaermesteNavnTF.getPromptText().isEmpty() && NaermesteNavnTF.getText().isEmpty() ) {
            NNavnlkkeUdfyldtLabel.setVisible(true); 
            bool = false; 
        }else if(!NaermesteNavnTF.getText().isEmpty()) generelinfo.setNaermesteNavn(NaermesteNavnTF.getText());

        if(NaermesteMobilTF.getPromptText().isEmpty() && NaermesteMobilTF.getText().isEmpty() && NaermesteTelefonTF.getPromptText().isEmpty() && NaermesteTelefonTF.getText().isEmpty()) {
            TlfMobilkkeudfyldLabel.setVisible(true); 
            bool = false; 
        }
        if(!NaermesteMobilTF.getText().isEmpty()) generelinfo.setNaermesteMobil(NaermesteMobilTF.getText());
        if(!NaermesteTelefonTF.getText().isEmpty()) generelinfo.setNaermesteTlf(NaermesteTelefonTF.getText());

        if(NaermesteArbTF.getPromptText().isEmpty() && NaermesteArbTF.getText().isEmpty() ) {
            NArbejdeIkkeUdfyldLabel.setVisible(true); 
            bool = false; 
        }else if(!NaermesteArbTF.getText().isEmpty()) generelinfo.setNaermesteArbejde(NaermesteArbTF.getText());


        if(!JaCheckBox.isSelected() && !NejCheckbox.isSelected()){
            MRSAIkkeUdfyldLabel.setVisible(true); 
            bool = false; 
        }
        else if (JaCheckBox.isSelected()) generelinfo.setMrsa("true"); 
        else if (NejCheckbox.isSelected()) generelinfo.setMrsa("false"); 

        return bool; 
    }

    public void setInstansOfGeneralPersonInfo(Generelinfo generelinfo){
        this.generelinfo = generelinfo;

        NaermesteNavnTF.setPromptText(generelinfo.getNaermesteNavn());
        NaermesteMobilTF.setPromptText(generelinfo.getNaermesteMobil());
        NaermesteTelefonTF.setPromptText(generelinfo.getNaermesteTlf());
        NaermesteArbTF.setPromptText(generelinfo.getNaermesteArbejde());
        if ("true".equals(generelinfo.getMrsa())) JaCheckBox.setSelected(true); 
        if ("false".equals(generelinfo.getMrsa())) NejCheckbox.setSelected(true); 
    
    }

}
