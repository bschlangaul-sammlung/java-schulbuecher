package org.bschlangaul.schulbuecher.isb.handreichung_11_2009.kapitel_01.thema_01.listen.liste_abschluss_erweiterung;

public class Arbeit
{
    public Arbeit()
    {
    }

    public void Ausfuehren1()
    {
        Liste testListe = new Liste();
        testListe.SortiertEinfuegen(new Kunde("Paulinger", "Hilde"));
        testListe.SortiertEinfuegen(new Kunde("Müller", "Inge"));
        testListe.SortiertEinfuegen(new Kunde("Huber", "Eduard"));
        testListe.SortiertEinfuegen(new Kunde("Meier", "Paul"));
        testListe.SortiertEinfuegen(new Kunde("Neulinger", "Werner"));
        testListe.SortiertEinfuegen(new Kunde("Adam", "Eva"));
        System.out.println("Alle");
        testListe.AlleAusgeben();
        System.out.println(testListe.AnzahlGeben());
        Kunde suchKunde = new Kunde("Meier", "Paul");
        System.out.println(testListe.Suchen(suchKunde));
        Kunde entfernKunde = new Kunde("Neulinger", "Werner");
        testListe.Entfernen(entfernKunde);
        System.out.println("Alle nach Entfernen Neulinger");
        testListe.AlleAusgeben();
        System.out.println(testListe.AnzahlGeben());
        testListe.AnfangEntfernen();
        System.out.println("Vorne weg");
        testListe.AlleAusgeben();
        System.out.println(testListe.AnzahlGeben());
    }
}
