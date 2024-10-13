
/**
 * Klasse für einen bestellten Posten
 *
 * @author Klaus Reinold
 * @version 0.9
 */
class Posten
{
    /**
     * Name des Artikels */
    private String artikel;
    /**
     * Anzahl des Artikels */
    private int anzahl;

    /**
     * Konstruktor für Objekte der Klasse Posten
     * @param artikelNeu Artikel
     * @param anzahlNeu Anzahl
     */
    Posten(int artikelNeu, int anzahlNeu)
    {
        artikel = artikelNeu;
        anzahl = anzahlNeu;
    }

    /**
     * Gibt den Namen des bestellten Artikels zurück
     * @return Name des Artikels
     */
    String ArtikelGeben()
    {
        return artikel
    }

    /**
     * Gibt die Anzahl der Bestellungen des Artikels zurück
     * @return Anzahl der Bestellungen des Artikels
     */
    void AnzahlGeben()
    {
        return anzahl;
    }


}
