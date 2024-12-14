import java.util.ArrayList;
import java.util.List;

public class Netzplan {

    private static final UserInput userInput = new UserInput();
//    private static final Menus menus = new Menus();

    private static List<Arbeitspaket> unsortierteListe = new ArrayList<>();
    private static List<Arbeitspaket> sortierteListe = new ArrayList<>();


//    public void inUnsortierteListe(Arbeitspaket arbeitspaket) {
//        unsortierteListe.add(arbeitspaket);
//    }

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
    public static void neuesApAnlegen() {
        String name;
        int apNummer;
        int FAZ;
        int dauer;

        name = userInput.userApNameIn();
        apNummer = userInput.userApNummerIn();
        FAZ = userInput.userFazIn();
        dauer = userInput.userDauerIn();
        Arbeitspaket arbeitspaket = new Arbeitspaket(name, apNummer, FAZ, dauer);
        unsortierteListe.add(arbeitspaket);
    }
}
