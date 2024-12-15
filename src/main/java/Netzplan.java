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
    public void neuesApAnlegen() {
        String name = userInput.userApNameIn();
        int apNummer = userInput.userApNummerIn();
        // int FAZ = userInput.userFazIn();
        int dauer = userInput.userDauerIn();
        int vorgaenger = userInput.userVorgaengerIn();

        Arbeitspaket apVorgaenger = findFirstApById(unsortierteListe, vorgaenger);

        int faz = 0;
        if(apVorgaenger != null) {
            faz = apVorgaenger.getFEZ();
        }

        Arbeitspaket ap2 = new Arbeitspaket(name, apNummer, faz, dauer);
        ap2.addVorgaenger(vorgaenger);

        unsortierteListe.add(ap2);
    }

    private Arbeitspaket findFirstApById(List<Arbeitspaket> all, int idToFind) {
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