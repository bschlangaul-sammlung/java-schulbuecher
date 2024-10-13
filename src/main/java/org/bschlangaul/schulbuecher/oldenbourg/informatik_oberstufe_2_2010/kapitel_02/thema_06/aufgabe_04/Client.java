package org.bschlangaul.schulbuecher.oldenbourg.informatik_oberstufe_2_2010.kapitel_02.thema_06.aufgabe_04;

/**
 * Rahmen für den Klienten.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Client
{
    /**
     * Legt die Arbeitsobjekte an.
     */
    private Client()
    {
        new ClientAutomat(new NetzwerkClient()).Arbeiten();
    }

    /**
     * Programmstart
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args)
    {
        new Client();
    }
}
