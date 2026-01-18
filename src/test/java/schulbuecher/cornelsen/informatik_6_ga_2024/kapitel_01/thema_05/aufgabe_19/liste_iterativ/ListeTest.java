package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_19.liste_iterativ;

import org.junit.jupiter.api.Test;

public class ListeTest
{
    private Liste liste1;

    private Darstellung darstell1;

    private Patient patient1;

    private Patient patient2;

    private Patient patient3;

    private Patient patient4;

    /**
     * Setzt das Testgerüst fuer den Test.
     * <p>
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Test

    public void test()
    {
        liste1 = new Liste();
        darstell1 = new Darstellung(liste1);
        patient1 = new Patient("Mayer");
        liste1.VorneEinfügen(patient1);
        darstell1.Anzeigen();
        patient2 = new Patient("Ludwig");
        liste1.VorneEinfügen(patient2);
        darstell1.Anzeigen();
        liste1.Suchen("Mayer");
        liste1.InformationAusgeben();
        liste1.Suchen("Mayer");
        liste1.AnfangGeben();
        liste1.AnfangEntfernen();
        darstell1.Anzeigen();
        liste1.EinfügenVor(patient2, patient1);
        darstell1.Anzeigen();
        patient3 = new Patient("Norbert");
        liste1.EinfügenVor(patient3, null);
        darstell1.Anzeigen();
        liste1.EndeEntfernen();
        darstell1.Anzeigen();
        darstell1.Anzeigen();
        darstell1.Anzeigen();
        liste1.HintenEinfügen(patient3);
        darstell1.Anzeigen();
        patient4 = new Patient("Anton");
        liste1.HintenEinfügen(patient4);
        darstell1.Anzeigen();
    }

}
