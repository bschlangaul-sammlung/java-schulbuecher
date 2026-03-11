package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_03.aufgabe_00.eierautomat;

/**
 * Befüllen und Entleeren eines ländlichen Eierautomaten
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class Landleben
{
    /**
     * Konstruktor für Objekte der Klasse Landleben
     */
    Landleben()
    {
        Eierautomat automat = new Eierautomat();
        // Eierautomat automat = new BessererEierautomat();
        Baeuerin b = new Baeuerin(automat);
        Leo l = new Leo(automat);
        b.start();
        l.start();
    }

    public static void main(String[] args)
    {
        new Landleben();
    }
}
