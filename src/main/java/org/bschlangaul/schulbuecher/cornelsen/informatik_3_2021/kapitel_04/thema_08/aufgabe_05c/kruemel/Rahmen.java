package org.bschlangaul.schulbuecher.cornelsen.informatik_3_2021.kapitel_04.thema_08.aufgabe_05c.kruemel;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Ereignisbehandlung;

/**
 * Schafft den Rahmen für das Spiel.
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Rahmen extends Ereignisbehandlung
{
    /**
     * Legt die Krümel und das Monster an
     */
    Rahmen()
    {
        new MauerRechteck(0, 0, 560, 20);
        new MauerRechteck(0, 20, 20, 160);
        new MauerRechteck(540, 20, 20, 160);
        new MauerRechteck(40, 40, 80, 120);
        new MauerRechteck(440, 40, 80, 120);
        new MauerRechteck(140, 40, 60, 60);
        new MauerRechteck(360, 40, 60, 60);
        new MauerRechteck(220, 40, 120, 60);
        new MauerRechteck(0, 180, 120, 100);
        new MauerRechteck(440, 180, 120, 100);
        new MauerRechteck(140, 120, 280, 40);
        new MauerRechteck(140, 160, 40, 60);
        new MauerRechteck(380, 160, 40, 60);
        new MauerRechteck(200, 180, 160, 40);
        new MauerRechteck(140, 240, 40, 100);
        new MauerRechteck(380, 240, 40, 100);
        new MauerRechteck(200, 240, 160, 100);
        new MauerRechteck(0, 300, 120, 100);
        new MauerRechteck(440, 300, 120, 100);
        new MauerRechteck(140, 360, 100, 40);
        new MauerRechteck(320, 360, 100, 40);
        new MauerRechteck(260, 360, 40, 100);
        new MauerRechteck(0, 400, 20, 200);
        new MauerRechteck(540, 400, 20, 200);
        new MauerRechteck(20, 420, 40, 40);
        new MauerRechteck(500, 420, 40, 40);
        new MauerRechteck(80, 420, 40, 100);
        new MauerRechteck(440, 420, 40, 100);
        new MauerRechteck(40, 480, 40, 100);
        new MauerRechteck(480, 480, 40, 100);
        new MauerRechteck(140, 420, 100, 40);
        new MauerRechteck(320, 420, 100, 40);
        new MauerRechteck(200, 480, 160, 40);
        new MauerRechteck(200, 460, 40, 20);
        new MauerRechteck(320, 460, 40, 20);
        new MauerRechteck(140, 480, 40, 40);
        new MauerRechteck(380, 480, 40, 40);
        new MauerRechteck(100, 540, 360, 40);
        new MauerRechteck(0, 600, 560, 20);
        new Monster(90, 30);
        for (int i = 0; i < 26; i += 1)
        {
            new Kruemel(i * 20 + 30, 30);
        }
        for (int i = 0; i < 7; i += 1)
        {
            new Kruemel(30, i * 20 + 50);
            new Kruemel(530, i * 20 + 50);
        }
        for (int i = 0; i < 14; i += 1)
        {
            new Kruemel(i * 20 + 150, 110);
        }
        for (int i = 0; i < 3; i += 1)
        {
            new Kruemel(210, i * 20 + 50);
            new Kruemel(350, i * 20 + 50);
        }
        for (int i = 0; i < 24; i += 1)
        {
            new Kruemel(130, i * 20 + 50);
            new Kruemel(430, i * 20 + 50);
        }
        for (int i = 0; i < 4; i += 1)
        {
            new Kruemel(i * 20 + 50, 170);
            new Kruemel(i * 20 + 450, 170);
        }
        for (int i = 0; i < 10; i += 1)
        {
            new Kruemel(i * 20 + 190, 170);
        }
        for (int i = 0; i < 5; i += 1)
        {
            new Kruemel(i * 20 + 30, 410);
            new Kruemel(i * 20 + 150, 410);
            new Kruemel(i * 20 + 330, 410);
            new Kruemel(i * 20 + 450, 410);
        }
        for (int i = 0; i < 4; i += 1)
        {
            new Kruemel(250, i * 20 + 410);
            new Kruemel(310, i * 20 + 410);
        }
        for (int i = 0; i < 20; i += 1)
        {
            new Kruemel(i * 20 + 90, 530);
        }
        for (int i = 0; i < 26; i += 1)
        {
            new Kruemel(i * 20 + 30, 590);
        }
        for (int i = 0; i < 6; i += 1)
        {
            new Kruemel(30, i * 20 + 470);
            new Kruemel(530, i * 20 + 470);
        }
        for (int i = 0; i < 3; i += 1)
        {
            new Kruemel(70, i * 20 + 430);
            new Kruemel(490, i * 20 + 430);
        }
        new Kruemel(50, 470);
        new Kruemel(510, 470);
        for (int i = 0; i < 2; i += 1)
        {
            new Kruemel(90, i * 20 + 550);
            new Kruemel(470, i * 20 + 550);
        }
        for (int i = 0; i < 3; i += 1)
        {
            new Kruemel(190, i * 20 + 470);
            new Kruemel(370, i * 20 + 470);
        }
        new Kruemel(150, 470);
        new Kruemel(170, 470);
        new Kruemel(390, 470);
        new Kruemel(410, 470);
        new Kruemel(270, 470);
        new Kruemel(290, 470);
        Starten();
    }

    /**
     * nichts
     */
    @Override
    public void SonderTasteGedrückt(int taste)
    {
    }

    /**
     * nichts
     */
    @Override
    public void TasteGedrückt(char taste)
    {
    }

    /**
     * nichts
     */
    @Override
    public void TaktImpulsAusführen()
    {
    }
}
