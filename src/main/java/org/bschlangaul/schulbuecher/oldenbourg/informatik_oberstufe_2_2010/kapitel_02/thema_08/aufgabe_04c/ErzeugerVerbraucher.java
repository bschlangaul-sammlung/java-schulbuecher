package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_08.aufgabe_04c;

/**
 * Rahmenklasse für das Erzeuger-Verbraucher-Problem.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ErzeugerVerbraucher
{
    private Verbraucher verbraucher;

    private Erzeuger erzeuger;

    private Speicher speicher;

    /**
     * Constructor for objects of class ERZEUGERVERBRAUCHER
     */
    ErzeugerVerbraucher()
    {
        speicher = new Speicher();
        for (int i = 0; i < 5; i++)
        {
            erzeuger = new Erzeuger(1000, speicher);
            verbraucher = new Verbraucher(1000, speicher);
            erzeuger.start();
            verbraucher.start();
        }
    }

    public static void main(String[] args)
    {
        new ErzeugerVerbraucher();
    }
}
