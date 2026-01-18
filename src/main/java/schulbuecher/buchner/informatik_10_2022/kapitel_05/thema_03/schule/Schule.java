package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_03.schule;

class Schule
{
    String name;

    int schuelerzahl;

    Raum[] raeume;

    Schule(Raum[] raeume)
    {
        this.raeume = raeume;
    }

    Schule()
    {
        raeume = new Raum[3];
        raeume[0] = new Raum(1, 60.5);
        raeume[1] = new Raum(2, 63);
        raeume[2] = new Raum(4, 20.38);
    }
}
