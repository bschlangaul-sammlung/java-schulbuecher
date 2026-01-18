package schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_06.aufgabe_03c;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Einfacher Server, der alle Zeichen spiegelt.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Server
{
    /**
     * Führt die eigentliche Arbeit aus.
     */
    void Arbeiten()
    {
        byte[] abmelden, beenden;
        int laengeAbmelden, laengeBeenden;
        boolean abmeldenEmpfangen, beendenEmpfangen;
        abmelden = new byte[8];
        beenden = new byte[7];
        beendenEmpfangen = false;
        try
        {
            ServerSocket server = new ServerSocket(54000);
            do
            {
                Socket anruf = server.accept();
                InputStream in = anruf.getInputStream();
                OutputStream out = anruf.getOutputStream();
                abmeldenEmpfangen = false;
                laengeAbmelden = 0;
                laengeBeenden = 0;
                do
                {
                    int zeichen = in.read();
                    if (zeichen < 0)
                    {
                        abmeldenEmpfangen = true;
                    }
                    else
                    {
                        out.write(zeichen);
                        if (laengeAbmelden < abmelden.length)
                        {
                            abmelden[laengeAbmelden] = (byte) zeichen;
                            laengeAbmelden += 1;
                        }
                        else
                        {
                            for (int i = 1; i < abmelden.length; i++)
                            {
                                abmelden[i - 1] = abmelden[i];
                            }
                            abmelden[abmelden.length - 1] = (byte) zeichen;
                        }
                        if (laengeBeenden < beenden.length)
                        {
                            beenden[laengeBeenden] = (byte) zeichen;
                            laengeBeenden += 1;
                        }
                        else
                        {
                            for (int i = 1; i < beenden.length; i++)
                            {
                                beenden[i - 1] = beenden[i];
                            }
                            beenden[beenden.length - 1] = (byte) zeichen;
                        }
                        if ("ABMELDEN".equals(new String(abmelden)))
                        {
                            abmeldenEmpfangen = true;
                        }
                        else if ("BEENDEN".equals(new String(beenden)))
                        {
                            beendenEmpfangen = true;
                        }
                    }
                }
                while ((!abmeldenEmpfangen) && (!beendenEmpfangen));
                anruf.close();
            }
            while (!beendenEmpfangen);
            server.close();
            System.exit(0);
        }
        catch (Exception e)
        {
            System.out.println("Allgemeiner Fehler: " + e);
            e.printStackTrace();
        }
    }

    /**
     * Startmethode, um Server als Programm betreiben zu können.
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args)
    {
        new Server().Arbeiten();
    }
}
