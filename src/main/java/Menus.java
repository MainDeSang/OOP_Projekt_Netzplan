import java.awt.*;

public class Menus {

    private final Netzplan netzplan;

    public Menus(Netzplan netzplan) {
        this.netzplan = netzplan;
    }

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

    public void arbeitspaketMenuAuswahl() {
        System.out.println(" 1 - Eine neues Arbeitspaket erstellen. ");
        System.out.println(" 2 - Ein vorhandes Arbeitspaket bearbeiten. ");
        System.out.println(" 3 - Ein vorhandes Arbeitspaket anzeigen. ");
        System.out.println(" 4 - Ein vorhandes Arbeitpaket entfernen. ");
        int auswahl = 0;
        switch (auswahl) {
            case 1:
                netzplan.neuesApAnlegen();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4 :

                break;
            default:
        }
    }
}
