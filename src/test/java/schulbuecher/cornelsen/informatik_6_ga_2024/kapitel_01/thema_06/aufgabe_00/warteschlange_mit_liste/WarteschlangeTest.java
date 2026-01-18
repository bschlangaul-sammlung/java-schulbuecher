package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_06.aufgabe_00.warteschlange_mit_liste;

import org.junit.jupiter.api.Test;

public class WarteschlangeTest
{

    private Warteschlange wartesch1;

    private Patient patient1;

    private Patient patient2;

    private Patient patient3;

    private Darstellung darstell1;

    private Patient patient4;

    private Patient patient5;

    private Patient patient6;

    private Patient patient7;

    private Patient patient8;

    @Test
    public void test()
    {
        wartesch1 = new Warteschlange();
        patient1 = new Patient("Hugo");
        patient2 = new Patient("Emil");
        patient3 = new Patient("Kasimir");
        wartesch1.Einfügen(patient1);
        wartesch1.Einfügen(patient2);
        wartesch1.Einfügen(patient3);
        darstell1 = new Darstellung(wartesch1);
        darstell1.Anzeigen();
        patient4 = new Patient("Nummer4");
        patient5 = new Patient("Nummer5");
        patient6 = new Patient("Nummer6");
        patient7 = new Patient("Nummer7");
        patient8 = new Patient("Nummer8");
        wartesch1.Einfügen(patient4);
        wartesch1.Einfügen(patient5);
        wartesch1.Einfügen(patient6);
        wartesch1.Einfügen(patient7);
        wartesch1.Einfügen(patient8);
    }

}
