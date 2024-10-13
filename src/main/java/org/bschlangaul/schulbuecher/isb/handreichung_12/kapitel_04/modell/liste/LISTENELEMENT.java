package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_04.modell.liste;

import org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_04.modell.DATENELEMENT;

/**
 * Beschreibt ein abstraktes Element der Liste.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
abstract class LISTENELEMENT
{
    /**
     * Keine Aufgabe, nur zur Dokumentation aufgeführt.
     */
    LISTENELEMENT()
    {
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     *
     * @param neu Referenz auf des neue Datenelement
     *
     * @return der (neue) Nachfolger für das Vorgängerelement
     */
    abstract LISTENELEMENT Einfuegen(DATENELEMENT neu);

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
