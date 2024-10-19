package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_a.grundstruktur;

/**
 * Beschreibung zum Interface DATENELEMENT
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
interface DatenElement
{
    /**
     * Ausgabe von Information über ein Ausgabefenster
     */
    void InformationAusgeben();

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    boolean IstKleinerAls(DatenElement dvergleich);

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels
     *
     * @param s Schlüssel vom Typ String
     */
    boolean SchluesselIstGleich(String s);
}