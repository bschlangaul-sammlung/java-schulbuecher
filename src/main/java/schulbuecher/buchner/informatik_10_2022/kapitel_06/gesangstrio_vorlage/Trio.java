package schulbuecher.buchner.informatik_10_2022.kapitel_06.gesangstrio_vorlage;

/**
 * Klasse Trio fuer Kapitel 4.6 Aufgabe 1
 *
 * @author Barbara Wieczorek
 *
 * @version 2022-09-12
 */
class Trio
{
    private String name;

    private Saenger saenger1;

    private Saenger saenger2;

    private Saenger saenger3;

    public Trio(String einName, Saenger einS1, Saenger einS2, Saenger einS3)
    {
        name = einName;
        saenger1 = einS1;
        saenger2 = einS2;
        saenger3 = einS3;
    }

    public String gibName()
    {
        return name;
    }

    public void zeigeSaenger()
    {
        System.out.println("Das Trio besteht aus folgenden Sängern:");
        System.out.println("Sänger 1: " + saenger1.gibName());
        System.out.println("Sänger 2: " + saenger2.gibName());
        System.out.println("Sänger 3: " + saenger3.gibName());
    }
}
