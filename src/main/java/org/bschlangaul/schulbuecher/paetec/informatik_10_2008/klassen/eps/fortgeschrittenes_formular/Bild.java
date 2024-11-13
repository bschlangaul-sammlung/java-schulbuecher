package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittenes_formular;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittenes_formular.interna.BildSpeicher;

/**
 * Diese Klasse implementiert ein Bild, das auf einem einfachen Formular
 * dargestellt werden kann. Objekte der Klasse Bild stellen einige einfache
 * Dienste zum Darstellen von Dateien des Typs jpg, png, gif... auf dem
 * Zeichenfenster bereit. Die Bilder muessen im Unterordner "bilder" liegen.
 * Dieser muss sich im Verzeichnis befinden, indem auch die Datei
 * eps.fortgeschrittenesFormular.Bild.class liegt. Es muss dort mindestens das
 * Standardbild mit Namen "Pirateninsel.jpg" vorhanden sein. Versucht der Nutzer
 * eines erfolgreich erzeugten Bildobjekts, einen dateinamen zu setzen, der im
 * Unterordner nicht vorhanden ist, dann gibt es eine kurze freundliche
 * Fehlermeldung auf der Konsole und der Zustand des Bildobjekts aendert sich
 * nicht.
 *
 * @author Florian Prager, Universität Passau
 */
public class Bild extends Formulargrafik
{
    private static String pfadprefix = "bilder/";

    private String dateiname;

    public Bild(String neuerDateiname)
    {
        dateiname = neuerDateiname;
    }

    public Bild()
    {
        dateiname = "Pirateninsel.jpg";
    }

    public Bild(String neuerDateiname, Formular formular)
    {
        super(formular);
        if (neuerDateiname != null)
            dateiname = neuerDateiname;
    }

    public Bild(Formular formular)
    {
        super(formular);
        this.dateiname = "Pirateninsel.jpg";
    }

    /**
     * Liefert eine Liste aller Dateien im Verzeichnis "bilder".
     *
     * @return die Bilderliste
     */
    public static String[] bilderGeben()
    {
        URL u = Bild.class.getResource(pfadprefix);
        if (u == null || u.getPath() == null)
            return new String[0];
        File file = new File(pfadFormatieren(u.getPath()));
        if (file == null || file.list() == null)
            return new String[0];
        String[] dateiliste = file.list();
        ArrayList<String> umgefuellteListe = new ArrayList<String>();
        umgefuellteListe.addAll(Arrays.asList(dateiliste));
        Iterator<String> it = umgefuellteListe.iterator();
        while (it.hasNext())
        {
            if (!BildSpeicher.istDateiDarstellbar(it.next()))
            {
                it.remove();
            }
        }
        return umgefuellteListe.toArray(new String[0]);
    }

    // /**
    // * Aendert das dargestellte Bild.
    // * toDo: Refactoring -> Rechtschreibfehler entfernen in allen
    // Nutzerklassen!
    // * Dann dateinamenSetzen loeschen und nur noch dateinameSetzen behalten!
    // * @param neuerDateiname
    // * der relative Pfad des neuen Bildes
    // */
    public void dateinamenSetzen(String neuerDateiname)
    {
        // dateiname = neuerDateiname;
        // formularGeben().formularAktualisieren();
    }

    /**
     * Aendert das dargestellte Bild, sofern die angegebene Datei vorhanden ist.
     * Ansonsten wird nichts geaendert.
     *
     * @param neuerDateiname der relative Pfad des neuen Bildes
     */
    public void dateinameSetzen(String neuerDateiname)
    {
        Image bild = BildSpeicher.speicherGeben().ladeBild(neuerDateiname);
        if (bild != null)
        {
            dateiname = neuerDateiname;
            formularGeben().formularAktualisieren();
        }
    }

    public String dateinameGeben()
    {
        return dateiname;
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    void formatieren()
    {
        Image bild = BildSpeicher.speicherGeben().ladeBild(dateiname);
        if (bild == null && !dateiname.equals("Pirateninsel.jpg"))
        {
            dateiname = "Pirateninsel.jpg";
            formatieren();
        }
        else if (bild != null)
        {
            BildLeinwand leinwand = new BildLeinwand(bild);
            awtKomponenteSetzen(leinwand);
        }
    }

    private static String pfadFormatieren(String pfad)
    {
        return pfad.replace("%20", " ").replace("%25", "%")
                .replace("%c3%84", "\u00C4").replace("%c3%96", "\u00D6")
                .replace("%c3%9c", "\u00DC").replace("%c3%a4", "\u00E4")
                .replace("%c3%b6", "\u00F6").replace("%c3%bc", "ü")
                .replace("%3d", "=").replace("%5b", "[").replace("%5d", "]")
                .replace("%7b", "{").replace("%7d", "}").replace("%60", "`")
                .replace("%C3%84", "\u00C4").replace("%C3%96", "\u00D6")
                .replace("%C3%9C", "\u00DC").replace("%C3%A4", "\u00E4")
                .replace("%C3%C6", "\u00F6").replace("%C3%BC", "ü")
                .replace("%3D", "=").replace("%5B", "[").replace("%5D", "]")
                .replace("%7B", "{").replace("%7D", "}");
    }

    private class BildLeinwand extends JPanel
    {
        private static final long serialVersionUID = 1L;

        private Image bild;

        public BildLeinwand(Image bild)
        {
            Image bildKorrigiert = bild;
            setBounds(0, 0, bildKorrigiert.getWidth(this),
                    bildKorrigiert.getHeight(this));
            if (bildKorrigiert.getWidth(this) > formularGeben().breiteGeben())
            {
                double verhaeltnis = (double) bildKorrigiert.getWidth(this)
                        / (double) bildKorrigiert.getHeight(this);
                double doubleBreite = (double) formularGeben().breiteGeben();
                bildKorrigiert = bildKorrigiert.getScaledInstance(
                        formularGeben().breiteGeben(),
                        (int) Math.round(doubleBreite / verhaeltnis),
                        Image.SCALE_SMOOTH);
                setBounds(0, 0, formularGeben().breiteGeben(),
                        (int) Math.round(doubleBreite / verhaeltnis));
            }
            setBackground(Color.white);
            this.bild = bildKorrigiert;
        }

        public void paint(Graphics g)
        {
            super.paint(g);
            g.drawImage(bild, 0, 0, this);
        }
    }
}
