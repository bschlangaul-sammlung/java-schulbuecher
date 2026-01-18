package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_04;

/**
 * Die Klasse beschreibt einen balancierten Baum (AVL-Baum) mit den Methoden,
 * die für den Laufzeittest beim Suchen im Baum erforderlich sind. Auf andere
 * Methoden wird verzichtet.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
public class AvlBaum
{
    /**
     * Die Wurzel des Baumes
     */
    private AvlKnoten wurzel;

    /**
     * Konstruktor eines leeren Baumes
     */
    public AvlBaum()
    {
        wurzel = null;
    }

    /**
     * Fügt ein Datenelement in den Baum ein
     *
     * @param d einzufügendes Datenelement
     */
    public void Einfuegen(DatenElement d)
    {
        if (wurzel == null)
        {
            wurzel = new AvlKnoten(d);
        }
        else
        {
            wurzel.Einfuegen(d);
        }
    }

    public DatenElement Suchen(int vergleichswert)
    {
        Zaehler.ZaehlerInkrementieren();
        if (wurzel == null)
        {
            Zaehler.ZaehlerInkrementieren();
            return null;
        }
        else
        {
            Zaehler.ZaehlerInkrementieren();
            return wurzel.Suchen(vergleichswert);
        }
    }
}
