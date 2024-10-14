package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_07.bank3;

/**
 * Klasse Leiter fuer 4.7 A3
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-01-31
 */
@SuppressWarnings("unused")
public class Leiter
{
    private String vorname;

    private String nachname;

    private Filiale filiale;

    public Leiter(String einVorname, String einNachname)
    {
        vorname = einVorname;
        nachname = einNachname;
    }

    public void setzeFiliale(Filiale eineFiliale)
    {
        filiale = eineFiliale;
        System.out
                .println("Erfolgreich Filiale in Klasse Filialleiter gesetzt");
    }
}
