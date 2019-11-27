package dk.aau.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dk.aau.models.database.Queryable;

public class GenerelinfoHandler implements Queryable {
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
        while(rs.next()){
            Generelinfo generelinfo = new Generelinfo(rs.getString("Navn"), rs.getString("CPR-nummer"), rs.getString("Arbejde"), rs.getString("Mobilnummer"), rs.getString("EgenLaegeNavn"), rs.getString("EgenLaegeAdresse"));
           //Generelinfo generelinfo = new Generelinfo(rs.getString("CPR_nummer"), rs.getString("Name"));
           addGenerelinfoListe(generelinfo);
        }

    }

}