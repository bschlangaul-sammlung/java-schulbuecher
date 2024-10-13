package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.einfaches_formular;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittenes_formular.Sensor;

/**
 * Diese Klasse soll exemplarisch zeigen, wie einfache Benutzerinteraktion
 * fakultativ in der 10.Klasse umgesetzt werden koennte.<BR>
 * Sensorobjekte kann man sich als Bausteine vorstellen, die automatisch nach
 * Erzeugung dem Menue des (Standard-)Formulars am Ende hinzugefuegt werden.<BR>
 * Das Anzeigen bereits angezeigter Sensorobjekte ist wirkungslos. Das
 * Verstecken sorgt fuer ein Verschwinden des zugehoerigen Menueeintrags.
 * Erneutes Anzeigen fuegt den Menueeintrag am Ende hinzu. Angezeigte
 * Sensorobjekte reagieren auf Auswahl "ihres" Menueeintrags (d.h. ein Mensch
 * waehlt z.B. mit Maus im Formularfenster unter der Rubrik Ereignisse aus) wie
 * in der Methode ausloesen festgelegt.<BR>
 * Der Beschreibungstext, der im Menueeintrag zu lesen ist, kann auch nach
 * Erzeugung eines Sensorobjekts jederzeit mit dem Dienst textSetzen passend
 * festgelegt werden. Die Dienste anzeigen, verstecken und textSetzen sind in
 * der abstrakten Klasse Sensor definiert. In Unterklassen dieser Klasse Sensor,
 * wie z.B. der Klasse Bildanzeigesensor ist typischerweise folgendes zu
 * definieren: <BR>
 * geeignete Attribute, <BR>
 * ein Konstruktor, welcher Beziehungen zu Objekten aufbaut, die 1) bei
 * Ausloesen zu reagieren haben oder/und 2) Nutzereingaben bereithalten <BR>
 * die Methode ausloesen in welcher passende Reaktionen festgelegt sind. Eine
 * Definition der Methode auslosen wird von der Oberklasse Sensor erzwungen in
 * jeder Unterklasse.
 *
 *
 * @author Ute Heuer
 *
 * @version 0.1
 */
public class Bildanzeigesensor extends Sensor
{
    private Bild grafik;

    private String name;

    private boolean grafikWirdAngezeigt;

    /**
     * Sie muessen eine Bildbeschreibung angeben. Bevor Sie diesen Konstruktor
     * aufrufen, empfiehlt es sich, ein Bild erzeugt zu haben. Dieses können Sie
     * dann als zweiten Eingangswert im Konstruktors einfuellen.
     */
    public Bildanzeigesensor(String bildbeschreibung, Bild gewuenschtesBild)
    {
        super();
        name = bildbeschreibung;
        grafik = gewuenschtesBild;
        textSetzen(name + " anzeigen");
    }

    /**
     * Wenn der zugehoerige Menueeintrag (siehe auch Attribut name...)
     * angewaehlt wird, dann wird die Methode ausloesen() aufgerufen.
     */
    public void ausloesen()
    {
        if (grafikWirdAngezeigt)
        {
            grafik.verstecken();
            textSetzen(name + " anzeigen");
            grafikWirdAngezeigt = false;
        }
        else
        {
            grafik.anzeigen();
            textSetzen(name + " verstecken");
            grafikWirdAngezeigt = true;
        }
    }
}
