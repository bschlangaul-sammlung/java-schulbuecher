package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_07.aufgabe_05;

/**
 * Verwaltet die Netzwerkverbindung und die ankommenden Anrufe.
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
import java.net.*;

class NetzwerkServer
{
    EndeMarkierung ende;

    ServerAutomat automat;

    /**
     * Belegt die Attribute.
     */
    NetzwerkServer()
    {
        ende = new EndeMarkierung();
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
                automat = new ServerAutomat(new Verbindung(anruf), ende);
                automat.start();
            }
            while (!ende.MussBeenden());
            server.close();
        }
        catch (Exception e)
        {
            System.out.println("Allgemeiner Fehler: " + e);
            e.printStackTrace();
        }
    }
}
