package dk.aau.models; 

public class CS_Generelinfo{
    private String navn;
    private String cprNummer; 
    private String arbejde; 
    private String mobilNummer; 
    private String telefonNummer; 
    private String adresse; 
    private String naermesteNavn; 
    private String naermesteTlf; 
    private String naermesteMobil; 
    private String naermesteArbejde; 
    private String mrsa; 
    private String egenLaegeNavn; 
    private String okHentOplysninger;

    public CS_Generelinfo(String navn, String cprNummer, String arbejde, String mobilNummer, String telefonNummer, String adresse, String naermesteNavn, String naermesteTlf, String naermesteMobil, String naermesteArbejde, String mrsa, String egenLaegeNavn, String okHentOplysninger){ 
        this.navn = navn; 
        this.cprNummer = cprNummer; 
        this.arbejde = arbejde; 
        this.mobilNummer = mobilNummer; 
        this.telefonNummer = telefonNummer; 
        this.adresse = adresse; 
        this.naermesteNavn = naermesteNavn; 
        this.naermesteTlf = naermesteTlf; 
        this.naermesteMobil = naermesteMobil; 
        this.naermesteArbejde = naermesteArbejde;
        this.mrsa = mrsa; 
        this.egenLaegeNavn = egenLaegeNavn; 
        this.okHentOplysninger = okHentOplysninger; 
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
}