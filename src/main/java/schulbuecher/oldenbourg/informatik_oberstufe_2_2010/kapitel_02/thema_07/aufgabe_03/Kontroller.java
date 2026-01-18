package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_03;

/**
 * Der Kontrolleur.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Kontroller
{
    private Spieler pac;

    private FigurenThread[] threads;

    /**
     * Constructor for objects of class KONTROLLER
     */
    Kontroller(Spieler pac, FigurenThread[] threads)
    {
        this.pac = pac;
        this.threads = threads;
    }

    /**
     * Startet die Threads
     */
    void Starten()
    {
        for (int i = 0; i < threads.length; i++)
        {
            threads[i].start();
        }
    }

    /**
     * Beendet das Programm
     */
    void Beenden()
    {
        System.exit(0);
    }

    /**
     * Verarbeitet die eingegebenen Zeichen.
     *
     * @param ch das Zeichen
     */
    void ZeichenVerarbeiten(char ch)
    {
        switch (ch)
        {
        case 'W':
        case 'w':
            pac.RichtungSetzen('N');
            break;

        case 'X':
        case 'x':
            pac.RichtungSetzen('S');
            break;

        case 'A':
        case 'a':
            pac.RichtungSetzen('W');
            break;

        case 'D':
        case 'd':
            pac.RichtungSetzen('O');
            break;

        default:
            // Nichts zu tun.
        }
    }
}
