package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Beschreibt die Eigenschaften eines in der Liste verwalteten Datenelements.
 *
 * @author
 *
 * @version 1.0
 */
interface DATENELEMENT
{
    /**
     * Identifiziert das Element.
     *
     * @param wert der Vergleichswert.
     *
     * @return true, wenn ein geeignetes Element gefunden wurde.
     */
    boolean IstGleich(String wert);

    /**
     * Implementiert die Kleiner-Relation für die Minimumsuche.
     *
     * @param d Datenelement mit dem Vergleichswert.
     *
     * @return true, wenn das Element einen kleineren Wert hat als der
     *     Vergleichswert.
     */
    boolean IstKleiner(DATENELEMENT d);
}
