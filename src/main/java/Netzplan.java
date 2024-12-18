import java.util.ArrayList;
import java.util.List;

public class Netzplan {
    final UserInput userInput = new UserInput();
    final Output output = new Output();
    private final Menus menus  = new Menus();

    private boolean running = true;

    // Getter und Setter für den <running> boolean.
    public boolean isRunning() {
        return running;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }

    private static List<AlleNetzplaene> alleNetzplaene = new ArrayList<>();

    private static List<ApVorlaeufer> dieCooleNeueUnsortierteListe = new ArrayList<>();
    private static List<Arbeitspaket> unsortierteListe = new ArrayList<>();
    private static List<Arbeitspaket> sortierteListe = new ArrayList<>();

    public static List<ApVorlaeufer> getDieCooleNeueUnsortierteListe() {
        return dieCooleNeueUnsortierteListe;
    }

    public static void setDieCooleNeueUnsortierteListe(List<ApVorlaeufer> dieCooleNeueUnsortierteListe) {
        Netzplan.dieCooleNeueUnsortierteListe = dieCooleNeueUnsortierteListe;
    }

    // -start- Methode
    public void start() {

        while (running) {
        switch (menus.startMenuAuswahl()) {
                case 1:
                    arbeitsPaketeOptionen();
                    //neuesApAnlegen();
                    break;
                case 2:
                    apListeAnzeigen();
                    break;
            case 3:

                break;
            case 4:
                berechnen(dieCooleNeueUnsortierteListe);
                break;
            case 5:
                default:
                    throw new RuntimeException("WURDE NOCH NICHT PROGRAMMIERT");
            }
        }
    }

    public void arbeitsPaketeOptionen() {
        switch (menus.arbeitspaketMenuAuswahl()) {
            case 1:
                neuesApAnlegen();
                break;
            case 2:
                System.out.println("WURDE NOCH NICHT PROGRAMMIERT");
                break;
            case 3:
                System.out.println("WURDE NOCH NICHT PROGRAMMIERT");
                break;
            case 4:
                System.out.println("WURDE NOCH NICHT PROGRAMMIERT");
                break;
            case 5:
                System.out.println("WURDE NOCH NICHT PROGRAMMIERT");
                break;
            case 6:
                System.out.println("WURDE NOCH NICHT PROGRAMMIERT");
                break;
        }
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

    public void apListeAnzeigen() {
        for (Arbeitspaket l : getSortierteListe()) {
            System.out.println(l);
        }
    }

    public List<Arbeitspaket> berechnen(List<ApVorlaeufer> vorlaeufers) {
        // Sortieren
        List<ApVorlaeufer> sortiert = sortieren(vorlaeufers);

        // Rechnen
        List<Arbeitspaket> apsErsteWerteBerechnet = erstelleApsUndErsteBerechnungen(sortiert);
        //TODO Berechnung der spätesten Zeitpunkte noch implementieren
        return apsErsteWerteBerechnet;
    }

    // Methode überprüft ob AP vorgänger hat.
    public List<Arbeitspaket> erstelleApsUndErsteBerechnungen(List<ApVorlaeufer> apVorlaeufers) {
        List<Arbeitspaket> result = new ArrayList<>();
        for (ApVorlaeufer vorlaeufer : apVorlaeufers) {
            int FAZ = 0;
            // -If- greift wenn AP Vorgänger nicht Null ist.
            if (!vorlaeufer.getVorgaenger().isEmpty()) {
                // Wenn AP Vorgänger nicht Null ist dann bekommmt AP den FAZ vom FEZ des Vorgängers
                FAZ = getFazFromVorgaenger(result, vorlaeufer.getVorgaenger());
            }
            // Wenn AP Vorgänger = 0 dann wird Arbeitspaket angelegt mit FAZ null.
            // und
            Arbeitspaket arbeitspaket = new Arbeitspaket(vorlaeufer.getName(),
                    vorlaeufer.getApNummer(),
                    FAZ,
                    vorlaeufer.getDauer());

            result.add(arbeitspaket);
        }

        //output.listeAusgeben();
        return result;
    }

    // Methode die dem AP hilft sein FAZ aus dem FEZ seines Vorgängers zu bekommen.
    public int getFazFromVorgaenger(List<Arbeitspaket> all, List<Integer> vorgaenger) {
        int hoechsterFaz = 0;
        for (Integer current : vorgaenger) {
            Arbeitspaket gefunden = findeApMitApNummer(all, current);
            if (gefunden.getFEZ() > hoechsterFaz) {
                hoechsterFaz = gefunden.getFEZ();
            }
        }
        return hoechsterFaz;
    }

    // Methode zum Ausgeben der <sortiertenListe> auf der Konsole.
    public void listeAusgeben() {

        for (Arbeitspaket l : getSortierteListe()) {
            System.out.println(l);
        }
    }

    // Methode zum Finden der gesuchten AP's
    private Arbeitspaket findeApMitApNummer(List<Arbeitspaket> all, int idToFind) {
        Arbeitspaket result = null;

        for (Arbeitspaket ap : all) {
            if (ap.getApNummer() == idToFind) {
                result = ap;
                break;
            }
        }

        return result;
    }

    // Methode zum Anlegen eines neuen Arbeitpaketes.
    public void neuesApAnlegen() {
        ApVorlaeufer eingegebeneDaten = arbeitspaketErstellen();
        dieCooleNeueUnsortierteListe.add(eingegebeneDaten);
    }

    // Methode zum Sortieren nach AP Vorgängern.
    // Sortierung beginnt erst nach dem all AP's erstellt wurden.
    public List<ApVorlaeufer> sortieren(List<ApVorlaeufer> zuBearbeiten) {
        // <sortierteListe> ist das Ergebnis der sortierung.
        // Sie enthält AP's so, dass jeder AP erst nach seinen Vorgängern in der Liste stehen kann.
        List<ApVorlaeufer> sortierteListe = new ArrayList<>();
        // <bereitsBekannteApNummern> Liste zur zwischenspeicherung der bekannten.
        // hilft beim Überprüfen ob die Vorgänger eines neuen AP's schon in der <sortiertenListe> sind
        List<Integer> bereitsBekannteApNummern = new ArrayList<>();
        // <naechsteRunde> Speichert die AP's zwischen deren Vorgänger noch nicht in der <sortiertenListe> sind.
        List<ApVorlaeufer> naechsteRunde = new ArrayList<>();
        // <dieseRunde> Enthält die AP's die im aktuellen sortierdurchgang sortiert werden müssen.
        // Beim ersten Mal werden alle bekannten AP's aus <zuBearbeiten> in diese Liste kopiert.
        List<ApVorlaeufer> dieseRunde = new ArrayList<>(zuBearbeiten);
        // While schaut ob Liste abgearbeitet ist.
        while (sortierteListe.size() != zuBearbeiten.size()) {
            for (ApVorlaeufer current : dieseRunde) {
                boolean keineVorgaenger = current.getVorgaenger().isEmpty();
                boolean vorgaengerBereitsBekannt = bereitsBekannteApNummern.containsAll(
                        current.getVorgaenger());

                if (keineVorgaenger || vorgaengerBereitsBekannt) {
                    sortierteListe.add(current);
                    bereitsBekannteApNummern.add(current.getApNummer());
                } else {
                    naechsteRunde.add(current);
                }
            }
            // <nächsteRunde> enthält nur noch die AP's die noch nicht einsortiert werden konnten.
            dieseRunde = new ArrayList<>(naechsteRunde);
        }

        return sortierteListe;
    }

    // Methode zur Erstellung eines Netzplanes
    /*public static String netzplanErstellung() {
        Netzplan netzplan = new Netzplan();
        return netzplan;
    } */

    // Getter und Setter für die <unsortierteListe>
    public List<Arbeitspaket> getUnsortierteListe() {
        return unsortierteListe;
    }
    public void setUnsortierteListe(List<Arbeitspaket> unsortierteListe) {
        this.unsortierteListe = unsortierteListe;
    }

    // Getter und Setter ür die <sortierteListe>.
    public List<Arbeitspaket> getSortierteListe() {
        return sortierteListe;
    }
    public void setSortierteListe(List<Arbeitspaket> sortierteListe) {
        this.sortierteListe = sortierteListe;
    }









}

//Moin Meister, ein Fuchs war hier