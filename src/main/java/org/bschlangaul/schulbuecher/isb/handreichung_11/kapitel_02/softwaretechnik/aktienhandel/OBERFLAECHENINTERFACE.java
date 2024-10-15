package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Beschreibt die Statusmeldungen der Oberfläche.
 *
 * @version 1.0
 */
interface OBERFLAECHENINTERFACE
{
    /**
     * Setzt den Text der Statuszeile
     *
     * @param text Statustext
     */
    void StatuszeileSetzen(String text);

    /**
     * Setzt den Wert des Kontostandes
     *
     * @param wert Kontostand
     */
    void KontostandsanzeigeSetzen(double wert);

    /**
     * Setzt die Anzeige der Depoteinträge
     *
     * @param eintraege Listeneinträge
     */
    void DepotlisteSetzen(String[] eintraege);
}
