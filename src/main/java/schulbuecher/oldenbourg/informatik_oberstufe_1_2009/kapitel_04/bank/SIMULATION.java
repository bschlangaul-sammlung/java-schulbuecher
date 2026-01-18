package schulbuecher.oldenbourg.informatik_oberstufe_1_2009.kapitel_04.bank;

/**
 * Baut die Simulation auf.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class SIMULATION
{
    /**
     * Legt die zentralen Objekte an und verknüpft sie.
     */
    private SIMULATION()
    {
        KONTROLLEUR k;
        OBERFLAECHE o;
        k = new KONTROLLEUR(BANK.BankGeben());
        o = new OBERFLAECHE(k);
        BANK.BankGeben().DatenbankverbindungGeben().Registrieren(o);
    }

    public static void main(String[] args)
    {
        new SIMULATION();
    }
}
