public class Arbeitspaket {

    private static final Berechnungen calc = new Berechnungen();

    private String apName;
    private int apNummer;
    private int FAZ;
    private int dauer;
    private int FEZ;
    private int SAZ;
    private int SEZ;
    private int FP;
    private int GP;

    public Arbeitspaket(String apName, int apNummer, int FAZ, int dauer) {
        this.apName = apName;
        this.apNummer = apNummer;
        this.FAZ = FAZ;
        this.dauer= dauer;
        calc.fezBerechnung(this.FAZ, this.dauer);
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
        return FEZ;
    }
    public void setFEZ(int FEZ) {
        this.FEZ = FEZ;
    }

    // Getter und Setter für den -spätesten Anfangzeitpunkt- des Arbeitspaketes
    public int getSAZ() {
        return SAZ;
    }
    public void setSAZ(int SAZ) {
        this.SAZ = SAZ;
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
        return GP;
    }
    public void setGP(int GP) {
        this.GP = GP;
    }

    @Override
    public String toString() {
        return getApName() + getApNummer() + getFAZ() + getDauer();
    }
}
