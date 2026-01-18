package schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_01.wie_gehts;

import java.io.IOException;

import schulbuecher.isb.handreichung_12_2010.kapitel_02.ErsterClient;

public class Client extends ErsterClient
{
    public Client() throws IOException
    {
        super();
    }

    /**
     * Hauptprogramm zum Erzeugen eines Clientobjekts
     *
     * @param args keine Parameter beim Programmaufruf erforderlich
     */
    public static void main(String[] args)
    {
        try
        {
            new Client();
        }
        catch (Exception e)
        {
            System.out.println("Fehler im Clientprogramm.");
            System.exit(1);
        }
    }
}
