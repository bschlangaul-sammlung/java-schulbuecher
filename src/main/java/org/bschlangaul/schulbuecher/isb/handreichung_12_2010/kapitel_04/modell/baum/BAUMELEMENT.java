package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.baum;

import org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.DATENELEMENT;

/**
 * Beschreibt ein abstraktes Element des Baums.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
abstract class BAUMELEMENT
{
    /**
     * Fügt ein neues Datenelement sortiert in den Baum ein.
     *
     * @param neu Referenz auf des neue Datenelement
     *
     * @return der (neue) Nachfolger für das Vorgängerelement
     */
    abstract BAUMELEMENT Einfuegen(DATENELEMENT neu);

    /**
     * Sucht ein Datenelement mit dem in der Referenz angegebenen Schlüssel.
     *
     * @param schluessel Referenz auf ein Datenelement mit dem zu suchenden
     *     Schlüsselwert
     *
     * @return das gefundene Datenelement oder null
     */
    abstract DATENELEMENT Suchen(DATENELEMENT schluessel);
}
