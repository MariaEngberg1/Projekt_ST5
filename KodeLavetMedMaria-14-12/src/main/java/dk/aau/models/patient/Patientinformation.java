package dk.aau.models.patient; 

public class Patientinformation{
    public Generelinfo generelInfoPSDB;
    public Generelinfo generelinfoCSDB;
    public TidligereSygdomme tidligereSygdommePSDB; 
    public TidligereSygdomme tidligereSygdommeCSDB;

    /**
     * constructor for patientinformaiton. It creaste 2 object of 'tidligereSygdommePSDB'
     * The objects of Generelinfo is created through the database connection
     */
    public Patientinformation (){
        tidligereSygdommePSDB = new TidligereSygdomme(); 
        tidligereSygdommeCSDB = new TidligereSygdomme(); 
    }

    /**
     * Set the instance of generelInfoPSDB that the patient object holds
     * @param generelInfoPSDB
     */
    public void setGenerelInfoPSDB(Generelinfo generelInfoPSDB) {
        this.generelInfoPSDB = generelInfoPSDB;
    }

    /**
     * Set the instance of generelInfoCSDB that the patient object holds 
     * @param generelinfoCSDB
     */
    public void setGenerelinfoCSDB(Generelinfo generelinfoCSDB) {
        this.generelinfoCSDB = generelinfoCSDB;
    }


    /**
     * Set the instance of tidligereSygdommePSDB that the patient object holds 
     * @param tidligereSygdommePSDB
     */
    public void setTidligereSygdommePSDB(TidligereSygdomme tidligereSygdommePSDB) {
        this.tidligereSygdommePSDB = tidligereSygdommePSDB;
    }

    /**
     * Set the instance of tidligereSygdommeCSDB that the patient object holds 
     * @param tidligereSygdommeCSDB
     */
    public void setTidligereSygdommeCSDB(TidligereSygdomme tidligereSygdommeCSDB) {
        this.tidligereSygdommeCSDB = tidligereSygdommeCSDB;
    }
}