package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_02.aufgabe_02.arzt_mit_visualisierung;

import java.util.ArrayList;
import java.util.Random;

/**
 * Stellt die Warteschlange im Wartezimmer dar
 *
 * @author Albert Wiedemann
 *
 * @version 1.0
 */
class Darstellung
{
    /**
     * Klasse für die Darstellung eines Patienten
     */
    private static class PatientenSymbol
    {
        /** äußeres Rechteck */
        private Rechteck außen;

        /** inneres Rechteck */
        private Rechteck innen;

        /** Anzeigetext */
        private Text name;

        /** Die Symbolfarben */
        private String[] farben = { "weiß", "rot", "grün", "blau", "gelb",
                "cyan", "magenta", "braun", "orange", "grau" };

        /** Zufallsgenerator */
        private static final Random ran = new Random();

        /**
         * Der Konstruktor legt die Anzeigeelemente an.
         */
        PatientenSymbol()
        {
            außen = new Rechteck();
            außen.SichtbarkeitSetzen(false);
            außen.PositionSetzen(0, 0);
            außen.GrößeSetzen(100, 40);
            außen.FarbeSetzen("schwarz");
            innen = new Rechteck();
            innen.SichtbarkeitSetzen(false);
            innen.PositionSetzen(2, 2);
            innen.GrößeSetzen(96, 36);
            innen.FarbeSetzen(farben[ran.nextInt(farben.length)]);
            name = new Text();
            name.SichtbarkeitSetzen(false);
            name.PositionSetzen(4, 24);
            name.TextSetzen("");
        }

        /**
         * Setzt die Position des Symbols
         *
         * @param x: x-Position der linken oberen Ecke
         * @param y: y-Position der linken oberen Ecke
         */
        void PositionSetzen(int x, int y)
        {
            außen.PositionSetzen(x, y);
            innen.PositionSetzen(x + 2, y + 2);
            name.PositionSetzen(x + 4, y + 24);
        }

        /**
         * Setzt die Sichtbarkeit des Symbols
         *
         * @param sichtbar: wenn wahr, wird das Symbol angezeigt
         */
        void SichtbarkeitSetzen(boolean sichtbar)
        {
            außen.SichtbarkeitSetzen(sichtbar);
            innen.SichtbarkeitSetzen(sichtbar);
            name.SichtbarkeitSetzen(sichtbar);
        }

        /**
         * Setzt den Anzeigetext
         *
         * @param text Anzeigetext
         */
        void TextSetzen(String text)
        {
            name.TextSetzen(text);
        }
    }

    /** Die darzustellende Warteschlange */
    private Warteschlange warteschlange;

    /** Der Pool an Patientensymbolen */
    private ArrayList<PatientenSymbol> symbole;

    /**
     * Der Konstruktor setzt die Warteschlange
     *
     * @param ws die darzustellende Warteschlange
     */
    Darstellung(Warteschlange ws)
    {
        warteschlange = ws;
        symbole = new ArrayList<PatientenSymbol>();
    }

    /**
     * Stellt den Inhalt der Warteschlange auf der Anzeige dar.
     */
    void Anzeigen()
    {
        KnotenAnzeigen(warteschlange.AnfangGeben(), 0);
    }

    /**
     * Stellt den aktuellen Knoten dar
     *
     * @param aktuell der aktuelle Knoten
     * @param nummer die laufende Nummer des Knotens
     */
    private void KnotenAnzeigen(Knoten aktuell, int nummer)
    {
        if (aktuell != null)
        {
            if (symbole.size() <= nummer)
            {
                symbole.add(new PatientenSymbol());
            }
            PatientenSymbol p = symbole.get(nummer);
            p.TextSetzen(aktuell.DatenelementGeben().NameGeben());
            p.SichtbarkeitSetzen(true);
            int x, y;
            int b = Zeichenfenster.MalflächenBreiteGeben();
            int h = Zeichenfenster.MalflächenHöheGeben();
            if (nummer < b / 110)
            {
                x = nummer * 110;
                y = 0;
            }
            else if (nummer < h / 50 + b / 110 - 1)
            {
                x = (b / 110 - 1) * 110;
                y = (nummer - b / 110 + 1) * 50;
            }
            else if (nummer < h / 50 + 2 * (b / 110) - 2)
            {
                x = (h / 50 + 2 * (b / 110) - nummer - 3) * 110;
                y = (h / 50 - 1) * 50;
            }
            else if (nummer < 2 * (h / 50 + b / 110) - 4)
            {
                x = 0;
                y = (2 * (h / 50 + b / 110) - nummer - 4) * 50;
            }
            else
            {
                p.SichtbarkeitSetzen(false);
                x = -200;
                y = -100;
            }
            p.PositionSetzen(x, y);
            KnotenAnzeigen(aktuell.NachfolgerGeben(), nummer + 1);
        }
        else
        {
            for (int i = nummer; nummer < symbole.size(); nummer += 1)
            {
                symbole.get(i).SichtbarkeitSetzen(false);
            }
        }
    }
}
