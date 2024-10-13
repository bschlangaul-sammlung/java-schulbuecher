package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_04;

/**
 * Baut einen sortierten, balancierten Baum und eine Liste entsprechend der
 * Aufgabe 4 in Kapitel 13 im Buch Informatik Oberstufe 2 Oldenbourg Verlag auf
 * und ermöglicht den Laufzeitvergleich für die Suche gemäß dem Verfahren
 * "Schritte zählen".
 *
 * @author K. Reinold
 *
 * @version 1.0
 */
public class Arbeit
{
    /**
     * zu untersuchender AVL-Baum
     */
    AvlBaum baum;

    /**
     * zu untersuchende Liste
     */
    Liste liste;

    /**
     * Konstruktor der Klasse ARBEIT Erzeugt einen leeren Baum und eine leere
     * Liste.
     */
    Arbeit()
    {
        baum = new AvlBaum();
        liste = new Liste();
    }

    /**
     * Erzeugt einen sortierten balancierten Baum und eine sortierte Liste mit
     * der angegebenen Anzahl an Elementen. Die Schlüssel der Datenelemente
     * erhalten die Werte von 1 bis anzahl.
     *
     * @param anzahl gewünschte Anzahl an Elementen.
     */
    public void Erzeugen(int anzahl)
    {
        baum = new AvlBaum();
        liste = new Liste();
        for (int i = 1; i <= anzahl; i++)
        {
            DatenElement d = new DatenElement(i);
            baum.Einfuegen(d);
            liste.SortiertEinfuegen(d);
        }
    }

    /**
     * Baum und Liste haben die gleiche Anzahl an Elementen. Nacheinander wird
     * nach allen vorhandenen Datenelementen gesucht - zunächst für den Baum,
     * dann für die Liste - und jeweils ein Mittelwert der Anzahl der
     * Suchoperationen bestimmt und ausgegeben.
     *
     * @param anzahl gewünschte Anzahl an Elementen.
     */
    public void Vergleichsmessung(int anzahl)
    {
        Erzeugen(anzahl);
        System.out.println("Elementanzahl: " + anzahl);
        Zaehler.ZaehlerZuruecksetzen();
        for (int i = 1; i <= anzahl; i++)
        {
            baum.Suchen(i);
        }
        float mittelwert = Zaehler.ZaehlerGeben() / anzahl;
        System.out.println("Baum: " + mittelwert + " Schritte");
        Zaehler.ZaehlerZuruecksetzen();
        for (int i = 1; i <= anzahl; i++)
        {
            liste.Suchen(i);
        }
        mittelwert = Zaehler.ZaehlerGeben() / anzahl;
        System.out.println("Liste: " + mittelwert + " Schritte");
    }

    /**
     * Nacheinander werden sortierte balancierte Binärbäume erzeugt, beginnend
     * bei der Anzahl start an Elementen, endend bei der Anzahl ende
     * (Schrittweite 1). Für jeden Baum wird die mittlere Anzahl an
     * Suchoperationen bei der Suche nach allen vorhandenen Datenelementen
     * ermittelt und ausgegeben.
     *
     * @param start minimale Anzahl an Datenelementen
     * @param ende maximale Anzahl an Datenelementen
     */
    public void BaumMessreihe(int start, int ende)
    {
        System.out.println("minimale Elementzahl des Baums: " + start);
        System.out.println("maximale Elementzahl des Baums: " + ende);
        for (int i = start; i <= ende; i++)
        {
            Erzeugen(i);
            Zaehler.ZaehlerZuruecksetzen();
            for (int j = 1; j <= i; j++)
            {
                baum.Suchen(j);
            }
            float mittelwert = Zaehler.ZaehlerGeben() / i;
            System.out.println(mittelwert);
        }
    }

    /**
     * Nacheinander werden sortierte Listen erzeugt, beginnend bei der Anzahl
     * start an Elementen, endend bei der Anzahl ende (Schrittweite 1). Für jede
     * Liste wird die mittlere Anzahl an Suchoperationen bei der Suche nach
     * allen vorhandenen Datenelementen ermittelt und ausgegeben.
     *
     * @param start minimale Anzahl an Datenelementen
     * @param ende maximale Anzahl an Datenelementen
     */
    public void ListeMessreihe(int start, int ende)
    {
        System.out.println("minimale Elementzahl der Liste: " + start);
        System.out.println("maximale Elementzahl der Liste: " + ende);
        for (int i = start; i <= ende; i++)
        {
            Erzeugen(i);
            Zaehler.ZaehlerZuruecksetzen();
            for (int j = 1; j <= i; j++)
            {
                liste.Suchen(j);
            }
            float mittelwert = Zaehler.ZaehlerGeben() / i;
            System.out.println(mittelwert);
        }
    }
}
