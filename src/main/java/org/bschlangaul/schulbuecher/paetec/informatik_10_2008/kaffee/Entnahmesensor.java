package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.kaffee;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular.Sensor;

/**
 * Klasse Entnahmesensor.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Entnahmesensor extends Sensor
{
    /**
     * Der Automat
     */
    private Kaffeeautomat automat;

    /**
     * Erzeugt ein neues Entnahmesensor. Wird beim Klick auf "Muenze einwerfen"
     * aufgerufen
     */
    public Entnahmesensor(Kaffeeautomat aktuellerAutomat)
    {
        automat = aktuellerAutomat;
        textSetzen("Becher nehmen");
    }

    /**
     * Wird beim Klick auf "Muenze einwerfen" aufgerufen
     */
    public void ausloesen()
    {
        automat.becherNehmen();
    }
}
