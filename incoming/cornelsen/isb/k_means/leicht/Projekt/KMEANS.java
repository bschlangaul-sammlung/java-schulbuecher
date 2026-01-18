package schulbuecher.isb.k_means.leicht.Projekt;

import java.util.Random;

public class KMEANS
{
    private int k;

    private int anzahlPunkte;

    private final Random random = new Random();

    private PUNKT[] daten;

    private PUNKT[] zentren;

    private int[] clusterZuordnung;

    public KMEANS(int kNeu)
    {
        k = kNeu;
        zentren = new PUNKT[k];
    }

    public boolean aktualisiereClusterzuordnung()
    {
        boolean gleichbleibend = true;
        // Wiederhole für jeden Datenpunkt der daten einmal
        // !!! Hier ergänzen !!!
        for (int i = 0;; i++)
        {
            // Bestimme den Index des nächstgelegenenen Zentrums zum aktuell
            // betrachteten
            // Datenpunkt und speichere diesen lokal
            // !!! Hier ergänzen !!!

            // Falls die Nummmer des Zentrums, dem dieser Datenpunkt zugeodnet
            // ist nicht mit
            // dem berechneten Index (+1 da wir die Zentren beginnend mit 1
            // nummerieren)
            // übereinstimmt:
            // Aktualisiere die Zurodnung und belege die Variable gleichbleibend
            // entsprechend
            // !!! Hier ergänzen !!!

        }
        return gleichbleibend;
    }

    public void positioniereZentrenNeu(){
        for(int i = 0; i < k; i++){
            double summeX = 0;
            double summeY = 0;
            int zaehler = 0;
            // Durchlauf alle Datenpunkt von daten
            // !!! Hier ergänzen !!!
            for(int j = 0;                j++){
                PUNKT d = daten[j];
                // Wenn der aktuell betrachtete Datenpunkt dem aktuellen Cluster (i+1)
                // zugeordnet ist, erhöhe die Koordinatensummen und den Zähler entsprechend.
                // !!! Hier ergänzen !!!

            }
            // Aktualsiere die x und die y Koordinate des Zentrums an Stelle i mit dem
            // geometrischen Schwerpunkt
            // !!! Hier ergänzen !!!

        }
    }

    public void kmeansAusfuehren(){
        this.generiereZufallszentren();
        // Solange die Aktualisierung der Clusterzuordnung eine Änderung zurückgibt
        // !!! Hier ergänzen !!!
        while(                    ){
            // Aktualisiere die Zentren der Cluster neu
            // !!! Hier ergänzen !!!



            LABOR.aktualisiereAnzeige();//Bebötigt für die Anzeige in der Laborklasse.
        }
    }

    public PUNKT[] gibDaten()
    {
        return daten;
    }

    public PUNKT[] gibZentren()
    {
        return zentren;
    }

    public int[] gibCluster()
    {
        return clusterZuordnung;
    }

    public int gibK()
    {
        return k;
    }

    public int gibAnzahl()
    {
        return anzahlPunkte;
    }

    public void leseDatenEin(String dateiname)
    {
        daten = DATENEINLESE.ladeTrainingsdaten(dateiname);
        anzahlPunkte = daten.length;
        clusterZuordnung = new int[anzahlPunkte];
    }

    public void generiereZufallszentren()
    {
        for (int i = 0; i < k; i++)
        {
            PUNKT z = daten[random.nextInt(anzahlPunkte)];
            zentren[i] = new PUNKT("Zentrum " + (i + 1), z.gibX(), z.gibY());
        }
    }

    public void gibAlleClusterAus()
    {
        for (int i = 0; i < k; i++)
        {
            PUNKT z = zentren[i];
            System.out.println("Cluster " + (i + 1) + " mit Zentrum ("
                    + z.gibX() + "/" + z.gibY() + "):");
            for (int j = 0; j < anzahlPunkte; j++)
            {
                PUNKT d = daten[j];
                if (clusterZuordnung[j] == i + 1)
                    System.out.print("(" + d.gibX() + "/" + d.gibY() + "); ");
            }
            System.out.println();
        }
        System.out
                .println("--------------------------------------------------");

    }

}
