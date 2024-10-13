package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_03.teilaufgabe_b.wartezimmer_oberflaeche;

/**
 * Klasse zum Start des Projekts
 *
 * @author Klaus van Dijkstran
 *
 * @version 1.0
 */
class START
{
    /**
     * Konstruktor der Klasse START Erzeugt ein neues Fenster zur
     * Patientenverwaltung
     */
    START()
    {
        new FENSTER("Patientenverwaltung");
    }

    /**
     * Sorgt für den Start
     */
    static void main(String[] args)
    {
        new START();
    }
}
