package schulbuecher.buchner.informatik_9_2021.kapitel_05.thema_11.aufgabe_12.kugel;

import greenfoot.Actor;

/**
 * Kap. 5.11, Aufgabe 12 Lösung
 */
public class Kugel extends Actor
{
    int radius;

    /**
     * Aufgabe 12 d) Konstruktor für Objekte der Klasse Kugel
     */
    Kugel()
    {
        setzeRadius(1);
    }

    Kugel(int neuerRadius)
    {
        setzeRadius(neuerRadius);
    }

    /**
     * Aufgabe 12 a) Setter für den Radius
     *
     * @param neuerRadius Der Radius einer Kugel
     */
    void setzeRadius(int neuerRadius)
    {
        radius = neuerRadius;
    }

    /**
     * Aufgabe 12 a), b) Getter für den Radius
     *
     * @return radius
     */
    int gibRadius()
    {
        return radius;
    }

    /**
     * Aufgabe 12 b) Berechnet den Oberflächeninhalt und gibt ihn zurück
     *
     * @return oberflaeche
     */
    double berechneOberflaecheninhalt()
    {
        double oberflaeche;
        oberflaeche = 4 * Math.PI * Math.pow(gibRadius(), 2);
        return oberflaeche;
    }

    /**
     * Aufgabe 12 g) Berechnet das Volumen der Kugel und gibt ihn zurück
     *
     * @return volumen
     */
    double getVolumen()
    {
        double volumen;
        volumen = 4 / 3 * Math.PI * Math.pow(gibRadius(), 3);
        return volumen;
    }
}
