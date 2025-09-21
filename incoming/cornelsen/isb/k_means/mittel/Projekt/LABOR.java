package org.bschlangaul.schulbuecher.isb.k_means.mittel.Projekt;

import processing.core.*;
import grafica.*;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

public class LABOR extends PApplet
{
    boolean start;

    KMEANS kmeans;

    GPlot plot;

    GPointsArray punkte;

    GPointsArray[] cluster;

    GPointsArray[] zentren;

    private static boolean UpdateFlag = false;

    public LABOR(KMEANS kmeansNeu)
    {
        runSketch();
        kmeans = kmeansNeu;
        start = true;
    }

    public static void aktualisiereAnzeige()
    {
        UpdateFlag = true;

        try
        {
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
        }
    }

    public void settings()
    {
        size(650, 650);
    }

    public void setup()
    {

        // Punkte laden und anzeigen.

        plot = new GPlot(this);
        plot.setPos(0, 0);
        plot.setDim(600, 600);
        plot = new GPlot(this, 25, 25, 600, 600);
        plot.setTitleText("K-Means Labor");
        plot.getXAxis().setAxisLabelText("x");
        plot.getYAxis().setAxisLabelText("y");

        cluster = new GPointsArray[kmeans.gibK()];
        zentren = new GPointsArray[kmeans.gibK()];
        punkte = new GPointsArray();

        // String dateiname = JOptionPane.showInputDialog(null, "Bitte
        // Dateinamen eingeben:");
        String projektVerzeichnis = System.getProperty("user.dir");
        JFileChooser dateiChooser = new JFileChooser(projektVerzeichnis);
        dateiChooser.showOpenDialog(null);
        String dateipfad = dateiChooser.getSelectedFile().getAbsolutePath();
        kmeans.leseDatenEin(dateipfad);

        for (PUNKT p : kmeans.gibDaten())
        {
            punkte.add(new GPoint((float) p.gibX(), (float) p.gibY(),
                    p.gibBeschriftung()));
        }
        plot.addLayer("daten", punkte);
        plot.getLayer("daten").setPointSize(10);
        plot.getLayer("daten").setPointColor(color(40, 40, 40, 150));

        kmeans.generiereZufallszentren();
        for (int i = 0; i < kmeans.gibK(); i++)
        {
            int[] farbe = farbWahl(i);
            zentren[i] = new GPointsArray();
            plot.addLayer("zentrum" + (i + 1), zentren[i]);
            plot.getLayer("zentrum" + (i + 1))
                    .setPointColor(color(farbe[0], farbe[1], farbe[2], 200));
            plot.getLayer("zentrum" + (i + 1)).setLineColor(100);
            plot.getLayer("zentrum" + (i + 1)).setLineWidth(10.0f);
            plot.getLayer("zentrum" + (i + 1)).setPointSize(15);
            plot.getLayer("zentrum" + (i + 1))
                    .addPoint(new GPoint((float) kmeans.gibZentren()[i].gibX(),
                            (float) kmeans.gibZentren()[i].gibY(),
                            kmeans.gibZentren()[i].gibBeschriftung()));
        }

        for (int i = 0; i < kmeans.gibK(); i++)
        {
            cluster[i] = new GPointsArray();
            plot.addLayer("cluster" + (i + 1), cluster[i]);
        }

        plot.activatePanning();
        plot.activateZooming(1.1F, CENTER, CENTER);
        plot.activatePointLabels();

    }

    public void draw()
    {
        background(220, 220, 220);
        stroke(255);
        plot.beginDraw();
        plot.drawBackground();
        plot.drawBox();
        plot.drawXAxis();
        plot.drawYAxis();
        plot.drawTitle();
        plot.drawPoints();
        plot.drawLabels();
        plot.endDraw();
        if (UpdateFlag)
        {
            UpdateFlag = false;
            iteration();
        }
    }

    private void iteration()
    {

        if (start)
        {
            plot.removeLayer("daten");
            start = false;
        }

        // Anzeigen
        for (int i = 0; i < kmeans.gibK(); i++)
        {
            plot.removeLayer("cluster" + (i + 1));
            cluster[i].removeRange(0, cluster[i].getNPoints());
        }

        for (int i = 0; i < kmeans.gibAnzahl(); i++)
        {
            cluster[kmeans.gibCluster()[i] - 1]
                    .add(new GPoint((float) kmeans.gibDaten()[i].gibX(),
                            (float) kmeans.gibDaten()[i].gibY(),
                            kmeans.gibDaten()[i].gibBeschriftung()));
        }

        for (int i = 0; i < kmeans.gibK(); i++)
        {
            int[] farbe = farbWahl(i);
            plot.addLayer("cluster" + (i + 1), cluster[i]);
            plot.getLayer("cluster" + (i + 1)).setPointSize(10);
            plot.getLayer("cluster" + (i + 1))
                    .setPointColor(color(farbe[0], farbe[1], farbe[2], 150));
        }

        for (int i = 0; i < kmeans.gibK(); i++)
        {
            plot.removeLayer("zentrum" + (i + 1));
        }

        for (int i = 0; i < kmeans.gibK(); i++)
        {
            int[] farbe = farbWahl(i);
            plot.addLayer("zentrum" + (i + 1), zentren[i]);
            plot.getLayer("zentrum" + (i + 1))
                    .setPointColor(color(farbe[0], farbe[1], farbe[2]));
            plot.getLayer("zentrum" + (i + 1)).setLineColor(100);
            plot.getLayer("zentrum" + (i + 1)).setLineWidth(3);
            plot.getLayer("zentrum" + (i + 1)).setPointSize(15);
            plot.getLayer("zentrum" + (i + 1))
                    .addPoint(new GPoint((float) kmeans.gibZentren()[i].gibX(),
                            (float) kmeans.gibZentren()[i].gibY(),
                            kmeans.gibZentren()[i].gibBeschriftung()));
        }
    }

    public void kmeansAusführen()
    {
        kmeans.kmeansAusfuehren();
    }

    private int[] farbWahl(int i)
    {
        switch (i)
        {
        case 0:
            return new int[] { 200, 60, 0 };

        case 1:
            return new int[] { 60, 180, 0 };

        case 2:
            return new int[] { 0, 120, 200 };

        case 3:
            return new int[] { 150, 0, 200 };

        case 4:
            return new int[] { 200, 150, 0 };

        case 5:
            return new int[] { 0, 140, 140 };

        case 6:
            return new int[] { 240, 120, 180 };

        case 7:
            return new int[] { 240, 200, 0 };

        case 8:
            return new int[] { 140, 180, 250 };

        case 9:
            return new int[] { 130, 130, 130 };

        default:
            return new int[] { 0, 0, 0 };
        }

    }

}
