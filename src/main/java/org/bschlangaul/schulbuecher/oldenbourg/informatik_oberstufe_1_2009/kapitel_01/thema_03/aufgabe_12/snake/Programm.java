package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_12.snake;

/**
 * Klasse zur Programmverwaltung
 *
 * @author Klaus van Dijkstan
 *
 * @version 1.0
 */
class Programm
{
    /**
     * Referenz auf ein verwaltetes Spiel-Objekt
     */
    private static Spiel s;

    /**
     * Referenz auf einen verwalteten Taktgeber
     */
    private static TaktGeber t;

    /**
     * Konstruktor der Klasse PROGRAMM Ruft die main-Methode auf.
     */
    Programm()
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
        s = new Spiel();
        t = new TaktGeber(s);
        t.Starten();
    }
}
