package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_02.einfache_oberflaeche;

import java.awt.Frame;

/**
 * Testfenster.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class MeinFenster extends Frame
{
    /**
     * Constructor for objects of class MeinFenster
     */
    MeinFenster()
    {
        super();
    }

    /**
     * Constructor for objects of class MeinFenster
     */
    MeinFenster(String titel)
    {
        super(titel);
        setSize(200, 100);
        setVisible(true);
    }
}
