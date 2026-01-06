package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Verwaltet Listen von KONTEN.
 *
 * @version 1.0
 */
class KnotenListe
{
    private ListenElement start;

    /**
     * Erzeugt eine leere Liste
     */
    KnotenListe()
    {
        start = new Abschluss();
    }

    /**
     * Fügt das angegebenen Konto in die Liste ein.
     *
     * @param konto das einzufügende Konto.
     */
    void Einfuegen(Konto konto)
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
    Konto Suchen(int nummer)
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
