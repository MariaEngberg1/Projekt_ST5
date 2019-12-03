package dk.aau.models.patient;

import dk.aau.models.Generelinfo;
import dk.aau.models.database.DatabaseManipulator;
import dk.aau.models.patient.*;

public class Patient{
    private String patientCPR; 
    Generelinfo generelInfo; 
    Hospitalization hospitalization; 
    Medicine medicine; 
    DiseaseType diseaseType; 
    Consumption consumption; 
    Nourishment nourishment; 
    Exercise exercise; 
    DentalDamage dentalDemage = new DentalDamage(); 
    Allergy allergy = new Allergy(); 


}