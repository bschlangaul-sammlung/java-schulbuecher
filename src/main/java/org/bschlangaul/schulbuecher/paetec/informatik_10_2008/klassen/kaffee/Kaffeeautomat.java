package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.kaffee;

/**
 * Die Klasse Kaffeeautomat ist das "Gehirn" der Simulation. Diese Klasse
 * simuliert die Funktionsweise eines Kaffeeautomaten.
 *
 * @author Florian Prager, Ute Heuer, Universität Passau
 *
 * @version 02.2008
 */
public class Kaffeeautomat
{
    /**
     * Der Zustand des Automaten
     */
    private String zustand;

    /**
     * Der Preis eines Getraenks
     */
    private int preis;

    /**
     * Der bisher eingeworfene Betrag
     */
    private int betrag;

    /**
     * Die Grafik des Automaten
     */
    private Kaffeegrafik animation;

    /**
     * Der Getraenkepreis wird vom Automatenbesitzer im Konstruktor festgelegt.
     * Unsinnige Getraenke- preise (kleiner 1 Cent) werden nicht abgefangen.
     */
    public Kaffeeautomat(int neuerPreis)
    {
        zustand = "bereit";
        preis = neuerPreis;
        betrag = 0;
        animation = new Kaffeegrafik("bereit");
    }

    /**
     * Befindet sich ein Becher im Ausgabefach, dann entfernt die Methode
     * becherNehmen() diesen.
     */
    public void becherNehmen()
    {
        if (zustand.equals("Getraenk im Ausgabefach"))
        {
            animation.becherEntfernen();
            animation.anzeigen("bereit");
            zustand = "bereit";
        }
    }

    /**
     * Wenn der Benutzer bereits genuegend bezahlt hat, dann kann er ein
     * Getraenk waehlen. als Wert des Eingangsparameters einfach das gewuenschte
     * Getraenk waehlen. (getraenk ist vom Typ String, Werte muessen mit
     * Anfuehrungszeichen " " eingefasst werden.)
     */
    public void getraenkWaehlen(String getraenk)
    {
        if (zustand.equals("bezahlt"))
        {
            animation.becherFuellen(getraenk);
            betrag = 0;
            zustand = "Getraenk im Ausgabefach";
        }
    }

    /**
     * Der Benutzer kann nur Muenzen einwerfen, wenn er noch nicht genuegend
     * bezahlt hat. Der Automat nimmt auch keine Muenzen an, wenn ein Becher im
     * Ausgabefach ist. Der Benutzer hat bezahlt und darf ein Getraenk waehlen,
     * wenn der eingeworfene Muenzwert zusammen mit dem bisherigen eingeworfenen
     * Betrag den Preis eines Getraenks erreicht oder uebersteigt. muenzwert -
     * hier darf angegeben werden, was an Kleingeldwerten zur Verfuegung
     * steht...
     */
    public void muenzeEinwerfen(int muenzwert)
    {
        if (zustand.equals("bereit"))
        {
            betrag = betrag + muenzwert;
            if (betrag >= preis)
            {
                zustand = "bezahlt";
                animation.anzeigen("waehlen");
            }
            else
            {
                animation.centAnzeigen(betrag);
            }
        }
    }
    // /**
    // * Der Dienst anzeigen stoesst ein Neuzeichnen des Automatengehaeuses an.
    // */
    // public void anzeigen() {
    // animation.zeigen();
    // }
    //
    // /**
    // * Der Dienst verstecken stoesst das Löschen der graphischen Darstellung
    // * dieses Kaffeeautomaten an. Anmerkung: Auch nach Aufruf von "verstecken"
    // * steht der Dienst anzeigen wie gewohnt zur Verfuegung.
    // */
    // public void verstecken() {
    // animation.verstecken();
    // }
}
