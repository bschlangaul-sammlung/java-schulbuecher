package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_07.kreuzung;

/**
 * Beschreibung zum Interface DATENELEMENT
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
interface DatenElement
{
    boolean IstKleinerAls(DatenElement d);

    /**
     * Gibt Information aus.
     */
    void InformationAusgeben();

    /**
     * Vergleicht zwei Datenelemente
     *
     * @param vergleichswert Vergleichs-String
     *
     * @return Ergebnis des Vergleichs
     */
    boolean SchluesselIstGleich(String vergleichswert);
}
