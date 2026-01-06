package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.notizzettel;

import java.util.ArrayList;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular.Eingabefeld;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular.Formular;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular.Text;
import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.werkzeuge.TextdateiWerkstatt;

/**
 * Ein simples Schreibblatt, dass man auch als Textdatei auf der Festplatte
 * speichern kann. Wo die Textdatei gespeichert werden soll, kann ueber den
 * ueblichen Dateidialog ausgewaehlt werden. Die Navigation beginnt im
 * "Wurzelordner" dieses Projekts.
 *
 * @author Ute Heuer, Florian Prager Universität Passau
 *
 * @version 02.2008
 */
public class Schreiber
{
    /**
     * Das Arbeiterobjekt zum Speichern und Einlesen von Texten
     */
    private TextdateiWerkstatt datei = new TextdateiWerkstatt();

    /**
     * Das Formular, auf das geschrieben wird
     */
    private Formular einfachesFormular;

    /**
     * Die Liste der dargestellten Texte
     */
    private ArrayList<String> texte;

    /**
     * Hier kann Text eingegeben werden. Siehe Kommentar im Konstruktor.
     */
    private Eingabefeld feld;

    /**
     * Erzeugt einen neuen Schreiber
     */
    public Schreiber()
    {
        this.einfachesFormular = new Formular();
        texte = new ArrayList<String>();
        /*
         * Folgende Zeilen koennen zusammen mit den auskommentierten
         * import-Anweisungen und der Deklaration des Attributs feld zu
         * Demonstrationszwecken einkommentiert werden. Verstehen koennen
         * Schueler die Klassenstrukturen (der Sensoren) erst, wenn Sie etwas
         * ueber Vererbung gelernt haben. Deshalb wurden die Sensoren in diesem
         * Projekt im "Unterordner" interna "versteckt".
         */
        // feld = new Eingabefeld(einfachesFormular);
        // feld.anzeigen();
        // new Schreibsensor(this, feld, einfachesFormular).anzeigen();
        // new Speichersensor(this, einfachesFormular).anzeigen();
        // new Lesesensor(this, einfachesFormular).anzeigen();
        // new Loeschsensor(this, einfachesFormular).anzeigen();
    }

    /**
     * Schreibt einen neuen Text auf das Formular. Eingefuellt werden kann
     * entweder ein Text, der in Anfuehrungsstriche einzufassen ist: "Guten
     * Morgen" oder eine Zahl: 123 oder 34.56 oder -7.8 oder ein Objektname
     * eines Objekts, welches vorher erzeugt wurde.
     */
    public void schreiben(Object o)
    {
        new Text(o.toString(), einfachesFormular).anzeigen();
        texte.add(o.toString());
    }

    /**
     * Bietet zunaechst einen Dialog zum Oeffnen einer Datei an. Liest dann den
     * Inhalt der ausgewaehlten Textdatei und stellt ihn auf dem Formular dar.
     * Dabei wir der alte Inhalt, falls einer da war, geloescht. Falls der
     * Nutzer den Dialog zum Oeffnen abbricht, wird keine Zustandsaenderung
     * durchgefuehrt, "alles bleibt beim Alten". Falls der Nutzer versucht eine
     * nicht lesbare Datei zu öffnen, wird die Ausfuehrung des Programms mit
     * einer Fehlermeldung abgebrochen. In Ordnern kann wie gewohnt navigiert
     * werden. Beim Versuch, einen ganzen Ordner einzulesen, wird die
     * Ausfuehrung des Programms mit einer Fehlermeldung abgebrochen. Der
     * Schreiber zeigt den zuletzt verwendeten Ordner im Dialog zum Oeffnen
     * einer Datei an.
     */
    public void textEinlesen()
    {
        ArrayList<String> textspeicher = datei
                .absatzlisteLesen(einfachesFormular);
        if (textspeicher == null)
            return;// Bei Abbruch des Dialogs durch den Nutzer wird null
                   // zurueckgegeben
        loeschen();
        texte = textspeicher;// Attribut aktualisieren
        for (String absatz : texte)
        {
            new Text(absatz, einfachesFormular).anzeigen();
        }
    }

    /**
     * Der Inhalt unseres Formulars wird in eine Textdatei geschrieben. Dazu
     * öffnet sich zunaechst ein ueblicher Dateidialog. Der Schreiber zeigt den
     * zuletzt verwendeten Ordner im Dialog zum Speichern einer Datei an. Es
     * kann von dort wie gewohnt navigiert werden. Beispiel fuer einen
     * Dateinamen: Witz.txt Der Dateityp .txt wird nicht automatisch an den
     * Namen angehaengt, er ist bitte anzugeben! Vor dem Ueberschreiben einer
     * existierenden Datei wird gewarnt. Bei Schreibfehlern (etwa wenn versucht
     * wird eine Datei ohne Schreibzugriff zu ueberschreiben), wird die
     * Ausfuehrung des Programms mit einer Fehlermeldung abgebrochen.
     */
    public void textSpeichern()
    {
        datei.speichern(einfachesFormular, texte);
    }

    /**
     * Loescht den Inhalt des Formulars
     */
    public void loeschen()
    {
        texte.clear();
        einfachesFormular.formulargrafikenLöschen();
        if (feld != null)
        {
            feld.anzeigen();
        }
    }
}
