package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.einfache_oberflaeche;

import java.awt.*;

/**
 * Testknopf.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class MEINKNOPF extends Button
{
    /**
     * Constructor for objects of class MeinKnopf
     */
    MEINKNOPF()
    {
        super();
        setLabel("Eingabe");
        setSize(100, 30);
        setLocation(10, 60);
        setVisible(true);
    }
}
