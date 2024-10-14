package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_01.thema_05.aufgabe_16.fussball;

/**
 * Klasse zur Verwaltung der Bundesliga
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Bundesliga
{
    private Liste l;

    /**
     * Konstruktor
     */
    Bundesliga(Fenster o)
    {
        l = new Liste();
        l.SortiertEinfügen(new Mannschaft("Hoffenheim", 35, 17));
        o.ItemEinfügen("Hoffenheim");
        l.SortiertEinfügen(new Mannschaft("Bayern", 35, 17));
        o.ItemEinfügen("Bayern");
        l.SortiertEinfügen(new Mannschaft("Hertha", 33, 17));
        o.ItemEinfügen("Hertha");
        l.SortiertEinfügen(new Mannschaft("HSV", 33, 17));
        o.ItemEinfügen("HSV");
        l.SortiertEinfügen(new Mannschaft("Leverkusen", 32, 17));
        o.ItemEinfügen("Leverkusen");
        l.SortiertEinfügen(new Mannschaft("Dortmund", 29, 17));
        o.ItemEinfügen("Dortmund");
        l.SortiertEinfügen(new Mannschaft("Schalke", 27, 17));
        o.ItemEinfügen("Schalke");
        l.SortiertEinfügen(new Mannschaft("Werder", 26, 17));
        o.ItemEinfügen("Werder");
        l.SortiertEinfügen(new Mannschaft("Wolfsburg", 26, 17));
        o.ItemEinfügen("Wolfsburg");
        l.SortiertEinfügen(new Mannschaft("Stuttgart", 25, 17));
        o.ItemEinfügen("Stuttgart");
        l.SortiertEinfügen(new Mannschaft("Köln", 22, 17));
        o.ItemEinfügen("Köln");
        l.SortiertEinfügen(new Mannschaft("Frankfurt", 19, 17));
        o.ItemEinfügen("Frankfurt");
        l.SortiertEinfügen(new Mannschaft("Hannover", 17, 17));
        o.ItemEinfügen("Hannover");
        l.SortiertEinfügen(new Mannschaft("Bielefeld", 14, 17));
        o.ItemEinfügen("Bielefeld");
        l.SortiertEinfügen(new Mannschaft("Karlsruhe", 13, 17));
        o.ItemEinfügen("Karlsruhe");
        l.SortiertEinfügen(new Mannschaft("Cottbus", 13, 17));
        o.ItemEinfügen("Cottbus");
        l.SortiertEinfügen(new Mannschaft("Bochum", 11, 17));
        o.ItemEinfügen("Bochum");
        l.SortiertEinfügen(new Mannschaft("Gladbach", 35, 17));
        o.ItemEinfügen("Gladbach");
    }

    /**
     * Methode zuz Aufnahme eines Spielergebnisses
     *
     * @param mannschaft1_String Name der 1. Mannschaft
     * @param mannschaft2_String Name der 2. Mannschaft
     * @param sieger hat Wert 1/2, falls Mannschaft 1/2 gewonnen hat, sonst
     *     unentschieden.
     */
    void SpielergebnisAufnehmen(String mannschaft1_String,
            String mannschaft2_String, int sieger)
    {
        int punkte1, punkte2;
        if (sieger == 1)
        {
            punkte1 = 3;
            punkte2 = 0;
        }
        else
        {
            if (sieger == 2)
            {
                punkte1 = 0;
                punkte2 = 3;
            }
            else
            {
                punkte1 = 1;
                punkte2 = 1;
            }
        }

        Mannschaft mannschaft1, mannschaft2;
        mannschaft1 = (Mannschaft) l.Suchen(mannschaft1_String);
        l.KnotenEntfernen(mannschaft1);
        mannschaft1.SpielergebnisAufnehmen(punkte1);
        l.SortiertEinfügen(mannschaft1);

        mannschaft2 = (Mannschaft) l.Suchen(mannschaft2_String);
        l.KnotenEntfernen(mannschaft2);
        mannschaft2.SpielergebnisAufnehmen(punkte2);
        l.SortiertEinfügen(mannschaft2);
    }

    /**
     * Ausgabe der Liste als String
     *
     * @return Liste als String
     */
    String ListeAusgeben()
    {
        return l.InformationGeben();
    }

}
