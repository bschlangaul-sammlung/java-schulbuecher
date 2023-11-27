package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_02.tiere_1;

/**
 * Klasse Fisch <br>
 *
 * Kap. 7.2 Arbeitsauftrag 2
 */
class Fisch extends Tier
{
    Fisch()
    {
        art = "Fisch";
        futter = "Algen";
    }
    /*
     * istRechtsWasser() liefert true, wenn im Feld rechts daneben Wasser ist
     * setLocation(getX() + 1, getY()); versetzt ein Objekt ein Feld nach rechts
     */

    void bewegeNachRechts()
    {
        if (istRechtsWasser() == true)
        {
            setLocation(getX() + 1, getY());
        }
    }
}
