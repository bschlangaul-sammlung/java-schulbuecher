package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Verwaltet den Graphen für die Verbindungssuche.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class GRAPH
{
    private GKLISTE verbindungen;

    private GKNOTEN startRoute;

    /**
     * Baut den Verbindungsgraphen auf.
     *
     * @param b Liste der Bahnhöfe
     * @param a Liste der Abschnitte
     * @param u Liste der Umsteigemöglichkeiten
     */
    GRAPH(BAHNHOFSLISTE b, ABSCHNITTSLISTE a, UMSTEIGELISTE u)
    {
        ABSCHNITT abschnitt;
        UMSTEIGEINFO uinfo;
        BAHNHOF bahnhof1, bahnhof2;
        GKNOTEN akt1, akt2;
        int linie;
        startRoute = null;
        verbindungen = new GKLISTE();
        a.VorErstesPositionieren();
        while (a.AufNaechstesPositionieren())
        {
            abschnitt = (ABSCHNITT) a.DatenGeben();
            bahnhof1 = b.Suchen(abschnitt.Bahnhof1Geben());
            bahnhof2 = b.Suchen(abschnitt.Bahnhof2Geben());
            linie = abschnitt.LinieGeben();
            akt1 = verbindungen.Suchen(bahnhof1, linie);
            if (akt1 == null)
            {
                akt1 = new GKNOTEN(bahnhof1, linie);
                verbindungen.Einfuegen(akt1);
            }
            akt2 = verbindungen.Suchen(bahnhof2, linie);
            if (akt2 == null)
            {
                akt2 = new GKNOTEN(bahnhof2, linie);
                verbindungen.Einfuegen(akt2);
            }
            akt1.VerbindungEinfuegen(akt2, abschnitt.LaengeGeben());
            akt2.VerbindungEinfuegen(akt1, abschnitt.LaengeGeben());
        }
        u.VorErstesPositionieren();
        while (u.AufNaechstesPositionieren())
        {
            uinfo = (UMSTEIGEINFO) u.DatenGeben();
            bahnhof1 = b.Suchen(uinfo.BahnhofGeben());
            akt1 = verbindungen.Suchen(bahnhof1, uinfo.VonLinieGeben());
            akt2 = verbindungen.Suchen(bahnhof1, uinfo.AbLinieGeben());
            akt1.VerbindungEinfuegen(akt2, 0.00001f);
        }
    }

    /**
     * Ermitteln der kürzesten Route nach Dijkstra.
     *
     * @param start Startbahnhof
     * @param ziel Zielbahnhof
     */
    void WegeSuche(BAHNHOF start, BAHNHOF ziel)
    {
        GKLISTE inArbeit;
        GKLISTE rest;
        LISTE verbindungenLokal;
        GKNOTEN akt, aktZiel;
        VERBINDUNGSINFO info;
        inArbeit = new GKLISTE();
        rest = new GKLISTE();
        startRoute = null;
        verbindungen.VorErstesPositionieren();
        // Alle zum Bahnhof start gehörenden Knoten sind gleichbereichtigte
        // Startmöglichkeiten
        while (verbindungen.AufNaechstesPositionieren())
        {
            akt = (GKNOTEN) verbindungen.DatenGeben();
            akt.VorgaengerSetzen(null);
            akt.GesamtlaengeSetzen(0.0f);
            if (akt.BahnhofGeben() == start)
            {
                inArbeit.Einfuegen(akt);
            }
            else
            {
                rest.Einfuegen(akt);
            }
        }
        // Eigentliche Wegesuche
        while (true)
        {
            akt = null;
            // kürzesten Weg in der Liste der offenen Posten
            inArbeit.VorErstesPositionieren();
            while (inArbeit.AufNaechstesPositionieren())
            {
                if ((akt == null) || (akt
                        .GesamtlaengeGeben() > ((GKNOTEN) inArbeit.DatenGeben())
                                .GesamtlaengeGeben()))
                {
                    akt = (GKNOTEN) inArbeit.DatenGeben();
                }
            }
            // von dort aus die Verbindungen überprüfen
            if (akt != null)
            {
                inArbeit.Loeschen(akt);
                // Der Knoten ist das Ziel, Weg gefunden
                if (akt.BahnhofGeben() == ziel)
                {
                    startRoute = akt;
                    break;
                }
                verbindungenLokal = akt.VerbindungenGeben();
                verbindungenLokal.VorErstesPositionieren();
                while (verbindungenLokal.AufNaechstesPositionieren())
                {
                    info = (VERBINDUNGSINFO) verbindungenLokal.DatenGeben();
                    aktZiel = info.ZielGeben();
                    if (inArbeit.Suchen(aktZiel) != null)
                    {
                        // Knoten ist schon in Arbeit
                        if (aktZiel.GesamtlaengeGeben() > akt
                                .GesamtlaengeGeben() + info.LaengeGeben())
                        {
                            // so geht es schneller
                            aktZiel.VorgaengerSetzen(akt);
                            aktZiel.GesamtlaengeSetzen(akt.GesamtlaengeGeben()
                                    + info.LaengeGeben());
                        }
                    }
                    else if (rest.Suchen(aktZiel) != null)
                    {
                        // Der Knoten war bisher noch nicht erreichbar
                        rest.Loeschen(aktZiel);
                        inArbeit.Einfuegen(aktZiel);
                        aktZiel.VorgaengerSetzen(akt);
                        aktZiel.GesamtlaengeSetzen(
                                akt.GesamtlaengeGeben() + info.LaengeGeben());
                    }
                }
            }
            else
            {
                // Da ist was schief gelaufen
                break;
            }
        }
    }

    /**
     * Baut die Fahrtstrecke als Textfeld auf.
     *
     * @return Feld mit den Stationsbeschreibungen.
     */
    String[] RoutenbeschreibungErstellen()
    {
        return Route(startRoute, 0, 1);
    }

    /**
     * Bout die Route rekursiv auf.
     *
     * @param akt aktueller Knoten
     * @param linie Linie des Nachfolgers
     * @param tiefe Rekursionstiefe für Elementanzahlbestimmung
     */
    private String[] Route(GKNOTEN akt, int linie, int tiefe)
    {
        String[] res;
        String text;
        if (akt.VorgaengerGeben() == null)
        {
            res = new String[tiefe];
        }
        else
        {
            res = Route(akt.VorgaengerGeben(), akt.LinieGeben(), tiefe + 1);
        }
        text = akt.BahnhofGeben().NameGeben() + " (" + akt.LinieGeben() + ")";
        if (linie == 0)
        {
            text = text + " Fahrziel erreicht";
        }
        else if (linie != akt.LinieGeben())
        {
            text = text + " Umsteigen zur Linie " + linie;
        }
        res[res.length - tiefe] = text;
        return res;
    }

    void Print()
    {
        GKNOTEN akt;
        akt = startRoute;
        while (akt != null)
        {
            System.out.println("Bahnhof Nr. " + akt.BahnhofGeben().NummerGeben()
                    + ": " + akt.BahnhofGeben().NameGeben() + " an Linie "
                    + akt.LinieGeben());
            akt = akt.VorgaengerGeben();
        }
    }
}
