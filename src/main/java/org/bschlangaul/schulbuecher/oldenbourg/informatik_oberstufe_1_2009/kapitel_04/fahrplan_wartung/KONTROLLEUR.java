package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_wartung;

/**
 * Logik der Benutzerführung.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.util.*;

class KONTROLLEUR
{
    private OBERFLAECHE oberflaeche;

    private BAHNHOFSLISTE bahnhoefe;

    private ABSCHNITTSLISTE abschnitte;

    private UMSTEIGELISTE umsteigen;

    private PLANANZEIGE plan;

    private DATENBANKVERBINDUNG verb;

    /**
     * Setzt die Attribute.
     *
     * @param b Bahnhofsliste
     * @param a Abschnittsliste
     * @param u Umsteigeinformationsliste
     * @param p Plananzeigecomponente
     */
    KONTROLLEUR(BAHNHOFSLISTE b, ABSCHNITTSLISTE a, UMSTEIGELISTE u,
            PLANANZEIGE p)
    {
        bahnhoefe = b;
        abschnitte = a;
        umsteigen = u;
        plan = p;
        oberflaeche = null;
        verb = DATENBANKVERBINDUNG.VerbindungGeben();
    }

    /**
     * Setzt die zugehörige Oberfläche.
     *
     * @param o Oberfläche
     */
    void OberflaecheSetzen(OBERFLAECHE o)
    {
        oberflaeche = o;
        oberflaeche.BahnhofsauswahlSetzen(bahnhoefe.NamenslisteGeben());
    }

    /**
     * In der Plananzeige wurde ein Bahnhof ausgewählt.
     */
    void BahnhofGewaehlt()
    {
        BAHNHOF akt;
        akt = plan.AktBahnhofGeben();
        oberflaeche.BahnhofsdatenSetzen("" + akt.XGeben(), "" + akt.YGeben(),
                akt.NameGeben());
        oberflaeche.LinienauswahlUmsteigenSetzen(
                abschnitte.LinienFuerBahnhofGeben(akt.NummerGeben()),
                umsteigen.UmsteigenFuerBahnhofGeben(akt.NummerGeben()));
    }

    /**
     * Fügt einen neuen Bahnhof ein.
     *
     * @param name Name des Bahnhofs
     * @param x x-Koordinate des Bahnhofs
     * @param y y-Koordinate des Bahnhofs
     */
    void NeuenBahnhofEinfuegen(String name, int x, int y)
    {
        BAHNHOF neu;
        neu = new BAHNHOF(0, name, x, y);
        verb.BahnhofEinfuegen(neu);
        bahnhoefe.Einfuegen(neu);
        oberflaeche.BahnhofsauswahlSetzen(bahnhoefe.NamenslisteGeben());
        plan.UmrechnungErmittlen();
        plan.AbschnitteNeuBerechnen();
        plan.invalidate();
        plan.repaint();
    }

    /**
     * ändert die Daten eines Bahnhofs.
     *
     * @param name Name des Bahnhofs
     * @param x x-Koordinate des Bahnhofs
     * @param y y-Koordinate des Bahnhofs
     */
    void BahnhofAendern(String name, int x, int y)
    {
        BAHNHOF akt;
        akt = plan.AktBahnhofGeben();
        akt.DatenSetzen(name, x, y);
        verb.BahnhofAendern(akt);
        plan.UmrechnungErmittlen();
        plan.AbschnitteNeuBerechnen();
        plan.invalidate();
        plan.repaint();
    }

    /**
     * Löscht einen Bahnhof.
     */
    void BahnhofLoeschen()
    {
        BAHNHOF akt;
        akt = plan.AktBahnhofGeben();
        verb.BahnhofLoeschen(akt);
        bahnhoefe.Loeschen(akt);
        plan.UmrechnungErmittlen();
        plan.AbschnitteNeuBerechnen();
        plan.invalidate();
        plan.repaint();
    }

    /**
     * Testet, ob der aktuelle Bahnhof gelöscht werden kann. Es dürfen keine
     * Abschnitte dort beginnen oder enden
     */
    boolean KannAktbahnhofGeloeschtWerden()
    {
        return !abschnitte
                .BahnhofWirdErreicht(plan.AktBahnhofGeben().NummerGeben());
    }

    /**
     * Setzt einen neuen Zielbahnhof für das Einfügen eines neuen Abschnitts.
     *
     * @param index Indexnummer des Bahnhofs
     */
    void ZielbahnhofWaehlen(int index)
    {
        plan.ZielbahnhofSetzen(bahnhoefe.BahnhofMitIndexGeben(index));
    }

    /**
     * In der Plananzeige wurde ein Abschnitt ausgewählt.
     */
    void AbschnittGewaehlt()
    {
        PLANABSCHNITT ab;
        ArrayList<ABSCHNITT> originale;
        String[] werte;
        ab = plan.AktAbschnittGeben();
        originale = ab.OriginaleGeben();
        werte = new String[originale.size()];
        for (int i = 0; i < originale.size(); i++)
        {
            werte[i] = "" + originale.get(i).LinieGeben();
        }
        oberflaeche.LinienauswahlSetzen(werte);
    }

    /**
     * Setzt den ausgewählten Linienabschnitt.
     *
     * @param nummer Nummer der speziellen Linie
     */
    void LinienabschnittSetzen(int nummer)
    {
        for (ABSCHNITT a : plan.AktAbschnittGeben().OriginaleGeben())
        {
            if (a.LinieGeben() == nummer)
            {
                oberflaeche.LinienlaengeSetzen("" + a.LaengeGeben());
            }
        }
    }

    /**
     * Legt einen neuen Abschnitt an.
     *
     * @param linie Nummer der Linie
     * @param laenge Länge des Abschnitts
     */
    void NeuenAbschnittAnlegen(int linie, float laenge)
    {
        int nummer1, nummer2;
        ABSCHNITT neu;
        nummer1 = plan.AktBahnhofGeben().NummerGeben();
        nummer2 = plan.ZielbahnhofGeben().NummerGeben();
        if ((abschnitte.Suchen(linie, nummer1, nummer2) == null)
                && (abschnitte.Suchen(linie, nummer2, nummer1) == null))
        {
            neu = new ABSCHNITT(linie, nummer1, nummer2, laenge);
            abschnitte.Einfuegen(neu);
            verb.AbschnittEinfuegen(neu);
            plan.PlanabschnitteErstellen(abschnitte);
        }
    }

    /**
     * ändert die Länge eines Abschnitts.
     *
     * @param linie Nummer der Linie
     * @param laenge Länge des Abschnitts
     */
    void AbschnittAendern(int linie, float laenge)
    {
        for (ABSCHNITT a : plan.AktAbschnittGeben().OriginaleGeben())
        {
            if (a.LinieGeben() == linie)
            {
                oberflaeche.LinienlaengeSetzen("" + laenge);
                a.LaengeSetzen(laenge);
                verb.AbschnittAendern(a);
            }
        }
    }

    /**
     * Löscht den angegebenen Abschnitt.
     *
     * @param linie Nummer der Linie
     */
    void AbschnittLoeschen(int linie)
    {
        for (ABSCHNITT a : plan.AktAbschnittGeben().OriginaleGeben())
        {
            if (a.LinieGeben() == linie)
            {
                verb.AbschnittLoeschen(a);
                abschnitte.Loeschen(a);
                plan.PlanabschnitteErstellen(abschnitte);
            }
        }
    }

    /**
     * Fügt eine neue Umsteugemöglichkeit ein.
     *
     * @param von von welcher Linie
     * @param nach nach welcher Linie
     */
    void UmsteigenEinfuegen(int von, int nach)
    {
        UMSTEIGEINFO neu;
        if (von != nach)
        {
            neu = new UMSTEIGEINFO(plan.AktBahnhofGeben().NummerGeben(), von,
                    nach);
            if (umsteigen.Suchen(neu) == null)
            {
                umsteigen.Einfuegen(neu);
                verb.UmsteigenEinfuegen(neu);
                oberflaeche.LinienauswahlUmsteigenSetzen(
                        abschnitte.LinienFuerBahnhofGeben(neu.BahnhofGeben()),
                        umsteigen
                                .UmsteigenFuerBahnhofGeben(neu.BahnhofGeben()));
            }
        }
    }

    /**
     * Löscht die angegebene Umsteigeinformation aus der Liste und der
     * Datenbank.
     *
     * @param index Index des zo löschenden Eintrags
     */
    void UmsteigenLoeschen(int index)
    {
        UMSTEIGEINFO alt;
        alt = umsteigen.UmsteigeinfoMitIndexGeben(index,
                plan.AktBahnhofGeben().NummerGeben());
        if (alt != null)
        {
            umsteigen.Loeschen(alt);
            verb.UmsteigenLoeschen(alt);
            oberflaeche.LinienauswahlUmsteigenSetzen(
                    abschnitte.LinienFuerBahnhofGeben(alt.BahnhofGeben()),
                    umsteigen.UmsteigenFuerBahnhofGeben(alt.BahnhofGeben()));
        }
    }

    /**
     * Beendet das Programm.
     */
    void Beenden()
    {
        DATENBANKVERBINDUNG.VerbindungGeben().VerbindungBeenden();
        System.exit(1);
    }
}
