package dk.aau.models.patient; 

public class Consumption{
    private Boolean alcoholConsumption; 
    public Boolean getAlcoholConsumption(){
        return alcoholConsumption; 
    }
    public void setAlcoholConsumption(boolean alcoholConsumption){
        this.alcoholConsumption = alcoholConsumption;
    }

    //====================================================

    private Boolean tobaccoConsumption; 
    public Boolean getTobaccoConsumption(){
        return tobaccoConsumption; 
    }
    public void SetTobaccoConsumption(boolean tobaccoConsumption){
        this.tobaccoConsumption = tobaccoConsumption;
    }

    //====================================================

    private Boolean earlierConsumption; 
    public Boolean getEarlierConsumption(){
        return earlierConsumption; 
    }
    public void SetEarlierConsumption(boolean earlierConsumption){
        this.earlierConsumption = earlierConsumption;
    }

    //====================================================

    private String presentConsumption; 
    public String getPresentConsumption(){
        return this.presentConsumption;
    }
    public void setPresentConsumption(String presentConsumption){
        this.presentConsumption = presentConsumption;  
    }

    //====================================================

    private int smokelessYears; 
    public int getSmokelessYears(){
        return this.smokelessYears; 
    }
    public void setSmokelessYears(int smokelessYears){
        this.smokelessYears = smokelessYears; 
    }

    //====================================================

    private Boolean dailyConsumption; 
    public Boolean getDailyConsumption(){
        return dailyConsumption; 
    }
    public void setDailyConsumption(boolean dailyConsumption){
        this.dailyConsumption = dailyConsumption;
    }

    //====================================================

    private int weeklyConsumption; 
    public int getWeeklyConsumption(){
        return this.weeklyConsumption; 
    }
    public void setWeeklyConsumption(int weeklyConsumption){
        this.weeklyConsumption = weeklyConsumption; 
    }




}