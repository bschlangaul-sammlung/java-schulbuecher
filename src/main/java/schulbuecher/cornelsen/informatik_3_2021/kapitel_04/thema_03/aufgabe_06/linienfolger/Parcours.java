package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_06.linienfolger;

import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;

/**
 * Verwaltet den Gesamtparcours.
 *
 * @author Franz Jetzinger
 *
 * @version 1.0
 */
class Parcours
{
    /**
     * Baut die Linien und das Ziel auf
     */
    Parcours()
    {
        new LinieWaagerecht(0, 160, 120, 10);
        new LinieSenkrecht(120, 160, 100, 10);
        new LinieWaagerecht(120, 260, 200, 10);
        new LinieSenkrecht(320, 260, -150, 10);
        new LinieWaagerecht(320, 110, 200, 10);
        new LinieSenkrecht(520, 110, 300, 10);
        new LinieWaagerecht(520, 410, 200, 10);
        Rechteck linienende = new Rechteck();
        linienende.FarbeSetzen("blau");
        linienende.PositionSetzen(720, 405);
        linienende.GrößeSetzen(20, 20);
    }
}
