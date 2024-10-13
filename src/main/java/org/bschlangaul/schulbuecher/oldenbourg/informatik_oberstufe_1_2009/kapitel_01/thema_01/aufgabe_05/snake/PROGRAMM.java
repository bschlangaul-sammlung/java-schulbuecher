package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_05.snake;

/**
 * Klasse zur Programmverwaltung
 *
 * @author Klaus van Dijkstan
 *
 * @version 1.0
 */
class PROGRAMM
{
    /**
     * Referenz auf ein verwaltetes Spiel-Objekt
     */
    private static SPIEL s;

    /**
     * Referenz auf einen verwalteten Taktgeber
     */
    private static TAKTGEBER t;

    /**
     * Konstruktor der Klasse PROGRAMM Erzeugt ein neues Spiel und startet es.
     */
    PROGRAMM()
    {
        s = new SPIEL();
        t = new TAKTGEBER(s);
        t.Starten();
    }

    /**
     * main-Methode Startet das Programm
     */
    public static void main(String args[])
    {
        new PROGRAMM();
    }
}
