package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_02.aufgabe_04.snake;

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
     * Konstruktor der Klasse PROGRAMM Ruft die main-Methode auf.
     */
    PROGRAMM()
    {
        String a[];
        a = new String[0];
        main(a);
    }

    /**
     * main-Methode Erzeugt ein Spiel und einen Taktgeber. Der Taktgeber wird
     * gestartet.
     */
    static void main(String args[])
    {
        s = new SPIEL();
        t = new TAKTGEBER(s);
        t.Starten();
    }
}
