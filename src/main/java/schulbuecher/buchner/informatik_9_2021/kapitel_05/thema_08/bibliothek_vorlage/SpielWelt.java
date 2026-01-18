package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_08.bibliothek_vorlage;

import greenfoot.World;

import java.util.Random;

public class SpielWelt extends World
{
    public SpielWelt()
    {
        super(600, 400, 1);
        Random rng = new Random();
        Buch buch1 = new Buch("Informatik leicht gemacht", "A. B. Zeh",
                2.99 + rng.nextInt(20));
        addObject(buch1, 100, 150);
        Buch buch2 = new Buch("Der Doppelklick", "D. Maus",
                2.99 + rng.nextInt(20));
        addObject(buch2, 300, 150);
        Buch buch3 = new Buch("Die Insel Java", "K. Fee",
                2.99 + rng.nextInt(20));
        addObject(buch3, 500, 150);
        Schueler schueler1 = new Schueler(12 + rng.nextInt(7));
        addObject(schueler1, 100, 350);
        Schueler schueler2 = new Schueler(12 + rng.nextInt(7));
        addObject(schueler2, 190, 350);
        Schueler schueler3 = new Schueler(12 + rng.nextInt(7));
        addObject(schueler3, 280, 350);
        Schueler schueler4 = new Schueler(12 + rng.nextInt(7));
        addObject(schueler4, 370, 350);
        Schueler schueler5 = new Schueler(12 + rng.nextInt(7));
        addObject(schueler5, 460, 350);
    }
}
