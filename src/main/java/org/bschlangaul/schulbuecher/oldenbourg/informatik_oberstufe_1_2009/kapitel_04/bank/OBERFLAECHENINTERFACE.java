package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Beschreibt die Sicht des Kontrollers auf die Oberfläche.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
interface OBERFLAECHENINTERFACE
{
    /** Die von der Oberfläche darzustellenden Zustände */
    enum Status
    {
        anmelden, kundenkontowahl, kundenkontoarbeit, angestelltensicht,
        angestelltensicht_kunde, angestelltensicht_kundeundkonto
    };

    /**
     * Setzt die Oberfläche auf den angegebenen Status.
     *
     * @param status der neue Status der Oberfläche
     */
    void StatusSetzen(Status status);

    /**
     * Statusanzeige besetzen
     *
     * @param text anzuzeigender Statustext
     */
    void StatusmeldungSetzen(String text);

    /**
     * Fehlermeldungen beim Ausführen von Aktionen anzeigen
     *
     * @param text anzuzeigende Fehlermeldung
     */
    void FehlermeldungAnzeigen(String text);
}
