package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_05.teilaufgabe_d.erzeuger_verbraucher;

/**
 * Erzeuger von Kisten.
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Erzeuger extends Thread
{
    /**
     * Produktionszeit pro Kiste in Millisekunden
     */
    private int zeit;

    /**
     * Zwischenspeicher
     */
    private Speicher speicher;

    /**
     * laufende Nummer der produzierten Kisten
     */
    private int nummer;

    /**
     * Konstruktor für Objekte der Klasse Erzeuger
     *
     * @param zeitNeu Produktionszeit für die Kisten
     * @param speicherNeu der Speicher, in dem abgelegt werden soll
     */
    Erzeuger(int zeitNeu, Speicher speicherNeu)
    {
        zeit = zeitNeu;
        speicher = speicherNeu;
        nummer = 0;
    }

    /**
     * Die Arbeitsmethode des Threads.
     */
    @Override
    public void run()
    {
        while (true)
        {
            Kiste kNeu = Produzieren();
            System.out.println(
                    "Ablegeversuch von Kiste " + kNeu.KistennummerGeben());
            speicher.Ablegen(kNeu);
            System.out.println(
                    "Kiste " + kNeu.KistennummerGeben() + " abgelegt.");
        }

    }

    /**
     * Produziert Kisten in der gegebenen Zeit.
     *
     * @return die neue Kiste
     */
    Kiste Produzieren()
    {
        long akt, ende;
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

        nummer = nummer + 1;
        System.out.println("Kiste Nummer " + nummer + " produziert.");
        return new Kiste(nummer);
    }
}
