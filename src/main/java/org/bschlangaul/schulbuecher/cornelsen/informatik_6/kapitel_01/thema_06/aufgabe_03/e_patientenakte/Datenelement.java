package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_06.aufgabe_03.e_patientenakte;

/**
 * Interface für Datenelemente
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */

interface Datenelement
{
    /**
     * Methode zur Ausgabe von Information über das Datenelement
     */
    void InformationAusgeben();

    /**
     * Gibt zurück, ob der Name gleich den übergebenen Wert ist.
     *
     * @param gesuchterWert gesuchter Wert
     *
     * @return Wahrheitswert, der angibt, ob der Name der gesuchte ist.
     */
    boolean SchlüsselIstGleich(String gesuchterWert);

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    boolean IstKleinerAls(Datenelement dvergleich);
}
