package org.bschlangaul.schulbuecher.cornelsen.informatik_5_2023.kapitel_04.thema_03.alternative_01.aufgabe_07.knn_implementieren;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse KNextNeighbourTest.
 *
 * @author (Peter Brichzin)
 *
 * @version (21.5.23)
 */
public class KNaechsterNachbarTest
{
    private KNaechsterNachbar kNN1;

    private Datenpunkt zuLabelnderDatenpunkt;

    /**
     * Konstruktor fuer die Test-Klasse KNextNeighbourTest
     */
    public KNaechsterNachbarTest()
    {
    }

    /**
     * Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
        kNN1 = new KNaechsterNachbar();
        zuLabelnderDatenpunkt = new Datenpunkt(400, 300);
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void LabelnEinesDatenpunkts()
    {
        kNN1.neuenDatenpunktLabeln(zuLabelnderDatenpunkt, 8);
    }
}
