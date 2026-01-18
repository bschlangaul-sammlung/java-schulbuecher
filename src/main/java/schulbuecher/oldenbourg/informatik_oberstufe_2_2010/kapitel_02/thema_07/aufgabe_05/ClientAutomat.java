package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_05;

/**
 * Arbeitet das Protokoll auf der Klientseite ab.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ClientAutomat
{
    private enum Zustaende
    {
        start, aktionWaehlen, dateinameSchicken, dateinameHolen, schicken,
        holen, beenden
    };

    private Zustaende zustand;

    private Verbindung verb;

    private NetzwerkClient client;

    private Eingabe ein;

    private DateiLesen in;

    private DateiSchreiben out;

    /**
     * Belegt die Attribute.
     *
     * @param client das Verbindungsobjekt
     */
    ClientAutomat(NetzwerkClient client)
    {
        zustand = Zustaende.start;
        this.client = client;
        ein = new Eingabe();
    }

    /**
     * Der eigentliche Automat zum Abbarbeiten der Verbindung.
     */
    void Arbeiten()
    {
        String text;
        text = "";
        while (true)
        {
            switch (zustand)
            {
            case start:
                text = ein.TextLesen("Bitte den Hostnamen eingeben.");
                verb = client.Oeffnen(text);
                if (verb != null)
                {
                    zustand = Zustaende.aktionWaehlen;
                }
                break;

            case aktionWaehlen:
                text = ein.TextLesen(
                        "Bitte die gewünschte Aktion (schicken, holen, beenden) eingeben.");
                if (text.equals("schicken"))
                {
                    verb.ZeileSenden("schicken");
                    VerstandenTesten();
                    zustand = Zustaende.dateinameSchicken;
                }
                else if (text.equals("holen"))
                {
                    verb.ZeileSenden("holen");
                    VerstandenTesten();
                    zustand = Zustaende.dateinameHolen;
                }
                else if (text.equals("beenden"))
                {
                    verb.ZeileSenden("beenden");
                    zustand = Zustaende.beenden;
                }
                else
                {
                    System.out.println("Ungültige Eingabe: " + text);
                }
                break;

            case dateinameSchicken:
                text = ein.TextLesen(
                        "Bitte den Namen der zu schickenden Datei eingeben.");
                in = new DateiLesen();
                if (in.Oeffnen(text))
                {
                    zustand = Zustaende.schicken;
                }
                else
                {
                    System.out.println(
                            "Konnte die Datei nicht \u00F6ffnen: " + text);
                    in = null;
                    zustand = Zustaende.aktionWaehlen;
                }
                break;

            case schicken:
                verb.ZeileSenden(text);
                VerstandenTesten();
                verb.ZeileSenden("*");
                while (true)
                {
                    text = in.PaketLesen();
                    if (text == null)
                    {
                        break;
                    }
                    verb.ZeileSenden(text);
                }
                in.Schliessen();
                verb.ZeileSenden("*");
                VerstandenTesten();
                System.out.println("Dateiübertragung beendet.");
                in = null;
                zustand = Zustaende.beenden;
                break;

            case dateinameHolen:
                text = ein.TextLesen(
                        "Bitte den Namen der zu holenden Datei eingeben.");
                out = new DateiSchreiben();
                if (out.Oeffnen(text))
                {
                    zustand = Zustaende.holen;
                }
                else
                {
                    System.out
                            .println("Konnte die Datei nicht anlegen: " + text);
                    out = null;
                    zustand = Zustaende.aktionWaehlen;
                }
                break;

            case holen:
                verb.ZeileSenden(text);
                MarkeTesten();
                while (true)
                {
                    text = verb.ZeileLesen();
                    if (text.equals("*"))
                    {
                        break;
                    }
                    out.PaketSchreiben(text);
                }
                out.Schliessen();
                verb.ZeileSenden("verstanden");
                System.out.println("Dateiübertragung beendet.");
                out = null;
                zustand = Zustaende.beenden;
                break;

            case beenden:
                client.Schliessen();
                System.exit(1);
            }
        }
    }

    /**
     * Testet, ob der Partner verstanden meldet.
     */
    private void VerstandenTesten()
    {
        String text;
        text = verb.ZeileLesen();
        if (!text.equals("verstanden"))
        {
            System.out.println("Protokollverletzung: verstanden erwartet, "
                    + text + " empfangen");
        }
    }

    /**
     * Testet, ob der Partner eine Marke gesendet hat.
     */
    private void MarkeTesten()
    {
        String text;
        text = verb.ZeileLesen();
        if (!text.equals("*"))
        {
            System.out.println(
                    "Protokollverletzung: * erwartet, " + text + " empfangen");
        }
    }
}
