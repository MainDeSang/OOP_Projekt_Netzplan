import java.util.List;

public class Netzplan {

    private List<Arbeitspaket> arbeitspaketListe;

    public List<Arbeitspaket> getArbeitspaketListe() {
        return arbeitspaketListe;
    }

    public void setArbeitspaketListe(List<Arbeitspaket> arbeitspaketListe) {
        this.arbeitspaketListe = arbeitspaketListe;
    }

    public void add(Arbeitspaket arbeitspaket) {
        arbeitspaketListe.add(arbeitspaket);
    }

    public void remove(Arbeitspaket arbeitspaket) {
        arbeitspaketListe.remove(arbeitspaket);
    }

    public void printList(List<Arbeitspaket> arbeitspaketListe) {
        System.out.println(arbeitspaketListe);

    }
}
