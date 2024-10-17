package org.bschlangaul.schulbuecher.isb.abitur.muster_2011.inf2.aufgabe_iii.teilaufgabe_01.schloss;

class Automat
{
    // Atribute
    private int zustand;

    // Konstruktor
    Automat()
    {
        zustand = 0;
    }

    void codeTesten(String w)
    {
        zustand = 0;
        String original = w;
        for (int i = 0; i < w.length(); i++)
        {
            schalten(w.charAt(i));
        }
        if (zustand == 4)
        {
            System.out.println("Automat akzeptiert " + original);
        }
        else
        {
            System.out.println("Automat akzeptiert " + original + " nicht");
        }
    }

    // Schaltmethode
    private void schalten(char z)
    {
        switch (zustand)
        {
        case 0:
            if (z == '0')
            {
                zustand = 1;
            }
            else
            {
                zustand = 2;
            }
            break;

        case 1:
            if (z == '0')
            {
                zustand = 1;
            }
            else
            {
                zustand = 3;
            }
            break;

        case 2:
            zustand = 2;
            break;

        case 3:
            if (z == '0')
            {
                zustand = 2;
            }
            else
            {
                zustand = 4;
            }
            break;

        case 4:
            zustand = 2;
            break;
        }
    }
}
