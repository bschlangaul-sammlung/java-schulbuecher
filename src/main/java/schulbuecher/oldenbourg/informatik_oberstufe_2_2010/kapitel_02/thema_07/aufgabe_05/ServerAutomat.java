package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_05;

/**
 * Der Automat arbeitet das Protokoll ab.
 *
 * @author Albert. Wiedemann
 *
 * @version 1.0
 */
class ServerAutomat extends Thread
{
    private enum Zustaende
    {
        start, dateinameSchreiben, dateinameLesen, verstandenWarten, beenden
    };

    private Zustaende zustand;

    private Verbindung verb;

    private EndeMarkierung ende;

    /**
     * Belegt die Attribute.
     *
     * @param verb das Verbindungsobjekt
     * @param ende Objekt zum Verwalten der Endemarkierung
     */
    ServerAutomat(Verbindung verb, EndeMarkierung ende)
    {
        zustand = Zustaende.start;
        this.verb = verb;
        this.ende = ende;
    }

    /**
     * Führt den Transfer durch
     */
    public void run()
    {
        String zeile;
        while (true)
        {
            switch (zustand)
            {
            case start:
                zeile = verb.ZeileLesen();
                if (zeile.equals("schicken"))
                {
                    zustand = Zustaende.dateinameSchreiben;
                    VerstandenSenden();
                }
                else if (zeile.equals("holen"))
                {
                    zustand = Zustaende.dateinameLesen;
                    VerstandenSenden();
                }
                else if (zeile.equals("beenden"))
                {
                    ende.BeendenSetzen();
                    zustand = Zustaende.beenden;
                }
                break;

            case dateinameLesen:
                zeile = verb.ZeileLesen();
                Senden(zeile);
                zustand = Zustaende.verstandenWarten;
                break;

            case verstandenWarten:
                zeile = verb.ZeileLesen();
                if (!zeile.equals("verstanden"))
                {
                    System.out.println(
                            "Protokollverletzung: verstanden erwartet, " + zeile
                                    + " empfangen");
                }
                zustand = Zustaende.beenden;
            case dateinameSchreiben:
                zeile = verb.ZeileLesen();
                VerstandenSenden();
                Empfangen(zeile);
                VerstandenSenden();
                zustand = Zustaende.beenden;
            case beenden:
                verb.Schliessen();
                return;
            }
        }
    }

    /**
     * Sendet die Verstanden-Botschaft an den Master.
     */
    private void VerstandenSenden()
    {
        verb.ZeileSenden("verstanden");
    }

    /**
     * Sendet die Dateimarke an den Master.
     */
    private void MarkeSenden()
    {
        verb.ZeileSenden("*");
    }

    /**
     * Sendet die Datei mit dem angegebenen Namen zum Master.
     *
     * @param name Dateiname
     */
    private void Senden(String name)
    {
        DateiLesen datei;
        String zeile;
        datei = new DateiLesen();
        MarkeSenden();
        if (datei.Oeffnen(name))
        {
            while (true)
            {
                zeile = datei.PaketLesen();
                if (zeile == null)
                {
                    break;
                }
                verb.ZeileSenden(zeile);
            }
            datei.Schliessen();
        }
        MarkeSenden();
    }

    /**
     * Empfängt die Datei mit dem angegebenen Namen vom Master.
     *
     * @param name Dateiname
     */
    private void Empfangen(String name)
    {
        DateiSchreiben datei;
        String zeile;
        datei = new DateiSchreiben();
        zeile = verb.ZeileLesen();
        if (!zeile.equals("*"))
        {
            System.out.println("Protokollverletzung, '*' erwartet, " + zeile
                    + " empfangen");
        }
        else if (datei.Oeffnen(name))
        {
            while (true)
            {
                zeile = verb.ZeileLesen();
                if (zeile.equals("*"))
                {
                    break;
                }
                datei.PaketSchreiben(zeile);
            }
            datei.Schliessen();
        }
        else
        {
            System.out.println(
                    "Ausgabedatei konnte nicht ge\u00F6ffnet werden: " + name);
        }
        VerstandenSenden();
    }
}
