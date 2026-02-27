package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_06.teilaufgabe_d.parkverbot;

/**
 * Fahrzeug im Verkehr
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Fahrzeug extends Thread
{
    /**
     * Id des Fahrzeugs
     */
    private int kennzeichen;

    /**
     * angestrebter Parkplatz
     */
    private Parkplatz zielParkplatz;

    /**
     * Konstruktor für Objekte der Klasse Fahrzeug
     *
     * @param kennzeichenNeu Kennzeichen des Fahrzeugs
     * @param parkplatz der gewünschte Parkplatz
     */
    Fahrzeug(int kennzeichenNeu, Parkplatz parkplatz)
    {
        kennzeichen = kennzeichenNeu;
        zielParkplatz = parkplatz;
    }

    /**
     * Das Fahrzeug versucht permanent, den gewünschten Parkplatz zu belegen.
     * Anschließend parkt es wieder aus und "fährt um den Block", um dann wieder
     * von Neuem zu beginnen.
     */
    @Override
    public void run()
    {
        boolean eingeparkt;
        while (true)
        {
            // Einparkversuch
            eingeparkt = zielParkplatz.Beparken(kennzeichen);
            // Der Parkplatz war frei.
            if (eingeparkt)
            {
                // Parken
                try
                {
                    Thread.sleep(2500);
                }
                catch (Exception e)
                {
                }
                // Ausparken
                zielParkplatz.Ausparken(kennzeichen);
            }
            // Um den Block fahren
            try
            {
                Thread.sleep(5000);
            }
            catch (Exception e)
            {
            }
        }
    }
}
