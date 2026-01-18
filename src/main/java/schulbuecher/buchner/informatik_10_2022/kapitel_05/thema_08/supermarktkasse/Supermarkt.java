package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_08.supermarktkasse;

import java.util.ArrayList;

/**
 * Klasse zur Darstellung eines Supermarktes
 */
@SuppressWarnings("unused")
public class Supermarkt
{
    private String name;

    private ArrayList<Person> kassenschlange;

    /**
     * e)
     */
    private ArrayList<Person> kassenschlange2;

    public Supermarkt()
    {
        name = "Zuckerberg-Markt";
        kassenschlange = new ArrayList<Person>();
        // e
        kassenschlange2 = new ArrayList<Person>();
    }

    /**
     * a)
     */
    public void anstellen(Person p)
    {
        kassenschlange.add(p);
    }

    /**
     * e)
     */
    public void anstellenAufgabeE(Person p)
    {
        if (kassenschlange.size() >= 5)
        {
            kassenschlange2.add(p);
        }
        else
        {
            kassenschlange.add(p);
        }
    }

    /**
     * b)
     */
    public void vorlassen(Person p)
    {
        kassenschlange.add(0, p);
    }

    /**
     * c)
     */
    public void tauschen(Person p, int position)
    {
        kassenschlange.set(position, p);
    }

    /**
     * f)
     */
    public boolean zusammenfassen()
    {
        if (kassenschlange.size() + kassenschlange2.size() <= 5)
        {
            while (!kassenschlange2.isEmpty())
            {
                kassenschlange.add(kassenschlange2.remove(0));
            }
            return true;
        }
        return false;
    }
}
