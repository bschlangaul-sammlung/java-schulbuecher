package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.ferienwohnungen_angestellter;

/**
 * Beschreibt den Beobachter von Meldungen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
interface MELDUNGSBEOBACHTER
{
    /**
     * Fehlermeldungen beim Ausführen von Aktionen
     */
    void FehlermeldungEmpfangen(String text);

    /**
     * Aktionslog für den Ablauf
     */
    void LogeintragEmpfangen(String text);
}
