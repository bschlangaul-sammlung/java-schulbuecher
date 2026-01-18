package schulbuecher.isb.handreichung_10_2008.konzept_01.automat_11;

import java.util.Random;

import schulbuecher.isb.handreichung_10_2008.konzept_01.ZeichenFenster;

public class SpielAutomat
{
    private SpielWalze spielwalze1, spielwalze2, spielwalze3;

    private int z1, z2, z3;

    private Random zufall;

    private int guthaben;

    private int[] gewinn;

    private int spielezahl;

    public SpielAutomat()
    {
        zufall = new Random();
        z1 = 0;
        z2 = 0;
        z3 = 0;
        spielwalze1 = new SpielWalze(20, 50, 150, z1);
        spielwalze2 = new SpielWalze(170, 50, 150, z2);
        spielwalze3 = new SpielWalze(320, 50, 150, z3);
        guthaben = 100;
        gewinn = new int[1000];
        spielezahl = 0;
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
        berechneGuthaben();
        gewinn[spielezahl] = ermittleGewinn();
        spielezahl = spielezahl + 1;
    }

    public void schreibeWerte()
    {
        System.out.println("z1: " + z1 + "  z2: " + z2 + "  z3: " + z3
                + "  Gewinn: " + ermittleGewinn());
    }

    public int ermittleGewinn()
    {
        if ((z1 == z2) && (z1 == z3))
        {
            return 10;
        }
        else
        {
            if ((z1 == z2) || (z1 == z3) || (z3 == z2))
            {
                return 2;
            }
            else
            {
                return 0;
            }
        }
    }

    public void gewinneSicher()
    {
        int g;
        do
        {
            setzeFarbmuster(zufall.nextInt(9), zufall.nextInt(9),
                    zufall.nextInt(9));
            g = ermittleGewinn();
        }
        while (g == 0);
        System.out.println("Gewinn: " + g);
    }

    public void berechneGuthaben()
    {
        guthaben = guthaben - 1 + ermittleGewinn();
    }

    public void spieleSelbst()
    {
        while (guthaben > 0)
        {
            spiele();
            ZeichenFenster.gibFenster().warte(100);
        }
    }

    public void laufe()
    {
        for (int i = 1; i <= 10; i++)
        {
            setzeFarbmuster(zufall.nextInt(9), zufall.nextInt(9),
                    zufall.nextInt(9));
            ZeichenFenster.gibFenster().warte(100);
        }
        berechneGuthaben();
    }

    public int zaehleHauptgewinne()
    {
        int zaehler = 0;
        for (int i = 0; i < spielezahl; i++)
        {
            if (gewinn[i] == 10)
            {
                zaehler = zaehler + 1;
            }
        }
        return zaehler;
    }

    public double berechneMittel()
    {
        int summe = 0;
        for (int i = 0; i < spielezahl; i++)
        {
            summe = summe + gewinn[i];
        }
        return 1.0 * summe / spielezahl;
    }

    public int zaehleKleingewinne()
    {
        int zaehler = 0;
        for (int i = 0; i < spielezahl; i++)
        {
            if (gewinn[i] == 2)
            {
                zaehler = zaehler + 1;
            }
        }
        return zaehler;
    }

    public int zaehleVerluste()
    {
        int zaehler = 0;
        for (int i = 0; i < spielezahl; i++)
        {
            if (gewinn[i] == 0)
            {
                zaehler = zaehler + 1;
            }
        }
        return zaehler;
    }

    public void spiele(int zahl)
    {
        for (int i = 0; i < zahl; i++)
        {
            spiele();
        }
        System.out.println(zaehleHauptgewinne() + " Hauptgewinne");
        System.out.println(zaehleKleingewinne() + " Kleingewinne");
        System.out.println(zaehleVerluste() + " mal verloren");
    }
}
