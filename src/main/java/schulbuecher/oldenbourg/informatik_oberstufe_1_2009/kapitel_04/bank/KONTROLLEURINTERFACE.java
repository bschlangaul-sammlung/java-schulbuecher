package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Beschreibt die Sicht des Kontrollers für die View.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
interface KONTROLLEURINTERFACE
{
    /**
     * Setzt die zugehörige Oberfläche
     *
     * @param o die Oberfläche
     */
    void OberflaecheSetzen(OBERFLAECHENINTERFACE o);

    /**
     * Reagiert auf Beenden-Ereignisse.
     */
    void BeendenAusfuehren();

    /**
     * Abmelden des Kunden oder Angestellten.
     */
    void AbmeldenAusfuehren();

    /**
     * Versucht, den angegebenen Namen als Kunden anzumelden.
     *
     * @param name Name des Kunden
     * @param pin PIN des Kunden
     */
    void KundeAnmelden(String name, int pin);

    /**
     * Setzt eine neue PIN für den Kunden.
     *
     * @param nummer die neue PIN
     */
    void KundePinAendern(int nummer);

    /**
     * Wählt das angegebene Konto des aktuellen Kunden.
     *
     * @param nummer: die Nummer des zu wählenden Kontos
     */
    void KundeKontoWaehlen(int nummer);

    /**
     * Holt die Nummern der verfügbaren Konten des aktuellen Kunden.
     *
     * @return die Nummern aller Konten des aktuellen Kunden oder null.
     */
    int[] NummerFuerKundenGeben();

    /**
     * Holt die Nummer des aktuellen Kontos des aktuellen Kunden.
     *
     * @return Nummer des aktuellen Kontos des aktuellen Kunden.
     */
    int NummerFuerKundenKontoGeben();

    /**
     * Holt den verfügbaren Betrag des aktuellen Kontos des aktuellen Kunden.
     *
     * @return Betrag auf den aktuellen Konto des aktuellen Kunden.
     */
    double BetragFuerKundenKontoGeben();

    /**
     * Zahlt den angegebenen Betrag auf das aktuelle Konto des Kunden ein.
     */
    void KundeKontoEinzahlen(double betrag);

    /**
     * Hebt den angegebenen Betrag vom aktuellen Konto des Kunden ab.
     */
    void KundeKontoAbheben(double betrag);

    /**
     * Holt die Kontoauszüge des akttuellen Kontos des aktuellen Kunden.
     *
     * @return Feld von Texten mit einem Kontoauszug pro Element
     */
    String[] KundeKontoauszuegeGeben();

    /**
     * Lässt das aktuelle Konto des Kunden neu wählen.
     */
    void KundeKontoNeuWaehlen();

    /**
     * Versucht, den angegebenen Namen als Angestellten anzumelden.
     *
     * @param name Name des Angestellten
     * @param pin PIN des Angestellten
     */
    void AngestellterAnmelden(String name, int pin);

    /**
     * Meldet die Namen aller Kunden.
     *
     * @return Stringfeld mit den vorhandenen Kundennamen oder null
     */
    String[] KundenNamenGeben();

    /**
     * Meldet die Namen aller Angestellten ausser "Chef" und dem aktuell
     * angemeldeten Angestellten.
     *
     * @return Stringfeld mit den vorhandenen Angestelltennamen oder null
     */
    String[] AngestelltenNamenGeben();

    /**
     * Wählt einen Kunden als aktuellen Kunden des Angestellten aus.
     *
     * @param name Name des Kunden
     */
    void AngestellterKundeWaehlen(String name);

    /**
     * Erzeugt einen Kunden und setzt ihn als aktuellen Kunden des Angestellten.
     *
     * @param name Name des Kunden
     * @param pin PIN des Kunden
     */
    void KundeErzeugen(String name, int pin);

    /**
     * Meldet den Namen des aktuellen Kunden.
     *
     * @return name Name des Kunden
     */
    String NameVonAktkundeGeben();

    /**
     * Erzeugt einen Angestellten.
     *
     * @param name Name des Angestellten
     * @param pin PIN des Angestellten
     */
    void AngestellterErzeugen(String name, int pin);

    /**
     * Holt die Nummern der verfügbaren Konten des aktuelle bearbeiteten Kunden
     * eines Angestellten.
     */
    int[] NummerFuerAktKundenGeben();

    /**
     * Legt ein neues Sparkonto für den aktuellen Kunden des Angestellten an.
     *
     * @param zins der Zinssatz für das neue Konto
     */
    void SparkontoEinrichten(double zins);

    /**
     * Legt ein neues Girokonto für den aktuellen Kunden des Angestellten an.
     *
     * @param kredit der überziehungsrahmen für das neue Konto
     */
    void GirokontoEinrichten(double kredit);

    /**
     * Setzt das zu bearbeitende Konto des aktuellen Kunden.
     *
     * @param nummer Nummer des Kontos
     */
    void KontoFuerAngestelltenSetzen(int nummer);

    /**
     * Löscht das zu bearbeitende Konto des aktuellen Kunden.
     */
    void KontoLoeschen();

    /**
     * Holt die Kontoauszüge des aktuellen Kontos des aktuellen Kunden für den
     * Angestellten.
     *
     * @return Feld von Texten mit einem Kontoauszug pro Element
     */
    String[] KontoauszuegeGeben();

    /**
     * Verzinst alle Sparkonten.
     */
    void Verzinsen();

    /**
     * Löscht den aktuellen Kunden des aktuellen Angestellten.
     */
    void KundeLoeschen();

    /**
     * Löscht den angegebenen Angestellten.
     *
     * @param name Name des zu löschenden Angestellten.
     */
    void AngestelltenLoeschen(String name);
}
