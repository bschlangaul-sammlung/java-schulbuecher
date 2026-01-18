package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_07.aufgabe_07.abiturparty;

/**
 * Steuerung der Leuchten auf dem Dancefloor
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class DancefloorSteuerung2 extends DancefloorSteuerung
{
    /**
     * Erzeugt zufällige Farbwechsel
     */
    @Override
    public void AktionAusführen()
    {
        for (int spalte = 0; spalte < d.SpaltenanzahlGeben(); spalte = spalte
                + 1)
        {
            for (int zeile = 0; zeile < d.ZeilenanzahlGeben(); zeile = zeile
                    + 1)
            {
                d.FarbeSetzen(spalte, zeile, ZufälligeFarbeGeben());
            }
        }
    }

    public static void main(String[] args)
    {
        new DancefloorSteuerung2().AktionAusführen();
    }
}
