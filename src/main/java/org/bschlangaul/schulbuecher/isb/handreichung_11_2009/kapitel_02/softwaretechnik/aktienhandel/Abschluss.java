package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Abschlussknoten einer Kontenliste.
 *
 *
 * @version 1.0
 */
class Abschluss extends ListenElement
{
    /**
     * Belegt die Attribute.
     */
    Abschluss()
    {
        super();
    }

    /**
     * Fügt ein Konto sortiert nach Kontonummern in die Liste ein.
     *
     * @param konto Referenz auf das einzufügende Konto.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    ListenElement Einfuegen(Konto konto)
    {
        return new Knoten(this, konto);
    }

    /**
     * Sucht das angegebene Konto. Nutzt die Sortierung der Liste aus.
     *
     * @param nummer Nummer des zu suchenden Kontos.
     *
     * @return Referenz auf das gefundene Konto oder null.
     */
    Konto Suchen(int nummer)
    {
        return null;
    }

    /**
     * Zählt die Konten, die der angegebene Kunde besitzt.
     *
     * @return Anzahl der Mitglieder der Menge.
     */
    int KontosZaehlen()
    {
        return 0;
    }

    /**
     * Trägt die Kontonummern der Konten des angegebenen Kunden in das Feld ein.
     *
     * @param ergebnis Referenz auf das Feld mit den gefundenen Daten.
     * @param pos Index, auf dem das nächste Element eingetragen werden soll.
     */
    void KontonummernEintragen(int[] ergebnis, int pos)
    {
        // hier ist nichts mehr zu tun
    }
}
