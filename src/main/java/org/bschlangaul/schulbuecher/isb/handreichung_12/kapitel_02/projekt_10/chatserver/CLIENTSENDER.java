package org.bschlangaul.schulbuecher.isb.handreichung_12.kapitel_02.projekt_10.chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Der Clientsender liest alle Tastatureingaben auf der Clientseite und schickt
 * diese zum Chatserver.
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
class CLIENTSENDER extends Thread
{
    /** Referenz auf das Leseobjekt für die Tastatur */
    BufferedReader tastatur = null;

    /** Schreibkanal zum Server */
    PrintWriter zumServer = null;

    /**
     * Konstruktor
     *
     * @param zumServer Schreibkanal zum Server
     * @param tastatur Lesekanal von der Tastatur
     */
    public CLIENTSENDER(PrintWriter zumServer, BufferedReader tastatur)
    {
        this.tastatur = tastatur;
        this.zumServer = zumServer;
    }

    /**
     * liest die Tastatureingaben und schickt diese zum Server falls die Eingabe
     * gleich "beenden" ist, wird der Thread beendet.<br/>
     * Die Serverantwort führt dazu, dass auch der Chatclient beendet wird.
     */
    @Override
    public void run()
    {
        String clientEingabe;
        try
        {
            while ((clientEingabe = tastatur.readLine()) != null)
            {
                zumServer.println(clientEingabe);
                if (clientEingabe.equals("beenden"))
                {
                    System.out.println("beenden");
                    break;
                }
            }
            tastatur.close();
        }
        catch (IOException e)
        {
            System.out.println("Fehler im Clientsender");
        }
    }
}
