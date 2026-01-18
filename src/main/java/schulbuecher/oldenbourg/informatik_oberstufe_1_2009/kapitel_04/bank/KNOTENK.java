package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * (Innerer) Knoten einer Konteniste.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KNOTENK extends LISTENELEMENTK
{
    private LISTENELEMENTK nachfolger;

    private KONTO konto;

    /**
     * Belegt die Attribute.
     *
     * @param nf Referenz auf den Nachfolger dieses Konotens
     * @param k Referenz auf das zu verwaltende Datenobjekt
     */
    KNOTENK(LISTENELEMENTK nf, KONTO k)
    {
        super();
        nachfolger = nf;
        konto = k;
    }

    /**
     * Fügt ein Konto sortiert nach Kontonummern in die Liste ein.
     *
     * @param k Referenz auf das einzufügende Konto.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENTK Einfuegen(KONTO k)
    {
        if (konto.KontonummerGeben() < k.KontonummerGeben())
        {
            nachfolger = nachfolger.Einfuegen(k);
            return this;
        }
        else
        {
            return new KNOTENK(this, k);
        }
    }

    /**
     * Löscht das angegebene KONTO aus der Liste. Nutzt die Sortierung der Liste
     * aus.
     *
     * @param k Referenz auf das einzufügende Konto.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENTK Loeschen(KONTO k)
    {
        if (konto == k)
        {
            return nachfolger;
        }
        else
        {
            if (konto.KontonummerGeben() < k.KontonummerGeben())
            {
                nachfolger = nachfolger.Loeschen(k);
            }
            return this;
        }
    }

    /**
     * Sucht das angegebene Konto. Nutzt die Sortierung der Liste aus.
     *
     * @param nummer Nummer des zu suchenden Kontos.
     *
     * @return Referenz auf das gefundene Konto oder null.
     */
    KONTO Suchen(int nummer)
    {
        if (konto.KontonummerGeben() == nummer)
        {
            return konto;
        }
        else if (konto.KontonummerGeben() < nummer)
        {
            return nachfolger.Suchen(nummer);
        }
        else
        {
            return null;
        }
    }

    /**
     * Zählt die Konten, die der angegebene Kunde besitzt.
     *
     * @param kunde Referenz auf den Kunde, für den die Konten gezählt werden
     *     sollen.
     *
     * @return Anzahl der Mitglieder der Menge.
     */
    int KontosFuerKundeZaehlen(KUNDE kunde)
    {
        if (konto.EigentuemerGeben() == kunde)
        {
            return nachfolger.KontosFuerKundeZaehlen(kunde) + 1;
        }
        else
        {
            return nachfolger.KontosFuerKundeZaehlen(kunde);
        }
    }

    /**
     * Trägt die Kontonummern der Konten des angegebenen Kunden in das Feld ein.
     *
     * @param kunde Referenz auf den Kunden.
     * @param ergebnis Referenz auf das Feld mit den gefundenen Daten.
     * @param pos Index, auf dem das nächste Element eingetragen werden soll.
     */
    void KontonummernFuerKundeEintragen(KUNDE kunde, int[] ergebnis, int pos)
    {
        if (konto.EigentuemerGeben() == kunde)
        {
            ergebnis[pos] = konto.KontonummerGeben();
            nachfolger.KontonummernFuerKundeEintragen(kunde, ergebnis, pos + 1);
        }
        else
        {
            nachfolger.KontonummernFuerKundeEintragen(kunde, ergebnis, pos);
        }
    }

    /**
     * Verzinst alle Sparkonten.
     */
    void Verzinsen()
    {
        if (konto instanceof SPARKONTO)
        {
            ((SPARKONTO) konto).Verzinsen();
        }
    }
}
