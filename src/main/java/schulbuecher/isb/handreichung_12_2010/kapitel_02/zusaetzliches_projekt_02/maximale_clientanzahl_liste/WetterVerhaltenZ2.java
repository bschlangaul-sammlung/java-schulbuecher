package schulbuecher.isb.handreichung_12_2010.kapitel_02.zusaetzliches_projekt_02.maximale_clientanzahl_liste;

/**
 * Diese Klasse implementiert das Serververhalten,<br/>
 * Modifizierte Version von WETTERVERHALTEN2:<br/>
 * In der Methode Holeantwort wird das Endesignal als Antwort auf den Text
 * "toomuchclients" generiert.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class WetterVerhaltenZ2
{
    /**
     * Konstante für den Zustand wartend
     */
    private static final int wartend = 0;

    /**
     * Konstante für den Zustand, nachdem nach dem Namen gefragt wurde
     */
    private static final int namegefragt = 1;

    /**
     * Konstante für den Zustand, nachdem nach einer Stadt gefragt wurde
     */
    private static final int stadtgefragt = 2;

    /**
     * Konstante für den Zustand, nachdem gefragt wurde ob wiederholt werden
     * soll
     */
    private static final int nochmal = 3;

    /**
     * speichert den aktuellen Zustand
     */
    private int zustand = wartend;

    /**
     * Liste mit Städten zum Generieren einer (zufälligen) Wetterauskunft
     */
    private String[] staedte = { "Berlin", "London", "Mailand", "Madrid" };

    /**
     * Liste mit Wetterdaten zum Generieren einer (zufälligen) Wetterauskunft
     */
    private String[] wetter = { "Regen, 4\u00B0C, 996mbar",
            "Sonne, 24\u00B0C, 1050mbar",
            "leicht bew\u00F6lkt, 15\u00B0C, 1013mbar",
            "Schneeregen, -2\u00B0C, 997mbar" };

    /**
     * ermittelt, ob Wetterdaten für die angegebene Stadt vorhanden sind
     *
     * @param gesuchteStadt Name der Stadt, für die nach Wetterdaten gesucht
     *     wird
     *
     * @return wahr, falls Wetterdaten zur angegebenen Stadt gefunden wurden.
     */
    private boolean WetterdatenVorhanden(String gesuchteStadt)
    {
        for (String stadt : staedte)
        {
            if (gesuchteStadt.equals(stadt))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * ermittelt die zu sendende Antwort in Abhängigkeit des Zustands und des
     * Textes, der vom Client übermittelt wurde
     *
     * @param textvomclient der Text, der vom Client an den Server gesendet
     *     wurde.
     *
     * @return den Text, der als Antwort an den Client gesendet wird.
     */
    public String HoleAntwort(String textvomclient)
    {
        String ausgabe = null;
        // unabhängig vom Zustand bei "beenden" immer antworten
        if (textvomclient.equalsIgnoreCase("beenden"))
        {
            return "Server[stopClient]: Auf Wiedersehen!";
        }
        if (textvomclient.equalsIgnoreCase("beende Server"))
        {
            return "Server[stopServer]: Auf Wiedersehen!";
        }
        if (textvomclient.equalsIgnoreCase("toomuchclients"))
        {
            return "Server[stopClient]: maximale Anzahl der Verbindungen erreicht.";
        }
        switch (zustand)
        {
        case wartend:
            ausgabe = "Bereit, bitte geben Sie Ihren Namen ein!";
            zustand = namegefragt;
            break;

        case namegefragt:
            ausgabe = "Hallo " + textvomclient + "!";
            ausgabe += "Geben Sie eine Stadt ein.";
            zustand = stadtgefragt;
            break;

        case stadtgefragt:
            if (WetterdatenVorhanden(textvomclient))
            {
                int i = (int) Math.round(Math.random() * (wetter.length - 1));
                ausgabe = wetter[i];
                zustand = nochmal;
            }
            else
            {
                ausgabe = "Für diese Stadt liegen leider keine Wetterdaten vor!";
            }
            ausgabe = ausgabe
                    + " Wollen Sie eine weitere Stadt abfragen? (Ja)?";
            zustand = nochmal;
            break;

        case nochmal:
            if (textvomclient.equalsIgnoreCase("Ja"))
            {
                ausgabe = "Geben Sie eine Stadt ein:";
                zustand = stadtgefragt;
            }
            else
            {
                zustand = wartend;
                return "Server[stopClient]: Auf Wiedersehen!";
            }
            break;
        }
        return ausgabe;
    }
}
