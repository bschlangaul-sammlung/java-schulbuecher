package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_03.aufgabe_09.lotto;

/**
 * Klasse zur Verwaltung der Lottozahlen
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Lotto
{
    private Liste l;

    /**
     * Konstruktor der Klasse LOTTO erzeugt eine leere Liste
     */
    Lotto()
    {
        l = new Liste();
    }

    /**
     * Einfügen einer neuen Zahl
     *
     * @param i einzufügende int-Zahl
     */
    void Einfuegen(int i)
    {
        Zahl zahl;
        zahl = new Zahl(i);
        l.SortiertEinfuegen(zahl);
    }

    /**
     * Ausgabe aller Zahlen über die Konsole
     */
    void Ausgeben()
    {
        l.InformationAusgeben();
    }
}
