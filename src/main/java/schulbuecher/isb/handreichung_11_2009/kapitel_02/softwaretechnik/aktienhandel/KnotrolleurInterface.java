package schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Beschreibt die für die Oberfläche nötigen Methoden des Kontrolleurs.
 *
 * @version 1.0
 */
interface KnotrolleurInterface
{
    /**
     * Setzt des aktuelle Konto anhand der gegebenen Kontonummer
     *
     * @param nummer neue Kontonummer
     */
    void KontoSetzen(int nummer);

    /**
     * Ereignis "Aktien einkaufen"
     *
     * @param aktienID Schlüssel der Aktie
     * @param anzahl gewünschte Anzahl der Aktie
     */
    void AktienKaufen(int aktienID, int anzahl);

    /**
     * Ereignis "Aktien verkaufen"
     *
     * @param aktienID Schlüssel der Aktie
     * @param anzahl gewünschte Anzahl der Aktie
     */
    void AktienVerkaufen(int aktienID, int anzahl);

    /**
     * Ereignis "Kursverlauf anzeigen"
     *
     * @param aktienID Schlüssel der Aktie
     */
    void KursverlaufAnzeigen(int aktienID);

    /**
     * Ereignis "neue Kurse"
     */
    void NeueKurswerteBerechnen();

    /**
     * Ereignis "Ende"
     */
    void Beenden();

    /**
     * Inhalt für die Aktienliste besorgen
     */
    String[] AktienNamenGeben();

    /**
     * Holt die Nummern aller Konten
     *
     * @return Feld mit den Kontonummern
     */
    int[] KontennummernGeben();
}
