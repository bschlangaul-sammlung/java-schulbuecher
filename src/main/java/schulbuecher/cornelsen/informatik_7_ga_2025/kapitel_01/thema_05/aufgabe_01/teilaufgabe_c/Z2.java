package schulbuecher.cornelsen.informatik_7_ga_2025.kapitel_01.thema_05.aufgabe_01.teilaufgabe_c;

/**
 * Klasse Z2
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Z2 extends Zustand
{
    /** einziges Objekt der Klasse **/
    private static Z2 z2 = new Z2();

    /**
     * Konstruktor für Objekte der Klasse Z2
     */
    private Z2()
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
        return z2;
    }

    /**
     * Verwaltet die Zustandsübergänge von Z2
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
        case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
            return Z2.ObjektGeben();

        default:
            return ZF.ObjektGeben();
        }
    }
}
