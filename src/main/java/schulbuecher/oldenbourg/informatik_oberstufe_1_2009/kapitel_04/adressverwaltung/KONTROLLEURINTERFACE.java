package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

/**
 * Die Schnittstelle des Kontrolleurs zur Oberfläche.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
interface KONTROLLEURINTERFACE
{
    /**
     * Behandelt die Adressauswahl
     *
     * @param objekt der ausgewählte Personeneintrag
     */
    void EintragAuswaehlen(Object objekt);

    /**
     * Behandelt die Auswahl der Dialogseite
     *
     * @param n der ausgewählte Objekteintrag
     */
    void TabAuswaehlen(String n);

    /**
     * Behandelt die Adressauswahl für die Bearbeitung
     *
     * @param objekt der ausgewählte Personeneintrag
     */
    void EintragAuswaehlenBearbeiten(Object objekt);

    /**
     * Behandelt die Adressauswahl auf der Suchseite
     *
     * @param objekt der ausgewählte Personeneintrag
     */
    void EintragAuswaehlenSuche(Object objekt);

    /**
     * Behandelt die Telefonnummernwahl für die Bearbeitung
     *
     * @param objekt der ausgewählte Telefonnummer
     */
    void TelefonnummerAuswaehlen(Object objekt);

    /**
     * Behandelt die Emailwahl für die Bearbeitung
     *
     * @param objekt der ausgewählte Emailadresse
     */
    void EmailAuswaehlen(Object objekt);

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
    void PersonAnlegen(String name, String vorname, String strasse,
            String hausnummer, String plz, String ort, String nummer,
            String art, String notiz1, String adresse, String notiz2);

    /**
     * ändert die Personendaten der aktuellen Person.
     *
     * @param name Name der Person
     * @param vorname Vorname der Person
     */
    void PersonendatenAendern(String name, String vorname);

    /**
     * Löscht die aktuelle Person.
     */
    void PersonLoeschen();

    /**
     * ändert die Adressdaten der aktuellen Person.
     *
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     */
    void AdressdatenAendern(String strasse, String hausnummer, String plz,
            String ort);

    /**
     * Legt die Adressdaten der aktuellen Person neu an.
     *
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     */
    void AdressdatenAnlegen(String strasse, String hausnummer, String plz,
            String ort);

    /**
     * übernimmt die Adresse von einer anderen Person.
     *
     * @param person Person, deren Adresse übernommen werden soll.
     */
    void AdressdatenUebernehmen(Object person);

    /**
     * ändert die Daten des gegebenen Telefoneintrags.
     *
     * @param telefon aktueller Eintrag
     * @param nummer die Telefonnummer
     * @param art die Art des Anschlusses
     * @param notiz Bemerkung zum Anschluss
     */
    void TelefonAendern(Object telefon, String nummer, String art,
            String notiz);

    /**
     * Legt eine Telefonnummer neu an.
     *
     * @param nummer die Telefonnummer
     * @param art die Art des Anschlusses
     * @param notiz Bemerkung zum Anschluss
     */
    void TelefonAnlegen(String nummer, String art, String notiz);

    /**
     * Löscht eine Telefonnummer.
     *
     * @param telefon aktueller Eintrag
     */
    void TelefonLoeschen(Object telefon);

    /**
     * ändert die Daten des gegebenen Emaileintrags.
     *
     * @param email aktueller Eintrag
     * @param adresse die Emailadresse
     * @param notiz Bemerkung zur Adresse
     */
    void EmailAendern(Object email, String adresse, String notiz);

    /**
     * Legt eine Emailadresse neu an.
     *
     * @param adresse die Emailadresse
     * @param notiz Bemerkung zur Adresse
     */
    void EmailAnlegen(String adresse, String notiz);

    /**
     * Löscht eine Emailadresse.
     *
     * @param email aktueller Eintrag
     */
    void EmailLoeschen(Object email);

    /**
     * Sucht alle Personen mit gegebenem (Teil-)Vornamen.
     *
     * @param text Vornamensteil
     */
    void VornamenSuchen(String text);

    /**
     * Sucht alle Personen mit gegebener (Teil-)Adresse.
     *
     * @param strasse Strassennamen(steil)
     * @param ort Ort(steil)
     */
    void AdresseSuchen(String strasse, String ort);

    /**
     * Sucht alle Personen mit gegebener (Teil-)Telefonnummer.
     *
     * @param text Nummernteil
     */
    void NummerSuchen(String text);

    /**
     * Sucht alle Personen mit gegebener (Teil-)EMailadresse.
     *
     * @param text Emailadressenteil
     */
    void EmailSuchen(String text);

    /**
     * Beendet die Ausführung des Programms
     */
    void Beenden();
}
