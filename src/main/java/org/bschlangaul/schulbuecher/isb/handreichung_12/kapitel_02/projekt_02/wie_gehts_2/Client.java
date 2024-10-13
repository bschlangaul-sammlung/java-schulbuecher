package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_02.wie_gehts_2;

import java.io.IOException;
import org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.ErsterClient;

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
