package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_03;

/**
 * Verwaltet das gesamte Spiel.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class PacMan
{
    /**
     * Die Welt
     */
    private KarolWelt welt;

    /**
     * Der Spieler
     */
    private Spieler pac;

    /**
     * Die Geister
     */
    private GeistZufall geist1;

    private GeistDirekt geist2;

    /**
     * Die Figurenthreads
     */
    private FigurenThread[] threads;

    /**
     * Legt das Speilfeld und die Basisobjekte an.
     *
     * @param verzoegerung zwischen den Schritten
     */
    PacMan(int verzoegerung)
    {
        Steuerung s;
        welt = new KarolWelt(20, 11, 4);
        pac = new Spieler(1, 1, 'S', welt);
        pac.MarkierungsAnzahlSetzen(WeltAufbauen());
        geist1 = new GeistZufall(11, 6, 'N', welt);
        geist2 = new GeistDirekt(10, 6, 'N', welt, pac);
        threads = new FigurenThread[3];
        threads[0] = new FigurenThread(pac, verzoegerung);
        threads[1] = new FigurenThread(geist1, verzoegerung);
        threads[2] = new FigurenThread(geist2, verzoegerung);
        s = new Steuerung(new Kontroller(pac, threads));
        pac.Registrieren(s);
        geist1.Registrieren(s);
        geist2.Registrieren(s);
    }

    /**
     * Baut die Welt gemäß den Vorgaben auf.
     *
     * @return Markenanzahl
     */
    private int WeltAufbauen()
    {
        int anzahl;
        String[] schema = { "....%........%....", ".%%.%.%%%%%%.%.%%.",
                ".%..............%.", ".%.%%.%%  %%.%%.%.",
                "......%    %......", ".%.%%.%%%%%%.%%.%.",
                ".%..............%.", ".%%.%.%%%%%%.%.%%.",
                "....%........%...." };
        anzahl = 0;
        pac.UnsichtbarMachen();
        pac.VerzoegerungSetzen(0);
        pac.Schritt();
        pac.LinksDrehen();
        pac.LinksDrehen();
        for (int i = 1; i <= 19; i++)
        {
            pac.Hinlegen();
            pac.RechtsDrehen();
            pac.Schritt();
            pac.LinksDrehen();
        }
        pac.Hinlegen();
        pac.LinksDrehen();
        pac.Schritt();
        pac.RechtsDrehen();
        pac.RechtsDrehen();
        for (int i = 1; i <= 9; i++)
        {
            pac.Hinlegen();
            pac.RechtsDrehen();
            pac.Schritt();
            pac.LinksDrehen();
        }
        pac.Hinlegen();
        pac.LinksDrehen();
        pac.Schritt();
        pac.RechtsDrehen();
        pac.RechtsDrehen();
        for (int i = 1; i <= 18; i++)
        {
            pac.Hinlegen();
            pac.RechtsDrehen();
            pac.Schritt();
            pac.LinksDrehen();
        }
        pac.Hinlegen();
        pac.LinksDrehen();
        pac.Schritt();
        pac.RechtsDrehen();
        pac.RechtsDrehen();
        for (int i = 1; i <= 8; i++)
        {
            pac.Hinlegen();
            pac.RechtsDrehen();
            pac.Schritt();
            pac.LinksDrehen();
        }
        pac.Hinlegen();
        pac.LinksDrehen();
        pac.LinksDrehen();
        for (int y = 0; y < schema.length; y++)
        {
            for (int x = 0; x < schema[y].length(); x++)
            {
                switch (schema[y].charAt(x))
                {
                case '%':
                    pac.Schritt();
                    pac.LinksDrehen();
                    pac.LinksDrehen();
                    pac.Hinlegen();
                    pac.LinksDrehen();
                    pac.LinksDrehen();
                    break;

                case '.':
                    pac.MarkeSetzen();
                    anzahl += 1;
                case ' ':
                    if (pac.IstZiegel())
                    {
                        pac.RechtsDrehen();
                        if (!pac.IstZiegel())
                        {
                            pac.Schritt();
                            pac.RechtsDrehen();
                            while (!pac.IstZiegel())
                            {
                                pac.Schritt();
                            }
                            pac.LinksDrehen();
                            pac.LinksDrehen();
                        }
                    }
                    else
                    {
                        pac.Schritt();
                    }
                    break;
                }
            }
        }
        pac.LinksDrehen();
        pac.LinksDrehen();
        for (int i = 1; i <= 4; i++)
        {
            pac.Schritt();
        }
        pac.RechtsDrehen();
        // pac. Aufheben ();
        pac.LinksDrehen();
        pac.LinksDrehen();
        for (int i = 1; i <= 5; i++)
        {
            pac.Schritt();
        }
        pac.LinksDrehen();
        pac.Schritt();
        pac.Schritt();
        pac.RechtsDrehen();
        for (int i = 1; i <= 7; i++)
        {
            pac.Schritt();
        }
        pac.RechtsDrehen();
        pac.Schritt();
        pac.Schritt();
        pac.LinksDrehen();
        for (int i = 1; i <= 5; i++)
        {
            pac.Schritt();
        }
        // pac. Aufheben ();
        pac.LinksDrehen();
        pac.LinksDrehen();
        for (int i = 1; i <= 5; i++)
        {
            pac.Schritt();
        }
        pac.LinksDrehen();
        pac.Schritt();
        pac.Schritt();
        pac.RechtsDrehen();
        for (int i = 1; i <= 4; i++)
        {
            pac.Schritt();
        }
        pac.SichtbarMachen();
        return anzahl;
    }

    /**
     * Startmethode
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args)
    {
        new PacMan(1000);
    }
}
