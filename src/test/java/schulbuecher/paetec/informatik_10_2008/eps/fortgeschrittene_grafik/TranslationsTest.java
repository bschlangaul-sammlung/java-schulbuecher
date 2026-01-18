package schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TranslationsTest
{
    private Rechteck rechteck1;

    @Disabled
    @Test
    void testVerschieben()
    {
        rechteck1 = new Rechteck();
        for (int i = 1; i <= 10; i++)
        {
            rechteck1.verschieben(10, 3);
            rechteck1.groesseSetzen(0, 0);
            rechteck1.groesseSetzen(i * 3, 70 / i);
        }
    }
}
