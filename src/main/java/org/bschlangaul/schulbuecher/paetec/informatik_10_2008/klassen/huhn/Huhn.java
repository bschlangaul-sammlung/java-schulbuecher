package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.huhn;

import static org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.werkzeuge.TonSpieler.tonDateiAbspielen;

import java.util.LinkedList;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Bild;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Dreieck;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Ellipse;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfache_grafik.Rechteck;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.interna.Zeichenfenster;

/**
 * Ein Huhnobjekt kann grafisch dargestellt werden. Es kann bewegt und
 * verkleinert werden. Es kann ein Ei legen, und aus dem zuletzt gelegten Ei
 * kann ein Huhn schluepfen. Das Ei bzw. das Kueken koennen nicht bewegt werden.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Huhn
{
    /**
     * x-Koordinate der linken oberen Ecke
     */
    private int xPosition;

    /**
     * y-Koordinate der linken oberen Ecke
     */
    private int yPosition;

    /**
     * Breite des Huhns
     */
    private int breite;

    /**
     * Hoehe des Huhns
     */
    private int hoehe;

    /**
     * Gibt an, ob das Huhn gerade fliegt
     */
    private boolean fliegt;

    /**
     * Einzelteile des Huhns
     */
    private Ellipse koerper = new Ellipse();

    private Rechteck hals = new Rechteck();

    private Ellipse kopf = new Ellipse();

    private Ellipse auge = new Ellipse();

    private Dreieck schnabel = new Dreieck();

    private Dreieck fluegel = new Dreieck();

    private Dreieck schwanz = new Dreieck();

    private Rechteck linkesBein = new Rechteck();

    private Rechteck linkerFuss = new Rechteck();

    private Rechteck rechtesBein = new Rechteck();

    private Rechteck rechterFuss = new Rechteck();

    /**
     * Erzeugt ein neues Huhn
     */
    public Huhn()
    {
        koerper.positionSetzen(300, 280);
        koerper.groesseSetzen(100, 50);
        koerper.farbeSetzen("orange");
        hals.positionSetzen(320, 245);
        hals.groesseSetzen(10, 50);
        hals.farbeSetzen("grau");
        kopf.positionSetzen(300, 200);
        kopf.groesseSetzen(50, 50);
        kopf.farbeSetzen("rot");
        auge.positionSetzen(315, 215);
        auge.groesseSetzen(10, 10);
        auge.farbeSetzen("schwarz");
        schnabel.positionSetzen(280, 225);
        schnabel.groesseSetzen(40, 20);
        schnabel.farbeSetzen("gelb");
        fluegel.positionSetzen(335, 290);
        fluegel.groesseSetzen(50, 30);
        fluegel.farbeSetzen("cyan");
        schwanz.positionSetzen(382, 300);
        schwanz.groesseSetzen(30, 12);
        schwanz.farbeSetzen("orange");
        linkesBein.positionSetzen(340, 323);
        linkesBein.groesseSetzen(5, 30);
        linkesBein.farbeSetzen("grau");
        linkerFuss.positionSetzen(330, 350);
        linkerFuss.groesseSetzen(10, 3);
        linkerFuss.farbeSetzen("orange");
        rechtesBein.positionSetzen(370, 323);
        rechtesBein.groesseSetzen(5, 30);
        rechtesBein.farbeSetzen("grau");
        rechterFuss.positionSetzen(360, 350);
        rechterFuss.groesseSetzen(10, 3);
        rechterFuss.farbeSetzen("orange");
        /*
         * Position des Huhns setzen
         */
        xPosition = 280;
        yPosition = 200;
        /*
         * Groesse des Huhns festlegen
         */
        breite = 100;
        hoehe = 150;
        verschieben(0, -50);
        Rechteck r = new Rechteck();
        r.groesseSetzen(1600, 10);// Zeichenfenster.zeichenfensterGeben().breiteGeben()
        r.positionSetzen(0, 300);
        r.farbeSetzen("schwarz");
        r.anzeigen();
        int anzahl = 80;// Zeichenfenster.zeichenfensterGeben().breiteGeben() /
                        // 20;
        LinkedList<Dreieck> strohListe = new LinkedList<Dreieck>();
        for (int i = 0; i < anzahl; i++)
        {
            Dreieck stroh = new Dreieck();
            stroh.positionSetzen(i * 20,
                    Zeichenfenster.zeichenfensterGeben().hoeheGeben() - 40);
            stroh.groesseSetzen(20, 40);
            stroh.farbeSetzen("gelb");
            strohListe.add(stroh);
            stroh.anzeigen();
        }
        fliegt = false;
        anzeigen();
    }

    /**
     * Das Huhn wird auf dem Zeichenfenster sichtbar gemacht.
     */
    public void anzeigen()
    {
        koerper.anzeigen();
        hals.anzeigen();
        kopf.anzeigen();
        auge.anzeigen();
        schnabel.anzeigen();
        fluegel.anzeigen();
        schwanz.anzeigen();
        linkesBein.anzeigen();
        linkerFuss.anzeigen();
        rechtesBein.anzeigen();
        rechterFuss.anzeigen();
    }

    /**
     * Das Huhn wird unsichtbar gemacht.
     */
    public void verstecken()
    {
        koerper.verstecken();
        hals.verstecken();
        kopf.verstecken();
        auge.verstecken();
        schnabel.verstecken();
        fluegel.verstecken();
        schwanz.verstecken();
        linkesBein.verstecken();
        linkerFuss.verstecken();
        rechtesBein.verstecken();
        rechterFuss.verstecken();
    }

    /**
     * Diese Methode veraendert die Position des Huhns im Zeichenfenster um die
     * angegebenen Werte. Es wird um deltaX auf der x-Achse und um deltaY auf
     * der y-Achse verschoben.
     */
    public void verschieben(int deltaX, int deltaY)
    {
        if (yPosition + deltaY > 150)
        {
            deltaY = 150 - yPosition;
        }
        koerper.verschieben(deltaX, deltaY);
        hals.verschieben(deltaX, deltaY);
        kopf.verschieben(deltaX, deltaY);
        auge.verschieben(deltaX, deltaY);
        schnabel.verschieben(deltaX, deltaY);
        fluegel.verschieben(deltaX, deltaY);
        schwanz.verschieben(deltaX, deltaY);
        linkesBein.verschieben(deltaX, deltaY);
        linkerFuss.verschieben(deltaX, deltaY);
        rechtesBein.verschieben(deltaX, deltaY);
        rechterFuss.verschieben(deltaX, deltaY);
        xPosition = xPosition + deltaX;
        yPosition = yPosition + deltaY;
        if (yPosition < 150 && !fliegt)
        {
            fliegt = true;
            fluegel.verschieben(0, -30);
        }
        if (yPosition == 150 && fliegt)
        {
            fliegt = false;
            fluegel.verschieben(0, 30);
        }
    }

    /**
     * Diese Methode laesst das Huhn ein (weiteres) Ei legen.
     */
    public void eiLegen()
    {
        if (yPosition != 150)
            return;
        Bild ei = new Bild();
        ei.dateinameSetzen("ei.jpg");
        ei.positionSetzen(xPosition + breite,
                Zeichenfenster.zeichenfensterGeben().hoeheGeben() - 50);
        ei.groesseSetzen(breite / 3, hoehe / 3);
        ei.anzeigen();
        tonDateiAbspielen("huhn.wav");
    }
}
