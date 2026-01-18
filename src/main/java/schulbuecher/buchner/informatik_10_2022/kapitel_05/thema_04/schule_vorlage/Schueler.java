package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_04.schule_vorlage;

/**
 * Projekt 5-4_Turnier
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Schueler
{
    private String name;

    private int alter;

    public Schueler(String name)
    {
        this.name = name;
    }

    public Schueler(String name, int alter)
    {
        this.name = name;
        this.alter = alter;
    }

    public String nenneName()
    {
        return name;
    }
}
