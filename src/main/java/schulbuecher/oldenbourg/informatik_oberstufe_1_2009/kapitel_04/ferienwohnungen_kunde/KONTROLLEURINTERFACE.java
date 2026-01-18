package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_kunde;

import java.util.Date;

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
     * Meldet den Kunden bei der Objektverwaltung an.
     */
    void Anmelden(String name, String pass);

    /**
     * Sucht alle Objekte mit den angegebenen Daten
     *
     * @param land Land, in dem das Objekt liegt
     * @param art Art des Objekts
     * @param persmin Platz für mindestens persmin Personen
     * @param persmax Platz für maximal persmax Personen
     * @param zimmin minimale Zimmeranzahl
     * @param zimmax maximale Zimmeranzahl
     * @param aus geforderte Ausstattung
     * @param start Beginn des Anzeigezeitraums
     * @param ende Ende des Anzeigezeitraums
     */
    void ObjekteSuchen(Object land, String art, int persmin, int persmax,
            int zimmin, int zimmax, boolean[] aus, Date start, Date ende);

    /**
     * Meldet die Selektion eines Objekts aus der Auswahlliste
     *
     * @param objekt das gewählte Objekt
     * @param start Startdatum des Interessezeitraums
     * @param ende Endedatum des Interessezeitraums
     */
    void ObjektAnzeigen(Object objekt, Date start, Date ende);

    /**
     * Reserviert das angegebene Objekt im angegebenen Zeitraum (wenn frei);
     *
     * @param objekt das gewählte Objekt
     * @param start Startdatum des Interessezeitraums
     * @param ende Endedatum des Interessezeitraums
     */
    void ObjektReservieren(Object objekt, Date start, Date ende);

    /**
     * Bucht die angegebene Reservierung fest
     *
     * @param reservierung die zu buchende Reservierung
     */
    void ObjektBuchen(Object reservierung);

    /**
     * Löscht die angegebene Reservierung
     *
     * @param reservierung die zu löschende Reservierung
     */
    void ReservierungLoeschen(Object reservierung);

    /**
     * Setzt das Passwort des aktuellen Benutzers
     *
     * @param pass das neue Passwort
     */
    void PasswortSetzen(String pass);

    /**
     * Beendet die Ausführung des Programms
     */
    void Beenden();
}
