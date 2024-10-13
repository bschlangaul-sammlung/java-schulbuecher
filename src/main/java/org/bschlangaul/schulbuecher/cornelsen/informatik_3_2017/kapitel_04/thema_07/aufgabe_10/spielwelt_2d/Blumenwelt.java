package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2017.kapitel_04.thema_07.aufgabe_10.spielwelt_2d;

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
        int nummer; // ein Platzhalter für eine Nummer
        nummer = 2; // Startwert 2 für die Nummer
        // Blumen werden gepflanzt
        while (nummer < 6)
        {
            new Blume(nummer, 3);
            nummer = nummer + 1; // die Nummer wird um eins erhöht
        }
        new Blume(1, 2);
        new Blume(7, 4);
        new Blume(7, 6);
        new Blume(9, 7);
        new Blume(3, 8);
        new Blume(8, 9);
        // Pilze werden positioniert
        for (int posY = 3; posY < 8; posY = posY + 1)
        {
            new Fliegenpilz(6, posY);
        }
    }
}
