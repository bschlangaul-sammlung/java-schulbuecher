package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfaches_formular;

import org.junit.jupiter.api.Test;

public class EingabefeldTest
{
    private Text text1;

    private Bild bild1;

    @Test
    void testAnzeigen()
    {
        text1 = new Text();
        text1.anzeigen();
        bild1 = new Bild();
        bild1.anzeigen();
    }
}
