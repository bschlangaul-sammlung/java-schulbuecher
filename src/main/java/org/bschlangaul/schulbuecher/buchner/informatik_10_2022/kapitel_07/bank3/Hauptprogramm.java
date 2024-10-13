package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_07.bank3;

/**
 * Klasse Hauptprogramm fuer 4.7 A3
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-01-31
 */
public class Hauptprogramm
{
    public static void main()
    {
        Filiale f = new Filiale("Am Markt");
        Leiter l = new Leiter("A", "B");
        l.setzeFiliale(f);
        f.setzeLeiter(l);
    }
}
