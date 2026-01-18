package schulbuecher.isb.handreichung_11_2009.kapitel_03.anwendungsorientierte_aufgaben.flugnetz;

/**
 * Diese Klasse stellt die Knoten eines Graphen dar. Jedes Objekt dieser Klasse
 * enthält genau ein Datenelement.
 */
class Knoten
{
    private DatenElement daten;

    // Dieses Attribut wird für Verfahren zum Graphendurchlauf benötigt.
    private boolean markierung;

    Knoten(DatenElement inhalt)
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
    DatenElement DatenGeben()
    {
        return daten;
    }
}
