package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.interna;

import java.util.HashMap;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.interna.Zeichenfenster;

/**
 * Diese Klasse implementiert einen statischen Fensterspeicher, der lediglich
 * dazu dient, auch Anfaengern ein Inspizieren von und Experimentieren mit
 * Fenstern in der didaktischen Entwicklungsumgebung BlueJ zu ermoeglichen.
 *
 * @author Ute Heuer
 */
public class FensterSpeicher
{
    /*---------------Attribute-----*/
    /**
     * Haelt die internen, fortgeschrittenen Fenster zu den einfachen Fenstern
     */
    private static HashMap<org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Zeichenfenster, Zeichenfenster> fensterMap = new HashMap<org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Zeichenfenster, Zeichenfenster>();

    /*---------------Methoden------*/
    /**
     * Liefert das zugehoerige fortgeschrittene Fenster zu einem einfachen
     * Fenster
     */
    public static Zeichenfenster fortgeschrittenesFensterGeben(
            org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Zeichenfenster einfachesFenster)
    {
        if (!fensterMap.containsKey(einfachesFenster))
            return null;
        else
            return fensterMap.get(einfachesFenster);
    }

    /**
     * Meldet ein einfaches Fenster im Speicher an
     */
    public static void einfachesFensterAnmelden(
            org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Zeichenfenster einfachesFenster,
            int breite, int hoehe)
    {
        fensterMap.put(einfachesFenster, new Zeichenfenster(breite, hoehe));
    }
}
