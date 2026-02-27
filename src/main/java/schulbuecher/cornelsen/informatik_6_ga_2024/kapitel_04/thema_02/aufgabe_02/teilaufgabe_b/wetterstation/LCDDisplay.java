package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_02.aufgabe_02.teilaufgabe_b.wetterstation;

public class LCDDisplay
{
    public synchronized void textAusgeben(String text)
    {
        for (char z : text.toCharArray())
        {
            zeichenAusgeben(z);
        }
    }

    private void zeichenAusgeben(char zeichen)
    {
        try
        {
            // Simuliert ein Hardwaredisplay, welches nur zeichenweise
            // und mit begrenzter Geschwindigkeit beschrieben werden kann.
            System.out.print(zeichen);
            Thread.sleep(10);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
    }
}
