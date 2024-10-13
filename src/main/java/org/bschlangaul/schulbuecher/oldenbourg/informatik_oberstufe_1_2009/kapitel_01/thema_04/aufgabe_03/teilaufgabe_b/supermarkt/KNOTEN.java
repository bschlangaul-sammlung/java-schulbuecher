package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.supermarkt;

/**
 * Beschreibung der Klasse KNOTEN
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class KNOTEN extends LISTENELEMENT
{
    /**
     * Datenelement des Knotens
     */
    private DATENELEMENT daten;

    /**
     * Verwaltung des nachfolgenden Knoten in der Warteschlange.
     */
    private LISTENELEMENT nachfolger;

    /**
     * Konstruktor des Knotens
     *
     * @param d neues Datenelement
     * @param l Nachfolger des Knotens
     */
    KNOTEN(DATENELEMENT d, LISTENELEMENT l)
    {
        daten = d;
        nachfolger = l;
    }

    /**
     * Fügt ein Datenelement am Ende der Liste ein
     *
     * @param dneu neues Datenelement
     */
    KNOTEN HintenEinfuegen(DATENELEMENT dneu)
    {
        nachfolger = nachfolger.HintenEinfuegen(dneu);
        return this;
    }

    /**
     * Fügt ein Datenelement vor einem bestimmten anderen Datenelement ein
     *
     * @param dneu neues Datenelement
     * @param d_vergleich gesuchtes Datenelement, vor dem eingefügt werden soll
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    KNOTEN EinfuegenVor(DATENELEMENT dneu, DATENELEMENT d_vergleich)
    {
        if (daten == d_vergleich)
        {
            KNOTEN kneu;
            kneu = new KNOTEN(dneu, this);
            return kneu;
        }
        else
        {
            nachfolger = nachfolger.EinfuegenVor(dneu, d_vergleich);
            return this;
        }
    }

    /**
     * Fügt ein Datenelement sortiert in die Liste ein
     *
     * @param dneu neues Datenelement
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    KNOTEN SortiertEinfuegen(DATENELEMENT dneu)
    {
        if (daten.IstKleinerAls(dneu))
        {
            nachfolger = nachfolger.SortiertEinfuegen(dneu);
            return this;
        }
        else
        {
            KNOTEN kneu;
            kneu = new KNOTEN(dneu, this);
            return kneu;
        }
    }

    /**
     * Entfernt einen Knoten, der über sein Datenelement identifiziert wird, aus
     * der Liste
     *
     * @param dvergleich gesuchtes Datenelement
     *
     * @return Weitergabe des künftigen Nachfolgers
     */
    LISTENELEMENT KnotenEntfernen(DATENELEMENT dvergleich)
    {
        if (daten == dvergleich)
        {
            return nachfolger;
        }
        else
        {
            nachfolger = nachfolger.KnotenEntfernen(dvergleich);
            return this;
        }
    }

    /**
     * Gibt das Datenelement des letzten Knotens aus
     *
     * @param d Vorgänger gibt Referenz auf sein Datenelement mit.
     *
     * @return hinterstes Datenelement
     */
    DATENELEMENT EndeGeben(DATENELEMENT d)
    {
        return nachfolger.EndeGeben(daten);
    }

    /**
     * Gibt den letzten Knoten aus und entfernt ihn aus der Liste
     *
     * @return bisheriger letzter Knoten
     */
    LISTENELEMENT EndeEntfernen(DATENELEMENT d)
    {
        if (daten == d)
        {
            return nachfolger;
        }
        else
        {
            nachfolger = nachfolger.EndeEntfernen(d);
            return this;
        }
    }

    /**
     * Gibt Information über das Datenelement und den Nachfolger des Knotens
     * aus.
     */
    void InformationAusgeben()
    {
        daten.InformationAusgeben();
        nachfolger.InformationAusgeben();
    }

    /**
     * Sucht ein Datenelement, das über seinen Schlüssel identifiziert wird, und
     * gibt es aus.
     *
     * @param vergleichswert Schlüssel vom Typ String
     *
     * @return gesuchtes Datenelement
     */
    DATENELEMENT Suchen(String vergleichswert)
    {
        if (daten.SchluesselIstGleich(vergleichswert))
        {
            return daten;
        }
        else
        {
            return nachfolger.Suchen(vergleichswert);
        }
    }

    /**
     * Gibt die Länge der Restliste aus
     *
     * @return Länge der Restliste
     */
    int RestlaengeGeben()
    {
        return nachfolger.RestlaengeGeben() + 1;
    }

    /**
     * Gibt eine Referenz auf das Datenelement aus
     *
     * @return Datenelement
     */
    DATENELEMENT DatenelementGeben()
    {
        return daten;
    }

    /**
     * Gibt eine Referenz auf den Nachfolger aus
     *
     * @return Nachfolger
     */
    LISTENELEMENT NachfolgerGeben()
    {
        return nachfolger;
    }

    /**
     * Sorgt für das NeuPositionieren der Darstellungssymbole des Datenelements
     * und der Nachfolger
     *
     * @param knummer Nummer der Kasse
     * @param pos Position vor der Kasse
     */
    void NeuPositionieren(int knummer, int pos)
    {
        daten.NeuPositionieren(knummer, pos);
        nachfolger.NeuPositionieren(knummer, pos + 1);
    }

    /**
     * Gibt die Artikelzahl der Restschlange zurück
     *
     * @return artikelzahl
     */
    int ArtikelzahlGeben()
    {
        int azahl;
        azahl = daten.ArtikelzahlGeben();
        azahl = azahl + nachfolger.ArtikelzahlGeben();
        return azahl;
    }
}
