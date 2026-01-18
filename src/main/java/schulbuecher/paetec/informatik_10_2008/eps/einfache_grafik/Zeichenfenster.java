package schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik;

import static schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.interna.FensterSpeicher.einfachesFensterAnmelden;
import static schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.interna.FensterSpeicher.fortgeschrittenesFensterGeben;

/**
 * Klasse Zeichenfenster.
 *
 * @author Ute Heuer
 */
public class Zeichenfenster
{
    /*---------------Attribute-----*/
    /*---------------Konstruktor---*/
    public Zeichenfenster(int breite, int hoehe)
    {
        einfachesFensterAnmelden(this, breite, hoehe);
    }

    /*---------------Methoden------*/
    public int breiteGeben()
    {
        return fortgeschrittenesFensterGeben(this).breiteGeben();
    }

    public int hoeheGeben()
    {
        return fortgeschrittenesFensterGeben(this).hoeheGeben();
    }
}
