package org.bschlangaul.schulbuecher.isb.handreichung_12_2010.kapitel_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Erste Clientimplementierung des Projekts wie gehts?
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class ErsterClient
{
    /**
     * bidirektionale Schnittstelle zur Netzwerkprotokoll-Implementierung
     */
    private Socket clientSocket = null;

    /**
     * Datenstrom zum Server
     */
    private PrintWriter zumServer = null;

    /**
     * Datenstrom vom Server
     */
    private BufferedReader vomServer = null;

    /**
     * Datenstrom von der Tastatur
     */
    private BufferedReader tastatur = null;

    /**
     * Botschaft vom Server
     */
    private String serverBotschaft;

    /**
     * Eingabe von Client an Server
     */
    private String clientEingabe;

    /**
     * Konstruktor
     *
     * @exception IOException eine Ausnahme tritt möglicherweise auf falls:<br/>
     *     - die Clientverbindung nicht hergestellt werden konnte
     *     (beispielsweise bei falscher IP-Adresse oder falschem Port)<br/>
     *     - die Verbindung zum Server gestört bzw. unterbrochen wurde.
     */
    public ErsterClient() throws IOException
    {
        VerbindungHerstellen();
        // Tastatureingabe, Senden und Empfangen
        while (((serverBotschaft = vomServer.readLine()) != null)
                && (!serverBotschaft.equals("Auf Wiedersehen!")))
        {
            // Serverbotschaft anzeigen.
            System.out.println("Server: " + serverBotschaft);
            // Eingabe vom Client lesen
            clientEingabe = tastatur.readLine();
            // auf die Clientkonsole ausgeben
            System.out.println("Client: " + clientEingabe);
            // und zum Server schicken
            zumServer.println(clientEingabe);
        }
        VerbindungBeenden();
    }

    /**
     * stellt die Serververbindung her und erzeugt die nötigen Lese- und
     * Schreibojekte
     *
     * @exception IOException tritt auf, falls die Verbindung nicht korrekt
     *     erstellt werden kann.
     */
    private void VerbindungHerstellen() throws IOException
    {
        // Ipadresse und Port ermitteln
        tastatur = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("IP-Adresse des Servers eingeben:");
        String ipadresse = tastatur.readLine();
        System.out.println("Port eingeben:");
        int port = Integer.parseInt(tastatur.readLine());
        // Verbindung herstellen
        clientSocket = new Socket(ipadresse, port);
        zumServer = new PrintWriter(clientSocket.getOutputStream(), true);
        vomServer = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
    }

    /**
     * beendet alle Lese- und Schreibkanäle und die Verbindung zum Server
     *
     * @exception IOException tritt auf, falls eine Verbindung oder ein Stream
     *     nicht beendet werden kann.
     */
    private void VerbindungBeenden() throws IOException
    {
        zumServer.close();
        vomServer.close();
        tastatur.close();
        clientSocket.close();
    }
}
