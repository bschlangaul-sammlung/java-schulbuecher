package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.jalando_vorlage;

/**
 * Klasse zur Darstellung eines Kunden
 */
@SuppressWarnings("unused")
public class Kunde
{
    private String name;

    private Artikel[] einkaufskorb;

    public Kunde(String name)
    {
        this.name = name;
        this.einkaufskorb = new Artikel[10];
    }

    public void hinzufuegen(Artikel artikel)
    {
        for (int i = 0; i < einkaufskorb.length; i++)
        {
            if (einkaufskorb[i] == null)
            {
                einkaufskorb[i] = artikel;
                return;
            }
        }
        Artikel[] zwischenspeicher = einkaufskorb;
        einkaufskorb = new Artikel[zwischenspeicher.length + 1];
        for (int i = 0; i < zwischenspeicher.length; i++)
        {
            einkaufskorb[i] = zwischenspeicher[i];
        }
        einkaufskorb[einkaufskorb.length - 1] = artikel;
    }
}
