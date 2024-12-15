import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Menus {
    public static final int NEUES_PACKET = 1;
    public static final int BERECHNEN = 5;

    UserInput userInput = new UserInput();

    public void startMenuAuswahl() {
        System.out.println(" 1 - Einen neuen Netzplan erstellen. ");
        System.out.println(" 2 - Ein vorhanden Netzplan bearbeiten. ");
        System.out.println(" 3 - Ein vorhanden Netzplan entfernen. ");
        int auswahl = 0;
        switch (auswahl) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            default:
        }
    }

    public int arbeitspaketMenuAuswahl() {
        System.out.println(" " + Menus.NEUES_PACKET + " - Eine neues Arbeitspaket erstellen. ");
        System.out.println(" 2 - Ein vorhandes Arbeitspaket bearbeiten. ");
        System.out.println(" 3 - Ein vorhandes Arbeitspaket anzeigen. ");
        System.out.println(" 4 - Ein vorhandes Arbeitpaket entfernen. ");
        System.out.println(" " + Menus.BERECHNEN + " - Netzplan berechnen");

        return userInput.readInt("Bitte Nummer eingeben");
    }

    public ApVorlaeufer arbeitspaketErstellen() {
        String name = userInput.userApNameIn();
        int apNummer = userInput.userApNummerIn();
        int dauer = userInput.userDauerIn();
        int vorgaenger = userInput.userVorgaengerIn();
        List<Integer> vorgaengers = new ArrayList<>();
        vorgaengers.add(vorgaenger);

        return new ApVorlaeufer(name,apNummer, dauer, vorgaengers);
    }
}
