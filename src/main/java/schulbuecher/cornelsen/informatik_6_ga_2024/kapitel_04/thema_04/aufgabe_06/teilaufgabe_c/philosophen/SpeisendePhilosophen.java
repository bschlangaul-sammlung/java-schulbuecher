package schulbuecher.cornelsen.informatik_6_ga_2024.kapitel_04.thema_04.aufgabe_06.teilaufgabe_c.philosophen;

import java.util.ArrayList;

import schulbuecher.cornelsen.shared.graphics_and_games.Kreis;
import schulbuecher.cornelsen.shared.graphics_and_games.Text;

/**
 * Visualisierung des Problems der speisenden Philosophen
 *
 * @author Johannes Neumeyer
 *
 * @version 1.0
 */
class SpeisendePhilosophen
{
    /**
     * verwaltet alle Gabeln
     */
    private ArrayList<Gabel> gabeln;

    /**
     * verwaltet alle Teller
     */
    private ArrayList<Kreis> teller;

    /**
     * verwaltet alle Tellerfarben
     */
    private ArrayList<String> tellerfarben;

    /**
     * verwaltet alle Philosophen
     */
    private ArrayList<Philosoph> philosophen;

    /**
     * instruierender Text oben im Zeichenfenster
     */
    private Text anleitung;

    /**
     * Beteiligte Objekte (Philosophen, Teller, Gabeln, ...) werden passend
     * erstellt und die Philosophenthreads gestartet.
     */
    SpeisendePhilosophen()
    {
        gabeln = new ArrayList<Gabel>();
        teller = new ArrayList<Kreis>();
        tellerfarben = new ArrayList<String>();
        tellerfarben.add("rot");
        tellerfarben.add("blau");
        tellerfarben.add("grün");
        tellerfarben.add("magenta");
        tellerfarben.add("grau");
        philosophen = new ArrayList<Philosoph>();
        anleitung = new Text();
        anleitung.TextSetzen(
                "Abgelegte Gabeln sind schwarz, aufgenommene Gabeln haben die Farbe ihres aktuellen Besitzers.");
        anleitung.PositionSetzen(10, 50);
        anleitung.TextGrößeSetzen(17);

        for (int zähler = 0; zähler < 5; zähler++)
        {
            gabeln.add(new Gabel(zähler));
            gabeln.get(zähler).SymbolGeben().GrößeSetzen(100, 10);
            gabeln.get(zähler).SymbolGeben().PositionSetzen(350
                    + (int) (150 * Math.cos(Math.toRadians(54 + 72 * zähler))),
                    295 - (int) (150
                            * Math.sin(Math.toRadians(54 + 72 * zähler))));
            gabeln.get(zähler).SymbolGeben().Drehen(54 + 72 * zähler);

            teller.add(new Kreis());
            teller.get(zähler).RadiusSetzen(50);
            teller.get(zähler).FarbeSetzen(tellerfarben.get(zähler));
            teller.get(zähler).PositionSetzen(400
                    + (int) (175 * Math.cos(Math.toRadians(18 + 72 * zähler))),
                    300 - (int) (175
                            * Math.sin(Math.toRadians(18 + 72 * zähler))));
        }

        for (int zähler = 0; zähler < 5; zähler++)
        {
            philosophen.add(new Philosoph(zähler, teller.get(zähler),
                    tellerfarben.get(zähler), gabeln.get((zähler - 1 + 5) % 5),
                    gabeln.get(zähler)));
            philosophen.get(zähler).start();
        }
    }
}
