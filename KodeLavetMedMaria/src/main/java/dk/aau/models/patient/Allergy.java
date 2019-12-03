package dk.aau.models.patient;

import java.sql.ResultSet;
import java.sql.SQLException;

import dk.aau.models.database.Queryable;

public class Allergy implements Queryable {
    private boolean latexAllergy;
    private boolean pencillinAllergy;
    private String allergyDescription;

/*
    public Allergy(Boolean latexAllergy, Boolean pencillinAllergy, String allergyDescription){ 
        this.latexAllergy = latexAllergy;
        this.pencillinAllergy = pencillinAllergy; 
        this.allergyDescription = allergyDescription; 
    }
    */

    public boolean getLatexAllergy() {
        return this.latexAllergy;
    }

    public void setLatexAllergy(boolean latexAllergy) {
        this.latexAllergy = latexAllergy;
    }

    // ====================================================

    public boolean getPencillinAllergy() {
        return this.pencillinAllergy;
    }

    public void setPencillin(boolean pencillinAllergy) {
        this.pencillinAllergy = pencillinAllergy;
    }

    // ====================================================

    public String getAllergyDescription() {
        return this.allergyDescription;
    }

    public void setAllergyDescription(String allergyDescription) {
        this.allergyDescription = allergyDescription;
    }

    @Override
    public void processResultSet(ResultSet rs) throws SQLException {
        while(rs.next()){
            setLatexAllergy(rs.getBoolean("latexAllergy")); 
            setPencillin(rs.getBoolean("pencillinAllergy"));
            setAllergyDescription(rs.getString("allergyDescription")); 
        }
    }

    




}