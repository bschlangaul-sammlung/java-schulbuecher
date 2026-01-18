package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_03.aufgabe_09.spielwelt_2d;

import schulbuecher.cornelsen.shared.graphics_and_games.Zelle;

/**
 * Legt die Blumenwelt an und die nicht beweglichen Objekte. Die Welt besteht
 * aus 10x10 Zellen. Damit die Objekte der Klasse Zelle gut sichtbar sind, wird
 * zwischen den Zellen ein Abstand von 4 Pixeln gelassen. Mit diesem Rand hat
 * die Welt Zellen der Größe 50x 50 Pixel. In der Blumenwelt sind auch mehrere
 * Blumen.
 *
 * @author Peter Brichzin
 *
 * @version version 1.0
 */
class Blumenwelt
{
    /**
     * Erzeugt die Welt.
     */
    Blumenwelt()
    {
        // Diesen Abschnitt ignorieren, es werden die 10x10 Zellen der Welt
        // erzeugt und positioniert
        for (int zellenNummerX = 0; zellenNummerX < 10; zellenNummerX = zellenNummerX
                + 1)
        {
            for (int zellenNummerY = 0; zellenNummerY < 10; zellenNummerY += 1)
            {
                new Zelle(50 * zellenNummerX + 2, 50 * zellenNummerY + 2,
                        "grün");
            }
        }
        // Abschnittsende
        int nummer; // ein PLatzhalter für eine Nummer
        nummer = 2; // Startwert 2 für die Nummer
        while (nummer < 10)
        {
            new Blume(nummer, 2);
            nummer = nummer + 1; // die Nummer wird um eins erhöht
        }
        nummer = 4; // neuer Startwert
        while (nummer < 9)
        {
            new Blume(7, nummer);
            nummer = nummer + 1; // die Nummer wird um eins erhöht
        }
    }
}
