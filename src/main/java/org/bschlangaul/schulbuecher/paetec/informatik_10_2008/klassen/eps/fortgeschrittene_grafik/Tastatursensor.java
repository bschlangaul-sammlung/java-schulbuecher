package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittene_grafik.interna.Zeichenfenster;

/**
 * Interface Tastatursensor
 *
 * @author Ute Heuer, Universität Passau
 */
public abstract class Tastatursensor
{
    public Tastatursensor()
    {
        Zeichenfenster.zeichenfensterGeben().sensorAnmelden(this);
    }

    /**
     * @param fenster wenn das uebergebene Zeichenfenster angewaehlt ist (den
     *     Fokus hat), dann werden die Methoden XXXausloesen bei
     *     Tastenbetaetigung automatisch gefeuert.
     */
    public Tastatursensor(Zeichenfenster fenster)
    {
        fenster.sensorAnmelden(this);
    }

    /**
     * Bei Tastendruck wird die Methode beiDruckAusloesen einer (beim
     * Zeichenfenster angemeldeten nicht abstrakten) Unterklasse aufgerufen. Bei
     * langem Tastendruck wird die Methode ausloesen mehrfach aufgerufen. Diese
     * Methode ist also von Unterklassen zu ueberschreiben, wenn auf Tastendruck
     * reagiert werden soll.
     * <p>
     * Achtung: Der Methodenname muss korrekt geschrieben werden, es ist auch
     * auf Gross/Kleinschreibung zu achten! Es kann der @Override Marker
     * verwendet werden, um dies automatisch zu ueberpruefen.
     *
     * @param taste Repraesentation der Taste als ganze Zahl
     */
    public void beiDruckAusloesen(int taste)
    {
    }

    /**
     * Bei Tastenanschlag wird die Methode beiAnschlagAusloesen einer (beim
     * Zeichenfenster angemeldeten nicht abstrakten) Unterklasse aufgerufen.
     * Diese Methode ist also von Unterklassen zu ueberschreiben, wenn auf
     * Tastenanschlag reagiert werden soll.
     * <p>
     * Achtung: Der Methodenname muss korrekt geschrieben werden, es ist auch
     * auf Gross/Kleinschreibung zu achten! Es kann der @Override Marker
     * verwendet werden, um dies automatisch zu ueberpruefen.
     *
     * @param taste Repraesentation der Taste als ganze Zahl
     */
    public void beiAnschlagAusloesen(int taste)
    {
    }

    /**
     * Beim Loslassen einer zuvor irgendwann gedrueckten Taste wird die Methode
     * beiFreigabeAusloesen einer (beim Zeichenfenster angemeldeten nicht
     * abstrakten) Unterklasse aufgerufen. Diese Methode ist also von
     * Unterklassen zu ueberschreiben, wenn auf Tastenfreigabe reagiert werden
     * soll.
     * <p>
     * Achtung: Der Methodenname muss korrekt geschrieben werden, es ist auch
     * auf Gross/Kleinschreibung zu achten! Es kann der @Override Marker
     * verwendet werden, um dies automatisch zu ueberpruefen.
     *
     * @param taste Repraesentation der Taste als ganze Zahl
     */
    public void beiFreigabeAusloesen(int taste)
    {
    }
}
