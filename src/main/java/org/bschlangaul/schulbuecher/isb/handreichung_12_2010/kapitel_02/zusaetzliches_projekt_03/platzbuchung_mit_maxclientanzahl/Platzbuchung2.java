package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_02.zusaetzliches_projekt_03.platzbuchung_mit_maxclientanzahl;

/**
 * Diese Klasse implementiert das Serververhalten des Platzbuchungsservers<br/>
 * Falls die maximale Anzahl an Clients erreicht ist, gibt die Methode
 * HoleAntwort Server[stopClient] zurück.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Platzbuchung2
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
    private ServerZ5 server;

    /**
     * Konstruktor der Klasse
     *
     * @param server der Platzbuchungsserver, dessen Methoden
     *     PlaetzeVerfuegbar() und PlaetzeBuchen(int anzahl) benötigt werden.
     */
    public Platzbuchung2(ServerZ5 server)
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
        if (textvomclient.equalsIgnoreCase("toomuchclients"))
        {
            return "Server[stopClient]: maximale Anzahl der Verbindungen erreicht.";
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
