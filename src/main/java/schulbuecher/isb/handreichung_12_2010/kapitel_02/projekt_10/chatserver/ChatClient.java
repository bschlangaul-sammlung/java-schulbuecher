package schulbuecher.isb.handreichung_12_2010.kapitel_02.projekt_10.chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Clientimplementierung mit Möglichkeit zum Beenden der Clientverbindung<br/>
 *
 * @author ISB-Arbeitskreis, Umsetzungshilfen Informatik 12
 *
 * @version 1.0
 */
public class ChatClient
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
     * Konstruktor der Klasse CHATCLIENT<br/>
     * empfängt alle Serverbotschaften und gibt diese auf der Konsole aus.
     *
     * @exception IOException eine Ausnahme tritt möglicherweise auf falls:<br/>
     *     - die Clientverbindung nicht hergestellt werden konnte
     *     (beispielsweise bei falscher IP-Adresse oder falschem Port)<br/>
     *     - die Verbindung zum Server gestört bzw. unterbrochen wurde.
     */
    public ChatClient(String[] args) throws IOException
    {
        String serverBotschaft;
        VerbindungHerstellen();
        serverBotschaft = vomServer.readLine();
        System.out.println(serverBotschaft);
        // falls die maximale Anzahl von Clients erreicht ist, wird hier beendet
        if (serverBotschaft.startsWith("Server[stopClient]:"))
        {
            ServerVerbindungBeenden();
            System.exit(0);
        }
        // der Clientsender liest die Tastatureingaben und sendet diese an den
        // Server
        new ClientSender(zumServer, tastatur).start();
        while ((serverBotschaft = vomServer.readLine()) != null)
        {
            // Serverbotschaft ausgeben.
            System.out.println(serverBotschaft);
            // Server[stopClient]: zu Beginn der Botschaft beendet den Client.
            if (serverBotschaft.startsWith("Server[stopClient]:"))
            {
                break;
            }
        }
        ServerVerbindungBeenden();
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
        System.out.println("IP-Adresse eingeben:");
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
    private void ServerVerbindungBeenden() throws IOException
    {
        vomServer.close();
        clientSocket.close();
    }

    /**
     * Hauptprogramm zum Erzeugen eines Clientobjekts
     *
     * @param args keine Parameter beim Programmaufruf erforderlich
     */
    public static void main(String[] args) throws IOException
    {
        new ChatClient(args);
    }
}
