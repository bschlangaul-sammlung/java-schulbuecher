package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_05.aufgabe_11.liste_komplett_mit_interface_und_visualisierung;

import org.junit.jupiter.api.Test;

public class ListeTest
{

    private Liste liste1;

    private Darstellung darstell1;

    private Patient patient1;

    private Patient patient2;

    private Patient patient3;

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
    }

}
