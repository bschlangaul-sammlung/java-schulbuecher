
import java.util.*;
/**
 * Theseus erhält einen Weg, auf dem er zum Ausgang findet
 *
 * @author Albert Wiedemann
 * @version 1.0
 */
class Theseus extends Figur
{
    /**
     * Der Weg zum Ausgang */
    private ArrayList<Knoten> weg;
    /**
     * Bereits zurückgelegt Schritte auf dem Weg zum Ausgang */
    int schritte;
    /**
     * x-Koordinate des Wanderers in Labyrinthelementen */
    int x;
    /**
     * y-Koordinate des Wanderers in Labyrinthelementen */
    int y;

    /**
     * Legt die Figur und die Startposition fest.
     */
    Theseus (int x, int y)
    {
        super();
        weg = null;
        schritte = 0;
        this.x = x;
        this.y = y;
        FigurFestlegen();
        GrößeSetzen(LabyrinthElement.seitenlänge);
        PositionSetzen(x * LabyrinthElement.seitenlänge + LabyrinthElement.seitenlänge / 2, y  * LabyrinthElement.seitenlänge + LabyrinthElement.seitenlänge / 2);
    }

    /**
     * Legt das Aussehen von Theseus fest.
     */
    private void FigurFestlegen()
    {
        EigeneFigurLöschen();
        FigurteilFestlegenRechteck(-35, 0, 70, 25, "rot");
        FigurteilFestlegenEllipse(-25, 25, 10, 10, "schwarz");
        FigurteilFestlegenEllipse(15, 25, 10, 10, "schwarz");
        FigurteilFestlegenEllipse(-20, -40, 40, 40, "rot");
        FigurteilFestlegenEllipse(5, -27, 15, 15, "gelb");
    }

    /**
     * Legt den Weg um Ausgang fest.
     * @param weg der Weg zum Ausgang
     */
    void WegSetzen (ArrayList<Knoten> weg)
    {
        this.weg = weg;
        schritte = 1;
    }

    /**
     * Bewegt Theseus ein Feld in Richtung Ausgang
     */
    @Override void AktionAusführen()
    {
        if ((weg != null) && (schritte < weg.size()))
        {
            Knoten k = weg.get(schritte);
            if (k.XGeben() == x + 1)
            {
                WinkelSetzen(0);
            }
            else if (k.XGeben() == x - 1)
            {
                WinkelSetzen(180);
            }
            else if (k.YGeben() == y - 1)
            {
                WinkelSetzen(90);
            }
            else if (k.YGeben() == y + 1)
            {
                WinkelSetzen(270);
            }
            Gehen(LabyrinthElement.seitenlänge);
            x = k.XGeben();
            y = k.YGeben();
            schritte += 1;
        }
    }
}
