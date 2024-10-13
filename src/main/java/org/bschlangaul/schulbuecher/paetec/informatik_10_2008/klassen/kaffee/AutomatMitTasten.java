package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.kaffee;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittenes_formular.Eingabefeld;

/**
 * Klasse AutomatMitTasten.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class AutomatMitTasten
{
    /**
     * Erzeugt einen neuen Kaffeeautomaten
     */
    public AutomatMitTasten()
    {
        Kaffeeautomat automat = new Kaffeeautomat(80);
        Eingabefeld muenzschlitz = new Eingabefeld("Centwert einer Muenze",
                "20");
        Eingabefeld getraenkewahl = new Eingabefeld("Getraenk", "Milchkaffee");
        muenzschlitz.anzeigen();
        getraenkewahl.anzeigen();
        new Einwurfsensor(automat, muenzschlitz);
        new Wahlsensor(automat, getraenkewahl);
        new Entnahmesensor(automat);
    }
}
