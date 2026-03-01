package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_01.aufgabe_01.ping_pong;

public class Controller
{
    public static void start()
    {
        ThreadPing t1 = new ThreadPing();
        ThreadPong t2 = new ThreadPong();
        t1.start();
        t2.start();
    }

    public static void main(String[] args)
    {
        Controller.start();
    }
}
