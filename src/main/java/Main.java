import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

//TODO Erst AP's sammeln in Liste bis alle AP vorhanden sind -> Liste nach vorgänger AP sortieren. Dann berechnen in neue Liste.

    public static void main(String[] args) {



        System.out.println("Willkommen, was möchten sie machen ?");

        Arbeitspaket ap1 = new Arbeitspaket("Wurst", 1, 0, 4);
        List<Arbeitspaket> apListe = new ArrayList<>();
        apListe.add(ap1);


        int vorgaenger1 = 0;
        Arbeitspaket start = findFirstApById(apListe, vorgaenger1);
        Arbeitspaket ap2 = new Arbeitspaket("Wurst", 2, start.getFEZ(), 2);
        ap2.addVorgaenger(vorgaenger1);
        apListe.add(ap2);

        Arbeitspaket ap3 = new Arbeitspaket("Wurst", 3, ap2.getFEZ(), 6);
        ap3.addVorgaenger(1);
        apListe.add(ap3);

        System.out.println(ap1);
        System.out.println(ap2);
        System.out.println(ap3);

        Netzplan netzplan = new Netzplan();
        Menus menu = new Menus(netzplan);
        menu.startMenuAuswahl();
    }

    private static Arbeitspaket findFirstApById(List<Arbeitspaket> all, int idToFind) {
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