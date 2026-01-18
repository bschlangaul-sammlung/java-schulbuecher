package schulbuecher.paetec.informatik_10_2008.eps.einfaches_formular;

import schulbuecher.paetec.informatik_10_2008.eps.werkzeuge.Notiz;

/**
 * Diese Klasse definiert ein simples Eingabefeld, das Benutzereingaben
 * entgegennehmen kann. Auf die Ausrichtung im Formularfenster kann kein
 * Einfluss genommen werden. Der rechteckige Bereich in den im Formularfenster
 * geschrieben werden kann wird in der rechten Haelfte des Fensters
 * positioniert, die Beschriftung desselben wird links daneben linksbuendig
 * angezeigt.<BR>
 * <BR>
 * Technische Details werden in dieser Umsetzung verborgen. Das einzige Attribut
 * internesEingabefeld eignet sich (wie der Name intern andeuten soll) nicht zum
 * Inspizieren.
 *
 * @author Ute Heuer
 *
 * @version 0.1
 */
public class Eingabefeld
{
    private schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular.Eingabefeld internesEingabefeld;

    public Eingabefeld()
    {
        internesEingabefeld = new schulbuecher.paetec.informatik_10_2008.eps.fortgeschrittenes_formular.Eingabefeld();
        beschriftungSetzen("Beschriftung");
        inhaltSetzen("Inhaltsvorgabe");
    }

    /**
     * Legt das Element ans Ende des Formularfensters, wenn es vorher nicht
     * angezeigt wurde.
     */
    public void anzeigen()
    {
        internesEingabefeld.anzeigen();
    }

    /**
     * Entfernt das Element vom Formularfenster
     */
    public void verstecken()
    {
        internesEingabefeld.verstecken();
    }

    /**
     * Setzt den erlaeuternden Text links vom Eingabefeld. Der wird linksbuendig
     * angezeigt.
     */
    public void beschriftungSetzen(String neueBeschriftung)
    {
        internesEingabefeld.beschriftungSetzen(neueBeschriftung);
    }

    /**
     * Setzt eine Art Vorgabetext, der im Eingabefeld selbst angezeigt wird. Der
     * Vorgabetext kann in der Anwendung dann per Maus und Tastatur im
     * Formularfenster ueberschrieben werden.
     */
    public void inhaltSetzen(String neuerInhalt)
    {
        internesEingabefeld.inhaltSetzen(neuerInhalt);
    }

    /**
     * Holt die Zeichenkette, die momentan im Eingabefeld steht.
     */
    public String inhaltGeben()
    {
        return internesEingabefeld.inhaltGeben();
    }

    /**
     * Holt die Zeichenkette, die momentan im Eingabefeld steht und versucht,
     * diese als ganze Zahl zu lesen und zurueckzugeben. Gelingt dies nicht,
     * wird eine freundliche Fehlermeldung ausgegeben, die der Nutzer manuell
     * bestaetigen muss und der Inhalt des Eingabefelds wird automatisch auf 0
     * gesetzt, entsprechend wird sodann 0 zurueckgegeben.
     */
    public int ganzeZahlGeben()
    {
        Integer zahl = internesEingabefeld.ganzeZahlGeben();
        if (zahl == null)
        {
            fehlerMelden("ganze Zahl", inhaltGeben());
            internesEingabefeld.inhaltSetzen("0");
            return 0;
        }
        return zahl;
    }

    /**
     * Holt die Zeichenkette, die momentan im Eingabefeld steht und versucht,
     * diese als "reelle Zahl" zu lesen und zurueckzugeben. Eine reelle Zahl
     * muss kein "Komma" haben, ganze Zahlen werden auch korrekt gelesen. Je
     * nach Umgebungseinstellung ist jedoch, falls es einen Nachkommaanteil
     * gibt, dieser mit dem richtigen Trenn zeichen abzutrennen. In den meisten
     * Faellen sollte dies das "," sein. Misslingt der Leseversuch, wird eine
     * freundliche Fehlermeldung ausgegeben, die der Nutzer manuell bestaetigen
     * muss und der Inhalt des Eingabefelds wird automatisch auf 0 gesetzt,
     * entsprechend wird sodann 0 zurueckgegeben.
     */
    public double kommaZahlGeben()
    {
        Double zahl = internesEingabefeld.kommaZahlGeben();
        if (zahl == null)
        {
            fehlerMelden("Kommazahl", inhaltGeben());
            internesEingabefeld.inhaltSetzen("0");
            return 0;
        }
        return zahl;
    }

    /**
     * Gesperrte Eingabefelder koennen keine neuen Eingaben via Maus und
     * Tastatur im Formularfenster entgegennehmen. In den meisten Umgebungen
     * wird das dem Nutzer auch optisch angezeigt. Alle Dienste der Klasse
     * Eingabefeld koennen jedoch trotzdem sinnvoll genutzt werden. Der Aufruf
     * sperren(true) sperrt das Eingabefeld Der Aufruf sperren(false) hebt eine
     * Sperrung auf.
     */
    public void sperren(boolean gesperrt)
    {
        internesEingabefeld.sperren(gesperrt);
    }

    private void fehlerMelden(String typbeschreibung, String fehlerhafterInhalt)
    {
        Notiz notiz = new Notiz();
        notiz.schreiben("Typfehler \nIm Eingabefeld \""
                + internesEingabefeld.beschriftungGeben() + "\" stand keine "
                + typbeschreibung + " sondern: " + fehlerhafterInhalt
                + ". \nDeshalb wird in diesem Projekt ein Standardwert gesetzt."
                + "\n\nHinweis: Spaeter kann diese Situation eleganter (sauberer) gemeistert werden, "
                + "\nwenn wir Referenzen einfuehren.");
    }
}
