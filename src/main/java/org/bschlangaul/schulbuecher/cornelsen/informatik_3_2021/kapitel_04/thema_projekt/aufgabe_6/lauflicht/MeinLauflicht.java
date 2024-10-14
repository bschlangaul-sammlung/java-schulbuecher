package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_projekt.aufgabe_6.lauflicht;

/**
 * Erweiterung der Klasse LAUFLICHT um zusätliche Methoden
 *
 * @author Mike Ganshorn (Mike_Gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class MeinLauflicht extends Lauflicht
{
    public MeinLauflicht()
    {
        super();
    }

    public void geradeAn()
    {
        for (int i = 0; i <= 6; i = i + 2)
        {
            super.licht(i, true);
        }
    }

    public void geradeAus()
    {
        for (int i = 0; i <= 6; i = i + 2)
        {
            super.licht(i, false);
        }
    }

    public void ungeradeAn()
    {
        for (int i = 1; i <= 7; i = i + 2)
        {
            super.licht(i, true);
        }
    }

    public void ungeradeAus()
    {
        for (int i = 1; i <= 7; i = i + 2)
        {
            super.licht(i, false);
        }
    }

    public void alleAn()
    {
        this.geradeAn();
        this.ungeradeAn();
    }

    public void alleAus()
    {
        this.geradeAus();
        this.ungeradeAus();
    }

    public void flash(int anzahl)
    {
        this.alleAus();
        for (int i = 0; i < anzahl; i++)
        {
            this.geradeAus();
            this.ungeradeAn();
            super.warte(0.1);
            this.ungeradeAus();
            this.geradeAn();
            super.warte(0.1);
        }
        this.alleAus();
    }

    public void LaufNachRechts()
    {
        this.alleAus();
        for (int i = 0; i < 8; i++)
        {
            super.licht(i, true);
            super.warte(0.1);
            super.licht(i, false);
        }
    }

    public void LaufNachLinks()
    {
        this.alleAus();
        for (int i = 7; i >= 0; i--)
        {
            super.licht(i, true);
            super.warte(0.1);
            super.licht(i, false);
        }
    }
}
