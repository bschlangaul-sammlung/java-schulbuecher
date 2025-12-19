package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_06.teilaufgabe_b.parkverbot;

/**
 * Parkplatz
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Parkplatz
{
    /** gibt an, ober der Parkplatz belegt ist oder nicht */
    private boolean frei;

    /**
     * Konstruktor für Objekte der Klasse Parkplatz
     */
    Parkplatz()
    {
        frei = true;
    }

    /**
     * Falls der Parkplatz frei ist, wird er beparkt.
     *
     * @param kennzeichen Kennzeichen des Fahrzeugs
     *
     * @return wahr, wenn der Platz beparkt werden konnte
     */
    synchronized boolean Beparken(int kennzeichen)
    {
        if (frei)
        {
            frei = false;
            System.out.println(kennzeichen + " erfolgreich eingeparkt.");
            return true;
        }
        System.out.println("Parkplatz belegt. Fahrzeug " + kennzeichen
                + " fährt um den Block.");
        return false;
    }

    /**
     * Der Parkplatz wird verlassen.
     *
     * @param kennzeichen Kennzeichen des Fahrzeugs
     */
    synchronized void Ausparken(int kennzeichen)
    {
        System.out.println(kennzeichen + " ausgeparkt.");
        frei = true;
    }
}
