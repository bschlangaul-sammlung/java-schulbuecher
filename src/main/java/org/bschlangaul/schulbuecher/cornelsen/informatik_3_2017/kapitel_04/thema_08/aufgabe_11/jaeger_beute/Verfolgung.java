package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_11.jaeger_beute;

/**
 * Steuert das Verfolgungsspiel.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Verfolgung extends Ereignisbehandlung
{

    /**
     * Legt die Objekte an.
     */
    Verfolgung()
    {
        new Beute(600, 400);
        new Jaeger(600, 400);
        TaktdauerSetzen(100);
    }

    /**
     * Die eigentliche Aktionsmethode des Zeitgebers. <br>
     * Muss bei Bedarf von einer Unterklasse überschrieben werden.
     */
    @Override
    void TaktImpulsAusführen()
    {
        // nichts
    }

    /**
     * Die eigentliche Aktionsmethode für einen Mausklick. <br>
     * Muss bei Bedarf von einer Unterklasse überschrieben werden.
     *
     * @param x x-Position des Mausklicks
     * @param y y-Position des Mausklicks
     * @param anzahl Anzahl der aufeinanderfolgenden Mausklicks
     */
    @Override
    void MausGeklickt(int x, int y, int anzahl)
    {
        // nichts
    }
}
