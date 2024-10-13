package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_06.gesangstrio;

/**
 * Hauptprogramm fuer 4.6, Aufgabe 1
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-12-01
 */
public class Hauptprogramm
{
    public static void main()
    {
        Saenger s1 = new Saenger("Lucia", "Bontoni", "Sopran");
        Saenger s2 = new Saenger("Felix", "Wohlklang", "Tenor");
        Saenger s3 = new Saenger("Bert", "Hall", "Bass");
        Trio t1 = new Trio("Trigoletto", s1, s2, s3);
        t1.zeigeSaenger();
    }
}
