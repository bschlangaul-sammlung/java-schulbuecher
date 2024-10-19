package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.liste;

import org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.DatenElement;

/**
 * Beschreibt ein abstraktes Element der Liste.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
abstract class ListenElement
{
    /**
     * Keine Aufgabe, nur zur Dokumentation aufgeführt.
     */
    ListenElement()
    {
    }

    /**
     * Fügt ein neues Datenelement sortiert in die Liste ein.
     *
     * @param neu Referenz auf des neue Datenelement
     *
     * @return der (neue) Nachfolger für das Vorgängerelement
     */
    abstract ListenElement Einfuegen(DatenElement neu);

    /**
     * Sucht ein Datenelement mit dem in der Referenz angegebenen Schlüssel.
     *
     * @param schluessel Referenz auf ein Datenelement mit dem zu suchenden
     *     Schlüsselwert
     *
     * @return das gefundene Datenelement oder null
     */
    abstract DatenElement Suchen(DatenElement schluessel);
}
