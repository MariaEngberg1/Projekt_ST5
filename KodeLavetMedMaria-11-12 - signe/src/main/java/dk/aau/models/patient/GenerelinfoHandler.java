package dk.aau.models.patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dk.aau.models.database.Queryable;

public class GenerelinfoHandler implements Queryable {
    private String fetchDataFromWhichDB;

    /**
     * @param fetchDataFromWhichDB this indput paremeter determines wether it downlaod fra CS or tempory DB 
     */
    public GenerelinfoHandler(String fetchDataFromWhichDB){
        this.fetchDataFromWhichDB = fetchDataFromWhichDB; 
    }

    private ArrayList<Generelinfo> generelinfoListe = new ArrayList<>();

    public void addGenerelinfoListe(Generelinfo generelinfo) {
        generelinfoListe.add(generelinfo);
    }

    public int getSizeOfGenerelinfoListe() {
        return generelinfoListe.size();
    }

    public Generelinfo getGenerelinfoListe(int pladsNummer) {
        return generelinfoListe.get(pladsNummer);
    }

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