package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_06.aufgabe_04;

/**
 * Rahmen für den Server.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Server
{
    /**
     * Legt die Rahmenobjekte an.
     */
    private Server()
    {
        new NetzwerkServer().Arbeiten();
    }

    /**
     * Programmstart
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args)
    {
        new Server();
    }
}
