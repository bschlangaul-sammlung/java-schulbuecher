package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_05.rechenoperationen;

/**
 * Projekt 5-5_Rechenoperationen
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Berechnung
{
    // 1c)
    public static double berechneDurchschnitt(int[] array)
    {
        int summe = 0;
        int i = 0;
        while (i < array.length)
        {
            summe = summe + array[i];
            i = i + 1;
        }
        return summe / array.length;
    }

    // 1b)
    public static int groeßerVier(int[] array)
    {
        int anzahl = 0;
        int i = 0;
        while (i < array.length)
        {
            if (array[i] > 4)
            {
                anzahl = anzahl + 1;
            }
            i = i + 1;
        }
        return anzahl;
    }
}
