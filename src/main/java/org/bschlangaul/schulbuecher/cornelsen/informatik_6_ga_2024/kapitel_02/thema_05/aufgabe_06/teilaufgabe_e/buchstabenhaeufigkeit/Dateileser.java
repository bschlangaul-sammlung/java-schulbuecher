package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_05.aufgabe_06.teilaufgabe_e.buchstabenhaeufigkeit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Mit der Klasse Dateileser kann ein Text aus einer Datei ausgelesen werden.
 *
 * @author Peter Brichzin
 *
 * @version 30.5.2024
 */
class Dateileser
{
    /**
     * Referenz auf die Datei, aus der gelesen wird
     */
    private File datei;

    /**
     * Konstruktor für Objekte der Klasse Dateileser
     *
     * @param dateinameNeu neuer Dateiname
     */
    Dateileser(String dateinameNeu)
    {
        datei = new File(dateinameNeu);
    }

    /**
     * Setzt den Wert der Datei, die ausgelesen wird.
     *
     * @param dateinameNeu neuer Dateiname
     */
    void DateiÖffnen(String dateinameNeu)
    {
        datei = new File(dateinameNeu);
    }

    /**
     * Liest den Text aus der Datei ein und gibt ihn zurück.
     *
     * @return Text
     */
    String TextAuslesen()
    {
        String text;
        text = "";
        try
        {
            Scanner inputStream = new Scanner(datei);

            while (inputStream.hasNext())
            {
                text = text + inputStream.next() + " ";
            }

            inputStream.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return text;
    }
}
