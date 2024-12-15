import java.util.ArrayList;
import java.util.List;

public class Netzplan {

    private final Menus menus  = new Menus();

    private boolean running = true;

    private static List<ApVorlaeufer> dieCooleNeueUnsortierteListe = new ArrayList<>();
    private static List<Arbeitspaket> unsortierteListe = new ArrayList<>();
    private static List<Arbeitspaket> sortierteListe = new ArrayList<>();

    public void start() {

        while (running) {
            switch (menus.arbeitspaketMenuAuswahl()) {
                case Menus.NEUES_PACKET:
                    neuesApAnlegen();
                    break;
                case Menus.BERECHNEN:
                    berechnen(dieCooleNeueUnsortierteListe);
                    break;
                default:
                    throw new RuntimeException("WURDE NOCHT NICHT PROGRAMMIERT");
            }
        }
    }

    private List<Arbeitspaket> berechnen(List<ApVorlaeufer> vorlaeufers) {
        // Sortieren
        List<ApVorlaeufer> sortiert = sortieren(vorlaeufers);

        // Rechnen
        List<Arbeitspaket> apsErsteWerteBerechnet = erstelleApsUndErsteBerechnungen(sortiert);
        //TODO Berechnung der spätesten Zeitpunkte noch implementieren
        return apsErsteWerteBerechnet;
    }

    public List<Arbeitspaket> erstelleApsUndErsteBerechnungen(List<ApVorlaeufer> apVorlaeufers) {
        List<Arbeitspaket> result = new ArrayList<>();
        for (ApVorlaeufer vorlaeufer : apVorlaeufers) {
            int FAZ = 0;
            if (!vorlaeufer.getVorgaenger().isEmpty()) {
                FAZ = getFazFromVorgaenger(result, vorlaeufer.getVorgaenger());
            }

            Arbeitspaket arbeitspaket = new Arbeitspaket(vorlaeufer.getName(),
                    vorlaeufer.getApNummer(),
                    FAZ,
                    vorlaeufer.getDauer());

            result.add(arbeitspaket);
        }

        return result;
    }

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

    //
    public List<Arbeitspaket> getUnsortierteListe() {
        return unsortierteListe;
    }
    public void setUnsortierteListe(List<Arbeitspaket> unsortierteListe) {
        this.unsortierteListe = unsortierteListe;
    }

    //
    public List<Arbeitspaket> getSortierteListe() {
        return sortierteListe;
    }
    public void setSortierteListe(List<Arbeitspaket> sortierteListe) {
        this.sortierteListe = sortierteListe;
    }

    //
    public void neuesApAnlegen() {
        ApVorlaeufer eingegebeneDaten = menus.arbeitspaketErstellen();
        dieCooleNeueUnsortierteListe.add(eingegebeneDaten);
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
}

//Moin Meister, ein Fuchs war hier