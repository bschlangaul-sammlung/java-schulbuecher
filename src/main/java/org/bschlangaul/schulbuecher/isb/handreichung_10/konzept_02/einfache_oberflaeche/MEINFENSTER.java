package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_02.einfache_oberflaeche;

import java.awt.*;

/**
 * Testfenster.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class MEINFENSTER extends Frame
{
    /**
     * Constructor for objects of class MeinFenster
     */
    MEINFENSTER()
    {
        super();
    }

    /**
     * Constructor for objects of class MeinFenster
     */
    MEINFENSTER(String titel)
    {
        super(titel);
        setSize(200, 100);
        setVisible(true);
    }
}
