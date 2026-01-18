package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_01;

/**
 * Beispielklasse zum zählen von Schritten
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public class SchrittZaehlung
{
    /**
     * Methode zur Berechnung des ggT
     */
    public void GGTBerechnen(int zahl_1, int zahl_2)
    {
        int i;
        i = 0;
        i++;
        while (zahl_1 != zahl_2)
        {
            i++;
            if (zahl_1 >= zahl_2)
            {
                i++;
                zahl_1 = zahl_1 - zahl_2;
            }
            else
            {
                i++;
                zahl_2 = zahl_2 - zahl_1;
            }
        }
        i++;
        System.out.println("Der ggT ist " + zahl_1);
        System.out.println(
                "Zur Berechnung waren " + i + " Schritte erforderlich");
    }
}
