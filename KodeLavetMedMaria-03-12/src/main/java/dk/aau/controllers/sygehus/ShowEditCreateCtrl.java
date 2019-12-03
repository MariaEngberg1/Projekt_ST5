package dk.aau.controllers.sygehus;

import dk.aau.App;
import dk.aau.models.CS_Generelinfo;
import dk.aau.models.Generelinfo;
import dk.aau.models.database.DatabaseManipulator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ShowEditCreateCtrl{
    private App mainApp; 
    private CS_Generelinfo cs_generelinfo;
    private Generelinfo generelinfo; 
    private String selectedDirection; 

    
    @FXML
    private Label infoLabel;

    @FXML
    private Label egenlaegeOplysninger;
    
    @FXML
    private TextField PatientNavnTF;

    @FXML
    private TextField cprTF;

    @FXML
    private TextField tlfTF;

    @FXML
    private TextField arbejdeTF;

    @FXML
    private TextField mobilTF;

    @FXML
    private TextField adresseFT;

    @FXML
    private TextField naermesteNavnTF;

    @FXML
    private TextField naermesteTlfTF;

    @FXML
    private TextField naermesteMobilTF;

    @FXML
    private TextField naermesteArbejdeTF;

    @FXML
    private TextField EgenLaegeTF;

    @FXML
    private Label tlfIkkeUdfyldtLabel;

    @FXML
    private Label mobilIkkeUdfyldtLabel;

    @FXML
    private Label ArbejdeIkkeUdfyldtLabel;

    @FXML
    private Label AdresseIkkeUdfyldtLabel;

    @FXML
    private Label mrsaIkkeUdfyldtLabel;

    @FXML
    private Label naermesteNavnIkkeUdfyldtLabel;

    @FXML
    private Label naermesteTlfIkkeUdfyldtLabel;

    @FXML
    private Label naermesteMobilIkkeUdfyldtLabel;

    @FXML
    private Label naermestearbejdeIkkeUdfyldtLabel;

    @FXML
    private Label egenLaegeIkkeUdfyldtLabel;


    @FXML
    private CheckBox hjertesygdomJaCheckBox;

    @FXML
    private Label HjerteSygdommeIkkeUdfyldtLabel;

    @FXML
    private Label astmaIkkeUdfyldtLabel;

    @FXML
    private Label NyresygdomIkkeUdfyldtLabel;

    @FXML
    private Label sukkersygeIkkeUdfyldtLabel;

    @FXML
    private Label andreSygdommeIkkeUdfyldtLabel;

    @FXML
    private Label bloederSygdommeIkkeUdfyldtLabel;

    @FXML
    private Label mavesaarIkkeUdfyldtLabel;

    @FXML
    private Label halsbrandIkkeUdfyldtLabel;

    @FXML
    private Label HoejBlodtrykIkkeUdfyldtLabel;

    @FXML
    private Label ElilepsiIkkeUdfyldtLabel;

    @FXML
    private Label rygprogroblemmerIkkeUdfyldtLabel;

    @FXML
    private Label hofteProblemIkkeUdfyldtLabel;

    @FXML
    private Label stoftSkifteIkkeUdfyldtLabel;

    @FXML
    private Button SendTilPatientBnt;

    @FXML
    private Label overSkriftlabel_id;

    @FXML
    private CheckBox henteOplysningerJaCheckBnt;

    @FXML
    private CheckBox henteOplysningerNejCheckBnt;

    @FXML
    void HandleHenteOplysningerJaCheckBnt(ActionEvent event) {
        if(selectedDirection.equals("tilgaa")){
            if( henteOplysningerJaCheckBnt.isSelected() ){
                henteOplysningerNejCheckBnt.setSelected(false);
                henteOplysningerJaCheckBnt.setSelected(true);
            }else{
                henteOplysningerNejCheckBnt.setSelected(true); 
                henteOplysningerJaCheckBnt.setSelected(false);
            }
        }
    }

    @FXML
    void handlehenteOplysningerNejCheckBnt(ActionEvent event) {
        if(selectedDirection.equals("tilgaa")){
            if( henteOplysningerNejCheckBnt.isSelected() ){
                henteOplysningerJaCheckBnt.setSelected(false);
                henteOplysningerNejCheckBnt.setSelected(true);
            }else{
                henteOplysningerJaCheckBnt.setSelected(true); 
                henteOplysningerNejCheckBnt.setSelected(false);
            }
        }
    }

    
    @FXML
    private CheckBox mrsaJaCheckBnt;

    @FXML
    private CheckBox mrsaCheckBnt;

    @FXML
    void handleMrsaJaCheckBnt(ActionEvent event) {
        if(selectedDirection.equals("tilgaa")){
            if( mrsaJaCheckBnt.isSelected() ){
                mrsaCheckBnt.setSelected(false);
                mrsaJaCheckBnt.setSelected(true);
            }else{
                mrsaCheckBnt.setSelected(true); 
                mrsaJaCheckBnt.setSelected(false);
            }
        }
    }

    @FXML
    void handleMrsaNejCheckBnt(ActionEvent event) {
        if(selectedDirection.equals("tilgaa")){
            if( mrsaCheckBnt.isSelected() ){
                mrsaJaCheckBnt.setSelected(false);
                mrsaCheckBnt.setSelected(true);
            }else{
                mrsaJaCheckBnt.setSelected(true); 
                mrsaCheckBnt.setSelected(false);
            }
        }
    }

    

    @FXML
    void handleSendtilPatientBnt(ActionEvent event) {
        if("opret".equals(selectedDirection)){
            DatabaseManipulator.updateDataBase("INSERT INTO `GenerelInformation` (`Navn`, `CPR-nummer`, `Arbejde`, `Mobilnummer`, `telefonNummer`, `adresse`, `naermesteNavn`, `naermesteTlf`, `naermesteMobil`, `naermesteArbejde`, `mrsa`, `EgenLaegeNavn`, `okHentOplysninger`, `SkemaUdfyld`) VALUES ('"+cs_generelinfo.getNavn()+"', '"+cs_generelinfo.getCprNummer()+"', '"+cs_generelinfo.getArbejde()+"', '"+cs_generelinfo.getMobilNummer()+"', '"+cs_generelinfo.getNaermesteTlf()+"', '"+cs_generelinfo.getAdresse()+"', '"+cs_generelinfo.getNaermesteNavn()+"', '"+cs_generelinfo.getNaermesteTlf()+"', '"+cs_generelinfo.getNaermesteMobil()+"', '"+cs_generelinfo.getNaermesteArbejde()+"', '"+cs_generelinfo.getMrsa()+"', '"+cs_generelinfo.getEgenLaegeNavn()+"', '"+cs_generelinfo.getOkHentOplysninger()+"', 'false')");
            mainApp.ShowScheme(); 
        } else System.out.println("IDK what to do?");
    }

    @FXML
    void handleTilbageBnt(ActionEvent event) {
        mainApp.ShowScheme(); 
    }



    public void setReference(App mainApp, CS_Generelinfo cs_generelinfo, String selectedDirection ){
        this.mainApp = mainApp; 
        this.cs_generelinfo = cs_generelinfo; 
        this.selectedDirection = selectedDirection; 

        PatientNavnTF.setText(cs_generelinfo.getNavn());
        PatientNavnTF.setEditable(false);

        cprTF.setText(cs_generelinfo.getCprNummer());
        cprTF.setEditable(false);

        tlfTF.setText(cs_generelinfo.getTelefonNummer());
        tlfTF.setEditable(false);

        arbejdeTF.setText(cs_generelinfo.getArbejde());
        arbejdeTF.setEditable(false);

        mobilTF.setText(cs_generelinfo.getMobilNummer());
        mobilTF.setEditable(false);

        adresseFT.setText(cs_generelinfo.getAdresse());
        adresseFT.setEditable(false);

        naermesteNavnTF.setText(cs_generelinfo.getNaermesteNavn()); 
        naermesteNavnTF.setEditable(false);

        naermesteTlfTF.setText(cs_generelinfo.getNaermesteTlf());
        naermesteTlfTF.setEditable(false);

        naermesteArbejdeTF.setText(cs_generelinfo.getNaermesteArbejde());
        naermesteArbejdeTF.setEditable(false);

        naermesteMobilTF.setText(cs_generelinfo.getNaermesteMobil());
        naermesteMobilTF.setEditable(false);

        EgenLaegeTF.setText(cs_generelinfo.getEgenLaegeNavn());
        EgenLaegeTF.setEditable(false);

        if (cs_generelinfo.getMrsa().equals("true")) mrsaJaCheckBnt.setSelected(true); 
        if (cs_generelinfo.getMrsa().equals("false") || cs_generelinfo.getMrsa().isEmpty()) mrsaJaCheckBnt.setSelected(true); 


    }

    public void setReference(App mainApp, CS_Generelinfo cs_generelinfo, Generelinfo generelinfo, String selectedDirection ){
        this.mainApp = mainApp; 
        this.cs_generelinfo = cs_generelinfo; 
        this.selectedDirection = selectedDirection; 

        PatientNavnTF.setText(cs_generelinfo.getNavn());
        PatientNavnTF.setEditable(false);

        cprTF.setText(cs_generelinfo.getCprNummer());
        cprTF.setEditable(false);


        tlfTF.setText(cs_generelinfo.getTelefonNummer());
        if(!cs_generelinfo.getTelefonNummer().equals(generelinfo.getTelefonNummer())){
            tlfIkkeUdfyldtLabel.setVisible(true);
            tlfIkkeUdfyldtLabel.setText(generelinfo.getTelefonNummer());
        }
        
        arbejdeTF.setText(cs_generelinfo.getArbejde());
        if(!cs_generelinfo.getArbejde().equals(generelinfo.getArbejde())){
            ArbejdeIkkeUdfyldtLabel.setVisible(true);
            ArbejdeIkkeUdfyldtLabel.setText(generelinfo.getArbejde());
        }
        
        mobilTF.setText(cs_generelinfo.getMobilNummer());
        if(!cs_generelinfo.getMobilNummer().equals(generelinfo.getMobilNummer())){
            mobilIkkeUdfyldtLabel.setVisible(true);
            mobilIkkeUdfyldtLabel.setText(generelinfo.getMobilNummer());
        }
        
        adresseFT.setText(cs_generelinfo.getAdresse());
        if(!cs_generelinfo.getAdresse().equals(generelinfo.getAdresse())){
            AdresseIkkeUdfyldtLabel.setVisible(true);
            AdresseIkkeUdfyldtLabel.setText(generelinfo.getAdresse());
        }
        
        naermesteNavnTF.setText(cs_generelinfo.getNaermesteNavn()); 
        if(!cs_generelinfo.getNaermesteNavn().equals(generelinfo.getNaermesteNavn())){
            naermesteNavnIkkeUdfyldtLabel.setVisible(true);
            naermesteNavnIkkeUdfyldtLabel.setText(generelinfo.getNaermesteNavn());
        }
        
        naermesteTlfTF.setText(cs_generelinfo.getNaermesteTlf());
        if(!cs_generelinfo.getNaermesteTlf().equals(generelinfo.getNaermesteTlf())){
            naermesteTlfIkkeUdfyldtLabel.setVisible(true);
            naermesteTlfIkkeUdfyldtLabel.setText(generelinfo.getNaermesteTlf());
        }
        
        naermesteArbejdeTF.setText(cs_generelinfo.getNaermesteArbejde());
        if(!cs_generelinfo.getNaermesteArbejde().equals(generelinfo.getNaermesteArbejde())){
            naermestearbejdeIkkeUdfyldtLabel.setVisible(true);
            naermestearbejdeIkkeUdfyldtLabel.setText(generelinfo.getNaermesteArbejde());
        }
        
        naermesteMobilTF.setText(cs_generelinfo.getNaermesteMobil());
        if(!cs_generelinfo.getNaermesteMobil().equals(generelinfo.getNaermesteMobil())){
            naermesteMobilIkkeUdfyldtLabel.setVisible(true);
            naermesteMobilIkkeUdfyldtLabel.setText(generelinfo.getNaermesteMobil());
        }
        
        EgenLaegeTF.setText(cs_generelinfo.getEgenLaegeNavn());
        if(!cs_generelinfo.getEgenLaegeNavn().equals(generelinfo.getEgenLaegeNavn())){
            egenLaegeIkkeUdfyldtLabel.setVisible(true);
            egenLaegeIkkeUdfyldtLabel.setText(generelinfo.getEgenLaegeNavn());
        }

        if (cs_generelinfo.getMrsa().equals("true")) mrsaJaCheckBnt.setSelected(true); 
        if (cs_generelinfo.getMrsa().equals("false") || cs_generelinfo.getMrsa().isEmpty()) mrsaCheckBnt.setSelected(true); 

        if (!cs_generelinfo.getMrsa().equals(generelinfo.getMrsa())){
            mrsaIkkeUdfyldtLabel.setVisible(true); 
            if(generelinfo.getMrsa().equals("true"))  mrsaIkkeUdfyldtLabel.setText("Ja");
            if(generelinfo.getMrsa().equals("false"))  mrsaIkkeUdfyldtLabel.setText("Nej");
        } 

        //====================
        if (cs_generelinfo.getOkHentOplysninger().equals("true")) henteOplysningerJaCheckBnt.setSelected(true); 
        if (cs_generelinfo.getOkHentOplysninger().equals("false") || cs_generelinfo.getOkHentOplysninger().isEmpty()) henteOplysningerNejCheckBnt.setSelected(true); 

        

        if (!cs_generelinfo.getOkHentOplysninger().equals(generelinfo.getOkHentOplysninger())){
            egenlaegeOplysninger.setVisible(true); 
            
            if(generelinfo.getOkHentOplysninger().equals("true"))  egenlaegeOplysninger.setText("Ja");
            if(generelinfo.getOkHentOplysninger().equals("false")) egenlaegeOplysninger.setText("Nej");
        } 
    }
}