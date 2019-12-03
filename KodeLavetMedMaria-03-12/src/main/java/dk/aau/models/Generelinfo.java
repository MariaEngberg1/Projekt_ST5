package dk.aau.models;

public class Generelinfo {
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
    private String skemaUdfyld; 

    public Generelinfo(){}

    public Generelinfo(String navn, String cprNummer, String arbejde, String mobilNummer, String telefonNummer, String adresse, String naermesteNavn, String naermesteTlf, String naermesteMobil, String naermesteArbejde, String mrsa, String egenLaegeNavn, String okHentOplysninger, String skemaUdfyld){ 
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
        this.skemaUdfyld = skemaUdfyld; 
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

    public String getSkemaUdfyld() {
        return skemaUdfyld;
    }

    public void setSkemaUdfyld(String skemaUdfyld) {
        this.skemaUdfyld = skemaUdfyld;
    }


    /*
    private final StringProperty navn; 
    private final StringProperty cpr; 
    private final StringProperty arbejde;
    private final StringProperty mobil;
    private final StringProperty egenlaegeNavn;
    private final StringProperty egenlaegeAdresse; 

    public Generelinfo(String navn, String cpr, String arbejde, String mobil, String egenlaegeNavn, String egenlaegeAdresse){ 
        this.navn = new SimpleStringProperty(navn);
        this.cpr = new SimpleStringProperty(cpr);
        this.arbejde = new SimpleStringProperty(arbejde);
        this.mobil = new SimpleStringProperty(mobil);
        this.egenlaegeNavn = new SimpleStringProperty(egenlaegeNavn);
        this.egenlaegeAdresse = new SimpleStringProperty(egenlaegeAdresse);
    }
    


    public void setNavn (String navn){
        this.navn.set(navn);
    }

    public String getNavn (){
        return navn.get();
    }
    
    public void setCPR (String cpr){
        this.cpr.set(cpr);
    }

    public String getCPR (){
        return cpr.get();
    }

    public void setArbejde (String arbejde){
        this.arbejde.set(arbejde);
    }

    public String getArbejde (){
        return arbejde.get();
    }

    public void setMobil (String mobil){
        this.mobil.set(mobil);
    }

    public String getMobil (){
        return mobil.get();
    }

    public void setEgenlaegeNavn (String egenlaegeNavn){
        this.egenlaegeNavn.set(egenlaegeNavn);
    }

    public String getEgenlaegeNavn (){
        return egenlaegeNavn.get();
    }

    public void setEgenlaegeAdresse (String egenlaegeAdresse){
        this.egenlaegeAdresse.set(egenlaegeAdresse);
    }

    public String getEgenlaegeAdresse (){
        return egenlaegeAdresse.get();
    }
    */

}