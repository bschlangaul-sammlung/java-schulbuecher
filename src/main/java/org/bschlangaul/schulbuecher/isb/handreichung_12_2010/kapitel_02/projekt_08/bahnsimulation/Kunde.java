package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_08.bahnsimulation;

/**
 * Diese Klasse simuliert das Buchungsverhalten eines Kunden<br/>
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class Kunde extends Thread
{
    /**
     * Referenzen auf die Züge mit Möglichkeit der Information und Buchung
     */
    private Zug[] zuege;

    /**
     * Konstruktor der Klasse
     *
     * @param name Name des Kunden
     * @param zuege Referenzen auf buchbare Züge
     */
    public Kunde(String name, Zug[] zuege)
    {
        super(name);
        this.zuege = zuege;
    }

    /**
     * Der Kunde bucht zufallsgesteuert in den verschiedenen Zügen
     */
    @Override
    public void run()
    {
        int auswahl, zufall;
        for (int i = 0; i < 50; i++)
        {
            zufall = (int) (Math.random() * 100);
            try
            { // Kunde verbalisiert seine Wünsche ...
                sleep(zufall);
            }
            catch (InterruptedException e)
            {
            }
            if (zufall % 2 == 0)
            {
                auswahl = 0;
            }
            else
            {
                auswahl = 1;
            }
            System.out.println(getName() + ": Platz "
                    + zuege[auswahl].nochFrei() + " in der "
                    + zuege[auswahl].getName() + " reserviert");
        }
    }
}
