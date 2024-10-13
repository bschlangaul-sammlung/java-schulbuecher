package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_01.wie_gehts;

import org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.ServerVerhalten;

/**
 * Diese Klasse implementiert das Serververhalten, das im Zustandsdiagramm
 * modelliert wurde
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class WieGehtsServerVerhalten implements ServerVerhalten
{
    /**
     * Konstante für Zustand wartend
     */
    private static final int wartend = 0;

    /**
     * Konstante für Zustand gegrüßt
     */
    private static final int gegruesst = 1;

    /**
     * Konstante für Zustand gefragt
     */
    private static final int gefragt = 2;

    /**
     * Konstante für Zustand nochmal
     */
    private static final int nochmal = 3;

    /**
     * speichert den aktuellen Zustand
     */
    private int zustand = wartend;

    /**
     * ermittelt die zu sendende Antwort in Abhängigkeit des Zustands und des
     * Textes, der vom Client übermittelt wurde
     *
     * @param textVomClient der Text, der vom Client an den Server gesendet
     *     wurde.
     *
     * @return den Text, der als Antwort an den Client gesendet wird.
     */
    public String HoleAntwort(String textVomClient)
    {
        String ausgabe = null;
        switch (zustand)
        {
        case wartend:
            ausgabe = "Hallo!";
            zustand = gegruesst;
            break;

        case gegruesst:
            if (textVomClient.equalsIgnoreCase("Hallo Meister!"))
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
            if (textVomClient.equalsIgnoreCase("gut"))
            {
                ausgabe = "Sehr erfreulich. Nochmal (Ja)?";
                zustand = nochmal;
            }
            else if (textVomClient.equalsIgnoreCase("schlecht"))
            {
                ausgabe = "Das ist sehr schade. Nochmal (Ja)?";
                zustand = nochmal;
            }
            else
            {
                ausgabe = "Sie koennen nur mit \"gut\" oder \"schlecht\" antworten. "
                        + "Wie geht es Ihnen?";
            }
            break;

        case nochmal:
            if (textVomClient.equalsIgnoreCase("Ja"))
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
