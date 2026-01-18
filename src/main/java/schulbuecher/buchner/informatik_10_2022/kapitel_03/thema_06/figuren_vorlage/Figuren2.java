package schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_06.figuren_vorlage;

import greenfoot.Actor;

public class Figuren2 extends Actor
{
    Figur f1;

    int ecken;

    public void act()
    {
        // Add your action code here.
    }

    Figuren2(int anzEcken)
    {
        if (anzEcken == 3)
        {
            f1 = new Dreieck();
        }
        else if (anzEcken == 4)
        {
            f1 = new Rechteck();
        }
        else
        {
            System.out.println("Eine Zuordnung war leider nicht möglich.");
        }
    }
}
