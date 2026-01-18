package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_02.tiere_1;

/**
 * Klasse Biene <br>
 *
 * Kap. 7.2 Arbeitsauftrag 1 und 3
 */
class Biene extends Tier
{
    Biene()
    {
        art = "Biene";
        futter = "Nektar";
    }

    // A3 d)
    void bewegeNachRechts()
    {
        setLocation(getX() + 1, getY());
    }
}
