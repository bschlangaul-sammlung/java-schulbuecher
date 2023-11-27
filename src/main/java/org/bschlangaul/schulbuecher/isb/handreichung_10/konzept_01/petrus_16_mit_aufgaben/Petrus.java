package org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.petrus_16_mit_aufgaben;

import org.bschlangaul.schulbuecher.isb.handreichung_10.konzept_01.ZeichenFenster;

import javax.swing.Timer;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Petrus
{
    private Wolke wolke;

    private Timer uhr;

    private Random zufall;

    private JButton startknopf, stopknopf, regenknopf, schneeknopf, hagelknopf,
            wirbelknopf, nebelknopf, blasenknopf;

    private JTextField eingabe;

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
        startknopf = new JButton("Start");
        startknopf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                starte();
            }
        });
        ZeichenFenster.gibFenster().komponenteHinzufuegen(startknopf, "rechts");
        stopknopf = new JButton("Stopp");
        stopknopf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                stoppe();
            }
        });
        ZeichenFenster.gibFenster().komponenteHinzufuegen(stopknopf, "rechts");
        eingabe = new JTextField("20");
        ZeichenFenster.gibFenster().komponenteHinzufuegen(eingabe, "rechts");
        regenknopf = new JButton("Regen erzeugen");
        regenknopf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                erzeugeTropfen(holeEingabe());
            }
        });
        ZeichenFenster.gibFenster().komponenteHinzufuegen(regenknopf, "rechts");
        hagelknopf = new JButton("Hagel erzeugen");
        hagelknopf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                erzeugeHagel(holeEingabe());
            }
        });
        ZeichenFenster.gibFenster().komponenteHinzufuegen(hagelknopf, "rechts");
        schneeknopf = new JButton("Schnee erzeugen");
        schneeknopf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                erzeugeFlocken(holeEingabe());
            }
        });
        ZeichenFenster.gibFenster().komponenteHinzufuegen(schneeknopf,
                "rechts");
        wirbelknopf = new JButton("Wirbelschnee erzeugen");
        wirbelknopf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                erzeugeWirbelflocken(holeEingabe());
            }
        });
        ZeichenFenster.gibFenster().komponenteHinzufuegen(wirbelknopf,
                "rechts");
        nebelknopf = new JButton("Nebel erzeugen");
        nebelknopf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                erzeugeNebel(holeEingabe());
            }
        });
        ZeichenFenster.gibFenster().komponenteHinzufuegen(nebelknopf, "rechts");
        blasenknopf = new JButton("Luftblasen erzeugen");
        blasenknopf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                erzeugeBlasen(holeEingabe());
            }
        });
        ZeichenFenster.gibFenster().komponenteHinzufuegen(blasenknopf,
                "rechts");
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

    public void erzeugeWirbelflocken(int zahl)
    {
        for (int i = 0; i < zahl; i++)
        {
            Wirbelflocke flocke = new Wirbelflocke(zufall.nextInt(600),
                    zufall.nextInt(200));
            wolke.fuegeHinzu(flocke);
        }
    }

    public void erzeugeBlasen(int zahl)
    {
        for (int i = 0; i < zahl; i++)
        {
            Luftblase bl = new Luftblase(zufall.nextInt(600),
                    280 + zufall.nextInt(200), 5 + zufall.nextInt(20), wolke);
            wolke.fuegeHinzu(bl);
        }
    }

    public void erzeugeNebel(int zahl)
    {
        for (int i = 0; i < zahl; i++)
        {
            Nebeltropfen nt = new Nebeltropfen(zufall.nextInt(600),
                    zufall.nextInt(480), 5 + zufall.nextInt(40), wolke);
            wolke.fuegeHinzu(nt);
        }
    }

    private int holeEingabe()
    {
        return Integer.parseInt(eingabe.getText());
    }
}
