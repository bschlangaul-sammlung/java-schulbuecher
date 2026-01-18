package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Abstraktes Element einer Liste
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
abstract class LISTENELEMENT
{
    /**
     * Der Konstruktor ist nur der Vollständigkeit halber angegeben.
     */
    LISTENELEMENT()
    {
        // (noch) nichts zu tun
    }

    /**
     * Fügt ein Datenelement sortiert in die Liste ein.
     *
     * @param daten Referenz auf das einzufügende Datenelement
     *
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    abstract LISTENELEMENT Einfuegen(DATENELEMENT daten);

    /**
     * Löscht das angegebene Element aus der Liste.
     *
     * @param welches Referenz auf das zu löschende Element
     *
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    abstract LISTENELEMENT Loeschen(DATENELEMENT welches);

    /**
     * Sucht das Datenelement mit dem in test angegebenen Schlüssel. Nutzt die
     * Sortierung der Liste aus.
     *
     * @param test Schlüssel des zu suchenden Datenelements
     *
     * @return Referenz auf das gefundene Datenelement oder null
     */
    abstract DATENELEMENT Suchen(DATENELEMENT test);

    /**
     * Meldet das nächste Datenelement für den Listendurchlauf.
     *
     * @return nächstes Element
     */
    abstract LISTENELEMENT Naechstes();

    /**
     * Gibt die Datenreferenz dieses Elements.
     *
     * @return Datenreferenz
     */
    abstract DATENELEMENT DatenGeben();
}
