package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.kaffeeautomaten;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Bild;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Ellipse;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Rechteck;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Text;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Zeichenfenster;

/**
 * Objekte der Klasse Espressografik koennen das ("dumme") Gehaeuse eines
 * einfachen italienischen Kaffeeautomaten darstellen. Objekte der Klasse
 * Espressografik bieten folgende Dienste an: Zahlen und Texte auf dem Display
 * anzeigen und ein beliebiges Getraenk ausgeben.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 05.2008
 */
public class Espressografik
{
    /**
     * Teil der Espressografik
     */
    private Rechteck gehaeuse;

    /**
     * Teil der Espressografik
     */
    private Rechteck anzeigefeld;

    /**
     * Teil der Espressografik
     */
    private Rechteck ausgabefeld;

    /**
     * Teil der Espressografik
     */
    private Text display;

    /**
     * Teil der Espressografik
     */
    private Bild becher;

    /**
     * Teil der Espressografik
     */
    private Ellipse kaffee;

    private Ellipse crema;

    /**
     * Teil der Espressografik
     */
    private Ellipse linkeObereEcke;

    /**
     * Teil der Espressografik
     */
    private Ellipse rechteObereEcke;

    /**
     * Teil der Espressografik
     */
    private Rechteck duesenVerkleidung;

    /**
     * Teil der Espressografik
     */
    private Rechteck linkeDuese;

    /**
     * Teil der Espressografik
     */
    private Rechteck rechteDuese;

    /**
     * Das Attribut angezeigterInhalt haelt den Text, der im Display des
     * Espressoautomaten angezeigt werden soll.
     */
    private String angezeigterInhalt;

    /**
     * Das Fenster, in dem die Kaffeegrafik gezeichnet wird
     */
    private Zeichenfenster fenster;

    /**
     * Die Display-Anzeige kann initialisiert werden. Ein moeglicher Eingabewert
     * ist: "Willkommen!" . Die Anfuehrungsstriche sind noetig.
     * <p>
     * Das Display hat 12 Stellen fuer Buchstaben. Werden mehr als 12 Zeichen
     * eingegeben, dann werden nur die ersten 12 angezeigt.
     */
    public Espressografik(String text)
    {
        fenster = new Zeichenfenster(400, 600);
        angezeigterInhalt = "";
        automatZeichnen();
        anzeigen(text);
    }

    /**
     * Die Display-Anzeige wird mit einem Standardwert initialisiert.
     */
    public Espressografik()
    {
        fenster = new Zeichenfenster(400, 600);
        angezeigterInhalt = "";
        automatZeichnen();
        bereitAnzeigen();
    }

    /**
     * Zeigt den vom Nutzer uebergebenen Hinweis im Display an. Das Display hat
     * 12 Stellen fuer Buchstaben. Werden mehr als 12 Zeichen eingegeben, dann
     * werden nur die ersten 12 angezeigt. Ein moeglicher Eingabewert ist:
     * "waehlen" . Die Anfuehrungsstriche sind noetig.
     */
    private void anzeigen(String hinweis)
    {
        angezeigterInhalt = hinweis;
        if (hinweis.length() > 16)
        {
            angezeigterInhalt = hinweis.substring(0, 15);
        }
        display.inhaltSetzen(angezeigterInhalt);
        display.anzeigen();
    }

    /**
     * Zeigt die Zeichenkette "pronto" (ital. bereit) im Display an.
     */
    public void bereitAnzeigen()
    {
        anzeigen("pronto");
    }

    /**
     * Zeigt die Zeichenkette "selezionare" (ital. waehlen) im Display an.
     */
    public void waehlenAnzeigen()
    {
        anzeigen("selezionare");
    }

    /**
     * Zeigt den vom Nutzer uebergebenen Geldbetrag in Cent im Display an. Das
     * Display hat nur 6 Stellen fuer Ziffern. Wird ein groesserer Geldbetrag
     * angegeben, werden nur die letzten 6 Stellen angezeigt. Ein moeglicher
     * Eingabewert ist: 80
     */
    public void centAnzeigen(int neuerBetrag)
    {
        neuerBetrag = neuerBetrag % 1000000;
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
        if (becher == null || kaffee == null || crema == null)
        {
            duesenAusfahren();
            becher = new Bild(fenster);
            becher.dateinameSetzen("Tasse.png");
            kaffee = new Ellipse(fenster);
            crema = new Ellipse(fenster);
        }
        becher.groesseSetzen(161, 108);
        becher.positionSetzen(130, 370);
        kaffee.farbeSetzen("grau");
        kaffee.positionSetzen(195, 384);
        kaffee.groesseSetzen(0, 0);
        kaffee.anzeigen();
        kaffeeZeichnen();
        crema.farbeSetzen("gelb");
        crema.positionSetzen(195, 384);
        crema.groesseSetzen(0, 0);
        crema.anzeigen();
        cremaZeichnen();
    }
    // /**
    // * Der Dienst zeigen malt die Grafik erneut ins Zeichenfenster
    // */
    // public void zeigen() {
    // gehaeuse.anzeigen();
    // anzeigefeld.anzeigen();
    // ausgabefeld.anzeigen();
    // display.anzeigen();
    // linkeObereEcke.anzeigen();
    // rechteObereEcke.anzeigen();
    // duesenVerkleidung.anzeigen();
    // linkeDuese.anzeigen();
    // rechteDuese.anzeigen();
    // if (becher != null)
    // becher.anzeigen();
    // if (kaffee != null)
    // kaffee.anzeigen();
    // }
    // /**
    // * Der Dienst verstecken entfernt die Grafik aus dem Zeichenfenster Er hat
    // * somit die gleiche Wirkung wie der "Besen" des Zeichenfensters
    // */
    // public void verstecken() {
    // duesenVerkleidung.verstecken();
    // linkeDuese.verstecken();
    // rechteDuese.verstecken();
    // linkeObereEcke.verstecken();
    // rechteObereEcke.verstecken();
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
        if (crema != null)
        {
            crema.verstecken();
            crema = null;
        }
        if (kaffee != null)
        {
            kaffee.verstecken();
            kaffee = null;
            duesenEinfahren();
        }
    }

    private void automatZeichnen()
    {
        gehaeuse = new Rechteck(fenster);
        anzeigefeld = new Rechteck(fenster);
        ausgabefeld = new Rechteck(fenster);
        display = new Text(32, fenster);
        gehaeuse.farbeSetzen("rot");
        gehaeuse.groesseSetzen(400, 500);
        anzeigefeld.farbeSetzen("weiss");
        anzeigefeld.groesseSetzen(300, 43);
        anzeigefeld.positionSetzen(50, 100);
        ausgabefeld.farbeSetzen("schwarz");
        ausgabefeld.groesseSetzen(300, 240);
        ausgabefeld.positionSetzen(50, 250);
        display.farbeSetzen("blau");
        display.positionSetzen(85, 100);
        display.inhaltSetzen(angezeigterInhalt);
        linkeObereEcke = new Ellipse(fenster);
        rechteObereEcke = new Ellipse(fenster);
        linkeObereEcke.farbeSetzen("rot");
        rechteObereEcke.farbeSetzen("rot");
        linkeObereEcke.groesseSetzen(50, 50);
        linkeObereEcke.positionSetzen(25, 225);
        rechteObereEcke.groesseSetzen(50, 50);
        rechteObereEcke.positionSetzen(325, 225);
        duesenVerkleidung = new Rechteck(fenster);
        linkeDuese = new Rechteck(fenster);
        rechteDuese = new Rechteck(fenster);
        duesenVerkleidung.farbeSetzen("blau");
        linkeDuese.farbeSetzen("blau");
        rechteDuese.farbeSetzen("blau");
        duesenVerkleidung.groesseSetzen(50, 15);
        linkeDuese.groesseSetzen(10, 10);
        rechteDuese.groesseSetzen(10, 10);
        duesenVerkleidung.positionSetzen(175, 250);
        linkeDuese.positionSetzen(185, 265);
        rechteDuese.positionSetzen(205, 265);
        gehaeuse.anzeigen();
        anzeigefeld.anzeigen();
        ausgabefeld.anzeigen();
        display.anzeigen();
        linkeObereEcke.anzeigen();
        rechteObereEcke.anzeigen();
        duesenVerkleidung.anzeigen();
        linkeDuese.anzeigen();
        rechteDuese.anzeigen();
    }

    private void duesenAusfahren()
    {
        for (int i = 1; i <= 60; i++)
        {
            duesenVerkleidung.groesseSetzen(50, 15 + i);
            linkeDuese.positionSetzen(185, 265 + i);
            rechteDuese.positionSetzen(205, 265 + i);
        }
    }

    private void duesenEinfahren()
    {
        for (int i = 60; i >= 1; i--)
        {
            duesenVerkleidung.groesseSetzen(50, 15 + i);
            linkeDuese.positionSetzen(185, 265 + i);
            rechteDuese.positionSetzen(205, 265 + i);
        }
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

    private void cremaZeichnen()
    {
        becher.anzeigen();
        kaffee.anzeigen();
        for (int i = 5; i < 30; i++)
        {
            crema.groesseSetzen(i, i / 5);
            crema.verschieben(-i % 2, -((i % 10) / 9));
            crema.anzeigen();
        }
    }
}
