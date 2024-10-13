package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Verwaltet Listen von KONTEN.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KONTENLISTE
{
    private LISTENELEMENTK start;

    /**
     * Erzeugt eine leere Liste
     */
    KONTENLISTE()
    {
        start = new BLATTK();
    }

    /**
     * Fügt das angegebenen Konto in die Liste ein.
     *
     * @param konto das einzufügende Konto.
     */
    void Einfuegen(KONTO konto)
    {
        start = start.Einfuegen(konto);
    }

    /**
     * Sucht das Konto mit der angegebenen Nummer.
     *
     * @param nummer die Nummer des zu suchenden Kontos
     *
     * @return Referenz auf das Konto oder null.
     */
    KONTO Suchen(int nummer)
    {
        return start.Suchen(nummer);
    }

    /**
     * Löscht das angegebene Konto aus der Liste.
     *
     * @param konto das zu löschende Konto.
     */
    void Loeschen(KONTO konto)
    {
        if (konto != null)
        {
            start = start.Loeschen(konto);
        }
    }

    /**
     * Sucht die Kontonummer für einen bestimmten Kunden in der Datenbank.
     *
     * @param kunde der Kunde dessen Kontonummern gesucht werden sollen.
     *
     * @return Feld mit den Kontonummer
     */
    int[] KontonummernFuerKundenGeben(KUNDE kunde)
    {
        int[] resultat;
        int anzahl;
        anzahl = start.KontosFuerKundeZaehlen(kunde);
        resultat = new int[anzahl];
        start.KontonummernFuerKundeEintragen(kunde, resultat, 0);
        return resultat;
    }

    /**
     * Verzinst alle Sparkonten.
     */
    void Verzinsen()
    {
        start.Verzinsen();
    }
}
