import java.util.List;

public class ApVorlaeufer {
    String name;
    int apNummer;
    int dauer;
    List<Integer> vorgaenger;

    // Methode erstellt AP mit APvorgänger Liste
    public ApVorlaeufer(String name, int apNummer, int dauer, List<Integer> vorgaenger) {
        this.name = name;
        this.apNummer = apNummer;
        this.dauer = dauer;
        this.vorgaenger = vorgaenger;
    }



    public List<Integer> getVorgaenger() {
        return vorgaenger;
    }

    public int getDauer() {
        return dauer;
    }

    public int getApNummer() {
        return apNummer;
    }

    public String getName() {
        return name;
    }
}
