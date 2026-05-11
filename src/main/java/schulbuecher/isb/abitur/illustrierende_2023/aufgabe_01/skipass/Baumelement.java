package schulbuecher.isb.abitur.illustrierende_2023.aufgabe_01.skipass;

abstract class Baumelement
{
    abstract boolean istVorhanden(int skipassnr);

    abstract void sortiertAusgeben(char skipassart);
}
