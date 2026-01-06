package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.einfaches_formular;

import java.util.Arrays;

/**
 * Diese Klasse definiert ein Bild, das auf einem einfachen Formular dargestellt
 * werden kann. Das Bild wird, wenn moeglich, in Orginalgroesse dargestellt. Nur
 * wenn das Formularfenster dafuer zu klein ist, wird das Bild so verkleinert,
 * dass es im Formularfenster ganz zu sehen ist. Objekte der Klasse Bild stellen
 * einige einfache Dienste zum Darstellen von Dateien des Typs jpg, png, gif,
 * eps... auf dem Zeichenfenster bereit. Die Bilder muessen im Unterordner
 * "bilder" liegen. Dieser muss sich im Verzeichnis befinden, indem auch die
 * Datei
 * org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular.Bild.class
 * liegt. Es muss dort mindestens das Standardbild mit Namen Pirateninsel.jpg
 * vorhanden sein. Versucht der Nutzer eines erfolgreich erzeugten Bildobjekts,
 * einen dateinamen zu setzen, der im Unterordner nicht vorhanden ist, dann gibt
 * es eine kurze freundliche Fehlermeldung im unteren Teil der Konsole,
 * ansonsten wird der Aenderungsversuch jedoch ignoriert.<BR>
 * <BR>
 * Technische Details werden verborgen. Das einzige Attribut internesBild eignet
 * sich (wie der Name intern andeuten soll) nicht zum Inspizieren.
 *
 * @author Ute Heuer
 *
 * @version 0.1
 */
public class Bild
{
    private org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular.Bild internesBild;

    public Bild()
    {
        internesBild = new org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular.Bild();
    }

    /**
     * Legt das Element ans Ende des Formularfensters, wenn es vorher nicht
     * angezeigt wurde.
     */
    public void anzeigen()
    {
        internesBild.anzeigen();
    }

    /**
     * Entfernt das Element vom Formularfenster
     */
    public void verstecken()
    {
        internesBild.verstecken();
    }

    /**
     * Zeigt das Bild neuerName im Formularfenster an, sofern dieses im
     * ".../bilder" Ordner vorhanden ist und das Bildobjekt gerade angezeigt
     * wird. Falls die Bilddatei zwar im Ordner ist, das Bildobjekt aber gar
     * nicht angezeigt wird, so wird der neue Name nur gespeichert. Falls das
     * Bild neuerName jedoch nicht gefunden wird, dann gibt es eine kurze
     * freundliche Fehlermeldung im unteren Teil der Konsole, ansonsten wird der
     * Aenderungsversuch jedoch einfach ignoriert. (Die Lage des Ordners bilder
     * ist in der Beschreibung der Klasse Bild vermerkt).
     */
    public void dateinameSetzen(String neuerName)
    {
        internesBild.dateinameSetzen(neuerName);
    }

    /**
     * Gibt den Namen des aktuell gesetzten Bilds zurueck.
     */
    public String dateinameGeben()
    {
        return internesBild.dateinameGeben();
    }

    /**
     * Konsolenausgabe einer Aufzaehlung aller Bildernamen im Ordner
     * ".../bilder"
     */
    public void bilderAusgeben()
    {
        System.out.println(bilderGeben());
    }

    /**
     * Gibt eine Aufzaehlung der Bildernamen zurueck, die sich im Ordner
     * ".../bilder" befinden. In dieser Version werden einfach alle Bildernamen
     * "hintereinandergeklebt". Spaeter in der 10.Klasse wird man sich eher fuer
     * ein Zeichenketten-Feld (Array) interessieren. Es erleichtert den Zugriff
     * auf einzelne Bildernamen. Dann kann bei Bedarf diese Methodendefinition
     * angepasst werden. Das ist einfach da intern eh mit dem entsprechenden
     * Feld gearbeitet wird.
     */
    public String bilderGeben()
    {
        String bilder = Arrays.asList(internesBild.bilderGeben()).toString();
        return bilder.substring(1, bilder.length() - 1);
    }
}
