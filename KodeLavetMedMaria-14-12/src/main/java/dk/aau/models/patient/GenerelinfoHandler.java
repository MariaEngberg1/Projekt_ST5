package dk.aau.models.patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dk.aau.models.database.Queryable;

public class GenerelinfoHandler implements Queryable {
    private String fetchDataFromWhichDB;
    private ArrayList<Generelinfo> generelinfoListe = new ArrayList<>();

    /**
     * Method is use to determine how information is stored in GenerelInformation
     * @param fetchDataFromWhichDB this input parameter determines wether downlaoded information should be storage as comming from CS or PSDB 
     */
    public GenerelinfoHandler(String fetchDataFromWhichDB){
        this.fetchDataFromWhichDB = fetchDataFromWhichDB; 
    }

    /**
     * Add object to array 
     * @param generelinfo this object will be stored in the array
     */
    public void addGenerelinfoListe(Generelinfo generelinfo) {
        generelinfoListe.add(generelinfo);
    }

    /**
     * @return size of array
     */
    public int getSizeOfGenerelinfoListe() {
        return generelinfoListe.size();
    }

    /**
     * @param locationNumberInArray type int 
     * @return the object in relative to the locationNumberInArray
     */
    public Generelinfo getGenerelinfoListe(int locationNumberInArray) {
        return generelinfoListe.get(locationNumberInArray);
    }

    /**
     * Method from the interface. This Class can now be used in this method "executeQueryWithResultSet(Queryable queryable, String sqlStatement)"
     */
    @Override
    public void processResultSet(ResultSet rs) throws SQLException {
        // Following metode is used when fetching information for tempory DB : 
        if ( fetchDataFromWhichDB.equals("PSDB") ){
            while(rs.next()){  
                Generelinfo generelinfo = new Generelinfo(rs.getString("CPR-nummer"), rs.getString("Mobilnummer"),rs.getString("telefonNummer"),rs.getString("naermesteNavn"),rs.getString("naermesteTlf"),rs.getString("naermesteMobil"),rs.getString("naermesteArbejde"), rs.getString("mrsa"), rs.getString("okHentOplysninger"), rs.getString("skemaudfyld"), rs.getString("arbejde") );  
                addGenerelinfoListe(generelinfo);
            }
        } 
        // Following metode is used when fetching information from Clinical DB : 
        else if (fetchDataFromWhichDB.equals("CSDB") ){
            while(rs.next()){
                Generelinfo generelinfo = new Generelinfo(rs.getString("Navn"), rs.getString("EgenlaegeNavn"), rs.getString("EgenlaegeAdresse"), rs.getString("CPR-nummer"), rs.getString("Mobilnummer"), rs.getString("telefonNummer"), rs.getString("naermesteNavn"), rs.getString("naermesteTlf"), rs.getString("naermesteMobil"), rs.getString("naermesteArbejde")); 
                addGenerelinfoListe(generelinfo);
            }
        }
    }

}