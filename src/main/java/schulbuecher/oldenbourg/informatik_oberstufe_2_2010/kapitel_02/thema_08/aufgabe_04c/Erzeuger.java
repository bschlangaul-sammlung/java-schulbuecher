package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_08.aufgabe_04c;

/**
 * Beschreibt den Erzeuger.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Erzeuger extends Thread
{
    /**
     * Die Produktionszeit pro Kiste
     */
    private int zeit;

    /**
     * Der Zwischenspeicher
     */
    private Speicher speicher;

    /**
     * Laufende Nummer der produzierten Kisten
     */
    private static int nummer = 0;

    /**
     * Legt die Konstruktionszeit fest
     *
     * @param z die Konstruktionszeit
     * @param s der Zwischenspeicher
     */
    Erzeuger(int z, Speicher s)
    {
        zeit = z;
        speicher = s;
    }

    /**
     * Die Arbeitsmethode des Threads.
     */
    public void run()
    {
        while (true)
        {
            speicher.Ablegen(Produzieren());
        }
    }

    /**
     * Produziert Kisten in der gegebenen Zeit.
     */
    Kiste Produzieren()
    {
        long akt, ende;
        int n;
        akt = System.currentTimeMillis();
        ende = akt + zeit;
        while (akt < ende)
        {
            try
            {
                wait(ende - akt);
            }
            catch (Exception e)
            {
            }
            akt = System.currentTimeMillis();
        }
        n = ++nummer;
        System.out.println("Kiste Nummer " + n + " produziert.");
        return new Kiste(n);
    }
}
