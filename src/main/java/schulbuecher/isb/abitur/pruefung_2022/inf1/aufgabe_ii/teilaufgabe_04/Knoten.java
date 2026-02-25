package schulbuecher.isb.abitur.pruefung_2022.inf1.aufgabe_ii.teilaufgabe_04;

public class Knoten extends Baumelement
{

    Abonnent inhalt;

    Baumelement linkerNachfolger;

    Baumelement rechterNachfolger;

    void eMailsAusgeben(String von, String bis)
    {
        if (inhalt.istKleinerAls(von))
        {
            rechterNachfolger.eMailsAusgeben(von, bis);
        }
        else if (inhalt.istGroesserAls(bis))
        {
            linkerNachfolger.eMailsAusgeben(von, bis);
        }
        else
        {
            linkerNachfolger.eMailsAusgeben(von, bis);
            inhalt.ausgeben();
            rechterNachfolger.eMailsAusgeben(von, bis);
        }
    }
}
