package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.geruechtekueche;

import org.bschlangaul.schulbuecher.paetec.informatik_10_2008.eps.werkzeuge.Warteschlange;

/**
 * Klasse Schueler. Diese Klassendefinition soll von Schuelern in der 10.Klasse
 * nicht eingesehen werden. Sie dient nur zum Experimentieren in der 10.Klasse
 *
 * @author Susanne Ritzer, Ute Heuer Universität Passau
 *
 * @version 05.2008
 */
public class Schueler
{
    private String name;

    private Schueler freund1;

    private Schueler freund2;

    private String geruecht;

    /**
     * Wie aktuell ist das Geruecht? Entspricht der Lebensdauer des Geruechts.
     */
    private int aktualitaet;

    /**
     * Ein interner Speicher fuer den Breitendurchlauf noch nicht "infizierter"
     * Schueler
     */
    private static Warteschlange<Schueler> internerSpeicher;

    /**
     * Konstruktor fuer Objekte der Klasse Schueler
     */
    public Schueler(String neuerName)
    {
        name = neuerName;
        if (internerSpeicher == null)
        {
            internerSpeicher = new Warteschlange<Schueler>();
        }
    }

    /**
     * Diese Methode stellt eine Freundschaftsbeziehung mit dem Schueler
     * neuerFreund her. Sie liefert <b>true</b> zurueck, wenn ein
     * Freundschaftsverhaeltnis eingegangen wurde. Sie liefert <b>false</b>
     * zurueck, wenn kein Freundschaftsverhaeltnis eingegangen wurde. Dies kann
     * passieren, wenn der Schueler bereits zwei Freunde hatte oder bereits eine
     * Freundschaft zu diesem Schueler bestand.
     */
    public boolean freundschaftBeginnen(Schueler neuerFreund)
    {
        // testen, ob bereits eine Freundschaft besteht.
        if (freund1 == neuerFreund || freund2 == neuerFreund)
        {
            return false;
        }
        if (freund1 == null)
        {
            freund1 = neuerFreund;
            return true;
        }
        else if (freund2 == null)
        {
            freund2 = neuerFreund;
            return true;
        }
        else
        {
            // dieser Schueler (this) hat bereits zwei Freunde
            return false;
        }
    }

    /**
     * Diese Methode beendet die Freundschaft mit dem uebergebenen Schueler. Sie
     * liefert <b>true</b> zurueck, wenn die Freundschaft beendet wurde. Bestand
     * jedoch zu diesem Schueler keine Freundschaftsbeziehung, so wird der Wert
     * <b>false</b> zurueckgegeben.
     */
    public boolean freundschaftBeenden(Schueler keinFreund)
    {
        if (freund1 == keinFreund)
        {
            freund1 = null;
            return true;
        }
        else if (freund2 == keinFreund)
        {
            freund2 = null;
            return true;
        }
        else
        {
            // zu diesem Schueler bestand keine Freundschaft
            return false;
        }
    }

    /**
     * Die Methode weitersagen erzaehlt den Freunden das neue Geruecht, wenn die
     * Lebensdauer des Geruechts groesser als 0 ist und wenn die Freunde das
     * Geruecht noch nicht kennen. Ist die Lebensdauer groesser als eins, dann
     * erzaehlen es die Freunde wiederum ihren Freunden...
     */
    public void weitersagen(String neuesGeruecht, int lebensdauer)
    {
        if (neuesGeruecht == null)
            return; // "null" wird sinnvollerweise nicht weitererzaehlt
        geruecht = neuesGeruecht;// wir kennen das Geruecht auf jeden Fall.
        aktualitaet = lebensdauer;// diese Lebensdauer steht auf unserem "gelben
                                  // Geruechtezettel"
        weitersagen();
    }

    private void weitersagen()
    {
        int weitergesagt = 0;
        if (aktualitaet > 0)
        {// wenn auf unserem "gelben Geruechtezettel nicht 0 steht"
            if (freund1 != null && !geruecht.equals(freund1.geruecht))
            {
                // Wir haben einen ersten Freund und der kennt unser geruecht
                // noch nicht
                weitergesagt++;
                System.out.println(name + " sagt zu " + freund1.name
                        + " folgendes: " + geruecht);
                freund1.geruecht = geruecht;// freund1 merkt sich das geruecht
                freund1.aktualitaet = aktualitaet - 1;// das geruecht verliert
                                                      // an Aktualitaet
                internerSpeicher.hineinstecken(freund1);
            }
            if (freund2 != null && !geruecht.equals(freund2.geruecht))
            {
                // Wir haben einen zweiten Freund und der kennt unser geruecht
                // noch nicht
                weitergesagt++;
                System.out.println(name + " sagt zu " + freund2.name
                        + " folgendes: " + geruecht);
                freund2.geruecht = geruecht;// freund2 merkt sich das geruecht
                freund2.aktualitaet = aktualitaet - 1;// das geruecht verliert
                                                      // an Aktualitaet
                internerSpeicher.hineinstecken(freund2);
            }
            for (int i = 0; i < weitergesagt; i++)
            {
                if (!internerSpeicher.istLeer())
                {
                    internerSpeicher.herausholen().weitersagen();
                }
            }
        }
    }

    public String toString()
    {
        return name;
    }
}
