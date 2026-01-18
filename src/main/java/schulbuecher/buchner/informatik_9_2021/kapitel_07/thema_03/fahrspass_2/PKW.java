package schulbuecher.buchner.informatik_9_2021.kapitel_07.thema_03.fahrspass_2;

/**
 * Klasse Auto <br>
 *
 * Kap. 7.3 Arbeitsauftrag 3, Aufgabe 1
 */
public class PKW extends Fahrzeug
{
    double ladestand;

    PKW()
    {
        super("schwarz");
        hoechstgeschwindigkeit = 15; // beliebige Einheit
        ladestand = 80; // in Prozent der Gesamtladung
    }

    /*
     * Das Auto bewegt sich, solange noch Energie vorhanden ist. Ist der
     * Ladestand unter 30%, fährt es langsamer, verbraucht aber auch weniger
     * Energie.
     */
    void fahre()
    {
        if (ladestand > 0)
        {
            if (ladestand >= 30)
            {
                move(hoechstgeschwindigkeit);
                ladestand = ladestand - 2;
            }
            else
            {
                move(hoechstgeschwindigkeit - 10);
                ladestand = ladestand - 1;
            }
        }
    }

    /*
     * Vor Beginn der Fahrt kann die Batterie (bis maximmal 100) nochmals
     * geladen werden.
     */
    void lade(int menge)
    {
        ladestand = ladestand + menge;
        if (ladestand > 100)
        {
            ladestand = 100;
        }
    }

    /*
     * Vor Beginn der Fahrt kann die Hupe betätigt werden.
     */
    void gibLaut()
    {
        System.out.println("tröööt tröööööööt!");
    }
}
