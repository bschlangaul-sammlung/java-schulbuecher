package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_05.aufgabe_09.spielwelt_2d;

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
        nummer = 1; // Startwert 2 für die Nummer
        while (nummer < 5)
        {
            new Blume(2 * nummer - 1, nummer);
            new Blume(nummer, 2 * nummer + 1);
            nummer = nummer + 1;
        }
    }
}
