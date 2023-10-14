package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_04c;

/**
 * Dummy-Klasse, stellt die gefüllte Kiste dar.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Kiste
{

    /** Laufende Nummer der Kiste */
    private int nummer;

    /**
     * Legt die Kistennummer fest
     */
    Kiste(int nummer)
    {
        this.nummer = nummer;
    }

    /**
     * Meldet die Nummer der Kiste
     */
    int KistennummerGeben()
    {
        return nummer;
    }
}
