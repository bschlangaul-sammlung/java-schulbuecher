package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_06.aufgabe_04;

/**
 * Der Automat arbeitet das Protokoll ab.
 *
 * @author Albert. Wiedemann
 *
 * @version 1.0
 */
class ServerAutomat
{
    private enum Zustaende
    {
        start, dateinameSchreiben, dateinameLesen, verstandenWarten
    };

    private Zustaende zustand;

    private Verbindung verb;

    /**
     * Belegt die Attribute.
     *
     * @param verb das Verbindungsobjekt
     */
    ServerAutomat(Verbindung verb)
    {
        zustand = Zustaende.start;
        this.verb = verb;
    }

    /**
     * Führt den Transfer durch
     *
     * @return true, falls die Beenden-Anweisung gegeben wurde.
     */
    boolean Uebertragen()
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
                    return true;
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
                return false;

            case dateinameSchreiben:
                zeile = verb.ZeileLesen();
                VerstandenSenden();
                Empfangen(zeile);
                VerstandenSenden();
                return false;
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
