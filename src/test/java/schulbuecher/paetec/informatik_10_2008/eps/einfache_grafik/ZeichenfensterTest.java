package schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ZeichenfensterTest
{
    private Rechteck rechteck1;

    @Disabled
    @Test
    void anzeigen()
    {
        rechteck1 = new Rechteck();
        rechteck1.anzeigen();
        rechteck1.verschieben(100, 100);
        rechteck1.groesseSetzen(0, 100);
        rechteck1.groesseSetzen(1, 100);
    }
}
