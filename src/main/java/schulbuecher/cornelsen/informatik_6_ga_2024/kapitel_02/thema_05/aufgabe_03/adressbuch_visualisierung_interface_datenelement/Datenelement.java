package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_02.thema_05.aufgabe_03.adressbuch_visualisierung_interface_datenelement;

/**
 * Das Interface Datenelement dient als Schnittstelle zum Speichern von Daten in
 * rekursiven Datenstrukturen. Jedes Datenelement hat ein Schlüsselattribut, auf
 * das eine Ordnungsrelation festgelegt ist Es werden vergleichende Methoden wie
 * IstGleich und IstKleiner ähnlich wie im Java Interface Comperable festgelegt,
 * die für Such- und sortierte Einfügeoperationen in die Datenstrukturen
 * notwendig sind.
 *
 * @author Peter Brichzin
 *
 * @version 30.05.24
 */

interface Datenelement
{
    /**
     * Gibt Information über das Datenelement zu Kontrollzwecken auf das
     * Terminalfenster aus.
     */
    public void InformationAusgeben();

    /**
     * Vergleicht zwei Datenelemente auf Gleichheit.
     *
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn die beiden Datenelemente gleichen Schlüssel haben.
     */
    public boolean IstGleich(Datenelement dvergleich);

    /**
     * Vergleicht zwei Datenelemente bezüglich der Ordnungsrelation.
     *
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als
     *     das eingegebene Datenelement dvergleich.
     */
    public boolean IstGrößerAls(Datenelement dvergleich);

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, auf
     * Gleichheit.
     *
     * @param vergleichsSchlüssel Schlüssel mit dem der Schlüssel des Objekt
     *     verglichen wird.
     *
     * @return true, wenn die beiden Schlüssel gleich sind.
     */
    public boolean SchlüsselIstGleich(String vergleichsSchlüssel);

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der
     * Ordnungsrelation.
     *
     * @param vergleichsSchlüssel Schlüssel mit dem der Schlüssel des Objekt
     *     verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als
     *     das angegebene Vergleichselement.
     */
    public boolean SchlüsselIstGrößerAls(String vergleichsSchlüssel);

    /**
     * Gibt den Wert Schlüssel als String zurück. Diese allgemeine Methode ist
     * nötig, da in den von Datenelement abgeleiteten Klassen nicht ein
     * allgemeines Attribut schluessel vom Typ String existiert, sondern Name
     * und Datentyp Schlüssels frei gewählt werden kann. Diese Methode wird beim
     * Entfernen eines Knotens benötigt.
     *
     * @return Schlüssel als String
     */
    public String SchlüsselAlsStringGeben();
}
