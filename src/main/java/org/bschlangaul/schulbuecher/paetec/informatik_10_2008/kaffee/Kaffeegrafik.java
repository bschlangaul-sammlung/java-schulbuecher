package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.kaffee;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Bild;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Ellipse;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Rechteck;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Text;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Zeichenfenster;

/**
 * Objekte der Klasse Espressografik koennen das ("dumme") Gehaeuse eines
 * einfachen deutschen Kaffeeautomaten darstellen. Objekte der Klasse
 * Espressografik bieten folgende Dienste an: Zahlen und Texte auf dem Display
 * anzeigen und ein beliebiges Getraenk ausgeben.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 05.2008
 */
public class Kaffeegrafik
{
    /**
     * Teil der Kaffegrafik
     */
    private Rechteck gehaeuse;

    /**
     * Teil der Kaffegrafik
     */
    private Rechteck anzeigefeld;

    /**
     * Teil der Kaffegrafik
     */
    private Rechteck ausgabefeld;

    /**
     * Teil der Kaffegrafik
     */
    private Text display;

    /**
     * Teil der Kaffegrafik
     */
    private Bild becher;

    /**
     * Teil der Kaffegrafik
     */
    private Ellipse kaffee;

    /**
     * Das Attribut angezeigterInhalt haelt die Zeichenkette, die im Display des
     * Kaffeautomaten angezeigt werden soll.
     */
    private String angezeigterInhalt;

    /**
     * Fenster, in der die Kaffeegrafik dargestellt wird
     */
    private Zeichenfenster fenster;

    /**
     * Die Display-Anzeige kann initialisiert werden. Ein moeglicher Eingabewert
     * ist: "Willkommen!" . Die Anfuehrungsstriche sind noetig.
     * <p>
     * Das Display hat 12 Stellen fuer Buchstaben. Werden mehr als 12 Zeichen
     * eingegeben, dann werden nur die ersten 12 angezeigt.
     */
    public Kaffeegrafik(String begruessung)
    {
        fenster = new Zeichenfenster(400, 600);
        angezeigterInhalt = "";
        automatZeichnen();
        anzeigen(begruessung);
    }

    /**
     * Zeigt den vom Nutzer uebergebenen Hinweis im Display an, falls dieses
     * sichtbar ist. Das Display hat 12 Stellen fuer Buchstaben. Werden mehr als
     * 12 Zeichen eingegeben, dann werden nur die ersten 12 angezeigt. Ein
     * moeglicher Eingabewert ist: "waehlen" . Die Anfuehrungsstriche sind
     * noetig.
     */
    public void anzeigen(String hinweis)
    {
        angezeigterInhalt = hinweis;
        if (hinweis.length() > 12)
        {
            angezeigterInhalt = hinweis.substring(0, 11);
        }
        display.inhaltSetzen(angezeigterInhalt);
        display.anzeigen();
    }

    /**
     * Zeigt den vom Nutzer uebergebenen Geldbetrag in Cent im Display an, falls
     * dieses sichtbar ist. Das Display hat nur 4 Stellen fuer Ziffern. Wird ein
     * groesserer Geldbetrag angegeben, werden nur die letzten 4 Stellen
     * angezeigt. Ein moeglicher Eingabewert ist: 80
     */
    public void centAnzeigen(int neuerBetrag)
    {
        neuerBetrag = neuerBetrag % 10000;
        angezeigterInhalt = neuerBetrag + " Cent";
        display.inhaltSetzen(angezeigterInhalt);
        display.anzeigen();
    }

    /**
     * Zeichnet ein Becherbild in das Ausgabefach und fuellt eine graue
     * Fluessigkeit ein und zeigt das vom Nutzer gewuenschte Getraenk im Display
     * an. Ein moeglicher Eingabewert ist: "Espresso" . Die Anfuehrungsstriche
     * sind noetig.
     */
    public void becherFuellen(String neuesGetraenk)
    {
        anzeigen(neuesGetraenk);
        if (becher == null || kaffee == null)
        {
            becher = new Bild(fenster);
            becher.dateinameSetzen("Kaffeebecher.png");
            kaffee = new Ellipse(fenster);
        }
        becher.groesseSetzen(150, 200);
        becher.positionSetzen(130, 270);
        kaffee.farbeSetzen("grau");
        kaffee.positionSetzen(205, 290);
        kaffee.verstecken();
        kaffeeZeichnen();
    }
    // /**
    // * Der Dienst zeigen malt die Grafik erneut ins Zeichenfenster
    // */
    // public void zeigen() {
    // gehaeuse.anzeigen();
    // anzeigefeld.anzeigen();
    // ausgabefeld.anzeigen();
    // display.anzeigen();
    // if (becher != null)
    // becher.anzeigen();
    // if (kaffee != null)
    // kaffee.anzeigen();
    // }
    //
    // /**
    // * Der Dienst verstecken entfernt die Grafik aus dem Zeichenfenster Er hat
    // * somit die gleiche Wirkung wie der "Besen" des Zeichenfensters
    // */
    // public void verstecken() {
    // display.verstecken();
    // anzeigefeld.verstecken();
    // ausgabefeld.verstecken();
    // gehaeuse.verstecken();
    // if (becher != null)
    // becher.verstecken();
    // if (kaffee != null)
    // kaffee.verstecken();
    // }

    /**
     * Entfernt Becherbild und Fluessigkeit aus dem Ausgabefach
     */
    public void becherEntfernen()
    {
        if (becher != null)
        {
            becher.verstecken();
            becher = null;
        }
        if (kaffee != null)
        {
            kaffee.verstecken();
            kaffee = null;
        }
    }

    private void automatZeichnen()
    {
        gehaeuse = new Rechteck(fenster);
        anzeigefeld = new Rechteck(fenster);
        ausgabefeld = new Rechteck(fenster);
        display = new Text(48, fenster);
        gehaeuse.farbeSetzen("grau");
        gehaeuse.groesseSetzen(400, 500);
        anzeigefeld.farbeSetzen("weiss");
        anzeigefeld.groesseSetzen(300, 65);
        anzeigefeld.positionSetzen(50, 75);
        ausgabefeld.farbeSetzen("schwarz");
        ausgabefeld.groesseSetzen(300, 300);
        ausgabefeld.positionSetzen(50, 190);
        display.farbeSetzen("gruen");
        display.positionSetzen(75, 75);
        display.inhaltSetzen(angezeigterInhalt);
        gehaeuse.anzeigen();
        anzeigefeld.anzeigen();
        ausgabefeld.anzeigen();
        display.anzeigen();
    }

    private void kaffeeZeichnen()
    {
        becher.anzeigen();
        for (int i = 5; i < 120; i++)
        {
            kaffee.groesseSetzen(i, i / 5);
            kaffee.verschieben(-i % 2, -((i % 10) / 9));
            kaffee.anzeigen();
        }
    }
}
