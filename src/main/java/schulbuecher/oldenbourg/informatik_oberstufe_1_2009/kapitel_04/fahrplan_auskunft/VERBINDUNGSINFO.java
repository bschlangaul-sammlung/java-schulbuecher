package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.fahrplan_auskunft;

/**
 * Beschreibt eine Verbindungsinformation.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class VERBINDUNGSINFO implements DATENELEMENT
{
    private GKNOTEN ziel;

    private float laenge;

    /**
     * Legt die Daten fest.
     *
     * @param ziel Zielknoten
     * @param laenge Länge des Wegs
     */
    VERBINDUNGSINFO(GKNOTEN ziel, float laenge)
    {
        this.ziel = ziel;
        this.laenge = laenge;
    }

    /**
     * Vergleicht das Datemelement mit dem Parameter.
     *
     * @param test Datenelement mit dem Testschlüssel
     *
     * @return true, wenn die Schlüssel übereinstimmen
     */
    public boolean IstGleich(DATENELEMENT test)
    {
        return ziel.IstGleich(((VERBINDUNGSINFO) test).ziel);
    }

    /**
     * Vergleicht das Datemelement mit dem Parameter. <br>
     * Hat das Datenelement einen kleineren Schlüssel als test, ist das Ergebnis
     * -1. <br>
     * Hat das Datenelement den gleichen Schlüssel wie test, ist das Ergebnis 0.
     * <br>
     * Hat das Datenelement einen größeren Schlüssel als test, ist das Ergebnis
     * 1.
     *
     * @param test Datenelement mit dem Testschlüssel
     *
     * @return Vergleichsergebnis
     */
    public int Vergleichen(DATENELEMENT test)
    {
        return ziel.Vergleichen(((VERBINDUNGSINFO) test).ziel);
    }

    /**
     * Meldet den Zielknoten.
     *
     * @return Zielknoten
     */
    GKNOTEN ZielGeben()
    {
        return ziel;
    }

    /**
     * Meldet die Länge des Wegstücks.
     *
     * @return Länge
     */
    float LaengeGeben()
    {
        return laenge;
    }
}
