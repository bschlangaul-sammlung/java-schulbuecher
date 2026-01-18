package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_02.baeume.woerterbuch;

/**
 * Stellt die speziellen Methoden für ein Wörterbuch zur Verfügung.
 *
 * @author Arbeitskreis
 *
 * @version 1.0
 */
class Woerterbuch2
{
    /**
     * Referenz uaf das benötigte BAUM-Objekt
     */
    Baum baum;

    /**
     * legt den verwendeten Baum an.
     */
    Woerterbuch2()
    {
        baum = new Baum();
    }

    /**
     * Gibt die übersetzung des angegebenen Begriffs auf Konsole aus.
     *
     * @param wort der zu übersetzende Begriff
     */
    void Uebersetzen(String wort)
    {
        Wort daten;
        daten = (Wort) baum.Suchen(new Wort(wort, ""));
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
        baum.Einfuegen(new Wort(englisch, deutsch));
    }
}
