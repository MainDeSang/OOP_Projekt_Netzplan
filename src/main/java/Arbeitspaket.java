import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Arbeitspaket {

    private String apName;
    private int apNummer;
    private int FAZ;
    private int dauer;
    private int SEZ;
    // THIS MIGHT BE USELESS
    private int FP;
    private List<Integer> vorgaenger = new ArrayList<>();

    // private int GP;
    public Arbeitspaket(String apName, int apNummer, int FAZ, int dauer) {
        this.apName = apName;
        this.apNummer = apNummer;
        this.FAZ = FAZ;
        this.dauer= dauer;
    }

    public Arbeitspaket(String apName, int apNummer, int FAZ, int dauer, List<Integer> vorgaenger) {
        this.apName = apName;
        this.apNummer = apNummer;
        this.FAZ = FAZ;
        this.dauer = dauer;
        this.vorgaenger = vorgaenger;
    }


    // Getter und Setter für den -Namen- des Arbeitspaketes
    public String getApName() {
        return apName;
    }
    public void setApName(String apName) {
        this.apName = apName;
    }

    // Getter und Setter für die -Nummer- des Arbeitspaketes
    public int getApNummer() {
        return apNummer;
    }
    public void setApNummer(int apNummer) {
        this.apNummer = apNummer;
    }

    // Getter und Setter für den -frühesten Anfangszeitpunkt- des Arbeitspaketes
    public int getFAZ() {
        return FAZ;
    }
    public void setFAZ(int FAZ) {
        this.FAZ = FAZ;
    }

    // Getter und Setter für die -Dauer- des Arbeitspaketes
    public int getDauer() {
        return dauer;
    }
    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    // Getter und Setter für den -frühesten Endzeitpunkt- des Arbeitspaketes
    public int getFEZ() {
        return FAZ + dauer;
    }

    // Getter und Setter für den -spätesten Anfangzeitpunkt- des Arbeitspaketes
    public int getSAZ() {
        return SEZ + dauer;
    }

    // Getter und Setter für den -spätesten Endzeitpunkt- des Arbeitspaketes
    public int getSEZ() {
        return SEZ;
    }
    public void setSEZ(int SEZ) {
        this.SEZ = SEZ;
    }

    // Getter und Setter für den -freien Puffer- des Arbeitspaketes
    public int getFP() {
        return FP;
    }
    public void setFP(int FP) {
        this.FP = FP;
    }

    // Getter und Setter für den -gesamten Puffer- des Arbeitspaketes
    public int getGP() {
        return getSAZ() - FAZ;
    }

    // Getter Vorgänger
    public List<Integer> getVorgaenger() {
        return vorgaenger;
    }
    // Einen neuen Vorgänger hinzufügen
    public void addVorgaenger(int newVorgaenger) {
        vorgaenger.add(newVorgaenger);
    }

    @Override
    public String toString() {
        return "Arbeitspaket{" +
                "apName='" + apName + '\'' +
                ", apNummer=" + apNummer +
                ", FAZ=" + FAZ +
                ", dauer=" + dauer +
                ", SEZ=" + SEZ +
                ", FP=" + FP +
                ", vorgaenger=" + vorgaenger.stream().map(Object::toString).collect(Collectors.joining(" ")) +
                '}';
    }


}
