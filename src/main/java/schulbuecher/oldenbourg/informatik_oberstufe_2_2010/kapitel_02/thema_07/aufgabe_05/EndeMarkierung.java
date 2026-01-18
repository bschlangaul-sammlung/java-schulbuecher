package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_05;

/**
 * Kommuniziert die Endebedingung vom Arbeitsthread zum Rahmenprogramm.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class EndeMarkierung
{
    private boolean istEnde;

    /**
     * Setzt die Endebedingung auf falsch.
     */
    EndeMarkierung()
    {
        istEnde = false;
    }

    /**
     * Setzt die Endebedingung auf wahr.
     */
    void BeendenSetzen()
    {
        istEnde = true;
    }

    /**
     * Testet die Endebedingung.
     */
    boolean MussBeenden()
    {
        return istEnde;
    }
}
