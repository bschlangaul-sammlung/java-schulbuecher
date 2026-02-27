package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_05.teilaufgabe_b.erzeuger_verbraucher;

import schulbuecher.cornelsen.shared.graphics_and_games.Figur;

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
     * Die Produktionszeit pro Kiste in Millisekunden
     */
    private int zeit;

    /**
     * Der Zwischenspeicher
     */
    private Speicher speicher;

    /**
     * Die Darstellung des Erzeugers
     **/
    private ErzeugerSymbol erzeugerSymbol;

    /**
     * Laufende Nummer der produzierten Kisten
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
        erzeugerSymbol = new ErzeugerSymbol();
    }

    /**
     * Die Arbeitsmethode des Threads.
     */
    @Override
    public void run()
    {
        Kiste kNeu;
        boolean abgelegt;

        while (true)
        {
            kNeu = Produzieren();
            abgelegt = false;

            BeladenHinDarstellen();
            abgelegt = speicher.Ablegen(kNeu);

            while (!abgelegt)
            {
                BeladenZurückDarstellen();
                BeladenHinDarstellen();
                abgelegt = speicher.Ablegen(kNeu);
            }
            LeerZurückDarstellen();
        }
    }

    /**
     * Produziert Kisten in der gegebenen Zeit.
     *
     * @return die neue Kiste
     */
    private Kiste Produzieren()
    {
        nummer = nummer + 1;
        Kiste kNeu;
        kNeu = new Kiste(nummer);

        kNeu.PositionSetzen(125, 200);

        for (int zähler = 0; zähler < 10; zähler++)
        {
            kNeu.GrößeSetzen(5 * (zähler + 1), 50);

            try
            {
                Thread.sleep(zeit / 10);
            }
            catch (InterruptedException e)
            {
            }

        }

        kNeu.SichtbarkeitSetzen(false);
        return kNeu;
    }

    /**
     * Stellt den Erzeuger mit Kiste auf dem Weg zum Ablegeplatz dar.
     */
    private void BeladenHinDarstellen()
    {
        erzeugerSymbol.FigurMitKisteFestlegen();
        for (int i = 0; i < 10; i++)
        {
            erzeugerSymbol.BeladenHin((float) i / 9);
            try
            {
                Thread.sleep(zeit / 10);
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    /**
     * Stellt den Erzeuger mit Kiste auf dem Weg vom Ablegeplatz zurück dar.
     */
    private void BeladenZurückDarstellen()
    {
        erzeugerSymbol.FigurMitKisteFestlegen();
        for (int i = 0; i < 10; i++)
        {
            erzeugerSymbol.BeladenZurück((float) i / 9);
            try
            {
                Thread.sleep(zeit / 10);
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    /**
     * Stellt den Erzeuger ohne Kiste auf dem Weg vom Ablegeplatz zurück dar.
     */
    private void LeerZurückDarstellen()
    {
        erzeugerSymbol.FigurOhneKisteFestlegen();
        for (int i = 0; i < 10; i++)
        {
            erzeugerSymbol.LeerZurück((float) i / 9);
            try
            {
                Thread.sleep(zeit / 10);
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    /**
     * Darstellung des Erzeugers
     *
     * @author Johannes Neumeyer
     *
     * @version 1.0
     */
    class ErzeugerSymbol extends Figur
    {
        /**
         * Erzeugt das Symbol in Startstellung
         */
        ErzeugerSymbol()
        {
            FigurOhneKisteFestlegen();
            GrößeSetzen(100);
            PositionSetzen(275, 225);
            LeerZurück(1);
        }

        /**
         * Schwenkt den beladenen Erzeugerarm Richtung Ablage
         *
         * @param anteil: Winkelanzeil des Schwenkbereichs
         */
        void BeladenHin(float anteil)
        {
            // Anteil an 180° in Winkel umrechnen und Winkel setzen
            int winkel = (int) (180 - 150 * anteil);
            WinkelSetzen(winkel);
        }

        /**
         * Schwenkt den beladenen Erzeugerarm Richtung Ausgangslage
         *
         * @param anteil: Winkelanzeil des Schwenkbereichs
         */
        void BeladenZurück(float anteil)
        {
            // Anteil an 180° in Winkel umrechnen und Winkel setzen
            int winkel = (int) (150 * anteil + 30);
            WinkelSetzen(winkel);
        }

        /**
         * Schwenkt den beladenen Erzeugerarm Richtung Ausgangslage
         *
         * @param anteil: Winkelanzeil des Schwenkbereichs
         */
        void LeerZurück(float anteil)
        {
            // Anteil an 180° in Winkel umrechnen und Winkel setzen
            int winkel = (int) (150 * anteil + 30);
            WinkelSetzen(winkel);
        }

        /**
         * Erzeugt den Ableger mit einer Kiste
         */
        void FigurMitKisteFestlegen()
        {
            // Bisherige Darstellung löschen
            EigeneFigurLöschen();
            // Figur mit Kiste darstellen
            FigurteilFestlegenRechteck(0, -10, 100, 20, "schwarz");
            FigurteilFestlegenEllipse(-10, -10, 20, 20, "schwarz");
            FigurteilFestlegenRechteck(100, -25, 50, 50, "braun");
        }

        /**
         * Erzeugt den Ableger ohe Kiste
         */
        void FigurOhneKisteFestlegen()
        {
            // Bisherige Darstellung löschen
            EigeneFigurLöschen();
            // Figur ohne Kiste darstellen
            FigurteilFestlegenRechteck(0, -10, 100, 20, "schwarz");
            FigurteilFestlegenEllipse(-10, -10, 20, 20, "schwarz");
        }
    }
}
