package schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_08.arztpraxis_vorlage;

/**
 * Klasse zur Darstellung eines Patienten mit Name und Alter
 */
@SuppressWarnings("unused")
public class Patient
{
    private String name;

    private int alter;

    public Patient(String name, int alter)
    {
        this.name = name;
        this.alter = alter;
    }

    public int nenneAlter()
    {
        return alter;
    }
}
