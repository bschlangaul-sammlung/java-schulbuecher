package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_03.thema_01.aufgabe_09.tuerme_von_hanoi;

/**
 * Steuert die "Türme von Hanoi"
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Hanoi
{
    /**
     * Das Darstellungsobjekt
     */
    private Darstellung darstellung;

    /**
     * Legt die Darstellung an und startet den Ablauf
     *
     * @param anzahl Anzahl der Scheiben auf dem Ausgangsturm
     */
    Hanoi(int anzahl)
    {
        darstellung = new Darstellung(anzahl);
        darstellung.Starten();
        TurmBewegen(anzahl, 0, 2);
    }

    /**
     * Rekursive Steuermethode zur Bewegung des zu bewegenden (Teil-)Turms.
     *
     * @param anzahlScheiben Anzahl der Scheiben des Turms
     * @param von Nummer des Ausgangsturms
     * @param nach Nummer des Zielturms
     */
    void TurmBewegen(int anzahlScheiben, int von, int nach)
    {
        if (anzahlScheiben > 0)
        {
            int frei;
            frei = 3 - von - nach;
            TurmBewegen(anzahlScheiben - 1, von, frei);
            Bewegen(von, nach);
            TurmBewegen(anzahlScheiben - 1, frei, nach);
        }
    }

    /**
     * Bewegt die oberste Platte des Turms mit der Nummer von auf den Turm mit
     * der Nummer nach
     *
     * @param von Nummer des Ausgangsturms
     * @param nach Nummer des Zielturms
     */
    private void Bewegen(int von, int nach)
    {
        darstellung.Bewegen(von, nach);
        // darstellung.Verschieben(von, nach);
    }
}
