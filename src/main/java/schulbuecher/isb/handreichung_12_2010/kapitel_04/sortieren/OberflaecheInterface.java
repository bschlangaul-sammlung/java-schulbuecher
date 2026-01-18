package schulbuecher.isb.handreichung_12_2010.kapitel_04.sortieren;

/**
 * Schnittstelle der Oberfläche für den Kontrolleur.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
interface OberflaecheInterface
{
    /**
     * Trägt die Suchzeit für Sortieren durch Auswählen ein.
     *
     * @param zeit benötigte Sortierzeit
     */
    void AuswahlSortierzeitSetzen(String zeit);

    /**
     * Trägt die Suchzeit für Sortieren durch Mischen ein.
     *
     * @param zeit benötigte Sortierzeit
     */
    void MischSortierzeitSetzen(String zeit);
}
