package schulbuecher.cornelsen.informatik_5_2023.kapitel_04.thema_05.aufgabe_07.perzeptron_implementieren;

/**
 * Implementierung des Perzeptrons
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public class Perzeptron
{
    // Attribute
    private double w1;

    private double w2;

    private double s;

    private double lernrate;

    /**
     * Konstruktor für Objekte der Klasse Perzeptron
     *
     * @param w1Neu Startwert für Gewicht 1
     * @param w2Neu Startwert für Gewicht 2
     * @param sNeu Startwert für den Schwellenwert
     * @param lernrateNeu Wert der Lernrate
     */
    public Perzeptron(double w1Neu, double w2Neu, double sNeu,
            double lernrateNeu)
    {
        w1 = w1Neu;
        w2 = w2Neu;
        s = sNeu;
        lernrate = lernrateNeu;
    }

    // weitere Methoden
    /**
     * Berechnungsverfahren des Neurons
     *
     * @param x1 Eingabewert 1
     * @param x2 Eingabewert 2
     *
     * @return Ausgabwert
     */
    public double WertBerechnen(double x1, double x2)
    {
        double gewichteteSumme;
        gewichteteSumme = w1 * x1 + w2 * x2 - s;
        if (gewichteteSumme > 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Lernschritt des Neurons
     *
     * @param x1 Eingabewert 1
     * @param x2 Eingabewert 2
     * @param labelwert Wert des Labels (0/1)
     */
    public void Lernschritt(double x1, double x2, double labelwert)
    {
        double berechneterWert = WertBerechnen(x1, x2);
        if (berechneterWert != labelwert)
        // Die Bedingungsprüfung könnte auch entfallen, da im Fall der
        // Gleichheit
        // die Differenz (labelwert-berechneterWert) den Wert 0 annimmt.
        {
            w1 = w1 + lernrate * (labelwert - berechneterWert) * x1;
            w2 = w2 + lernrate * (labelwert - berechneterWert) * x2;
            s = s + lernrate * (labelwert - berechneterWert);
        }
    }
}
