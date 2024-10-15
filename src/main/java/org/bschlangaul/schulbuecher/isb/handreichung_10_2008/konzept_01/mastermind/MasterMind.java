package org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_01.mastermind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

import org.bschlangaul.schulbuecher.isb.handreichung_10_2008.konzept_01.ZeichenFenster;

public class MasterMind
{
    private int[] vorgabe, tipp;

    private SpielWalze[] anzeige;

    private SpielWalze[] auswertung;

    private int anzahlWeiss, anzahlSchwarz;

    private Random zufall;

    private FarbeAuswahl auswahl1, auswahl2, auswahl3, auswahl4;

    public MasterMind()
    {
        vorgabe = new int[4];
        tipp = new int[4];
        anzeige = new SpielWalze[4];
        auswertung = new SpielWalze[4];
        zufall = new Random();
        for (int i = 0; i < 4; i++)
        {
            anzeige[i] = new SpielWalze(40 * i, 0, 40, 0);
            auswertung[i] = new SpielWalze(170 + i * 30, 5, 30, 0);
        }
        erzeugeVorgabe();
        ZeichenFenster fenster = ZeichenFenster.gibFenster();
        fenster.setzeTitel("Mastermind");
        JButton schaltknopf = new JButton("Raten");
        schaltknopf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                rate();
            }
        });
        fenster.komponenteHinzufuegen(schaltknopf, "rechts");
        auswahl1 = new FarbeAuswahl(6);
        auswahl2 = new FarbeAuswahl(6);
        auswahl3 = new FarbeAuswahl(6);
        auswahl4 = new FarbeAuswahl(6);
        fenster.komponenteHinzufuegen(auswahl1, "unten");
        fenster.komponenteHinzufuegen(auswahl2, "unten");
        fenster.komponenteHinzufuegen(auswahl3, "unten");
        fenster.komponenteHinzufuegen(auswahl4, "unten");
    }

    private void erzeugeVorgabe()
    {
        for (int i = 0; i < 4; i++)
        {
            vorgabe[i] = 1 + zufall.nextInt(6);
        }
    }

    public void rate()
    {
        tippe(auswahl1.gibFarbnummer(), auswahl2.gibFarbnummer(),
                auswahl3.gibFarbnummer(), auswahl4.gibFarbnummer());
    }

    public void tippe(int r0, int r1, int r2, int r3)
    {
        tipp[0] = r0;
        tipp[1] = r1;
        tipp[2] = r2;
        tipp[3] = r3;
        for (int i = 0; i < 4; i++)
        {
            anzeige[i].verschiebe(0, 45);
            anzeige[i].faerbeUm(tipp[i]);
            auswertung[i].verschiebe(0, 45);
        }
        werteAus();
        for (int i = 0; i < anzahlSchwarz; i++)
        {
            auswertung[i].faerbeUm(0);
        }
        for (int i = anzahlSchwarz; i < anzahlWeiss + anzahlSchwarz; i++)
        {
            auswertung[i].faerbeUm(8);
        }
    }

    public void werteAus()
    {
        int kopie[] = new int[4];
        anzahlWeiss = 0;
        anzahlSchwarz = 0;
        for (int i = 0; i < 4; i++)
        {
            kopie[i] = vorgabe[i];
        }
        for (int i = 0; i < 4; i++)
        {
            if (kopie[i] == tipp[i])
            {
                anzahlSchwarz++;
                kopie[i] = -1;
                tipp[i] = -2;
            }
        }
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (kopie[i] == tipp[j])
                {
                    anzahlWeiss++;
                    kopie[i] = -1;
                    tipp[j] = -2;
                }
            }
        }
    }
}
