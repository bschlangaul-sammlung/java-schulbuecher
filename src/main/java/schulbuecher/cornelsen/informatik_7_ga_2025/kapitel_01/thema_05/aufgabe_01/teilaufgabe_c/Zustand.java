package schulbuecher.cornelsen.informatik_7_ga_2025.kapitel_01.thema_05.aufgabe_01.teilaufgabe_c;

/**
 * Abstrakte Oberklasse Zustand.
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
abstract class Zustand
{
    /** Speichert, ob der aktuelle Zustand ein Endzustand ist oder nicht **/
    boolean istEndzustand;

    /**
     * Konstruktor für Objekte der Klasse Zustand
     */
    Zustand()
    {
    }

    /**
     * Abstrakte Methode AktZeichenVerarbeiten
     *
     * @param zei aktuell zu verarbeitendes Zeichen
     *
     * @return Folgezustand nach der Verarbeitung
     */
    abstract Zustand AktZeichenVerarbeiten(char zei);

    /**
     * Überprüft, ob es sich um einen Endzustand handelt
     *
     * @return true, wenn es ein Endzustand ist, false sonst
     */
    boolean IstEndzustandGeben()
    {
        return istEndzustand;
    }
}
