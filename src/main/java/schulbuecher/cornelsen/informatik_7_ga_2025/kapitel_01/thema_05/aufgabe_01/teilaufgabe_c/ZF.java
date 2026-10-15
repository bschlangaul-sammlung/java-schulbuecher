package schulbuecher.cornelsen.informatik_7_ga_2025.kapitel_01.thema_05.aufgabe_01.teilaufgabe_c;

/**
 * Klasse ZF
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class ZF extends Zustand
{
    /** einziges Objekt der Klasse **/
    private static ZF zf = new ZF();

    /**
     * Konstruktor für Objekte der Klasse ZF
     */
    private ZF()
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
        return zf;
    }

    /**
     * Verwaltet die Zustandsübergänge von ZF
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
