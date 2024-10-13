package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.aktienhandel;

/**
 * (Innerer) Knoten einer Kontenliste.
 *
 * @version 1.0
 */
class KNOTEN extends LISTENELEMENT
{
    private LISTENELEMENT nachfolger;

    private KONTO konto;

    /**
     * Belegt die Attribute.
     *
     * @param nf Referenz auf den Nachfolger dieses Konotens
     * @param k Referenz auf das zu verwaltende Datenobjekt
     */
    KNOTEN(LISTENELEMENT nf, KONTO k)
    {
        super();
        nachfolger = nf;
        konto = k;
    }

    /**
     * Fügt ein Konto sortiert nach Kontonummern in die Liste ein.
     *
     * @param k Referenz auf das einzufügende Konto.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENT Einfuegen(KONTO k)
    {
        if (konto.KontoNummerGeben() < k.KontoNummerGeben())
        {
            nachfolger = nachfolger.Einfuegen(k);
            return this;
        }
        else
        {
            return new KNOTEN(this, k);
        }
    }

    /**
     * Sucht das angegebene Konto. Nutzt die Sortierung der Liste aus.
     *
     * @param nummer Nummer des zu suchenden Kontos.
     *
     * @return Referenz auf das gefundene Konto oder null.
     */
    KONTO Suchen(int nummer)
    {
        if (konto.KontoNummerGeben() == nummer)
        {
            return konto;
        }
        else if (konto.KontoNummerGeben() < nummer)
        {
            return nachfolger.Suchen(nummer);
        }
        else
        {
            return null;
        }
    }

    /**
     * Zählt die Konten, die der angegebene Kunde besitzt.
     *
     * @return Anzahl der Mitglieder der Menge.
     */
    int KontosZaehlen()
    {
        return nachfolger.KontosZaehlen() + 1;
    }

    /**
     * Trägt die Kontonummern der Konten des angegebenen Kunden in das Feld ein.
     *
     * @param ergebnis Referenz auf das Feld mit den gefundenen Daten.
     * @param pos Index, auf dem das nächste Element eingetragen werden soll.
     */
    void KontonummernEintragen(int[] ergebnis, int pos)
    {
        ergebnis[pos] = konto.KontoNummerGeben();
        nachfolger.KontonummernEintragen(ergebnis, pos + 1);
    }
}
