package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_05.teilaufgabe_e.erzeuger_verbraucher;

import java.util.ArrayList;

/**
 * Zwischenspeicher beim Erzeuger-Verbraucher-Problem
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
@SuppressWarnings("unused")
class Speicher
{
    /**
     * Zählt, wie oft der Erzeuger Warten() aufruft
     */
    private int wartenErz;

    /**
     * Zählt, wie oft der Verbraucher Warten() aufruft
     */
    private int wartenVerb;

    /**
     * Speicherplätze
     */
    private ArrayList<Kiste> kistenspeicher;

    /**
     * Besetzt die Attribute vor.
     */
    Speicher()
    {
        kistenspeicher = new ArrayList<Kiste>();
        wartenErz = 0;
        wartenVerb = 0;
    }

    /**
     * Ablegen der Kiste
     *
     * @param kisteNeu die abzulegende Kiste
     */
    synchronized void Ablegen(Kiste kisteNeu)
    {
        while (kistenspeicher.size() >= 10)
        {
            try
            {
                wartenErz += 1;
                wait();
            }
            catch (Exception e)
            {
            }
        }
        kistenspeicher.add(kisteNeu);
        notifyAll();
    }

    /**
     * Holen der Kiste
     *
     * @return die geholte Kiste
     */
    synchronized Kiste Holen()
    {
        Kiste k;
        while (kistenspeicher.size() <= 0)
        {
            try
            {
                wartenVerb += 1;
                wait();
            }
            catch (Exception e)
            {
            }
        }
        k = kistenspeicher.get(0);
        kistenspeicher.remove(0);
        notifyAll();
        return k;
    }
}
