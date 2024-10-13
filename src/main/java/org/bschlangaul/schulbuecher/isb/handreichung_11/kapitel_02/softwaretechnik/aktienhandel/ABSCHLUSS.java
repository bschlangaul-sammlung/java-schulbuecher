package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Abschlussknoten einer Kontenliste.
 *
 * @author
 *
 * @version 1.0
 */
class ABSCHLUSS extends LISTENELEMENT
{
    /**
     * Belegt die Attribute.
     */
    ABSCHLUSS()
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
    LISTENELEMENT Einfuegen(KONTO konto)
    {
        return new KNOTEN(this, konto);
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
