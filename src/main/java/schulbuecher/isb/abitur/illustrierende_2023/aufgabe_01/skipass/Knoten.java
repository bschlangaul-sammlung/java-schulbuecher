package schulbuecher.isb.abitur.illustrierende_2023.aufgabe_01.skipass;

public class Knoten
{
    Skipass inhalt;

    Baumelement nachfolgerLi;

    Baumelement nachfolgerRe;

    boolean istVorhanden(int skipassnr)
    {
        if (inhalt.nummerGeben() == skipassnr)
        {
            return true;
        }
        else
        {
            if (inhalt.nummerGeben() < skipassnr)
            {
                return nachfolgerRe.istVorhanden(skipassnr);
            }
            else
            {
                return nachfolgerLi.istVorhanden(skipassnr);
            }
        }
    }

    void sortiertAusgeben(char skipassart)
    {
        nachfolgerLi.sortiertAusgeben(skipassart);
        if (inhalt.artGeben() == skipassart)
        {
            inhalt.datenAusgeben();
        }
        nachfolgerRe.sortiertAusgeben(skipassart);
    }
}
