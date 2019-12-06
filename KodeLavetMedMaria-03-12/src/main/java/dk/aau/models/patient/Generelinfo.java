package dk.aau.models.patient;

public class Generelinfo {
    // Denne information skal kun være i CS DB (ingen patient ændringer muligt): 
    private String navn;
    private String cprNummer; 
    private String egenLaegeNavn; 
    private String egenlaegeAdresse;

    // Denne information eksiterer allerede i CS DB, men skal også lageres i tempory DB, hvis patient ændringer forkommer. 
    private String mobilNummer; 
    private String telefonNummer; 
    private String naermesteNavn; 
    private String naermesteTlf; 
    private String naermesteMobil; 
    private String naermesteArbejde; 


    //Den information eksister kun i tempory DB, og skal besvares af patient hver gang : 
    private String mrsa; 
    private String okHentOplysninger; 
    private String skemaUdfyld; 
    private String arbejde; 

    /**
     * This contructor is used for storage of information fra Tempory database
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
     * This contructor is used for storage of information fra CS database
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
