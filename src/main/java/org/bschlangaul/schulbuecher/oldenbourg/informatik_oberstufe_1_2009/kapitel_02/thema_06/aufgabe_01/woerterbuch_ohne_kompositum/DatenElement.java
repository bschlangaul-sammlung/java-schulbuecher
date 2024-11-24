package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_06.aufgabe_01.woerterbuch_ohne_kompositum;

/**
 * Beschreibung zum Interface DATENELEMENT
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public interface DatenElement
{
    /**
     * Ausgabe von Information über ein Ausgabefenster
     */
    public void InformationAusgeben();

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(DatenElement dvergleich);

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels
     *
     * @param s Schlüssel vom Typ String
     */
    public boolean SchluesselIstGleich(String s);
}
