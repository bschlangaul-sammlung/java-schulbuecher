package schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.warteschlange_einfach;

public class Arbeit
{
    public Arbeit()
    {
    }

    public void Ausfuehren()
    {
        Warteschlange warteSchlange = new Warteschlange();
        warteSchlange.EndeEinfuegen("Huber", "Eduard");
        warteSchlange.EndeEinfuegen("Meier", "Paul");
        warteSchlange.EndeEinfuegen("Müller", "Inge");
        System.out.println("Alle");
        warteSchlange.AlleAusgeben();
        System.out.println(warteSchlange.AnzahlGeben());
        warteSchlange.AnfangEntfernen();
        System.out.println("Vorne weg");
        warteSchlange.AlleAusgeben();
        System.out.println(warteSchlange.AnzahlGeben());
    }
}
