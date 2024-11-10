package org.bschlangaul.schulbuecher.isb.abitur.pruefung_2014.inf1.aufgabe_i.teilaufgabe_04;

class Messreihe
{
    private Listenelement erster;

    Messreihe()
    {
        erster = new Abschluss();
    }

    double maxEnergieGeben()
    {
        return erster.maxEnergieGeben(0.0);
    }

    double mittlereZerfallszeitGeben()
    {
        return erster.summeZeitenGeben() / erster.anzahlKnotenGeben();

        // Das Abfangen einer Division durch Null wird hier nicht verlangt...

    }
}
