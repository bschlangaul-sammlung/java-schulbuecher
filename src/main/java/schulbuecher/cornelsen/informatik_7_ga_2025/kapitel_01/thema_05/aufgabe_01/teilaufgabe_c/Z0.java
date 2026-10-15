package schulbuecher.cornelsen.informatik_7_ga_2025.kapitel_01.thema_05.aufgabe_01.teilaufgabe_c;

/**
 * Klasse Z0
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Z0 extends Zustand
{
    /** einziges Objekt der Klasse **/
    private static Z0 z0 = new Z0();

    /**
     * Konstruktor für Objekte der Klasse Z0
     */
    private Z0()
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
        return z0;
    }

    /**
     * Verwaltet die Zustandsübergänge von Z0
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

        case '-':
            return Z1.ObjektGeben();

        case '0':
            return Z3.ObjektGeben();

        default:
            return ZF.ObjektGeben();
        }
    }
}
