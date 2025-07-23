package org.bschlangaul.schulbuecher.isb.k_means.schwer.Projekt;
import java.util.Random;

public class KMEANS
{
    private final Random random = new Random();

    public KMEANS(int kNeu)
    {
        k = kNeu;
        zentren = new PUNKT[k];
    }


    public void generiereZufallszentren(){

    }

    public boolean aktualisiereClusterzuordnung(){

    }

    public void positioniereZentrenNeu(){

    }


    public void kmeansAusfuehren(){

    }

        public void gibAlleClusterAus(){
        for(int i = 0; i < k; i++){
            PUNKT z = zentren[i];
            System.out.println("Cluster " + (i+1) + " mit Zentrum (" + z.gibX() + "/" + z.gibY() + "):");
            for(int j = 0; j < anzahlPunkte; j++){
                PUNKT d = daten[j];
                if(clusterZuordnung[j] == i+1)
                    System.out.print("(" + d.gibX() + "/" + d.gibY() + "); ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------");

    }

        public PUNKT[] gibDaten(){
        return daten;
    }

    public PUNKT[] gibZentren(){
        return zentren;
    }

    public int[] gibCluster(){
        return clusterZuordnung;
    }

    public int gibK(){
        return k;
    }

    public int gibAnzahl(){
        return anzahlPunkte;
    }

    public void leseDatenEin(String dateiname){
        daten = DATENEINLESE.ladeTrainingsdaten(dateiname);
        anzahlPunkte = daten.length;
        clusterZuordnung = new int[anzahlPunkte];
    }

}
