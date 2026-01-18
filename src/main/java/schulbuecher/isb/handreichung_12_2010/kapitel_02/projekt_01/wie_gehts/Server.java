package schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_01.wie_gehts;

import java.io.IOException;

import schulbuecher.isb.handreichung_12_2010.kapitel_02.ErsterServer;
import schulbuecher.isb.handreichung_12_2010.kapitel_02.ServerVerhalten;

public class Server extends ErsterServer
{
    public Server(ServerVerhalten serverVerhalten) throws IOException
    {
        super(serverVerhalten);
    }

    /**
     * Hauptprogramm zum Erzeugen des Serverobjekts
     *
     * @param args keine Parameter beim Programmaufruf erforderlich
     */
    public static void main(String[] args)
    {
        try
        {
            new Server(new WieGehtsServerVerhalten());
        }
        catch (Exception e)
        {
            System.err.println("Fehler in der Serververabeitung.");
            System.exit(1);
        }
    }
}
