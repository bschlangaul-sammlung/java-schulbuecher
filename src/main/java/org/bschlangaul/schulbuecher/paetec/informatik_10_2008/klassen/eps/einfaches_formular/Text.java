package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfaches_formular;

/**
 * Diese Klasse definiert einen einfachen Text, der auf dem Standard-Formular
 * angezeigt werden kann. Dort wird automatisch zentriert und umgebrochen, je
 * nach aktueller Groesse des Formularfensters. Die Schriftart und die Farbe des
 * Textes koennen veraendert werden.<BR>
 * Technische Details werden verborgen. Das einzige Attribut internerText eignet
 * sich (wie der Name intern andeuten soll) nicht zum Inspizieren.
 *
 * @author Ute Heuer
 *
 * @version 0.1
 */
public class Text
{
    private org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittenes_formular.Text internerText;

    /**
     * Ein Standard-Text wird erzeugt. Dieser wird jedoch noch nicht im
     * Formularfenster angezeigt.
     */
    public Text()
    {
        internerText = new org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittenes_formular.Text();
    }

    /**
     * Legt den Text ans Ende des Formularfensters, wenn er vorher nicht
     * angezeigt wurde.
     */
    public void anzeigen()
    {
        internerText.anzeigen();
    }

    /**
     * Entfernt den Text vom Formularfenster
     */
    public void verstecken()
    {
        internerText.verstecken();
    }

    /**
     * Gibt die Schriftgroesse des Textes zurueck.
     */
    public int groesseGeben()
    {
        return internerText.groesseGeben();
    }

    /**
     * Die Schriftgroesse des Textes kann geaendert werden. Es koennen nur
     * Schriftgroessen im Bereich 1 bis 35 angezeigt werden. Bei
     * Bereichsueberschreitung wird 35, bei -unterschreitung wird 1 gesetzt und
     * entsprechendes angezeigt.
     */
    public void groesseSetzen(int neueSchriftgroesse)
    {
        internerText.groesseSetzen(neueSchriftgroesse);
    }

    /**
     * Gibt den Textinhalt zurueck.
     */
    public String inhaltGeben()
    {
        return internerText.inhaltGeben();
    }

    /**
     * Aendert den Text, der neue Inhalt wird anstelle des alten angezeigt.
     */
    public void inhaltSetzen(String neuerInhalt)
    {
        internerText.inhaltSetzen(neuerInhalt);
    }

    /**
     * Die Farbe des Textes kann gewaehlt werden. Mögliche Farben sind: "weiss",
     * "gelb", "orange", "rot", "pink", "magenta", "cyan", "gruen", "blau",
     * "grau", "schwarz" Achtung: Die Anfuehrungsstriche sind noetig! Alle
     * anderen Eingabewerte werden ignoriert.
     */
    public void farbeSetzen(String neueFarbe)
    {
        internerText.farbeSetzen(neueFarbe);
    }
}
