package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_03.graphen.radnetz;

/**
 * Diese Klasse stellt die Knoten eines Graphen dar. Jedes Objekt dieser Klasse
 * enthält genau ein Datenelement.
 */
class Knoten
{
    private Datenelement daten;

    // Dieses Attribut wird für Verfahren zum Graphendurchlauf benötigt.
    private boolean markierung;

    Knoten(Datenelement inhalt)
    {
        daten = inhalt;
    }

    Datenelement datenLiefern()
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
