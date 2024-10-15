package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_03.graphen.radnetz;

/**
 * Diese Klasse stellt die Knoten eines Graphen dar. Jedes Objekt dieser Klasse
 * enthält genau ein Datenelement.
 *
 */
class KNOTEN
{
    private DATENELEMENT daten;

    // Dieses Attribut wird für Verfahren zum Graphendurchlauf benötigt.
    private boolean markierung;

    KNOTEN(DATENELEMENT inhalt)
    {
        daten = inhalt;
    }

    DATENELEMENT datenLiefern()
    {
        return daten;
    }

    boolean markierungGeben()
    {
        return markierung;
    }

    void markierungSetzen(boolean wert)
    {
        markierung = wert;
    }
}
