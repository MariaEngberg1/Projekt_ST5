package dk.aau.models.patient; 

public class Patientinformation{
    public Generelinfo generelInfoPSDB;
    public Generelinfo generelinfoCSDB;
    public TidligereSygdomme tidligereSygdommePSDB; 
    public TidligereSygdomme tidligereSygdommeCSDB;

    public Patientinformation (){
        tidligereSygdommePSDB = new TidligereSygdomme(); 
        tidligereSygdommeCSDB = new TidligereSygdomme(); 

    }

    public void setGenerelInfoPSDB(Generelinfo generelInfoPSDB) {
        this.generelInfoPSDB = generelInfoPSDB;
    }

    public void setGenerelinfoCSDB(Generelinfo generelinfoCSDB) {
        this.generelinfoCSDB = generelinfoCSDB;
    }


    public void setTidligereSygdommePSDB(TidligereSygdomme tidligereSygdommePSDB) {
        this.tidligereSygdommePSDB = tidligereSygdommePSDB;
    }


    public void setTidligereSygdommeCSDB(TidligereSygdomme tidligereSygdommeCSDB) {
        this.tidligereSygdommeCSDB = tidligereSygdommeCSDB;
    }
}