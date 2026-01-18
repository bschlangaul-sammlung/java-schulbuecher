package schulbuecher.buchner.informatik_10_2022.kapitel_06.gesangstrio;

/**
 * Klasse Saenger für Kapitel 4.6 Aufgabe 1
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-06-03
 */
public class Saenger
{
    private String vorname;

    private String nachname;

    private String stimmlage;

    public Saenger(String einVorname, String einNachname, String eineStimmlage)
    {
        vorname = einVorname;
        nachname = einNachname;
        stimmlage = eineStimmlage;
    }

    public String gibName()
    {
        return vorname + " " + nachname;
    }

    public String gibStimmlage()
    {
        return stimmlage;
    }
}
