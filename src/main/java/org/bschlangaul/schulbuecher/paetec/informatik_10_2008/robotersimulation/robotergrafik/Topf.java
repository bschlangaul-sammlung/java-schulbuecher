package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.robotersimulation.robotergrafik;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Bild;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.Text;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittene_grafik.interna.Zeichenfenster;

/**
 * Die Klasse Topf definiert die Funktion und Repraesentation eines Topfes
 * dieser Simulation.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Topf
{
    /**
     * haelt die xKoordinate des Topfes.
     */
    private int xPosition;

    /**
     * haelt die Breite des Topfes.
     */
    private double breite;

    /**
     * Das Attribut anzahlKugeln haelt die Anzahl der Kugeln, die sich in dem
     * Topf befinden und die angezeigt werden.
     */
    private int anzahlKugeln;

    /**
     * Das Attribut beschriftung haelt das Text-Objekt, das die Anzahl der
     * Kugeln im Topf anzeigt.
     */
    Text beschriftung;

    /**
     * Das Fenster, auf dem der Topf gezeichnet werden soll.
     */
    Zeichenfenster zeichenfenster;

    /**
     * Der Konstruktor der Klasse Topf erzeugt einen neuen Topf an der
     * uebergebenen xKoordiante und mit der durch die topfnummer definierten
     * Farbe.
     */
    public Topf(Zeichenfenster fenster, int neueXPosition, String topfID)
    {
        zeichenfenster = fenster;
        xPosition = neueXPosition;
        anzahlKugeln = 0;
        topfInitialisieren(topfID);
        beschriftungErzeugen();
        topfmarkierungErzeugen(topfID);
    }

    /**
     * Die Methode hineinfallen wird aufgerufen, wenn eine Kugel von einer
     * Position mit der x-Koordinate xKomponente losgelassen wird. Die Methode
     * prueft, ob xKomponente innerhalb des linken und des rechten Randes des
     * Topfes liegt, und erhoeht in diesem Fall den Wert des Attributs
     * anzahlKugeln um 1.
     */
    public void hineinfallen(int xKomponente)
    {
        if (xKomponente >= xPosition && xKomponente <= (xPosition + breite))
        {
            anzahlKugeln++;
            beschriftung.inhaltSetzen(kugelanzeigeNormalisieren(3));
        }
        zeichenfenster.zeichnen();
    }

    /**
     * Die Methode topfInitialisieren initialisiert den Topf mit einem passenden
     * Bild, an passender Stelle. Dies wird durch den Parameter topfID bestimmt.
     */
    private void topfInitialisieren(String topfID)
    {
        Bild topfBild = new Bild(false, zeichenfenster);
        if ("A".equals(topfID))
        {
            topfBild.dateinameSetzen("Topf1.png");
        }
        else
        {
            topfBild.dateinameSetzen("Topf2.png");
        }
        topfBild.positionSetzen(xPosition, 400);
        breite = topfBild.breiteGeben();
        topfBild.anmelden();
    }

    /**
     * Initialisiert die Beschriftung des Topfes. Es ist eine Zahl, die ueber
     * die Anzahl der Kugeln im Topf informiert.
     */
    private void beschriftungErzeugen()
    {
        beschriftung = new Text(40, false, zeichenfenster);
        beschriftung.inhaltSetzen(kugelanzeigeNormalisieren(3));
        beschriftung.positionSetzen(xPosition + 17, 420);
        beschriftung.farbeSetzen("weiss");
        beschriftung.anmelden();
    }

    private String kugelanzeigeNormalisieren(int anzahlVorkommastellen)
    {
        String normalisierteAnzeige = "" + anzahlKugeln;
        int stufenzahl = 10;
        for (int i = 1; i < anzahlVorkommastellen; i++)
        {
            if (anzahlKugeln < stufenzahl)
            {
                normalisierteAnzeige = "0" + normalisierteAnzeige;
            }
            stufenzahl = 10 * stufenzahl;
        }
        return normalisierteAnzeige;
    }

    private void topfmarkierungErzeugen(String topfID)
    {
        Text art = new Text(20, false, zeichenfenster);
        art.inhaltSetzen("Topf " + topfID);
        art.positionSetzen(xPosition + 20, 398);
        art.anmelden();
    }
}
