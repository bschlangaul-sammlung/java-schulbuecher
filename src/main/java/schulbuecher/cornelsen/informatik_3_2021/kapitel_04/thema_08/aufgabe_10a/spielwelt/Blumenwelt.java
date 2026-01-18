package schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_10a.spielwelt;

import java.util.Random;

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
     * Der Zufallsgenerator
     */
    Random zufallszahlgenerator;

    /**
     * Erzeugt die Welt.
     */
    Blumenwelt()
    {
        // Erzeuge einen Zufallszahlgenerator
        zufallszahlgenerator = new Random();
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
        // Blumen werden gepflanzt
        for (int anzahlBlumen = 0; anzahlBlumen < 10; anzahlBlumen = anzahlBlumen
                + 1)
        {
            new Blume(zufallszahlgenerator.nextInt(10),
                    zufallszahlgenerator.nextInt(10));
        }
        // Pilze werden positioniert
        for (int anzahlPilze = 0; anzahlPilze < 8; anzahlPilze = anzahlPilze
                + 1)
        {
            new Fliegenpilz(zufallszahlgenerator.nextInt(10),
                    zufallszahlgenerator.nextInt(10));
        }
    }
}
