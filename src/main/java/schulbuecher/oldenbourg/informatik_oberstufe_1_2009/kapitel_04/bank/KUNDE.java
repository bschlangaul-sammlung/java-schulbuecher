package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Beschreibt die Kunden der Bank.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KUNDE extends PERSON
{
    /**
     * Akutelles Konto des Kunden
     */
    KONTO aktKonto;

    /**
     * Belegt name und pin der Person
     *
     * @param n Name der neuen Person
     * @param p PIN der neuen Person
     */
    KUNDE(String n, int p)
    {
        super(n, p);
        aktKonto = null;
    }

    /**
     * Setzt das aktuelle Konto des Kunden
     *
     * @param nummer das neue aktuelle Konto
     */
    boolean AktkontoSetzen(int nummer)
    {
        KONTO k;
        k = BANK.BankGeben().KontoSuchen(nummer);
        if ((k != null) && (k.EigentuemerGeben() == this))
        {
            aktKonto = k;
        }
        else
        {
            aktKonto = null;
        }
        return aktKonto != null;
    }

    /**
     * Zahlt auf das aktuelle Konto ein. pre: das aktuelle Konto ist gesetzt
     *
     * @param betrag der einzuzahlende Betrag
     */
    void Einzahlen(double betrag)
    {
        aktKonto.Einzahlen(betrag);
    }

    /**
     * Hebt vom aktuellen Konto ab. pre: das aktuelle Konto ist gesetzt
     *
     * @param betrag der azuhebende Betrag
     */
    boolean Abheben(double betrag)
    {
        return aktKonto.Abheben(betrag);
    }

    /**
     * Gibt den aktuellen Kontostand aus. pre: das aktuelle Konto ist gesetzt
     *
     * @return Kontostand
     */
    double KontostandGeben()
    {
        return aktKonto.KontostandGeben();
    }

    /**
     * Generiert die Daten für die Erstellung des Kontoauszugs.
     *
     * @return Referenz auf das Ergebnisfeld oder null
     */
    AUSZUGSEINTRAG[] AuszugsdatenErstellen()
    {
        return aktKonto.AuszugsdatenErstellen();
    }
}
