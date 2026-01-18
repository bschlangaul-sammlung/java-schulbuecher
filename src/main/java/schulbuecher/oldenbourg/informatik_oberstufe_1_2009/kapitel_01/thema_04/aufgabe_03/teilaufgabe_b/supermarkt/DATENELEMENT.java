package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.supermarkt;

/**
 * Beschreibung zum Interface DATENELEMENT
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public interface DATENELEMENT
{
    /**
     * Ausgabe von Information über ein Ausgabefenster
     */
    public void InformationAusgeben();

    /**
     * Vergleich zweier Datenelemente bezüglich einer Ordnungsrelation
     *
     * @param dvergleich Datenelement zum Vergleich
     */
    public boolean IstKleinerAls(DATENELEMENT dvergleich);

    /**
     * Identifikation eines Datenelements aufgrund seines Schlüssels
     *
     * @param s Schlüssel vom Typ String
     */
    public boolean SchluesselIstGleich(String s);

    /**
     * Sorgt für das NeuPositionieren der Darstellungssymbole des Datenelements
     * und der Nachfolger
     */
    public void NeuPositionieren(int i, int j);

    /**
     * Gibt die Artikelzahl des Datenelements aus
     *
     * @return artikelzahl
     */
    int ArtikelzahlGeben();
}
