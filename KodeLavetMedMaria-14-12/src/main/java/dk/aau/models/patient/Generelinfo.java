package dk.aau.models.patient;

public class Generelinfo {
    // This information only exists in Clinical Suite Database - not editable for patient
    private String navn;
    private String cprNummer; 
    private String egenLaegeNavn; 
    private String egenlaegeAdresse;

    // This information exist in Clinical Suite Database, but should be stored in PSDB - editable for patient
    private String mobilNummer; 
    private String telefonNummer; 
    private String naermesteNavn; 
    private String naermesteTlf; 
    private String naermesteMobil; 
    private String naermesteArbejde; 

    // This informaiton only exist in PSDB - editable for patient
    private String mrsa; 
    private String okHentOplysninger; 
    private String skemaUdfyld; 
    private String arbejde; 

    /**
     * This contructor is used for storage of information from PSDB
     */
    public Generelinfo(String cprNummer, String mobilNummer, String telefonNummer, String naermesteNavn, String naermesteTlf, String naermesteMobil, String naermesteArbejde,  String mrsa, String okHentOplysninger,  String skemaudfyld, String arbejde){
        // Denne information skal bruges til besvarelse af PBS
        this.cprNummer = cprNummer; 
        this.arbejde = arbejde; 
        this.mrsa = mrsa; 

        // Denne informaiton skal 
        this.mobilNummer = mobilNummer; 
        this.telefonNummer = telefonNummer; 
        this.naermesteNavn = naermesteNavn; 
        this.naermesteTlf = naermesteTlf; 
        this.naermesteMobil = naermesteMobil; 
        this.naermesteArbejde = naermesteArbejde; 
        this.okHentOplysninger = okHentOplysninger; 
        this.skemaUdfyld = skemaudfyld; 
    }

    /**
     * This contructor is used for storage of information from Clinical Suite DB 
     */
    public Generelinfo(String navn, String egenLaegeNavn, String egenlaegeAdresse, String cprNummer, String mobilNummer, String telefonNummer, String naermesteNavn, String naermesteTlf, String naermesteMobil, String naermesteArbejde){ 
        this.navn = navn; 
        this.egenLaegeNavn = egenLaegeNavn; 
        this.egenlaegeAdresse = egenlaegeAdresse; 
        this.cprNummer = cprNummer; 
        this.mobilNummer = mobilNummer; 
        this.telefonNummer = telefonNummer; 
        this.naermesteNavn = naermesteNavn; 
        this.naermesteTlf = naermesteTlf; 
        this.naermesteMobil = naermesteMobil; 
        this.naermesteArbejde = naermesteArbejde;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getCprNummer() {
        return cprNummer;
    }

    public void setCprNummer(String cprNummer) {
        this.cprNummer = cprNummer;
    }

    public String getArbejde() {
        return arbejde;
    }

    public void setArbejde(String arbejde) {
        this.arbejde = arbejde;
    }

    public String getMobilNummer() {
        return mobilNummer;
    }

    public void setMobilNummer(String mobilNummer) {
        this.mobilNummer = mobilNummer;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    public String getNaermesteNavn() {
        return naermesteNavn;
    }

    public void setNaermesteNavn(String naermesteNavn) {
        this.naermesteNavn = naermesteNavn;
    }

    public String getNaermesteTlf() {
        return naermesteTlf;
    }

    public void setNaermesteTlf(String naermesteTlf) {
        this.naermesteTlf = naermesteTlf;
    }

    public String getNaermesteMobil() {
        return naermesteMobil;
    }

    public void setNaermesteMobil(String naermesteMobil) {
        this.naermesteMobil = naermesteMobil;
    }

    public String getNaermesteArbejde() {
        return naermesteArbejde;
    }

    public void setNaermesteArbejde(String naermesteArbejde) {
        this.naermesteArbejde = naermesteArbejde;
    }

    public String getMrsa() {
        return mrsa;
    }

    public void setMrsa(String mrsa) {
        this.mrsa = mrsa;
    }

    public String getEgenLaegeNavn() {
        return egenLaegeNavn;
    }

    public void setEgenLaegeNavn(String egenLaegeNavn) {
        this.egenLaegeNavn = egenLaegeNavn;
    }

    public String getOkHentOplysninger() {
        return okHentOplysninger;
    }

    public void setOkHentOplysninger(String okHentOplysninger) {
        this.okHentOplysninger = okHentOplysninger;
    }

    public String getSkemaUdfyld() {
        return skemaUdfyld;
    }

    public void setSkemaUdfyld(String skemaUdfyld) {
        this.skemaUdfyld = skemaUdfyld;
    }

    public String getEgenlaegeAdresse() {
        return egenlaegeAdresse;
    }

    public void setEgenlaegeAdresse(String egenlaegeAdresse) {
        this.egenlaegeAdresse = egenlaegeAdresse;
    }
}
