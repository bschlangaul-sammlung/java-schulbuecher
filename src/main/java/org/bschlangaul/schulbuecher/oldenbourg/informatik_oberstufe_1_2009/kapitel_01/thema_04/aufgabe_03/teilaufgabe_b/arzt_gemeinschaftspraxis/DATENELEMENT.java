package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.arzt_gemeinschaftspraxis;

/**
 * Beschreibung zum Interface DATENELEMENT
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
interface DATENELEMENT
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
    boolean IstKleinerAls(DATENELEMENT dvergleich);

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels
     *
     * @param s Schlüssel vom Typ String
     */
    boolean SchluesselIstGleich(String s);
}
