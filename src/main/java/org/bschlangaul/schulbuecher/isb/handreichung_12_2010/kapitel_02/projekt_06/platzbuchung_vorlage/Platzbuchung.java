package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_06.platzbuchung_vorlage;

/**
 * Diese Klasse implementiert das Serververhalten des Platzbuchungsservers<br/>
 * Vorlage für die Aufgabe 2 des Kapitels 2.3.3<br/>
 * Die Stellen, an denen eine Quelltextergänzung notwendig ist, sind mit
 * "Quelltextergänzung" gekennzeichnet.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Platzbuchung
{
    /**
     * Referenz auf den Server, dort muss nachgefragt werden, ob noch Plätze
     * frei sind
     */
    @SuppressWarnings("unused")
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
        // Quelltextergänzung
        return ausgabe;
    }
}
