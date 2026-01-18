package schulbuecher.buchner.informatik_10_2022.kapitel_07.klassenzimmer;

/**
 * Klasse Tisch, für Kapitel 4.7 Aufgabe 2
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-06-03
 */
class Tisch
{
    String raum;

    Schueler schueler1;

    Schueler schueler2;

    /**
     * Konstruktor für Objekte der Klasse Tasse
     */
    Tisch(String einRaum)
    {
        raum = einRaum;
    }

    void setzeSchueler1(Schueler s1)
    {
        schueler1 = s1;
    }

    void setzeSchueler2(Schueler s2)
    {
        schueler2 = s2;
    }

    void zeigeSchueler()
    {
        System.out.println("Schüler 1 an diesem Tisch: " + schueler1.gibName());
        System.out.println("Schüler 2 an diesem Tisch: " + schueler2.gibName());
    }
}
