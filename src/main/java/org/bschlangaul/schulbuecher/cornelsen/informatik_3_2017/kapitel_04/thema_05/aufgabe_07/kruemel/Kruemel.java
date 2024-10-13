package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_07.kruemel;

/**
 * Verwaltet einen Krümel
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Kruemel extends Figur
{
    /**
     * Stellt den orangen Krümel dar.
     */
    void FigurFestlegen()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenEllipse(-5, -5, 10, 10, "orange");
    }

    /**
     * Der Krümel verschwindet bei Berührung
     */
    void AktionAusführen()
    {
        if (Berührt())
        {
            Entfernen();
        }
    }
}
