package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_01.thema_01.aufgabe_04.teilaufgabe_b.supermarkt;

import java.util.Random;

/**
 * Kontrolle des Supermarkts.
 *
 * @author Klaus Reinold und Barbara Leidorn
 *
 * @version 1.0
 */
class Supermarkt implements TaktKlient
{
    private Kasse[] kassen;

    private Warteschlange[] schlangen;

    private int wartezeit;

    @SuppressWarnings("unused")
    private int mittlereWartezeit;

    private Random zzgenerator;

    /**
     * Legt die Kassen und ihre Warteschlangen an.
     */
    Supermarkt()
    {
        schlangen = new Warteschlange[3];
        kassen = new Kasse[schlangen.length];
        for (int i = 0; i < kassen.length; i++)
        {
            schlangen[i] = new Warteschlange();
            schlangen[i].KassennummerSetzen(i + 1);
            kassen[i] = new Kasse(i + 1, schlangen[i]);
        }
        wartezeit = 0;
        zzgenerator = new Random();
    }

    /**
     * Erzeugt einen neuen Kunden und lässt ihn anstellen.
     */
    private void KundeErzeugen()
    {
        int zufallszahl;
        Kunde k;
        zufallszahl = zzgenerator.nextInt(20) + 1;
        switch (zzgenerator.nextInt(4))
        {
        case 0:
            k = new KundeWenig(zufallszahl);
            break;

        case 1:
            k = new KundeKurz(zufallszahl);
            break;

        case 2:
            k = new KundeZufall(zufallszahl);
            break;

        case 3:
            k = new KundeZufall2(zufallszahl);
            break;

        default:
            k = null;
            break;
        }
        k.Anstellen(schlangen);
    }

    /**
     * Erzeugt nach Ablauf der Wartezeit den nächsten Kunden. Gibt den
     * Taktimpuls an die Kassen weiter.
     */
    public void TaktImpulsAusfuehren()
    {
        if (wartezeit == 0)
        {
            KundeErzeugen();
            int zufallszahl1;
            int zufallszahl2;
            zufallszahl1 = zzgenerator.nextInt(2);
            zufallszahl2 = zzgenerator.nextInt(61);
            if (zufallszahl1 == 0)
            {
                wartezeit = 70 - zufallszahl2;
            }
            else
            {
                wartezeit = 70 + zufallszahl2;
            }
        }
        else
        {
            wartezeit = wartezeit - 1;
        }
        for (int i = 0; i < kassen.length; i++)
        {
            kassen[i].TaktImpulsAusfuehren();
        }
    }

    /**
     * Schließt eine Kasse.
     *
     * @param i Kassennummer von 0 bis n - 1
     */
    void KasseSchliessen(int i)
    {
        kassen[i].SchliessendSetzen();
    }

    /**
     * öffnet eine Kasse.
     *
     * @param i Kassennummer von 0 bis n - 1
     */
    void KasseOeffnen(int i)
    {
        kassen[i].OffenSetzen();
    }

    /**
     * Setzt die mittlere Wartezeit zwischen 2 Kunden
     *
     * @param zeit mittlere Wartezeit
     */
    public void KundenabstandSetzen(int zeit)
    {
        mittlereWartezeit = zeit;
    }
}
