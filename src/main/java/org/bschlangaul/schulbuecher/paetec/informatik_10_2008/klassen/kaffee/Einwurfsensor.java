package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.kaffee;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittenes_formular.Eingabefeld;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittenes_formular.Sensor;

/**
 * Klasse Einwurfsensor.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Einwurfsensor extends Sensor
{
    /**
     * Der Automat
     */
    private Kaffeeautomat automat;

    /**
     * Das Bedienfeld
     */
    private Eingabefeld feld;

    /**
     * Erzeugt ein neues Einwurfsensor. Wird beim Klick auf "Muenze einwerfen"
     * aufgerufen
     */
    public Einwurfsensor(Kaffeeautomat aktuellerAutomat,
            Eingabefeld relevantesFeld)
    {
        feld = relevantesFeld;
        automat = aktuellerAutomat;
        textSetzen("Muenze einwerfen");
    }

    /**
     * Wird beim Klick auf "Muenze einwerfen" aufgerufen
     */
    public void ausloesen()
    {// Der Nutzer hat keine Zahl angegeben
        Integer muenzwert = feld.ganzeZahlGeben();
        if (muenzwert == null)
        {
            System.err.println(
                    "Bitte als Muenzwert eine ganze Zahl eingeben und nicht: \""
                            + feld.inhaltGeben() + "\"");
            return;
        }
        automat.muenzeEinwerfen(muenzwert);
    }
}
