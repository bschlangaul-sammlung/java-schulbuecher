package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_02.einfache_oberflaeche;

import java.awt.Label;

/**
 * Testtext.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class MeinText extends Label
{
    /**
     * Constructor for objects of class MeinText
     */
    MeinText()
    {
        super();
        setText("Beispiel");
        setSize(100, 20);
        setLocation(10, 30);
        setVisible(true);
    }
}
