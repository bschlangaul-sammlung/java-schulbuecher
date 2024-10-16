package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_02.einfache_oberflaeche;

import java.awt.Button;

/**
 * Testknopf.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class MeinKnopf extends Button
{
    /**
     * Constructor for objects of class MeinKnopf
     */
    MeinKnopf()
    {
        super();
        setLabel("Eingabe");
        setSize(100, 30);
        setLocation(10, 60);
        setVisible(true);
    }
}
