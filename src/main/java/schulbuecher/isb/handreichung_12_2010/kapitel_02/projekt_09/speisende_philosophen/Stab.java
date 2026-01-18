package schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_09.speisende_philosophen;

/**
 * Klasse zur Simulation eines Stäbchens zum Essen<br/>
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Stab
{
    /**
     * speichert, ob der Stab aufgenommen wurde.
     */
    private boolean gegriffen = false;

    /**
     * prüft, ob der Stab bereits verwendet wird, wenn nicht wird er vom
     * aufrufenden Philosophen in die Hand genommen, muss synchronisiert sein.
     *
     * @return true, falls der Stab aufgenommen werden konnte, weil er noch
     *     nicht verwendet wird.
     */
    public synchronized boolean nehmen()
    {
        if (gegriffen == false)
        {
            gegriffen = true;
            return true;
        }
        return false;
    }

    /**
     * gibt den Stab wieder zur Verwendung frei.
     */
    public synchronized void loslassen()
    {
        gegriffen = false;
    }
}
