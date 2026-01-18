package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_00.aufgabe_03.bestellsystem;

/**
 * Klasse zum Testen
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Test
{
    Bestellsystem b;

    Test()
    {
        b = new Bestellsystem(10);
        b.Bestellen(1, "Spinatknödel", 2);
        b.Bestellen(1, "Maracujaschorle", 3);
        b.RechnungAusgeben(1);
    }
}
