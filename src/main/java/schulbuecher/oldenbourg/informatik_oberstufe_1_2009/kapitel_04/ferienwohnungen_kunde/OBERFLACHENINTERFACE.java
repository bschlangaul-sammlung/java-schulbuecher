package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_kunde;

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
     * Stauts der Oberfläche
     */
    enum Status
    {
        anmleden, auswaehlen
    };

    /**
     * Setzt die Oberfläche auf den angegebenen Status.
     *
     * @param status der zu setzende Status
     */
    void StatusSetzen(Status status);

    /**
     * Setzen der Statuszeile durch den Kontrolleur
     *
     * @param text der Anzeigetext;
     */
    void StatuszeileSetzen(String text);

    /**
     * Besetzt das Auswahlmenü mit den Länderdaten
     *
     * @param daten Feld mit den Länderinformationen
     * @param keines Symbol für "keine Angabe"
     */
    void LaenderSetzen(Object[] daten, Object keines);

    /**
     * Besetzt die Liste der gefundenen Objekte
     *
     * @param daten Feld mit den Objektinformationen
     */
    void AuswahllisteSetzen(Object[] daten);

    /**
     * Setzt die Information für das ausgewählte Objekt
     *
     * @param name Name und Land des Objekts
     * @param info Größeninformation
     * @param ausstattungen Ausstattungsinformation
     * @param belegt Buchungen im angegebenen Zeitraum
     */
    void ObjektinfoSetzen(String name, String info, String ausstattungen,
            String belegt);

    /**
     * Besetzt die Liste der reservierten Objekte
     *
     * @param daten Feld mit den Reservierungsinformationen
     */
    void ReservierungslisteSetzen(Object[] daten);
}
