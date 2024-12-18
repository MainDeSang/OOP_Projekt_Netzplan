import java.util.ArrayList;
import java.util.List;



public class Menus {
    //public static final int NEUES_PACKET = 1;
    //public static final int BERECHNEN = 5;
    //public static final int ANZEIGEN = 2;
    UserInput userInput = new UserInput();


    public int startMenuAuswahl() {
        System.out.println(" 1 - ( noch gleich AP erstellung )Einen neuen Netzplan erstellen. ");
        System.out.println(" 2 - Einen vorhanden Netzplan anzeigen. ");
        System.out.println(" 3 - Ein vorhanden Netzplan bearbeiten. ");
        System.out.println(" 4 - Ein vorhanden Netzplan entfernen. ");
        System.out.println(" 5 - Beenden");

        /*switch (userInput.menuAuswahl()) {
            case 1:
                //netzPlan.start();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                System.out.println("Auf Wiedersehen. Wixxa");
                //netzPlan.setRunning(false);
                break;
            default:  userInput.readInt("Bitte wählen Sie die Nummer des Menupunktes.");

        } */
        return userInput.menuAuswahl();
    }

    public int netzplanBearbeitenMenu() {
        System.out.println(" 1 - Den Namen des Netzplans ändern. ");
        System.out.println(" 2 - Die Arbeitspakete des Netzplans bearbeiten. ");
        System.out.println(" 3 - zurück zum Haupt menu");

        /* int auswahl = 0;
        switch (auswahl) {
            case 1:
                System.out.println("WURDE NOCH NICHT PROGRAMMIERT");
                break;
            case 2:
                arbeitspaketMenuAuswahl();
                break;
            case 3:
                startMenuAuswahl();
                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            default: userInput.menuAuswahl();
        } */
        return userInput.menuAuswahl();
    }

    public int arbeitspaketMenuAuswahl() {
        System.out.println(" 1 - Eine neues Arbeitspaket erstellen. ");
        System.out.println(" 2 - Ein vorhandes Arbeitspaket bearbeiten. ");
        System.out.println(" 3 - Ein vorhandes Arbeitspaket anzeigen. ");
        System.out.println(" 4 - Ein vorhandes Arbeitpaket entfernen. ");
        System.out.println(" 5 - Netzplan berechnen");
        System.out.println(" 6 - Zurück zum Hauptmenu");

        /* int auswahl = 0;
        switch (auswahl) {
            case 1:

                break;
            case 2:
                System.out.println("WURDE NOCHT NICHT PROGRAMMIERT");
                break;
            case 3:
                System.out.println("WURDE NOCHT NICHT PROGRAMMIERT");
                break;
            case 4:
                System.out.println("WURDE NOCHT NICHT PROGRAMMIERT");
                break;
            case 5:
                //netzPlan1.berechnen(Netzplan.getDieCooleNeueUnsortierteListe());
                System.out.println("WURDE NOCHT NICHT PROGRAMMIERT");
                break;
            case 6:
                startMenuAuswahl();
                break;
            default: userInput.menuAuswahl();
        } */
        return userInput.menuAuswahl();
    }


    // Methode erstellt AP mit Daten der Usereingabe und
    // Methode in die Klasse Netzplan verschoben.
    /* public ApVorlaeufer arbeitspaketErstellen() {
        String name = userInput.userApNameIn();
        int apNummer = userInput.userApNummerIn();
        int dauer = userInput.userDauerIn();
        int vorgaenger = userInput.userVorgaengerIn();
        List<Integer> vorgaengers = new ArrayList<>();
        vorgaengers.add(vorgaenger);

        return new ApVorlaeufer(name,apNummer, dauer, vorgaengers);
    } */
}
