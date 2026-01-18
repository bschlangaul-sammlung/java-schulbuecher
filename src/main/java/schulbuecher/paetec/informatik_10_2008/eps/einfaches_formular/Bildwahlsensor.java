package schulbuecher.paetec.informatik_10_2008.eps.einfaches_formular;

import schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular.Sensor;

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
 * @author Ute Heuer
 *
 * @version 0.1
 */
public class Bildwahlsensor extends Sensor
{
    private Eingabefeld feld;

    private Bild bild;

    public Bildwahlsensor()
    {
        super();
        textSetzen("gewaehltes Bild anzeigen");
        feld = new Eingabefeld();
        Text anzeige = new Text();
        bild = new Bild();
        feld.beschriftungSetzen("gewaehltes Bild:");
        feld.inhaltSetzen(bild.dateinameGeben());
        feld.anzeigen();
        anzeige.inhaltSetzen(
                "Zur Verfuegung stehen folgende Bilder: " + bild.bilderGeben());
        anzeige.anzeigen();
    }

    /**
     * Wenn der zugehoerige Menueeintrag "gewaehltes Bild anzeigen" angewaehlt
     * wird, dann wird die Methode ausloesen() aufgerufen.
     */
    public void ausloesen()
    {
        bild.verstecken();
        bild.dateinameSetzen(feld.inhaltGeben());
        bild.anzeigen();
    }
}
