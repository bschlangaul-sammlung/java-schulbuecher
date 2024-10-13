package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_03.anwendungsorientierte_aufgaben.flugnetz;

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

    void ausgeben()
    {
        daten.Ausgeben();
    }

    boolean MarkierungGeben()
    {
        return markierung;
    }

    public void MarkierungSetzen(boolean wert)
    {
        markierung = wert;
    }

    // Ergänzung: Rückgabe des Datenobjekts
    DATENELEMENT DatenGeben()
    {
        return daten;
    }
}
