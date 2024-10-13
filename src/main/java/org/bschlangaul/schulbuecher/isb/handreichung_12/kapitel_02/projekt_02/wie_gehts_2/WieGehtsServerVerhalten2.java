package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_02.wie_gehts_2;

import org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.ServerVerhalten;

/**
 * Diese Klasse implementiert das Serververhalten,<br />
 * Lösungsvorschlag für Aufgabe 2 (Kapitel 2.2.2.2)
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class WieGehtsServerVerhalten2 implements ServerVerhalten
{
    /** Konstante für Zustand wartend */
    private static final int wartend = 0;

    /** Konstante für Zustand gegrüßt */
    private static final int gegruesst = 1;

    /** Konstante für Zustand gefragt */
    private static final int gefragt = 2;

    /** Konstante für Zustand nochmal */
    private static final int nochmal = 3;

    /** Konstante für Zustand zum zweiten Mal gefragt */
    private static final int gefragt2 = 4;

    /** speichert den aktuellen Zustand */
    private int zustand = wartend;

    /**
     * ermittelt die zu sendende Antwort in Abhängigkeit des Zustands und des
     * Textes, der vom Client übermittelt wurde
     *
     * @param textvomclient der Text, der vom Client an den Server gesendet
     *     wurde.
     *
     * @return den Text, der als Antwort an den Client gesendet wird.
     */
    public String HoleAntwort(String textvomclient)
    {
        String ausgabe = null;
        switch (zustand)
        {
        case wartend:
            ausgabe = "Hallo!";
            zustand = gegruesst;
            break;

        case gegruesst:
            if (textvomclient.equalsIgnoreCase("Hallo Meister!"))
            {
                ausgabe = "Wie geht es Ihnen?";
                zustand = gefragt;
            }
            else
            {
                ausgabe = "Sie muessen mich mit \"Hallo Meister!\" begruessen! "
                        + "Probieren Sie es nochmal!";
            }
            break;

        case gefragt:
            if (textvomclient.equalsIgnoreCase("gut"))
            {
                ausgabe = "Sehr erfreulich.";
                ausgabe += " Heute schon gelacht? (Ja)";
                zustand = gefragt2;
            }
            else if (textvomclient.equalsIgnoreCase("schlecht"))
            {
                ausgabe = "Das ist sehr schade.";
                ausgabe += " Heute schon gelacht? (Ja)";
                zustand = gefragt2;
            }
            else if (textvomclient.equalsIgnoreCase("geht so"))
            {
                ausgabe = "Das hoert sich nicht sehr toll an.";
                ausgabe += " Heute schon gelacht? (Ja)";
                zustand = gefragt2;
            }
            else
            {
                ausgabe = "Sie koennen nur mit \"gut\" oder \"schlecht\" "
                        + "oder \"geht so\" antworten. " + "Wie geht es Ihnen?";
            }
            break;

        case gefragt2:
            if (textvomclient.equalsIgnoreCase("Ja"))
            {
                ausgabe = "Gut, Lachen ist gesund! Nochmal (Ja)?";
                zustand = nochmal;
            }
            else
            {
                ausgabe = "Sie sollen aber! Jetzt mal kraeftig schmunzeln! "
                        + "Hats geklappt? (Ja)";
            }
            break;

        case nochmal:
            if (textvomclient.equalsIgnoreCase("Ja"))
            {
                ausgabe = "Hallo!";
                zustand = gegruesst;
            }
            else
            {
                ausgabe = "Auf Wiedersehen!";
                zustand = wartend;
            }
            break;
        }
        return ausgabe;
    }
}
