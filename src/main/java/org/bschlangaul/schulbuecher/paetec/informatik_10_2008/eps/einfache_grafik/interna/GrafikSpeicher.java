package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.interna;

import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.interna.Zeichenfenster.zeichenfensterGeben;

import java.util.HashMap;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Bild;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Dreieck;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Ellipse;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Rechteck;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Text;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.interna.Grafik;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.interna.Zeichenfenster;

/**
 * Diese Klasse implementiert einen statischen Grafikspeicher, der lediglich
 * dazu dient, auch Anfaengern ein Inspizieren von einfachen Grafiken in der
 * didaktischen Entwicklungsumgebung BlueJ zu ermoeglichen.
 *
 * @author Florian Prager, Universität Passau
 *
 * @version 02.2008
 */
public class GrafikSpeicher
{
    /**
     * Haelt die internen, fortgeschrittenen Grafiken zu den einfachen Grafiken
     */
    private static HashMap<Object, Grafik> grafikMap = new HashMap<Object, Grafik>();

    /**
     * Liefert die zugehoerige fortgeschrittene Grafik zu einer einfachen Grafik
     */
    public static Grafik fortgeschrittenegrafikGeben(Object einfacheGrafik)
    {
        if (!grafikMap.containsKey(einfacheGrafik))
            return null;
        else
            return grafikMap.get(einfacheGrafik);
    }

    /**
     * Meldet eine einfache Grafik (mit Standardzeichenfenster) im Speicher an
     */
    public static void einfachegrafikAnmelden(Object einfacheGrafik)
    {
        einfachegrafikAnmelden(einfacheGrafik, null);
    }

    /**
     * Meldet eine einfache Grafik im Speicher an
     */
    public static void einfachegrafikAnmelden(Object einfacheGrafik,
            Zeichenfenster fenster)
    {
        if (fenster == null)
        {
            fenster = zeichenfensterGeben();
        }
        if (einfacheGrafik instanceof Bild)
            grafikMap.put(einfacheGrafik,
                    new org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Bild(
                            false, fenster));
        else if (einfacheGrafik instanceof Dreieck)
            grafikMap.put(einfacheGrafik,
                    new org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Dreieck(
                            false, fenster));
        else if (einfacheGrafik instanceof Ellipse)
            grafikMap.put(einfacheGrafik,
                    new org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Ellipse(
                            false, fenster));
        else if (einfacheGrafik instanceof Rechteck)
            grafikMap.put(einfacheGrafik,
                    new org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Rechteck(
                            false, fenster));
        else if (einfacheGrafik instanceof Text)// Text mit
                                                // Standardschriftgroesse
                                                // anmelden (kann
                                                // entfernt werden)
            grafikMap.put(einfacheGrafik,
                    new org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Text(
                            false, fenster));
        else
            return;
        ((org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.interna.Grafik) grafikMap
                .get(einfacheGrafik)).fensterGeben().zeichenautomatStarten();
    }

    /**
     * Meldet einen einfachen Text im Speicher an
     */
    public static void einfachenTextAnmelden(int schriftgroesse,
            Object einfacheGrafik, Zeichenfenster fenster)
    {
        if (fenster == null)
        {
            fenster = zeichenfensterGeben();
        }
        if (einfacheGrafik instanceof Text)
            grafikMap.put(einfacheGrafik,
                    new org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Text(
                            schriftgroesse, false, fenster));
        else
            return;
        ((org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.interna.Grafik) grafikMap
                .get(einfacheGrafik)).fensterGeben().zeichenautomatStarten();
    }
}
