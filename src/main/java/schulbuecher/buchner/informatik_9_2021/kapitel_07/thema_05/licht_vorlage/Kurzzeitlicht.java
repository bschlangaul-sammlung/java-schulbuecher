package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_05.licht_vorlage;

/**
 * Ein Kurzzeitlicht wird durch Mausklick eingeschaltet. Es geht nach einer
 * bestimmten Zeit von selbst wieder aus.
 */
class Kurzzeitlicht extends Licht
{
    int leuchtdauer = 200;

    int zaehler = 0;

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
                istAn = false;
            }
        }
        else
        {
            zeigeLichtAus();
            zaehler = 0;
        }
    }
}
