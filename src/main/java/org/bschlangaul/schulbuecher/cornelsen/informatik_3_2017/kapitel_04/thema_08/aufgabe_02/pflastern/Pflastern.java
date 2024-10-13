package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_08.aufgabe_02.pflastern;

/**
 * Legt einen Weg aus Pflastersteinen
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Pflastern
{
    /**
     * Legt die Steine
     *
     * @param zeilenAnzahl die Anzahl der Pflasterzeilen
     * @param spaltenAnzahl die Anzahl der Pflasterspalten
     * @param größe die Größe der Pflastersteine
     * @param farbe die Farbe der Pflastersteine
     */
    Pflastern(int zeilenAnzahl, int spaltenAnzahl, int größe, String farbe)
    {
        for (int spalte = 0; spalte < spaltenAnzahl; spalte = spalte + 1)
        {
            for (int zeile = 0; zeile < zeilenAnzahl; zeile = zeile + 1)
            {
                new Pflasterstein(zeile, spalte, größe, farbe);
            }
        }
    }
}
