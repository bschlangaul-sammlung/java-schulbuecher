package schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_06.platzbuchung;

/**
 * Diese Klasse implementiert das Serververhalten des Platzbuchungsservers<br/>
 * Lösung der Aufgabe 2 des Kapitels 2.3.3<br/>
 * Die Stellen, an denen eine Quelltextergänzung notwendig ist, sind mit
 * "Quelltextergänzung" gekennzeichnet.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Platzbuchung
{
    // Zustände
    private static final int wartend = 0;

    private static final int angefragt = 1;

    // Variable für den aktuellen Zustand, zu Beginn gleich WAITING
    private int zustand = wartend;

    /**
     * Referenz auf den Server, dort muss nachgefragt werden, ob noch Plätze
     * frei sind
     */
    private Server4 server;

    /**
     * Konstruktor der Klasse
     *
     * @param server der Platzbuchungsserver, dessen Methoden
     *     PlaetzeVerfuegbar() und PlaetzeBuchen(int anzahl) benötigt werden.
     */
    public Platzbuchung(Server4 server)
    {
        this.server = server;
    }

    /**
     * ermittelt die zu sendende Antwort in Abhängigkeit des Zustands und des
     * Textes, der vom Client übermittelt wurde, nimmt Platzbuchung vor.
     *
     * @param textvomclient der Text, der vom Client an den Server gesendet
     *     wurde.
     *
     * @return den Text, der als Antwort an den Client gesendet wird.
     */
    public String HoleAntwort(String textvomclient)
    {
        String ausgabe = null;
        if (textvomclient.equalsIgnoreCase("beenden"))
        {
            return "Server[stopClient]: beende Client.";
        }
        switch (zustand)
        {
        case wartend:
            if (textvomclient.equalsIgnoreCase("plaetze?"))
            {
                // Plaetze ermitteln, mitteilen
                ausgabe = "Verfuegbare Plaetze: " + server.PlaetzeVerfuegbar();
                zustand = angefragt;
            }
            else
            {
                ausgabe = "Buchungsserver bereit (plaetze?)";
            }
            break;

        case angefragt:
            if (textvomclient.equalsIgnoreCase("buche"))
            {
                // buchen und buchungsergebnis mitteilen
                if (server.PlaetzeBuchen(1))
                {
                    ausgabe = "Platz wurde gebucht, weitere Buchung (plaetze?)";
                }
                else
                {
                    ausgabe = "konnte leider nicht buchen, "
                            + "Platz nicht mehr verfuegbar.";
                }
                zustand = wartend;
            }
            else if (textvomclient.equalsIgnoreCase("plaetze?"))
            {
                ausgabe = "Verfuegbare Plaetze: " + server.PlaetzeVerfuegbar();
            }
            else
            {
                ausgabe = "Buchung mit \"buche\"";
            }
            break;
        }
        return "Server: " + ausgabe;
    }
}
