package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_07.baerenhunger_vorlage;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.MouseInfo;

/**
 * Der Baer ist die Hauptfigur, die Essen einsammeln muss.
 */
class Baer extends Actor
{
    private Punktezaehler zaehler;

    /**
     * Der Baer besitzt einen Punktezaehler
     */
    public Baer()
    {
        zaehler = new Punktezaehler("Punktzahl");
    }

    /**
     * Der Baer futtert Essen. Er erhoeht seine Punktzahl und schreibt sie auf
     * den Welthintergrund. Ausserdem folgt er dem Mauszeiger in x-Richtung. Er
     * verringert die Entfernung zum Mauszeiger immer um 10 Prozent, sofern eine
     * Maus verfuegbar ist.
     */
    public void act()
    {
        /*
         * Wenn du Essen beruehrst, erhoehe den Punktezaehler. Das Essen-Objekt
         * verschwindet dann.
         */
        if (isTouching(Essen.class))
        {
            zaehler.erhoeheUm(1);
            removeTouching(Essen.class);
        }
        /*
         * Schreibe den Punktestand links oben auf den Welthintergrund.
         */
        zaehler.zeichneAuf(getWorld().getBackground(), 0, 0);
        /*
         * Frage die Daten der Maus ab.
         */
        MouseInfo maus = Greenfoot.getMouseInfo();
        /*
         * Wenn du eine Maus gefunden hast, bestimme deren x-Koordinate und
         * deine eigenen Koordinaten. Verringere die Entfernung zum Mauszeiger
         * um 10 Prozent der xEntfernung.
         */
        if (maus != null)
        {
            int mausX = maus.getX();
            int meinX = getX();
            int meinY = getY();
            int xEntfernung = mausX - meinX;
            int meinNeuesX = meinX + xEntfernung / 10;
            setLocation(meinNeuesX, meinY);
        }
    }
}
