package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Beschreibt die Angestellten der Bank.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ANGESTELLTER extends PERSON
{
    /**
     * Der Kunde, der gerade bearbeitet wird
     */
    private KUNDE aktKunde;

    /**
     * Die Bank, in der der Angestellte arbeitet.
     */
    private BANK bank;

    /**
     * Das Konto, das geade bearbeitet wird.
     */
    private KONTO aktKonto;

    /**
     * Belegt name und pin der Person
     *
     * @param n Name der neuen Person
     * @param p PIN der neuen Person
     * @param b Bank des Angestellten
     */
    ANGESTELLTER(String n, int p, BANK b)
    {
        super(n, p);
        aktKunde = null;
        aktKonto = null;
        bank = b;
    }

    /**
     * Trägt einen neuen Kunden ein und setzt ihn als aktuellen Kunden.
     *
     * @param name Name des neuen Kunden.
     * @param pin PIN des neuen Kunden.
     *
     * @return true, wenn der Kunde eingerichtet werden konnte.
     */
    boolean NeuenKundenEinrichten(String name, int pin)
    {
        if ((bank.KundenSuchen(name) != null)
                || (bank.AngestelltenSuchen(name) != null))
        {
            return false;
        }
        else
        {
            bank.NeuenKundenEinrichten(name, pin);
            aktKunde = bank.KundenSuchen(name);
            aktKonto = null;
            return true;
        }
    }

    /**
     * Wählt den angegebenen Kunden als aktuellen Kunden.
     *
     * @param name Name des zu wählenden Kunden.
     *
     * @return true, wenn der Kunde existiert.
     */
    boolean KundeWaehlen(String name)
    {
        aktKunde = bank.KundenSuchen(name);
        aktKonto = null;
        return aktKunde != null;
    }

    /**
     * Meldet den aktuellen Kunden.
     *
     * @return name Name des Kunden
     */
    KUNDE AktkundeGeben()
    {
        return aktKunde;
    }

    /**
     * Löscht den aktuellen Kunden.
     *
     * @return Fehlermeldung oder null
     */
    String KundenLoeschen()
    {
        if (bank.KontonummernFuerKundenGeben(aktKunde) == null)
        {
            bank.KundenLoeschen(aktKunde);
            aktKonto = null;
            aktKunde = null;
            return null;
        }
        else
        {
            return "Der Kunde hat noch Konten.";
        }
    }

    /**
     * Legt ein neues Sparkonto für den aktuellen Kunden an.
     *
     * @param zins der Zinssatz für das neue Konto
     *
     * @return die Nummer des neuen Kontos;
     */
    int SparkontoEinrichten(double zins)
    {
        return bank.SparkontoEinrichten(zins, aktKunde);
    }

    /**
     * Legt ein neues Girokonto an.
     *
     * @param kredit der überziehungsrahmen für das neue Konto
     *
     * @return die Nummer des neuen Kontos
     */
    int GirokontoEinrichten(double kredit)
    {
        return bank.GirokontoEinrichten(kredit, aktKunde);
    }

    /**
     * Setzt das aktuelle Konto. pre: das Konto gehört dem aktuellen Kunden.
     *
     * @param nummer das aktuelle Konto
     */
    void KontoSetzen(int nummer)
    {
        aktKonto = bank.KontoSuchen(nummer);
    }

    /**
     * Löscht das aktuelle Konto, falls der Kontostand 0 ist. pre: das Konto
     * gehört dem aktuellen Kunden.
     *
     * @return true, falls das Konto gelöscht wurde
     */
    boolean KontoLoeschen()
    {
        if (bank.KontoLoeschen(aktKonto))
        {
            aktKonto = null;
            return true;
        }
        else
        {
            return false;
        }
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

    /**
     * Trägt einen neuen Angestellten ein.
     *
     * @param name Name des neuen Angestellten.
     * @param pin PIN des neuen Angestellten.
     *
     * @return true, wenn der Angestellte eingerichtet werden konnte.
     */
    boolean NeuenAngestelltenEinrichten(String name, int pin)
    {
        if ((bank.KundenSuchen(name) != null)
                || (bank.AngestelltenSuchen(name) != null))
        {
            return false;
        }
        else
        {
            bank.NeuenAngestelltenEinrichten(name, pin);
            return true;
        }
    }

    /**
     * Löscht den angegebenen Angestellten.
     *
     * @param name der zu löschende Angestellte
     *
     * @return true, wenn der Angestellte gelöscht werden konnte
     */
    boolean AngestelltenLoeschen(String name)
    {
        ANGESTELLTER a;
        a = bank.AngestelltenSuchen(name);
        if (a != null)
        {
            bank.AngestelltenLoeschen(a);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Verzinst alle Sparkonten.
     */
    void Verzinsen()
    {
        bank.Verzinsen();
    }
}
