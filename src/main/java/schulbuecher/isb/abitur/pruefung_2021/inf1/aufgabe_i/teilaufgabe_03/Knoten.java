package schulbuecher.isb.abitur.pruefung_2021.inf1.aufgabe_i.teilaufgabe_03;

/**
 * InnerNode
 */
public class Knoten
{
    Kunstwerk inhalt;

    Baumelement nachfolgerLinks;

    Baumelement nachfolgerRechts;

    void ortAendern(String name, Ort ortNeu)
    {
        int v = name.compareTo(inhalt.nameGeben());
        if (v == 0)
        {
            inhalt.ortSetzen(ortNeu);
        }
        else if (v > 0)
        {
            nachfolgerRechts.ortAendern(name, ortNeu);
        }
        else
        {
            nachfolgerLinks.ortAendern(name, ortNeu);
        }
    }
}
