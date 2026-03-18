package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_00.eierautomat.vorlage;

import java.util.Random;

import schulbuecher.cornelsen.shared.graphics_and_games.Text;

/**
 * Leo, ein extremer Eierkonsument
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Leo extends Thread
{
    /**
     * Zufallsgenertator zum Erzeugen einer zufälligen Wartezeit
     */
    Random zufallsgenerator;

    /**
     * Zähler für die Anzahl der Zugriffsversuche
     */
    int anzahlVersuche;

    /**
     * Textanzeige
     */
    Text ausgabeLeo;

    /**
     * der zu verwendene Eierautomat
     */
    Eierautomat automat;

    /**
     * Konstruktor für Objekte der Klasse Leo
     *
     * @param eierautomat der zu verwendene Eierautomat
     */
    Leo(Eierautomat eierautomat)
    {
        super();
        automat = eierautomat;
        zufallsgenerator = new Random();
        ausgabeLeo = new Text();
        ausgabeLeo.PositionSetzen(550, 200);
        anzahlVersuche = 0;
    }

    /**
     * Leo versucht in unregelmäßigen Zeitabständen, einen Eierkarton aus dem
     * Automaten zu holen.
     */
    @Override
    public void run()
    {
        while (true)
        {
            // Textausgabe
            anzahlVersuche += 1;
            ausgabeLeo.TextSetzen(anzahlVersuche + ". Eierholbesuch");

            // Eierholversuch
            automat.EierHolen();

            // Simulation der Zeitdauer zwischen zwei Eierholversuchen
            try
            {
                sleep(zufallsgenerator.nextInt(200));// Zufallszahl aus dem
                                                     // Bereich [0; 200[
            }
            catch (InterruptedException e)
            {
            }
        }
    }
}
