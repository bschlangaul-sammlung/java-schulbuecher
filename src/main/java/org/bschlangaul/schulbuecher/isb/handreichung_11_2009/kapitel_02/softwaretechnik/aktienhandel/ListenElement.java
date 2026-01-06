package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Allgemeines Element einer Liste von Konten
 *
 * @version 1.0
 */
abstract class ListenElement
{
    /**
     * Der Konstruktor ist nur der Vollständigkeit halber angegeben.
     */
    ListenElement()
    {
        // (noch) nichts zu tun
    }

    /**
     * Fügt ein Konto sortiert nach Kontonummern in die Liste ein.
     *
     * @param konto Referenz auf das einzufügende Konto.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    abstract ListenElement Einfuegen(Konto konto);

    /**
     * Sucht das angegebene Konto. Nutzt die Sortierung der Liste aus.
     *
     * @param nummer Nummer des zu suchenden Kontos.
     *
     * @return Referenz auf das gefundene Konto oder null.
     */
    abstract Konto Suchen(int nummer);

    /**
     * Zählt die Konten, die der angegebene Kunde besitzt.
     *
     * @return Anzahl der Mitglieder der Menge.
     */
    abstract int KontosZaehlen();

    /**
     * Trägt die Kontonummern der Konten des angegebenen Kunden in das Feld ein.
     *
     * @param ergebnis Referenz auf das Feld mit den gefundenen Daten.
     * @param pos Index, auf dem das nächste Element eingetragen werden soll.
     */
    abstract void KontonummernEintragen(int[] ergebnis, int pos);
}
