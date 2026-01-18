package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

/**
 * Kontrolleur für die Oberfläche eines Angestellten.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
@SuppressWarnings("unused")
class KONTROLLEUR implements KONTROLLEURINTERFACE
{
    private OBERFLACHENINTERFACE oberflaeche;

    private DATENBANKVERBINDUNG verb;

    private PERSON aktPerson;

    private String tabName;

    private LISTE personenListe;

    private LISTE aktNummern;

    private LISTE aktEmails;

    /**
     * Besetzt die Attribute, insbesondere die Datenbankverbindung
     */
    KONTROLLEUR()
    {
        oberflaeche = null;
        aktPerson = null;
        aktNummern = null;
        aktEmails = null;
        personenListe = new LISTE();
        verb = DATENBANKVERBINDUNG.VerbindungGeben();
        verb.PersonenHolen(personenListe);
    }

    /**
     * Setzt die zu bedienende Oberfläche.
     *
     * @param o Oberfläche
     */
    void OberflaecheSetzen(OBERFLACHENINTERFACE o)
    {
        oberflaeche = o;
        oberflaeche.PersonenSetzen(personenListe.ReferenzenAlsFeldGeben());
    }

    /**
     * Behandelt die Adressauswahl
     *
     * @param objekt der ausgewählte Personeneintrag
     */
    public void EintragAuswaehlen(Object objekt)
    {
        if (objekt != null)
        {
            aktPerson = (PERSON) objekt;
            LISTE nummern, emails;
            nummern = new LISTE();
            emails = new LISTE();
            verb.TelefonnummernHolen(nummern, aktPerson.NummerGeben());
            verb.EMailadressenHolen(emails, aktPerson.NummerGeben());
            oberflaeche.PersonenInfoSetzen(aktPerson.NameGeben(),
                    aktPerson.VornameGeben(), aktPerson.StrasseGeben(),
                    aktPerson.HausnummerGeben(), aktPerson.PlzGeben(),
                    aktPerson.OrtGeben(), nummern.ReferenzenAlsFeldGeben(),
                    emails.ReferenzenAlsFeldGeben());
        }
        else
        {
            oberflaeche.PersonenInfoSetzen("", "", "", "", "", "",
                    new Object[0], new Object[0]);
        }
    }

    /**
     * Behandelt die Adressauswahl für die Bearbeitung
     *
     * @param objekt der ausgewählte Personeneintrag
     */
    public void EintragAuswaehlenBearbeiten(Object objekt)
    {
        if (objekt != null)
        {
            aktPerson = (PERSON) objekt;
            LISTE nummern, emails;
            nummern = new LISTE();
            emails = new LISTE();
            verb.TelefonnummernHolen(nummern, aktPerson.NummerGeben());
            verb.EMailadressenHolen(emails, aktPerson.NummerGeben());
            oberflaeche.PersonenInfoSetzenBearbeiten(aktPerson.NameGeben(),
                    aktPerson.VornameGeben(), aktPerson.StrasseGeben(),
                    aktPerson.HausnummerGeben(), aktPerson.PlzGeben(),
                    aktPerson.OrtGeben(), nummern.ReferenzenAlsFeldGeben(),
                    emails.ReferenzenAlsFeldGeben());
        }
        else
        {
            oberflaeche.PersonenInfoSetzenBearbeiten("", "", "", "", "", "",
                    new Object[0], new Object[0]);
        }
    }

    /**
     * Behandelt die Adressauswahl auf der Suchseite
     *
     * @param objekt der ausgewählte Personeneintrag
     */
    public void EintragAuswaehlenSuche(Object objekt)
    {
        if (objekt != null)
        {
            PERSON p;
            p = (PERSON) objekt;
            LISTE nummern, emails;
            nummern = new LISTE();
            emails = new LISTE();
            verb.TelefonnummernHolen(nummern, p.NummerGeben());
            verb.EMailadressenHolen(emails, p.NummerGeben());
            oberflaeche.PersonenInfoSetzenSuche(p.NameGeben(), p.VornameGeben(),
                    p.StrasseGeben(), p.HausnummerGeben(), p.PlzGeben(),
                    p.OrtGeben(), nummern.ReferenzenAlsFeldGeben(),
                    emails.ReferenzenAlsFeldGeben());
        }
        else
        {
            oberflaeche.PersonenInfoSetzenSuche("", "", "", "", "", "",
                    new Object[0], new Object[0]);
        }
    }

    /**
     * Behandelt die Telefonnummernwahl für die Bearbeitung
     *
     * @param objekt der ausgewählte Telefonnummer
     */
    public void TelefonnummerAuswaehlen(Object objekt)
    {
        if (objekt != null)
        {
            TELEFON t = (TELEFON) objekt;
            oberflaeche.NummernInfoSetzenBearbeiten(t.NummerGeben(),
                    t.NotizGeben(), t.ArtGeben());
        }
    }

    /**
     * Behandelt die Emailwahl für die Bearbeitung
     *
     * @param objekt der ausgewählte Emailadresse
     */
    public void EmailAuswaehlen(Object objekt)
    {
        if (objekt != null)
        {
            EMAIL e = (EMAIL) objekt;
            oberflaeche.EmailInfoSetzenBearbeiten(e.AdresseGeben(),
                    e.NotizGeben());
        }
    }

    /**
     * ändert die Personendaten der aktuellen Person.
     *
     * @param name Name der Person
     * @param vorname Vorname der Person
     */
    public void PersonendatenAendern(String name, String vorname)
    {
        aktPerson.PersonendatenSetzen(name, vorname);
        if (verb.PersonendatenAendern(aktPerson))
        {
            oberflaeche.StatusSetzen("Personendaten ge\u00E4ndert.");
            EintragAuswaehlenBearbeiten(aktPerson);
        }
    }

    /**
     * Löscht die aktuelle Person.
     */
    public void PersonLoeschen()
    {
        personenListe.Loeschen(aktPerson);
        if (verb.PersonLoeschen(aktPerson))
        {
            int res = verb.AdressenBereinigen();
            if (res == 0)
            {
                oberflaeche.StatusSetzen("Person gel\u00F6scht.");
            }
            else
            {
                oberflaeche.StatusSetzen("Person und Adresse gel\u00F6scht.");
            }
            aktPerson = null;
        }
        oberflaeche.PersonenSetzen(personenListe.ReferenzenAlsFeldGeben());
    }

    /**
     * ändert die Personendaten der aktuellen Person.
     *
     * @param name Name der Person
     * @param vorname Vorname der Person
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     * @param nummer die Telefonnummer
     * @param art die Art des Anschlusses
     * @param notiz1 Bemerkung zum Anschluss
     * @param adresse die Emailadresse
     * @param notiz2 Bemerkung zur Adresse
     */
    public void PersonAnlegen(String name, String vorname, String strasse,
            String hausnummer, String plz, String ort, String nummer,
            String art, String notiz1, String adresse, String notiz2)
    {
        PERSON p;
        p = new PERSON(-1, name, vorname, -1, strasse, hausnummer, plz, ort);
        if (verb.AdressdatenAnlegen(p) && verb.PersonAnlegen(p))
        {
            personenListe.Einfuegen(p);
            if (nummer != "")
            {
                verb.TelefonAnlegen(
                        new TELEFON(p.NummerGeben(), -1, nummer, notiz1, art));
            }
            if (adresse != "")
            {
                verb.EmailAnlegen(
                        new EMAIL(p.NummerGeben(), -1, adresse, notiz2));
            }
            oberflaeche.StatusSetzen("Person angelegt.");
            oberflaeche.PersonenSetzen(personenListe.ReferenzenAlsFeldGeben());
        }
    }

    /**
     * ändert die Adressdaten der aktuellen Person.
     *
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     */
    public void AdressdatenAendern(String strasse, String hausnummer,
            String plz, String ort)
    {
        aktPerson.AdresseSetzen(aktPerson.AdressNummerGeben(), strasse,
                hausnummer, plz, ort);
        if (verb.AdressdatenAendern(aktPerson))
        {
            oberflaeche.StatusSetzen("Adressdaten ge\u00E4ndert.");
            EintragAuswaehlenBearbeiten(aktPerson);
        }
    }

    /**
     * Legt die Adressdaten der aktuellen Person neu an.
     *
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     */
    public void AdressdatenAnlegen(String strasse, String hausnummer,
            String plz, String ort)
    {
        aktPerson.AdresseSetzen(-1, strasse, hausnummer, plz, ort);
        if (verb.AdressdatenAnlegen(aktPerson))
        {
            oberflaeche.StatusSetzen("Adressdaten angelegt.");
            EintragAuswaehlenBearbeiten(aktPerson);
        }
    }

    /**
     * übernimmt die Adresse von einer anderen Person.
     *
     * @param person Person, deren Adresse übernommen werden soll.
     */
    public void AdressdatenUebernehmen(Object person)
    {
        PERSON p;
        p = (PERSON) person;
        aktPerson.AdresseSetzen(p.AdressNummerGeben(), p.StrasseGeben(),
                p.HausnummerGeben(), p.PlzGeben(), p.OrtGeben());
        if (verb.AdressdatenUebernehmen(aktPerson))
        {
            oberflaeche.StatusSetzen("Adressdaten übernommen.");
            verb.AdressenBereinigen();
            EintragAuswaehlenBearbeiten(aktPerson);
        }
    }

    /**
     * ändert die Daten des gegebenen Telefoneintrags.
     *
     * @param telefon aktueller Eintrag
     * @param nummer die Telefonnummer
     * @param art die Art des Anschlusses
     * @param notiz Bemerkung zum Anschluss
     */
    public void TelefonAendern(Object telefon, String nummer, String art,
            String notiz)
    {
        TELEFON t = (TELEFON) telefon;
        t.DatenSetzen(nummer, art, notiz);
        if (verb.TelefonAendern(t))
        {
            oberflaeche.StatusSetzen("Telefondaten ge\u00E4ndert.");
            EintragAuswaehlenBearbeiten(aktPerson);
        }
    }

    /**
     * Legt eine Telefonnummer neu an.
     *
     * @param nummer die Telefonnummer
     * @param art die Art des Anschlusses
     * @param notiz Bemerkung zum Anschluss
     */
    public void TelefonAnlegen(String nummer, String art, String notiz)
    {
        TELEFON t = new TELEFON(aktPerson.NummerGeben(), -1, nummer, notiz,
                art);
        if (verb.TelefonAnlegen(t))
        {
            oberflaeche.StatusSetzen("Telefondaten angelegt.");
            EintragAuswaehlenBearbeiten(aktPerson);
        }
    }

    /**
     * Löscht eine Telefonnummer.
     *
     * @param telefon aktueller Eintrag
     */
    public void TelefonLoeschen(Object telefon)
    {
        if (verb.TelefonLoeschen((TELEFON) telefon))
        {
            oberflaeche.StatusSetzen("Telefondaten gel\u00F6scht.");
            EintragAuswaehlenBearbeiten(aktPerson);
        }
    }

    /**
     * ändert die Daten des gegebenen Emaileintrags.
     *
     * @param email aktueller Eintrag
     * @param adresse die Emailadresse
     * @param notiz Bemerkung zur Adresse
     */
    public void EmailAendern(Object email, String adresse, String notiz)
    {
        EMAIL e = (EMAIL) email;
        e.DatenSetzen(adresse, notiz);
        if (verb.EmailAendern(e))
        {
            oberflaeche.StatusSetzen("Emaildaten ge\u00E4ndert.");
            EintragAuswaehlenBearbeiten(aktPerson);
        }
    }

    /**
     * Legt eine Emailadresse neu an.
     *
     * @param adresse die Emailadresse
     * @param notiz Bemerkung zur Adresse
     */
    public void EmailAnlegen(String adresse, String notiz)
    {
        EMAIL e = new EMAIL(aktPerson.NummerGeben(), -1, adresse, notiz);
        if (verb.EmailAnlegen(e))
        {
            oberflaeche.StatusSetzen("Emailadresse angelegt.");
            EintragAuswaehlenBearbeiten(aktPerson);
        }
    }

    /**
     * Löscht eine Emailadresse.
     *
     * @param email aktueller Eintrag
     */
    public void EmailLoeschen(Object email)
    {
        if (verb.EmailLoeschen((EMAIL) email))
        {
            oberflaeche.StatusSetzen("Emailadresse gel\u00F6scht.");
            EintragAuswaehlenBearbeiten(aktPerson);
        }
    }

    /**
     * Behandelt die Auswahl der Dialogseite
     *
     * @param name Name des Tab-Eintrags
     */
    public void TabAuswaehlen(String name)
    {
        tabName = name;
        if (tabName == "Adressen anzeigen")
        {
            if (aktPerson != null)
            {
                oberflaeche.PersonenAuswahlSetzen1(aktPerson);
            }
        }
        else if (tabName == "Daten bearbeiten")
        {
            if (aktPerson != null)
            {
                oberflaeche.PersonenAuswahlSetzen2(aktPerson);
            }
        }
        oberflaeche.StatusSetzen("");
    }

    /**
     * Sucht alle Personen mit gegebenem (Teil-)Vornamen.
     *
     * @param text Vornamensteil
     */
    public void VornamenSuchen(String text)
    {
        LISTE treffer;
        treffer = new LISTE();
        verb.VornamenSuchen(treffer, text);
        oberflaeche.PersonenSetzenSuche(treffer.ReferenzenAlsFeldGeben());
    }

    /**
     * Sucht alle Personen mit gegebener (Teil-)Adresse.
     *
     * @param strasse Strassennamen(steil)
     * @param ort Ort(steil)
     */
    public void AdresseSuchen(String strasse, String ort)
    {
        LISTE treffer;
        treffer = new LISTE();
        verb.AdresseSuchen(treffer, strasse, ort);
        oberflaeche.PersonenSetzenSuche(treffer.ReferenzenAlsFeldGeben());
    }

    /**
     * Sucht alle Personen mit gegebener (Teil-)Telefonnummer.
     *
     * @param text Nummernteil
     */
    public void NummerSuchen(String text)
    {
        LISTE treffer;
        treffer = new LISTE();
        verb.NummerSuchen(treffer, text);
        oberflaeche.PersonenSetzenSuche(treffer.ReferenzenAlsFeldGeben());
    }

    /**
     * Sucht alle Personen mit gegebener (Teil-)EMailadresse.
     *
     * @param text Emailadressenteil
     */
    public void EmailSuchen(String text)
    {
        LISTE treffer;
        treffer = new LISTE();
        verb.EmailSuchen(treffer, text);
        oberflaeche.PersonenSetzenSuche(treffer.ReferenzenAlsFeldGeben());
    }

    /**
     * Beendet die Ausführung des Programms
     */
    public void Beenden()
    {
        verb.VerbindungBeenden();
        System.exit(1);
    }
}
