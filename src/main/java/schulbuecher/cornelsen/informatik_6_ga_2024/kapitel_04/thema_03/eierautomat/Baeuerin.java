package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.eierautomat;

import java.util.Random;

import schulbuecher.cornelsen.shared.graphics_and_games.Text;

/**
 * Bäuerin, die einen Eierautomaten betreibt
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Baeuerin extends Thread
{
    /** Zufallsgenertator zum Erzeugen einer zufälligen Wartezeit */
    Random zufallsgenerator;

    /** Zähler für die Anzahl der Zugriffsversuche */
    int anzahlVersuche;

    /** Textanzeige */
    Text ausgabeBäuerin;

    /** der zu verwendene Eierautomat */
    Eierautomat automat;

    /**
     * Konstruktor für Objekte der Klasse Baeuerin
     *
     * @param eierautomat der zu verwendene Eierautomat
     */
    Baeuerin(Eierautomat eierautomat)
    {
        super();
        automat = eierautomat;
        zufallsgenerator = new Random();
        ausgabeBäuerin = new Text();
        ausgabeBäuerin.PositionSetzen(50, 200);
        anzahlVersuche = 0;
    }

    /**
     * Die Bäuerin versucht in unregelmäßigen Zeitabständen, den Eierautomaten
     * wieder neu zu befüllen.
     */
    @Override
    public void run()
    {
        while (true)
        {
            // Textausgabe
            anzahlVersuche += 1;
            ausgabeBäuerin.TextSetzen(anzahlVersuche + ". Befüllbesuch");

            // Automatenbefüllversuch
            automat.Befüllen();

            // Simulation der Zeitdauer zwischen zwei Befüllversuchen
            try
            {
                sleep(zufallsgenerator.nextInt(4000)); // Zufallszahl aus dem
                                                       // Bereich [0; 4000[
            }
            catch (InterruptedException e)
            {
            }
        }
    }
}
