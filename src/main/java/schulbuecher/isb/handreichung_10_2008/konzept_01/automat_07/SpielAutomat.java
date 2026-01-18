package schulbuecher.isb.handreichung_10_2008.konzept_01.automat_07;

import java.util.Random;

public class SpielAutomat
{
    private SpielWalze spielwalze1, spielwalze2, spielwalze3;

    private int z1, z2, z3;

    private Random zufall;

    public SpielAutomat()
    {
        zufall = new Random();
        z1 = 0;
        z2 = 0;
        z3 = 0;
        spielwalze1 = new SpielWalze(20, 50, 150, z1);
        spielwalze2 = new SpielWalze(170, 50, 150, z2);
        spielwalze3 = new SpielWalze(320, 50, 150, z3);
    }

    public void zeichne()
    {
        spielwalze1.zeichne();
        spielwalze2.zeichne();
        spielwalze3.zeichne();
    }

    public void setzeFarbmuster(int z1Neu, int z2Neu, int z3Neu)
    {
        z1 = z1Neu;
        z2 = z2Neu;
        z3 = z3Neu;
        spielwalze1.faerbeUm(z1);
        spielwalze2.faerbeUm(z2);
        spielwalze3.faerbeUm(z3);
    }

    public void spiele()
    {
        setzeFarbmuster(zufall.nextInt(9), zufall.nextInt(9),
                zufall.nextInt(9));
    }

    public void schreibeWerte()
    {
        System.out.println("z1: " + z1 + "  z2: " + z2 + "  z3: " + z3);
    }
}
