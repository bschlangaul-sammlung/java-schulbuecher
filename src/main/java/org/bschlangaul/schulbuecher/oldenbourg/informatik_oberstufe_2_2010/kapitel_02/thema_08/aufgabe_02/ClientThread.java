package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_08.aufgabe_02;

import java.io.*;
import java.net.*;

/**
 * Bearbeitet einen speziellen Anrufer
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class ClientThread extends Thread
{
    /** Das Verbindungsobjekt */
    private Socket socket;

    /** Serverobjekt */
    private Server server;

    /** Ausgabeobjekt */
    private OutputStream out;

    /** Zeichenpuffer */
    private int[] puffer;

    /** Anzahl der Zeichen im Puffer */
    private int pufferStand;

    /**
     * Constructor for objects of class CLIENTTHREAD
     */
    ClientThread(Socket socket, Server server)
    {
        this.socket = socket;
        this.server = server;
        puffer = new int[255];
        pufferStand = 0;
    }

    /**
     * Liest die Zeilen und gibt sie an alle aus.
     */
    public void run()
    {
        InputStream in;
        byte[] abmelden, beenden;
        int laengeAbmelden, laengeBeenden;
        boolean abmeldenEmpfangen, beendenEmpfangen;
        abmelden = new byte[8];
        beenden = new byte[7];
        beendenEmpfangen = false;
        try
        {
            in = socket.getInputStream();
            out = socket.getOutputStream();
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
                    Speichern(zeichen);
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
            server.Abmelden(this);
            if (beendenEmpfangen)
            {
                server.BeendenSetzen();
            }
            socket.close();
        }
        catch (Exception e)
        {
            System.out.println("Allgemeiner Fehler: " + e);
            e.printStackTrace();
        }
    }

    /**
     * Speichert die auszugebenden Zeichen bis der Puffer voll ist oder eine
     * Zeile fertig ist.
     *
     * @param zeichen das zu speichernde Zeichen.
     */
    private void Speichern(int zeichen)
    {
        puffer[pufferStand] = zeichen;
        pufferStand += 1;
        if ((pufferStand == puffer.length) || (zeichen == '\n'))
        {
            server.Ausgeben(puffer, pufferStand);
            pufferStand = 0;
        }
    }

    /**
     * Gibt die Zeichen auf den Ausgabestrom aus.
     *
     * @param zeichen die auszugebenden Zeichen
     * @param anzahl Anzahl der auszugebenden Zeichen
     */
    void Ausgeben(int[] zeichen, int anzahl)
    {
        try
        {
            for (int i = 0; i < anzahl; i++)
            {
                out.write(zeichen[i]);
            }
            out.flush();
        }
        catch (Exception e)
        {
            System.out.println("Allgemeiner Fehler: " + e);
            e.printStackTrace();
        }
    }
}
