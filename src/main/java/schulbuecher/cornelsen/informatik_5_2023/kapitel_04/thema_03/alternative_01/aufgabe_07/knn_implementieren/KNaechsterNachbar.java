package schulbuecher.cornelsen.informatik_5_2023.kapitel_04.thema_03.alternative_01.aufgabe_07.knn_implementieren;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import schulbuecher.cornelsen.shared.graphics_and_games.Kreis;
import schulbuecher.cornelsen.shared.graphics_and_games.Rechteck;
import schulbuecher.cornelsen.shared.graphics_and_games.Text;

/**
 * Erzeugung von zufälligen Datenpunkten und Umsetzung des
 * k-NächsteNachbarn-Algorithmus
 *
 * @author (Peter Brichzin)
 *
 * @version (21.5.23)
 */
public class KNaechsterNachbar // gibt es ein Problem bei Umlauten im
                               // Klassennamen? -> KNächsteNachbar
{
    /**
     * Zufallsgenerator
     */
    Random zufallsgenerator;

    /**
     * Datenpunkte
     */
    ArrayList<Datenpunkt> datenpunkte;

    /**
     * Visualisierung der Datenpunkte über Rechtecke von Grafics &amp; Games
     */
    ArrayList<Rechteck> datenpunkteVisualisierung;

    /**
     * Visualisierung des zu labelnden Datenpunkts über einen Kreis von Grafics
     * &amp; Games
     */
    Kreis zuLabelnderDatenpunktVisualisierung;

    /**
     * Label der Art: Label 1, Label 2, Label 3, ...
     */
    ArrayList<String> labelListe;

    /**
     * absolute Häufigkeit der Label von den k nächsten Nachbarn Zuordnung zur
     * Labelart über den Index: 0 -> Label 1, 1 -> Label 2 ...
     */
    ArrayList<Integer> häufigkeitLabel;

    /**
     * Konstruktor für Objekte der Klasse KNaechsterNachbar
     */
    public KNaechsterNachbar()
    {
        zufallsgenerator = new Random();

        datenpunkte = new ArrayList<Datenpunkt>();
        datenpunkteVisualisierung = new ArrayList<Rechteck>();

        // Erzeugung der Visualisierung für den (erst später erstellten) zu
        // labelnden
        // Punkt
        zuLabelnderDatenpunktVisualisierung = new Kreis();
        zuLabelnderDatenpunktVisualisierung.RadiusSetzen(10);
        zuLabelnderDatenpunktVisualisierung.FarbeSetzen("cyan");
        zuLabelnderDatenpunktVisualisierung.SichtbarkeitSetzen(false);

        // Erzeugen von 150 Datenpunkten mit 6 Labeln, die passend zu den Labeln
        // geclustert sind
        DatenGenerieren(150, 6);

        häufigkeitLabel = new ArrayList<Integer>();
    }

    /**
     * Methode DatenGenerieren erzeugt zufällig Daten mit Clustern. Jedem
     * Cluster wird ein Label zugeordnet. Jedes Cluster hat die gleiche Anzahl
     * von Datenpunkten.
     *
     * @param anzahlDatenpunkte Anzahl der Datenpunkte
     * @param anzahlLabel Anzahl der Cluster
     */
    void DatenGenerieren(int anzahlDatenpunkte, int anzahlLabel)
    {
        // gegebenenfalls schon existierende Datenvisualisierungen entfernen
        GezeichneteDatenEntfernen();

        ArrayList<Datenpunkt> clusterzentren;
        clusterzentren = new ArrayList<Datenpunkt>();

        // Labelliste erstellen
        labelListe = LabelGenerieren(anzahlLabel);

        // Clusterzentren erzeugen
        clusterzentren = ClusterzentrenGenerieren(anzahlLabel);

        // Datenpunkte um die Cluster erzeugen
        datenpunkte = DatenpunkteUmClusterGenerieren(anzahlDatenpunkte,
                clusterzentren);

        // Datenpunkte zeichnen
        DatenZeichnen();
    }

    public double euklidischerAbstandBerechnen(Datenpunkt punkt1,
            Datenpunkt punkt2)
    {
        double x1 = punkt1.XGeben();
        double y1 = punkt1.YGeben();
        double x2 = punkt2.XGeben();
        double y2 = punkt2.YGeben();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /**
     * Methode neuenDatenpunktLabeln
     *
     * @param punktNeu neuer Datenpunkt, für den das Label zu finden ist
     * @param k Anzahl der nächsten Nachbarn, die berücksichtigt werden.
     */
    public void neuenDatenpunktLabeln(Datenpunkt punktNeu, int k)
    {
        // zu labelnden Punkt in der Zeichnung passend positionieren und
        // sichtbar machen
        zuLabelnderDatenpunktVisualisierung.PositionSetzen(
                (int) punktNeu.XGeben(), 500 - (int) punktNeu.YGeben());
        zuLabelnderDatenpunktVisualisierung.SichtbarkeitSetzen(true);

        // Abstand zum neuen Datenpunkt wird in dem Feld Datenpunkte ergänzt;
        double abstandTemp;
        for (Datenpunkt p : datenpunkte)
        {
            abstandTemp = euklidischerAbstandBerechnen(p, punktNeu);
            p.AbstandSetzen(abstandTemp);
        }

        // Die Datenpunkte werden nach Abstand sortieren;
        // (Sortieren durch Einfügen siehe Informatik 11 Kapitel 1.9 Aufgabe 8)
        for (int i = 1; i < datenpunkte.size(); i = i + 1)
        {
            Datenpunkt zuSortierenderDatenpunkt;
            zuSortierenderDatenpunkt = datenpunkte.get(i);
            int j;
            j = i;
            while (j > 0 && datenpunkte.get(j - 1)
                    .AbstandGeben() > zuSortierenderDatenpunkt.AbstandGeben())
            {
                datenpunkte.set(j, datenpunkte.get(j - 1));
                j = j - 1;
            }
            datenpunkte.set(j, zuSortierenderDatenpunkt);
        }

        // Ausgabe der k-Nächsten-Nachbarn und Häufigkeit zählen
        häufigkeitLabelInitialisieren(labelListe.size());
        System.out.println("Die " + k + " nächsten Nachbarn sind:");

        for (int i = 0; i < k; i = i + 1)
        {
            datenpunkte.get(i).InformationAusgeben();
            switch (datenpunkte.get(i).LabelGeben())
            {
            case "Label 1":
                häufigkeitLabel.set(0, häufigkeitLabel.get(0) + 1);
                break;

            case "Label 2":
                häufigkeitLabel.set(1, häufigkeitLabel.get(1) + 1);
                break;

            case "Label 3":
                häufigkeitLabel.set(2, häufigkeitLabel.get(2) + 1);
                break;

            case "Label 4":
                häufigkeitLabel.set(3, häufigkeitLabel.get(3) + 1);
                break;

            case "Label 5":
                häufigkeitLabel.set(4, häufigkeitLabel.get(4) + 1);
                break;

            case "Label 6":
                häufigkeitLabel.set(5, häufigkeitLabel.get(5) + 1);
                break;

            case "Label 7":
                häufigkeitLabel.set(6, häufigkeitLabel.get(6) + 1);
                break;

            case "Label 8":
                häufigkeitLabel.set(7, häufigkeitLabel.get(7) + 1);
                break;

            case "Label 9":
                häufigkeitLabel.set(8, häufigkeitLabel.get(8) + 1);
                break;

            case "Label 10":
                häufigkeitLabel.set(9, häufigkeitLabel.get(9) + 1);
                break;

            }
        }

        // Bestimmung und Ausgabe des Labels
        // Falls es mehrere Labals mit gleicher Häufigkeit gibt, werden alle
        // ausgegeben
        // und es muss (z. B. per Zufall) entschieden werden, welches gewählt
        // wird.
        Integer max = Collections.max(häufigkeitLabel); // Bibliotheksfunktion
                                                        // erleichtert die
                                                        // MAximumsbestimmung
        for (int i = 0; i < häufigkeitLabel.size(); i = i + 1)
        {
            if (häufigkeitLabel.get(i) == max)
            {
                System.out.println(
                        "Das gesuchte Label ist " + labelListe.get(i) + " .");
            }
        }

    }

    private void häufigkeitLabelInitialisieren(int k)
    {
        häufigkeitLabel.clear();
        for (int i = 0; i < k; i = i + 1)
        {
            häufigkeitLabel.add(0);
        }
    }

    /**
     * Methode LabelGenerieren generiert Label der Art: Label 1, Label 2, Label
     * 3, ...
     *
     * @param anzahl Anzahl der Label, maximale Anzahl beträgt 10 wegen der
     *     Visualisierung
     *
     * @return Label als Arraylist von Zeichenketten
     */
    private ArrayList<String> LabelGenerieren(int anzahl)
    {
        if (anzahl > 10)
        {
            anzahl = 10;
            System.out.println("Die maximale Anzahl der Label ist 10.");
        }

        ArrayList<String> ergebnis;
        ergebnis = new ArrayList<String>();
        for (int i = 0; i < anzahl; i = i + 1)
        {
            ergebnis.add("Label " + (i + 1));

        }
        return ergebnis;
    }

    /**
     * Methode ClusterzentrenGenerieren erzeugt Clusterzentren im Bereich
     * {@code 100<x<600} und {@code 100<y<400} -> Jedes Cluster ist mindestens
     * 100 vom Rand der Zeichenfläche (Rechtecks der Größe {@code 700 x 500})
     * entfernt.
     *
     * @param anzahl Anzahl der Clusterzentren
     *
     * @return die Clusterzentren als Arraylist von Datenpunkten
     */
    private ArrayList<Datenpunkt> ClusterzentrenGenerieren(int anzahl)
    {
        ArrayList<Datenpunkt> ergebnis;
        ergebnis = new ArrayList<Datenpunkt>();
        for (int i = 0; i < anzahl; i = i + 1)
        {
            int x = zufallsgenerator.nextInt(500) + 100;
            int y = zufallsgenerator.nextInt(300) + 100;
            ergebnis.add(new Datenpunkt(x, y));
        }
        return ergebnis;
    }

    /**
     * Die Methode DatenpunkteUmClusterGenerieren erzeugt Datenpunkte um die
     * Clusterzentren. Die Datenpunkte sind auf die Clusterzentren gleichmäßig
     * verteilt und streuen um +/- 100 sowohl in x- als auch y-Richtung um die
     * Clusterzentren
     *
     * @param anzahlDatenpunkte zu erzeugende Anzahl an Datenpunkten
     * @param clusterzentren Arraylist der Clusterzentren
     *
     * @return die Datenpunkte als Arraylist von Datenpunkten
     */
    private ArrayList<Datenpunkt> DatenpunkteUmClusterGenerieren(
            int anzahlDatenpunkte, ArrayList<Datenpunkt> clusterzentren)
    {
        ArrayList<Datenpunkt> ergebnis;
        ergebnis = new ArrayList<Datenpunkt>();

        for (int i = 0; i < anzahlDatenpunkte; i++)
        {
            int clusterIndex = zufallsgenerator.nextInt(clusterzentren.size());
            Datenpunkt clusterDatenpunkt = clusterzentren.get(clusterIndex);
            double x = (double) clusterDatenpunkt.XGeben()
                    + zufallsgenerator.nextInt(200) - 100;
            double y = (double) clusterDatenpunkt.YGeben()
                    + zufallsgenerator.nextInt(100) - 100;

            ergebnis.add(new Datenpunkt(x, y, labelListe.get(clusterIndex)));
        }
        return ergebnis;
    }

    /**
     * Die Methode GezeichneteDatenEntfernen entfernt (alte) Visualisierungen
     * von Datenpunkten.
     *
     */
    void GezeichneteDatenEntfernen()
    {
        for (Rechteck r : datenpunkteVisualisierung)
        {
            r.Entfernen();
        }
        datenpunkteVisualisierung.clear();

        zuLabelnderDatenpunktVisualisierung.SichtbarkeitSetzen(false);
    }

    /**
     * Die Methode DatenZeichnen ermöglicht das Visualisieren der Datenpunkte.
     * Da die y-Achse nach unten gerichtet ist muss beim Setzen der Position der
     * y-Wert auf 500 -p.YGeben() gesetzt werden (-> x-Achse ist 500 Pixel vom
     * oberen Bildschrimrand entfernt)
     *
     */
    void DatenZeichnen()
    {
        // für jeden Datenpunkt ein Rechteck zeichnen, passend zum Label gefärbt
        LegendeZeichnen();
        for (Datenpunkt p : datenpunkte)
        {
            Rechteck r;
            r = new Rechteck();

            int xWertAlsInt;
            xWertAlsInt = (int) p.XGeben(); // Konvertierung in eine ganze Zahl
                                            // zum Zeichnen
            int yWertAlsInt;
            yWertAlsInt = (int) p.YGeben(); // Konvertierung in eine ganze Zahl
                                            // zum Zeichnenandelt in eine ganze
                                            // Zahl

            System.out.println(xWertAlsInt + "   " + yWertAlsInt);

            r.PositionSetzen(xWertAlsInt, 500 - yWertAlsInt);
            r.GrößeSetzen(5, 5);
            switch (p.LabelGeben())
            {
            case "Label 1":
                r.FarbeSetzen("blau");
                break;

            case "Label 2":
                r.FarbeSetzen("grün");
                break;

            case "Label 3":
                r.FarbeSetzen("magenta");
                break;

            case "Label 4":
                r.FarbeSetzen("rot");
                break;

            case "Label 5":
                r.FarbeSetzen("braun");
                break;

            case "Label 6":
                r.FarbeSetzen("orange");
                break;

            case "Label 7":
                r.FarbeSetzen("schwarz");
                break;

            case "Label 8":
                r.FarbeSetzen("gelb");
                break;

            case "Label 9":
                r.FarbeSetzen("hellgrün");
                break;

            case "Label 10":
                r.FarbeSetzen("hellgelb");
                break;

            default:
                r.FarbeSetzen("grau");

            }
            datenpunkteVisualisierung.add(r);
        }
    }

    /**
     * Methode LegendeZeichnen zeichnet die Legende
     *
     */
    void LegendeZeichnen()
    {
        int yPosition;
        yPosition = 380;
        for (String labelname : labelListe)
        {
            Text t;
            t = new Text();
            t.PositionSetzen(700, yPosition);
            t.TextGrößeSetzen(12);
            t.TextSetzen(labelname);
            yPosition = yPosition + 15;
            switch (labelname)
            {
            case "Label 1":
                t.FarbeSetzen("blau");
                break;

            case "Label 2":
                t.FarbeSetzen("grün");
                break;

            case "Label 3":
                t.FarbeSetzen("magenta");
                break;

            case "Label 4":
                t.FarbeSetzen("rot");
                break;

            case "Label 5":
                t.FarbeSetzen("braun");
                break;

            case "Label 6":
                t.FarbeSetzen("orange");
                break;

            case "Label 7":
                t.FarbeSetzen("schwarz");
                break;

            case "Label 8":
                t.FarbeSetzen("gelb");
                break;

            case "Label 9":
                t.FarbeSetzen("hellgrün");
                break;

            case "Label 10":
                t.FarbeSetzen("hellgelb");
                break;

            default:
                t.FarbeSetzen("grau");

            }
        }

    }

    public static void main(String[] args)
    {

        KNaechsterNachbar kNN1 = new KNaechsterNachbar();
        Datenpunkt zuLabelnderDatenpunkt = new Datenpunkt(400, 300);

        kNN1.neuenDatenpunktLabeln(zuLabelnderDatenpunkt, 8);

    }
}
