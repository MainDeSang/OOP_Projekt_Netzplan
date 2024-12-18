import java.util.ArrayList;
import java.util.List;

public class AlleNetzplaene {


    private static List<AlleNetzplaene> alleNetzplaene = new ArrayList<>();




    // Getter und Setter für alleNetzplaene.
    public static List<AlleNetzplaene> getAlleNetzplaene() {
        return alleNetzplaene;
    }
    public static void setAlleNetzplaene(List<AlleNetzplaene> alleNetzplaene) {
        AlleNetzplaene.alleNetzplaene = alleNetzplaene;
    }
}
