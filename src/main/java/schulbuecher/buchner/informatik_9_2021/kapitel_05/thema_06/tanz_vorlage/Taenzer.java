package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_06.tanz_vorlage;

import greenfoot.Actor;

public class Taenzer extends Actor
{
    int id; // Nummer des Taenzers

    int zähler; // zählt die Tanzschritte

    void rufeMethode1Auf() // Arbeitsauftrag 1b)
    {
        geheUndDrehe(50);
    }

    void geheUndDrehe(int winkel) // Arbeitsauftrag 1a)
    {
        setRotation(90);
        move(100);
        setRotation(winkel);
    }

    void rufeMethode2Auf() // S109: Methoden mit Rückgabewert deklarieren
    {
        int mitte; // Deklaration der lokalen Variablen mitte
        mitte = berechneMitte(0, 180); // mitte bekommt einen Wert zugewiesen
        setRotation(mitte); // Methodenaufruf mit diesem Wert
    }

    int berechneMitte(int a, int b) // S109: Methoden mit Rückgabewert
                                    // deklarieren
    {
        int mittelwert; // Deklaration der lokalen Variablen mittelwert
        mittelwert = (a + b) / 2; // mittelwert bekommt einen Wert zugewiesen
        return mittelwert; // dieser Wert wird zurückgeliefert
    }

    void bewegeNachUnten(int schritte) // Arbeitsauftrag 1c)
    {
        setRotation(90);
        move(20);
        setRotation(0);
    }

    double berechneEntfernungZu(int objektX, int objektY) // Arbeitsauftrag 2
    {
        int dx;
        dx = objektX - getX(); // x(anderer) - x(ich)
        int dy;
        dy = objektY - getY(); // y(anderer) - y(ich)
        int c2;
        c2 = dx * dx + dy * dy; // Pythagoras: c^2 = a^2 + b^2
        double distanz;
        distanz = Math.sqrt(c2); // Umformung: c = Wurzel(c^2)
        return distanz;
    }

    /**
     * Der Programmtext ab hier braucht für die Bearbeitung der Arbeitsaufträge
     * und Aufgaben weder gelesen noch verstanden zu werden.
     */
    Taenzer(int startId)
    {
        id = startId;
        zähler = 0;
    }

    public void act()
    {
        zähler = zähler + 1;
        if (zähler < 5)
        {
            bewegeNachUnten(20);
        }
        else
        {
            if (zähler < 17)
            {
                setRotation(90 * (zähler % 4));
                move(6 * id);
                setRotation(0);
            }
            else
            {
                bewegeNachUnten(20);
            }
        }
        if (zähler >= 20)
        {
            zähler = 0;
        }
    }
}
