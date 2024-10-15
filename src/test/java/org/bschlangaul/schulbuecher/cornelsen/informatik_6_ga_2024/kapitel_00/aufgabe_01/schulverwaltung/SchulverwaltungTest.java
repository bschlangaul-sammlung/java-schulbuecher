package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_00.aufgabe_01.schulverwaltung;

import org.junit.jupiter.api.BeforeEach;

public class SchulverwaltungTest
{
    private Klassenraum klassenr1;

    private Klassenraum klassenr2;

    private Fachraum fachraum1;

    private Fachraum fachraum2;

    private Schulverwaltung schulver1;

    /**
     * Setzt das Testgerüst fuer den Test.
     * <p>
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
        klassenr1 = new Klassenraum("A104", 30, "11b");
        klassenr2 = new Klassenraum("A105", 34, "11c");
        fachraum1 = new Fachraum("B007", 2, "Schulleitung");
        fachraum2 = new Fachraum("B008", 3, "Sekretariat");
        schulver1 = new Schulverwaltung();
        schulver1.RaumHinzufügen(klassenr1);
        schulver1.RaumHinzufügen(klassenr2);
        schulver1.RaumHinzufügen(fachraum1);
        schulver1.RaumHinzufügen(fachraum2);
    }
}
