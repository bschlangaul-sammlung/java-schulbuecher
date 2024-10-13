package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_02.softwaretechnik.aktienhandel;

/**
 * Der Börsenplatz.
 *
 * @author
 * @version 1.0
 */
import java.util.*;

class BOERSE implements STATUSERZEUGER
{
    private DATENBANKVERBINDUNG verbindung;

    private Random zufallsgenerator;

    private STATUSBEOBACHTER beobachter;

    /**
     * Bestimmt die Datenbankverbindung
     */
    BOERSE()
    {
        verbindung = DATENBANKVERBINDUNG.VerbindungGeben();
        zufallsgenerator = new Random();
        beobachter = null;
    }

    /**
     * Registrieren des Stautsbeobachters
     *
     * @param wer der neue Statusbeobachter
     */
    public void Registrieren(STATUSBEOBACHTER wer)
    {
        beobachter = wer;
    }

    /**
     * Setzt die Fehlermeldung an einen Beobachter ab (falls vorhanden)
     *
     * @param text Fehlertext
     */
    private void Fehlermeldung(String text)
    {
        if (beobachter != null)
        {
            beobachter.FehlerSetzen(text);
        }
    }

    /**
     * Kaufen mehrerer Aktien einer bestimmten Art
     *
     * @param aktienID Schlüssel der Aktie
     * @param anzahl Anzahl der zu kaufenden Aktien
     * @param konto Konto, von dem die Aktien bezahlt werden sollen.
     */
    void Kaufen(int aktienID, int anzahl, KONTO konto)
    {
        KURSINFO info;
        double gesamtbetrag;
        info = verbindung.AktuellerKurs(aktienID);
        gesamtbetrag = info.KursGeben() * anzahl;
        if (gesamtbetrag > konto.KontoStandGeben())
        {
            Fehlermeldung("\u00DCberschreitung des Kontostandes");
        }
        else
        {
            konto.Abheben(gesamtbetrag);
            verbindung.KaufEintragen(anzahl, aktienID, info.DatumGeben(),
                    info.KursGeben());
        }
    }

    /**
     * Verkaufen mehrerer Aktien einer bestimmten Art
     *
     * @param aktienID Schlüssel der Aktie
     * @param anzahl Anzahl der zu verkaufenden Aktien
     * @param konto Konto, auf das der Erlös fließen soll.
     */
    void Verkaufen(int aktienID, int anzahl, KONTO konto)
    {
        AKTIENPAKET paket;
        KURSINFO info;
        if (verbindung.AktienAnzahlGeben(aktienID) < anzahl)
        {
            Fehlermeldung("Zu wenig Aktien im Depot");
        }
        else
        {
            info = verbindung.AktuellerKurs(aktienID);
            while (anzahl > 0)
            {
                paket = verbindung.AktienpaketGeben(anzahl, aktienID);
                if (paket == null)
                {
                    paket = verbindung.GroesstesAktienpaketGeben(aktienID);
                    int anz = paket.AnzahlGeben();
                    konto.Einzahlen(anz * info.KursGeben());
                    verbindung.VerkaufEintragen(paket.PaketNummerGeben(),
                            aktienID, anz, 0, paket.KaufDatumGeben(),
                            paket.KaufKursGeben(), info.DatumGeben(),
                            info.KursGeben());
                    anzahl -= anz;
                }
                else
                {
                    konto.Einzahlen(anzahl * info.KursGeben());
                    verbindung.VerkaufEintragen(paket.PaketNummerGeben(),
                            aktienID, anzahl, paket.AnzahlGeben() - anzahl,
                            paket.KaufDatumGeben(), paket.KaufKursGeben(),
                            info.DatumGeben(), info.KursGeben());
                    anzahl = 0;
                }
            }
        }
    }

    /**
     * Ermittelt neue Kurse für die Aktien und trägt sie in die DB ein
     */
    void NeueKurseBestimmen()
    {
        KURSINFO[] infos;
        infos = verbindung.AlleKurseGeben();
        for (int i = 0; i < infos.length; i++)
        {
            infos[i].KursSetzen(Kurssimulator(infos[i].KursGeben()));
        }
        verbindung.NeueKurseEintragen(infos);
    }

    /**
     * Neuer Kurswert, ist zufällig aus dem Intervall +/- 5% um den alten Wert
     *
     * @param kurswert alter Kurswert
     *
     * @return neuer Kurswert
     */
    private double Kurssimulator(double kurswert)
    {
        return kurswert * (1 + (zufallsgenerator.nextDouble() - 0.5) / 10);
    }
}
