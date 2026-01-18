package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_05.teilaufgabe_c.erzeuger_verbraucher;

import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Verwaltet den Zwischenspeicher und stellt ihn dar.
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Speicher extends Rechteck
{
    /** Gibt an, ob Platz frei ist */
    private boolean frei;

    /** Die eventuell vorhandene Kiste */
    private Kiste kiste;

    /** zur Steuerung der Kistendarstellung */
    private Kiste kistendarstellung;

    /** zählt die Vergleich mit */
    private int vergleiche;

    /**
     * Besetzt die Attribute vor.
     */
    Speicher()
    {
        frei = true;
        kiste = null;
        kistendarstellung = new Kiste(-1);
        kistendarstellung.SichtbarkeitSetzen(false);
        vergleiche = 0;

        GrößeSetzen(50, 10);
        FarbeSetzen("grau");
        PositionSetzen(375, 250);
    }

    /**
     * Versucht, eine Kiste abzulegen und wartet gegebenenfalls.
     *
     * @param kisteNeu die abzulegende Kiste
     */
    synchronized boolean Ablegen(Kiste kisteNeu)
    {
        vergleiche += 1;
        System.out.println("Anzahl Vergleiche: " + vergleiche);

        while (!frei)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
            }
        }

        frei = false;
        kiste = kisteNeu;
        kiste.ImSpeicherDarstellen();
        notify();
        return true;
    }

    /**
     * Versucht, eine Kiste zu holen und wartet gegebenenfalls.
     *
     * @return die geholte Kiste
     */
    synchronized Kiste Holen()
    {
        vergleiche += 1;
        System.out.println("Anzahl Vergleiche: " + vergleiche);

        while (frei)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
            }
        }

        frei = true;
        Kiste kNeu = kiste;
        kiste.SpeicherdarstellungVerbergen();
        kiste = null;
        notify();
        return kNeu;
    }
}
