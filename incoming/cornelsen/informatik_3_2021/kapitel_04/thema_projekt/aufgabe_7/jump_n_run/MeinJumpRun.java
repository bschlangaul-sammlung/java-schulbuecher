package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_projekt.aufgabe_7.jump_n_run;

/**
 * Erweitert die Klasse JumpRun um die volle Spielfunktionalität.
 *
 * @author Mike Ganshorn (Mike_Gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class MeinJumpRun extends JumpRun
{
    private int aktionen;

    public MeinJumpRun()
    {
        super();
        this.aktionen = 0;
        super.starteTickerNeu(0.1);
    }

    @Override
    public void tasteReagieren(int tastenCode)
    {
        if (tastenCode == TASTE.RAUF)
        {
            super.wirkeImpulsAufSpieler(0, 2500);
        }
        else if (tastenCode == TASTE.RECHTS)
        {
            super.wirkeImpulsAufSpieler(1000, 0);
        }
        else if (tastenCode == TASTE.RUNTER)
        {
            super.spielerStoppen();
        }
        else if (tastenCode == TASTE.LINKS)
        {
            super.wirkeImpulsAufSpieler(-1000, 0);
        }
        this.aktionen++;
        super.anzeigeAktualisieren(aktionen);
    }

    @Override
    public void tick()
    {
        if (super.spielerBeruehrtKreisel()
                || super.spielerBeruehrtLinkenWaechter()
                || super.spielerBeruehrtRechtenWaechter())
        {
            super.stoppeTicker();
            super.zeigeSpielVerlorenAn();
        }
        if (super.spielerBeruehrtStern())
        {
            super.stoppeTicker();
            super.zeigeSpielGewonnenAn();
        }
    }
}
