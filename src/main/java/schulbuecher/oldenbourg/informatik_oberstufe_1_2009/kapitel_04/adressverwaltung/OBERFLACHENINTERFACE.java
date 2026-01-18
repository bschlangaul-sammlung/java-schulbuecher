package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

/**
 * Interface für die Oberfläche der Adressverwaltung.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
interface OBERFLACHENINTERFACE
{
    /**
     * Besetzt das Auswahlmenü mit Personendaten
     *
     * @param daten Feld mit den Personeninformationen
     */
    void PersonenSetzen(Object[] daten);

    /**
     * Besetzt das Auswahlmenü der Suche mit Personendaten
     *
     * @param daten Feld mit den Personeninformationen
     */
    void PersonenSetzenSuche(Object[] daten);

    /**
     * Besetzt die Anzeigeelemente für eine bestimmte Person.
     *
     * @param name Name der Person
     * @param vorname Vorname der Person
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     * @param nummern Feld mit den Telefonnummern
     * @param emails Feld mit den Emiladressen
     */
    void PersonenInfoSetzen(String name, String vorname, String strasse,
            String hausnummer, String plz, String ort, Object[] nummern,
            Object[] emails);

    /**
     * Besetzt die Anzeigeelemente für eine bestimmte Person.
     *
     * @param name Name der Person
     * @param vorname Vorname der Person
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     * @param nummern Feld mit den Telefonnummern
     * @param emails Feld mit den Emiladressen
     */
    void PersonenInfoSetzenBearbeiten(String name, String vorname,
            String strasse, String hausnummer, String plz, String ort,
            Object[] nummern, Object[] emails);

    /**
     * Besetzt die Anzeigeelemente der Suche für eine bestimmte Person.
     *
     * @param name Name der Person
     * @param vorname Vorname der Person
     * @param strasse Straße
     * @param hausnummer Hausnummer
     * @param plz Postleitzahl
     * @param ort Wohnort
     * @param nummern Feld mit den Telefonnummern
     * @param emails Feld mit den Emiladressen
     */
    void PersonenInfoSetzenSuche(String name, String vorname, String strasse,
            String hausnummer, String plz, String ort, Object[] nummern,
            Object[] emails);

    /**
     * Besetzt die Anzeigeelemente für eine Telefonnummer.
     *
     * @param nummer die Telefonnummer
     * @param notiz Notiz zur Nummer
     * @param art Art der Nummer
     */
    void NummernInfoSetzenBearbeiten(String nummer, String notiz, String art);

    /**
     * Besetzt die Anzeigeelemente für eine EMailadresse.
     *
     * @param adresse die Emailadresse
     * @param notiz Notiz zur Adresse
     */
    void EmailInfoSetzenBearbeiten(String adresse, String notiz);

    /**
     * Setzt die Auswahl im Personenmenue 1
     */
    void PersonenAuswahlSetzen1(Object auswahl);

    /**
     * Setzt die Auswahl im Personenmenue 2 und 3
     */
    void PersonenAuswahlSetzen2(Object auswahl);

    /**
     * Meldungen des Kontrolleurs eintragen.
     *
     * @param text Meldungstext.
     */
    void StatusSetzen(String text);
}
