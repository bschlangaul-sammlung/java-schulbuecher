package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.adressverwaltung;

/**
 * Knoten einer Objektliste
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class KNOTEN extends LISTENELEMENT
{
    private DATENELEMENT daten;

    private LISTENELEMENT nachfolger;

    /**
     * Baut die Referenzen auf
     *
     * @param d Daten
     * @param nf Nachfolgeelement der Liste
     */
    KNOTEN(DATENELEMENT d, LISTENELEMENT nf)
    {
        super();
        daten = d;
        nachfolger = nf;
    }

    /**
     * Fügt ein Objekt sortiert in die Liste ein.
     *
     * @param d Referenz auf das einzufügende Objekt.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENT Einfuegen(DATENELEMENT d)
    {
        if (daten.Vergleichen(d) < 0)
        {
            nachfolger = nachfolger.Einfuegen(d);
            return this;
        }
        else
        {
            return new KNOTEN(d, this);
        }
    }

    /**
     * Sucht das angegebene Objekt. Nutzt die Sortierung der Liste aus.
     *
     * @param d Schlüssel des zu suchenden Objekts.
     *
     * @return Referenz auf das gefundene Objekt oder null.
     */
    DATENELEMENT Suchen(DATENELEMENT d)
    {
        if (daten.IstGleich(d))
        {
            return daten;
        }
        else if (daten.Vergleichen(d) < 0)
        {
            return nachfolger.Suchen(d);
        }
        else
        {
            return null;
        }
    }

    /**
     * Löscht das angegebene Objekt. Nutzt die Sortierung der Liste aus.
     *
     * @param d Schlüssel des zu löschenden Objekts.
     *
     * @return (neues) Nachfolgeelement des Aufrufers.
     */
    LISTENELEMENT Loeschen(DATENELEMENT d)
    {
        if (daten.IstGleich(d))
        {
            return nachfolger;
        }
        else if (daten.Vergleichen(d) < 0)
        {
            return nachfolger.Loeschen(d);
        }
        else
        {
            return this;
        }
    }

    /**
     * Meldet die Anzahl der ab hier in der Liste befindlichen Datenelemente.
     *
     * @return Anzahl
     */
    int AnzahlAbHierGeben()
    {
        return nachfolger.AnzahlAbHierGeben() + 1;
    }

    /**
     * überträgt die Datenreferenz in das Feld.
     *
     * @param feld Das Feld zur Aufnahme der Referenzen
     * @param index Feldindex für das Element dieses Listenelements
     */
    void Eintragen(DATENELEMENT[] feld, int index)
    {
        feld[index] = daten;
        nachfolger.Eintragen(feld, index + 1);
    }
}
