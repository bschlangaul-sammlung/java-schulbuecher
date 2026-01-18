package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_01.aufgabe_02.lagerarbeit;

/**
 * Lagerist in einem Lager
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
public class Lagerist extends Thread
{
    /** graphische Darstellung des Lageristen */
    LageristenSymbol symbol;

    /**
     * Konstruktor für Objekte der Klasse Lagerist
     */
    public Lagerist(String helmfarbe, int nummer)
    {
        symbol = new LageristenSymbol(helmfarbe, nummer);
    }

    /**
     * Schiebt eine Kiste bis zum rechten Rand des Zeichenfensters.
     */
    @Override
    public void run()
    {
        while (symbol.XPositionGeben() < 763)
        {
            symbol.Gehen(1);
            symbol.Warten(5);
        }
    }
}
