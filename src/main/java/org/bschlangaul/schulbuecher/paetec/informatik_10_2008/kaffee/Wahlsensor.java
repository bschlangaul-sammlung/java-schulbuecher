package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.kaffee;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular.Eingabefeld;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular.Sensor;

/**
 * Klasse Wahlsensor.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Wahlsensor extends Sensor
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
     * Erzeugt einen neuen Wahlsensor. Der wird dann beim Klick auf "Getraenk
     * bestaetigen" ausgeloest
     */
    public Wahlsensor(Kaffeeautomat aktuellerAutomat,
            Eingabefeld relevantesFeld)
    {
        feld = relevantesFeld;
        automat = aktuellerAutomat;
        textSetzen("Getraenk bestaetigen");
    }

    /**
     * Wird beim Klick auf "Getraenk bestaetigen" ausgel�st
     */
    public void ausloesen()
    {
        automat.getraenkWaehlen(feld.inhaltGeben());
    }
}
