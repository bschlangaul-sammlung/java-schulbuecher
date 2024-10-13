package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.fahrradroutenplaner;

/**
 * Berechnet die kürzeste Entfernung von Start nach Ziel. Verwendet den Algorithmus nach E. Dijkstra
 *
 * @author
 * @version 1.0
 */
import java.util.*;

class DIJKSTRA implements STATUSERZEUGER
{
    private LISTE orte;

    private LISTE strecken;

    private ArrayList<STATUSBEOBACHTER> beobachter;

    /**
     * Belegt die Attribute.
     *
     * @param o Liste der Orte;
     * @param s Liste der Strecken
     */
    DIJKSTRA(LISTE o, LISTE s)
    {
        orte = o;
        strecken = s;
        beobachter = new ArrayList<STATUSBEOBACHTER>();
    }

    /**
     * Registriert den Beobachter für die Statusmeldungen
     *
     * @param b der Beobachter
     */
    public void Registrieren(STATUSBEOBACHTER b)
    {
        beobachter.add(b);
    }

    /**
     * Meldet den Status an alle Beobachter.
     *
     * @param text Statustext
     * @param vorgaengerinformation Weginformation
     * @param start Name des Startortes
     * @param ziel Name des Zielortes
     */
    private void StatusMelden(String text, LISTE vorgaengerinformation,
            String start, String ziel)
    {
        for (STATUSBEOBACHTER b : beobachter)
        {
            b.StatusSetzen(text);
            b.WegSetzen(vorgaengerinformation, start, ziel);
        }
    }

    /**
     * Die eigentliche Wegesuche.
     *
     * @param start Startort
     * @param ziel Zielort
     */
    void StreckeSuchen(ORT start, ORT ziel)
    {
        LISTE restOrte, restStrecken, inArbeit, fertig;
        VORGAENGERINFO aktOrt, alt;
        STRECKE aktStrecke;
        ORT neu;
        String name;
        restOrte = orte.Kopieren();
        restOrte.Loeschen(start);
        restStrecken = strecken.Kopieren();
        inArbeit = new LISTE();
        inArbeit.Anfuegen(new VORGAENGERINFO(start, null, 0));
        fertig = new LISTE();
        while (true)
        {
            aktOrt = (VORGAENGERINFO) inArbeit.MinimumSuchen();
            if (aktOrt == null)
            {
                StatusMelden("Keinen Weg gefunden", null, "", "");
                break;
            }
            inArbeit.Loeschen(aktOrt);
            fertig.Anfuegen(aktOrt);
            if (aktOrt.OrtGeben() == ziel)
            {
                StatusMelden(
                        "Der Weg von " + start.NameGeben() + " nach "
                                + ziel.NameGeben() + " ist "
                                + aktOrt.LaengeGeben() + "km lang.",
                        fertig, start.NameGeben(), ziel.NameGeben());
                break;
            }
            while (true)
            {
                name = aktOrt.OrtGeben().NameGeben();
                aktStrecke = (STRECKE) restStrecken.Suchen(name);
                if (aktStrecke == null)
                {
                    break;
                }
                restStrecken.Loeschen(aktStrecke);
                if (aktStrecke.StartortGeben().IstGleich(name))
                {
                    name = aktStrecke.ZielortGeben().NameGeben();
                }
                else
                {
                    name = aktStrecke.StartortGeben().NameGeben();
                }
                neu = (ORT) restOrte.Suchen(name);
                if (neu != null)
                {
                    restOrte.Loeschen(neu);
                    inArbeit.Anfuegen(new VORGAENGERINFO(neu, aktOrt.OrtGeben(),
                            aktOrt.LaengeGeben() + aktStrecke.LaengeGeben()));
                }
                else
                {
                    alt = (VORGAENGERINFO) inArbeit.Suchen(name);
                    if (alt.LaengeGeben() > aktOrt.LaengeGeben()
                            + aktStrecke.LaengeGeben())
                    {
                        alt.LaengeSetzen(aktOrt.LaengeGeben()
                                + aktStrecke.LaengeGeben());
                        alt.VorgaengerSetzen(aktOrt.OrtGeben());
                    }
                }
            }
        }
    }
}
