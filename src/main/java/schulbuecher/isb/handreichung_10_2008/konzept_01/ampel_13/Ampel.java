package schulbuecher.isb.handreichung_10_2008.konzept_01.ampel_13;

public class Ampel
{
    enum Zustand
    {
        rot, gruen, gelb, rotgelb, aus
    };

    private SpielWalze oben, mitte, unten;

    private Zustand z;

    public Ampel()
    {
        z = Zustand.aus;
        oben = new SpielWalze(100, 100, 100, 0);
        mitte = new SpielWalze(100, 200, 100, 0);
        unten = new SpielWalze(100, 300, 100, 0);
        oben.zeichne();
        mitte.zeichne();
        unten.zeichne();
    }

    private void setzeZustand(Zustand zustandNeu)
    {
        z = zustandNeu;
        if (z == Zustand.aus)
        {
            oben.faerbeUm(0);
            mitte.faerbeUm(0);
            unten.faerbeUm(0);
        }
        if (z == Zustand.rot)
        {
            oben.faerbeUm(4);
            mitte.faerbeUm(0);
            unten.faerbeUm(0);
        }
        if (z == Zustand.gruen)
        {
            oben.faerbeUm(0);
            mitte.faerbeUm(0);
            unten.faerbeUm(2);
        }
        if (z == Zustand.gelb)
        {
            oben.faerbeUm(0);
            mitte.faerbeUm(6);
            unten.faerbeUm(0);
        }
        if (z == Zustand.rotgelb)
        {
            oben.faerbeUm(4);
            mitte.faerbeUm(6);
            unten.faerbeUm(0);
        }
    }

    public void schalteEin()
    {
        if (z == Zustand.aus)
        {
            setzeZustand(Zustand.gelb);
        }
    }

    public void schalteWeiter()
    {
        if (z == Zustand.gelb)
        {
            setzeZustand(Zustand.rot);
        }
        else
        {
            if (z == Zustand.rot)
            {
                setzeZustand(Zustand.rotgelb);
            }
            else
            {
                if (z == Zustand.rotgelb)
                {
                    setzeZustand(Zustand.gruen);
                }
                else
                {
                    if (z == Zustand.gruen)
                    {
                        setzeZustand(Zustand.gelb);
                    }
                }
            }
        }
    }

    public void schalteAus()
    {
        if (z == Zustand.gruen)
        {
            setzeZustand(Zustand.aus);
        }
    }

    public static void main(String[] args)
    {
        Ampel ampel = new Ampel();
        ampel.schalteEin();
        ampel.schalteWeiter();
        ampel.schalteWeiter();
        ampel.schalteWeiter();
    }
}
