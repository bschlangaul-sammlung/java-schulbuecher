package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_04.aufgabe_06.teilaufgabe_e.philosophen;

import java.util.Random;

import schulbuecher.cornelsen.shared.graphics_and_games.Kreis;

/**
 * Speisender Philosoph
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
@SuppressWarnings("unused")
class Philosoph extends Thread
{
    /**
     * Id des Philosophen
     */
    private int id;

    /**
     * Zeitangabe in ms als Grundlage für die Bestimmung zufälliger Ess- und
     * Wartezeiten
     */
    private int wartezeit;

    /**
     * Teller des Philosophen
     */
    private Kreis teller;

    /**
     * Farbe des Tellers
     */
    private String tellerfarbe;

    /**
     * Referenz auf die linke Gabel
     */
    private Gabel gabelLinks;

    /**
     * Referenz auf die rechte Gabel
     */
    private Gabel gabelRechts;

    /**
     * Zufallsgenerator
     */
    private Random ran;

    /**
     * Konstruktor für Objekte der Klasse Philosoph
     *
     * @param philosophenId Id des Philosophen
     * @param tellerNeu der Teller, von dem der Philosoph speist
     * @param tellerfarbeNeu Farbe des Tellers
     * @param links die linke Gabel, die der Philosoph nutzt
     * @param rechts die rechte Gabel, die der Philosoph nutzt
     */
    Philosoph(int philosophenId, Kreis tellerNeu, String tellerfarbeNeu,
            Gabel links, Gabel rechts)
    {
        wartezeit = 10;
        id = philosophenId;
        teller = tellerNeu;
        tellerfarbe = tellerfarbeNeu;
        gabelLinks = links;
        gabelRechts = rechts;
        ran = new Random();
    }

    /**
     * Die Arbeitsmethode des Threads mit einer Endlosschleife: Der Philosoph
     * versucht nach einer Zeit des Denkens die Gabeln aufzunehmen. Ist er damit
     * erfolgreich, isst er und legt sie dann wieder ab.
     */
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                sleep(ran.nextInt(wartezeit));
            }
            catch (InterruptedException e)
            {
            } ; // denken
            gabelLinks.Aufnehmen(tellerfarbe);

            if (gabelRechts.AufnehmenVersuchen(tellerfarbe))
            {
                try
                {
                    sleep(ran.nextInt(wartezeit));
                }
                catch (InterruptedException e)
                {
                } ; // essen
                gabelRechts.Ablegen();
            }
            gabelLinks.Ablegen();
        }
    }
}
