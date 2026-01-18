package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_05.licht_aufgabe_2c;

import greenfoot.Greenfoot;

/**
 * Ein Kurzzeitlicht wird durch Mausklick eingeschaltet. Es geht nach einer
 * bestimmten Zeit von selbst wieder aus.
 */
class Kurzzeitlicht extends Licht
{
    int leuchtdauer = 200;

    int zaehler = 0;

    Kurzzeitlicht()
    {
        super();
    }

    void setzeLeuchtdauer(int neuerWert)
    {
        leuchtdauer = neuerWert;
    }

    int gibLeuchtdauer()
    {
        return leuchtdauer;
    }

    void leuchte()
    {
        if (istAn == true)
        {
            if (zaehler < gibLeuchtdauer())
            {
                zeigeLichtEin();
                zaehler = zaehler + 1;
            }
            else
            {
                blinke();
                istAn = false;
            }
        }
        else
        {
            zeigeLichtAus();
            zaehler = 0;
        }
    }

    void blinke()
    {
        int i = 0;
        while (i < 3)
        {
            zeigeLichtAus();
            Greenfoot.delay(20);
            zeigeLichtEin();
            Greenfoot.delay(20);
            i = i + 1;
        }
    }
}
