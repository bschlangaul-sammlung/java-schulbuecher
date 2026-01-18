package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Blatt einer Kontenliste.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class BLATTK extends LISTENELEMENTK
{
    /**
     * Belegt die Attribute.
     */
    BLATTK()
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
    LISTENELEMENTK Einfuegen(KONTO konto)
    {
        return new KNOTENK(this, konto);
    }

    /**
     * Löscht das angegebene KONTO aus der Liste. Nutzt die Sortierung der Liste
     * aus.
     *
     * @param konto Referenz auf das einzufügende Konto.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENTK Loeschen(KONTO konto)
    {
        return this;
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
     * @param kunde Referenz auf den Kunde, für den die Konten gezählt werden
     *     sollen.
     *
     * @return Anzahl der Mitglieder der Menge.
     */
    int KontosFuerKundeZaehlen(KUNDE kunde)
    {
        return 0;
    }

    /**
     * Trägt die Kontonummern der Konten des angegebenen Kunden in das Feld ein.
     *
     * @param kunde Referenz auf den Kunden.
     * @param ergebnis Referenz auf das Feld mit den gefundenen Daten.
     * @param pos Index, auf dem das nächste Element eingetragen werden soll.
     */
    void KontonummernFuerKundeEintragen(KUNDE kunde, int[] ergebnis, int pos)
    {
        // hier ist nichts mehr zu tun
    }

    /**
     * Verzinst alle Sparkonten.
     */
    void Verzinsen()
    {
        // nichts zu tun
    }
}
