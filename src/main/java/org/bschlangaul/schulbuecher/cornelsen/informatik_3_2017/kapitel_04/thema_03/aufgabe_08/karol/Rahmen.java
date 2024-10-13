package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_03.aufgabe_08.karol;

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
        welt = new WELT("4_3_A08_Karol.kdw");
        karol = new MEINROBOTER(welt);
    }

    /**
     * Erledigt die Arbeit
     */
    void Ausführen()
    {
        // karol.ZurWandGehen();
        // karol.AlleZiegelAufheben();
        // karol.Putzen1();
        // karol.Putzen2();
        karol.SchlangeAufräumen();
        // karol.ZumHindernisGehen();
    }
}
