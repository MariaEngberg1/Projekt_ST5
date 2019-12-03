package dk.aau.models.patient;

public class DentalDamage{
    private Boolean dentalDamage;
    private Boolean prosthesis;
    private Boolean toothMobility;
    private Boolean dentalBrigde;
    private Boolean pivorTooth;
    private Boolean dentalCrown;

    public boolean getDentalDamage(){
        return dentalDamage; 
    }

    public void setDentalDamage(Boolean bool){
        this.dentalDamage = bool; 
    }

    public boolean getProsthesis(){
        return prosthesis; 
    }

    public void setProsthesis(Boolean bool){
        this.prosthesis = bool; 
    }

    public boolean getToothMobility(){
        return toothMobility; 
    }

    public void setToothMobility(Boolean bool){
        this.toothMobility = bool; 
    }

    public boolean getDentalBrigde(){
        return dentalBrigde; 
    }

    public void setDentalBrigde(Boolean bool){
        this.dentalBrigde = bool; 
    }

    public boolean getPivorTooth(){
        return pivorTooth; 
    }

    public void setPivorTooth(Boolean bool){
        this.pivorTooth = bool; 
    }

    public boolean getDentalCrown(){
        return dentalCrown; 
    }

    public void setDentalCrown(Boolean bool){
        this.dentalCrown = bool; 
    }
}