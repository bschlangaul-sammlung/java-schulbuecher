package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_abschluss;

public class Arbeit
{
    public Arbeit()
    {
    }

    public void Ausfuehren1()
    {
        Liste warteSchlange = new Liste();
        warteSchlange.EndeEinfuegen(new Kunde("Huber", "Eduard"));
        warteSchlange.EndeEinfuegen(new Kunde("Meier", "Paul"));
        warteSchlange.EndeEinfuegen(new Kunde("Müller", "Inge"));
        System.out.println("Alle");
        warteSchlange.AlleAusgeben();
        System.out.println(warteSchlange.AnzahlGeben());
        warteSchlange.AnfangEntfernen();
        System.out.println("Vorne weg");
        warteSchlange.AlleAusgeben();
        System.out.println(warteSchlange.AnzahlGeben());
    }
}
