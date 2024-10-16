package org.bschlangaul.schulbuecher.isb.abitur.pruefung_2024.inf1.aufgabe_i.teilaufgabe_04.schwerionen_zerfall;

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
        // Das Abfangen einer Division durch Null wird hier nicht verlangt...
        return erster.summeZeitenGeben() / erster.anzahlKnotenGeben();
    }
}
