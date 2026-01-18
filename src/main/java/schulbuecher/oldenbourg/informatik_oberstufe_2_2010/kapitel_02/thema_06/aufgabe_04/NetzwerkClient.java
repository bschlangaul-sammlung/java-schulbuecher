package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_06.aufgabe_04;

import java.net.Socket;

/**
 * Baut die Verbindung um Server auf.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class NetzwerkClient
{
    private Socket socket;

    /**
     * Belegt die Attribute
     */
    NetzwerkClient()
    {
        socket = null;
    }

    /**
     * Baut die Verbindung auf.
     *
     * @param name Hostname
     *
     * @return Verbindungsobjekt oder null
     */
    Verbindung Oeffnen(String name)
    {
        try
        {
            socket = new Socket(name, 54000);
            return new Verbindung(socket);
        }
        catch (Exception e)
        {
            System.out.println("Fehler beim Verbindungsaufbau: " + e);
            return null;
        }
    }

    /**
     * Schließt die Verbindung
     */
    void Schliessen()
    {
        try
        {
            socket.close();
        }
        catch (Exception e)
        {
            System.out.println("Fehler beim Verbindungsaufbau: " + e);
        }
    }
}
