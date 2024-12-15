import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NetzplanTest {
    private Netzplan testee = new Netzplan();

    @Test
    public void thatSortWorks() {
        List<ApVorlaeufer> inputs = new ArrayList<>();
        ApVorlaeufer ap1 = new ApVorlaeufer("Wurst", 1, 4, List.of(0));
        ApVorlaeufer ap2 = new ApVorlaeufer("Hans", 0, 4, Collections.emptyList());

        inputs.add(ap1);
        inputs.add(ap2);

        List<ApVorlaeufer> result = testee.sortieren(inputs);

        assertEquals(result.get(0), ap2);
        assertEquals(result.get(1), ap1);
    }

    @Test
    public void thatSortWorksComplex() {
        List<ApVorlaeufer> inputs = new ArrayList<>();
        ApVorlaeufer ap1 = new ApVorlaeufer("Wurst", 1, 4, List.of(0));
        ApVorlaeufer ap2 = new ApVorlaeufer("Hans", 2, 4, List.of(1));
        ApVorlaeufer ap0 = new ApVorlaeufer("Hans", 0, 4, Collections.emptyList());

        ApVorlaeufer ap3 = new ApVorlaeufer("Hans", 3, 4, List.of(1, 2));
        ApVorlaeufer ap4 = new ApVorlaeufer("Hans", 4, 4, Collections.emptyList());
        ApVorlaeufer ap5 = new ApVorlaeufer("Hans", 5, 4, List.of(3, 4));

        inputs.add(ap1);
        inputs.add(ap2);
        inputs.add(ap0);
        inputs.add(ap3);
        inputs.add(ap4);
        inputs.add(ap5);

        List<ApVorlaeufer> result = testee.sortieren(inputs);

        assertEquals(result.get(0), ap0);
        assertEquals(result.get(1), ap4);
        assertEquals(result.get(2), ap1);
        assertEquals(result.get(3), ap2);
        assertEquals(result.get(4), ap3);
        assertEquals(result.get(5), ap5);
    }

    @Test
    public void thatErstelleApsUndErsteBerechnungenWorks() {
        List<ApVorlaeufer> sortierteListe = new ArrayList<>();
        ApVorlaeufer ap0 = new ApVorlaeufer("Obi", 0, 1, Collections.emptyList());
        ApVorlaeufer ap1 = new ApVorlaeufer("Obi Wan", 1, 1, List.of(0));
        ApVorlaeufer ap2 = new ApVorlaeufer("Obi Wan Kenobi", 2, 1, List.of(1));
        ApVorlaeufer ap3 = new ApVorlaeufer("Obi Wan Kenobi, Meister", 3, 1, List.of(1, 2));
        ApVorlaeufer ap4 = new ApVorlaeufer("Jedi", 4, 1, Collections.emptyList());
        ApVorlaeufer ap5 = new ApVorlaeufer("Obi Wan Kenobi, Meister Jedi Ritter", 5, 4, List.of(3, 4));

        sortierteListe.add(ap0);
        sortierteListe.add(ap1);
        sortierteListe.add(ap2);
        sortierteListe.add(ap3);
        sortierteListe.add(ap4);
        sortierteListe.add(ap5);

        List<Arbeitspaket> ergebnise = testee.erstelleApsUndErsteBerechnungen(sortierteListe);
        assertEquals(8, ergebnise.get(ergebnise.size() -1 ).getFEZ());
    }

    @Test
    public void thatGetFazFromVorgaengerWorks() {
        Arbeitspaket packet1 = new Arbeitspaket("Obi", 0, 0, 4, Collections.emptyList());
        Arbeitspaket packet2 = new Arbeitspaket("Obi", 1, 0, 6, Collections.emptyList());

        List<Arbeitspaket> list = List.of(packet1, packet2);

        int berechneteFaz = testee.getFazFromVorgaenger(list, List.of(0, 1));

        assertEquals(6, berechneteFaz);
    }
}
