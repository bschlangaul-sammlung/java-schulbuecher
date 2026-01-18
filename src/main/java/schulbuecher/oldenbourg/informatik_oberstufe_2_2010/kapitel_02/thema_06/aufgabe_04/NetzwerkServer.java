package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_06.aufgabe_04;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Verwaltet die Netzwerkverbindung und die ankommenden Anrufe.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class NetzwerkServer
{
    boolean ende;

    ServerAutomat automat;

    /**
     * Belegt die Attribute.
     */
    NetzwerkServer()
    {
        ende = false;
        automat = null;
    }

    /**
     * Führt die eingentliche Arbeit aus.
     */
    void Arbeiten()
    {
        try
        {
            ServerSocket server = new ServerSocket(54000);
            do
            {
                Socket anruf = server.accept();
                System.out.println("Neuer Anruf von " + anruf + " auf Port: "
                        + anruf.getLocalPort());
                automat = new ServerAutomat(new Verbindung(anruf));
                ende = automat.Uebertragen();
                anruf.close();
            }
            while (!ende);
            server.close();
        }
        catch (Exception e)
        {
            System.out.println("Allgemeiner Fehler: " + e);
            e.printStackTrace();
        }
    }
}
