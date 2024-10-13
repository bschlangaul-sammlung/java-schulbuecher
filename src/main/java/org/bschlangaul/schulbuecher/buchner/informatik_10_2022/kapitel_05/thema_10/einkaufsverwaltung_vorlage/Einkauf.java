package org.bschlangaul.schulbuecher.buchner.informatik_10_2022.kapitel_05.thema_10.einkaufsverwaltung_vorlage;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Projekt 5-10_Einkaufsverwaltung (ÜuV Aufgabe 24)
 *
 * @author Julia Kronawitter
 *
 * @version 2022-09-12
 */
public class Einkauf
{
    private Artikel[] artikelfeld;

    private LocalDate datum;

    private String geschaeft;

    public Einkauf()
    {
        this.datum = LocalDate.now();
        this.geschaeft = "Vero Moda";
        artikelfeld = new Artikel[6];
        artikelfeld[0] = new Artikel("Jeans", "Kleidung", 89.9);
        artikelfeld[1] = new Artikel("Guertel", "Accessoire", 19.45);
        artikelfeld[2] = new Artikel("Bluse", "Kleidung", 24.99);
        artikelfeld[3] = new Artikel("Badehose", "Kleidung", 49.95);
        artikelfeld[4] = new Artikel("Socken", "Kleidung", 9.95);
        artikelfeld[5] = new Artikel("Hut", "Accessoire", 29.95);
    }

    public Einkauf(Artikel[] einkaufsliste, LocalDate datum, String geschaeft)
    {
        this.artikelfeld = einkaufsliste;
        this.datum = datum;
        this.geschaeft = geschaeft;
    }

    public String nenneGeschaeft()
    {
        return this.geschaeft;
    }

    public LocalDate nenneDatum()
    {
        return this.datum;
    }

    public Einkauf(int laengeEinkaufsliste, LocalDate datum, String geschaeft)
    {
        this.artikelfeld = new Artikel[laengeEinkaufsliste];
        this.datum = datum;
        this.geschaeft = geschaeft;
    }

    public void printArtikelfeld()
    {
        // 24c
    }

    public Artikel[] nenneArtikel()
    {
        return this.artikelfeld;
    }

    public boolean einkaufen(Artikel artikel)
    {
        // 24d
        return false;
    }

    public double berechnePreis()
    {
        // 24f
        return -1.0;
    }

    public double einkaufAuswerten(String kategorie)
    {
        // 24g
        return -1.0;
    }

    public void sortiereEinkaufsliste()
    {
        // 24h
    }

    public ArrayList<String> nenneKategorien()
    {
        int i = 0;
        ArrayList<String> kategorien = new ArrayList<String>();
        while (i < artikelfeld.length)
        {
            if (!kategorien.contains(artikelfeld[i].nenneKategorie()))
            {
                kategorien.add(artikelfeld[i].nenneKategorie());
            }
            i = i + 1;
        }
        return kategorien;
    }
}
