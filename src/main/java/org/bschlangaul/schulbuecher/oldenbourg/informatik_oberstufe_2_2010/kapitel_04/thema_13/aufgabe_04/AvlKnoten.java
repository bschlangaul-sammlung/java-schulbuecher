package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_04.thema_13.aufgabe_04;

/**
 * Die Klasse beschreibt einen AVL-Knoten. Beim Einfügen eines neuen Knotens
 * wird auf die Ausgeglichenheit des Baumes geachtet.
 *
 * @author Klaus Reinold
 *
 * @version 1.0
 */
class AvlKnoten
{
    /** Referenz auf das verwaltete Datenelement */
    private DatenElement daten;

    /** Balance des Knotens (mögliche Werte -2, -1, 0, 1, +2) */
    private byte balance;

    /** linker Nachfolger */
    private AvlKnoten linkerNachfolger;

    /** rechter Nachfolger */
    private AvlKnoten rechterNachfolger;

    /**
     * Konstruktor Erzeugt einen neuen AVL-Knoten und setzt die Referenz auf das
     * übergebene Datenelement.
     *
     * @param d zu verwaltendes Datenelement
     */
    public AvlKnoten(DatenElement d)
    {
        daten = d;
        balance = 0;
        linkerNachfolger = rechterNachfolger = null;
    }

    /**
     * Ermöglicht die Suche nach einem Schlüsselwert vom Typ int. Untersucht
     * zuerst das verwaltete Datenelement, dann rekursiv den linken und rechten
     * Nachfolger.
     *
     * @param vergleichswert gesuchter Wert
     *
     * @return gesuchtes Datenelement
     */
    public DatenElement Suchen(int vergleichswert)
    {
        Zaehler.ZaehlerInkrementieren();
        if (daten.SchluesselIstGleich(vergleichswert))// Prüfung der Bedingung
                                                      // und Methodenaufruf
                                                      // werden als zwei
                                                      // Schritte gewertet
        {
            Zaehler.ZaehlerInkrementieren();
            return daten;
        }
        else
            Zaehler.ZaehlerInkrementieren();
        if (daten.SchluesselIstGroesser(vergleichswert))// Prüfung der Bedingung
                                                        // und Methodenaufruf
                                                        // werden als zwei
                                                        // Schritte gewertet
        {
            Zaehler.ZaehlerInkrementieren();
            if (linkerNachfolger != null)
            {
                Zaehler.ZaehlerInkrementieren();
                return linkerNachfolger.Suchen(vergleichswert);
            }
            else
            {
                Zaehler.ZaehlerInkrementieren();
                return null;
            }
        }
        else
        {
            Zaehler.ZaehlerInkrementieren();
            if (rechterNachfolger != null)
            {
                Zaehler.ZaehlerInkrementieren();
                return rechterNachfolger.Suchen(vergleichswert);
            }
            else
            {
                Zaehler.ZaehlerInkrementieren();
                return null;
            }
        }
    }

    /**
     * Gibt das verwaltete Datenelement zurück
     *
     * @return verwaltetes Datenelement
     */
    private DatenElement DatenelementGeben()
    {
        return daten;
    }

    /**
     * Setzt die Referenz des verwalteten Datenelements auf den übergebenen
     * Wert.
     *
     * @param d neues Datenelement
     */
    public void DatenelementSetzen(DatenElement d)
    {
        daten = d;
    }

    /**
     * Gibt den linken Nachfolgeknoten zurück
     *
     * @return linker Nachfolgeknoten
     */
    private AvlKnoten LinkenNachfolgerGeben()
    {
        return linkerNachfolger;
    }

    /**
     * Setzt den linken Nachfolgeknoten auf den übergebenen Wert
     *
     * @param k neuer linker Nachfolger
     */
    private void LinkenNachfolgerSetzen(AvlKnoten k)
    {
        linkerNachfolger = k;
    }

    /**
     * Gibt den rechten Nachfolgeknoten zurück
     *
     * @return rechter Nachfolgeknoten
     */
    private AvlKnoten RechtenNachfolgerGeben()
    {
        return rechterNachfolger;
    }

    /**
     * Setzt den rechten Nachfolgeknoten auf den übergebenen Wert
     *
     * @param k neuer rechter Nachfolger
     */
    private void RechtenNachfolgerSetzen(AvlKnoten k)
    {
        rechterNachfolger = k;
    }

    /**
     * Gibt die Balance des Knoten zurück
     *
     * @return Balance
     */
    private byte BalanceGeben()
    {
        return balance;
    }

    /**
     * Setzt die Balance des Knoten auf den übergebenen Wert
     *
     * @param b neue Balance
     */
    private void BalanceSetzen(byte b)
    {
        balance = b;
    }

    /**
     * Fügt ein neues Datenelement in den Baum ein, falls der Schlüsselwert noch
     * nicht enthalten ist.
     *
     * @param d einzufügendes Datenelement
     *
     * @return liefert zurück, ob der Teilbaum unterhalb des Knotens gewachsen
     *     ist
     */
    public boolean Einfuegen(DatenElement d)
    {
        boolean gewachsen = true;
        if (daten.SchluesselIstGleich(d.SchluesselGeben()))
        {
            gewachsen = false;
        }
        else
        {
            if (daten.SchluesselIstGroesser(d.SchluesselGeben()))
            {
                if (linkerNachfolger == null)
                {
                    linkerNachfolger = new AvlKnoten(d);
                    balance = (byte) (balance - 1);
                    if (rechterNachfolger != null)
                    {
                        gewachsen = false;
                    }
                }
                else
                {
                    gewachsen = linkerNachfolger.Einfuegen(d);
                    if (gewachsen)
                    {
                        balance = (byte) (balance - 1);
                    }
                }
            }
            else
            {
                if (rechterNachfolger == null)
                {
                    rechterNachfolger = new AvlKnoten(d);
                    balance = (byte) (balance + 1);// irgendwas noch mit
                                                   // gewachsen???
                    if (linkerNachfolger != null)
                    {
                        gewachsen = false;
                    }
                }
                else
                {
                    gewachsen = rechterNachfolger.Einfuegen(d);
                    if (gewachsen)
                    {
                        balance = (byte) (balance + 1);
                    }
                }
            }
        }
        switch (balance)
        {
        case -2:
            if (linkerNachfolger.BalanceGeben() == 1)
            {
                linkerNachfolger.RotierenLinks();
            }
            RotierenRechts();
            gewachsen = false;
            break;

        case -1:
            break;

        case 0:
            gewachsen = false;
            break;

        case 1:
            break;

        case 2:
            if (rechterNachfolger.BalanceGeben() == -1)
            {
                rechterNachfolger.RotierenRechts();
            }
            RotierenLinks();
            gewachsen = false;
            break;
        }
        return gewachsen;
    }

    /**
     * Sorgt für die Rotation nach rechts um den Knoten herum
     */
    private void RotierenRechts()
    {
        AvlKnoten m = linkerNachfolger;
        DatenElement speicher = daten;
        daten = linkerNachfolger.DatenelementGeben();
        linkerNachfolger.DatenelementSetzen(speicher);
        linkerNachfolger = linkerNachfolger.LinkenNachfolgerGeben();
        m.LinkenNachfolgerSetzen(m.RechtenNachfolgerGeben());
        m.RechtenNachfolgerSetzen(rechterNachfolger);
        rechterNachfolger = m;
        int bm = 1 + Math.max(-m.BalanceGeben(), 0) + balance;
        int bk = 1 + m.BalanceGeben() + Math.max(0, bm);
        balance = (byte) bk;
        m.BalanceSetzen((byte) bm);
    }

    /**
     * Sorgt für die Rotation nach links um den Knoten herum
     */
    private void RotierenLinks()
    {
        AvlKnoten m = rechterNachfolger;
        DatenElement speicher = daten;
        daten = rechterNachfolger.DatenelementGeben();
        rechterNachfolger.DatenelementSetzen(speicher);
        rechterNachfolger = rechterNachfolger.RechtenNachfolgerGeben();
        m.RechtenNachfolgerSetzen(m.LinkenNachfolgerGeben());
        m.LinkenNachfolgerSetzen(linkerNachfolger);
        linkerNachfolger = m;
        int bm = -(1 + Math.max(m.BalanceGeben(), 0) - balance);
        int bk = -(1 - m.BalanceGeben() + Math.max(0, -bm));
        balance = (byte) bk;
        m.BalanceSetzen((byte) bm);
    }
}
