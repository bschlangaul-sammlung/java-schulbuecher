package org.bschlangaul.schulbuecher.isb.handreichung_11.kapitel_01.thema_02.baeume.woerterbuch;

/**
 * Stellt die speziellen Methoden für ein Wörterbuch zur Verfügung.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
class WOERTERBUCH2
{
    /**
     * Referenz uaf das benötigte BAUM-Objekt
     */
    BAUM baum;

    /**
     * legt den verwendeten Baum an.
     */
    WOERTERBUCH2()
    {
        baum = new BAUM();
    }

    /**
     * Gibt die übersetzung des angegebenen Begriffs auf Konsole aus.
     *
     * @param wort der zu übersetzende Begriff
     */
    void Uebersetzen(String wort)
    {
        WORT daten;
        daten = (WORT) baum.Suchen(new WORT(wort, ""));
        if (daten != null)
        {
            daten.Ausgeben();
        }
        else
        {
            System.out.println("Unbekanntes Wort: " + wort);
        }
    }

    /**
     * Gibt den gesamten Inhalt des Lexions auf Konsole aus.
     */
    void InhaltAusgeben()
    {
        baum.InOrder();
    }

    /**
     * Fügt ein neues Wort in das Wörterbuch ein. Der Wert darf noch nicht
     * vorkommen
     *
     * @param englisch der englische Begriff
     * @param deutsch die möglichen deutschen übersetzungen
     */
    void Einfuegen(String englisch, String deutsch)
    {
        baum.Einfuegen(new WORT(englisch, deutsch));
    }
}
