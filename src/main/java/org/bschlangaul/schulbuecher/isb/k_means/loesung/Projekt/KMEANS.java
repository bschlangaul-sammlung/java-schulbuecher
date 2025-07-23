package org.bschlangaul.schulbuecher.isb.k_means.loesung.Projekt;
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

    public void generiereZufallszentren(){
        for(int i = 0; i < k; i++){
            PUNKT z = daten[random.nextInt(anzahlPunkte)];
            zentren[i] = new PUNKT("Zentrum "+(i+1),z.gibX(), z.gibY());
        }
    }

    public boolean aktualisiereClusterzuordnung(){
        boolean gleichbleibend = true;
        for(int i = 0; i < daten.length; i++){
            int z = daten[i].gibIndexNaechstgelegenerPunkt(zentren);
            if(clusterZuordnung[i] != z+1){
                gleichbleibend = false;
                clusterZuordnung[i] = z+1;
            }
        }
        return gleichbleibend;
    }

    public void positioniereZentrenNeu(){
        for(int i = 0; i < k; i++){
            double summeX = 0;
            double summeY = 0;
            int zaehler = 0;
            for(int j = 0; j < anzahlPunkte; j++){
                PUNKT d = daten[j];
                if(clusterZuordnung[j] == i+1){
                    summeX = summeX + d.gibX();
                    summeY = summeY + d.gibY();
                    zaehler++;
                }
            }
            zentren[i].setzeX(summeX/zaehler);
            zentren[i].setzeY(summeY/zaehler);
        }
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

    public void kmeansAusfuehren(){
        this.generiereZufallszentren();
        while(!aktualisiereClusterzuordnung()){
            //gibAlleClusterAus();
            positioniereZentrenNeu();
            LABOR.aktualisiereAnzeige();//Bebötigt für die Anzeige in der Laborklasse.
        }
    }

}
