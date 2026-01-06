package org.bschlangaul.schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_01.aufgabe_01.ping_pong;

public class ThreadPong extends Thread
{
    public void run()
    {
        for (int i = 1; i < 10; i++)
        {
            System.out.println(i + ": Pong");
        }
    }
}
