package schulbuecher.isb.abitur.illustrierende_2023.ga.aufgabe_i.teilaufgabe_01.skipass;

public class BinBaum
{
    Baumelement wurzel;

    boolean istVorhanden(int skipassnr)
    {
        return wurzel.istVorhanden(skipassnr);
    }

    void sortiertAusgeben(char skipassart)
    {
        wurzel.sortiertAusgeben(skipassart);
    }
}
