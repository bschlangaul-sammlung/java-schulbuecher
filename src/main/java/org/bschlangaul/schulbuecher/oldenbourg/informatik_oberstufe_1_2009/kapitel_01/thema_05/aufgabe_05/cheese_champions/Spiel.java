package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_05.aufgabe_05.cheese_champions;

/**
 * Klasse zur Verwaltung eines Experiments
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Spiel
{
    /**
     * Stapel, von dem die Mäuse losgelaufen sind
     */
    private Stapel ursprungsstapel;

    /**
     * Stapel, an dem die Mäuse angekommen sind
     */
    private Stapel zielstapel;

    /**
     * Stapel für die Mäuse in der Sackgasse
     */
    private Stapel sackgassenstapel;

    /**
     * Spiel beendet oder nicht
     */
    private boolean beendet;

    /**
     * Erzeugt drei Stapel und setzt beendet auf false.
     */
    Spiel()
    {
        ursprungsstapel = new Stapel();
        zielstapel = new Stapel();
        sackgassenstapel = new Stapel();
        beendet = false;
    }

    /**
     * Fügt eine neue Maus auf dem Zielstapel ein
     *
     * @param m einzufügende Maus
     */
    void Einfuegen(Maus m)
    {
        zielstapel.VorneEinfuegen(m);
    }

    /**
     * Die passende Maus wird bewegt.
     */
    void Schritt()
    {
        if ((zielstapel.LaengeGeben() != 0)
                && (sackgassenstapel.LaengeGeben() != 0))
        {
            Maus mausZiel = (Maus) zielstapel.AnfangEntfernen();
            Maus mausSackgasse = (Maus) sackgassenstapel.AnfangEntfernen();
            if (mausZiel.IstKleinerAls(mausSackgasse))
            {
                zielstapel.VorneEinfuegen(mausZiel);
                ursprungsstapel.VorneEinfuegen(mausSackgasse);
                if (sackgassenstapel.LaengeGeben() != 0)
                {
                    mausSackgasse.SiegeszahlErhoehen();
                    mausSackgasse = (Maus) sackgassenstapel.AnfangEntfernen();
                    mausSackgasse.NiederlagenzahlErhoehen();
                    sackgassenstapel.VorneEinfuegen(mausSackgasse);
                }
            }
            else
            {
                sackgassenstapel.VorneEinfuegen(mausSackgasse);
                sackgassenstapel.VorneEinfuegen(mausZiel);
                if (ursprungsstapel.LaengeGeben() != 0)
                {
                    mausZiel.SiegeszahlErhoehen();
                    Maus mausUrsprung = (Maus) ursprungsstapel
                            .AnfangEntfernen();
                    mausUrsprung.NiederlagenzahlErhoehen();
                    ursprungsstapel.VorneEinfuegen(mausUrsprung);
                }
            }
        }
        else
        {
            if ((zielstapel.LaengeGeben() != 0)
                    && (sackgassenstapel.LaengeGeben() == 0))
            {
                Maus mausZiel = (Maus) zielstapel.AnfangEntfernen();
                sackgassenstapel.VorneEinfuegen(mausZiel);
                if (ursprungsstapel.LaengeGeben() != 0)
                {
                    mausZiel.SiegeszahlErhoehen();
                    Maus mausUrsprung = (Maus) ursprungsstapel
                            .AnfangEntfernen();
                    mausUrsprung.NiederlagenzahlErhoehen();
                    ursprungsstapel.VorneEinfuegen(mausUrsprung);
                }
            }
            else
            {
                if (sackgassenstapel.LaengeGeben() != 0)
                {
                    Maus mausSackgasse = (Maus) sackgassenstapel
                            .AnfangEntfernen();
                    ursprungsstapel.VorneEinfuegen(mausSackgasse);
                    if (sackgassenstapel.LaengeGeben() != 0)
                    {
                        mausSackgasse.SiegeszahlErhoehen();
                        mausSackgasse = (Maus) sackgassenstapel
                                .AnfangEntfernen();
                        mausSackgasse.NiederlagenzahlErhoehen();
                        sackgassenstapel.VorneEinfuegen(mausSackgasse);
                    }
                }
            }
        }
        if ((zielstapel.LaengeGeben() == 0)
                && (sackgassenstapel.LaengeGeben() == 0))
        {
            beendet = true;
        }
    }

    /*
     * Gibt einen gesuchten Stapel als String aus
     * @param s gesuchter Stapel
     */
    String StapelAusgeben(char s)
    {
        String stapel;
        stapel = "";
        if (s == 'z')
        {
            stapel = zielstapel.InformationAusgeben();
        }
        if (s == 'u')
        {
            stapel = ursprungsstapel.InformationAusgeben();
        }
        if (s == 's')
        {
            stapel = sackgassenstapel.InformationAusgeben();
        }
        return stapel;
    }

    /**
     * Prüft, ob der Ursprungsstapel sortiert ist und gibt das Ergebnis aus. Ein
     * unsortierter Stapel sagt aus, dass es sich um keine gültige
     * Eingangsreihenfolge handelt.
     */
    boolean UrsprungsstapelSortiert()
    {
        Maus oben;
        Maus unten;
        if (ursprungsstapel.LaengeGeben() > 1)
        {
            oben = (Maus) ursprungsstapel.AnfangEntfernen();
            unten = (Maus) ursprungsstapel.AnfangEntfernen();
            if (unten.IstKleinerAls(oben))
            {
                return false;
            }
            else
            {
                ursprungsstapel.VorneEinfuegen(unten);
                return UrsprungsstapelSortiert();
            }
        }
        else
        {
            return true;
        }
    }

    /**
     * Gibt aus, ob das Spiel beendet ist.
     */
    boolean BeendetGeben()
    {
        return beendet;
    }
}
