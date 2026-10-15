package schulbuecher.cornelsen.informatik_7_ga_2025.kapitel_01.thema_05.aufgabe_01.teilaufgabe_c;

/**
 * Klasse Z3
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Z3 extends Zustand
{
    /** einziges Objekt der Klasse **/
    private static Z3 z3 = new Z3();

    /**
     * Konstruktor für Objekte der Klasse Z3
     */
    private Z3()
    {
        istEndzustand = true;
    }

    /**
     * Liefert die Referenz auf das einzige Objekt der Klasse
     *
     * @return das einzige Objekt der Klasse
     */
    static Zustand ObjektGeben()
    {
        return z3;
    }

    /**
     * Verwaltet die Zustandsübergänge von Z3
     *
     * @param zei aktuell zu verarbeitendes Zeichen
     *
     * @return Zustand nach erfolgtem Zustandsübergang
     */
    @Override
    Zustand AktZeichenVerarbeiten(char zei)
    {
        return ZF.ObjektGeben();
    }
}
