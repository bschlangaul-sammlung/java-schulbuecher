package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_04.sortieren_zaehlen;

/**
 * Schnittstelle der Oberfläche für den Kontrolleur.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
interface OBERFLAECHENINTERFACE
{
    /**
     * Trägt die Vergleichsanzahl für Sortieren durch Auswählen ein.
     */
    void AuswahlSortieranzahlSetzen(String anzahl);

    /**
     * Trägt die Vergleichsanzahl für Sortieren durch Mischen ein.
     *
     */
    void MischSortieranzahlSetzen(String anzahl);
}
