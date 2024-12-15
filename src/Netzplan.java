import java.util.List;

public class Netzplan {
    // jeweilige Listen Objekte werden initialisiert.
    private List<Arbeitspaket> unsortierteListe;
    private List<Arbeitspaket> sortiertListe;

    // Methode um sortierte Liste auf der Konsole auszugeben.
    public void printList(List<Arbeitspaket> sortiertListe) {
        System.out.println(sortiertListe);

    }

    public List<Arbeitspaket> getUnsortierteListe() {
        return unsortierteListe;
    }

    public void setUnsortierteListe(List<Arbeitspaket> unsortierteListe) {
        this.unsortierteListe = unsortierteListe;
    }

    public List<Arbeitspaket> getSortiertListe() {
        return sortiertListe;
    }

    public void setSortiertListe(List<Arbeitspaket> sortiertListe) {
        this.sortiertListe = sortiertListe;
    }
    // Methode um erstelltes Arbeitspaket Objekt in die unsortiertListe zu packen.
    public void putArbeitspaketToUnsortierteListe(Arbeitspaket arbeitspaket) {
        this.unsortierteListe.add(arbeitspaket);
    }
}
