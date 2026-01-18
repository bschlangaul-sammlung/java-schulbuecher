package schulbuecher.paetec.informatik_10_2008.sammelleidenschaft;

import java.util.Collection;
import java.util.Iterator;

import schulbuecher.paetec.informatik_10_2008.sammelleidenschaft.interna.Speicher;

/**
 * Eine Art "Universalbehaelter", der Objekte eines Typs halten kann.<BR>
 * <BR>
 *
 * Beim Erzeugen eines Behaelterobjekts muss man angeben, von welchem Typ die
 * aufzubewahrenden Objekte sein werden.<BR>
 *
 * Ein Objekt kann nur dann in diesen Behaelter eingefuegt werden, wenn es noch
 * kein gleiches Objekt im Behaelter gibt.<BR>
 * Wann sind zwei Objekte gleich? Diese Frage wird mit Hilfe des Dienstes
 * "equals" beantwortet, den jedes Objekt anbietet.<BR>
 * <BR>
 *
 * Diese Behaelter merkt sich nicht, ob ein Objekt "frueher oder spaeter" als
 * ein anderes eingefuegt wurde. Man kann als Nutzer auch nicht sagen, "wo" man
 * das Objekt nun gerne einfuegen moechte.
 * <p>
 * Anmerkung: Das Attribut speicher soll und braucht von Schuelern in der
 * 10.Klasse nicht inspiziert zu werden.
 *
 * @author Ute Heuer
 *
 * @version 28.11.07
 */
public class Behaelter<Typ> extends Speicher<Typ> implements Iterable<Typ>
{
    /* -----------------------------------Konstruktoren- */
    /**
     * Ein leerer Behaelter wird erzeugt. Wollen Sie einen Behaelter fuer Worte
     * erzeugen, dann geben Sie als Wert des Typ-Parameters ein: String . Wollen
     * Sie einen Behaelter fuer ganze Zahlen erzeugen, dann geben Sie als Wert
     * des Typ-Parameters ein: Integer . Wollen Sie einen Behaelter fuer
     * Dreiecke erzeugen, dann geben Sie als Wert des Typ-Parameters ein:
     * schulbuecher.paetec.informatik_10_2008.eps.einfache_grafik.Dreieck .
     */
    public Behaelter()
    {
    }
    // Kann nach Kapitel 3 veröffentlicht werden
    // /**
    // * Konstruktor zum Umfuellen eines Feldes in einen Behaelter, dabei werden
    // gleiche Objekte
    // * nur einmal in den Behaelter eingefuellt.
    // * Es wird ein Behaelter erzeugt, der Elemente eines Typs enthaelt.
    // *
    // * @param elemente ein Feld mit Elementen eines Typs
    // */
    // public Behaelter(Typ[] elemente){
    // for (Typ element: elemente) {
    // hineinstecken(element);
    // }
    // }

    // Kann bei Bedarf spaeter veröffentlicht werden.
    /**
     * Erzeugt einen Behaelter, der die Elemente der angegebenen Collection
     * enthaelt. Die Elemente der Collection muessen alle den festgelegten Typ
     * haben.
     */
    private Behaelter(Collection<Typ> elemente)
    {
        speicherGeben().addAll(elemente);
    }

    /* -----------------------------------Methoden---- */
    // Kann nach Kapitel 4 veröffentlicht werden:
    /**
     * @return Liefert eine Kopie des aktuellen Behaelters, die zum Durchlauf
     *     verwendet werden kann. Dann kann waehrend des Durchlaufs in den
     *     aktuellen Behaelter (nicht in die Kopie!) etwas hineingesteckt oder
     *     herausgenommen werden. So vermeidet man Laufzeitfehler (Concurrent
     *     Modification Exception)
     */
    private Behaelter<Typ> kopieGeben()
    {
        return new Behaelter<Typ>(speicherGeben());
    }

    /**
     * Dieser Dienst steckt ein Element in den Behaelter hinein, sofern noch
     * kein gleiches darinnen ist. Engl.: add .
     */
    public void hineinstecken(Typ element)
    {
        speicherGeben().add(element);
    }

    /**
     * Dieser Dienst ermoeglicht das "Anschauen" eines Elements aus dem
     * Behaelter. Das "angeschaute" Element bleibt im Behaelter, es wird nicht
     * entfernt.
     * <p>
     * Wird versucht, ein Element aus einem leeren Behaelter anzuschauen, dann
     * gibt dieser Dienst einfach null aus.
     */
    public Typ schauen()
    {
        Iterator<Typ> iterator = speicherGeben().iterator();
        if (iterator.hasNext())
        {
            return iterator.next();
        }
        return null;
    }

    /**
     * Entnimmt ein Element aus dem Behaelter. Engl.: remove
     * <p>
     * Aus einem leeren Behaelter kann kein Element entnommen werden, dieser
     * Dienst gibt dann einfach null aus.
     */
    public Typ herausholen()
    {
        Iterator<Typ> iterator = speicherGeben().iterator();
        if (iterator.hasNext())
        {
            Typ herausgeholtesElement = iterator.next();
            iterator.remove();
            return herausgeholtesElement;
        }
        return null;
    }

    /**
     * Versucht ein Element aus dem Behaelter zu entfernen, welches dem
     * eingegebenen gleicht. Engl.: remove. Ausgabe: true, wenn das Element drin
     * war und also entfernt werden konnte, ansonsten false.
     */
    public boolean entfernen(Typ element)
    {
        if (enthaeltElement(element))
        {
            return speicherGeben().remove(element);
        }
        else
        {
            return false;
        }
    }

    /**
     * Berechnet die Anzahl der Elemente im Behaelter. Ausgabe: die Anzahl der
     * Elemente
     */
    public int anzahlGeben()
    {
        return speicherGeben().size();
    }

    /**
     * Vollstaendige Entleerung des Behaelters
     */
    public void leeren()
    {
        entfernen(this);
    }

    /**
     * Dieser Dienst liefert Informationen ueber den Inhalt des Behaelters.
     * Experiment: "Holen" Sie sich die Ausgabe dieses Dienstes auf die
     * Arbeitsleiste Ihrer Umgebung. Vergeben Sie einen Namen fuer die Ausgabe,
     * sagen wir: string1. Schicken Sie sodann die Anweisung
     * System.out.println(string1) via Direkteingabe-Fenster ab.
     */
    public String inhaltsuebersichtGeben()
    {
        return speicherGeben().toString();
    }
    // public String toString()
    // {
    // Das ist die Bezeichnung, die Java vorsieht.
    // return speicherGeben().toString();
    // }

    /**
     * nur fuer interessierte veröffentlichen Dieser Dienst fuellt die Elemente
     * aus einem anderen Behaelter in diesen Behaelter hinein, sofern jeweils
     * noch kein gleiches darinnen ist. Engl.: addAll
     */
    private void hineinstecken(Behaelter<Typ> einzufuellendes)
    {
        if (einzufuellendes != null)
        {
            speicherGeben().addAll(einzufuellendes.speicherGeben());
        }
    }

    /**
     * Dieser Dienst steckt eine beliebig lange Aufzaehlung von Elementen
     * gleichen Typs in den Behaelter hinein, sofern jeweils noch kein gleiches
     * darinnen ist.
     */
    public void hineinstecken(Typ... elemente)
    {
        for (Typ element : elemente)
        {
            hineinstecken(element);
        }
    }

    /**
     * nur fuer interessierte veröffentlichen Versucht die Elemente des
     * eingegebenen Behaelters aus diesem Behaelter (man sagt salopp auch "aus
     * uns") zu entfernen. Auch hier ist entscheidend, wie die Gleichheit zweier
     * Elemente festgelegt wurde. "Gleiche Elemente werden entfernt."
     * Mengendifferenz. Engl.: removeAll Ausgabe: true, wenn wenigstens ein
     * Element entfernt werden konnte, ansonsten false.
     */
    private boolean entfernen(Behaelter<Typ> zuEntfernendes)
    {
        if (zuEntfernendes != null)
        {
            return speicherGeben().removeAll(zuEntfernendes.speicherGeben());
        }
        else
        {
            return false;
        }
    }

    // Kann nach Kapitel 2 veröffentlicht werden.
    // Motivation: Es ist sinnvoll festzulegen, wann zwei Behaelter gleich sind.
    // Das macht man am besten mit einem Dienst, dessen Namen von Java
    // festgelegt ist.
    // Ab Kapitel 5 kann angesprochen werden, dass equals von Object hier
    // ueberschrieben wird.
    private boolean equals(Behaelter<Typ> BehaelterRechts)
    {
        if (BehaelterRechts != null)
        {
            return speicherGeben().equals(BehaelterRechts.speicherGeben());
        }
        else
        {
            return false;
        }
    }

    // Fuer Aufgabe 1.17 sollten nicht zu viele Dienste bereitgestellt werden.
    // Deshalb wurde fuer Kapitel 1 auf die folgenden Dienste verzichtet.
    // Sie koennen bei Bedarf in spaeteren Kapitel veröffentlicht werden.
    private boolean enthaeltElement(Typ element)
    {
        return speicherGeben().contains(element);
    }

    private boolean istLeer()
    {
        return speicherGeben().isEmpty();
    }
    // /**
    // * Wirft Exception
    // */
    // public void schneiden(Behaelter<Typ> BehaelterRechts) {
    // speicher.retainAll(BehaelterRechts.speicherGeben());
    // }
}
