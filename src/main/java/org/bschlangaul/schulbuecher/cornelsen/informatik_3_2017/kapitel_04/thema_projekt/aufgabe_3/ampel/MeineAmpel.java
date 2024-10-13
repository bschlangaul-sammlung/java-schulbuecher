package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_projekt.aufgabe_3.ampel;

/**
 * Erweiterung der Klasse AMPEL um eine Steuerung mit den Pfeiltasten sowie
 * einer Durchlaufsimluation.
 *
 * @author Mike Ganshorn (Mike_gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class MeineAmpel extends Ampel
{
    public MeineAmpel()
    {
        super();
    }

    public void rot()
    {
        this.rot(true);
        this.gelb(false);
        this.gruen(false);
    }

    public void rotGelb()
    {
        this.rot(true);
        this.gelb(true);
        this.gruen(false);
    }

    public void gruen()
    {
        this.rot(false);
        this.gelb(false);
        this.gruen(true);
    }

    public void gelb()
    {
        this.rot(false);
        this.gelb(true);
        this.gruen(false);
    }

    public void ampeldurchlaufSimulieren()
    {
        this.rot();
        this.warte(2);
        this.rotGelb();
        this.warte(0.5);
        this.gruen();
        warte(2);
        this.gelb();
        warte(0.5);
        this.rot();
    }

    @Override
    public void tasteReagieren(int tastenCode)
    {
        if (tastenCode == TASTE.RAUF)
        {
            this.rot();
        }
        else if (tastenCode == TASTE.RECHTS)
        {
            this.rotGelb();
        }
        else if (tastenCode == TASTE.RUNTER)
        {
            this.gruen();
        }
        else if (tastenCode == TASTE.LINKS)
        {
            this.gelb();
        }
    }

    public void einschalten()
    {
        while (true)
        {
            this.ampeldurchlaufSimulieren();
        }
    }
}
