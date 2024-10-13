package org.bschlangaul.schulbuecher.cornelsen.informatik_6.kapitel_00.aufgabe_03.bestellsystem;

import java.util.ArrayList;

/**
 * Hauptklasse des Bestellsystems
 *
 * @author Klaus Reinold
 *
 * @version 0.9
 */
class Bestellsystem
{
    /**
     * Referenz auf die Speisekarte
     */
    private Speisekarte karte;

    /**
     * Referenz auf das Feld der Tische
     */
    private ArrayList<Tisch> tische;

    /**
     * Konstruktor für Objekte der Klasse Bestellsystem
     *
     * @param tischAnzahl Anzahl der Tische
     */
    Bestellsystem(int tischAnzahl)
    {
        karte = new Speisekarte();
        tische = new ArrayList<Tisch>();
        for (int i = 0; i < tischAnzahl; i = i + 1)
        {
            tische.add(new Tisch());
        }
    }

    /**
     * Methode zum Bestellen von Posten für einen Tisch
     *
     * @param tischNr Tischnummer
     * @param artikel gewählter Artikel
     * @param anzahl Anzahl des gewählten Artikels
     */
    void Bestellen(int tischNr, String artikel, int anzahl)
    {
        tische.get(tischNr).Bestellen(artikel, anzahl);
    }

    /**
     * Ausgabe der Rechnung
     *
     * @param tischNr Tischnummer
     */
    void RechnungAusgeben(int tischNr)
    {
        System.out.println("Restaurant Knödel-Karli");
        ArrayList<Posten> liste = tische.get(tischNr).BestelltePostenGeben();
        double summe = 0;
        for (Posten p : liste)
        {
            String name = p.ArtikelGeben();
            int anzahl = p.AnzahlGeben();
            double preis = karte.SpeisekarteneintragGeben(name).PreisGeben();
            System.out.println(anzahl + " " + name + " Einzelpreis: " + preis
                    + " Gesamtpreis: " + preis * anzahl);
            summe = summe + preis * anzahl;
        }
        System.out.println("--------------------");
        System.out.println("Gesamt: " + summe);
        tische.get(tischNr).BestelltePostenLöschen();
    }

    /**
     * Anzeigen der Speisekarte
     */
    void SpeisekarteAnzeigen()
    {
        karte.Anzeigen();
    }
}
