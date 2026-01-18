package schulbuecher.buchner.informatik_9_2021.kapitel_06.thema_02.lausjagd_vorlage;

import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * Projekt zu Kap. 6.2.
 * <p>
 * Arbeitsauftrag 2, Aufgabe 1
 */
public class Spielwelt extends World
{
    int timer = 0;

    int anzahlGefresseneLaeuse = 0;

    public Spielwelt()
    {
        super(800, 600, 1); // erzeugt eine Welt, 800x600 Zellen, Seitenlänge
                            // jeweils 1 Pixel
        addObject(new Marienkaefer(this), 300, 300); // fügt Marienkäfer der
                                                     // Welt hinzu
        // Arbeitsauftrag A2c)
    }

    void fuegeBlattlausEin()
    {
        int xPosition;
        int yPosition;
        xPosition = Greenfoot.getRandomNumber(600) + 100; // verhindert, dass
                                                          // die Laus in die
                                                          // linke
                                                          // Hecke gesetzt wird
        yPosition = Greenfoot.getRandomNumber(600);
        // Aufgabe 1
        // verwende die Methode berechneDistanzZurNaehestenBlattlaus(xPosition,
        // yPosition)
        addObject(new Blattlaus(), xPosition, yPosition); // fügt eine Blattlaus
                                                          // an der Stelle
                                                          // (xPosition|yPosition)
                                                          // ein
    }
    /*
     * Der Programmtext ab hier braucht für die Bearbeitung der Arbeitsaufträge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */

    public void act() // erhöht nach 1200 Zeitschritten die Zahl der Blattläuse
                      // wiedr auf 30
    {
        timer = timer - 1;
        if (timer <= 0)
        {
            fuelleMitBlattlaeusen();
            timer = 1200;
        }
        aktualisiereTexte();
    }

    void aktualisiereTexte() // erzeugt alle Texte und zeigt sie an
    {
        showText("Timer: " + timer, 300, 10);
        showText("Läuse gefressen: " + anzahlGefresseneLaeuse, 300, 30);
        showText("Läuse übrig: " + zaehleLaeuse(), 300, 50);
        if (zaehleLaeuse() == 0)
        {
            showText("Gewonnen!", 300, 70);
            Greenfoot.stop();
        }
    }

    void fuegeBuschHinzu(int xPos, int yPos) // fügt einen Busch in die Welt ein
    {
        Busch baumstumpf = new Busch();
        addObject(baumstumpf, xPos, yPos);
    }

    int zaehleLaeuse()
    {
        return getObjects(Blattlaus.class).size();
    }

    void fuelleMitBlattlaeusen()
    {
        while (zaehleLaeuse() < 30)
        {
            fuegeBlattlausEin();
        }
    }

    double berechneDistanzZurNaehestenBlattlaus(int x, int y)
    {
        int blattlausNr = 0;
        double minDistanz = Double.POSITIVE_INFINITY;;
        while (blattlausNr < zaehleLaeuse())
        {
            Blattlaus aktuelleLaus = getObjects(Blattlaus.class)
                    .get(blattlausNr);
            int dx = x - aktuelleLaus.getX();
            int dy = y - aktuelleLaus.getY();
            double aktuelleDistanz = Math.sqrt(dx * dx + dy * dy);
            if (aktuelleDistanz < minDistanz)
            {
                minDistanz = aktuelleDistanz;
            }
            blattlausNr = blattlausNr + 1;
        }
        return minDistanz;
    }
}
