package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Stellt die Verbindung zwischen View und Modell her.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KONTROLLEUR implements KONTROLLEURINTERFACE
{
    private OBERFLAECHENINTERFACE oberflaeche;

    private BANK bank;

    private KUNDE aktkunde;

    private ANGESTELLTER aktAngestellter;

    private int kontonummer;

    /**
     * Belegt die Attribute
     *
     * @param b die zu kontrollierende Bank
     */
    KONTROLLEUR(BANK b)
    {
        oberflaeche = null;
        bank = b;
        aktkunde = null;
        kontonummer = -1;
        aktAngestellter = null;
    }

    /**
     * Setzt die zugehörige Oberfläche
     *
     * @param o die Oberfläche
     */
    public void OberflaecheSetzen(OBERFLAECHENINTERFACE o)
    {
        oberflaeche = o;
    }

    /**
     * Reagiert auf Beenden-Ereignisse
     */
    public void BeendenAusfuehren()
    {
        bank.Beenden();
        System.exit(1);
    }

    /**
     * Abmelden des Kunden oder Angestellten.
     */
    public void AbmeldenAusfuehren()
    {
        aktkunde = null;
        kontonummer = -1;
        aktAngestellter = null;
        oberflaeche.StatusSetzen(OBERFLAECHENINTERFACE.Status.anmelden);
    }

    /**
     * Versucht, den angegebenen Namen als Kunden anzumelden.
     *
     * @param name Name des Kunden
     * @param pin PIN des Kunden
     */
    public void KundeAnmelden(String name, int pin)
    {
        KUNDE k;
        aktkunde = null;
        aktAngestellter = null;
        k = bank.KundenSuchen(name);
        if (k == null)
        {
            FehlermeldungAbsetzen("Der Kunde '" + name + "' existiert nicht.");
        }
        else
        {
            if (k.PinGeben() == pin)
            {
                aktkunde = k;
                oberflaeche.StatusSetzen(
                        OBERFLAECHENINTERFACE.Status.kundenkontowahl);
            }
            else
            {
                FehlermeldungAbsetzen(
                        "Falsche PIN für den Kunden '" + name + "'.");
            }
        }
    }

    /**
     * Setzt eine neue PIN für den Kunden.
     *
     * @param nummer die neue PIN
     */
    public void KundePinAendern(int nummer)
    {
        aktkunde.PinSetzen(nummer);
    }

    /**
     * Wählt das angegebene Konto des aktuellen Kunden.
     *
     * @param nummer: die Nummer des zu wählenden Kontos
     */
    public void KundeKontoWaehlen(int nummer)
    {
        if (aktkunde.AktkontoSetzen(nummer))
        {
            StatusmeldungAbsetzen("Sie arbeiten mit Konto Nummer: " + nummer);
            kontonummer = nummer;
            oberflaeche.StatusSetzen(
                    OBERFLAECHENINTERFACE.Status.kundenkontoarbeit);
        }
        else
        {
            FehlermeldungAbsetzen("Der Kunde '" + aktkunde.NameGeben()
                    + "' besitzt das Konto " + nummer + " nicht.");
            kontonummer = -1;
        }
    }

    /**
     * Holt die Nummern der verfügbaren Konten des aktuellen Kunden.
     */
    public int[] NummerFuerKundenGeben()
    {
        return bank.KontonummernFuerKundenGeben(aktkunde);
    }

    /**
     * Holt die Nummer des aktuellen Kontos des aktuellen Kunden.
     */
    public int NummerFuerKundenKontoGeben()
    {
        return kontonummer;
    }

    /**
     * Holt den verfügbaren Betrag des aktuellen Kontos des aktuellen Kunden.
     */
    public double BetragFuerKundenKontoGeben()
    {
        return aktkunde.KontostandGeben();
    }

    /**
     * Zahlt den angegebenen Betrag auf das aktuelle Konto des Kunden ein.
     */
    public void KundeKontoEinzahlen(double betrag)
    {
        aktkunde.Einzahlen(betrag);
    }

    /**
     * Hebt den angegebenen Betrag vom aktuellen Konto des Kunden ab.
     */
    public void KundeKontoAbheben(double betrag)
    {
        if (!aktkunde.Abheben(betrag))
        {
            FehlermeldungAbsetzen("Der Betrag von " + betrag
                    + " kann nicht abgehoben werden.");
        }
    }

    /**
     * Holt die Kontoauszüge des akttuellen Kontos des aktuellen Kunden.
     *
     * @return Feld von Texten mit einem Kontoauszug pro Element
     */
    public String[] KundeKontoauszuegeGeben()
    {
        String[] resultat;
        AUSZUGSEINTRAG[] daten;
        daten = aktkunde.AuszugsdatenErstellen();
        if (daten == null)
        {
            resultat = new String[1];
            resultat[0] = "Es liegen keine Auszugsdaten vor";
        }
        else
        {
            resultat = new String[daten.length];
            for (int i = 0; i < daten.length; i++)
            {
                resultat[i] = "Nr " + daten[i].AuszugsnummerGeben() + " am "
                        + daten[i].DatumGeben() + " Zweck: "
                        + daten[i].BeschreibungGeben() + " Betrag: "
                        + daten[i].BetragGeben();
            }
        }
        return resultat;
    }

    /**
     * Lässt das aktuelle Konto des Kunden neu wählen.
     */
    public void KundeKontoNeuWaehlen()
    {
        oberflaeche.StatusSetzen(OBERFLAECHENINTERFACE.Status.kundenkontowahl);
    }

    /**
     * Versucht, den angegebenen Namen als Angestellten anzumelden.
     *
     * @param name Name des Angestellten
     * @param pin PIN des Angestellten
     */
    public void AngestellterAnmelden(String name, int pin)
    {
        ANGESTELLTER a;
        aktkunde = null;
        aktAngestellter = null;
        a = bank.AngestelltenSuchen(name);
        if (a == null)
        {
            FehlermeldungAbsetzen(
                    "Der Angestellte '" + name + "' existiert nicht.");
        }
        else
        {
            if (a.PinGeben() == pin)
            {
                aktAngestellter = a;
                oberflaeche.StatusSetzen(
                        OBERFLAECHENINTERFACE.Status.angestelltensicht);
            }
            else
            {
                FehlermeldungAbsetzen(
                        "Falsche PIN für den Angestellten '" + name + "'.");
            }
        }
    }

    /**
     * Meldet die Namen aller Kunden.
     *
     * @return Stringfeld mit den vorhandenen Kundennamen oder null
     */
    public String[] KundenNamenGeben()
    {
        return bank.KundennamenGeben();
    }

    /**
     * Meldet die Namen aller Angestellten außer "Chef" und dem aktuell
     * angemeldeten Angestellten.
     *
     * @return Stringfeld mit den vorhandenen Angestelltennamen oder null
     */
    public String[] AngestelltenNamenGeben()
    {
        return bank.AngestelltennamenGeben(aktAngestellter);
    }

    /**
     * Wählt einen Kunden als aktuellen Kunden des Angestellten aus.
     *
     * @param name Name des Kunden
     */
    public void AngestellterKundeWaehlen(String name)
    {
        if (aktAngestellter.KundeWaehlen(name))
        {
            oberflaeche.StatusSetzen(
                    OBERFLAECHENINTERFACE.Status.angestelltensicht_kunde);
        }
        else
        {
            FehlermeldungAbsetzen(
                    "Der Kunde " + name + " konnte nicht gew\u00E4hlt werden.");
            oberflaeche.StatusSetzen(
                    OBERFLAECHENINTERFACE.Status.angestelltensicht);
        }
    }

    /**
     * Erzeugt einen Kunden und setzt ihn als aktuellen Kunden des Angestellten.
     *
     * @param name Name des Kunden
     * @param pin PIN des Kunden
     */
    public void KundeErzeugen(String name, int pin)
    {
        if (aktAngestellter.NeuenKundenEinrichten(name, pin))
        {
            AngestellterKundeWaehlen(name);
        }
        else
        {
            if (bank.KundenSuchen(name) != null)
            {
                FehlermeldungAbsetzen("Der Kunde mit dem Namen " + name
                        + " existiert schon.");
            }
            else if (bank.AngestelltenSuchen(name) != null)
            {
                FehlermeldungAbsetzen(
                        "Es existiert schon ein Angestellter mit dem Namen "
                                + name + ".");
            }
            else
            {
                FehlermeldungAbsetzen(
                        "Der Kunde konnte nicht eingerichtet werden.");
            }
        }
    }

    /**
     * Meldet den Namen des aktuellen Kunden.
     *
     * @return name Name des Kunden
     */
    public String NameVonAktkundeGeben()
    {
        return aktAngestellter.AktkundeGeben().NameGeben();
    }

    /**
     * Holt die Nummern der verfügbaren Konten des aktuelle bearbeiteten Kunden
     * eines Angestellten.
     */
    public int[] NummerFuerAktKundenGeben()
    {
        return bank
                .KontonummernFuerKundenGeben(aktAngestellter.AktkundeGeben());
    }

    /**
     * Legt ein neues Sparkonto für den aktuellen Kunden des Angestellten an.
     *
     * @param zins der Zinssatz für das neue Konto
     */
    public void SparkontoEinrichten(double zins)
    {
        int nummer = aktAngestellter.SparkontoEinrichten(zins);
        StatusmeldungAbsetzen("Das neue Konto hat die Nummmer " + nummer);
        oberflaeche.StatusSetzen(
                OBERFLAECHENINTERFACE.Status.angestelltensicht_kunde);
    }

    /**
     * Legt ein neues Girokonto für den aktuellen Kunden des Angestellten an.
     *
     * @param kredit der überziehungsrahmen für das neue Konto
     */
    public void GirokontoEinrichten(double kredit)
    {
        int nummer = aktAngestellter.GirokontoEinrichten(kredit);
        StatusmeldungAbsetzen("Das neue Konto hat die Nummmer " + nummer);
        oberflaeche.StatusSetzen(
                OBERFLAECHENINTERFACE.Status.angestelltensicht_kunde);
    }

    /**
     * Setzt das zu bearbeitende Konto des aktuellen Kunden.
     *
     * @param nummer Nummer des Kontos
     */
    public void KontoFuerAngestelltenSetzen(int nummer)
    {
        aktAngestellter.KontoSetzen(nummer);
        oberflaeche.StatusSetzen(
                OBERFLAECHENINTERFACE.Status.angestelltensicht_kundeundkonto);
        StatusmeldungAbsetzen("Aktuelles Konto: " + nummer);
    }

    /**
     * Löscht das zu bearbeitende Konto des aktuellen Kunden.
     */
    public void KontoLoeschen()
    {
        if (!aktAngestellter.KontoLoeschen())
        {
            FehlermeldungAbsetzen(
                    "Das Konto konnte nicht gel\u00F6scht werden.");
        }
        oberflaeche.StatusSetzen(
                OBERFLAECHENINTERFACE.Status.angestelltensicht_kunde);
        StatusmeldungAbsetzen("Aktueller Kunde: "
                + aktAngestellter.AktkundeGeben().NameGeben());
    }

    /**
     * Holt die Kontoauszüge des aktuellen Kontos des aktuellen Kunden für den
     * Angestellten.
     *
     * @return Feld von Texten mit einem Kontoauszug pro Element
     */
    public String[] KontoauszuegeGeben()
    {
        String[] resultat;
        AUSZUGSEINTRAG[] daten;
        daten = aktAngestellter.AuszugsdatenErstellen();
        if (daten == null)
        {
            resultat = new String[1];
            resultat[0] = "Es liegen keine Auszugsdaten vor";
        }
        else
        {
            resultat = new String[daten.length];
            for (int i = 0; i < daten.length; i++)
            {
                resultat[i] = "Nr " + daten[i].AuszugsnummerGeben() + " am "
                        + daten[i].DatumGeben() + " Zweck: "
                        + daten[i].BeschreibungGeben() + " Betrag: "
                        + daten[i].BetragGeben();
            }
        }
        return resultat;
    }

    /**
     * Löscht den aktuellen Kunden des aktuellen Angestellten.
     */
    public void KundeLoeschen()
    {
        String meldung = aktAngestellter.KundenLoeschen();
        if (meldung == null)
        {
            oberflaeche.StatusSetzen(
                    OBERFLAECHENINTERFACE.Status.angestelltensicht);
            StatusmeldungAbsetzen("Der aktuelle Kunde wurde gel\u00F6scht.");
        }
        else
        {
            oberflaeche.StatusSetzen(
                    OBERFLAECHENINTERFACE.Status.angestelltensicht_kunde);
            StatusmeldungAbsetzen(meldung);
        }
    }

    /**
     * Erzeugt einen Angestellten.
     *
     * @param name Name des Angestellten
     * @param pin PIN des Angestellten
     */
    public void AngestellterErzeugen(String name, int pin)
    {
        if (!aktAngestellter.NeuenAngestelltenEinrichten(name, pin))
        {
            if (bank.AngestelltenSuchen(name) != null)
            {
                FehlermeldungAbsetzen("Der Angestellte mit dem Namen " + name
                        + " existiert schon.");
            }
            else if (bank.KundenSuchen(name) != null)
            {
                FehlermeldungAbsetzen(
                        "Es existiert schon ein Kunde mit dem Namen " + name
                                + ".");
            }
            else
            {
                FehlermeldungAbsetzen(
                        "Der Angestellte konnte nicht eingerichtet werden.");
            }
        }
        oberflaeche
                .StatusSetzen(OBERFLAECHENINTERFACE.Status.angestelltensicht);
    }

    /**
     * Löscht den angegebenen Angestellten.
     *
     * @param name Name des zu löschenden Angestellten.
     */
    public void AngestelltenLoeschen(String name)
    {
        if (aktAngestellter.AngestelltenLoeschen(name))
        {
            StatusmeldungAbsetzen(
                    "Der Angestellte: " + name + " wurde gel\u00F6scht.");
        }
        else
        {
            FehlermeldungAbsetzen("Der Angestellte: " + name
                    + " konnte nicht gel\u00F6scht werden.");
        }
        oberflaeche
                .StatusSetzen(OBERFLAECHENINTERFACE.Status.angestelltensicht);
    }

    /**
     * Verzinst alle Sparkonten.
     */
    public void Verzinsen()
    {
        aktAngestellter.Verzinsen();
    }

    /**
     * Setzt eine Fehlermeldung an die Beobachter ab.
     *
     * @param text der Text der Fehlermeldung
     */
    private void FehlermeldungAbsetzen(String text)
    {
        oberflaeche.FehlermeldungAnzeigen(text);
    }

    /**
     * Setzt eine Statusmeldung an die Beobachter ab.
     *
     * @param text der Text der Statusmeldung
     */
    private void StatusmeldungAbsetzen(String text)
    {
        oberflaeche.StatusmeldungSetzen(text);
    }
}
