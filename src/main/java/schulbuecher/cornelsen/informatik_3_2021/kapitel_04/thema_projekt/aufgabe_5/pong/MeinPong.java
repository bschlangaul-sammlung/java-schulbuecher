package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_projekt.aufgabe_5.pong;

/**
 * Erweiterung der Klasse PONG und die volle Funktionalität des Spiels.
 *
 * @author Mike Ganshorn (Mike_Gans@yahoo.de)
 *
 * @version 1.0 (2019-12-28)
 */
public class MeinPong extends Pong
{
    public MeinPong()
    {
        super();
        super.ballMacheAktiv();
        super.ballSetzeElastizitaet(1.0);
        super.bodenMachePassiv();
        super.linkerSpielerMachePassiv();
        super.rechterSpielerMachePassiv();
        if (super.zufallszahlVonBis(1, 2) == 1)
        {
            super.ballWirkeImpuls(100, 0);
        }
        else
        {
            super.ballWirkeImpuls(-100, 0);
        }
        super.bodenSetzeElastizitaet(0.5);
        super.linkerSpielerSetzeElastizitaet(0.5);
        super.rechterSpielerSetzeElastizitaet(0.5);
        super.ballSetzeMittelpunkt(0, 8);
        super.zeigeKoordinaten(false);
        super.starteTickerNeu(0.1);
    }

    @Override
    public void tasteReagieren(int tastenCode)
    {
        if (tastenCode == TASTE.RAUF)
        {
            if (super.rechterSpielerNenneMittelpunktY() < 8)
            {
                super.rechtenSpielerVerschiebenUm(0, 1);
            }
        }
        else if (tastenCode == TASTE.RUNTER)
        {
            if (super.rechterSpielerNenneMittelpunktY() > -8)
            {
                super.rechtenSpielerVerschiebenUm(0, -1);
            }
        }
        else if (tastenCode == TASTE.W)
        {
            if (super.linkerSpielerNenneMittelpunktY() < 8)
            {
                super.linkenSpielerVerschiebenUm(0, 1);
            }
        }
        else if (tastenCode == TASTE.S)
        {
            if (super.linkerSpielerNenneMittelpunktY() > -8)
            {
                super.linkenSpielerVerschiebenUm(0, -1);
            }
        }
    }

    @Override
    public void tick()
    {
        if (super.ballNenneMittelpunktX() > 14)
        {
            super.ballStoppen();
            super.erhoehePunktestandLinks();
            super.ballSetzeMittelpunkt(0, 8);
            super.ballWirkeImpuls(100, 0);
        }
        else if (super.ballNenneMittelpunktX() < -14)
        {
            super.ballStoppen();
            super.erhoehePunktestandRechts();
            super.ballSetzeMittelpunkt(0, 8);
            super.ballWirkeImpuls(-100, 0);
        }
    }
}
