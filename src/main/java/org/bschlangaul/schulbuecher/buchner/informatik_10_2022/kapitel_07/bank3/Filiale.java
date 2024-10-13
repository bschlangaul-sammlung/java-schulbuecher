package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_07.bank3;

/**
 * Klasse Filiale fuer 4.7 A3
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-01-31
 */
class Filiale
{
    private String name;

    private Leiter leiter;

    public Filiale(String einName)
    {
        name = einName;
    }

    public void setzeLeiter(Leiter einLeiter)
    {
        leiter = einLeiter;
        System.out
                .println("Erfolgreich Filialleiter in Klasse Filiale gesetzt");
    }
}
