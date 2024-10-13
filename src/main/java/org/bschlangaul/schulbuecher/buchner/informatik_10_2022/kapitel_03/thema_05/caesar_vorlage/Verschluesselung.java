package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_03.thema_05.caesar_vorlage;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.util.*;

/**
 * Projekt 3-5_Caesar
 *
 * @author André Greubel, Anja Stube
 *
 * @version 2022-09-21
 */
class Verschluesselung
{
    static int zaehleBuchstabeImWort(String wort)
    {
        return 0;
    }

    static int rateSchluessel(String wort)
    {
        // Todo 1d
        return 0;
    }

    static char gibHaeufigsterBuchstabe(String wort)
    {
        int[] zaehler = new int[52];
        int i = 0;
        while (i < wort.length())
        {
            int zahl = gibBuchstabenEinerBestimmtenStelle(wort, i);
            if (zahl >= 65 && zahl <= 90)
            {
                zaehler[zahl - 65]++;
            }
            if (zahl >= 97 && zahl <= 122)
            {
                zaehler[zahl - 97 + 26]++;
            }
            i++;
        }
        int maxWert = zaehler[0];
        int maxPos = 0;
        int aktPos = 0;
        while (aktPos < zaehler.length)
        {
            if (zaehler[aktPos] > maxWert)
            {
                maxWert = zaehler[aktPos];
                maxPos = aktPos;
            }
            aktPos++;
        }
        char res = '?';
        if (maxPos < 26)
        {
            res = (char) (maxPos + 65);
        }
        else
        {
            res = (char) (maxPos - 26 + 97);
        }
        return res;
    }

    static char codiereBuchstabe(char buchstabe, int schluessel)
    {
        int tmp = buchstabe + schluessel;
        if (tmp > 90)
        {
            tmp = tmp - 26;
        }
        return (char) tmp;
    }

    static String codiereWort(String eingabe)
    {
        return eingabe; // ToDo 3a
    }

    static String WortVerschlüsseln(String wort, int zahl)
    {
        String geheimesWort = "";
        // ToDo 3a !
        char ersterBuchstabe = gibBuchstabenEinerBestimmtenStelle(wort, 0);
        textAusgeben(geheimesWort);
        return geheimesWort;
    }
    /* Der Programmtext ab hier muss weder gelesen noch verstanden werden. */

    private static String allesInGroßbuchstabenUmwandeln(String wort)
    {
        return wort.toUpperCase();
    }

    private static char gibBuchstabenEinerBestimmtenStelle(String wort,
            int stelle)
    {
        return wort.charAt(stelle);
    }

    private static void textAusgeben(String wort)
    {
        System.out.println("Das verschlüsselte Wort lautet: " + wort);
    }
}
