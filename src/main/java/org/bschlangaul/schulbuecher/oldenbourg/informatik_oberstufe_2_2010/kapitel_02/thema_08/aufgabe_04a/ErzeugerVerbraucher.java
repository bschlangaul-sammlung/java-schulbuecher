package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_04a;

/**
 * Rahmenklasse für das Erzeuger-Verbraucher-Problem.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class ErzeugerVerbraucher
{
    private Verbraucher verbraucher;
    private Erzeuger erzeuger;
    private Speicher speicher;

    /**
     * Legt die beteiligten Objekte an.
     */
    ErzeugerVerbraucher()
    {
        speicher = new Speicher();
        erzeuger = new Erzeuger(1000, speicher);
        verbraucher = new Verbraucher(1000, speicher);
        erzeuger.start();
        verbraucher.start();
    }

    /**
     * Startmethode
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args)
    {
        new ErzeugerVerbraucher();
    }
}
