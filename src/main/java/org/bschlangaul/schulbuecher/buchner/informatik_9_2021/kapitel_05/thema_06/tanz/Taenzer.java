package org.bschlangaul.schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_06.tanz;

import greenfoot.Actor;

public class Taenzer extends Actor
{
    int id; // Nummer des Taenzers

    int zähler; // zählt die Tanzschritte

    void rufeMethode1Auf(int winkel) // Arbeitsauftrag 1b)
    {
        geheUndDrehe(winkel);
        // geheUndDrehe(2 * winkel);
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
        mitte = (int) berechneMitte(0, 180); // mitte bekommt einen Wert
                                             // zugewiesen
        setRotation(mitte); // Methodenaufruf mit diesem Wert
    }

    /**
     * Aufgabe 2b
     */
    double berechneMitte(int a, int b) // S109: Methoden mit Rückgabewert
                                       // deklarieren
    {
        double mittelwert; // Deklaration der lokalen Variablen mittelwert
        mittelwert = (a + b) / 2; // mittelwert bekommt einen Wert zugewiesen
        return mittelwert; // dieser Wert wird zurückgeliefert
    }

    void bewegeNachUnten(int schritte) // Arbeitsauftrag 1c)
    {
        setRotation(90);
        move(20);
        setRotation(0);
    }

    /**
     * Aufgabe 3
     */
    int berechneUmfang(int radius)
    {
        double umfang;
        umfang = 2 * radius * Math.PI;
        return (int) umfang;
    }

    double berechneEntfernungZu(int objektX, int objektY) // Arbeitsauftrag 2
    {
        int diffX;
        diffX = objektX - getX(); // x(anderer) - x(ich)
        int diffY;
        diffY = objektY - getY(); // y(anderer) - y(ich)
        int c2;
        c2 = diffX * diffX + diffY * diffY; // Pythagoras: c^2 = a^2 + b^2
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
