package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_02.softwaretechnik.fahrradroutenplaner;

import java.util.ArrayList;

/**
 * Berechnet die kürzeste Entfernung von Start nach Ziel. Verwendet den
 * Algorithmus nach E. Dijkstra
 *
 * @version 1.0
 */
class Dijkstra implements StatusErzeuger
{
    private Liste orte;

    private Liste strecken;

    private ArrayList<StatusBeobachter> beobachter;

    /**
     * Belegt die Attribute.
     *
     * @param o Liste der Orte;
     * @param s Liste der Strecken
     */
    Dijkstra(Liste o, Liste s)
    {
        orte = o;
        strecken = s;
        beobachter = new ArrayList<StatusBeobachter>();
    }

    /**
     * Registriert den Beobachter für die Statusmeldungen
     *
     * @param b der Beobachter
     */
    public void Registrieren(StatusBeobachter b)
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
    private void StatusMelden(String text, Liste vorgaengerinformation,
            String start, String ziel)
    {
        for (StatusBeobachter b : beobachter)
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
    void StreckeSuchen(Ort start, Ort ziel)
    {
        Liste restOrte, restStrecken, inArbeit, fertig;
        Vorgaengerinfo aktOrt, alt;
        Strecke aktStrecke;
        Ort neu;
        String name;
        restOrte = orte.Kopieren();
        restOrte.Loeschen(start);
        restStrecken = strecken.Kopieren();
        inArbeit = new Liste();
        inArbeit.Anfuegen(new Vorgaengerinfo(start, null, 0));
        fertig = new Liste();
        while (true)
        {
            aktOrt = (Vorgaengerinfo) inArbeit.MinimumSuchen();
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
                aktStrecke = (Strecke) restStrecken.Suchen(name);
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
                neu = (Ort) restOrte.Suchen(name);
                if (neu != null)
                {
                    restOrte.Loeschen(neu);
                    inArbeit.Anfuegen(new Vorgaengerinfo(neu, aktOrt.OrtGeben(),
                            aktOrt.LaengeGeben() + aktStrecke.LaengeGeben()));
                }
                else
                {
                    alt = (Vorgaengerinfo) inArbeit.Suchen(name);
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
