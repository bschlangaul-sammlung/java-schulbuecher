package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_01.petrus_14;

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
        erzeugeNiederschlag(20);
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

    public void erzeugeNiederschlag(int zahl)
    {
        for (int i = 0; i < zahl; i++)
        {
            Niederschlag n = new Niederschlag(zufall.nextInt(600),
                    zufall.nextInt(200));
            wolke.fuegeHinzu(n);
        }
    }
}
