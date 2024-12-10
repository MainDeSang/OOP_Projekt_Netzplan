import java.util.List;

public class Arbeitspaket {
    private int apNr;
    private String name;
    private int dauer;
    private int faz;
    private int fez;
    private int saz;
    private int sez;
    private int fp;
    private int gp;
    private List<Arbeitspaket> vorgaengerListe;
    private List<Arbeitspaket> nachfolgerListe;


    public int getApNr() {
        return apNr;
    }

    public void setApNr(int apNr) {
        this.apNr = apNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public int getFaz() {
        return faz;
    }

    public void setFaz(int faz) {
        this.faz = faz;
    }

    public int getFez() {
        return fez;
    }

    public void setFez(int fez) {
        this.fez = fez;
    }

    public int getSaz() {
        return saz;
    }

    public void setSaz(int saz) {
        this.saz = saz;
    }

    public int getSez() {
        return sez;
    }

    public void setSez(int sez) {
        this.sez = sez;
    }

    public int getFp() {
        return fp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }

    public int getGp() {
        return gp;
    }

    public void setGp(int gp) {
        this.gp = gp;
    }

    public List<Arbeitspaket> getVorgaengerListe() {
        return vorgaengerListe;
    }

    public void setVorgaengerListe(List<Arbeitspaket> vorgaengerListe) {
        this.vorgaengerListe = vorgaengerListe;
    }

    public List<Arbeitspaket> getNachfolgerListe() {
        return nachfolgerListe;
    }

    public void setNachfolgerListe(List<Arbeitspaket> nachfolgerListe) {
        this.nachfolgerListe = nachfolgerListe;
    }

    public int calculateFP(int faz, int fez) {
        return faz - fez;
    }

    public int calculateGP(int saz, int faz) {
        return saz - faz;
    }
}
