package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_04.teilaufgabe_b.supermarkt;

/**
 * Verwaltet einen Kunden.
 *
 * @author Klaus van Dijkstran und Barbara Leidorn
 *
 * @version 1.0
 */
abstract class KUNDE
{
    /** Anzeigesymbol für den Kunden */
    private KUNDENSYMBOL darstellung;

    /** Anzahl der Artikel des Kunden */
    private int artikelzahl;

    /** Nachfolger des Kunden */
    private KUNDE nachfolger;

    /**
     * Konstruktor des Kunden. Setzt eine zufällige Farbe und die Größe gemäß
     * der Artikelanzahl. Ein Objekt der Klasse KUNDENSYMBOL dient zur
     * Darstellung des Kunden an zuächst fester Position vor Kasse 1.
     *
     * @param artikel die neue artikelzahl des Kunden.
     */
    KUNDE(int artikel)
    {
        artikelzahl = artikel;
        darstellung = new KUNDENSYMBOL();
        darstellung.GroesseSetzen(artikelzahl);
        darstellung.PositionSetzen(1, 1);
        darstellung.FarbeSetzen("zufall");
        nachfolger = null;
    }

    /**
     * Setzt den Anstellmechanismus in Gang.
     *
     * @param schlangenZurAuswahl Warteschlange, an der sich der Kunde anstellt
     */
    abstract void Anstellen(WARTESCHLANGE[] schlangenZurAuswahl);

    /**
     * Sorgt für ein Neuzeichnen des Kundensymbols.
     *
     * @param kassennummer Nummer der Kasse, an der der Kunde ansteht.
     * @param kundennummer Kundennummer Position des Kunden in der Schlange (-1
     *     für Kasse).
     */
    void NeuPositionieren(int kassennummer, int kundennummer)
    {
        darstellung.PositionSetzen(kassennummer, kundennummer);
    }

    /**
     * Sorgt für ein Entfernen des Kundensymbols.
     */
    void KundensymbolEntfernen()
    {
        darstellung.Entfernen();
    }

    /**
     * Gibt die Artikelzahl des Kunden aus.
     */
    int ArtikelzahlGeben()
    {
        return artikelzahl;
    }

    /**
     * Setzt den Nachfolger des Kunden auf den übergebenen Wert.
     */
    void NachfolgerSetzen(KUNDE kneu)
    {
        nachfolger = kneu;
    }

    /**
     * Gibt den Nachfolger des Kunden aus.
     */
    KUNDE NachfolgerGeben()
    {
        return nachfolger;
    }
}
