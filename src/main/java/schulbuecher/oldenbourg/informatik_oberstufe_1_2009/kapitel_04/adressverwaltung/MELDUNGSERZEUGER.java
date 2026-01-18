package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

/**
 * Beschreibt die Produzenten von Meldungen.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
interface MELDUNGSERZEUGER
{
    /**
     * Registriert einen Beobachter beim Produzenten.
     *
     * @param beobachter der neue Beobachter.
     */
    void Registrieren(MELDUNGSBEOBACHTER beobachter);

    /**
     * Meldet einen Beobachter beim Produzenten ab.
     *
     * @param beobachter der abzumeldene Beobachter.
     */
    void Abmelden(MELDUNGSBEOBACHTER beobachter);
}
