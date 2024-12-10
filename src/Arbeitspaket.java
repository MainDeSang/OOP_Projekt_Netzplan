import java.util.List;
import java.util.Scanner;

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


    public Arbeitspaket() {
        // Try-Catch-Block im Konstruktor um eventuell aufkommende fehler bei der Initialisierung der Objekte oder fehler bei der Eingabe des Nutzers aufzufangen.
        try {


            Scanner apNr = new Scanner(System.in); // Scanner für Eingabe erstellen
            System.out.print("Bitte geben Sie die Arbeitspaket Nummer ein: "); // Konsolenausgabe mit Eingabeaufforderung an den Nutzer
            if (apNr.hasNextInt()) { //überprüfen ob Nutzereingabe richtigen Wert/Typ hat.
                this.apNr = apNr.nextInt(); // Wert der privaten Variable setzen
            } else {
                System.out.println("Eingabe ist ungültig! Bitte geben Sie eine Dezimalzahl ein!");
            }


            Scanner name = new Scanner(System.in); // Scanner für Eingabe erstellen
            System.out.println("Bitte geben Sie den Namen des Arbeitspakets ein: "); // Konsolenausgabe mit Eingabeaufforderung an den Nutzer
            if (name.hasNextLine()) { // Wert der privaten Variable setzen
                this.name = name.nextLine();
            } else {
                System.out.println("Eingabe ist ungültig! Bitte geben Sie einen Namen in lateinischen Buchstaben ohne Sonderzeichen ein.");
            }

            Scanner faz = new Scanner(System.in); // Scanner für Eingabe erstellen
            System.out.println("Bitte geben sie den frühesten Anfangszeitpunkt des Arbeitspakets ein: "); // Konsolenausgabe mit Eingabeaufforderung an den Nutzer
            if (faz.hasNextInt()) {
                this.faz = faz.nextInt(); // Wert der privaten Variable setzen
            } else {
                System.out.println("Eingabe ist ungültig! Bitte geben Sie den frühesten Anfangszeitpunkt (faz) in ganzen Stunden an!");
            }

            Scanner dauer = new Scanner(System.in); // Scanner für Eingabe erstellen
            System.out.println("Bitte geben Sie die Dauer des Arbeitspakets ein: "); // Konsolenausgabe mit Eingabeaufforderung an den Nutzer
            if (dauer.hasNextInt()) {
                this.dauer = dauer.nextInt(); // Wert der privaten Variable setzen
            } else {
                System.out.println("Eingabe ist ungültig. Bitte geben Sie die Dauer des Arbeitspakets in ganzen Stunden an!");
            }

            apNr.close(); // Schließen
            name.close(); // der jeweils
            faz.close(); // initialisierten
            dauer.close(); // Scannern
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


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
