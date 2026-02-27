package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_05.teilaufgabe_b.erzeuger_verbraucher;

import schulbuecher.cornelsen.shared.graphics_and_games.Figur;

/**
 * Verbraucher von Kisten.
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Verbraucher extends Thread
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
     * Die Darstellung des Verbrauchers
     **/
    private VerbraucherSymbol verbraucherSymbol;

    /**
     * Konstruktor für Objekte der Klasse Verbraucher
     *
     * @param zeitNeu Ablagezeit für die Kisten
     * @param speicherNeu der Speicher, aus dem geholt werden soll
     */
    Verbraucher(int zeitNeu, Speicher speicherNeu)
    {
        zeit = zeitNeu;
        speicher = speicherNeu;
        verbraucherSymbol = new VerbraucherSymbol();
    }

    /**
     * Die Arbeitsmethode des Threads.
     */
    @Override
    public void run()
    {
        Kiste kNeu;

        while (true)
        {
            LeerHinDarstellen();
            kNeu = speicher.Holen();

            while (kNeu == null)
            {
                LeerZurückDarstellen();
                LeerHinDarstellen();
                kNeu = speicher.Holen();
            }
            BeladenZurückDarstellen();
            Einlagern(kNeu);
        }
    }

    /**
     * Lagert Kisten in der gegebenen Zeit.
     *
     * @param kisteNeu die zu lagernde Kiste
     */
    private void Einlagern(Kiste kisteNeu)
    {
        for (int zähler = 0; zähler < 10; zähler++)
        {
            kisteNeu.SichtbarkeitSetzen(true);
            kisteNeu.PositionSetzen(625 + 5 * (zähler + 1), 200);
            kisteNeu.GrößeSetzen(50 - 5 * (zähler + 1), 50);

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
     * Stellt den Verbraucher ohne Kiste auf dem Weg zum Abholplatz dar.
     */
    private void LeerHinDarstellen()
    {
        verbraucherSymbol.FigurOhneKisteFestlegen();
        for (int i = 0; i < 10; i++)
        {
            verbraucherSymbol.LeerHin((float) i / 9);
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
     * Stellt den Verbraucher ohne Kiste auf dem Weg vom Abholplatz zurück dar.
     */
    private void LeerZurückDarstellen()
    {
        verbraucherSymbol.FigurOhneKisteFestlegen();
        for (int i = 0; i < 10; i++)
        {
            verbraucherSymbol.LeerZurück((float) i / 9);
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
     * Stellt den Verbraucher mit Kiste auf dem Weg vom Abholplatz zurück dar.
     */
    private void BeladenZurückDarstellen()
    {
        verbraucherSymbol.FigurMitKisteFestlegen();
        for (int i = 0; i < 10; i++)
        {
            verbraucherSymbol.BeladenZurück((float) i / 9);
            try
            {
                Thread.sleep(zeit / 10);
            }
            catch (InterruptedException e)
            {
            }
        }
        verbraucherSymbol.FigurOhneKisteFestlegen();
    }

    /**
     * Darstellung des Verbrauchers
     *
     * @author Johannes Neumeyer
     *
     * @version 1.0
     */
    class VerbraucherSymbol extends Figur
    {
        /**
         * Erzeugt das Symbol in Startstellung
         */
        VerbraucherSymbol()
        {
            FigurOhneKisteFestlegen();
            GrößeSetzen(100);
            PositionSetzen(525, 225);
            LeerZurück(1);
        }

        /**
         * Schwenkt den leeren Verbraucherarm Richtung Ablage
         *
         * @param anteil: Winkelanzeil des Schwenkbereichs
         */
        void LeerHin(float anteil)
        {
            // Anteil an 180° in Winkel umrechnen und Winkel setzen
            int winkel = (int) (160 * anteil);
            WinkelSetzen(winkel);
        }

        /**
         * Schwenkt den leeren Verbraucherarm Richtung Einlagerung
         *
         * @param anteil: Winkelanzeil des Schwenkbereichs
         */
        void LeerZurück(float anteil)
        {
            // Anteil an 180° in Winkel umrechnen und Winkel setzen
            int winkel = (int) (160 - 160 * anteil);
            WinkelSetzen(winkel);
        }

        /**
         * Schwenkt den beladenen Verbraucherarm Richtung Einlagerung
         *
         * @param anteil: Winkelanzeil des Schwenkbereichs
         */
        void BeladenZurück(float anteil)
        {
            // Anteil an 180° in Winkel umrechnen und Winkel setzen
            int winkel = (int) (160 - 160 * anteil);
            WinkelSetzen(winkel);
        }

        /**
         * Erzeugt den Konsumenten mit einer Kiste
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
         * Erzeugt den Konsumenten ohne Kiste
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
