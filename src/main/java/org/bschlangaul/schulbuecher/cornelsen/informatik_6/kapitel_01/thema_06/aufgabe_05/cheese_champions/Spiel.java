package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_06.aufgabe_05.cheese_champions;

/**
 * Klasse zur Verwaltung eines Experiments
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class Spiel
{
    /** Stapel, von dem die Mäuse losgelaufen sind */
    private Stapel ursprungsstapel;

    /** Stapel, an dem die Mäuse angekommen sind */
    private Stapel zielstapel;

    /** Stapel für die Mäuse in der Sackgasse */
    private Stapel sackgassenstapel;

    /** Spiel beendet oder nicht */
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
    void Einfügen(Maus m)
    {
        zielstapel.Einfügen(m);
    }

    /**
     * Die passende Maus wird bewegt.
     */
    void Schritt()
    {
        if ((zielstapel.LängeGeben() != 0)
                && (sackgassenstapel.LängeGeben() != 0))
        {
            Maus mausZiel = (Maus) zielstapel.Entfernen();
            Maus mausSackgasse = (Maus) sackgassenstapel.Entfernen();
            if (mausZiel.IstKleinerAls(mausSackgasse))
            {
                zielstapel.Einfügen(mausZiel);
                ursprungsstapel.Einfügen(mausSackgasse);
                if (sackgassenstapel.LängeGeben() != 0)
                {
                    mausSackgasse.SiegeszahlErhöhen();
                    mausSackgasse = (Maus) sackgassenstapel.Entfernen();
                    mausSackgasse.NiederlagenzahlErhöhen();
                    sackgassenstapel.Einfügen(mausSackgasse);
                }
            }
            else
            {
                sackgassenstapel.Einfügen(mausSackgasse);
                sackgassenstapel.Einfügen(mausZiel);
                if (ursprungsstapel.LängeGeben() != 0)
                {
                    mausZiel.SiegeszahlErhöhen();
                    Maus mausUrsprung = (Maus) ursprungsstapel.Entfernen();
                    mausUrsprung.NiederlagenzahlErhöhen();
                    ursprungsstapel.Einfügen(mausUrsprung);
                }
            }
        }
        else
        {
            if ((zielstapel.LängeGeben() != 0)
                    && (sackgassenstapel.LängeGeben() == 0))
            {
                Maus mausZiel = (Maus) zielstapel.Entfernen();
                sackgassenstapel.Einfügen(mausZiel);
                if (ursprungsstapel.LängeGeben() != 0)
                {
                    mausZiel.SiegeszahlErhöhen();
                    Maus mausUrsprung = (Maus) ursprungsstapel.Entfernen();
                    mausUrsprung.NiederlagenzahlErhöhen();
                    ursprungsstapel.Einfügen(mausUrsprung);
                }
            }
            else
            {
                if (sackgassenstapel.LängeGeben() != 0)
                {
                    Maus mausSackgasse = (Maus) sackgassenstapel.Entfernen();
                    ursprungsstapel.Einfügen(mausSackgasse);
                    if (sackgassenstapel.LängeGeben() != 0)
                    {
                        mausSackgasse.SiegeszahlErhöhen();
                        mausSackgasse = (Maus) sackgassenstapel.Entfernen();
                        mausSackgasse.NiederlagenzahlErhöhen();
                        sackgassenstapel.Einfügen(mausSackgasse);
                    }
                }
            }
        }
        if ((zielstapel.LängeGeben() == 0)
                && (sackgassenstapel.LängeGeben() == 0))
        {
            beendet = true;
        }
    }

    /**
     * Gibt einen gesuchten Stapel als String aus
     *
     * @param s gesuchter Stapel
     *
     * @return Information üvber den Stapel
     */
    String StapelAusgeben(char s)
    {
        String stapel;
        stapel = "";
        if (s == 'z')
        {
            stapel = zielstapel.InformationGeben();
        }
        if (s == 'u')
        {
            stapel = ursprungsstapel.InformationGeben();
        }
        if (s == 's')
        {
            stapel = sackgassenstapel.InformationGeben();
        }
        return stapel;
    }

    /**
     * Prüft, ob der Ursprungsstapel sortiert ist und gibt das Ergebnis aus. Ein
     * unsortierter Stapel sagt aus, dass es sich um keine gültige
     * Eingangsreihenfolge handelt.
     *
     * @return wahr, wenn der Stapel sortiert ist
     */
    boolean IstUrsprungsstapelSortiert()
    {
        Maus oben;
        Maus unten;
        if (ursprungsstapel.LängeGeben() > 1)
        {
            oben = (Maus) ursprungsstapel.Entfernen();
            unten = (Maus) ursprungsstapel.Entfernen();
            if (unten.IstKleinerAls(oben))
            {
                return false;
            }
            else
            {
                ursprungsstapel.Einfügen(unten);
                return IstUrsprungsstapelSortiert();
            }
        }
        else
        {
            return true;
        }
    }

    /**
     * Gibt aus, ob das Spiel beendet ist.
     *
     * @return wahr, wenn das Spiel beendet ist
     */
    boolean BeendetGeben()
    {
        return beendet;
    }
}
