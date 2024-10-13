package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Allgemeines Element einer Liste von Konten
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
abstract class LISTENELEMENTK
{
    /**
     * Der Konstruktor ist nur der Vollständigkeit halber angegeben.
     */
    LISTENELEMENTK()
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
    abstract LISTENELEMENTK Einfuegen(KONTO konto);

    /**
     * Löscht das angegebene KONTO aus der Liste. Nutzt die Sortierung der Liste
     * aus.
     *
     * @param konto Referenz auf das einzufügende Konto.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    abstract LISTENELEMENTK Loeschen(KONTO konto);

    /**
     * Sucht das angegebene Konto. Nutzt die Sortierung der Liste aus.
     *
     * @param nummer Nummer des zu suchenden Kontos.
     *
     * @return Referenz auf das gefundene Konto oder null.
     */
    abstract KONTO Suchen(int nummer);

    /**
     * Zählt die Konten, die der angegebene Kunde besitzt.
     *
     * @param kunde Referenz auf den Kunde, für den die Konten gezählt werden
     *     sollen.
     *
     * @return Anzahl der Mitglieder der Menge.
     */
    abstract int KontosFuerKundeZaehlen(KUNDE kunde);

    /**
     * Trägt die Kontonummern der Konten des angegebenen Kunden in das Feld ein.
     *
     * @param kunde Referenz auf den Kunden.
     * @param ergebnis Referenz auf das Feld mit den gefundenen Daten.
     * @param pos Index, auf dem das nächste Element eingetragen werden soll.
     */
    abstract void KontonummernFuerKundeEintragen(KUNDE kunde, int[] ergebnis,
            int pos);

    /**
     * Verzinst alle Sparkonten.
     */
    abstract void Verzinsen();
}
