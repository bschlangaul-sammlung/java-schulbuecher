package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.sortieren_zaehlen;

import org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_04.modell.TestSortieren;

/**
 * Kontrolleur des Programms.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class Kontrolleur implements KontrolleurInterface
{
    /**
     * Die ereigniserzeugende Oberfläche
     */
    private OberflaechenInterface oberflaeche;

    /**
     * Besetzt das Attribut vor.
     */
    Kontrolleur()
    {
        oberflaeche = null;
    }

    /**
     * Setzt die Oberfläche.
     *
     * @param o die ereigniserzeugende Oberfläche
     */
    void OberflaecheSetzen(OberflaechenInterface o)
    {
        oberflaeche = o;
    }

    /**
     * Ausführen der Laufzeitmessungen.
     *
     * @param anzahlElemente Anzahl der zu sortierenden Datenelemente
     * @param auswahl gibt an, ob mit Auswahlsort sortiert werden soll
     * @param mischen gibt an, ob mit Mergesort sortiert werden soll
     */
    public void SortierenAusfuehren(int anzahlElemente, boolean auswahl,
            boolean mischen)
    {
        TestSortieren test;
        oberflaeche.AuswahlSortieranzahlSetzen("---");
        oberflaeche.MischSortieranzahlSetzen("---");
        test = new TestSortieren(anzahlElemente);
        test.DurchschnittsTestAnzahl(auswahl, mischen);
        if (auswahl)
        {
            oberflaeche.AuswahlSortieranzahlSetzen(
                    "" + test.AnzahlFuerAuswahlGeben());
        }
        if (mischen)
        {
            oberflaeche.MischSortieranzahlSetzen(
                    "" + test.AnzahlFuerMergesortGeben());
        }
    }

    /**
     * Beendet das Programm.
     */
    public void BeendenAusfuehren()
    {
        System.exit(0);
    }
}
