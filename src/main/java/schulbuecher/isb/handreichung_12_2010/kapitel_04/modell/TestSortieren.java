package schulbuecher.isb.handreichung_12_2010.kapitel_04.modell;

/**
 * Führt die gewünschten Laufzeittests durch.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class TestSortieren
{
    /**
     * Erzeugerelement für die Schlüsselwerte
     */
    private Generator g;

    /**
     * Die Vergleichsanzahlen
     */
    private int anzahl1, anzahl2;

    /**
     * Die Laufzeitsummen
     */
    private long zeitAuswahlsort, zeitMergesort;

    /**
     * Die Ausgangsdaten
     */
    private DatenElement[] daten;

    /**
     * Legt die benötigten Objekte an und besetzt die Attributwerte.
     *
     * @param anzahl Anzahl der zu sortierenden Datenelemente
     */
    public TestSortieren(int anzahl)
    {
        g = new Generator(10);
        daten = new DatenElement[anzahl];
        for (int i = 0; i < anzahl; i++)
        {
            daten[i] = new StringDaten(g.BezeichnerGenerieren());
        }
    }

    /**
     * Sortiert das gegebene Feld durch Auswahl des jeweils kleinsten Elements
     * im unsortierten Rest.
     *
     * @param d das zu sortierende Feld
     */
    private void Auswahlsort(DatenElement[] d)
    {
        int pos;
        DatenElement hilf;
        anzahl1 = 0;
        for (int i = 0; i < d.length - 1; i++)
        {
            pos = i;
            for (int j = i + 1; j < d.length; j++)
            {
                anzahl1 += 1;
                if (d[j].Vergleichen(d[pos]) < 0)
                {
                    pos = j;
                }
            }
            hilf = d[i];
            d[i] = d[pos];
            d[pos] = hilf;
        }
    }

    /**
     * Sortiert den angegebenen Teilbereich des Feldes. pre: beide Felder
     * enthalten die Ausgangsdaten, da der Start nicht vorhersagbar ist.
     *
     * @param von das Feld mit den Ausgangsdaten
     * @param nach das Feld mit den Zieldaten
     * @param minIndex der Index, ab dem sortiert werden soll
     * @param topIndex der Index, bis zu dem (ausschließlich) sortiert werden
     *     soll
     */
    private void Mischen(DatenElement[] von, DatenElement[] nach, int minIndex,
            int topIndex)
    {
        int mitte;
        int pos;
        int posUnten;
        int posOben;
        if (minIndex < topIndex - 1)
        {
            mitte = (minIndex + topIndex) / 2;
            Mischen(nach, von, minIndex, mitte);
            Mischen(nach, von, mitte, topIndex);
            posUnten = minIndex;
            posOben = mitte;
            pos = minIndex;
            while (pos < topIndex)
            {
                if (posUnten >= mitte)
                {
                    while (posOben < topIndex)
                    {
                        nach[pos] = von[posOben];
                        pos += 1;
                        posOben += 1;
                    }
                }
                else if (posOben >= topIndex)
                {
                    while (posUnten < mitte)
                    {
                        nach[pos] = von[posUnten];
                        pos += 1;
                        posUnten += 1;
                    }
                }
                else
                {
                    anzahl2 += 1;
                    if (((StringDaten) von[posUnten])
                            .Vergleichen(von[posOben]) <= 0)
                    {
                        nach[pos] = von[posUnten];
                        posUnten += 1;
                    }
                    else
                    {
                        nach[pos] = von[posOben];
                        posOben += 1;
                    }
                    pos += 1;
                }
            }
        }
    }

    /**
     * Sortiert das gegebene Feld durch Mischen immer längerer Teilfelder.
     *
     * @param d das zu sortierende Feld
     */
    private void Mergesort(DatenElement[] d)
    {
        DatenElement[] nach;
        nach = d.clone();
        anzahl2 = 0;
        Mischen(d, nach, 0, d.length);
        for (int i = 0; i < d.length; i++)
        {
            d[i] = nach[i];
        }
    }

    /**
     * Misst die Zeit für einen Sortiervorgang mittels Sortieren durch direktes
     * Auswählen. Um die unterschiedlichen Prozessorfremdbelastungen
     * auszugleichen wird der Vorgang hundert Mal wiederholt und die minimale
     * Sortierzeit ermittelt.
     *
     * @return das Minimum der benötigten Sortierzeiten
     */
    private long ZeitFuerAuswahlsortMessen()
    {
        long start, ende, min;
        DatenElement[] d;
        min = Long.MAX_VALUE;
        for (int i = 1; i <= 100; i++)
        {
            d = daten.clone();
            start = System.nanoTime();
            Auswahlsort(d);
            ende = System.nanoTime();
            min = Math.min(min, ende - start);
        }
        return min;
    }

    /**
     * Misst die Zeit für einen Sortiervorgang mittels Sortieren durch Mischen.
     * Um die unterschiedlichen Prozessorfremdbelastungen auszugleichen wird der
     * Vorgang hundert Mal wiederholt und die minimale Sortierzeit ermittelt.
     *
     * @return das Minimum der benötigten Sortierzeiten
     */
    private long ZeitFuerMergesortMessen()
    {
        long start, ende, min;
        DatenElement[] d;
        min = Long.MAX_VALUE;
        for (int i = 1; i <= 100; i++)
        {
            d = daten.clone();
            start = System.nanoTime();
            Mergesort(d);
            ende = System.nanoTime();
            min = Math.min(min, ende - start);
        }
        return min;
    }

    /**
     * Meldet die Zeit für die Sortierung durch direktes Auswählen.
     *
     * @return Suchzeit
     */
    public long ZeitFuerAuswahlGeben()
    {
        return zeitAuswahlsort;
    }

    /**
     * Meldet die Zeit für die Sortierung durch Mischen.
     *
     * @return Suchzeit
     */
    public long ZeitFuerMergesortGeben()
    {
        return zeitMergesort;
    }

    /**
     * Bestimmt die durschnittlichen Sortierzeiten.
     *
     * @param auswahl gibt an, ob in der Liste gesucht werden soll
     * @param merge gibt an, ob im Baum gesucht werden soll
     */
    public void DurchschnittsTestZeit(boolean auswahl, boolean merge)
    {
        if (auswahl)
        {
            zeitAuswahlsort = ZeitFuerAuswahlsortMessen();
        }
        if (merge)
        {
            zeitMergesort = ZeitFuerMergesortMessen();
        }
    }

    /**
     * Meldet die durchschnittliche Anzahl der Vergleiche für die Sortierung
     * durch direktes Auswählen.
     *
     * @return Suchzeit
     */
    public int AnzahlFuerAuswahlGeben()
    {
        return anzahl1;
    }

    /**
     * Meldet die durchschnittliche Anzahl der Vergleiche für die Sortierung
     * durch Mischen.
     *
     * @return Suchzeit
     */
    public int AnzahlFuerMergesortGeben()
    {
        return anzahl2;
    }

    /**
     * Bestimmt die Vergleichsanzahlen.
     *
     * @param auswahl gibt an, ob Sortiren durch Auswählen durchgeführt werden
     *     soll
     * @param merge gibt an, ob Sortiren durch Mischen durchgeführt werden soll
     */
    public void DurchschnittsTestAnzahl(boolean auswahl, boolean merge)
    {
        if (auswahl)
        {
            Auswahlsort(daten.clone());
        }
        if (merge)
        {
            Mergesort(daten.clone());
        }
    }
}
