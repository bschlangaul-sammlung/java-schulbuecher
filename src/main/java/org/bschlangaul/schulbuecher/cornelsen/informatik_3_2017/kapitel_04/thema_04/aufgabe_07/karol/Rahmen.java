package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_04.aufgabe_07.karol;

/**
 * Rahmenklasse für Roboter und Welt
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Rahmen
{
    WELT welt;

    MEINROBOTER karol;

    /**
     * Liest die Welt aus der Datei und erzeugt den Roboter
     */
    Rahmen()
    {
        welt = new WELT("4_4_A07_Karol.kdw");
        karol = new MEINROBOTER(welt);
    }

    /**
     * Erledigt die Arbeit
     */
    void Ausführen()
    {
        karol.Invertieren();
    }
}
