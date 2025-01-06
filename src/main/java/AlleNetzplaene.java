import java.util.ArrayList;
import java.util.List;

public class AlleNetzplaene {

    private static UserInput userInput = new UserInput();
    private static Menus menus = new Menus();
    private static List<AlleNetzplaene> alleNetzplaene = new ArrayList<>();
    private String netzplanName = " ";



    public void netzplanMenu() {
        switch (menus.netzplanBearbeitenMenu()) {
            case 1:
                netzplanName = userInput.readString("Bitte geben Sie den Namen des Netzplanes an.");

                //neuesApAnlegen();
                break;
            case 2:
                for (AlleNetzplaene l : alleNetzplaene) {
                    System.out.println(l);
                }
                break;
            case 3:
                String antwort = " ";
                userInput.jaNeinAbfrage("Möchten Sie zurück zum Haupt menu ?");
                if (antwort.equals("Y") || antwort.equals("y")) {
                    menus.startMenuAuswahl();
                } else {
                    netzplanMenu();
                }

                break;
            /* case 4:

                break;
            case 5: */
            default:
                throw new RuntimeException("WURDE NOCH NICHT PROGRAMMIERT");
        }
    }


    // Getter und Setter für alleNetzplaene.
    public static List<AlleNetzplaene> getAlleNetzplaene() {
        return alleNetzplaene;
    }
    public static void setAlleNetzplaene(List<AlleNetzplaene> alleNetzplaene) {
        AlleNetzplaene.alleNetzplaene = alleNetzplaene;
    }

    // GetterSetter für den Netzplan Name.
    public String getNetzplanName() {
        return netzplanName;
    }
    public void setNetzplanName(String netzplanName) {
        this.netzplanName = netzplanName;
    }
}
