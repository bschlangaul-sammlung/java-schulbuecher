package schulbuecher.isb.handreichung_12_2010.kapitel_04.sortieren;

/**
 * Schnittstelle des Kontrolleurs für die Oberfläche.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
interface KontrolleurInterface
{
    /**
     * Ausführen der Laufzeitmessungen.
     *
     * @param anzahlElemente Anzahl der zu sortierenden Datenelemente
     * @param auswahl gibt an, ob mit Auswahlsort sortiert werden soll
     * @param mischen gibt an, ob mit Mergesort sortiert werden soll
     */
    void SortierenAusfuehren(int anzahlElemente, boolean auswahl,
            boolean mischen);

    /**
     * Beendet das Programm.
     */
    void BeendenAusfuehren();
}
