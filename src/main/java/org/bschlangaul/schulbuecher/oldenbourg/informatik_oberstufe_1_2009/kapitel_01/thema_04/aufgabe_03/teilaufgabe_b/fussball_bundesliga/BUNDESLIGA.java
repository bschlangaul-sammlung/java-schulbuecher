package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_04.aufgabe_03.teilaufgabe_b.fussball_bundesliga;

/**
 * Klasse zur Verwaltung der Bundesliga
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class BUNDESLIGA
{
    private LISTE l;

    /**
     * Konstruktor
     */
    BUNDESLIGA(FENSTER o)
    {
        l = new LISTE();
        l.SortiertEinfuegen(new MANNSCHAFT("Hoffenheim", 35, 17));
        o.ItemEinfuegen("Hoffenheim");
        l.SortiertEinfuegen(new MANNSCHAFT("Bayern", 35, 17));
        o.ItemEinfuegen("Bayern");
        l.SortiertEinfuegen(new MANNSCHAFT("Hertha", 33, 17));
        o.ItemEinfuegen("Hertha");
        l.SortiertEinfuegen(new MANNSCHAFT("HSV", 33, 17));
        o.ItemEinfuegen("HSV");
        l.SortiertEinfuegen(new MANNSCHAFT("Leverkusen", 32, 17));
        o.ItemEinfuegen("Leverkusen");
        l.SortiertEinfuegen(new MANNSCHAFT("Dortmund", 29, 17));
        o.ItemEinfuegen("Dortmund");
        l.SortiertEinfuegen(new MANNSCHAFT("Schalke", 27, 17));
        o.ItemEinfuegen("Schalke");
        l.SortiertEinfuegen(new MANNSCHAFT("Werder", 26, 17));
        o.ItemEinfuegen("Werder");
        l.SortiertEinfuegen(new MANNSCHAFT("Wolfsburg", 26, 17));
        o.ItemEinfuegen("Wolfsburg");
        l.SortiertEinfuegen(new MANNSCHAFT("Stuttgart", 25, 17));
        o.ItemEinfuegen("Stuttgart");
        l.SortiertEinfuegen(new MANNSCHAFT("Köln", 22, 17));
        o.ItemEinfuegen("Köln");
        l.SortiertEinfuegen(new MANNSCHAFT("Frankfurt", 19, 17));
        o.ItemEinfuegen("Frankfurt");
        l.SortiertEinfuegen(new MANNSCHAFT("Hannover", 17, 17));
        o.ItemEinfuegen("Hannover");
        l.SortiertEinfuegen(new MANNSCHAFT("Bielefeld", 14, 17));
        o.ItemEinfuegen("Bielefeld");
        l.SortiertEinfuegen(new MANNSCHAFT("Karlsruhe", 13, 17));
        o.ItemEinfuegen("Karlsruhe");
        l.SortiertEinfuegen(new MANNSCHAFT("Cottbus", 13, 17));
        o.ItemEinfuegen("Cottbus");
        l.SortiertEinfuegen(new MANNSCHAFT("Bochum", 11, 17));
        o.ItemEinfuegen("Bochum");
        l.SortiertEinfuegen(new MANNSCHAFT("Gladbach", 35, 17));
        o.ItemEinfuegen("Gladbach");
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
        MANNSCHAFT mannschaft1, mannschaft2;
        mannschaft1 = (MANNSCHAFT) l.Suchen(mannschaft1_String);
        l.KnotenEntfernen(mannschaft1);
        mannschaft1.SpielergebnisAufnehmen(punkte1);
        l.SortiertEinfuegen(mannschaft1);
        mannschaft2 = (MANNSCHAFT) l.Suchen(mannschaft2_String);
        l.KnotenEntfernen(mannschaft2);
        mannschaft2.SpielergebnisAufnehmen(punkte2);
        l.SortiertEinfuegen(mannschaft2);
    }

    /**
     * Ausgabe der Liste als String
     *
     * @return Liste als String
     */
    String ListeAusgeben()
    {
        return l.InformationAusgeben();
    }
}
