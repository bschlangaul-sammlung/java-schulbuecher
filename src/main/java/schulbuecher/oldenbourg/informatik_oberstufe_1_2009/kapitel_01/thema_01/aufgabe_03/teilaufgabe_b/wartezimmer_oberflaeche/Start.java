package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_03.teilaufgabe_b.wartezimmer_oberflaeche;

/**
 * Klasse zum Start des Projekts
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Start
{
    /**
     * Konstruktor der Klasse START Erzeugt ein neues Fenster zur
     * Patientenverwaltung
     */
    Start()
    {
        new Fenster("Patientenverwaltung");
    }

    /**
     * Sorgt für den Start
     */
    static void main(String[] args)
    {
        new Start();
    }
}
