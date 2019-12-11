package dk.aau.models.patient; 

public class Patient{
    private Generelinfo generelInfoTemporyDB;
    private Generelinfo generelinfoClinicalSuiteDB;

    public Generelinfo getGenerelInfoTemporyDB() {
        return generelInfoTemporyDB;
    }
//
    public void setGenerelInfoTemporyDB(Generelinfo generelInfoTemporyDB) {
        this.generelInfoTemporyDB = generelInfoTemporyDB;
    }

    public Generelinfo getGenerelinfoClinicalSuiteDB() {
        return generelinfoClinicalSuiteDB;
    }

    public void setGenerelinfoClinicalSuiteDB(Generelinfo generelinfoClinicalSuiteDB) {
        this.generelinfoClinicalSuiteDB = generelinfoClinicalSuiteDB;
    }
}