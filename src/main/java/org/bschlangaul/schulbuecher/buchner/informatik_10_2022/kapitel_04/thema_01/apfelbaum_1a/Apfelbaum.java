package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_04.thema_01.apfelbaum_1a;

/**
 * Klasse Apfelbaum, Lösung für Kapitel 4.1 Aufgabe 1
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-10-12
 */
class Apfelbaum
{
    String ort;

    double hoehe;

    /**
     * Konstruktor für Objekte der Klasse Apfelbaum
     */
    Apfelbaum(String einOrt, double eineHoehe)
    {
        // Instanzvariable initialisieren
        ort = einOrt;
        hoehe = eineHoehe;
    }

    /**
     * Methode wachse, der Wert des Parameters einBetrag wird zum Wert des
     * Attributes hoehe addiert.
     */
    void wachse(double einBetrag)
    {
        hoehe = hoehe + einBetrag;
    }
}
