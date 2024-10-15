package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_01.petrus_16;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

public class Petrus
{
    private Wolke wolke;

    private Timer uhr;

    private Random zufall;

    public Petrus()
    {
        wolke = new Wolke();
        uhr = new Timer(100, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ticke();
            }
        });
        zufall = new Random();
        erzeugeTropfen(20);
    }

    private void ticke()
    {
        wolke.bewege(0.1);
        wolke.zeichne();
    }

    public void starte()
    {
        uhr.start();
    }

    public void stoppe()
    {
        uhr.stop();
    }

    public void erzeugeTropfen(int zahl)
    {
        for (int i = 0; i < zahl; i++)
        {
            Tropfen tr = new Tropfen(zufall.nextInt(600), zufall.nextInt(200),
                    5 + zufall.nextInt(20), wolke);
            wolke.fuegeHinzu(tr);
        }
    }

    public void erzeugeHagel(int zahl)
    {
        for (int i = 0; i < zahl; i++)
        {
            Hagelkorn hk = new Hagelkorn(zufall.nextInt(600),
                    zufall.nextInt(200));
            wolke.fuegeHinzu(hk);
        }
    }

    public void erzeugeFlocken(int zahl)
    {
        for (int i = 0; i < zahl; i++)
        {
            Schneeflocke flocke = new Schneeflocke(zufall.nextInt(600),
                    zufall.nextInt(200));
            wolke.fuegeHinzu(flocke);
        }
    }
}
