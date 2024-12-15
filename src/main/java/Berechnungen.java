public class Berechnungen {


    // Methode zur Berechnung des FEZ.
    public int fezBerechnung(int FAZ, int dauer) {
        return FAZ + dauer;
    }

    // Methode zur Berechnung des Gesamtpuffers.
    public int gesamtPuffer(int SAZ, int FAZ) {
        return SAZ- FAZ;
    }

    // Methode zur Berechnung des SAZ.
    public int sazRueckrechnung(int SEZ, int dauer) {
        return SEZ - dauer;
    }
}
