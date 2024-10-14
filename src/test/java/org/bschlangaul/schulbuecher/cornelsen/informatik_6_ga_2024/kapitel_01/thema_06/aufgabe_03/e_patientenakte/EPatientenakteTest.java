package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_06.aufgabe_03.e_patientenakte;

import org.junit.jupiter.api.Test;

public class EPatientenakteTest
{
    private Patient patient1;

    private Patient patient2;

    private Liste patientenliste;

    @Test
    public void test()
    {
        patient1 = new Patient("Ben Deriss");
        patient2 = new Patient("Armin Gips");
        patient1.AktennotizHinzufügen("Beinbruch");
        patient1.AktennotizHinzufügen("Schnupfen");
        patient2.AktennotizHinzufügen("Husten");
        patient2.AktennotizHinzufügen("Bänderriss");
        patientenliste = new Liste();
        patientenliste.HintenEinfügen(patient1);
        patientenliste.HintenEinfügen(patient2);
        patientenliste.InformationAusgeben();
    }

}
