package schulbuecher.cornelsen.informatik_5_2023.kapitel_04.thema_02.aufgabe_01.autokennzeichen;

/**
 * Klasse Kennzeichen zum Speichern des Unterscheidungszeichens (Ortskürzel) und
 * den zugehörigen Ort bzw. die Behörde
 *
 * @author (Stefan Seegerer, Peter Brichzin)
 *
 * @version (18.5.23)
 */
public class Kennzeichen
{
    String oertskuerzel;

    String ort;

    /**
     * Konstruktor für Objekte der Klasse Kennzeichen
     */
    public Kennzeichen(String oertskuerzelNeu, String ortNeu)
    {
        oertskuerzel = oertskuerzelNeu;
        ort = ortNeu;
    }

    /**
     * Getter-Methode fuer: oertskuerzel
     */
    public String OertskuerzelGeben()
    {
        return oertskuerzel;
    }

    /**
     * Getter-Methode fuer: ort
     */
    public String OrtGeben()
    {
        return ort;
    }

}
