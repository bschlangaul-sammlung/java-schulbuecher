package org.bschlangaul.schulbuecher.paetec.informatik_10_2008.klassen.eps.fortgeschrittenes_formular;

import java.awt.Component;

/**
 * Diese Klasse stellt die Schnittstelle fuer alle Formulargrafiken dar (Text,
 * Bild, Eingabefeld).
 *
 * @author Florian Prager, Universität Passau
 *
 * @version 06.2008
 */
public abstract class Formulargrafik
{
    private Component awtKomponente;

    private Formular formular;

    private int urspruenglicheYPos;

    private int urspruenglicheXPos;

    private static int idZaehler;

    private int id;

    public Formulargrafik()
    {
        id = idZaehler++;
        this.formular = Formular.formularGeben();
    }

    public Formulargrafik(Formular formular)
    {
        id = idZaehler++;
        if (formular != null)
            this.formular = formular;
        else
            this.formular = Formular.formularGeben();
    }

    /**
     * Legt die Grafik auf das Formular
     */
    public void anzeigen()
    {
        formular.formulargrafikHinzufuegen(this, true);
    }

    /**
     * Entfernt die Grafik vom Formular;
     */
    public void verstecken()
    {
        formular.formulargrafikEntfernen(this);
    }

    /**
     * Liefert die aktuelle Breite der Grafik.
     *
     * @return die Breite
     */
    public int breiteGeben()
    {
        return awtKomponente.getWidth();
    }

    /**
     * Liefert die aktuelle Hoehe der Grafik.
     *
     * @return die Hoehe
     */
    public int hoeheGeben()
    {
        return awtKomponente.getHeight();
    }

    /**
     * Liefefert die aktuelle xPosition der Grafik.
     *
     * @return die position
     */
    public int xPositionGeben()
    {
        return awtKomponente.getX();
    }

    /**
     * Liefefert die aktuelle yPosition der Grafik.
     *
     * @return die position
     */
    public int yPositionGeben()
    {
        return awtKomponente.getY();
    }

    /**
     * Liefert die eindeutige ID der Grafik.
     *
     * @return die ID
     */
    public int idGeben()
    {
        return id;
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    public boolean equals(Object o)
    {
        if (!(o instanceof Formulargrafik) && !(o instanceof Integer))
            return false;
        else if (o instanceof Integer)
            return ((Integer) o).intValue() == id;
        else
            return ((Formulargrafik) o).idGeben() == id;
    }

    Formulargrafik(int id)
    {
        this.id = id;
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    int urspruenglicheYPosGeben()
    {
        return urspruenglicheYPos;
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    int urspruenglicheXPosGeben()
    {
        return urspruenglicheXPos;
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    Component awtKomponenteGeben()
    {
        return awtKomponente;
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    void awtKomponenteSetzen(Component c)
    {
        awtKomponente = c;
    }

    /**
     * Kann vom Formular aufgerufen werden.
     */
    void groesseSetzen(int breite, int hoehe)
    {
        awtKomponente.setSize(breite, hoehe);
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    void rahmenSetzen(int x, int y, int breite, int hoehe)
    {
        awtKomponente.setBounds(x, y, breite, hoehe);
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    void urspruenglichePositionSichern()
    {
        urspruenglicheXPos = awtKomponente.getX();
        urspruenglicheYPos = awtKomponente.getY();
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    Formular formularGeben()
    {
        return formular;
    }

    /**
     * Wird vom Formular aufgerufen.
     */
    abstract void formatieren();
}
