package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_02.thema_08.aufgabe_03.woerterbuch_mit_testklasse;

/**
 * Das Interface DATENELEMENT dient als Schnittstelle zum Speichern von Daten in
 * rekursiven Datenstrukturen. Jedes Datenelement hat ein Schlüsselattribut, auf
 * das eine Ordnungsrelation festgelegt ist Es werden vergleichende Methoden wie
 * IstGleich und IstKleiner ähnlich wie im Java Interface Comperable festgelegt,
 * die für Such- und sortierte Einfügeoperationen in die Datenstrukturen
 * notwendig sind.
 *
 * @author (Peter Brichzin)
 *
 * @version (20.07.08)
 */
public interface DATENELEMENT
{
    /**
     * Gibt Information über das Datenelement zu Kontrollzwecken auf das
     * Terminalfenster aus.
     */
    void InformationAusgeben();

    /**
     * Vergleicht zwei Datenelemente bezüglich der Ordnungsrelation.
     *
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen kleineren Schlüssel hat,
     *     als das eingegebene Datenelement dvergleich.
     */
    boolean IstKleinerAls(DATENELEMENT dvergleich);

    /**
     * Vergleicht zwei Datenelemente auf Gleichheit.
     *
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn die beiden Datenelemente gleichen Schlüssel haben.
     */
    boolean IstGleich(DATENELEMENT dvergleich);

    /**
     * Vergleicht zwei Datenelemente bezüglich der Ordnungsrelation.
     *
     * @param dvergleich Datenelement mit dem das Objekt verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als
     *     das eingegebene Datenelement dvergleich.
     */
    boolean IstGroesserAls(DATENELEMENT dvergleich);

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, auf
     * Gleichheit.
     *
     * @param vergleichsSchluessel Schlüssel mit dem der Schlüssel des Objekt
     *     verglichen wird.
     *
     * @return true, wenn die beiden Schlüssel gleich sind.
     */
    boolean SchluesselIstGleich(String vergleichsSchluessel);

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der
     * Ordnungsrelation.
     *
     * @param vergleichsSchluessel Schlüssel mit dem der Schlüssel des Objekt
     *     verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen größeren Schlüssel hat, als
     *     das angegebene Vergleichselement.
     */
    boolean SchluesselIstGroesserAls(String vergleichsSchluessel);

    /**
     * Vergleicht zwei Schlüssel, die als Zeichenketten vorliegen, bezüglich der
     * Ordnungsrelation.
     *
     * @param vergleichsSchluessel Schlüssel mit dem der Schlüssel des Objekt
     *     verglichen wird.
     *
     * @return true, wenn das aktuelle Element einen kleineren Schlüssel hat,
     *     als das angegebene Vergleichselement.
     */
    public boolean SchluesselIstKleinerAls(String vergleichsSchluessel);
}
