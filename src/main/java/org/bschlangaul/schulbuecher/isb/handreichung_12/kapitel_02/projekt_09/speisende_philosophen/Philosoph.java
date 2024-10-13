package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_09.speisende_philosophen;

/**
 * Klasse zur Simulation eines Philosophen<br/>
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class Philosoph extends Thread
{
    /**
     * der Name des Philosphen
     */
    private String Name;

    /**
     * Referenz auf den linken Stab
     */
    private Stab linkerStab;

    /**
     * Referenz auf den rechten Stab
     */
    private Stab rechterStab;

    /**
     * speichert ob der rechte Stab in der Hand gehalten wird
     */
    private boolean halteRechtenStab = false;

    /**
     * speichert ob der linke Stab in der Hand gehalten wird
     */
    private boolean halteLinkenStab = false;

    /**
     * Konstruktor
     *
     * @param Name Name des Philosphen
     * @param linkerStab Referenz auf den linken Stab
     * @param rechterStab Referenz auf den rechten Stab
     */
    public Philosoph(String Name, Stab linkerStab, Stab rechterStab)
    {
        this.Name = Name;
        this.linkerStab = linkerStab;
        this.rechterStab = rechterStab;
    }

    /**
     * zur Simulation des Denkens wird eine zufällige Zeitspanne lang gewartet
     */
    private void denken()
    {
        String prefix = "[";
        if (halteLinkenStab)
        {
            prefix += "L";
        }
        if (halteRechtenStab)
        {
            prefix += "R";
        }
        prefix += "] ";
        System.out.println(prefix + "Philosoph " + Name + " denkt");
        try
        {
            // denkt eine gewisse Zeit
            sleep((int) (Math.random() * 1000));
        }
        catch (InterruptedException e)
        {
        }
    }

    /**
     * zur Simulation des Essens wird eine zufällige Zeitspanne lang gewartet,
     * anschließend werden die Stäbchen zurückgelegt.
     * <p>
     * Beim Aufruf dieser Methode muss bereits sichergestellt sein, dass der
     * Philosoph beide Stäbchen in den Händen hält.
     */
    private void essen()
    {
        System.out.println("Philosoph " + Name + " isst");
        try
        {
            // denkt eine gewisse Zeit
            sleep((int) (Math.random() * 1000));
        }
        catch (InterruptedException e)
        {
        }
        linkerStab.loslassen();
        halteLinkenStab = false;
        rechterStab.loslassen();
        halteRechtenStab = false;
    }

    /**
     * versucht irgendeinen freien Stab zu greifen
     */
    private void GreifeNachStab()
    {
        if (!halteRechtenStab)
        {
            halteRechtenStab = rechterStab.nehmen();
            if (halteRechtenStab)
            {
                System.out.println("Philosoph " + Name + " nimmt rechten Stab");
            }
        }
        if (!halteLinkenStab)
        {
            halteLinkenStab = linkerStab.nehmen();
            if (halteLinkenStab)
            {
                System.out.println("Philosoph " + Name + " nimmt linken Stab");
            }
        }
    }

    /**
     * versucht immer wieder abwechselnd zu essen, oder falls nicht bei Stäbe in
     * den Händen sind, nach den Stäben zu greifen.
     */
    @Override
    public void run()
    {
        while (true)
        {
            denken();
            if ((halteRechtenStab) && (halteLinkenStab))
            {
                essen();
            }
            else
            {
                GreifeNachStab();
            }
        }
    }
}
