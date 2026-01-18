package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_07.aufgabe_08.baum;

/**
 * Beschreibt einen wachsenden Baum
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class WachsenderBaum extends Baum
{
    /**
     * Der Baum wechselt automatisch durch die Jahreszeiten; im Frühling wächst
     * der Baum
     */
    @Override
    public void AktionAusführen()
    {
        switch (jahreszeit)
        {
        case "Frühling":
            SommerSetzen();
            break;

        case "Sommer":
            HerbstSetzen();
            break;

        case "Herbst":
            WinterSetzen();
            break;

        case "Winter":
            FrühlingSetzen();
            Wachsen();
            break;

        default:
            System.out.println("Fehler bei den Jahreszeiten");
        }
    }
}
