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


    // Klassen eigener Konstruktor welcher die bereits bekannten Werte des Arbeitspaketes, die über Scanner dem Nutzer abgefragt werden, direkt in das zu instanziierende Objekt füllt.
    public Arbeitspaket() {

        // Try-Catch-Blöcke im Konstruktor um eventuell aufkommende fehler bei der Initialisierung der Objekte mit den zu übergebenden Variablen oder fehler bei der Eingabe des Nutzers aufzufangen.

        try (Scanner apNr = new Scanner(System.in)) { // Try-Catch-Block mit Scanner für Eingabe eines int Wertes für die private Variable apNr.
            System.out.print("Bitte geben Sie die Arbeitspaket Nummer ein: "); // Konsolenausgabe mit Eingabeaufforderung an den Nutzer.
            this.apNr = apNr.nextInt();// Wert der privaten Variable wird mit dem Wert, welcher über den Scanner erahlten wird belegt.
        } catch (Exception e) { // Ausnahme wird geworfen, wenn fehler im Try-Block entsteht.
            System.out.println("Eingabe ist ungültig! Bitte geben Sie eine Dezimalzahl ein!");
            this.apNr = 0; // Standardwert setzen.
        }


        try (Scanner name = new Scanner(System.in)) { // Try-Catch-Block mit Scanner für Eingabe eines int Wertes für die private Variable name.
            System.out.println("Bitte geben Sie den Namen des Arbeitspakets ein: "); // Konsolenausgabe mit Eingabeaufforderung an den Nutzer
            this.name = name.nextLine(); // private Variable name wird mit dem String Wert belegt, welcher vom Scanner vom Nutzer bezogen wird.
        } catch (Exception e) {
            System.out.println("Eingabe ist ungültig! Bitte geben Sie einen Namen in lateinischen Buchstaben ohne Sonderzeichen ein.");
            this.name = ""; // Standardwert setzen
        }


        try (Scanner faz = new Scanner(System.in)) { // Try-Catch-Block mit Scanner für Eingabe eines int Wertes für die private Variable faz (frühester anfangs Zeitpunkt).
            System.out.println("Bitte geben sie den frühesten Anfangszeitpunkt des Arbeitspakets ein: "); // Konsolenausgabe mit Eingabeaufforderung an den Nutzer
            this.faz = faz.nextInt(); // Belegen der privaten Variable mit Wert aus der Scanner Eingabe.
        } catch (Exception e) {
            System.out.println("Eingabe ist ungültig! Bitte geben Sie den frühesten Anfangszeitpunkt (faz) in ganzen Stunden an!");
            this.faz = 0;
        }

        try (Scanner dauer = new Scanner(System.in)) { // Try-Catch-Block mit Scanner für Eingabe eines int Wertes für die private Variable dauer.
            System.out.println("Bitte geben Sie die Dauer des Arbeitspakets ein: "); // Konsolenausgabe mit Eingabeaufforderung an den Nutzer
            this.dauer = dauer.nextInt(); // Belegen der privaten int Variable dauer, mit dem aus Scanner erhaltenen Wert.
        } catch (Exception e) {
            System.out.println("Eingabe ist ungültig. Bitte geben Sie die Dauer des Arbeitspakets in ganzen Stunden an!");
            this.dauer = 0; // Standartwert setzen
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

    //Set FeZ mit Formel zur berechnung der Variablen. Wird beim Aufrufen des Setters angewandt.
    public void setFez(int dauer) { this.fez = faz + dauer; }

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



    // Methode um den freien Puffer anhand der Parameter zu berechnen.
    public int calculateFP(int faz, int fez) {
        return this.fp = faz - fez; //Formel aus Briefing zur Berechnung von freien Puffer.
    }

    // Methode um den gesamten Puffer anhand der Parameter zu berechnen.
    public int calculateGP(int saz, int faz) {
        return this.gp = saz - faz;  //Formel aus Briefing zur Berechnung von gesamten Puffer.
    }
}

