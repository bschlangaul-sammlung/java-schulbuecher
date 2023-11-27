package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfaches_formular;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfaches_formular.Text;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfaches_formular.Bild;
import junit.framework.TestCase;

/**
 * Der Speicher.
 *
 * @author Ute Heuer
 */
public class Speicher extends TestCase
{ // Typ und Name
  // der Objekte, deren Zustand spaeter wiederhergestellt werden soll
    private Text text1;

    private Bild bild1;

    /**
     * Hier koennen Zustandsaenderungen (<-> Methodenaufrufe) mitprotokolliert
     * werden. Beim Wiederherstellen werden diese ausgefuehrt.
     */
    protected void setUp()
    {
        text1 = new Text();
        text1.anzeigen();
        bild1 = new Bild();
        bild1.anzeigen();
    }

    /**
     * Diese Methode kann in der 10.Klasse ignoriert werden.
     */
    protected void tearDown()
    {
    }
}
