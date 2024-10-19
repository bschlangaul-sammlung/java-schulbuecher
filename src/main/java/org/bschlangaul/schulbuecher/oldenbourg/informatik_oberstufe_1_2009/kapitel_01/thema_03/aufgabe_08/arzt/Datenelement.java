package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_08.arzt;

/**
 * Beschreibung zum Interface DATENELEMENT
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
interface Datenelement
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
    boolean IstKleinerAls(Datenelement dvergleich);

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels
     *
     * @param s Schlüssel vom Typ String
     */
    boolean SchluesselIstGleich(String s);
}