package dk.aau.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dk.aau.models.database.Queryable;

public class CS_GenerelinfoHandler implements Queryable {
    private ArrayList<CS_Generelinfo> csGenerelinfoListe = new ArrayList<>();

    public void addCSGenerelinfoListe(CS_Generelinfo csGenerelinfo) {
        csGenerelinfoListe.add(csGenerelinfo);
    }

    public int getSizeOfCSGenerelinfoListe() {
        return csGenerelinfoListe.size();
    }

    public CS_Generelinfo getCSGenerelinfoListe(int pladsNummer) {
        return csGenerelinfoListe.get(pladsNummer);
    }

    @Override
    public void processResultSet(ResultSet rs) throws SQLException {
        while(rs.next()){
            CS_Generelinfo csgenerelinfo = new CS_Generelinfo(rs.getString("Navn"), rs.getString("CPR-nummer"), rs.getString("Arbejde"), rs.getString("Mobilnummer"), rs.getString("telefonNummer"), rs.getString("adresse"), rs.getString("naermesteNavn"), rs.getString("naermesteTlf"), rs.getString("naermesteMobil"), rs.getString("naermesteArbejde"), rs.getString("mrsa"), rs.getString("EgenLaegeNavn"), rs.getString("okHentOplysninger"));
            addCSGenerelinfoListe(csgenerelinfo);
        }

    }

}