package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Beschreibt einen Knoten im Verbindungsgraph.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GKNOTEN implements DATENELEMENT
{
    /**
     * Graphdaten
     */
    private BAHNHOF bahnhof;

    private int linie;

    private LISTE verbindungen;

    /**
     * Temporäre Daten der aktuellen Route
     */
    private float gesamtlaenge;

    private GKNOTEN vorgaenger;

    /**
     * Legt die Daten fest.
     *
     * @param bahnhof der Asugangsbahnhof
     * @param linie die abgehende Linie
     */
    GKNOTEN(BAHNHOF bahnhof, int linie)
    {
        this.bahnhof = bahnhof;
        this.linie = linie;
        verbindungen = new LISTE();
        gesamtlaenge = 0.0f;
        vorgaenger = null;
    }

    /**
     * Vergleicht das Datemelement mit dem Parameter.
     *
     * @param test Datenelement mit dem Testschlüssel
     *
     * @return true, wenn die Schlüssel übereinstimmen
     */
    public boolean IstGleich(DATENELEMENT test)
    {
        return ((((GKNOTEN) test).bahnhof == bahnhof)
                && (((GKNOTEN) test).linie == linie));
    }

    /**
     * Vergleicht das Datenemelement mit dem Parameter. <br>
     * Hat das Datenelement einen kleineren Schlüssel als test, ist das Ergebnis
     * -1. <br>
     * Hat das Datenelement den gleichen Schlüssel wie test, ist das Ergebnis 0.
     * <br>
     * Hat das Datenelement einen größeren Schlüssel als test, ist das Ergebnis
     * 1.
     *
     * @param test Datenelement mit dem Testschlüssel
     *
     * @return Vergleichsergebnis
     */
    public int Vergleichen(DATENELEMENT test)
    {
        if (bahnhof.NummerGeben() < ((GKNOTEN) test).bahnhof.NummerGeben())
        {
            return -1;
        }
        else if (bahnhof.NummerGeben() > ((GKNOTEN) test).bahnhof.NummerGeben())
        {
            return 1;
        }
        else
        {
            if (linie < ((GKNOTEN) test).linie)
            {
                return -1;
            }
            else if (linie > ((GKNOTEN) test).linie)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }

    /**
     * Fügt eine neue Verbindung ein.
     *
     * @param ziel Zielknoten im Graph
     * @param laenge Länge des Weges
     */
    void VerbindungEinfuegen(GKNOTEN ziel, float laenge)
    {
        verbindungen.Einfuegen(new VERBINDUNGSINFO(ziel, laenge));
    }

    /**
     * Setzt die Gesamtlänge der Route auf den angegebenen Wert.
     *
     * @param gesamt neue Längeninformation
     */
    void GesamtlaengeSetzen(float gesamt)
    {
        gesamtlaenge = gesamt;
    }

    /**
     * Meldet die Gesamtlänge der Route bis hierher.
     *
     * @return Gesamtlänge
     */
    float GesamtlaengeGeben()
    {
        return gesamtlaenge;
    }

    /**
     * Setzt den Vorgänger in der Route auf den angegebenen Wert.
     *
     * @param vorg neuer Vorgänger
     */
    void VorgaengerSetzen(GKNOTEN vorg)
    {
        vorgaenger = vorg;
    }

    /**
     * Meldet den Vorgänger in der Route.
     *
     * @return Vorgänger
     */
    GKNOTEN VorgaengerGeben()
    {
        return vorgaenger;
    }

    /**
     * Meldet den zugehörigen Bahnhof.
     *
     * @return Bahnhof
     */
    BAHNHOF BahnhofGeben()
    {
        return bahnhof;
    }

    /**
     * Meldet die bediente Linie.
     *
     * @return Linie
     */
    int LinieGeben()
    {
        return linie;
    }

    /**
     * Meldet die Verbindungsliste.
     *
     * @return Verbindungen
     */
    LISTE VerbindungenGeben()
    {
        return verbindungen;
    }
}
