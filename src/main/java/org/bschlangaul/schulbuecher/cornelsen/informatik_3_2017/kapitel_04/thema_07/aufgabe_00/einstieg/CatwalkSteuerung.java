package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_07.aufgabe_00.einstieg;

/**
 * Steuerung der Leuchten auf dem Catwalk
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class CatwalkSteuerung extends Figur
{
    /**
     * Der Laufsteg
     */
    Catwalk laufsteg;

    /**
     * Der Zähler für die Farbensteuerung
     */
    int zähler;

    /**
     * Legt den Laufsteg und den Zufallsgenerator an.
     */
    CatwalkSteuerung()
    {
        laufsteg = new Catwalk();
        SichtbarkeitSetzen(false);
        zähler = 0;
    }

    /**
     * Lässt die Farben eine Spalte weiter laufen
     */
    @Override
    void AktionAusführen()
    {
        for (int spalte = 0; spalte < laufsteg.SpaltenanzahlGeben()
                - 1; spalte = spalte + 1)
        {
            laufsteg.FarbeSetzen(spalte, laufsteg.FarbeGeben(spalte + 1));
        }
        laufsteg.FarbeSetzen(laufsteg.SpaltenanzahlGeben() - 1,
                NächsteFarbeGeben());
    }

    /**
     * Bestimmt die nächste Farbe
     *
     * @return nächste Farbe
     */
    String NächsteFarbeGeben()
    {
        String farbe;
        if (zähler == 0)
        {
            farbe = "weiß";
        }
        else
        {
            if (zähler == 1)
            {
                farbe = "rot";
            }
            else
            {
                if (zähler == 2)
                {
                    farbe = "grün";
                }
                else
                {
                    if (zähler == 3)
                    {
                        farbe = "blau";
                    }
                    else
                    {
                        if (zähler == 4)
                        {
                            farbe = "gelb";
                        }
                        else
                        {
                            if (zähler == 5)
                            {
                                farbe = "magenta";
                            }
                            else
                            {
                                if (zähler == 6)
                                {
                                    farbe = "cyan";
                                }
                                else
                                {
                                    if (zähler == 7)
                                    {
                                        farbe = "hellgelb";
                                    }
                                    else
                                    {
                                        if (zähler == 8)
                                        {
                                            farbe = "hellgrün";
                                        }
                                        else
                                        {
                                            if (zähler == 9)
                                            {
                                                farbe = "orange";
                                            }
                                            else
                                            {
                                                if (zähler == 10)
                                                {
                                                    farbe = "braun";
                                                }
                                                else
                                                {
                                                    if (zähler == 11)
                                                    {
                                                        farbe = "grau";
                                                    }
                                                    else
                                                    {
                                                        farbe = "schwarz";
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zähler = (zähler + 1) % 12;
        return farbe;
    }
}
