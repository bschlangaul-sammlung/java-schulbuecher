package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.supermarkt;

/**
 * Beschreibung zum Interface DATENELEMENT
 *
 * @author Klaus Reinold
 * @version 1.0
 */
interface DATENELEMENT
{
    /**
     * Sorgt für das NeuPositionieren der Darstellungssymbole des Datenelements
     * und der Nachfolger
     *
     * @param knummer Nummer der Kasse
     * @param pos     Position vor der Kasse
     */
    void NeuPositionieren(int i, int j);

    /**
     * Gibt die Artikelzahl des Datenelements aus
     *
     * @return artikelzahl
     */
    int ArtikelzahlGeben();

    /**
     * Vergleicht zwei Datenelemente
     *
     * @param d Vergleichs-Datenelement
     * @return Ergebnis des Vergleichs
     */
    boolean IstKleinerAls(DATENELEMENT d);

    /**
     * Gibt Information aus.
     */
    void InformationAusgeben();

    /**
     * Vergleicht zwei Datenelemente
     *
     * @param vergleichswert Vergleichs-String
     * @return Ergebnis des Vergleichs
     */
    boolean SchluesselIstGleich(String vergleichswert);
}
