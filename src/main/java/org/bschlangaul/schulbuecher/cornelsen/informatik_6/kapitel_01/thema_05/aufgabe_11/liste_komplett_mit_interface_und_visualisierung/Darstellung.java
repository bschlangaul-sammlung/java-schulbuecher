package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_01.thema_05.aufgabe_11.liste_komplett_mit_interface_und_visualisierung;

import java.util.ArrayList;
import java.util.Random;

import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;
import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Text;
import org.bschlangaul.schulbuecher.cornelsen.shared.graphics_and_games.Zeichenfenster;

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

        /**
         * inneres Rechteck
         */
        private Rechteck innen;

        /**
         * Anzeigetext
         */
        private Text name;

        /**
         * Die Symbolfarben
         */
        private String[] farben = { "weiß", "rot", "grün", "blau", "gelb",
                "cyan", "magenta", "braun", "orange", "grau" };

        /**
         * Zufallsgenerator
         */
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

    /**
     * Die darzustellende Warteschlange
     */
    private Liste liste;

    /**
     * Der Pool an Patientensymbolen
     */
    private ArrayList<PatientenSymbol> symbole;

    /**
     * Der Konstruktor setzt die Warteschlange
     *
     * @param lNeu die darzustellende Warteschlange
     */
    Darstellung(Liste lNeu)
    {
        liste = lNeu;
        symbole = new ArrayList<PatientenSymbol>();
    }

    /**
     * Stellt den Inhalt der Warteschlange auf der Anzeige dar.
     */
    void Anzeigen()
    {
        ListenelementAnzeigen(liste.AnfangGeben(), 0);
    }

    /**
     * Stellt den aktuellen Knoten dar
     *
     * @param aktuell der aktuelle Knoten
     * @param nummer die laufende Nummer des Knotens
     */
    private void ListenelementAnzeigen(Listenelement aktuell, int nummer)
    {
        if (aktuell instanceof Knoten)
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
            ListenelementAnzeigen(aktuell.NachfolgerGeben(), nummer + 1);
        }
        else
        {
            for (int i = nummer; nummer < symbole.size(); nummer += 1)
            {
                symbole.get(i).SichtbarkeitSetzen(false);
            }
        }
    }

    public static void main(String[] args)
    {
        Liste liste = new Liste();
        Darstellung darstellung = new Darstellung(liste);
        Patient patient1 = new Patient("Patient 1");
        liste.VorneEinfügen(patient1);
        darstellung.Anzeigen();
    }
}
