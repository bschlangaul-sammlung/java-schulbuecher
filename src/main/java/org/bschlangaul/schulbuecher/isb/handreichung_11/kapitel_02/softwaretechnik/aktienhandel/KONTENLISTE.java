package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Verwaltet Listen von KONTEN.
 *
 * @version 1.0
 */
class KONTENLISTE
{
    private LISTENELEMENT start;

    /**
     * Erzeugt eine leere Liste
     */
    KONTENLISTE()
    {
        start = new ABSCHLUSS();
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
     * Sucht die Kontonummer für einen bestimmten Kunden in der Datenbank.
     *
     * @return Feld mit den Kontonummer
     */
    int[] KontonummernGeben()
    {
        int[] resultat;
        int anzahl;
        anzahl = start.KontosZaehlen();
        resultat = new int[anzahl];
        start.KontonummernEintragen(resultat, 0);
        return resultat;
    }
}
