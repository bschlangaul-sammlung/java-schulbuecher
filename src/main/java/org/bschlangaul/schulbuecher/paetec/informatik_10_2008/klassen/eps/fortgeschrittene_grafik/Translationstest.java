package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.*;

/**
 * Der Translationstext.
 *
 * @author Ute Heuer
 */
public class Translationstest extends junit.framework.TestCase
{
    private Rechteck rechteck1;
    // Typ und Name der Objekte, deren Zustand spaeter
    // wiederhergestellt werden soll

    /**
     * Hier koennen Zustandsaenderungen (<-> Methodenaufrufe) mitprotokolliert
     * werden. Beim Wiederherstellen werden diese ausgefuehrt.
     */
    protected void setUp()
    {
        rechteck1 = new Rechteck();
        for (int i = 1; i <= 10; i++)
        {
            rechteck1.verschieben(10, 3);
            rechteck1.groesseSetzen(0, 0);
            rechteck1.groesseSetzen(i * 3, 70 / i);
        }
    }

    /**
     * Diese Methode kann in der 10.Klasse ignoriert werden.
     */
    protected void tearDown()
    {
    }
}
