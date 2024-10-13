package org.bschlangaul.schulbuecher.cornelsen.informatik_5.kapitel_04.thema_03.alternative_01.aufgabe_07.knn_implementieren;

/**
 * Klasse DatenpunktStandardisiert, zum Speichern von gelabelten Datenpunkten im
 * zweidimensionalen Raum. Da die Datenpunkte für den
 * k_Nächste_Nachbar-Algorithmus verwendet werden, gibt es noch die Möglichkeit
 * bei jedem DatenpunktStandardisiert einen Abstand zu speichern.
 *
 * @author (Peter Brichzin)
 *
 * @version (Version 1.1)
 */
public class Datenpunkt
{
    double x;

    double y;

    String label;

    double abstand;

    /**
     * Konstruktor für Objekte der Klasse DatenpunktStandardisiert
     */
    public Datenpunkt(double xNeu, double yNeu, String labelNeu)
    {
        x = xNeu;
        y = yNeu;
        label = labelNeu;
        abstand = -1;
    }

    /**
     * Konstruktor für Objekte der Klasse DatenpunktStandardisiert ohne
     * initialisierung eines Labels.
     */
    public Datenpunkt(double xNeu, double yNeu)
    {
        x = xNeu;
        y = yNeu;
        label = "";
        abstand = -1;
    }

    /**
     * Getter-Methode fuer: x
     */
    public double XGeben()
    {
        return x;
    }

    /**
     * Getter-Methode fuer: y
     */
    public double YGeben()
    {
        return y;
    }

    /**
     * Getter-Methode fuer: label
     */
    public String LabelGeben()
    {
        return label;
    }

    /**
     * Setter-Methode fuer: abstand
     *
     * @param abstandNeu Der neue Wert fuer das Attribut abstand
     */
    public void AbstandSetzen(double abstandNeu)
    {
        abstand = abstandNeu;
    }

    /**
     * Getter-Methode fuer: abstand
     */
    public double AbstandGeben()
    {
        return abstand;
    }

    /**
     * Die Methode InformationAusgeben gibt alle Informationen eines Datenpunkts
     * auf der Konsole aus.
     *
     */
    public void InformationAusgeben()
    {
        System.out.println(x + " | " + y + " | " + label + " | " + abstand);

    }

    /**
     * Setter-Methode fuer: x
     *
     * @param xNeu Der neue Wert fuer das Attribut x
     */
    public void XSetzen(double xNeu)
    {
        x = xNeu;
    }

    /**
     * Setter-Methode fuer: y
     *
     * @param yNeu Der neue Wert fuer das Attribut y
     */
    public void YSetzen(double yNeu)
    {
        y = yNeu;
    }

}
