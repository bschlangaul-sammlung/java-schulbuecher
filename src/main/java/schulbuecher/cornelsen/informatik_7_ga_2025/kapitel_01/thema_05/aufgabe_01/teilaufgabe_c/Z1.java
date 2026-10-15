package schulbuecher.cornelsen.informatik_7_ga_2025.kapitel_01.thema_05.aufgabe_01.teilaufgabe_c;

/**
 * Klasse Z1
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Z1 extends Zustand
{
    /** einziges Objekt der Klasse **/
    private static Z1 z1 = new Z1();

    /**
     * Konstruktor für Objekte der Klasse Z1
     */
    private Z1()
    {
        istEndzustand = false;
    }

    /**
     * Liefert die Referenz auf das einzige Objekt der Klasse
     *
     * @return das einzige Objekt der Klasse
     */
    static Zustand ObjektGeben()
    {
        return z1;
    }

    /**
     * Verwaltet die Zustandsübergänge von Z1
     *
     * @param zei aktuell zu verarbeitendes Zeichen
     *
     * @return Zustand nach erfolgtem Zustandsübergang
     */
    @Override
    Zustand AktZeichenVerarbeiten(char zei)
    {
        switch (zei)
        {
        case '1', '2', '3', '4', '5', '6', '7', '8', '9':
            return Z2.ObjektGeben();

        default:
            return ZF.ObjektGeben();
        }
    }
}
