package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_03.bestenliste;

/**
 * Klasse zur Darstellung einer Punkteliste mit Name und eingetragenen
 * Punkteständen
 */
class Punkteliste
{
    String name;

    int[] punktestaende;

    Punkteliste()
    {
        this.name = "Informatik-Quiz";
        punktestaende = new int[6];
        punktestaende[0] = 1020;
        punktestaende[1] = 999;
        punktestaende[2] = 875;
        punktestaende[3] = 634;
        punktestaende[4] = 459;
        punktestaende[5] = 10;
    }

    Punkteliste(int[] punktestaende)
    {
        this.punktestaende = punktestaende;
    }
}
