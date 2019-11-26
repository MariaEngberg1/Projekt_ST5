package dk.aau.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Generelinfo {
    private final StringProperty navn;
    private final StringProperty cpr; 
    private final StringProperty arbejde;
    private final StringProperty mobil;
    private final StringProperty egenlaegeNavn;
    private final StringProperty egenlaegeAdresse; 


    public Generelinfo (){
        this(null, null, null, null, null, null);
    }

    public Generelinfo(String navn, String cpr, String arbejde, String mobil, String egenlaegeNavn, String egenlaegeAdresse){ 
        this.navn = new SimpleStringProperty(navn);
        this.cpr = new SimpleStringProperty(cpr);
        this.arbejde = new SimpleStringProperty(arbejde);
        this.mobil = new SimpleStringProperty(mobil);
        this.egenlaegeNavn = new SimpleStringProperty(egenlaegeNavn);
        this.egenlaegeAdresse = new SimpleStringProperty(egenlaegeAdresse);
    }

    public void setNavn (String navn){
        this.navn.set(navn);
    }

    public String getNavn (){
        return navn.get();
    }
    
    public void setCPR (String cpr){
        this.cpr.set(cpr);
    }

    public String getCPR (){
        return cpr.get();
    }

    public void setArbejde (String arbejde){
        this.arbejde.set(arbejde);
    }

    public String getArbejde (){
        return arbejde.get();
    }

    public void setMobil (String mobil){
        this.mobil.set(mobil);
    }

    public String getMobil (){
        return mobil.get();
    }

    public void setEgenlaegeNavn (String egenlaegeNavn){
        this.egenlaegeNavn.set(egenlaegeNavn);
    }

    public String getEgenlaegeNavn (){
        return egenlaegeNavn.get();
    }

    public void setEgenlaegeAdresse (String egenlaegeAdresse){
        this.egenlaegeAdresse.set(egenlaegeAdresse);
    }

    public String getEgenlaegeAdresse (){
        return egenlaegeAdresse.get();
    }

}