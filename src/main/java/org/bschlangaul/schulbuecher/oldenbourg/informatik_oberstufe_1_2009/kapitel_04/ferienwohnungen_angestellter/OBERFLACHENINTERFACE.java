package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_angestellter;

/**
 * Interface für die Oberfläche eines Angestellten.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
interface OBERFLACHENINTERFACE
{
    /**
     * Besetzt alle Anzeigeelemente mit Länderdaten
     *
     * @param daten Feld mit den Länderinformationen
     */
    void LaenderSetzen(Object[] daten);

    /**
     * Besetzt das Auswahlmenü mit Objektdaten
     *
     * @param daten Feld mit den Objektinformationen
     */
    void ObjekteSetzen(Object[] daten);

    /**
     * Besetzt die Anzeigeelemente für ein bestimmtes Objekt.
     *
     * @param nummer die Objektnummer
     * @param name Name des Objekts
     * @param groesse Objektgröße in qm
     * @param zimmer Anzahl der Zimmer
     * @param personen Anzahl der Personen
     * @param landinfo Infoobjekt für das Land des Objekts
     * @param a Art des Objekts
     * @param p Preis des Objekts
     * @param sperr Sperrinformation für dieses Objekt
     * @param aus Feld mit der Ausstattunsinformation
     */
    void ObjektInfoSetzen(int nummer, String name, int groesse, int zimmer,
            int personen, Object landinfo, String a, double p, boolean sperr,
            boolean[] aus);

    /**
     * Besetzt das Auswahlmenü mit Kundendaten
     *
     * @param daten Feld mit den Kundeninformationen
     */
    void KundenSetzen(Object[] daten);

    /**
     * Besetzt die Anzeigeelemente für einen bestimmten Kunden.
     *
     * @param benutzername der Benutzername des Kunden
     * @param name Name
     * @param vorname Vorname
     */
    void KundenInfoSetzen(String benutzername, String name, String vorname);

    /**
     * Wählt im Objektmenü das angegebene Objekt aus
     *
     * @param obj das auszuwählende Objekt
     */
    void ObjektWaehlen(Object obj);

    /**
     * Wählt im Kundenmenü den angegebenen Kunden aus
     *
     * @param kunde der auszuwählende Kunde
     */
    void KundeWaehlen(Object kunde);

    /**
     * Besetzt die Liste der Buchungen
     *
     * @param daten Feld mit den Buchungsinformationen
     */
    void BuchungenSetzen(Object[] daten);
}
