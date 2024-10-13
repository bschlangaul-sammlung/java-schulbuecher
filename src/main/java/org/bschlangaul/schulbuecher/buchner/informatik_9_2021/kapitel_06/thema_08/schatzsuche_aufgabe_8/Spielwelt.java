package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_08.schatzsuche_aufgabe_8;

import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * Projekt zu 6.8, Aufgabe 8
 * <p>
 * Klasse Spielwelt <br>
 * Der Programmtext dieser Klasse braucht für die Bearbeitung der
 * Arbeitsaufträge und Aufgaben weder gelesen noch verstanden zu werden.
 */
public class Spielwelt extends World
{
    int timer = 60 * 55;

    Anzeige anzeige = new Anzeige();

    Pirat joe;

    public Spielwelt()
    {
        super(18, 11, 60);
        bereiteSpielweltVor();
        anzeige.setzeZeit(timer / 55);
        Greenfoot.setSpeed(50);
    }

    public void act()
    {
        anzeige.setzeGoldstuecke(joe.gibAnzahlGoldstuecke());
        timer = timer - 1;
        if (timer == 0)
        {
            anzeige.zeigeZeitAbgelaufen();
            Greenfoot.stop();
        }
        anzeige.setzeZeit(timer / 55);
    }

    public Anzeige getAnzeige()
    {
        return anzeige;
    }

    void bereiteSpielweltVor()
    {
        joe = new Pirat(this);
        addObject(joe, 2, 3); // Pirat einfügen
        /* Meer einfügen */
        Meer meer = new Meer();
        meer.getImage().scale(120, 660);
        addObject(meer, 17, 5);
        /* Tafel einfügen */
        addObject(new Tafel(), 1, 1);
        addObject(anzeige, 1, 0);
        /* 9 Schatztruhen einfügen */
        Schatztruhe schatztruhe1 = new Schatztruhe();
        addObject(schatztruhe1, 11, 3);
        Schatztruhe schatztruhe2 = new Schatztruhe();
        addObject(schatztruhe2, 5, 1);
        Schatztruhe schatztruhe3 = new Schatztruhe();
        addObject(schatztruhe3, 12, 5);
        Schatztruhe schatztruhe4 = new Schatztruhe();
        addObject(schatztruhe4, 7, 5);
        Schatztruhe schatztruhe5 = new Schatztruhe();
        addObject(schatztruhe5, 0, 8);
        Schatztruhe schatztruhe6 = new Schatztruhe();
        addObject(schatztruhe6, 1, 6);
        Schatztruhe schatztruhe7 = new Schatztruhe();
        addObject(schatztruhe7, 7, 10);
        Schatztruhe schatztruhe8 = new Schatztruhe();
        addObject(schatztruhe8, 14, 10);
        Schatztruhe schatztruhe9 = new Schatztruhe();
        addObject(schatztruhe9, 11, 0);
        /* 74 Felsen einfügen */
        Fels fels1 = new Fels();
        addObject(fels1, 5, 7);
        Fels fels2 = new Fels();
        addObject(fels2, 5, 6);
        Fels fels3 = new Fels();
        addObject(fels3, 6, 5);
        Fels fels4 = new Fels();
        addObject(fels4, 6, 4);
        Fels fels5 = new Fels();
        addObject(fels5, 3, 2);
        Fels fels6 = new Fels();
        addObject(fels6, 3, 0);
        Fels fels7 = new Fels();
        addObject(fels7, 4, 0);
        Fels fels8 = new Fels();
        addObject(fels8, 5, 0);
        Fels fels9 = new Fels();
        addObject(fels9, 0, 4);
        Fels fels10 = new Fels();
        addObject(fels10, 0, 5);
        Fels fels11 = new Fels();
        addObject(fels11, 0, 6);
        Fels fels12 = new Fels();
        addObject(fels12, 5, 2);
        Fels fels13 = new Fels();
        addObject(fels13, 6, 2);
        Fels fels14 = new Fels();
        addObject(fels14, 6, 0);
        Fels fels15 = new Fels();
        addObject(fels15, 7, 0);
        Fels fels16 = new Fels();
        addObject(fels16, 8, 0);
        Fels fels17 = new Fels();
        addObject(fels17, 9, 0);
        Fels fels18 = new Fels();
        addObject(fels18, 7, 2);
        Fels fels19 = new Fels();
        addObject(fels19, 7, 3);
        Fels fels20 = new Fels();
        addObject(fels20, 6, 3);
        Fels fels21 = new Fels();
        addObject(fels21, 8, 3);
        Fels fels22 = new Fels();
        addObject(fels22, 8, 4);
        Fels fels23 = new Fels();
        addObject(fels23, 9, 1);
        Fels fels24 = new Fels();
        addObject(fels24, 10, 1);
        Fels fels25 = new Fels();
        addObject(fels25, 11, 1);
        Fels fels26 = new Fels();
        addObject(fels26, 12, 1);
        Fels fels27 = new Fels();
        addObject(fels27, 13, 0);
        Fels fels28 = new Fels();
        addObject(fels28, 12, 3);
        Fels fels29 = new Fels();
        addObject(fels29, 12, 4);
        Fels fels30 = new Fels();
        addObject(fels30, 11, 4);
        Fels fels31 = new Fels();
        addObject(fels31, 10, 4);
        Fels fels32 = new Fels();
        addObject(fels32, 8, 5);
        Fels fels33 = new Fels();
        addObject(fels33, 7, 4);
        Fels fels34 = new Fels();
        addObject(fels34, 6, 6);
        Fels fels35 = new Fels();
        addObject(fels35, 6, 7);
        Fels fels36 = new Fels();
        addObject(fels36, 4, 4);
        Fels fels37 = new Fels();
        addObject(fels37, 3, 4);
        Fels fels38 = new Fels();
        addObject(fels38, 8, 6);
        Fels fels39 = new Fels();
        addObject(fels39, 8, 7);
        Fels fels40 = new Fels();
        addObject(fels40, 9, 7);
        Fels fels41 = new Fels();
        addObject(fels41, 10, 7);
        Fels fels42 = new Fels();
        addObject(fels42, 11, 5);
        Fels fels43 = new Fels();
        addObject(fels43, 11, 7);
        Fels fels44 = new Fels();
        addObject(fels44, 12, 7);
        Fels fels45 = new Fels();
        addObject(fels45, 15, 10);
        Fels fels46 = new Fels();
        addObject(fels46, 3, 1);
        Fels fels47 = new Fels();
        addObject(fels47, 6, 9);
        Fels fels48 = new Fels();
        addObject(fels48, 7, 9);
        Fels fels49 = new Fels();
        addObject(fels49, 8, 9);
        Fels fels50 = new Fels();
        addObject(fels50, 12, 9);
        Fels fels51 = new Fels();
        addObject(fels51, 2, 7);
        Fels fels52 = new Fels();
        addObject(fels52, 2, 6);
        Fels fels53 = new Fels();
        addObject(fels53, 1, 7);
        Fels fels54 = new Fels();
        addObject(fels54, 4, 10);
        Fels fels55 = new Fels();
        addObject(fels55, 3, 10);
        Fels fels56 = new Fels();
        addObject(fels56, 8, 10);
        Fels fels57 = new Fels();
        addObject(fels57, 9, 10);
        Fels fels58 = new Fels();
        addObject(fels58, 12, 10);
        Fels fels59 = new Fels();
        addObject(fels59, 13, 6);
        Fels fels60 = new Fels();
        addObject(fels60, 13, 7);
        Fels fels61 = new Fels();
        addObject(fels61, 10, 10);
        Fels fels62 = new Fels();
        addObject(fels62, 11, 10);
        Fels fels63 = new Fels();
        addObject(fels63, 4, 9);
        Fels fels64 = new Fels();
        addObject(fels64, 15, 9);
        Fels fels65 = new Fels();
        addObject(fels65, 14, 9);
        Fels fels66 = new Fels();
        addObject(fels66, 0, 7);
        Fels fels67 = new Fels();
        addObject(fels67, 1, 4);
        Fels fels68 = new Fels();
        addObject(fels68, 2, 4);
        Fels fels69 = new Fels();
        addObject(fels69, 2, 10);
        Fels fels70 = new Fels();
        addObject(fels70, 1, 10);
        Fels fels71 = new Fels();
        addObject(fels71, 0, 10);
        Fels fels72 = new Fels();
        addObject(fels72, 1, 8);
        Fels fels73 = new Fels();
        addObject(fels73, 2, 8);
        Fels fels74 = new Fels();
        addObject(fels74, 14, 1);
        /* 35 Grasbüschel einfügen */
        Gras gras1 = new Gras();
        addObject(gras1, 6, 1);
        Gras gras2 = new Gras();
        addObject(gras2, 10, 3);
        Gras gras3 = new Gras();
        addObject(gras3, 10, 2);
        Gras gras4 = new Gras();
        addObject(gras4, 11, 2);
        Gras gras5 = new Gras();
        addObject(gras5, 9, 6);
        Gras gras6 = new Gras();
        addObject(gras6, 10, 6);
        Gras gras7 = new Gras();
        addObject(gras7, 11, 6);
        Gras gras8 = new Gras();
        addObject(gras8, 5, 5);
        Gras gras9 = new Gras();
        addObject(gras9, 4, 5);
        Gras gras10 = new Gras();
        addObject(gras10, 1, 9);
        Gras gras11 = new Gras();
        addObject(gras11, 3, 7);
        Gras gras12 = new Gras();
        addObject(gras12, 7, 8);
        Gras gras13 = new Gras();
        addObject(gras13, 16, 0);
        Gras gras14 = new Gras();
        addObject(gras14, 16, 1);
        Gras gras15 = new Gras();
        addObject(gras15, 15, 1);
        Gras gras16 = new Gras();
        addObject(gras16, 15, 0);
        Gras gras17 = new Gras();
        addObject(gras17, 15, 2);
        Gras gras18 = new Gras();
        addObject(gras18, 15, 3);
        Gras gras19 = new Gras();
        addObject(gras19, 16, 3);
        Gras gras20 = new Gras();
        addObject(gras20, 15, 4);
        Gras gras21 = new Gras();
        addObject(gras21, 16, 4);
        Gras gras22 = new Gras();
        addObject(gras22, 15, 5);
        Gras gras23 = new Gras();
        addObject(gras23, 16, 5);
        Gras gras24 = new Gras();
        addObject(gras24, 15, 6);
        Gras gras25 = new Gras();
        addObject(gras25, 16, 6);
        Gras gras26 = new Gras();
        addObject(gras26, 15, 7);
        Gras gras27 = new Gras();
        addObject(gras27, 16, 7);
        Gras gras28 = new Gras();
        addObject(gras28, 16, 8);
        Gras gras29 = new Gras();
        addObject(gras29, 16, 9);
        Gras gras30 = new Gras();
        addObject(gras30, 16, 10);
        Gras gras31 = new Gras();
        addObject(gras31, 15, 8);
        Gras gras32 = new Gras();
        addObject(gras32, 10, 8);
        Gras gras33 = new Gras();
        addObject(gras33, 13, 1);
        Gras gras34 = new Gras();
        addObject(gras34, 13, 5);
        Gras gras35 = new Gras();
        addObject(gras35, 13, 4);
        /* Piratenschiff einfügen */
        Piratenschiff piratenschiff = new Piratenschiff();
        addObject(piratenschiff, 16, 2);
    }
}
