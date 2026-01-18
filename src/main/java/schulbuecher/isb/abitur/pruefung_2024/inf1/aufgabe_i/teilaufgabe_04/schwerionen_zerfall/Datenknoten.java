package schulbuecher.isb.abitur.pruefung_2024.inf1.aufgabe_i.teilaufgabe_04.schwerionen_zerfall;

class Datenknoten extends Listenelement
{
    private Listenelement naechster;

    private Zerfall inhalt;

    Datenknoten(Listenelement le, Zerfall z)
    {
        naechster = le;
        inhalt = z;
    }

    double maxEnergieGeben(double temp)
    {
        if (temp < inhalt.energieGeben())
        {
            return naechster.maxEnergieGeben(inhalt.energieGeben());
        }
        else
        {
            return naechster.maxEnergieGeben(temp);
        }
    }

    double summeZeitenGeben()
    {
        return inhalt.zerfallszeitGeben() + naechster.summeZeitenGeben();
    }

    int anzahlKnotenGeben()
    {
        return 1 + naechster.anzahlKnotenGeben();
    }
}
