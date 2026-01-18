package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_angestellter;

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
     * Behandelt die Objektauswahl
     *
     * @param objekt der ausgewählte Objekteintrag
     */
    void ObjektAuswaehlen(Object objekt);

    /**
     * Behandelt die Kundenauswahl
     *
     * @param kunde der ausgewählte Kunde
     */
    void KundeAuswaehlen(Object kunde);

    /**
     * Behandelt die Auswahl der Dialogseite
     *
     * @param n der ausgewählte Objekteintrag
     */
    void TabAuswaehlen(String n);

    /**
     * Veranlasst das Eintragen eines neuen Landes.
     *
     * @param name Name des neuen Landes
     */
    void LandEintragen(String name);

    /**
     * Veranlasst das Anlegen eines neuen Objekts mit den gegebenen Daten.
     *
     * @param name Name des Objekts
     * @param groesse Wohnfläche des Objekts
     * @param zimmer Anzahl der Zimmer
     * @param personen Maximale Anzahl der Personen
     * @param land Beschreibung des Landes
     * @param art "Wohnung" oder "Haus"
     * @param preis Wochenpreis
     * @param gesperrt Buchungssperre
     * @param ausstattungen Zusatzausstattungen
     */
    void NeuesObjektAnlegen(String name, int groesse, int zimmer, int personen,
            Object land, String art, double preis, boolean gesperrt,
            boolean[] ausstattungen);

    /**
     * Veranlasst das ändern eines Objekts mit den gegebenen Daten.
     *
     * @param nummer Schlüssel des Objekts
     * @param name Name des Objekts
     * @param groesse Wohnfläche des Objekts
     * @param zimmer Anzahl der Zimmer
     * @param personen Maximale Anzahl der Personen
     * @param land Beschreibung des Landes
     * @param art "Wohnung" oder "Haus"
     * @param preis Wochenpreis
     * @param gesperrt Buchungssperre
     * @param ausstattungen Zusatzausstattungen
     */
    void ObjektAendern(int nummer, String name, int groesse, int zimmer,
            int personen, Object land, String art, double preis,
            boolean gesperrt, boolean[] ausstattungen);

    /**
     * Veranlasst das Löschen des angegebenen Objekts.
     *
     * @param nummer Schlüssel des Objekts
     */
    void ObjektLoeschen(int nummer);

    /**
     * Veranlasst das Anlegen eines neuen Kunden mit den gegebenen Daten.
     *
     * @param name Name des Kunden
     * @param vorname Vorname des Kunden
     */
    void NeuenKundenAnlegen(String name, String vorname);

    /**
     * Veranlasst das ändern eines Kunden mit den gegebenen Daten.
     *
     * @param benutzername Schlüssel des Kunden
     * @param name Name des Kunden
     * @param vorname Vorname des Kunden
     */
    void KundenAendern(String benutzername, String name, String vorname);

    /**
     * Veranlasst das Löschen des angegebenen Kunden.
     *
     * @param benutzername Schlüssel des Kunden
     */
    void KundenLoeschen(String benutzername);

    /**
     * Veranlasst das Setzen des Passworts für den angegebenen Kunden.
     *
     * @param benutzername Schlüssel des Kunden
     * @param pass das Passwort des Kunden
     */
    void PasswortSetzen(String benutzername, String pass);

    /**
     * Veranlasst das Holen aller Buchungen zum angegebenen Objekt.
     *
     * @param objekt Beschreibung des Objekts
     */
    void BuchungenFuerObjektHolen(Object objekt);

    /**
     * Veranlasst das Holen aller Buchungen des angegebenen Kunden.
     *
     * @param kunde Beschreibung des Kunden
     */
    void BuchungenFuerKundeHolen(Object kunde);

    /**
     * Veranlasst das Löschen der angegebenen Buchung.
     *
     * @param buchung Beschreibung der Buchung
     */
    void BuchungLoeschen(Object buchung);

    /**
     * Veranlasst das Umwandeln einer Reservierung in eine feste Buchung.
     *
     * @param buchung Beschreibung der Buchung
     */
    void ReservierungBuchen(Object buchung);

    /**
     * Beendet die Ausführung des Programms
     */
    void Beenden();
}
