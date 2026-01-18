package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_05.licht_aufgabe_3b;

/**
 * Ein Blinklicht beginnt nach einem Mausklick zu blinken. Das Blinken hört nach
 * einem weiteren Mausklick wieder auf.
 *
 */
class Blinklicht extends Licht
{
    int umschaltzeit = 40;

    int zaehler = 0;

    Blinklicht()
    {
        super();
    }

    void setzeUmschaltzeit(int neuerWert)
    {
        umschaltzeit = neuerWert;
    }

    int gibUmschaltzeit()
    {
        return umschaltzeit;
    }

    void leuchte()
    {
        if (istAn == true)
        {
            if (zaehler < gibUmschaltzeit())
            {
                zeigeLichtEin();
                zaehler = zaehler + 1;
            }
            if (gibUmschaltzeit() <= zaehler && zaehler < 2 * gibUmschaltzeit())
            {
                zeigeLichtAus();
                zaehler = zaehler + 1;
            }
            if (zaehler >= 2 * gibUmschaltzeit())
            {
                zaehler = 0;
            }
        }
        else
        {
            zeigeLichtAus();
            zaehler = 0;
        }
    }
}
